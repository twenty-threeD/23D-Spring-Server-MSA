package services.member.application.service

import org.springframework.stereotype.Service
import services.member.application.port.`in`.SignUpCommand
import services.member.application.port.`in`.SignUpUseCase
import services.member.application.port.out.SaveMemberPort
import services.member.domain.model.Member
import services.member.domain.model.Provider
import services.member.domain.model.Role
import java.time.LocalDateTime
import java.util.UUID

@Service
class SignUpService(
    private val saveMemberPort: SaveMemberPort
): SignUpUseCase {

    override fun signUp(
        signUpCommand: SignUpCommand
    ) {

        saveMemberPort.saveMember(
            Member(
                id = UUID.randomUUID(),
                username = signUpCommand.username,
                name = signUpCommand.name,
                email = signUpCommand.email,
                phone = signUpCommand.phone,
                password = signUpCommand.password,
                role = Role.USER,
                provider = Provider.AUTH,
                createdAt = LocalDateTime.now()
            )
        )
    }
}