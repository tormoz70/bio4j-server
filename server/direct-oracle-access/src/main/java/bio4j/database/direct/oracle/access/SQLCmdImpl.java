package bio4j.database.direct.oracle.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import bio4j.common.types.Params;
import bio4j.database.api.SQLCmd;

public class SQLCmdImpl implements SQLCmd {

	@Override
	public Statement init(Connection conn, String sql, Params prms, Long timeout) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void open(Long timeout) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open(Connection conn, Long timeout) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Params getParams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh(Long timeout) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(Connection conn, Long timeout) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPreparedSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getResultSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement getStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, ?> getRow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getRowPos() {
		// TODO Auto-generated method stub
		return null;
	}

}
