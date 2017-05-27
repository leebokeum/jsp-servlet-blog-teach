package model.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


public class DBConnectionORM {

	private SqlMapClient sqlMap;

	public SqlMapClient connect() {
		String resource = "util/SqlMapConfig.xml";
		Reader reader = null;
		SqlMapClient sqlMap = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sqlMap;
	}

	public <T> T queryForList(String queryId){
		sqlMap = connect();
		T result = null;
		try {
			result = (T) sqlMap.queryForList(queryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public <T, E> T queryForList(String queryId, E parameter){
		sqlMap = connect();
		T result = null;
		try {
			result = (T) sqlMap.queryForList(queryId, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public <T> void update(String queryId, T parameter) {
		sqlMap = connect();
		try {
			sqlMap.update(queryId, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(String queryId) {
		sqlMap = connect();
		try {
			sqlMap.update(queryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public <T> void insert(String queryId, T parameter) {
		sqlMap = connect();
		try {
			sqlMap.insert(queryId, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(String queryId) {
		sqlMap = connect();
		try {
			sqlMap.insert(queryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public <T, E> T queryForObject(String queryId, E parameter) {
		sqlMap = connect();
		T result = null;
		try {
			result = (T) sqlMap.queryForObject(queryId, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public <T> T queryForObject(String queryId) {
		sqlMap = connect();
		T result = null;
		try {
			result = (T) sqlMap.queryForObject(queryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
