package com.sample.foo.usingbottomsheets

import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var mButton1: Button? = null
    private var mButton2: Button? = null
    private var mButton3: Button? = null
    private var mBottomSheetBehavior1: BottomSheetBehavior<*>? = null
    private var mBottomSheetBehavior2: BottomSheetBehavior<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheet = findViewById(R.id.bottom_sheet1)
        mBottomSheetBehavior1 = BottomSheetBehavior.from(bottomSheet)

        mButton1 = findViewById(R.id.button_1) as Button
        mButton1!!.setOnClickListener {
            if (mBottomSheetBehavior1!!.state != BottomSheetBehavior.STATE_EXPANDED) {
                mBottomSheetBehavior1!!.state = BottomSheetBehavior.STATE_EXPANDED
                mButton1!!.setText(R.string.collapse_button1)
            } else {
                mBottomSheetBehavior1!!.state = BottomSheetBehavior.STATE_COLLAPSED
                mButton1!!.setText(R.string.button1)
            }
        }

        val bottomSheet2 = findViewById(R.id.bottom_sheet2)
        mBottomSheetBehavior2 = BottomSheetBehavior.from(bottomSheet2)
        mBottomSheetBehavior2!!.isHideable = true
        mBottomSheetBehavior2!!.peekHeight = 300
        mBottomSheetBehavior2!!.state = BottomSheetBehavior.STATE_HIDDEN

        mButton2 = findViewById(R.id.button_2) as Button
        mButton2!!.setOnClickListener {
            if (mBottomSheetBehavior2!!.state == BottomSheetBehavior.STATE_EXPANDED) {
                mBottomSheetBehavior2!!.state = BottomSheetBehavior.STATE_COLLAPSED
                mButton2!!.setText(R.string.button2_hide)
            } else if (mBottomSheetBehavior2!!.state == BottomSheetBehavior.STATE_COLLAPSED) {
                mBottomSheetBehavior2!!.state = BottomSheetBehavior.STATE_HIDDEN
                mButton2!!.setText(R.string.button2)
            } else if (mBottomSheetBehavior2!!.state == BottomSheetBehavior.STATE_HIDDEN) {
                mBottomSheetBehavior2!!.state = BottomSheetBehavior.STATE_EXPANDED
                mButton2!!.setText(R.string.button2_peek)
            }
        }

        mBottomSheetBehavior2!!.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    mButton2!!.setText(R.string.button2_peek)
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mButton2!!.setText(R.string.button2_hide)
                } else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    mButton2!!.setText(R.string.button2)
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })

        mButton3 = findViewById(R.id.button_3) as Button
        mButton3!!.setOnClickListener {
            val bottomSheetDialogFragment = BottomSheet3DialogFragment()
            bottomSheetDialogFragment.show(supportFragmentManager, bottomSheetDialogFragment.tag)
        }
    }

    companion object {

        private val TAG = "MainActivity"
    }
}
