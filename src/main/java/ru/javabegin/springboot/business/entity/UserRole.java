package ru.javabegin.springboot.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_role", schema = "tasklist", catalog = "postgres")
public class UserRole {
    private Long userId;
    private Long roleId;
    private UserData userDataByUserId;
    private RoleData roleDataByRoleId;

    @Id
    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "role_id", nullable = false)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (userId != null ? !userId.equals(userRole.userId) : userRole.userId != null) return false;
        if (roleId != null ? !roleId.equals(userRole.roleId) : userRole.roleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserData getUserDataByUserId() {
        return userDataByUserId;
    }

    public void setUserDataByUserId(UserData userDataByUserId) {
        this.userDataByUserId = userDataByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public RoleData getRoleDataByRoleId() {
        return roleDataByRoleId;
    }

    public void setRoleDataByRoleId(RoleData roleDataByRoleId) {
        this.roleDataByRoleId = roleDataByRoleId;
    }
}
