package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 李靖宇
 * @Project jpa
 * @date 2019/10/31 17:56
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void test1(){
        final Customer customer = customerDao.findOne(2l);
        System.out.println(customer);
    }

    @Test
    public void test2(){
        final Customer customer1 = new Customer();
        customer1.setCustName("ddddddddd");
        customerDao.save(customer1);
    }

    @Test
    public void test3(){
       customerDao.delete(3l);
    }

    @Test
    public void test4(){
        final List<Customer> all = customerDao.findAll();
        System.out.println(all);
    }
}
