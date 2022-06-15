package ru.javabegin.springboot.auth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "USER_DATA")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @Column
    public Activity activity;

    @Email
    @Column
    private String email;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles=new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

/* @OneToMany(mappedBy = "userDataByUserId")
    private Collection<Activity> activitiesById;

    @OneToMany(mappedBy = "userDataByUserId")
    private Collection<Category> categoriesById;

    @OneToMany(mappedBy = "userDataByUserId")
    private Collection<Priority> prioritiesById;

    @OneToMany(mappedBy = "userDataByUserId")
    private Collection<Stat> statsById;

    @OneToMany(mappedBy = "userDataByUserId")
    private Collection<Task> tasksById;

    //@OneToOne(mappedBy = "userDataByUserId")
    //private UserRole userRoleById;*/
}
