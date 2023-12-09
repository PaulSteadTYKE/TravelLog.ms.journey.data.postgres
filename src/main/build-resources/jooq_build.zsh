#!/bin/zsh

java -classpath /Users/paul/.m2/repository/org/jooq/jooq/3.18.7/jooq-3.18.7.jar:\
/Users/paul/.m2/repository/org/jooq/jooq-meta/3.18.7/jooq-meta-3.18.7.jar:\
/Users/paul/.m2/repository/org/jooq/jooq-codegen/3.18.7/jooq-codegen-3.18.7.jar:\
/Users/paul/.m2/repository/org/reactivestreams/reactive-streams/1.0.4/reactive-streams-1.0.4.jar:\
/Users/paul/.m2/repository/io/r2dbc/r2dbc-spi/1.0.0.RELEASE/r2dbc-spi-1.0.0.RELEASE.jar:\
/Users/paul/.m2/repository/jakarta/xml/bind/jakarta.xml.bind-api/3.0.0/jakarta.xml.bind-api-3.0.0.jar:\
/Users/paul/.m2/repository/org/postgresql/postgresql/42.7.1/postgresql-42.7.1.jar:. \
org.jooq.codegen.GenerationTool jooq_config.xml