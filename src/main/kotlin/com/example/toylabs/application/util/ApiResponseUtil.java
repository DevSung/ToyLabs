package com.example.toylabs.application.util;

import com.example.toylabs.application.dto.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseUtil {

    private ApiResponseUtil() {
    }

    // 성공 응답 (데이터만 포함)
    public static ResponseEntity<ApiResponse> ok(Object data) {
        return ResponseEntity.ok(new ApiResponse(data));
    }

    // 성공 응답 (데이터 없음)
    public static ResponseEntity<ApiResponse> ok() {
        return ResponseEntity.ok(new ApiResponse(null));
    }

    // 실패 응답 (에러 메시지 포함)
    public static ResponseEntity<ApiResponse> fail(String message, HttpStatus status) {
        return ResponseEntity.status(status).body(new ApiResponse(message, status));
    }

}
