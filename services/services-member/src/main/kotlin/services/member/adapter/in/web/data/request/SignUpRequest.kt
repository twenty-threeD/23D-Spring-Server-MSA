package services.member.adapter.`in`.web.data.request

import com.l98293.phone.Format
import com.l98293.phone.Phone
import com.l98293.phone.Region
import jakarta.validation.constraints.Email
import services.member.application.port.`in`.SignUpCommand

data class SignUpRequest(
    val username: String,

    val name: String,

    @field:Email
    val email: String,

    @field:Phone(
        region = Region.KR,
        format = Format.LOCAL
    )
    val phone: String,

    val password: String
) {

    fun toCommand() = SignUpCommand(
        username = username,
        name = name,
        email = email,
        phone = phone,
        password = password
    )
}
