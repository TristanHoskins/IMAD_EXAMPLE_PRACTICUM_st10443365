package com.example.imadexamplepracticum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.example.imadexamplepracticum.R.id.tableLayout

class DetailedViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view_screen)


                val tableLayout: TableLayout = findViewById(R.id.tableLayout)
                val btnBack: Button = findViewById(R.id.button5)
                 val clear: Button = findViewById(R.id.button)

                val screenTimeData = intent.getSerializableExtra("screenTimeData") as ArrayList<Map<String, Any>>

                populateSummaryTable(tableLayout, screenTimeData)

                 clear.setOnClickListener{
                     tableLayout.removeAllViews()
                 }

                btnBack.setOnClickListener {
                    val intent = Intent(this, Mscreen2::class.java)
                    startActivity(intent)
                }
            }

            private fun populateSummaryTable(tableLayout: TableLayout, screenTimeData: List<Map<String, Any>>) {
                // Adding table headers
                val headerRow = TableRow(this)
                headerRow.addView(createTextView("Date"))
                headerRow.addView(createTextView("Morning Time"))
                headerRow.addView(createTextView("Afternoon Time"))
                headerRow.addView(createTextView("Notes"))
                tableLayout.addView(headerRow)

                screenTimeData.forEach { entry ->
                    val row = TableRow(this)
                    row.addView(createTextView(entry["date"] as String))
                    row.addView(createTextView((entry["morningTime"] as Int).toString()))
                    row.addView(createTextView((entry["afternoonTime"] as Int).toString()))
                    row.addView(createTextView(entry["notes"] as String))
                    tableLayout.addView(row)
                }
            }

            private fun createTextView(text: String): TextView {
                val textView = TextView(this)
                textView.text = text
                return textView
            }
        }

