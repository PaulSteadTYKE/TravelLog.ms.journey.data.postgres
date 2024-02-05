package uk.co.tyke.travellog.journey.data.postgres;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import uk.co.tyke.travellog.journey.data.JourneyData;
import uk.co.tyke.travellog.journey.data.postgres.jooq.tables.records.JourneyRecord;
import uk.co.tyke.travellog.journey.data.postgres.jooq.tables.records.LegRecord;
import uk.co.tyke.travellog.journey.data.postgres.jooq.tables.records.LocationRecord;
import uk.co.tyke.travellog.journey.model.Journey;
import uk.co.tyke.travellog.journey.model.Leg;
import uk.co.tyke.travellog.journey.model.Location;

import javax.inject.Singleton;

import java.util.List;

import static uk.co.tyke.travellog.journey.data.postgres.jooq.tables.Journey.JOURNEY;
import static uk.co.tyke.travellog.journey.data.postgres.jooq.tables.Leg.LEG;
import static uk.co.tyke.travellog.journey.data.postgres.jooq.tables.Location.LOCATION;

@Singleton
public class JourneyPostgresImpl implements JourneyData {

    private final DSLContext context;

    JourneyPostgresImpl(Configuration config) {
        this.context = config.dsl();
    }

    @Override
    public long saveJourney(Journey journey) {

        assert context != null;
        JourneyRecord journeyRecord = context.newRecord(JOURNEY);
        journeyRecord.setName(journey.name());
        journeyRecord.setNotes(journey.notes());
        journeyRecord.store();
        long journeyId = journeyRecord.getJourneyId();

        List<Leg> legs = journey.legs();
        for (Leg leg: legs) {
            LegRecord legRecord = context.newRecord(LEG);
            legRecord.setJourneyId(journeyId);
            legRecord.store();
            long legId = legRecord.getLegId();
            for (Location location: leg.locations()) {
                LocationRecord locationRecord = context.newRecord(LOCATION);
                locationRecord.setLegId(legId);
                locationRecord.setLatitude(location.latitude());
                locationRecord.setLongitude(location.longitude());
                locationRecord.setAltitude(location.altitude());
                locationRecord.setCreated(location.time());
                locationRecord.store();
            }
        }

        return journeyId;

    }
}
