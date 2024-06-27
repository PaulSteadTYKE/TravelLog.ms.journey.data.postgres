package uk.co.tyke.travellog.journey.data.postgres;

import org.jooq.*;
import org.jooq.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.tyke.travellog.journey.data.JourneyData;
import uk.co.tyke.travellog.journey.data.postgres.jooq.tables.records.JourneyRecord;
import uk.co.tyke.travellog.journey.data.postgres.jooq.tables.records.LegRecord;
import uk.co.tyke.travellog.journey.data.postgres.jooq.tables.records.LocationRecord;
import uk.co.tyke.travellog.journey.model.Journey;
import uk.co.tyke.travellog.journey.model.Leg;
import uk.co.tyke.travellog.journey.model.Location;

import javax.inject.Singleton;

import java.util.List;
import java.util.Objects;

// import static org.jooq.Records.mapping;
import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.selectFrom;
import static uk.co.tyke.travellog.journey.data.postgres.jooq.tables.Journey.JOURNEY;
import static uk.co.tyke.travellog.journey.data.postgres.jooq.tables.Leg.LEG;
import static uk.co.tyke.travellog.journey.data.postgres.jooq.tables.Location.LOCATION;

@Singleton
public class JourneyPostgresImpl implements JourneyData {

    private Logger logger = LoggerFactory.getLogger(JourneyPostgresImpl.class);

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
        for (Leg leg : legs) {
            LegRecord legRecord = context.newRecord(LEG);
            legRecord.setJourneyId(journeyId);
            legRecord.setDistance(leg.distance());
            legRecord.store();
            long legId = legRecord.getLegId();
            for (Location location : leg.locations()) {
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

    @Override
    public List<Journey> getJourneys() {
        logger.debug("Get Journeys");
        assert context != null;

        List<Location> result = context.select(
                        LOCATION.LATITUDE,
                        LOCATION.LONGITUDE,
                        LOCATION.ALTITUDE,
                        LOCATION.CREATED)
                .from(LOCATION)
                .orderBy(LOCATION.LOCATION_ID)
                .fetch(mapping(Location::new));


        logger.info("Number of locations returned: {}", result.size());

        // String name, String notes, List<Leg> legs
//        List<Journey> result = context.select(
//                JOURNEY.NAME,
//                JOURNEY.NOTES,
//                multiset(selectFrom(LEG).where(LEG.JOURNEY_ID.eq(JOURNEY.JOURNEY_ID))).as("legs"))
//                .from(JOURNEY)
//                .orderBy(JOURNEY.JOURNEY_ID)
//                .fetchInto(Journey.class);

//        Result<Record> journeys = context.select()
//                .from(JOURNEY).fetch();
//
//        journeys.forEach(journey -> {
//            journey.getValue(JOURNEY.JOURNEY_ID)
//        });


        return null;

    }
}
