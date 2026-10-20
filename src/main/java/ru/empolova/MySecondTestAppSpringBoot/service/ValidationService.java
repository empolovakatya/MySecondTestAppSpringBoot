package ru.empolova.MySecondTestAppSpringBoot.service;

import org.springframework.validation.BindingResult;
import ru.empolova.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.empolova.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.empolova.MySecondTestAppSpringBoot.model.Request;

public interface ValidationService {

    void isValid(BindingResult bindingResult) throws ValidationFailedException;

    void checkUid(Request request) throws UnsupportedCodeException;
}
