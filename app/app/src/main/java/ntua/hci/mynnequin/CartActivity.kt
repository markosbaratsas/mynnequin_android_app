package ntua.hci.mynnequin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toDrawable

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)




        val button_search = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.search_button)

        button_search.setOnClickListener {
            val intent = Intent(this@CartActivity, SearchViewJav::class.java)
            startActivity(intent)
        }

        val button_profile = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.profile_button)

        button_profile.setOnClickListener {
            val intent = Intent(this@CartActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        val button_favorites = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.favorites_button)

        button_favorites.setOnClickListener {
            val intent = Intent(this@CartActivity, FavoritesActivityJav::class.java)
            startActivity(intent)
        }

        val button_cart = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.cart_button)
        button_cart.setBackgroundResource(R.drawable.icon_selected)

        button_cart.setOnClickListener {
            val intent = Intent(this@CartActivity, CartActivity::class.java)
            startActivity(intent)
        }




    }
}