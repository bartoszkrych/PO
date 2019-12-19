package com.wGory.configuration;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.type.StringType;

import java.sql.Types;

public class SQLiteDialect extends Dialect {

    private static final String INTEGER_TYPE_STRING = "integer";
    private static final String SUBSTR_FUNCTION_NAME = "substr";
    private static final String IDENTITY_SELECT_SQL = "select last_insert_rowid()";

    public SQLiteDialect() {
        registerColumnType(Types.BIT, INTEGER_TYPE_STRING);
        registerColumnType(Types.TINYINT, "tinyint");
        registerColumnType(Types.SMALLINT, "smallint");
        registerColumnType(Types.INTEGER, INTEGER_TYPE_STRING);
        registerColumnType(Types.BIGINT, "bigint");
        registerColumnType(Types.FLOAT, "float");
        registerColumnType(Types.REAL, "real");
        registerColumnType(Types.DOUBLE, "double");
        registerColumnType(Types.NUMERIC, "numeric");
        registerColumnType(Types.DECIMAL, "decimal");
        registerColumnType(Types.CHAR, "char");
        registerColumnType(Types.VARCHAR, "varchar");
        registerColumnType(Types.LONGVARCHAR, "longvarchar");
        registerColumnType(Types.DATE, "date");
        registerColumnType(Types.TIME, "time");
        registerColumnType(Types.TIMESTAMP, "timestamp");
        registerColumnType(Types.BINARY, "blob");
        registerColumnType(Types.VARBINARY, "blob");
        registerColumnType(Types.LONGVARBINARY, "blob");
        registerColumnType(Types.BLOB, "blob");
        registerColumnType(Types.CLOB, "clob");
        registerColumnType(Types.BOOLEAN, INTEGER_TYPE_STRING);

        registerFunction("concat", new VarArgsSQLFunction(StringType.INSTANCE, "", "||", ""));
        registerFunction("mod", new SQLFunctionTemplate(StringType.INSTANCE, "?1 % ?2"));
        registerFunction(
                SUBSTR_FUNCTION_NAME, new StandardSQLFunction(SUBSTR_FUNCTION_NAME, StringType.INSTANCE));
        registerFunction(
                "substring", new StandardSQLFunction(SUBSTR_FUNCTION_NAME, StringType.INSTANCE));
    }

    @SuppressWarnings("unused")
    public boolean supportsIdentityColumns() {
        return true;
    }

    @SuppressWarnings("unused")
    public boolean hasDataTypeInIdentityColumn() {
        return false; // As specify in NHibernate dialect
    }

    @SuppressWarnings("unused")
    public String getIdentityColumnString() {
        return INTEGER_TYPE_STRING;
    }

    @SuppressWarnings("unused")
    public String getIdentitySelectString() {
        return IDENTITY_SELECT_SQL;
    }

    @Override
    public boolean supportsLimit() {
        return true;
    }

    @Override
    protected String getLimitString(String query, boolean hasOffset) {
        return query + (hasOffset ? " limit ? offset ?" : " limit ?");
    }

    @SuppressWarnings("unused")
    public boolean supportsTemporaryTables() {
        return true;
    }

    @SuppressWarnings("unused")
    public String getCreateTemporaryTableString() {
        return "create temporary table if not exists";
    }

    @SuppressWarnings("unused")
    public boolean dropTemporaryTableAfterUse() {
        return false;
    }

    @Override
    public boolean supportsCurrentTimestampSelection() {
        return true;
    }

    @Override
    public boolean isCurrentTimestampSelectStringCallable() {
        return false;
    }

    @Override
    public String getCurrentTimestampSelectString() {
        return "select current_timestamp";
    }

    @Override
    public boolean supportsUnionAll() {
        return true;
    }

    @Override
    public boolean hasAlterTable() {
        return false; // As specify in NHibernate dialect
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }

    @Override
    public String getAddColumnString() {
        return "add column";
    }

    @Override
    public String getForUpdateString() {
        return "";
    }

    @Override
    public boolean supportsOuterJoinForUpdate() {
        return false;
    }

    @Override
    public String getDropForeignKeyString() {
        throw new UnsupportedOperationException(
                "No drop foreign key syntax supported by SQLiteDialect");
    }

    @Override
    public String getAddForeignKeyConstraintString(
            String constraintName,
            String[] foreignKey,
            String referencedTable,
            String[] primaryKey,
            boolean referencesPrimaryKey) {
        throw new UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect");
    }

    @Override
    public String getAddPrimaryKeyConstraintString(String constraintName) {
        throw new UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect");
    }

    @Override
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    @Override
    public boolean supportsCascadeDelete() {
        return false;
    }
}
