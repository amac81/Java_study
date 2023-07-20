package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	private static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	private Connection dbConnection;

	public SellerDaoJDBC(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public void insert(Seller seller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller seller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = dbConnection.prepareStatement(
					"SELECT seller.*,department.Name as DepartmentName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = dbConnection.prepareStatement(
							"SELECT seller.*,department.Name as DepartmentName " 
							+ "FROM seller " 
							+ "INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " 
							+ "WHERE DepartmentId = ? " 
							+ "ORDER BY Name");

			st.setInt(1, department.getId());

			rs = st.executeQuery();

			List<Seller> departmentsList = new ArrayList<>();
			Map <Integer, Department> departmentsMap = new HashMap<>();
			
			//rs may return 0 or more results
			while (rs.next()) {
				
				//use of Map to avoid incorrectly instantiating Departments.
				Department dep = departmentsMap.get(rs.getInt("DepartmentId"));
				if(dep == null) {
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
