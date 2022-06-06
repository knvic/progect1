package ru.javabegin.springboot.business.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "role_data", schema = "tasklist", catalog = "postgres")
public class RoleData {
    private Long id;
    private String name;
    private Collection<UserRole> userRolesById;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleData roleData = (RoleData) o;

        if (id != null ? !id.equals(roleData.id) : roleData.id != null) return false;
        if (name != null ? !name.equals(roleData.name) : roleData.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleDataByRoleId")
    public Collection<UserRole> getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(Collection<UserRole> userRolesById) {
        this.userRolesById = userRolesById;
    }
}
