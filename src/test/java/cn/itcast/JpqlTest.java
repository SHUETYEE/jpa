package cn.itcast;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author 李靖宇
 * @Project jpa
 * @date 2019/10/31 15:55
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpqlTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void test1() {
        Customer customer = customerDao.findJpql("111");
        System.out.println(customer);
    }

    @Test
    public void test2() {
        final Customer customer = customerDao.findCustNameAndLevel("111", "dd");
        System.out.println(customer);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void test3() {
        customerDao.updateCustomer("ggggg", 2l);
    }

    @Test
    public void test4() {
        final List<Object[]> sql = customerDao.findSql();
        System.out.println(sql);
    }


    @Test
    public void test5() {
        final List<Customer> sql = customerDao.findSql2("%播%");
        System.out.println(sql);
    }

    @Test
    public void test6() {
        final Customer customer = customerDao.findByCustName("传智播客");
        System.out.println(customer);
    }

    @Test
    public void test7() {
        final List<Customer> nameLike = customerDao.findByCustNameLike("%智%");
        System.out.println(nameLike);
    }

    @Test
    public void test8() {
        final List<Customer> byCustNameLikeAndCustLevel = customerDao.findByCustNameLikeAndCustLevel("%播%", "dd");
        System.out.println(byCustNameLikeAndCustLevel);
    }

    @Test
    public void test9() {
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> path = root.get("custName");
                return criteriaBuilder.equal(path, "传智播客");
            }
        };
        final Customer customer = customerDao.findOne(spec);
        System.out.println(customer);
    }

    @Test
    public void test10() {
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
                Path<Object> custIndustry = root.get("custIndustry");
                return criteriaBuilder.and(criteriaBuilder.equal(custName, "传智播客"), criteriaBuilder.equal(custIndustry, "dd"));
            }
        };
        Customer customer = customerDao.findOne(spec);
        System.out.println(customer);
    }

    @Test
    public void test11() {
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
                final Predicate like = criteriaBuilder.like(custName.as(String.class), "%播%");
                return like;
            }
        };
        final List<Customer> all = customerDao.findAll(spec,new Sort(Sort.Direction.DESC,"custId"));
        System.out.println(all);
    }

    @Test
    public void test12() {
        Pageable pageable=new PageRequest(0,2);
        Page<Customer> page = customerDao.findAll(pageable);
        System.out.println(page.getContent());
        System.out.println(page.getTotalElements());
    }

}
