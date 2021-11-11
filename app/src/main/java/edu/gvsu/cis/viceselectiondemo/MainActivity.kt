package edu.gvsu.cis.viceselectiondemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var vice = "Steak"

    companion object {
        const val VICE_SELECTION = 1 + Activity.RESULT_FIRST_USER
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, ViceSelectionActivity::class.java)
            intent.putExtra("vice", vice)
            startActivityForResult(intent, VICE_SELECTION)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == VICE_SELECTION && resultCode == RESULT_OK) {
            val tv = findViewById<TextView>(R.id.message)
            vice = data?.getStringExtra("vice") ?: "Steak"
            tv.text = "Your vice is: " + vice
        }
    }
}