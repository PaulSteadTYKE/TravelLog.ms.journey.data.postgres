DROP SCHEMA IF EXISTS travellog_journey_dev_schema CASCADE;

CREATE SCHEMA travellog_journey_dev_schema AUTHORIZATION tyke_developer;

SET search_path TO travellog_journey_dev_schema;

CREATE TABLE "journey" ( -- a journey consists of one or more trips
	"journey_id" BIGSERIAL primary key,
	"name" varchar(100),
	"notes" varchar(1024),
	"created" timestamp DEFAULT (now())
);

CREATE TABLE "trip" (
	"trip_id" BIGSERIAL primary key,
	"journey_id" bigint,
	"created" timestamp DEFAULT (now())
)

CREATE TABLE "trip_point" (
  "trip_point_id" BIGSERIAL primary key,
  "trip_id" bigint,
  "latitude" numeric(7,4),
  "longitude" numeric(7,4),
  "altitude" int,
  "created" timestamp   -- take from device, not DB entry
);


ALTER TABLE "trip_point" ADD FOREIGN KEY ("trip_id") REFERENCES "trip" ("trip_id");
ALTER TABLE "trip" ADD FOREIGN KEY ("journey_id") REFERENCES "journey" ("journey_id");

alter table trip_point OWNER TO tyke_developer;
alter table trip OWNER TO tyke_developer;
alter table journey OWNER TO tyke_developer;

GRANT USAGE ON SCHEMA travellog_journey_dev_schema TO tyke_developer;

GRANT SELECT ON ALL TABLES IN SCHEMA travellog_journey_dev_schema TO tyke_developer;
GRANT SELECT ON ALL SEQUENCES IN SCHEMA travellog_journey_dev_schema TO tyke_developer;
GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA travellog_journey_dev_schema TO tyke_developer;

commit;