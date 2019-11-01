package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 李靖宇
 * @Project jpa
 * @date 2019/10/31 17:51
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    @Query(value = "from Customer where custName= ?")
    public Customer findJpql(String custName);

    @Query(value = "from Customer where custName=? and custLevel=?")
    public Customer findCustNameAndLevel(String name,String level);

    @Query("update Customer set custName = ? where custId =?")
    @Modifying
    public void updateCustomer(String name,Long id);

    @Query(value = "select * from cst_customer",nativeQuery = true)
    public List<Object []> findSql();

    @Query(value = "select * from cst_customer where cust_name like ?",nativeQuery = true)
    public List<Customer> findSql2(String name);

    public Customer findByCustName(String custName);

    public List<Customer> findByCustNameLike(String custName);

    public List<Customer> findByCustNameLikeAndCustLevel(String custName,String custLevel);
}
