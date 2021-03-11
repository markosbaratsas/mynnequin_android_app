package ntua.hci.mynnequin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import com.google.android.material.snackbar.BaseTransientBottomBar

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        val button_search = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.search_button)
        button_search.setBackgroundResource(R.drawable.icon_selected)
        button_search.setOnClickListener {
            val intent = Intent(this@SearchActivity, SearchActivity::class.java)
            startActivity(intent)
        }

        val button_profile = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.profile_button)
        button_profile.setOnClickListener {
            val intent = Intent(this@SearchActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        val button_favorites = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.favorites_button)
        button_favorites.setOnClickListener {
            val intent = Intent(this@SearchActivity, FavoritesActivity::class.java)
            startActivity(intent)
        }

        val button_cart = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.cart_button)
        button_cart.setOnClickListener {
            val intent = Intent(this@SearchActivity, CartActivityJav::class.java)
            startActivity(intent)
        }

        val button01 = findViewById<LinearLayout>(R.id.product01)
        button01.setOnClickListener {
            val productText = findViewById<TextView>(R.id.product01_name).text.toString()
            val intent = Intent(this@SearchActivity, ProductActivity::class.java)
            intent.putExtra("productText", productText)
            startActivity(intent)
        }

        val button02 = findViewById<LinearLayout>(R.id.product02)
        button02.setOnClickListener {
            val productText = findViewById<TextView>(R.id.product02_name).text.toString()
            val intent = Intent(this@SearchActivity, ProductActivity::class.java)
            intent.putExtra("productText", productText)
            startActivity(intent)
        }

        val button03 = findViewById<LinearLayout>(R.id.product03)
        button03.setOnClickListener {
            val productText = findViewById<TextView>(R.id.product03_name).text.toString()
            val intent = Intent(this@SearchActivity, ProductActivity::class.java)
            intent.putExtra("productText", productText)
            startActivity(intent)
        }

        val button04 = findViewById<LinearLayout>(R.id.product04)
        button04.setOnClickListener {
            val productText = findViewById<TextView>(R.id.product04_name).text.toString()
            val intent = Intent(this@SearchActivity, ProductActivity::class.java)
            intent.putExtra("productText", productText)
            startActivity(intent)
        }

        val button05 = findViewById<LinearLayout>(R.id.product05)
        button05.setOnClickListener {
            val productText = findViewById<TextView>(R.id.product05_name).text.toString()
            val intent = Intent(this@SearchActivity, ProductActivity::class.java)
            intent.putExtra("productText", productText)
            startActivity(intent)
        }

        val button06 = findViewById<LinearLayout>(R.id.product06)
        button06.setOnClickListener {
            val productText = findViewById<TextView>(R.id.product06_name).text.toString()
            val intent = Intent(this@SearchActivity, ProductActivity::class.java)
            intent.putExtra("productText", productText)
            startActivity(intent)
        }

        val button07 = findViewById<LinearLayout>(R.id.product07)
        button07.setOnClickListener {
            val productText = findViewById<TextView>(R.id.product07_name).text.toString()
            val intent = Intent(this@SearchActivity, ProductActivity::class.java)
            intent.putExtra("productText", productText)
            startActivity(intent)
        }

        val button08 = findViewById<LinearLayout>(R.id.product08)
        button08.setOnClickListener {
            val productText = findViewById<TextView>(R.id.product08_name).text.toString()
            val intent = Intent(this@SearchActivity, ProductActivity::class.java)
            intent.putExtra("productText", productText)
            startActivity(intent)
        }

    }
}