import org.example.pojo.Books;
import org.example.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bookServiceImpl =(BookService) context.getBean("BookServiceImpl");
		for (Books books : bookServiceImpl.queryAllBook()) {
			System.out.println(books);
		}
	}
}
