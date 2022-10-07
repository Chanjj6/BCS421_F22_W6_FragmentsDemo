package edu.farmingdale.bcs421.bcs421_f22_w6_fragmentsdemo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity2 : AppCompatActivity() {
    lateinit var mBtn1:Button
    lateinit var mBtn2:Button
    lateinit var mTV:TextView
    lateinit var edT:EditText
    lateinit var sbar:SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        sbar = findViewById<SeekBar>(R.id.seekBar)
        mBtn1 = findViewById(R.id.btn1);
        mBtn2 = findViewById(R.id.btn2);
        mTV = findViewById(R.id.tv1)
        edT = findViewById(R.id.editText01)
        var frgmnt01 = Fragment01()
        var frgmnt02 = Fragment02()

        sbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                edT.setText(p1.toString())
                mTV.setTextSize(p1.toFloat())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })







        mBtn1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.framelayout1, frgmnt01)
                commit()
            }
        }
        mBtn2.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.framelayout1, frgmnt02)
                commit()
            }
            readFromSharedPref()
        }
    }

    private fun readFromSharedPref(){
        var sharedPref= getSharedPreferences(MainActivity().SHAREDPREF_FILENAME, MODE_PRIVATE)
        mTV.setText(sharedPref.getString("KEY", "not found"))
    }
}