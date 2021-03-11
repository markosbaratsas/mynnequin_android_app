package ntua.hci.mynnequin

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<ImageView>(R.id.button1)

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SearchViewJav::class.java)
            startActivity(intent)
        }

    }
}