package com.example.tank

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.View
import com.example.tanksforandroid.R

class MovingImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var bitmap: Bitmap? = null
    private var x = 0
    private var y = 0

    init {
        val drawable = context.getDrawable(R.drawable.tank_active) as BitmapDrawable
        bitmap = drawable.bitmap
    }

    fun updatePosition(newX: Int, newY: Int) {
        x = newX
        y = newY
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas?.drawBitmap(bitmap!!, x.toFloat(), y.toFloat(), Paint())
    }
}
