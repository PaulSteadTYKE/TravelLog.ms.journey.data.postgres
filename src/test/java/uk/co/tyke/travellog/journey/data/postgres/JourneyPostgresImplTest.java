package uk.co.tyke.travellog.journey.data.postgres;

import io.r2dbc.spi.ConnectionFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;
import org.jooq.*;
import org.jooq.conf.Settings;
import org.jooq.exception.DataAccessException;
import org.jooq.tools.jdbc.MockConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.tyke.travellog.journey.model.Journey;

import javax.sql.DataSource;
import java.sql.Connection;
import java.time.Clock;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.function.Supplier;

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
        Assertions.assertEquals(1, journeys.size());
    }

}
