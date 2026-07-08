package services.member.adapter.`in`.web.controller

import core.common.data.BaseResponse
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import services.member.adapter.`in`.web.data.request.SignUpRequest
import services.member.application.port.`in`.SignUpUseCase

@RestController
@RequestMapping("/api/member")
class MemberController(
    private val signUpUseCase: SignUpUseCase
) {

    @PostMapping("/signup")
    fun signUp(
        @Valid @RequestBody signUpRequest: SignUpRequest
    ): BaseResponse<Unit> {

        signUpUseCase.signUp(
            signUpCommand = signUpRequest.toCommand()
        )

        return BaseResponse.ok("회원가입 되었습니다.")
    }
}