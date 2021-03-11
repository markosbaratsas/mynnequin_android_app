package ntua.hci.mynnequin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ModelPreview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model_preview)


        val previous = findViewById<ImageView>(R.id.previous)
        previous.setOnClickListener {
            onBackPressed()
        }

    }
}