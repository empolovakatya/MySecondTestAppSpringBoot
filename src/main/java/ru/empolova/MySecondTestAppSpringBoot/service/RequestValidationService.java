package ru.empolova.MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.empolova.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.empolova.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.empolova.MySecondTestAppSpringBoot.model.Request;

import java.util.stream.Collectors;

@Slf4j
@Service
public class RequestValidationService implements ValidationService {

    private static final String UNSUPPORTED_UID = "123";

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                log.error("bindingResult error: field '{}', value '{}', message: {}",
                        error.getField(), error.getRejectedValue(), error.getDefaultMessage());
            }
            String message = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.joining("; "));
            log.error("throw ValidationFailedException: {}", message);
            throw new ValidationFailedException(message);
        }
        log.info("request validation passed");
    }

    @Override
    public void checkUid(Request request) throws UnsupportedCodeException {
        if (UNSUPPORTED_UID.equals(request.getUid())) {
            log.error("throw UnsupportedCodeException: uid {} is not supported", request.getUid());
            throw new UnsupportedCodeException("uid " + UNSUPPORTED_UID + " не поддерживается");
        }
        log.info("uid check passed");
    }
}
