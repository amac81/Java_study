package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import db.DB;
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
		Seller seller = null;
		ResultSet rs = null;
		try {

			st = dbConnection.prepareStatement(
					"SELECT seller.*,department.Name as DepartmentName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");

			st.setInt(1, id);

			rs = st.executeQuery();
			
			if (rs.next()) {
				Integer sellerId = rs.getInt("Id");
				String sellerName = rs.getString("Name");
				String sellerEmail = rs.getString("Email");
				LocalDate sellerBirthDate = rs.getDate("BirthDate").toLocalDate();
				Double sellerBaseSalary = rs.getDouble("BaseSalary");
				Integer departmentId = rs.getInt("DepartmentId");
				String departmentName = rs.getString("DepartmentName");

				Department department = new Department(departmentId, departmentName);
				seller = new Seller (sellerId, sellerName, sellerEmail, sellerBirthDate,
				sellerBaseSalary, department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

		return seller;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
