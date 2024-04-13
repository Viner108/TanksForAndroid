package tank.dto;

import java.io.Serializable

class TankDto(val id: Int) : Serializable {
    companion object {
        private const val serialVersionUID = 8038539938717817115L
    }

    var speed = 5f
    var alpha = 0f
    var deltaX = 0f
    var deltaY = 0f
    var deltaAlpha = 0f
    var speedAlpha = 2f
    var isFocusable = false
    var isAlive = true
    private var _x = 0f
    private var _y = 0f

    var X: Float
        get() = _x
        set(value) {
            _x = value
        }

    var Y: Float
        get() = _y
        set(value) {
            _y = value
        }

    override fun toString(): String {
        return "TankDto{id=$id, X=$X, Y=$Y}"
    }
}
