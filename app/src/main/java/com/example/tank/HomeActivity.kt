package com.example.tank

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tanksforandroid.R

class HomeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.setBackgroundColor(Color.rgb(164, 191, 51))
        setContentView(R.layout.activity_home)
        val socket1 = SocketManager.socket1
        val socket2 = SocketManager.socket2
    }

}
