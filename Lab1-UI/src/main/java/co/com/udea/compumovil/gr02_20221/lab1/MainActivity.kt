package co.com.udea.compumovil.gr02_20221.lab1

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val grades = resources.getStringArray(R.array.grades)
        val spinner: Spinner = findViewById(R.id.academicGrade)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, grades)
        val button: Button = findViewById(R.id.buttonDate)
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val edittext: EditText = findViewById(R.id.editTextDate2)

        spinner.adapter = adapter

        /*Shows the list with diferents grades*/
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.selected_item) + " " +
                            "" + grades[position], Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }


        /*Shows the calendar for the birth date*/
        button.setOnClickListener {
            val datePickerDialog =
                DatePickerDialog(this@MainActivity, DatePickerDialog.OnDateSetListener
                { view, year, monthOfYear, dayOfMonth ->

                    edittext.setText("" + dayOfMonth + " - " + (monthOfYear + 1) + " - " + year)

                }, year, month, day
                )
            datePickerDialog.show()
        }

    }

        fun goToContactActivity(view: View) {
            val intent = Intent(this, MainActivity2::class.java).apply{}
            startActivity(intent)
        }


}

