import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.demo.services.BookService;
import org.demo.services.UserService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoTests {

    UserService userService;
    BookService bookService;

    @BeforeClass
    public void beforeClass(){
        userService = new UserService();
        bookService = new BookService();
    }

    @Test
    public void createUserAndAddBooks() throws JsonProcessingException {
        Response response = userService.createUser("user412534","password@Nm12");
        String userId = userService.getUserId(response);
        Response tokenResponse = userService.generateUserToken("user4125","password@Nm12");
        String token = userService.getUserToken(tokenResponse);
        Response bookResponse = bookService.getBooks();
        String isbn = bookService.getBooksIsbn(bookResponse);
        userService.addBookToUseAccount(userId,isbn,token);
    }
}
