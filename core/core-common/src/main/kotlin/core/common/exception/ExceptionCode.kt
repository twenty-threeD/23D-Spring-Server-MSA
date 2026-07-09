package core.common.exception

import org.springframework.http.HttpStatus

interface ExceptionCode {

    val message: String

    val httpStatus: HttpStatus
}