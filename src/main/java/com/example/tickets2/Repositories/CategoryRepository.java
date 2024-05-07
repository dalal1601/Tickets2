package com.example.tickets2.Repositories;

import com.example.tickets2.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> { //JpaRepository est une interface fournie par Spring Data JPA qui étend l'interface CrudRepository


}
