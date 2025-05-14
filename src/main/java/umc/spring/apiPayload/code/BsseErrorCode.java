package umc.spring.apiPayload.code;

public interface BaseErrorCode {

    ErrorReason getReason();

    ErrorReason getReasonHttpStatus();
}