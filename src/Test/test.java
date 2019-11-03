import com.maple.MapleMall.dao.IAdminDao;
import com.maple.MapleMall.dao.IOrderDao;
import com.maple.MapleMall.dao.IUserDao;
import com.maple.MapleMall.entity.Admin;
import com.maple.MapleMall.entity.User;
import com.maple.MapleMall.service.IAdminService;
import com.maple.MapleMall.service.IOrderService;
import com.maple.MapleMall.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class test {
    @Autowired
    private IUserDao userDao;

    @Autowired
    private IAdminDao adminDao;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IAdminService adminService;

    @Test
    public void test(){
        User user = new User();
        user.setUserNum("test");
        user.setUserName("test");
        user.setUserPassword("test");
//        userDao.addUser(user);
        user.setUserPassword("1");
        userDao.updateUser(user);
//        userDao.deleteUser("test");
        System.out.println(userDao.findUserByUsername("鲁阳"));
        System.out.println(userDao.findUserByUserNum("U10003"));
    }

    @Test
    public void tes2t(){
        Admin admin = new Admin();
        admin.setAdminNum("test");
        admin.setAdminName("test");
        admin.setAdminPassword("test");
        adminDao.addAdmin(admin);
        admin.setAdminPassword("1");
        adminDao.updateAdmin(admin);
        adminDao.deleteAdmin("test");
        System.out.println(adminDao.findAdminByName("张三"));
        System.out.println(adminDao.findAdminByNum("10001"));
    }

    @Test
    public void rte(){
//        System.out.println(userDao.getMaxId());
//        System.out.println(orderDao.findAllOrders());
        System.out.println(orderService.findOrderByOrderNum("191014-100001"));
//        System.out.println(orderDao.findOrderByGoodsName("火腿肠"));
    }

    @Test
    public void a1(){
        System.out.println(adminDao.getDBAdmin("luyang"));
        Admin admin = new Admin();
        admin.setAdminName("luyang");
        admin.setAdminPassword("123456");
        System.out.println(adminService.adminLogin(admin));
    }
}
