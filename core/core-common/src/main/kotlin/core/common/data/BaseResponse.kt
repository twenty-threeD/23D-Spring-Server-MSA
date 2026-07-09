package core.common.data

import com.fasterxml.jackson.annotation.JsonInclude
import core.common.exception.ApplicationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class BaseResponse<T>(

    val status: Int,

    val message: String,

    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    val data: T? = null,

    @field:JsonInclude(JsonInclude.Include.NON_NULL)
    val code: String? = null
) {

    companion object {

        fun <T> of(
            httpStatus: HttpStatus,
            message: String,
            data: T? = null,
        ) = BaseResponse(
            status = httpStatus.value(),
            message = message,
            data = data,
        )

        fun <T> ok(
            message: String,
            data: T? = null
        ) = of(
            httpStatus = HttpStatus.OK,
            message = message,
            data = data
        )

        fun error(
            applicationException: ApplicationException
        ): BaseResponse<Unit> = of(
            httpStatus = applicationException.exceptionCode.httpStatus,
            message = applicationException.exceptionCode.message
        )
    }

    fun toResponseEntity(): ResponseEntity<BaseResponse<T>> = ResponseEntity
        .status(status)
        .body(this)
}
