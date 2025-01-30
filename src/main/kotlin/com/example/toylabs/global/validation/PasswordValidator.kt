package com.example.toylabs.global.validation

import com.example.toylabs.global.validation.annotation.ValidPassword
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext


class PasswordValidator : ConstraintValidator<ValidPassword, String> {

    private val regex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?]).{8,}$")

    override fun isValid(password: String?, context: ConstraintValidatorContext?): Boolean {
        return password != null && regex.matches(password)
    }

}