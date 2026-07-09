package core.security.exception

import core.common.exception.ExceptionCode
import org.springframework.http.HttpStatus

enum class SecurityExceptionCode(
    override val message: String,
    override val httpStatus: HttpStatus
): ExceptionCode {

    INVALID_AUTHENTICATION("잘못된 인증 정보 입니다.", HttpStatus.UNAUTHORIZED)
}