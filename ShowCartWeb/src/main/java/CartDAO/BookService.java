package CartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Cart.DButil.CartDButil;
import Cart.Entity.Book;
import Cart.Entity.Category;

public class BookService {
	public List<Book> getBooksByCategoryId(int categoryId) throws SQLException{
		//connect to DB
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		
		try {
			//make connection to mysql
			conn= CartDButil.makeConnection();
			
			ps = conn.prepareStatement("Select * from `book` where category_id=?");
			ps.setInt(1, categoryId);
			
			//execute and get result SET
			rs= ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name= rs.getString("name");
				
				book=new Book(id,name,categoryId);
				list.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		return list;
	}
	public List<Book> getAllBooks() throws SQLException{
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs= null;
		List<Book> list = new ArrayList<Book>();
		Book book = null;
		try {
			//make connection to mysql
			conn= CartDButil.makeConnection();
			
			ps = conn.prepareStatement("Select * from `book`");
			
			//execute and get result SET
			rs= ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name= rs.getString("name");
				int categoryId = rs.getInt("category_id");
				
				book=new Book(id,name,categoryId);
				list.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		return list;
	}
	public List<Book> getBooksByName(String bookName) throws SQLException{
		//connect to DB
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		Book book = null;
		List<Book> list = new ArrayList<Book>();
				
		try {
			//make connection to mysql
			conn= CartDButil.makeConnection();
			
			ps = conn.prepareStatement("Select * from `book` where `name` like?");
			ps.setString(1, "%" +bookName+"%");
			
			//execute and get result SET
			rs= ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");
				String author = rs.getString("author");
				String title = rs.getString("title");
				int stock = rs.getInt("stock");
				
				book=new Book(id,name,categoryId, author,title, stock);
				list.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		return list;
}
	public Book getBooksDetail(int bookId) throws SQLException{
		//connect to DB
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		Book book = null;
		
		try {
			//make connection to mysql
			conn= CartDButil.makeConnection();
			
			ps = conn.prepareStatement("Select * from `book` where `id`=");
			ps.setInt(1, bookId);
			
			//execute and get result SET
			rs= ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");
				String author = rs.getString("author");
				String title = rs.getString("title");
				int stock = rs.getInt("stock");
				
				book=new Book(id,name,categoryId, author,title, stock);
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		return book;
}
	public List<Book> getAll() throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		Book book = new Book();
		List<Book> list = new ArrayList<Book>();
				
		try {
			//make connection to mysql
			conn= CartDButil.makeConnection();
			
			ps = conn.prepareStatement("Select b.id, b.name,c.name,b.title, b.stock,b.author from `book` b inner join `category`c on b.category_id=c.id");
		
			
			//execute and get result SET
			rs= ps.executeQuery();
			
			while(rs.next()) {
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				
				Category c= new Category(rs.getInt("id"),rs.getString("name"));
				book.setCate(c);
			
				list.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		return list;
}
	public List<Book> getListByPage(List<Book> bookList1, int start, int end){
		ArrayList<Book> arr = new ArrayList<>();
		for(int i=start; i<end; i++) {
			arr.add(bookList1.get(i));
		}
	return arr;
	}
}

