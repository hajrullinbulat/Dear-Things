import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dz.labs.model.Users;
import ru.dz.labs.services.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Gataullin Kamil
 *         12.10.2014 0:03
 */
public class TestHibernate {
    public static AddressesService addressesService;
    public static CartsService cartsService;
    public static CategoriesService categoriesService;
    public static GoodsService goodsService;
    public static OrdersService ordersService;
    public static UsersService usersService;


    public static void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"tutor-core.xml"}, true);
        addressesService = (AddressesService) context.getBean("addressesService");
        cartsService = (CartsService) context.getBean("cartsService");
        categoriesService = (CategoriesService) context.getBean("categoriesService");
        goodsService = (GoodsService) context.getBean("goodsService");
        ordersService = (OrdersService) context.getBean("ordersService");
        usersService = (UsersService) context.getBean("usersService");
    }

    public static void main(String[] args) throws SQLException {
        init();
        testSubject();
    }

    public static void testSubject() {
        List<Users> users = usersService.getAllUsers();
        System.out.println("======== All subjects =========");
        for (Users user : users) {
            System.out.println("id : " + user.getId() + ", name : " + user.getName());
        }
        System.out.println("=============================");
    }

}
