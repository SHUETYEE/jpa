package cn.itcast.dao;

import cn.itcast.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author 李靖宇
 * @Project jpa
 * @date 2019/10/31 17:51
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {


}
