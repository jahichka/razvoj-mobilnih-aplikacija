package com.example.colorpicker

import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.view.View
import androidx.activity.ComponentActivity
class MainActivity : ComponentActivity() {

    private lateinit var redSeekBar: SeekBar
    private lateinit var greenSeekBar: SeekBar
    private lateinit var blueSeekBar: SeekBar
    private lateinit var redLabel: TextView
    private lateinit var greenLabel: TextView
    private lateinit var blueLabel: TextView
    private lateinit var colorPreview: View
    private lateinit var hexColorLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redSeekBar = findViewById(R.id.redSeekBar)
        greenSeekBar = findViewById(R.id.greenSeekBar)
        blueSeekBar = findViewById(R.id.blueSeekBar)
        redLabel = findViewById(R.id.redLabel)
        greenLabel = findViewById(R.id.greenLabel)
        blueLabel = findViewById(R.id.blueLabel)
        colorPreview = findViewById(R.id.colorPreview)
        hexColorLabel = findViewById(R.id.hexColorLabel)

        redSeekBar.setOnSeekBarChangeListener(seekBarChangeListener)
        greenSeekBar.setOnSeekBarChangeListener(seekBarChangeListener)
        blueSeekBar.setOnSeekBarChangeListener(seekBarChangeListener)

        if (savedInstanceState != null) {
            redSeekBar.progress = savedInstanceState.getInt("RED_VALUE", 0)
            greenSeekBar.progress = savedInstanceState.getInt("GREEN_VALUE", 0)
            blueSeekBar.progress = savedInstanceState.getInt("BLUE_VALUE", 0)
            updateColor()
        } else {
            updateColor()
        }

    }

    private val seekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            updateColor()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }

    private fun updateColor() {
        val red = redSeekBar.progress
        val green = greenSeekBar.progress
        val blue = blueSeekBar.progress

        redLabel.text = "Crvena: $red"
        greenLabel.text = "Zelena: $green"
        blueLabel.text = "Plava: $blue"

        val color = Color.rgb(red, green, blue)
        colorPreview.setBackgroundColor(color)

        val hexColor = String.format("#%02X%02X%02X", red, green, blue)
        hexColorLabel.text = "Izabrana boja je $hexColor"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("RED_VALUE", redSeekBar.progress)
        outState.putInt("GREEN_VALUE", greenSeekBar.progress)
        outState.putInt("BLUE_VALUE", blueSeekBar.progress)
    }
}
