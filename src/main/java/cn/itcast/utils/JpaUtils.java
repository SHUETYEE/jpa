package cn.itcast.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author 李靖宇
 * @Project jpa
 * @date 2019/10/31 15:27
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public class JpaUtils {
    private static EntityManagerFactory factory;

    static{
     factory = Persistence.createEntityManagerFactory("myJpa");
    }

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
