package com.example.novelparse.presentation.authenticate.view_model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel: ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }
    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun login() {
        if (_email.value == "test@example.com" && _password.value == "123456") {
            _isLoggedIn.value = true // Giả lập đăng nhập thành công
        }
    }

    fun register(email: String, password: String, confirmPassword: String) {
        if (password == confirmPassword) {
            _email.value = email
            _password.value = password
            _isLoggedIn.value = true // Giả lập đăng ký thành công
            println("Register success email $_email")
        }

    }
}