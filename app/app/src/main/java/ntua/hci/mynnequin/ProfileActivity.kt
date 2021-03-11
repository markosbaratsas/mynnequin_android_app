package ntua.hci.mynnequin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)




        val button_search = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.search_button)
        button_search.setOnClickListener {
            val intent = Intent(this@ProfileActivity, SearchViewJav::class.java)
            startActivity(intent)
        }

        val button_profile = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.profile_button)
        button_profile.setOnClickListener {
            val intent = Intent(this@ProfileActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        val button_favorites = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.favorites_button)
        button_favorites.setOnClickListener {
            val intent = Intent(this@ProfileActivity, FavoritesActivityJav::class.java)
            startActivity(intent)
        }

        val button_cart = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.cart_button)
        button_cart.setOnClickListener {
            val intent = Intent(this@ProfileActivity, CartActivityJav::class.java)
            startActivity(intent)
        }



        val pressed_button = findViewById<ImageView>(R.id.profile_button_icon);
        pressed_button.setImageResource(R.drawable.profile2);


        var database = FirebaseDatabase.getInstance().reference

        var getdata = object: ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                var sb_name = StringBuilder()
                var sb_username = StringBuilder()
                var sb_address = StringBuilder()
                var sb_card = StringBuilder()
                var name = ""
                var username = ""
                var address = ""
                var card = ""
                for (i in p0.children ) {
                    name = i.child("Name").getValue().toString()
                    username = i.child("Username").getValue().toString()
                    address = i.child("Shipping_address").getValue().toString()
                    card = i.child("Card").getValue().toString()
                }
                sb_name.append("$name")
                sb_username.append("$username")
                sb_address.append("$address")
                sb_card.append("$card")
                findViewById<TextView>(R.id.profile_name).setText(sb_name)
                findViewById<TextView>(R.id.profile_username).setText(sb_username)
                findViewById<TextView>(R.id.profile_address).setText(sb_address)
                findViewById<TextView>(R.id.profile_card).setText(sb_card)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)
    }


    fun pressLogout(view: View?) {
        val context = applicationContext
        val text: CharSequence = "Υποτίθεται έγινε Log Out τώρα..."
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }
}