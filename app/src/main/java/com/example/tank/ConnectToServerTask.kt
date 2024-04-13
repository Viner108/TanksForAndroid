package com.example.tank

import android.os.AsyncTask
import android.util.Log
import tank.dto.UserDto
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.OutputStream
import java.net.Socket

class ConnectToServerTask : AsyncTask<String, Boolean, Boolean>() {
    override fun doInBackground(vararg params: String): Boolean? {
        val login = if (params.isNotEmpty()) params[0] else "No strings provided"
        val password = if (params.isNotEmpty()) params[1] else "No strings provided"
        val str =  if (params.isNotEmpty()) params[2] else "No strings provided"
        var userDto: UserDto? = null;
        if(str.equals("new")) {
             userDto = UserDto(true, login, password)
        }else{
             userDto = UserDto(false, login, password)
        }
        val serverIp = "192.168.163.250"
        val serverPortOutput = 8001
        val serverPortInput = 8002
        var boolean: Boolean? = null;
        try {
            SocketManager.socketOutput = Socket(serverIp, serverPortOutput)
            SocketManager.socketInput = Socket(serverIp, serverPortInput)

            val outputStream: OutputStream = SocketManager.socketOutput!!.getOutputStream()
            val objectOutputStream = ObjectOutputStream(outputStream)
            Log.d("MainActivity", userDto.toString())
            objectOutputStream.writeObject(userDto)
            val inputStream = SocketManager.socketInput!!.getInputStream()
            val objectInputStream = ObjectInputStream(inputStream)
            boolean = objectInputStream.readObject() as Boolean?;
            Thread.sleep(1000)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return boolean
    }
}