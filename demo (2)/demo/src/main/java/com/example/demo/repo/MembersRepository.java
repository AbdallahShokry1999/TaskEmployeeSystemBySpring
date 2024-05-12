package com.example.demo.repo;

import com.example.demo.entities.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long> {
    void deleteByUserId(String userId); // Custom delete method based on user_id
    void findByUserId(String userId); // Custom find method based on user_id

}
