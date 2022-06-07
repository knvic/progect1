package ru.javabegin.springboot.business.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.javabegin.springboot.auth.entity.User;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class Priority {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private String color;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    //@OneToMany(mappedBy = "priorityByPriorityId")
   // private Collection<Task> tasksById;
}
