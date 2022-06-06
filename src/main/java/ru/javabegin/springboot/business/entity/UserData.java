package ru.javabegin.springboot.business.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_data", schema = "tasklist", catalog = "postgres")
public class UserData {
    private Long id;
    private String email;
    private String password;
    private String username;
    private Collection<Activity> activitiesById;
    private Collection<Category> categoriesById;
    private Collection<Priority> prioritiesById;
    private Collection<Stat> statsById;
    private Collection<Task> tasksById;
    private UserRole userRoleById;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "username", nullable = false, length = -1)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (id != null ? !id.equals(userData.id) : userData.id != null) return false;
        if (email != null ? !email.equals(userData.email) : userData.email != null) return false;
        if (password != null ? !password.equals(userData.password) : userData.password != null) return false;
        if (username != null ? !username.equals(userData.username) : userData.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userDataByUserId")
    public Collection<Activity> getActivitiesById() {
        return activitiesById;
    }

    public void setActivitiesById(Collection<Activity> activitiesById) {
        this.activitiesById = activitiesById;
    }

    @OneToMany(mappedBy = "userDataByUserId")
    public Collection<Category> getCategoriesById() {
        return categoriesById;
    }

    public void setCategoriesById(Collection<Category> categoriesById) {
        this.categoriesById = categoriesById;
    }

    @OneToMany(mappedBy = "userDataByUserId")
    public Collection<Priority> getPrioritiesById() {
        return prioritiesById;
    }

    public void setPrioritiesById(Collection<Priority> prioritiesById) {
        this.prioritiesById = prioritiesById;
    }

    @OneToMany(mappedBy = "userDataByUserId")
    public Collection<Stat> getStatsById() {
        return statsById;
    }

    public void setStatsById(Collection<Stat> statsById) {
        this.statsById = statsById;
    }

    @OneToMany(mappedBy = "userDataByUserId")
    public Collection<Task> getTasksById() {
        return tasksById;
    }

    public void setTasksById(Collection<Task> tasksById) {
        this.tasksById = tasksById;
    }

    @OneToOne(mappedBy = "userDataByUserId")
    public UserRole getUserRoleById() {
        return userRoleById;
    }

    public void setUserRoleById(UserRole userRoleById) {
        this.userRoleById = userRoleById;
    }
}
