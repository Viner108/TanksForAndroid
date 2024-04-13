package tank.dto

import java.io.Serializable

class UserDto(var isNovel: Boolean, var username: String, var password: String) : Serializable {


    companion object {
        private const val serialVersionUID = 6529685098267757671L
    }

    override fun toString(): String {
        return "UserDto(isNovel=$isNovel, username='$username', password='$password')"
    }
}