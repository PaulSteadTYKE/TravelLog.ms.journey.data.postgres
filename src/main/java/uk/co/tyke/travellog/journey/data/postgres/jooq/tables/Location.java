/*
 * This file is generated by jOOQ.
 */
package uk.co.tyke.travellog.journey.data.postgres.jooq.tables;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import uk.co.tyke.travellog.journey.data.postgres.jooq.Keys;
import uk.co.tyke.travellog.journey.data.postgres.jooq.TravellogJourneyDevSchema;
import uk.co.tyke.travellog.journey.data.postgres.jooq.tables.records.LocationRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Location extends TableImpl<LocationRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of
     * <code>travellog_journey_dev_schema.location</code>
     */
    public static final Location LOCATION = new Location();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LocationRecord> getRecordType() {
        return LocationRecord.class;
    }

    /**
     * The column
     * <code>travellog_journey_dev_schema.location.location_id</code>.
     */
    public final TableField<LocationRecord, Long> LOCATION_ID = createField(DSL.name("location_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>travellog_journey_dev_schema.location.leg_id</code>.
     */
    public final TableField<LocationRecord, Long> LEG_ID = createField(DSL.name("leg_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>travellog_journey_dev_schema.location.latitude</code>.
     */
    public final TableField<LocationRecord, BigDecimal> LATITUDE = createField(DSL.name("latitude"), SQLDataType.NUMERIC(7, 4), this, "");

    /**
     * The column <code>travellog_journey_dev_schema.location.longitude</code>.
     */
    public final TableField<LocationRecord, BigDecimal> LONGITUDE = createField(DSL.name("longitude"), SQLDataType.NUMERIC(7, 4), this, "");

    /**
     * The column <code>travellog_journey_dev_schema.location.altitude</code>.
     */
    public final TableField<LocationRecord, Integer> ALTITUDE = createField(DSL.name("altitude"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>travellog_journey_dev_schema.location.created</code>.
     */
    public final TableField<LocationRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6), this, "");

    private Location(Name alias, Table<LocationRecord> aliased) {
        this(alias, aliased, null);
    }

    private Location(Name alias, Table<LocationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>travellog_journey_dev_schema.location</code>
     * table reference
     */
    public Location(String alias) {
        this(DSL.name(alias), LOCATION);
    }

    /**
     * Create an aliased <code>travellog_journey_dev_schema.location</code>
     * table reference
     */
    public Location(Name alias) {
        this(alias, LOCATION);
    }

    /**
     * Create a <code>travellog_journey_dev_schema.location</code> table
     * reference
     */
    public Location() {
        this(DSL.name("location"), null);
    }

    public <O extends Record> Location(Table<O> child, ForeignKey<O, LocationRecord> key) {
        super(child, key, LOCATION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : TravellogJourneyDevSchema.TRAVELLOG_JOURNEY_DEV_SCHEMA;
    }

    @Override
    public Identity<LocationRecord, Long> getIdentity() {
        return (Identity<LocationRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<LocationRecord> getPrimaryKey() {
        return Keys.LOCATION_PKEY;
    }

    @Override
    public List<ForeignKey<LocationRecord, ?>> getReferences() {
        return Arrays.asList(Keys.LOCATION__LOCATION_LEG_ID_FKEY);
    }

    private transient Leg _leg;

    /**
     * Get the implicit join path to the
     * <code>travellog_journey_dev_schema.leg</code> table.
     */
    public Leg leg() {
        if (_leg == null)
            _leg = new Leg(this, Keys.LOCATION__LOCATION_LEG_ID_FKEY);

        return _leg;
    }

    @Override
    public Location as(String alias) {
        return new Location(DSL.name(alias), this);
    }

    @Override
    public Location as(Name alias) {
        return new Location(alias, this);
    }

    @Override
    public Location as(Table<?> alias) {
        return new Location(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Location rename(String name) {
        return new Location(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Location rename(Name name) {
        return new Location(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Location rename(Table<?> name) {
        return new Location(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, BigDecimal, BigDecimal, Integer, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super Long, ? super Long, ? super BigDecimal, ? super BigDecimal, ? super Integer, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super Long, ? super Long, ? super BigDecimal, ? super BigDecimal, ? super Integer, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}