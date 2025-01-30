package com.example.toylabs.global.security

import com.example.toylabs.domain.model.member.Member
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.SignatureException
import java.util.*

@Component
class JwtTokenProvider(
    @Value("\${jwt.secret}") private val secretKey: String,
    @Value("\${jwt.expiration}") private val validityInMilliseconds: Long
) {
    private val logger: Logger = LoggerFactory.getLogger(JwtTokenProvider::class.java)
    private val key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))

    fun createToken(member: Member, roles: List<String>): String {
        val claims: Claims = Jwts.claims().setSubject(member.email)
        claims["id"] = member.id
        claims["roles"] = roles

        val now = Date()
        val validity = Date(now.time + validityInMilliseconds)

        return Jwts.builder()
            .setClaims(claims) // 사용자 정보(claims) 설정
            .setIssuedAt(now) // 생성 시간
            .setExpiration(validity) // 만료 시간
            .signWith(key)
            .compact()
    }

    fun getClaimsFromToken(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body
    }

    fun validateToken(token: String): Boolean {
        return try {
            val claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
            !claims.body.expiration.before(Date())
        } catch (e: Exception) {
            // 예외 처리 추가
            when (e) {
                is ExpiredJwtException -> logger.warn("Token expired: ${e.message}")
                is MalformedJwtException -> logger.warn("Malformed token: ${e.message}")
                is SignatureException -> logger.error("Invalid token signature: ${e.message}")
                else -> logger.error("Unexpected error while validating token: ${e.message}")
            }
            false
        }
    }

}