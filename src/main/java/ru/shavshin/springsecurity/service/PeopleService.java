package ru.shavshin.springsecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shavshin.springsecurity.dal.entity.PersonEntity;
import ru.shavshin.springsecurity.dal.repository.PeopleRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public Optional<PersonEntity> findByUsername(String username) {
        return peopleRepository.findByUsername(username);
    }
}
