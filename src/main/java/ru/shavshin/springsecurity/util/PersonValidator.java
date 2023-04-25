package ru.shavshin.springsecurity.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.shavshin.springsecurity.dal.entity.PersonEntity;
import ru.shavshin.springsecurity.service.PeopleService;


@Component
@RequiredArgsConstructor
public class PersonValidator implements Validator {

    private final PeopleService peopleService;


    @Override
    public boolean supports(Class<?> clazz) {
        return PersonEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonEntity person = (PersonEntity) target;

        if (peopleService.findByUsername(person.getUsername()).isPresent())
            errors.rejectValue("username",  "Такое имя пользователя уже существует!");
    }
}
