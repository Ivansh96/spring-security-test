package ru.shavshin.springsecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.shavshin.springsecurity.dal.entity.PersonEntity;
import ru.shavshin.springsecurity.dal.repository.PeopleRepository;
import ru.shavshin.springsecurity.security.PersonDetails;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonDetailsService implements UserDetailsService {
    private  final PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<PersonEntity> person = peopleRepository.findByUsername(username);

       if (person.isEmpty()) {
            new UsernameNotFoundException("User not found!");
       }
       return new PersonDetails(person.get());
    }
}
