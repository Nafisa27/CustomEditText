package com.example.edittextvalidation.customViews

import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText


class CustomEdittext : TextInputEditText {
    private val mPaint = Paint()

    constructor(context: Context) : super(context) {
        initPaint(R.color.holo_blue_bright)
    }

    constructor(context: Context, attrs: AttributeSet) : super(
        context, attrs
    ) {
        //initPaint(R.color.holo_blue_bright)

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        //initPaint(R.color.holo_blue_bright)

    }

    private fun initPaint(holoBlueBright: Int) {
        mPaint.style = Paint.Style.STROKE
        mPaint.color = ContextCompat.getColor(context, holoBlueBright)
    }

    override fun onDraw(canvas: Canvas) {
        val paint = Paint()
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas.drawPaint(paint)
        paint.color = ContextCompat.getColor(context, R.color.holo_green_dark)
        paint.textSize = 20f
        canvas.drawText("Some Text", -10F, -10F, paint)
        super.onDraw(canvas)
    }

    private fun drawText()
    {

    }
    private fun validatePassword(password: String?) {
        if(!password.isNullOrEmpty()){
        if (password.length < 8) {

           initPaint(R.color.holo_red_dark)
        }
        if (!password.matches(".*[A-Z].*".toRegex())) {
            initPaint(R.color.holo_blue_dark)
        }
        if (!password.matches(".*[a-z].*".toRegex())) {
            // initPaint(R.color.holo_red_dark)
        }
        if (!password.matches(".*[@#\$%^&+].*".toRegex())) {
            //  initPaint(R.color.holo_green_dark)
        }
        }
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        if (text != null) {
            validatePassword(text.toString())
        }
    }
}