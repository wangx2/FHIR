package com.ibm.fhir.schema.app.processor.action;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

import com.ibm.fhir.database.utils.api.IDatabaseAdapter;
import com.ibm.fhir.database.utils.api.IDatabaseStatement;
import com.ibm.fhir.database.utils.api.IDatabaseSupplier;
import com.ibm.fhir.database.utils.api.IDatabaseTranslator;
import com.ibm.fhir.database.utils.api.TenantStatus;
import com.ibm.fhir.database.utils.model.ColumnBase;
import com.ibm.fhir.database.utils.model.IdentityDef;
import com.ibm.fhir.database.utils.model.PrimaryKeyDef;
import com.ibm.fhir.database.utils.model.Privilege;
import com.ibm.fhir.database.utils.model.Table;
import com.ibm.fhir.database.utils.model.Tenant;

public class DatabaseSupport {

    /**
     * generate undefined name exception.
     * 
     * @return
     */
    public static SQLException generateUndefinedName() {
        String reason = "Dummy";
        String sqlState = "42704";
        int vendorCode = 10;
        Throwable cause = new SQLWarning();
        SQLException sqlException = new SQLException(reason, sqlState, vendorCode, cause);
        return sqlException;
    }

    public static IDatabaseAdapter generateTenantAdapter() {
        return new IDatabaseAdapter() {
            @Override
            public IDatabaseTranslator getTranslator() {
                return null;
            }

            @Override
            public void createTablespace(String tablespaceName) {

            }

            @Override
            public void createTablespace(String tablespaceName, int extentSizeKB) {

            }

            @Override
            public void dropTablespace(String tablespaceName) {

            }

            @Override
            public void detachPartition(String schemaName, String tableName, String partitionName,
                    String newTableName) {

            }

            @Override
            public void createTable(String schemaName, String name, String tenantColumnName, List<ColumnBase> columns,
                    PrimaryKeyDef primaryKey, IdentityDef identity, String tablespaceName) {

            }

            @Override
            public void createRowType(String schemaName, String typeName, List<ColumnBase> columns) {

            }

            @Override
            public void createArrType(String schemaName, String typeName, String valueType, int arraySize) {

            }

            @Override
            public void dropType(String schemaName, String typeName) {

            }

            @Override
            public void createProcedure(String schemaName, String procedureName, Supplier<String> supplier) {

            }

            @Override
            public void dropProcedure(String schemaName, String procedureName) {

            }

            @Override
            public void createUniqueIndex(String schemaName, String tableName, String indexName,
                    String tenantColumnName, List<String> indexColumns, List<String> includeColumns) {

            }

            @Override
            public void createUniqueIndex(String schemaName, String tableName, String indexName,
                    String tenantColumnName, List<String> indexColumns) {

            }

            @Override
            public void createIndex(String schemaName, String tableName, String indexName, String tenantColumnName,
                    List<String> indexColumns) {

            }

            @Override
            public void createIntVariable(String schemaName, String variableName) {

            }

            @Override
            public void createPermission(String schemaName, String permissionName, String tableName, String predicate) {

            }

            @Override
            public void activateRowAccessControl(String schemaName, String tableName) {

            }

            @Override
            public void deactivateRowAccessControl(String schemaName, String tableName) {

            }

            @Override
            public void setIntVariable(String schemaName, String variableName, int value) {

            }

            @Override
            public void dropTable(String schemaName, String name) {

            }

            @Override
            public void dropPermission(String schemaName, String permissionName) {

            }

            @Override
            public void dropVariable(String schemaName, String variableName) {

            }

            @Override
            public void createForeignKeyConstraint(String constraintName, String schemaName, String name,
                    String targetSchema, String targetTable, String tenantColumnName, List<String> columns) {

            }

            @Override
            public int allocateTenant(String adminSchemaName, String schemaName, String tenantName, String tenantKey,
                    String tenantSalt, String idSequenceName) {
                return 0;
            }

            @Override
            public int findTenantId(String adminSchemaName, String tenantName) {
                return 0;
            }

            @Override
            public void createTenantPartitions(Collection<Table> tables, String schemaName, int newTenantId,
                    int extentSizeKB) {

            }

            @Override
            public void removeTenantPartitions(Collection<Table> tables, String schemaName, int tenantId,
                    String tenantStagingTable) {

            }

            @Override
            public void updateTenantStatus(String adminSchemaName, int tenantId, TenantStatus status) {

            }

            @Override
            public void createSequence(String schemaName, String sequenceName, int cache) {

            }

            @Override
            public void dropSequence(String schemaName, String sequenceName) {

            }

            @Override
            public void grantObjectPrivileges(String schemaName, String tableName, Collection<Privilege> privileges,
                    String toUser) {
            }

            @Override
            public void grantProcedurePrivileges(String schemaName, String procedureName,
                    Collection<Privilege> privileges, String toUser) {
            }

            @Override
            public void grantVariablePrivileges(String schemaName, String variableName,
                    Collection<Privilege> privileges, String toUser) {
            }

            @Override
            public void grantSequencePrivileges(String schemaName, String objectName, Collection<Privilege> group,
                    String toUser) {
            }

            @SuppressWarnings("unchecked")
            @Override
            public <T> T runStatement(IDatabaseSupplier<T> supplier) {
                return (T) new Tenant();
            }

            @Override
            public void runStatement(IDatabaseStatement statement) {

            }

            @Override
            public boolean doesTableExist(String schemaName, String objectName) {
                return false;
            }

            @Override
            public void createFhirSchemas(String schemaName, String adminSchemaName) {

            }

        };
    }

