package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Books;

import java.util.List;

public interface BookMapper {
	// 增加 Book
	int addBook(Books book);

	// 根据 id 删除 Book
	int deleteBookById(@Param("bookID") int id);

	// 更新Book
	int updateBook(Books books);

	// 根据 id 查询，返回 Book
	Books queryBookById(@Param("bookID") int id);

	// 查询全部 Book，返回 list 集合
	List<Books> queryAllBook();

	// 通过书名查询书籍
	Books queryBookByName(@Param("bookName") String bookName);
}
