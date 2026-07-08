package services.member.domain.exception

import core.common.exception.ExceptionCode
import org.springframework.http.HttpStatus

enum class AuthExceptionCode(
    override val message: String,
    override val httpStatus: HttpStatus
): ExceptionCode {

    UNKNOWN_REGISTRATION_ID("회원가입 경로를 확인할 수 없습니다.", HttpStatus.NOT_FOUND),
    CANNOT_VERIFY_INTEGRITY("무결성을 검증할 수 없습니다.", HttpStatus.BAD_REQUEST)
}