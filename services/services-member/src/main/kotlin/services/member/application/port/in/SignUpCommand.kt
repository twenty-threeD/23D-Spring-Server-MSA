package services.member.application.port.`in`

data class SignUpCommand(

    val username: String,

    val name: String,

    val email: String,

    val phone: String,

    val password: String
)
