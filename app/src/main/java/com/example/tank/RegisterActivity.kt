package com.example.tank

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tanksforandroid.R
import tank.dto.UserDto
import java.io.ObjectOutputStream
import java.io.OutputStream
import java.net.Socket

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextConfirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword)
    }

    fun onRegisterButtonClick(view: View) {
        val username = editTextUsername.text.toString()
        val password = editTextPassword.text.toString()
        val confirmPassword = editTextConfirmPassword.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty() && password == confirmPassword) {
            val task = ConnectToServerTask()
            task.execute(username,password,"new")
            val result: Boolean? = task.get()
            if (result == true) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        } else {

            println("Invalid input or passwords don't match")
        }
    }
}
