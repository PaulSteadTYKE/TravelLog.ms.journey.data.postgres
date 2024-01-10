package uk.co.tyke.travellog.journey.db;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import uk.co.tyke.travellog.journey.data.JourneyData;
import uk.co.tyke.travellog.journey.data.postgres.jooq.tables.records.JourneyRecord;
import uk.co.tyke.travellog.journey.model.Journey;

import javax.inject.Singleton;

import static uk.co.tyke.travellog.journey.data.postgres.jooq.tables.Journey.JOURNEY;

@Singleton
public class JourneyPostgresImpl implements JourneyData {

    private DSLContext context;

    JourneyPostgresImpl(Configuration config) {
        this.context = config.dsl();
    }

    @Override
    public long saveJourney(Journey journey) {

//        List<Trip> routes = journey.routes();
//        Route route = routes.get(0);
//        List<RoutePoint> routePoints = route.routePoints();
//        RoutePoint routePoint = routePoints.get(0);

        // Need to insert this last as it needs the tripId
        // so start by inserting the Journey

        assert context != null;
        JourneyRecord journeyRecord = context.newRecord(JOURNEY);
        journeyRecord.setName(journey.name());
        journeyRecord.setNotes(journey.notes());
        journeyRecord.store();

//        Result<TRIP_POINT> result = dsl.insertInto(TRIP_POINT)
//                    .set(TRIP_POINT.LATITUDE, routePoint.latitude())
//                    .set(TRIP_POINT.LONGITUDE, routePoint.longitude())
//                    .set(TRIP_POINT.ALTITUDE, routePoint.altitude())
//                    .returning(TRIP_POINT.TRIP_POINT_ID)
//                    .fetch();

        return journeyRecord.getJourneyId();

    }
}
