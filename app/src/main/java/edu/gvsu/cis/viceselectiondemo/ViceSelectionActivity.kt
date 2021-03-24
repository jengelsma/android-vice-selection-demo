package edu.gvsu.cis.viceselectiondemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class ViceSelectionActivity : AppCompatActivity() {

    private var selection = "Steak"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vice_selection)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
            val intent = Intent()
            intent.putExtra("vice", selection)
            setResult(RESULT_OK, intent)
            finish()

        }

        val spinner = findViewById<Spinner>(R.id.choices)

        val adapter = ArrayAdapter.createFromResource(
            this, R.array.vices,
            R.layout.support_simple_spinner_dropdown_item
        )
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View?, i: Int, l: Long) {
                selection = adapterView.getItemAtPosition(i) as String
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }

    }
}