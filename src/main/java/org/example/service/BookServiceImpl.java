package org.example.service;

import org.example.dao.BookMapper;
import org.example.pojo.Books;

import java.util.List;

/**
 * service 层（业务层）
 * service 层调用 dao 层
 */
public class BookServiceImpl implements BookService{
	// service 层调用 dao 层，组合 Dao
	private BookMapper bookMapper;

	public void setBookMapper(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	public int addBook(Books book) {
		return bookMapper.addBook(book);
	}

	public int deleteBookById(int id) {
		return bookMapper.deleteBookById(id);
	}

	public int updateBook(Books books) {
		System.out.println("BookServiceImpl::updateBook() ==>" + books);
		return bookMapper.updateBook(books);
	}

	public Books queryBookById(int id) {
		return bookMapper.queryBookById(id);
	}

	public List<Books> queryAllBook() {
		return bookMapper.queryAllBook();
	}

	public Books queryBookByName(String bookName) {
		return bookMapper.queryBookByName(bookName);
	}
}