    /**
     * generate connection
     * 
     * @param good
     * @param exception
     * @return
     */
    public static Connection generateConnection(boolean good, SQLException exception) {
        return new Connection() {
            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                return false;
            }

            @Override
            public Statement createStatement() throws SQLException {
                return null;
            }

            @Override
            public PreparedStatement prepareStatement(String sql) throws SQLException {
                return newPreparedStatement(good, exception);
            }

            @Override
            public CallableStatement prepareCall(String sql) throws SQLException {
                if (!good) {
                    throw exception;
                }
                return new CallableStatement() {
                    @Override
                    public ResultSet executeQuery() throws SQLException {
                        return null;
                    }

                    @Override
                    public int executeUpdate() throws SQLException {
                        return 0;
                    }

                    @Override
                    public void setNull(int parameterIndex, int sqlType) throws SQLException {

                    }

                    @Override
                    public void setBoolean(int parameterIndex, boolean x) throws SQLException {

                    }

                    @Override
                    public void setByte(int parameterIndex, byte x) throws SQLException {

                    }

                    @Override
                    public void setShort(int parameterIndex, short x) throws SQLException {

                    }

                    @Override
                    public void setInt(int parameterIndex, int x) throws SQLException {

                    }

                    @Override
                    public void setLong(int parameterIndex, long x) throws SQLException {

                    }

                    @Override
                    public void setFloat(int parameterIndex, float x) throws SQLException {

                    }

                    @Override
                    public void setDouble(int parameterIndex, double x) throws SQLException {

                    }

                    @Override
                    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {

                    }

                    @Override
                    public void setString(int parameterIndex, String x) throws SQLException {

                    }

                    @Override
                    public void setBytes(int parameterIndex, byte[] x) throws SQLException {

                    }

                    @Override
                    public void setDate(int parameterIndex, Date x) throws SQLException {

                    }

                    @Override
                    public void setTime(int parameterIndex, Time x) throws SQLException {

                    }

                    @Override
                    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {

                    }

                    @Override
                    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {

                    }

                    @Override
                    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {

                    }

                    @Override
                    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {

                    }

                    @Override
                    public void clearParameters() throws SQLException {

                    }

                    @Override
                    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {

                    }

                    @Override
                    public void setObject(int parameterIndex, Object x) throws SQLException {

                    }

                    @Override
                    public boolean execute() throws SQLException {

                        return false;
                    }

                    @Override
                    public void addBatch() throws SQLException {

                    }

                    @Override
                    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {

                    }

                    @Override
                    public void setRef(int parameterIndex, Ref x) throws SQLException {

                    }

                    @Override
                    public void setBlob(int parameterIndex, Blob x) throws SQLException {

                    }

                    @Override
                    public void setClob(int parameterIndex, Clob x) throws SQLException {

                    }

                    @Override
                    public void setArray(int parameterIndex, Array x) throws SQLException {

                    }

                    @Override
                    public ResultSetMetaData getMetaData() throws SQLException {

                        return null;
                    }

                    @Override
                    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {

                    }

                    @Override
                    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {

                    }

                    @Override
                    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {

                    }

                    @Override
                    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {

                    }

                    @Override
                    public void setURL(int parameterIndex, URL x) throws SQLException {

                    }

                    @Override
                    public ParameterMetaData getParameterMetaData() throws SQLException {

                        return null;
                    }

                    @Override
                    public void setRowId(int parameterIndex, RowId x) throws SQLException {

                    }

                    @Override
                    public void setNString(int parameterIndex, String value) throws SQLException {

                    }

                    @Override
                    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {

                    }

                    @Override
                    public void setNClob(int parameterIndex, NClob value) throws SQLException {

                    }

                    @Override
                    public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {

                    }

                    @Override
                    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {

                    }

                    @Override
                    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {

                    }

                    @Override
                    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {

                    }

                    @Override
                    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength)
                            throws SQLException {

                    }

                    @Override
                    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {

                    }

                    @Override
                    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {

                    }

                    @Override
                    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {

                    }

                    @Override
                    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {

                    }

                    @Override
                    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {

                    }

                    @Override
                    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {

                    }

                    @Override
                    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {

                    }

                    @Override
                    public void setClob(int parameterIndex, Reader reader) throws SQLException {

                    }

                    @Override
                    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {

                    }

                    @Override
                    public void setNClob(int parameterIndex, Reader reader) throws SQLException {

                    }

                    @Override
                    public ResultSet executeQuery(String sql) throws SQLException {

                        return null;
                    }

                    @Override
                    public int executeUpdate(String sql) throws SQLException {

                        return 0;
                    }

                    @Override
                    public void close() throws SQLException {

                    }

                    @Override
                    public int getMaxFieldSize() throws SQLException {

                        return 0;
                    }

                    @Override
                    public void setMaxFieldSize(int max) throws SQLException {

                    }

                    @Override
                    public int getMaxRows() throws SQLException {

                        return 0;
                    }

                    @Override
                    public void setMaxRows(int max) throws SQLException {

                    }

                    @Override
                    public void setEscapeProcessing(boolean enable) throws SQLException {

                    }

                    @Override
                    public int getQueryTimeout() throws SQLException {

                        return 0;
                    }

                    @Override
                    public void setQueryTimeout(int seconds) throws SQLException {

                    }

                    @Override
                    public void cancel() throws SQLException {

                    }

                    @Override
                    public SQLWarning getWarnings() throws SQLException {

                        return null;
                    }

                    @Override
                    public void clearWarnings() throws SQLException {

                    }

                    @Override
                    public void setCursorName(String name) throws SQLException {

                    }

                    @Override
                    public boolean execute(String sql) throws SQLException {

                        return false;
                    }

                    @Override
                    public ResultSet getResultSet() throws SQLException {

                        return null;
                    }

                    @Override
                    public int getUpdateCount() throws SQLException {

                        return 0;
                    }

                    @Override
                    public boolean getMoreResults() throws SQLException {

                        return false;
                    }

                    @Override
                    public void setFetchDirection(int direction) throws SQLException {

                    }

                    @Override
                    public int getFetchDirection() throws SQLException {

                        return 0;
                    }

                    @Override
                    public void setFetchSize(int rows) throws SQLException {

                    }

                    @Override
                    public int getFetchSize() throws SQLException {

                        return 0;
                    }

                    @Override
                    public int getResultSetConcurrency() throws SQLException {

                        return 0;
                    }

                    @Override
                    public int getResultSetType() throws SQLException {

                        return 0;
                    }

                    @Override
                    public void addBatch(String sql) throws SQLException {

                    }

                    @Override
                    public void clearBatch() throws SQLException {

                    }

                    @Override
                    public int[] executeBatch() throws SQLException {

                        return null;
                    }

                    @Override
                    public Connection getConnection() throws SQLException {

                        return null;
                    }

                    @Override
                    public boolean getMoreResults(int current) throws SQLException {

                        return false;
                    }

                    @Override
                    public ResultSet getGeneratedKeys() throws SQLException {

                        return null;
                    }

                    @Override
                    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {

                        return 0;
                    }

                    @Override
                    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {

                        return 0;
                    }

                    @Override
                    public int executeUpdate(String sql, String[] columnNames) throws SQLException {

                        return 0;
                    }

                    @Override
                    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {

                        return false;
                    }

                    @Override
                    public boolean execute(String sql, int[] columnIndexes) throws SQLException {

                        return false;
                    }

                    @Override
                    public boolean execute(String sql, String[] columnNames) throws SQLException {

                        return false;
                    }

                    @Override
                    public int getResultSetHoldability() throws SQLException {

                        return 0;
                    }

                    @Override
                    public boolean isClosed() throws SQLException {

                        return false;
                    }

                    @Override
                    public void setPoolable(boolean poolable) throws SQLException {

                    }

                    @Override
                    public boolean isPoolable() throws SQLException {

                        return false;
                    }

                    @Override
                    public void closeOnCompletion() throws SQLException {

                    }

                    @Override
                    public boolean isCloseOnCompletion() throws SQLException {

                        return false;
                    }

                    @Override
                    public <T> T unwrap(Class<T> iface) throws SQLException {

                        return null;
                    }

                    @Override
                    public boolean isWrapperFor(Class<?> iface) throws SQLException {

                        return false;
                    }

                    @Override
                    public void registerOutParameter(int parameterIndex, int sqlType) throws SQLException {

                    }

                    @Override
                    public void registerOutParameter(int parameterIndex, int sqlType, int scale) throws SQLException {

                    }

                    @Override
                    public boolean wasNull() throws SQLException {

                        return false;
                    }

                    @Override
                    public String getString(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public boolean getBoolean(int parameterIndex) throws SQLException {

                        return false;
                    }

                    @Override
                    public byte getByte(int parameterIndex) throws SQLException {

                        return 0;
                    }

                    @Override
                    public short getShort(int parameterIndex) throws SQLException {

                        return 0;
                    }

                    @Override
                    public int getInt(int parameterIndex) throws SQLException {

                        return 10;
                    }

                    @Override
                    public long getLong(int parameterIndex) throws SQLException {

                        return 0;
                    }

                    @Override
                    public float getFloat(int parameterIndex) throws SQLException {

                        return 0;
                    }

                    @Override
                    public double getDouble(int parameterIndex) throws SQLException {

                        return 0;
                    }

                    @Override
                    public BigDecimal getBigDecimal(int parameterIndex, int scale) throws SQLException {

                        return null;
                    }

                    @Override
                    public byte[] getBytes(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public Date getDate(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public Time getTime(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public Timestamp getTimestamp(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public Object getObject(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public BigDecimal getBigDecimal(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public Object getObject(int parameterIndex, Map<String, Class<?>> map) throws SQLException {

                        return null;
                    }

                    @Override
                    public Ref getRef(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public Blob getBlob(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public Clob getClob(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public Array getArray(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public Date getDate(int parameterIndex, Calendar cal) throws SQLException {

                        return null;
                    }

                    @Override
                    public Time getTime(int parameterIndex, Calendar cal) throws SQLException {

                        return null;
                    }

                    @Override
                    public Timestamp getTimestamp(int parameterIndex, Calendar cal) throws SQLException {

                        return null;
                    }

                    @Override
                    public void registerOutParameter(int parameterIndex, int sqlType, String typeName)
                            throws SQLException {

                    }

                    @Override
                    public void registerOutParameter(String parameterName, int sqlType) throws SQLException {

                    }

                    @Override
                    public void registerOutParameter(String parameterName, int sqlType, int scale) throws SQLException {

                    }

                    @Override
                    public void registerOutParameter(String parameterName, int sqlType, String typeName)
                            throws SQLException {

                    }

                    @Override
                    public URL getURL(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public void setURL(String parameterName, URL val) throws SQLException {

                    }

                    @Override
                    public void setNull(String parameterName, int sqlType) throws SQLException {

                    }

                    @Override
                    public void setBoolean(String parameterName, boolean x) throws SQLException {

                    }

                    @Override
                    public void setByte(String parameterName, byte x) throws SQLException {

                    }

                    @Override
                    public void setShort(String parameterName, short x) throws SQLException {

                    }

                    @Override
                    public void setInt(String parameterName, int x) throws SQLException {

                    }

                    @Override
                    public void setLong(String parameterName, long x) throws SQLException {

                    }

                    @Override
                    public void setFloat(String parameterName, float x) throws SQLException {

                    }

                    @Override
                    public void setDouble(String parameterName, double x) throws SQLException {

                    }

                    @Override
                    public void setBigDecimal(String parameterName, BigDecimal x) throws SQLException {

                    }

                    @Override
                    public void setString(String parameterName, String x) throws SQLException {

                    }

                    @Override
                    public void setBytes(String parameterName, byte[] x) throws SQLException {

                    }

                    @Override
                    public void setDate(String parameterName, Date x) throws SQLException {

                    }

                    @Override
                    public void setTime(String parameterName, Time x) throws SQLException {

                    }

                    @Override
                    public void setTimestamp(String parameterName, Timestamp x) throws SQLException {

                    }

                    @Override
                    public void setAsciiStream(String parameterName, InputStream x, int length) throws SQLException {

                    }

                    @Override
                    public void setBinaryStream(String parameterName, InputStream x, int length) throws SQLException {

                    }

                    @Override
                    public void setObject(String parameterName, Object x, int targetSqlType, int scale)
                            throws SQLException {
                        // No Operation
                    }

                    @Override
                    public void setObject(String parameterName, Object x, int targetSqlType) throws SQLException {

                    }

                    @Override
                    public void setObject(String parameterName, Object x) throws SQLException {

                    }

                    @Override
                    public void setCharacterStream(String parameterName, Reader reader, int length)
                            throws SQLException {

                    }

                    @Override
                    public void setDate(String parameterName, Date x, Calendar cal) throws SQLException {

                    }

                    @Override
                    public void setTime(String parameterName, Time x, Calendar cal) throws SQLException {

                    }

                    @Override
                    public void setTimestamp(String parameterName, Timestamp x, Calendar cal) throws SQLException {

                    }

                    @Override
                    public void setNull(String parameterName, int sqlType, String typeName) throws SQLException {

                    }

                    @Override
                    public String getString(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public boolean getBoolean(String parameterName) throws SQLException {

                        return false;
                    }

                    @Override
                    public byte getByte(String parameterName) throws SQLException {

                        return 0;
                    }

                    @Override
                    public short getShort(String parameterName) throws SQLException {

                        return 0;
                    }

                    @Override
                    public int getInt(String parameterName) throws SQLException {

                        return 0;
                    }

                    @Override
                    public long getLong(String parameterName) throws SQLException {

                        return 0;
                    }

                    @Override
                    public float getFloat(String parameterName) throws SQLException {

                        return 0;
                    }

                    @Override
                    public double getDouble(String parameterName) throws SQLException {

                        return 0;
                    }

                    @Override
                    public byte[] getBytes(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public Date getDate(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public Time getTime(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public Timestamp getTimestamp(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public Object getObject(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public BigDecimal getBigDecimal(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public Object getObject(String parameterName, Map<String, Class<?>> map) throws SQLException {

                        return null;
                    }

                    @Override
                    public Ref getRef(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public Blob getBlob(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public Clob getClob(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public Array getArray(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public Date getDate(String parameterName, Calendar cal) throws SQLException {

                        return null;
                    }

                    @Override
                    public Time getTime(String parameterName, Calendar cal) throws SQLException {

                        return null;
                    }

                    @Override
                    public Timestamp getTimestamp(String parameterName, Calendar cal) throws SQLException {

                        return null;
                    }

                    @Override
                    public URL getURL(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public RowId getRowId(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public RowId getRowId(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public void setRowId(String parameterName, RowId x) throws SQLException {

                    }

                    @Override
                    public void setNString(String parameterName, String value) throws SQLException {

                    }

                    @Override
                    public void setNCharacterStream(String parameterName, Reader value, long length)
                            throws SQLException {

                    }

                    @Override
                    public void setNClob(String parameterName, NClob value) throws SQLException {

                    }

                    @Override
                    public void setClob(String parameterName, Reader reader, long length) throws SQLException {

                    }

                    @Override
                    public void setBlob(String parameterName, InputStream inputStream, long length)
                            throws SQLException {

                    }

                    @Override
                    public void setNClob(String parameterName, Reader reader, long length) throws SQLException {

                    }

                    @Override
                    public NClob getNClob(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public NClob getNClob(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public void setSQLXML(String parameterName, SQLXML xmlObject) throws SQLException {

                    }

                    @Override
                    public SQLXML getSQLXML(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public SQLXML getSQLXML(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public String getNString(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public String getNString(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public Reader getNCharacterStream(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public Reader getNCharacterStream(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public Reader getCharacterStream(int parameterIndex) throws SQLException {

                        return null;
                    }

                    @Override
                    public Reader getCharacterStream(String parameterName) throws SQLException {

                        return null;
                    }

                    @Override
                    public void setBlob(String parameterName, Blob x) throws SQLException {

                    }

                    @Override
                    public void setClob(String parameterName, Clob x) throws SQLException {

                    }

                    @Override
                    public void setAsciiStream(String parameterName, InputStream x, long length) throws SQLException {

                    }

                    @Override
                    public void setBinaryStream(String parameterName, InputStream x, long length) throws SQLException {

                    }

                    @Override
                    public void setCharacterStream(String parameterName, Reader reader, long length)
                            throws SQLException {

                    }

                    @Override
                    public void setAsciiStream(String parameterName, InputStream x) throws SQLException {

                    }

                    @Override
                    public void setBinaryStream(String parameterName, InputStream x) throws SQLException {

                    }

                    @Override
                    public void setCharacterStream(String parameterName, Reader reader) throws SQLException {

                    }

                    @Override
                    public void setNCharacterStream(String parameterName, Reader value) throws SQLException {

                    }

                    @Override
                    public void setClob(String parameterName, Reader reader) throws SQLException {

                    }

                    @Override
                    public void setBlob(String parameterName, InputStream inputStream) throws SQLException {

                    }

                    @Override
                    public void setNClob(String parameterName, Reader reader) throws SQLException {

                    }

                    @Override
                    public <T> T getObject(int parameterIndex, Class<T> type) throws SQLException {

                        return null;
                    }

                    @Override
                    public <T> T getObject(String parameterName, Class<T> type) throws SQLException {

                        return null;
                    }

                };
            }

            @Override
            public String nativeSQL(String sql) throws SQLException {

                return null;
            }

            @Override
            public void setAutoCommit(boolean autoCommit) throws SQLException {

            }

            @Override
            public boolean getAutoCommit() throws SQLException {

                return false;
            }

            @Override
            public void commit() throws SQLException {

            }

            @Override
            public void rollback() throws SQLException {

            }

            @Override
            public void close() throws SQLException {

            }

            @Override
            public boolean isClosed() throws SQLException {

                return false;
            }

            @Override
            public DatabaseMetaData getMetaData() throws SQLException {

                return null;
            }

            @Override
            public void setReadOnly(boolean readOnly) throws SQLException {

            }

            @Override
            public boolean isReadOnly() throws SQLException {

                return false;
            }

            @Override
            public void setCatalog(String catalog) throws SQLException {

            }

            @Override
            public String getCatalog() throws SQLException {

                return null;
            }

            @Override
            public void setTransactionIsolation(int level) throws SQLException {

            }

            @Override
            public int getTransactionIsolation() throws SQLException {

                return 0;
            }

            @Override
            public SQLWarning getWarnings() throws SQLException {

                return null;
            }

            @Override
            public void clearWarnings() throws SQLException {

            }

            @Override
            public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {

                return null;
            }

            @Override
            public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
                    throws SQLException {
                return newPreparedStatement(good, exception);
            }

            @Override
            public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
                    throws SQLException {

                return null;
            }

            @Override
            public Map<String, Class<?>> getTypeMap() throws SQLException {

                return null;
            }

            @Override
            public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

            }

            @Override
            public void setHoldability(int holdability) throws SQLException {

            }

            @Override
            public int getHoldability() throws SQLException {

                return 0;
            }

            @Override
            public Savepoint setSavepoint() throws SQLException {

                return null;
            }

            @Override
            public Savepoint setSavepoint(String name) throws SQLException {

                return null;
            }

            @Override
            public void rollback(Savepoint savepoint) throws SQLException {

            }

            @Override
            public void releaseSavepoint(Savepoint savepoint) throws SQLException {

            }

            @Override
            public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
                    throws SQLException {

                return null;
            }

            @Override
            public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
                    int resultSetHoldability) throws SQLException {
                return newPreparedStatement(good, exception);
            }

            @Override
            public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
                    int resultSetHoldability) throws SQLException {

                return null;
            }

            @Override
            public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
                return newPreparedStatement(good, exception);
            }

            @Override
            public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
                return newPreparedStatement(good, exception);
            }

            @Override
            public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
                return newPreparedStatement(good, exception);
            }

            @Override
            public Clob createClob() throws SQLException {

                return null;
            }

            @Override
            public Blob createBlob() throws SQLException {

                return null;
            }

            @Override
            public NClob createNClob() throws SQLException {

                return null;
            }

            @Override
            public SQLXML createSQLXML() throws SQLException {

                return null;
            }

            @Override
            public boolean isValid(int timeout) throws SQLException {

                return false;
            }

            @Override
            public void setClientInfo(String name, String value) throws SQLClientInfoException {

            }

            @Override
            public void setClientInfo(Properties properties) throws SQLClientInfoException {

            }

            @Override
            public String getClientInfo(String name) throws SQLException {

                return null;
            }

            @Override
            public Properties getClientInfo() throws SQLException {

                return null;
            }

            @Override
            public Array createArrayOf(String typeName, Object[] elements) throws SQLException {

                return null;
            }

            @Override
            public Struct createStruct(String typeName, Object[] attributes) throws SQLException {

                return null;
            }

            @Override
            public void setSchema(String schema) throws SQLException {

            }

            @Override
            public String getSchema() throws SQLException {

                return null;
            }

            @Override
            public void abort(Executor executor) throws SQLException {

            }

            @Override
            public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

            }

            @Override
            public int getNetworkTimeout() throws SQLException {

                return 0;
            }

        };
    }

    /**
     * generate a new prepared statement.
     * 
     * @param good
     * @param exception
     * @return
     */
    public static PreparedStatement newPreparedStatement(boolean good, SQLException exception) {
        return new PreparedStatement() {
            @Override
            public ResultSet executeQuery(String sql) throws SQLException {
                if (!good) {
                    throw exception;
                }
                return null;
            }

            @Override
            public int executeUpdate(String sql) throws SQLException {

                return 0;
            }

            @Override
            public void close() throws SQLException {

            }

            @Override
            public int getMaxFieldSize() throws SQLException {

                return 0;
            }

            @Override
            public void setMaxFieldSize(int max) throws SQLException {

            }

            @Override
            public int getMaxRows() throws SQLException {

                return 0;
            }

            @Override
            public void setMaxRows(int max) throws SQLException {

            }

            @Override
            public void setEscapeProcessing(boolean enable) throws SQLException {

            }

            @Override
            public int getQueryTimeout() throws SQLException {

                return 0;
            }

            @Override
            public void setQueryTimeout(int seconds) throws SQLException {

            }

            @Override
            public void cancel() throws SQLException {

            }

            @Override
            public SQLWarning getWarnings() throws SQLException {

                return null;
            }

            @Override
            public void clearWarnings() throws SQLException {

            }

            @Override
            public void setCursorName(String name) throws SQLException {

            }

            @Override
            public boolean execute(String sql) throws SQLException {

                return false;
            }

            @Override
            public ResultSet getResultSet() throws SQLException {

                return null;
            }

            @Override
            public int getUpdateCount() throws SQLException {

                return 0;
            }

            @Override
            public boolean getMoreResults() throws SQLException {

                return false;
            }

            @Override
            public void setFetchDirection(int direction) throws SQLException {

            }

            @Override
            public int getFetchDirection() throws SQLException {

                return 0;
            }

            @Override
            public void setFetchSize(int rows) throws SQLException {

            }

            @Override
            public int getFetchSize() throws SQLException {

                return 0;
            }

            @Override
            public int getResultSetConcurrency() throws SQLException {

                return 0;
            }

            @Override
            public int getResultSetType() throws SQLException {

                return 0;
            }

            @Override
            public void addBatch(String sql) throws SQLException {

            }

            @Override
            public void clearBatch() throws SQLException {

            }

            @Override
            public int[] executeBatch() throws SQLException {

                return null;
            }

            @Override
            public Connection getConnection() throws SQLException {

                return null;
            }

            @Override
            public boolean getMoreResults(int current) throws SQLException {

                return false;
            }

            @Override
            public ResultSet getGeneratedKeys() throws SQLException {

                return null;
            }

            @Override
            public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {

                return 0;
            }

            @Override
            public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {

                return 0;
            }

            @Override
            public int executeUpdate(String sql, String[] columnNames) throws SQLException {

                return 0;
            }

            @Override
            public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {

                return false;
            }

            @Override
            public boolean execute(String sql, int[] columnIndexes) throws SQLException {

                return false;
            }

            @Override
            public boolean execute(String sql, String[] columnNames) throws SQLException {

                return false;
            }

            @Override
            public int getResultSetHoldability() throws SQLException {

                return 0;
            }

            @Override
            public boolean isClosed() throws SQLException {

                return false;
            }

            @Override
            public void setPoolable(boolean poolable) throws SQLException {

            }

            @Override
            public boolean isPoolable() throws SQLException {

                return false;
            }

            @Override
            public void closeOnCompletion() throws SQLException {

            }

            @Override
            public boolean isCloseOnCompletion() throws SQLException {

                return false;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {

                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {

                return false;
            }

            @Override
            public ResultSet executeQuery() throws SQLException {
                if (!good) {
                    throw exception;
                }
                return null;
            }

            @Override
            public int executeUpdate() throws SQLException {

                return 0;
            }

            @Override
            public void setNull(int parameterIndex, int sqlType) throws SQLException {

            }

            @Override
            public void setBoolean(int parameterIndex, boolean x) throws SQLException {

            }

            @Override
            public void setByte(int parameterIndex, byte x) throws SQLException {

            }

            @Override
            public void setShort(int parameterIndex, short x) throws SQLException {

            }

            @Override
            public void setInt(int parameterIndex, int x) throws SQLException {

            }

            @Override
            public void setLong(int parameterIndex, long x) throws SQLException {

            }

            @Override
            public void setFloat(int parameterIndex, float x) throws SQLException {

            }

            @Override
            public void setDouble(int parameterIndex, double x) throws SQLException {

            }

            @Override
            public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {

            }

            @Override
            public void setString(int parameterIndex, String x) throws SQLException {

            }

            @Override
            public void setBytes(int parameterIndex, byte[] x) throws SQLException {

            }

            @Override
            public void setDate(int parameterIndex, Date x) throws SQLException {

            }

            @Override
            public void setTime(int parameterIndex, Time x) throws SQLException {

            }

            @Override
            public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {

            }

            @Override
            public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {

            }

            @Override
            public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {

            }

            @Override
            public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {

            }

            @Override
            public void clearParameters() throws SQLException {

            }

            @Override
            public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {

            }

            @Override
            public void setObject(int parameterIndex, Object x) throws SQLException {

            }

            @Override
            public boolean execute() throws SQLException {

                return false;
            }

            @Override
            public void addBatch() throws SQLException {

            }

            @Override
            public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {

            }

            @Override
            public void setRef(int parameterIndex, Ref x) throws SQLException {

            }

            @Override
            public void setBlob(int parameterIndex, Blob x) throws SQLException {

            }

            @Override
            public void setClob(int parameterIndex, Clob x) throws SQLException {

            }

            @Override
            public void setArray(int parameterIndex, Array x) throws SQLException {

            }

            @Override
            public ResultSetMetaData getMetaData() throws SQLException {

                return null;
            }

            @Override
            public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {

            }

            @Override
            public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {

            }

            @Override
            public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {

            }

            @Override
            public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {

            }

            @Override
            public void setURL(int parameterIndex, URL x) throws SQLException {

            }

            @Override
            public ParameterMetaData getParameterMetaData() throws SQLException {

                return null;
            }

            @Override
            public void setRowId(int parameterIndex, RowId x) throws SQLException {

            }

            @Override
            public void setNString(int parameterIndex, String value) throws SQLException {

            }

            @Override
            public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {

            }

            @Override
            public void setNClob(int parameterIndex, NClob value) throws SQLException {

            }

            @Override
            public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {

            }

            @Override
            public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {

            }

            @Override
            public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {

            }

            @Override
            public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {

            }

            @Override
            public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength)
                    throws SQLException {

            }

            @Override
            public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {

            }

            @Override
            public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {

            }

            @Override
            public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {

            }

            @Override
            public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {

            }

            @Override
            public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {

            }

            @Override
            public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {

            }

            @Override
            public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {

            }

            @Override
            public void setClob(int parameterIndex, Reader reader) throws SQLException {

            }

            @Override
            public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {

            }

            @Override
            public void setNClob(int parameterIndex, Reader reader) throws SQLException {

            }
        };
    }
}