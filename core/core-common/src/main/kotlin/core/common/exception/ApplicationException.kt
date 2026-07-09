package core.common.exception

open class ApplicationException(

    val exceptionCode: ExceptionCode
): RuntimeException(exceptionCode.message)