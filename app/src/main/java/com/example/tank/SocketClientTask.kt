package com.example.tank

import android.os.AsyncTask
import android.widget.ImageView
import tank.dto.TankDto
import java.io.ObjectInputStream

class SocketClientTask(imageView: ImageView?) :  Thread()  {
    private val imageView =imageView
    private var isRunning = true
    override fun run() {
        var tankDto: TankDto? = null

        try {
//            val socketOutput = SocketManager.socketOutput
//            val socketInput = SocketManager.socketInput
//
//            val outputStream = socketOutput?.getOutputStream()
//
//            val inputStream = ObjectInputStream(socketInput?.getInputStream())
            var i = 0;
            while (isRunning) {
//                val tankDto = inputStream.readObject() as? TankDto
                val tankDto = TankDto(1)
                tankDto.X= i.toFloat();
                tankDto.Y= i.toFloat();
                i+=10
                imageView?.post {
                    updateTankImage(tankDto)
                }
                // Имитация паузы между обновлениями
                Thread.sleep(1000)
            }

//            inputStream.close()
//            socketOutput!!.close()
//            socketInput!!.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun updateTankImage(tankDto: TankDto) {
        val x = tankDto.X
        val y = tankDto.Y
        imageView?.let {
            it.x = x
            it.y = y
        }
    }
    fun stopTask() {
        isRunning = false
    }
}
