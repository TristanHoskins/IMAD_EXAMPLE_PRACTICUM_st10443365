package com.example.imadexamplepracticum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class Mscreen2 : AppCompatActivity() {
    private lateinit var Date: EditText
    private lateinit var MorningTime: EditText
    private lateinit var AfternoonTime: EditText
    private lateinit var ActivityNotes: EditText
    private val screenTimeData = mutableListOf<Map<String, Any>>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mscreen2)

        Date = findViewById(R.id.editTextDate)
        MorningTime = findViewById(R.id.editTextNumber1)
        AfternoonTime = findViewById(R.id.editTextNumber2)
        ActivityNotes = findViewById(R.id.editText1)
                val button3: Button = findViewById(R.id.button3)
                val button4: Button = findViewById(R.id.button4)

                button3.setOnClickListener {
                    addScreenTimeData()
                }

                button4.setOnClickListener {
                    val intent = Intent(this, DetailedViewScreen::class.java)
                    intent.putExtra("screenTimeData", ArrayList(screenTimeData))
                    startActivity(intent)
                }
    }
    private fun addScreenTimeData() {
        val date = Date.text.toString()
        val morningTime = MorningTime.text.toString().toIntOrNull() ?: 0
        val afternoonTime = AfternoonTime.text.toString().toIntOrNull() ?: 0
        val notes = ActivityNotes.text.toString()

        if (date.isNotEmpty() && (morningTime > 0 || afternoonTime > 0)) {
            val entry = mapOf(
                "date" to date,
                "morningTime" to morningTime,
                "afternoonTime" to afternoonTime,
                "notes" to notes
            )
            screenTimeData.add(entry)
            clearInputFields()
        }
    }

    private fun clearInputFields() {
        Date.text.clear()
        MorningTime.text.clear()
        AfternoonTime.text.clear()
        ActivityNotes.text.clear()
    }
}