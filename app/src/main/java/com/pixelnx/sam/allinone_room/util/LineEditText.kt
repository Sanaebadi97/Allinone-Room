package com.pixelnx.sam.allinone_room.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.appcompat.widget.AppCompatEditText


class LineEditText(context: Context?) : AppCompatEditText(context) {

    private var mRect: Rect = Rect()
    private var mPaint: Paint = Paint()


    override fun onDraw(canvas: Canvas?) {
        val height = (parent as View).height
        val lineHeight = lineHeight
        val numberOfLines = height / lineHeight

        val rect: Rect = mRect
        val paint: Paint = mPaint

        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 2.0f
        mPaint.color = Color.YELLOW

        var baseLine = getLineBounds(0, rect)
        for (i in 0..numberOfLines) {

            canvas!!.drawLine(
                rect.left.toFloat(),
                (baseLine + 1).toFloat(), rect.right.toFloat(), (baseLine + 1).toFloat(), paint
            )
            baseLine += lineHeight
        }
        super.onDraw(canvas)
    }

}