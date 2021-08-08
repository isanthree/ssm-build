package org.example.controller;

import org.example.pojo.Books;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * controller 层调用 service 层
 */
@Controller
@RequestMapping("/book")
public class BookController {
	// controller 层调用 service 层
	@Autowired
	@Qualifier("BookServiceImpl")
	private BookService bookService;

	// 查询全部的书籍，并且返回到一个书籍展示页面
	@RequestMapping("/allBook")
	public String list(Model model) {
		List<Books> list = bookService.queryAllBook();
		model.addAttribute("list", list);
		return "allBook";
	}

	// 跳转到增加书籍页面
	@RequestMapping("/toAddBook")
	public String toAddBook() {
		return "addBook";
	}

	// 添加书籍的请求
	@RequestMapping("/addBook")
	public String addBook(Books books) {
		System.out.println("BookController::addBook() ==> " + books);
		bookService.addBook(books);
		return "redirect:/book/allBook";  // 重定向到 @RequestMapping("/allBook") 请求
	}

	// 跳转到更新书籍页面
	@RequestMapping("/toUpdateBook")
	public String toUpdateBook(int id, Model model) {
		Books book = bookService.queryBookById(id);
		model.addAttribute("QBook", book);
		System.out.println("BookController::updateBook() ==> 更新 " + id + " 号书籍前：" + book);
		return "updateBook";  // 重定向到 @RequestMapping("/allBook") 请求
	}

	// 更新书籍的请求
	@RequestMapping("/updateBook")
	public String updateBook(Books books) {
		int i = bookService.updateBook(books);
		if (i > 0) {
			System.out.println("添加成功！");
		}
		System.out.println("BookController::updateBook() ==> 更新后：" + books);
		return "redirect:/book/allBook";  // 重定向到 @RequestMapping("/allBook") 请求
	}

	// 删除书籍的请求
	@RequestMapping("/deleteBook/{bookId}")
	public String deleteBook(@PathVariable("bookId") int id) {
		int i = bookService.deleteBookById(id);

		System.out.println("BookController::updateBook() ==> 删除 " + id + " 号书籍");
		return "redirect:/book/allBook";  // 重定向到 @RequestMapping("/allBook") 请求
	}

	// 查询书籍
	@RequestMapping("/queryBook")
	public String queryBook(String queryBookName, Model model) {
		Books books = bookService.queryBookByName(queryBookName);



		System.err.println("BookController::queryBook() ==> " + books);
		List<Books> list = new ArrayList<Books>();
		list.add(books);

		if (books == null) {
			list = bookService.queryAllBook();
			model.addAttribute("error", "未查到相关书籍");
		}

		model.addAttribute("list", list);
		return "allBook";
	}
}
