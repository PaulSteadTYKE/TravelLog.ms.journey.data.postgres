package uk.co.tyke.travellog.journey.data.postgres;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import uk.co.tyke.travellog.journey.data.JourneyData;
import uk.co.tyke.travellog.journey.data.postgres.jooq.tables.records.JourneyRecord;
import uk.co.tyke.travellog.journey.data.postgres.jooq.tables.records.TripPointRecord;
import uk.co.tyke.travellog.journey.data.postgres.jooq.tables.records.TripRecord;
import uk.co.tyke.travellog.journey.model.Journey;
import uk.co.tyke.travellog.journey.model.Trip;
import uk.co.tyke.travellog.journey.model.TripPoint;

import javax.inject.Singleton;

import java.util.List;

import static uk.co.tyke.travellog.journey.data.postgres.jooq.tables.Journey.JOURNEY;
import static uk.co.tyke.travellog.journey.data.postgres.jooq.tables.Trip.TRIP;
import static uk.co.tyke.travellog.journey.data.postgres.jooq.tables.TripPoint.TRIP_POINT;

@Singleton
public class JourneyPostgresImpl implements JourneyData {

    private DSLContext context;

    JourneyPostgresImpl(Configuration config) {
        this.context = config.dsl();
    }

    @Override
    public long saveJourney(Journey journey) {


        // Need to insert this last as it needs the tripId
        // so start by inserting the Journey

        assert context != null;
        JourneyRecord journeyRecord = context.newRecord(JOURNEY);
        journeyRecord.setName(journey.name());
        journeyRecord.setNotes(journey.notes());
        journeyRecord.store();
        long journeyId = journeyRecord.getJourneyId();

        List<Trip> trips = journey.trips();
        for (Trip trip: trips) {
            TripRecord tripRecord = context.newRecord(TRIP);
            tripRecord.setJourneyId(journeyId);
            tripRecord.store();
            long tripId = tripRecord.getTripId();
            for (TripPoint tripPoint: trip.tripPoints()) {
                TripPointRecord tripPointRecord = context.newRecord(TRIP_POINT);
                tripPointRecord.setTripId(tripId);
                tripPointRecord.setLatitude(tripPointRecord.getLatitude());
                tripPointRecord.setLongitude(tripPointRecord.getLongitude());
                tripPointRecord.setAltitude(tripPointRecord.getAltitude());
            }
        }

        return journeyId;

    }
}
