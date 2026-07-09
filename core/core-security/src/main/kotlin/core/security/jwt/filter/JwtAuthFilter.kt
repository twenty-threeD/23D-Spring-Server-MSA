package core.security.jwt.filter

import core.security.jwt.JwtValidator
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthFilter(
    private val jwtValidator: JwtValidator
): OncePerRequestFilter() {


    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        val token = jwtValidator.resolveToken(request)
        val claims = token?.let { jwtValidator.parseClaims(it) }

        if (claims.isNullOrEmpty()) {

            filterChain.doFilter(
                request,
                response
            )

            return
        }

        val username = claims.subject
        val role = claims.get("role", String::class.java)

        if (username.isNullOrBlank() || role.isNullOrEmpty()) {

            filterChain.doFilter(
                request,
                response
            )

            return
        }

        SecurityContextHolder.getContext().authentication = UsernamePasswordAuthenticationToken(
            username,
            null,
            listOf(SimpleGrantedAuthority(role.takeIf { it.startsWith("ROLE_") } ?: "ROLE_$role"))
        )

        filterChain.doFilter(
            request,
            response
        )
    }
}