package ru.javabegin.springboot.business.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {
    private Long id;
    private String title;
    private Long completedCount;
    private Long uncompletedCount;
    private Long userId;
    private UserData userDataByUserId;
    private Collection<Task> tasksById;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "completed_count", nullable = true)
    public Long getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(Long completedCount) {
        this.completedCount = completedCount;
    }

    @Basic
    @Column(name = "uncompleted_count", nullable = true)
    public Long getUncompletedCount() {
        return uncompletedCount;
    }

    public void setUncompletedCount(Long uncompletedCount) {
        this.uncompletedCount = uncompletedCount;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (title != null ? !title.equals(category.title) : category.title != null) return false;
        if (completedCount != null ? !completedCount.equals(category.completedCount) : category.completedCount != null)
            return false;
        if (uncompletedCount != null ? !uncompletedCount.equals(category.uncompletedCount) : category.uncompletedCount != null)
            return false;
        if (userId != null ? !userId.equals(category.userId) : category.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (completedCount != null ? completedCount.hashCode() : 0);
        result = 31 * result + (uncompletedCount != null ? uncompletedCount.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserData getUserDataByUserId() {
        return userDataByUserId;
    }

    public void setUserDataByUserId(UserData userDataByUserId) {
        this.userDataByUserId = userDataByUserId;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<Task> getTasksById() {
        return tasksById;
    }

    public void setTasksById(Collection<Task> tasksById) {
        this.tasksById = tasksById;
    }
}
