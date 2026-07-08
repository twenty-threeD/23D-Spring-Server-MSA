package services.member.adapter.out.persistence

import com.l98293.phone.Format
import com.l98293.phone.Phone
import com.l98293.phone.Region
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.PrePersist
import services.member.domain.model.Provider
import services.member.domain.model.Role
import java.time.LocalDateTime
import java.util.UUID

@Entity
class MemberJpaEntity(
    @Column(unique = true)
    var username: String,

    var name: String,

    @Column(unique = true)
    var email: String,

    @field:Phone(
        region = Region.KR,
        format = Format.LOCAL
    )
    var phone: String?,

    var password: String?,

    @Enumerated(EnumType.STRING)
    var role: Role,

    @Enumerated(EnumType.STRING)
    var provider: Provider
) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private var id: UUID? = null

    private var createdAt: LocalDateTime? = null

    @PrePersist
    fun prePersistDate() {

        createdAt = LocalDateTime.now()
    }
}