package cn.itcast;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author 李靖宇
 * @Project jpa
 * @date 2019/10/31 15:00
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public class Jpatest {

    @Test
    public void testSave() {
        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager jpaEntityManager = myJpa.createEntityManager();
        EntityTransaction transaction = jpaEntityManager.getTransaction();
        transaction.begin();
        Customer customer = new Customer();
        customer.setCustName("传智播客");
        customer.setCustIndustry("教育");
        jpaEntityManager.persist(customer);
        transaction.commit();
        jpaEntityManager.close();
        myJpa.close();
    }

    @Test
    public void test2() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.find(Customer.class, 1l);
        entityManager.remove(customer);
        System.out.println(customer);
        tx.commit();
    }

    @Test
    public void test3() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.find(Customer.class, 2l);
        customer.setCustIndustry("ddd");
        entityManager.merge(customer);
        System.out.println(customer);
        tx.commit();
    }
}
