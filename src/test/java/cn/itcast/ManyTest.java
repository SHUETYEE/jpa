package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkManDao;
import cn.itcast.dao.RoleDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 李靖宇
 * @Project jpa
 * @date 2019/11/1 13:06
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyTest {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Test
    @Transactional
    @Rollback(false)
    public void test1() {
        Customer customer = new Customer();
        customer.setCustName("fff");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("fffdsdddd");
        customer.getManSet().add(linkMan);
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test2() {
        Customer customer = new Customer();
        customer.setCustName("fffsdfasdf");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("fffdsddddsdfafsda");
        linkMan.setCustomer(customer);
        customer.getManSet().add(linkMan);
        customerDao.save(customer);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test3() {
        final Customer customer = customerDao.findOne(1l);
        System.out.println(customer);
        customerDao.delete(1l);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test4() {
        final User user = new User();
        user.setUserName("dfff");
        userDao.save(user);
        final Role role = new Role();
        role.setRoleName("fdffffff");
        user.getRoles().add(role);

        roleDao.save(role);
        userDao.save(user);
    }


}
