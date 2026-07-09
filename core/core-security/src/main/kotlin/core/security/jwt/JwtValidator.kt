package core.security.jwt

import core.security.exception.InvalidAuthentication
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets

@Component
class JwtValidator(
    @Value("\${jwt.security}")
    secret: String
) {

    companion object {

        private const val BEARER_PREFIX = "Bearer "
    }

    private val parser = Jwts.parser()
        .verifyWith(Keys.hmacShaKeyFor(secret.toByteArray(StandardCharsets.UTF_8)))
        .build()

    fun resolveToken(httpServletRequest: HttpServletRequest): String? =
        httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION)
            ?.takeIf { it.startsWith(BEARER_PREFIX, ignoreCase = true) }
            ?.substring(BEARER_PREFIX.length)

    fun parseClaims(token: String): Claims =
        try {

            parser.parseSignedClaims(token).payload
        } catch (_: Exception) {

            throw InvalidAuthentication()
        }
}