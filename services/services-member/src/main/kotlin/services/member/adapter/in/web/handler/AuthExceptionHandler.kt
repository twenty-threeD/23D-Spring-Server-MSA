package services.member.adapter.`in`.web.handler

import core.common.data.BaseResponse
import core.common.exception.ApplicationException
import core.common.handler.GlobalExceptionHandler
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class AuthExceptionHandler: GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException::class)
    override fun exceptionHandler(
        applicationException: ApplicationException
    ): ResponseEntity<BaseResponse<Unit>> {

        return BaseResponse.error(
            applicationException = applicationException
        ).toResponseEntity()
    }
}