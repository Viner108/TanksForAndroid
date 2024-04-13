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
        val serverPort1 = 8001
        val serverPort2 = 8002
        var boolean: Boolean? = null;
        try {
            SocketManager.socket1 = Socket(serverIp, serverPort1)
            SocketManager.socket2 = Socket(serverIp, serverPort2)

            val outputStream: OutputStream = SocketManager.socket1!!.getOutputStream()
            val objectOutputStream = ObjectOutputStream(outputStream)
            Log.d("MainActivity", userDto.toString())
            objectOutputStream.writeObject(userDto)
            val inputStream = SocketManager.socket2!!.getInputStream()
            val objectInputStream = ObjectInputStream(inputStream)
            boolean = objectInputStream.readObject() as Boolean?;
            Thread.sleep(1000)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return boolean
    }
}