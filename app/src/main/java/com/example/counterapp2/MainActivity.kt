package com.example.counterapp2

import android.R
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.Color

class MainActivity : AppCompatActivity() {

    var count =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) // connects kotlin to xml

        val counter= findViewById<TextView>(R.id.counter)
        val increasebutton=findViewById<Button>(R.id.increase)
        val decreasebutton=findViewById<Button>(R.id.decrease)
        val resetbutton=findViewById<Button>(R.id.reset)

        increasebutton.setOnClickListener {
            count++

            counter.text=count.toString()

            if(count>0)
                counter.setTextColor(Color.GREEN)
            else if(count<0)
                counter.setTextColor(Color.RED)
            else
                counter.setTextColor(Color.WHITE)

        }
        decreasebutton.setOnClickListener {
//            if(count>0)
//            {
                count--
                counter.text=count.toString()
//            }
//            else{
//                counter.text="0"
//            }

            if(count>0)
                counter.setTextColor(Color.GREEN)
            else if(count<0)
                counter.setTextColor(Color.RED)
            else
                counter.setTextColor(Color.WHITE)

        }
        resetbutton.setOnClickListener {
            count=0
            counter.text=count.toString()

            counter.setTextColor(Color.WHITE)
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}