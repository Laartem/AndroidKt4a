package com.esiea.androidkt4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.androidkt4a.domain.entity.User
import com.esiea.androidkt4a.domain.usecase.CreateUserUseCase
import com.esiea.androidkt4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()


    fun onClickedLogin(emailUser: String, pwdUser: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser, pwdUser)
            val loginStatus = if(user != null){
                LoginSuccess(user.email, user.pwd)
            }else{
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }

        }

    }
}