package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{

	private Connection dbConnection;

	public DepartmentDaoJDBC(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public DepartmentDaoJDBC() {
		
	}
	
	@Override
	public void insert(Department department) {
		PreparedStatement st = null;
		try {
			dbConnection = DB.getDbConnection();

			st = dbConnection.prepareStatement(
					"INSERT INTO department " 
				    + "(Name) VALUES(?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, department.getName());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1); // 1st column
					department.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unexpected error");
			}

			System.out.println("Done! Rows Affected: " + rowsAffected);

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}	
	}

	@Override
	public void update(Department department) {
		PreparedStatement st = null;
		try {
			dbConnection.setAutoCommit(false);
			st = dbConnection.prepareStatement(
					"UPDATE department SET Name=? WHERE Id=?", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, department.getName());
			st.setInt(2, department.getId());
			
			//error simulation
			//int x =1;
			//if(x<2) {
			//	throw new SQLException("Fake error");
			//}
			
			int rowsAffected = st.executeUpdate();
			dbConnection.commit();

			System.out.println("Done! Rows Affected: " + rowsAffected);

		} catch (SQLException e) {
			try {
				dbConnection.rollback();
			} catch (SQLException e1) {
				throw new DbException(e1.getMessage());
			}
			
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}	
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = dbConnection.prepareStatement("SELECT * FROM department WHERE Id = ?");

			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {
				return instantiateDepartment(rs);
			} else {
				return null;
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			st = dbConnection.prepareStatement("SELECT * FROM department ORDER BY Name");
			rs = st.executeQuery();

			List<Department> departmentsList = new ArrayList<>();

			// rs may return 0 or more results
			while (rs.next()) {
				Department dep = instantiateDepartment(rs);
				departmentsList.add(dep);
			}

			return departmentsList;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Integer departmentId = rs.getInt("Id");
		String departmentName = rs.getString("Name");
		return new Department(departmentId, departmentName);
	}
}
