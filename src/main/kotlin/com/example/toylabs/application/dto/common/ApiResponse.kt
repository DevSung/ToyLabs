package com.example.toylabs.application.dto.common

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiResponse(
    val status: Int,
    val message: String,
    val data: Any? = null
) {
    companion object {
        private val DEFAULT_STATUS = HttpStatus.OK.value()
        private const val DEFAULT_MESSAGE = "success"

        fun default(): ApiResponse {
            return ApiResponse(
                status = DEFAULT_STATUS,
                message = DEFAULT_MESSAGE
            )
        }

        fun success(data: Any? = null): ApiResponse {
            return ApiResponse(
                status = DEFAULT_STATUS,
                message = DEFAULT_MESSAGE,
                data = data
            )
        }

        fun error(code: HttpStatus, message: String): ApiResponse {
            return ApiResponse(
                status = code.value(),
                message = message
            )
        }

    }
}