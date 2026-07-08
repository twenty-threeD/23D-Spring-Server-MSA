package services.member.adapter.out.persistence

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Component
import services.member.application.port.out.SaveMemberPort
import services.member.domain.exception.CannotVerifyIntegrity
import services.member.domain.model.Member

@Component
class MemberPersistenceAdapter(
    private val memberJpaRepository: MemberJpaRepository
): SaveMemberPort {

    override fun saveMember(
        member: Member
    ): Member {

        try {

            memberJpaRepository.save(
                MemberJpaEntity(
                    username = member.username,
                    name = member.name,
                    email = member.email,
                    phone = member.phone,
                    password = member.password,
                    role = member.role,
                    provider = member.provider
                )
            )
        } catch (_: DataIntegrityViolationException) {

            throw CannotVerifyIntegrity()
        }

        return member
    }
}