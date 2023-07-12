package CartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Cart.DButil.CartDButil;
import Cart.Entity.Category;


public class CategoryDAO {
	public List<Category> getCategories(boolean isShow) throws SQLException{
		List<Category> categories = new ArrayList<Category>();
		
		Connection conn=null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = CartDButil.makeConnection();
			
			String sql ="SELECT * FROM `category` where `show` =?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setBoolean(1, isShow);
			rs= pstm.executeQuery();		
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				boolean show = rs.getBoolean("show");
				
				Category category = new Category(id, name, show);
				categories.add(category);
			}
		} finally {
			close(conn, pstm,rs);
		} return categories;
	}

	private void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			if (rs!=null) {
				rs.close();
			}
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

