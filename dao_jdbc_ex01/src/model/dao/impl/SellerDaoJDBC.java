package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	private Connection dbConnection;

	public SellerDaoJDBC(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public void insert(Seller seller) {
		PreparedStatement st = null;
		try {
			dbConnection = DB.getDbConnection();

			st = dbConnection.prepareStatement(
					"INSERT INTO seller " 
				    + "(Name,Email,BirthDate,BaseSalary,DepartmentId) " 
					+ "VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, seller.getName());
			st.setString(2, seller.getEmail());

			long longDate = fmt.parse(seller.getBirthDate().toString()).getTime();

			st.setDate(3, new java.sql.Date(longDate));
			st.setDouble(4, seller.getBaseSalary());
			st.setInt(5, seller.getDepartment().getId());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1); // 1st column
					seller.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unexpected error");
			}

			System.out.println("Done! Rows Affected: " + rowsAffected);

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Seller seller) {
		PreparedStatement st = null;
		try {
			dbConnection = DB.getDbConnection();
			dbConnection.setAutoCommit(false);
			st = dbConnection.prepareStatement(
					"UPDATE seller "
					+ "SET Name=?,Email=?,BirthDate=?,BaseSalary=?,DepartmentId=? "
					+ "WHERE Id=?", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, seller.getName());
			st.setString(2, seller.getEmail());

			long longDate = fmt.parse(seller.getBirthDate().toString()).getTime();

			st.setDate(3, new java.sql.Date(longDate));
			st.setDouble(4, seller.getBaseSalary());
			st.setInt(5, seller.getDepartment().getId());
			st.setInt(6, seller.getId());
			
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
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			dbConnection = DB.getDbConnection();

			st = dbConnection.prepareStatement(
					"DELETE FROM seller WHERE Id = ?");
			
			st.setInt(1, id);
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = dbConnection.prepareStatement(
						"SELECT seller.*,department.Name as DepartmentName " 
						+ "FROM seller INNER JOIN department "
						+ "ON seller.DepartmentId = department.Id " 
						+ "WHERE seller.Id = ?");

			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {
				Department department = instantiateDepartment(rs);
				return instantiateSeller(rs, department);
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

	private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
		Integer sellerId = rs.getInt("Id");
		String sellerName = rs.getString("Name");
		String sellerEmail = rs.getString("Email");
		LocalDate sellerBirthDate = rs.getDate("BirthDate").toLocalDate();
		Double sellerBaseSalary = rs.getDouble("BaseSalary");

		return new Seller(sellerId, sellerName, sellerEmail, sellerBirthDate, sellerBaseSalary, department);
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Integer departmentId = rs.getInt("DepartmentId");
		String departmentName = rs.getString("DepartmentName");
		return new Department(departmentId, departmentName);
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			st = dbConnection.prepareStatement(
					"SELECT seller.*,department.Name as DepartmentName " 
					+ "FROM seller "
					+ "INNER JOIN department " 
					+ "ON seller.DepartmentId = department.Id " 
					+ "ORDER BY Name");

			rs = st.executeQuery();

			List<Seller> departmentsList = new ArrayList<>();
			Map<Integer, Department> departmentsMap = new HashMap<>();

			// rs may return 0 or more results
			while (rs.next()) {

				// Use of Map to avoid incorrectly instantiating Departments.
				// Do not create a Department instance for each row of the ResultSet
				Department dep = departmentsMap.get(rs.getInt("DepartmentId"));
				if (dep == null) {
					dep = instantiateDepartment(rs);
					departmentsMap.put(rs.getInt("DepartmentId"), dep);
				}

				departmentsList.add(instantiateSeller(rs, dep));
			}

			return departmentsList;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = dbConnection.prepareStatement(
							"SELECT seller.*,department.Name as DepartmentName " 
							+ "FROM seller " + "INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " 
							+ "WHERE DepartmentId = ? " 
							+ "ORDER BY Name");

			st.setInt(1, department.getId());

			rs = st.executeQuery();

			List<Seller> departmentsList = new ArrayList<>();
			Map<Integer, Department> departmentsMap = new HashMap<>();

			while (rs.next()) {
				Department dep = departmentsMap.get(rs.getInt("DepartmentId"));
				if (dep == null) {
					dep = instantiateDepartment(rs);
					departmentsMap.put(rs.getInt("DepartmentId"), dep);
				}

				departmentsList.add(instantiateSeller(rs, dep));
			}

			return departmentsList;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
}
