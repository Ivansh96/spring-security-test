package ru.shavshin.springsecurity.dal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shavshin.springsecurity.dal.entity.PersonEntity;


import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<PersonEntity, Integer> {
    Optional<PersonEntity> findByUsername(String username);
}
