package CartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import Cart.DButil.CartDButil;
import Cart.Entity.Book;


public class BookDAO {
		public static Book getBook(int id) throws Exception{
			Book book = null;
			Connection conn = null;
			PreparedStatement pstm =  null;
			ResultSet rs = null;
			
			try {
				conn=CartDButil.makeConnection();
				
				String sql= "SELECT * FROM book WHERE id =?";
				
				pstm=conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				rs= pstm.executeQuery();
				
				if (rs.next()) {
					String name = rs.getString("name");
					int category_id = rs.getInt("category_id");
					int stock =rs.getInt("stock");
					int id1 = rs.getInt("id");
					
					book = new Book(id, name, category_id, stock);
					
				}else {
					throw new Exception ("could not find book with value id: "+ id );
				} return book;
			}finally {
				close (conn,pstm, rs);
			}
		}
			public List<Book> getAllBook() throws Exception{
				List<Book> books = null;
				Connection conn = null;
				PreparedStatement pstm =  null;
				ResultSet rs = null;
				
				try {
					conn=CartDButil.makeConnection();
					
					String sql= "SELECT * FROM book";
					
					pstm=conn.prepareStatement(sql);
					
					
					rs= pstm.executeQuery();
					
					if (rs.next()) {
						String name = rs.getString("name");
						int category_id = rs.getInt("category_id");
						int stock =rs.getInt("stock");
						int id = rs.getInt("id");
						
						Book book = new Book(id, name, category_id, stock);
						books.add(book);
					}
					return books;
				}finally {
					close (conn,pstm, rs);
				}
		}

		private static void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
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
					
					
					
				
			
		

