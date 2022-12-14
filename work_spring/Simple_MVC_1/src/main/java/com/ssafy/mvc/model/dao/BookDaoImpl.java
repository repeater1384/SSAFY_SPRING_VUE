package com.ssafy.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.mvc.dto.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	DataSource ds;

	@Override
	public List<Book> selectAll() throws SQLException {
		String sql = "select isbn, title, author, price from book";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			List<Book> result = new ArrayList<Book>();
			while (rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				result.add(book);
			}
			return result;
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
	}

}
