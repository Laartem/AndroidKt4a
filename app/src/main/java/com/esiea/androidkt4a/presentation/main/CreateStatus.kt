package com.esiea.androidkt4a.presentation.main

sealed class CreateStatus

data class CreateSuccess(val email : String) : CreateStatus()
object CreateError : CreateStatus()