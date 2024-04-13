package com.example.tank

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tanksforandroid.R

class LoginActivity : AppCompatActivity(){
    private lateinit var editTextLogin: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextLogin = findViewById(R.id.editTextLogin)
        editTextPassword = findViewById(R.id.editTextPassword)
    }

    fun onLoginButtonClick(view: View) {
        val login = editTextLogin.text.toString()
        val password = editTextPassword.text.toString()

        val task = ConnectToServerTask()
        task.execute(login,password,"old")
        val result: Boolean? = task.get()
        if (result == true) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
