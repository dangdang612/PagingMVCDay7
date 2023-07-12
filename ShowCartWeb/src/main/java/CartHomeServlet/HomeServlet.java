package CartHomeServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Cart.Entity.Book;
import Cart.Entity.Category;
import CartDAO.BookDAO;
import CartDAO.CategoryDAO;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDAO categoryDAO = new CategoryDAO();
	BookDAO bookDAO = new BookDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Category> categories = categoryDAO.getCategories(true);
			List<Book> books =bookDAO.getAllBook();
			
			request.setAttribute("categories", categories);
			
			String command = request.getParameter("command");
			if(command!=null && command.equals("DETAIL")) {
				int bookId = Integer.parseInt(request.getParameter("bookId"));
				Book book = bookDAO.getBook(bookId);
				request.setAttribute("book", book);
			} else {
				
				request.setAttribute("books", books);
			}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		request.setAttribute("categoryList", categories);
		request.setAttribute("bookList", books);
		dispatcher.forward(request,response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
