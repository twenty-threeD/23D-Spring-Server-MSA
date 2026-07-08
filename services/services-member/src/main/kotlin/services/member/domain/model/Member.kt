package services.member.domain.model

import java.time.LocalDateTime
import java.util.UUID

class Member(

    val id: UUID,

    val username: String,

    val name: String,

    val email: String,

    val phone: String,

    val password: String,

    val role: Role,

    val provider: Provider,

    val createdAt: LocalDateTime
)