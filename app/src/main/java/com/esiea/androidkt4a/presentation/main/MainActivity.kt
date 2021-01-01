package com.esiea.androidkt4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.esiea.androidkt4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> {
                    Toast.makeText(applicationContext, "Connection success !", Toast.LENGTH_SHORT).show()
                    //startActivity(Intent(this, ApiList::class.java))
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Unknown Account")
                        .setPositiveButton("Ok") {dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        mainViewModel.createLiveData.observe(this, Observer{
            when(it){
                is CreateSuccess -> {
                    Toast.makeText(applicationContext, "Account created !", Toast.LENGTH_SHORT).show()
                }
                is CreateError -> {
                    Toast.makeText(applicationContext, "An error occurred. Please try again later", Toast.LENGTH_LONG).show()
                }
            }
        })

        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(login_edit.text.toString().trim())
        }
        create_account_button.setOnClickListener{
            mainViewModel.onClickedCreate(login_edit.text.toString().trim())

        }
    }
}