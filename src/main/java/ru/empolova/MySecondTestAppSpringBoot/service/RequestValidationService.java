package ru.empolova.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.empolova.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.empolova.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.empolova.MySecondTestAppSpringBoot.model.Request;

import java.util.stream.Collectors;

@Service
public class RequestValidationService implements ValidationService {

    private static final String UNSUPPORTED_UID = "123";

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            // собираем все ошибки, чтобы при нескольких нарушениях было видно каждое
            String message = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.joining("; "));
            throw new ValidationFailedException(message);
        }
    }

    @Override
    public void checkUid(Request request) throws UnsupportedCodeException {
        if (UNSUPPORTED_UID.equals(request.getUid())) {
            throw new UnsupportedCodeException("uid " + UNSUPPORTED_UID + " не поддерживается");
        }
    }
}
