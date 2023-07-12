package Cart.Entity;

public class Book {
	public int id;
	public Book(int id, String name, int category_id, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.category_id = category_id;
		this.stock = stock;
	}
	public String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int category_id;
	public String author;
	public String title; 
	public int stock;
}
