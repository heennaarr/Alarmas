package com.example.alarmasddi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSwitchListeners()
    }

    private fun setupSwitchListeners() {
        // Mapeo de los TextViews correspondientes a los tiempos y los textos
        val timeViews = listOf(
            findViewById<TextView>(R.id.time),
            findViewById<TextView>(R.id.time2),
            findViewById<TextView>(R.id.time3),
            findViewById<TextView>(R.id.time4),
            findViewById<TextView>(R.id.time5),
            findViewById<TextView>(R.id.time6),
            findViewById<TextView>(R.id.time7)
        )

        val textViews = listOf(
            findViewById<TextView>(R.id.text),
            findViewById<TextView>(R.id.text2),
            findViewById<TextView>(R.id.text3),
            findViewById<TextView>(R.id.text4),
            findViewById<TextView>(R.id.text5),
            findViewById<TextView>(R.id.text6),
            findViewById<TextView>(R.id.text7)
        )

        val switches = listOf(
            findViewById<SwitchMaterial>(R.id.switch1),
            findViewById<SwitchMaterial>(R.id.switch2),
            findViewById<SwitchMaterial>(R.id.switch3),
            findViewById<SwitchMaterial>(R.id.switch4),
            findViewById<SwitchMaterial>(R.id.switch5),
            findViewById<SwitchMaterial>(R.id.switch6),
            findViewById<SwitchMaterial>(R.id.switch7)
        )
        val button = findViewById<FloatingActionButton>(R.id.floating_action_button)

        switches.forEachIndexed { index, materialSwitch ->
            val timeView = timeViews[index]
            val textView = textViews[index]

            updateViewColors(materialSwitch.isChecked, timeView, textView)

            materialSwitch.setOnCheckedChangeListener { _, isChecked ->
                updateViewColors(isChecked, timeView, textView)
                toast(isChecked,textView)
            }
            button.setOnClickListener {
                val text = "Añadir alarma"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this, text, duration) // in Activity
                toast.show()
            }
        }
    }

    private fun updateViewColors(isChecked: Boolean, timeView: TextView, textView: TextView) {
        if (isChecked) {
            timeView.setTextColor(ContextCompat.getColor(this, android.R.color.black))
            textView.setTextColor(ContextCompat.getColor(this, android.R.color.black))

        } else {
            timeView.setTextColor(ContextCompat.getColor(this, R.color.gris))
            textView.setTextColor(ContextCompat.getColor(this, R.color.gris))
        }
    }

    private fun toast(isChecked: Boolean, textView: TextView) {
        if (isChecked) {
            val text = "Alarma ${textView.text} activada"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(this, text, duration) // in Activity
            toast.show()
        } else {
            val text = "Alarma ${textView.text} desactivada"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(this, text, duration) // in Activity
            toast.show()
        }

    }
}
