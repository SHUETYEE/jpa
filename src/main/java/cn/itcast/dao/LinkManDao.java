package cn.itcast.dao;

import cn.itcast.domain.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 李靖宇
 * @Project jpa
 * @date 2019/11/1 12:23
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public interface LinkManDao extends JpaRepository<LinkMan,Long>, JpaSpecificationExecutor<LinkMan> {
}
