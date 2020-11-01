package com.example.gdgandroidwebinar14

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.*
import kotlinx.android.synthetic.main.activity_sample1.*

class Sample1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample1)

        textBox1.setOnClickListener { toggleZoom(it) }
        textBox2.setOnClickListener { toggleZoom(it) }
        textBox3.setOnClickListener { toggleZoom(it) }
        textBox4.setOnClickListener { toggleZoom(it) }
    }

    private fun toggleZoom(view: View) {
        if(motionLayout.currentState == R.id.altEnd){
            motionLayout.transitionToStart()
        }
        else {
            val cs = motionLayout.getConstraintSet(R.id.altEnd)
            val cs2 = motionLayout.getConstraintSet(R.id.start)

            cs.clone(cs2)

            cs.connect(view.id, TOP, PARENT_ID, TOP)
            cs.connect(view.id, BOTTOM, PARENT_ID, BOTTOM)
            cs.connect(view.id, START, PARENT_ID, START)
            cs.connect(view.id, END, PARENT_ID, END)

            cs.setElevation(view.id, 1f)
            cs.setFloatValue(view.id, "TextSize", 40f)

            motionLayout.updateState(R.id.altEnd, cs)
            motionLayout.transitionToEnd()
        }
    }
}