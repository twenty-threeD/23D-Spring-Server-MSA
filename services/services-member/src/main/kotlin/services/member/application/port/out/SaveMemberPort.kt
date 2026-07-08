package services.member.application.port.out

import services.member.domain.model.Member

interface SaveMemberPort {

    fun saveMember(
        member: Member
    ): Member
}