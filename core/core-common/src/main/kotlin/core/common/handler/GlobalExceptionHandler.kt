package core.common.handler

import core.common.data.BaseResponse
import core.common.exception.ApplicationException
import org.springframework.http.ResponseEntity

interface GlobalExceptionHandler {

    fun exceptionHandler(applicationException: ApplicationException): ResponseEntity<BaseResponse<Unit>>
}