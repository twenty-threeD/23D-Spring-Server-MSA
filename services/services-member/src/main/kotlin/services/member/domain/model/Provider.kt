package services.member.domain.model

import services.member.domain.exception.UnknownRegistrationId

enum class Provider {

    AUTH,
    GOOGLE,
    KAKAO,
    NAVER;

    companion object {

        fun getRegistrationId(registrationId: String): Provider {

            return when(registrationId.lowercase()) {

                "google" -> GOOGLE
                "kakao" -> KAKAO
                "naver" -> NAVER
                else -> throw UnknownRegistrationId()
            }
        }
    }
}