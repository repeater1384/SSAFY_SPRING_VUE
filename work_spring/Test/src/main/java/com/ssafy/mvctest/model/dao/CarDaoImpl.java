package com.ssafy.mvctest.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.mvctest.dto.Car;

@Repository
public class CarDaoImpl implements CarDao {

	@Autowired
	DataSource ds;

	@Override
	public List<Car> selectAll() throws SQLException {
		String sql = "select number, model, price, brand from car";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Car> list = new ArrayList<Car>();
			while (rs.next()) {
				Car car = new Car();
				car.setNumber(rs.getString(1));
				car.setModel(rs.getString(2));
				car.setPrice(rs.getInt(3));
				car.setBrand(rs.getString(4));
				list.add(car);
			}
			return list;
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
	}

	@Override
	public int regist(Car car) throws SQLException {
		String sql = "insert into car values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getNumber());
			pstmt.setString(2, car.getModel());
			pstmt.setInt(3, car.getPrice());
			pstmt.setString(4, car.getBrand());
			int result = pstmt.executeUpdate();
			return result;
		} finally {
			pstmt.close();
			conn.close();
		}
	}

}
