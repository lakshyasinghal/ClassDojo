/*
 * This file is generated by jOOQ.
 */
package com.classDojo.entities.meta.tables;


import com.classDojo.entities.meta.Classdojo;
import com.classDojo.entities.meta.Keys;
import com.classDojo.entities.meta.tables.records.EnrollmentsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Enrollments extends TableImpl<EnrollmentsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>ClassDojo.Enrollments</code>
     */
    public static final Enrollments ENROLLMENTS = new Enrollments();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EnrollmentsRecord> getRecordType() {
        return EnrollmentsRecord.class;
    }

    /**
     * The column <code>ClassDojo.Enrollments.id</code>.
     */
    public final TableField<EnrollmentsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>ClassDojo.Enrollments.subject</code>.
     */
    public final TableField<EnrollmentsRecord, String> SUBJECT = createField(DSL.name("subject"), SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>ClassDojo.Enrollments.teacherId</code>.
     */
    public final TableField<EnrollmentsRecord, Integer> TEACHERID = createField(DSL.name("teacherId"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>ClassDojo.Enrollments.studentId</code>.
     */
    public final TableField<EnrollmentsRecord, Integer> STUDENTID = createField(DSL.name("studentId"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>ClassDojo.Enrollments.created</code>.
     */
    public final TableField<EnrollmentsRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    private Enrollments(Name alias, Table<EnrollmentsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Enrollments(Name alias, Table<EnrollmentsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>ClassDojo.Enrollments</code> table reference
     */
    public Enrollments(String alias) {
        this(DSL.name(alias), ENROLLMENTS);
    }

    /**
     * Create an aliased <code>ClassDojo.Enrollments</code> table reference
     */
    public Enrollments(Name alias) {
        this(alias, ENROLLMENTS);
    }

    /**
     * Create a <code>ClassDojo.Enrollments</code> table reference
     */
    public Enrollments() {
        this(DSL.name("Enrollments"), null);
    }

    public <O extends Record> Enrollments(Table<O> child, ForeignKey<O, EnrollmentsRecord> key) {
        super(child, key, ENROLLMENTS);
    }

    @Override
    public Schema getSchema() {
        return Classdojo.CLASSDOJO;
    }

    @Override
    public Identity<EnrollmentsRecord, Integer> getIdentity() {
        return (Identity<EnrollmentsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<EnrollmentsRecord> getPrimaryKey() {
        return Keys.KEY_ENROLLMENTS_PRIMARY;
    }

    @Override
    public List<UniqueKey<EnrollmentsRecord>> getKeys() {
        return Arrays.<UniqueKey<EnrollmentsRecord>>asList(Keys.KEY_ENROLLMENTS_PRIMARY);
    }

    @Override
    public Enrollments as(String alias) {
        return new Enrollments(DSL.name(alias), this);
    }

    @Override
    public Enrollments as(Name alias) {
        return new Enrollments(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Enrollments rename(String name) {
        return new Enrollments(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Enrollments rename(Name name) {
        return new Enrollments(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, Integer, Integer, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
