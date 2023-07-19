package model.dao;

import java.sql.Connection;

import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	public static SellerDao createSellerDao(Connection dbConnection ) {
		return new SellerDaoJDBC(dbConnection);
	}
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC();
	}
}
