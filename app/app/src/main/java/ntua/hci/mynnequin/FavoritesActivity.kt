package ntua.hci.mynnequin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toDrawable

class FavoritesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)


        val button_search = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.search_button)

        button_search.setOnClickListener {
            val intent = Intent(this@FavoritesActivity, SearchViewJav::class.java)
            startActivity(intent)
        }

        val button_profile = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.profile_button)

        button_profile.setOnClickListener {
            val intent = Intent(this@FavoritesActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        val button_favorites = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.favorites_button)
        button_favorites.setBackgroundResource(R.drawable.icon_selected)

        button_favorites.setOnClickListener {
            val intent = Intent(this@FavoritesActivity, FavoritesActivity::class.java)
            startActivity(intent)
        }

        val button_cart = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.cart_button)

        button_cart.setOnClickListener {
            val intent = Intent(this@FavoritesActivity, CartActivity::class.java)
            startActivity(intent)
        }



    }
}