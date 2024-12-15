package uk.co.tyke.travellog.journey.data.postgres;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.tyke.travellog.journey.model.Journey;

import java.util.List;

public class JourneyPostgresImplTest {

    private JourneyPostgresImpl journeyPostgresImpl;

    @BeforeEach
    public void testSetUp() {
        JooqConfigurationFactory configFactory = new JooqConfigurationFactory();
        journeyPostgresImpl = new JourneyPostgresImpl(configFactory.configuration());
    }

    @Test
    public void getJourneysTest() {
        List<Journey> journeys = journeyPostgresImpl.getJourneys();
        Assertions.assertEquals(13, journeys.size());
    }

}
