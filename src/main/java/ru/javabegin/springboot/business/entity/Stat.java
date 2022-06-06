package ru.javabegin.springboot.business.entity;

import javax.persistence.*;

@Entity
public class Stat {
    private Long id;
    private Long completedTotal;
    private Long uncompletedTotal;
    private Long userId;
    private UserData userDataByUserId;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "completed_total", nullable = false)
    public Long getCompletedTotal() {
        return completedTotal;
    }

    public void setCompletedTotal(Long completedTotal) {
        this.completedTotal = completedTotal;
    }

    @Basic
    @Column(name = "uncompleted_total", nullable = false)
    public Long getUncompletedTotal() {
        return uncompletedTotal;
    }

    public void setUncompletedTotal(Long uncompletedTotal) {
        this.uncompletedTotal = uncompletedTotal;
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

        Stat stat = (Stat) o;

        if (id != null ? !id.equals(stat.id) : stat.id != null) return false;
        if (completedTotal != null ? !completedTotal.equals(stat.completedTotal) : stat.completedTotal != null)
            return false;
        if (uncompletedTotal != null ? !uncompletedTotal.equals(stat.uncompletedTotal) : stat.uncompletedTotal != null)
            return false;
        if (userId != null ? !userId.equals(stat.userId) : stat.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (completedTotal != null ? completedTotal.hashCode() : 0);
        result = 31 * result + (uncompletedTotal != null ? uncompletedTotal.hashCode() : 0);
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
}
