package services.member.application.port.`in`

interface SignUpUseCase {

    fun signUp(
        signUpCommand: SignUpCommand
    )
}