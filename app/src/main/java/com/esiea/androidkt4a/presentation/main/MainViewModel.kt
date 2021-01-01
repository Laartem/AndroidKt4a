package com.esiea.androidkt4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.androidkt4a.domain.entity.User
import com.esiea.androidkt4a.domain.usecase.CreateUserUseCase
import com.esiea.androidkt4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()
    val createLiveData: MutableLiveData<CreateStatus> = MutableLiveData()


    fun onClickedLogin(emailUser: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)
            val loginStatus = if(user != null){
                LoginSuccess(user.email)
            }else{
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }

        }
    }

    fun onClickedCreate(emailUser: String){
        viewModelScope.launch(Dispatchers.IO) {
            val u = User(emailUser)
            val user = createUserUseCase.invoke(u)
            val createStatus = if(user != null){
                CreateSuccess(u.email)
            }else{
                CreateError
            }
            withContext(Dispatchers.Main){
                createLiveData.value = createStatus
            }
        }
    }
}