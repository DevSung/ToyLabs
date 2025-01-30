package com.example.toylabs.global.validation

import com.example.toylabs.global.validation.annotation.ValidEmail
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext


class EmailValidator : ConstraintValidator<ValidEmail, String> {

    private val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")

    override fun isValid(email: String?, context: ConstraintValidatorContext?): Boolean {
        return email != null && emailRegex.matches(email)
    }
}