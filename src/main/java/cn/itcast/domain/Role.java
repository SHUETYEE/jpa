package cn.itcast.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 李靖宇
 * @Project jpa
 * @date 2019/11/1 13:45
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@Entity
@Table(name = "sys_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;

    //配置多对多
    @ManyToMany(mappedBy = "roles")  //配置多表关系
    private Set<User> users = new HashSet<User>();

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}