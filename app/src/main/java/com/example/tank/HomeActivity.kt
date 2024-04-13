package com.example.tank

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tanksforandroid.R

class HomeActivity : AppCompatActivity() {
    private lateinit var movingImageView: MovingImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.setBackgroundColor(Color.rgb(164, 191, 51))
        setContentView(R.layout.activity_home)
        val imageView = findViewById<ImageView>(R.id.tankImageView)
        val socketClientTask = SocketClientTask(imageView)
        socketClientTask.start()
    }

}
