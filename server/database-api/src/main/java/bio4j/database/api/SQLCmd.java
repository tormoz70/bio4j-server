package bio4j.database.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import bio4j.common.types.Params;

public interface SQLCmd {
	 Statement init(Connection conn, String sql, Params prms, Long timeout);
	 void open(Long timeout);
	 void open(Connection conn, Long timeout);
	 Params getParams();
	 void refresh(Long timeout);
	 void refresh(Connection conn, Long timeout);
	 void cancel();
	 void close();
	 Boolean next();
	 Boolean isActive();
	 Connection getConnection();
	 String getPreparedSQL();
	 String getSQL();
	 ResultSet getResultSet();
	 Statement getStatement();
	 Map<String, ?> getRow();
	 Long getRowPos();
}
