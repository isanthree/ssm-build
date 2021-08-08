package org.example.service;

import org.example.pojo.Books;

import java.util.List;

public interface BookService {
	// 增加 Book
	int addBook(Books book);

	// 根据 id 删除 Book
	int deleteBookById(int id);

	// 更新Book
	int updateBook(Books books);

	// 根据 id 查询，返回 Book
	Books queryBookById(int id);

	// 查询全部 Book，返回 list 集合
	List<Books> queryAllBook();
}
