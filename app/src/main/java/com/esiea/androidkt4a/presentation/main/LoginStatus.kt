package com.esiea.androidkt4a.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String) : LoginStatus()
object LoginError : LoginStatus()