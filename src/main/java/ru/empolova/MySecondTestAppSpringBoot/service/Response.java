package ru.empolova.MySecondTestAppSpringBoot.service;

import lombok.Builder;
import lombok.Data;
import ru.empolova.MySecondTestAppSpringBoot.model.Codes;
import ru.empolova.MySecondTestAppSpringBoot.model.ErrorCodes;
import ru.empolova.MySecondTestAppSpringBoot.model.ErrorMessages;

@Data
@Builder
public class Response {

    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private ErrorCodes errorCode;
    private ErrorMessages errorMessage;
}
