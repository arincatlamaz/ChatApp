package com.arincatlamaz.chatapp.methods

import android.content.Context
import android.content.res.Resources
import kotlin.jvm.JvmOverloads
import android.util.AttributeSet
import android.view.View
import android.view.WindowInsets

class BaseToolbar @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) :
    View(context, attrs) {
    private var mStatusBarHeight = 0

    init {
        systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
        mStatusBarHeight = dpToPx(15.0f)
        return insets.consumeSystemWindowInsets()
        return insets
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), mStatusBarHeight)
    }

    private fun dpToPx(dp: Float): Int {
        val density = Resources.getSystem().displayMetrics.density
        return Math.round(dp * density)
    }
}