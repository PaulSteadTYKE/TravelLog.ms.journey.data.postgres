/*
 * This file is generated by jOOQ.
 */
package uk.co.tyke.travellog.journey.db.postgres.jooq.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import uk.co.tyke.travellog.journey.db.postgres.jooq.tables.Trip;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TripRecord extends UpdatableRecordImpl<TripRecord> implements Record3<Long, Long, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>travellog_journey_dev_schema.trip.trip_id</code>.
     */
    public void setTripId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>travellog_journey_dev_schema.trip.trip_id</code>.
     */
    public Long getTripId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>travellog_journey_dev_schema.trip.journey_id</code>.
     */
    public void setJourneyId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>travellog_journey_dev_schema.trip.journey_id</code>.
     */
    public Long getJourneyId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>travellog_journey_dev_schema.trip.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>travellog_journey_dev_schema.trip.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, LocalDateTime> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, LocalDateTime> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Trip.TRIP.TRIP_ID;
    }

    @Override
    public Field<Long> field2() {
        return Trip.TRIP.JOURNEY_ID;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Trip.TRIP.CREATED;
    }

    @Override
    public Long component1() {
        return getTripId();
    }

    @Override
    public Long component2() {
        return getJourneyId();
    }

    @Override
    public LocalDateTime component3() {
        return getCreated();
    }

    @Override
    public Long value1() {
        return getTripId();
    }

    @Override
    public Long value2() {
        return getJourneyId();
    }

    @Override
    public LocalDateTime value3() {
        return getCreated();
    }

    @Override
    public TripRecord value1(Long value) {
        setTripId(value);
        return this;
    }

    @Override
    public TripRecord value2(Long value) {
        setJourneyId(value);
        return this;
    }

    @Override
    public TripRecord value3(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public TripRecord values(Long value1, Long value2, LocalDateTime value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TripRecord
     */
    public TripRecord() {
        super(Trip.TRIP);
    }

    /**
     * Create a detached, initialised TripRecord
     */
    public TripRecord(Long tripId, Long journeyId, LocalDateTime created) {
        super(Trip.TRIP);

        setTripId(tripId);
        setJourneyId(journeyId);
        setCreated(created);
        resetChangedOnNotNull();
    }
}
