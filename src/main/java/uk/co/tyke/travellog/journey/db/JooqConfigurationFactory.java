package uk.co.tyke.travellog.journey.db;

import io.micronaut.context.annotation.Factory;
import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.postgresql.ds.PGSimpleDataSource;

import javax.inject.Singleton;

@Factory
public class JooqConfigurationFactory {
    private final PGSimpleDataSource dataSource;

    public JooqConfigurationFactory() {

        String[] serverNames = {"localhost:5432"};

        dataSource = new PGSimpleDataSource() ;
        dataSource.setServerNames(serverNames);
        dataSource.setDatabaseName( "TL_DEV" );
        dataSource.setUser( "postgres" );
        dataSource.setPassword( "Password123" );
    }

    @Singleton
    public Configuration configuration() {
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.setSQLDialect(SQLDialect.POSTGRES);
        configuration.set(dataSource);

        return configuration;
    }
}