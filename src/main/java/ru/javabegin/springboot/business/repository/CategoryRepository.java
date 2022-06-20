package ru.javabegin.springboot.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javabegin.springboot.business.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category,Long> {
}
