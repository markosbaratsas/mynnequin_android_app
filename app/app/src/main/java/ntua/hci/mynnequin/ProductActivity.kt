package ntua.hci.mynnequin

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        // get data from intent
        var intent = intent
        val resultTv = findViewById<TextView>(R.id.product_name)
        val productText = intent.getStringExtra("productText")
        resultTv.text = productText

        val imageView = findViewById<ImageView>(R.id.product_image)
        if (productText == "Sweater, 50\$") {
            imageView.setImageResource(R.drawable.product01)
        }
        else if (productText == "Pullover, 35\$") {
            imageView.setImageResource(R.drawable.product02)
        }
        else if (productText == "Loose Jeans, 80\$") {
            imageView.setImageResource(R.drawable.product03)
        }
        else if (productText == "Sneakers, 110\$") {
            imageView.setImageResource(R.drawable.product04)
        }
        else if (productText == "Cool Pants, 90\$") {
            imageView.setImageResource(R.drawable.product05)
        }
        else if (productText == "All Star Shoes, 70\$") {
            imageView.setImageResource(R.drawable.product06)
        }
        else if (productText == "Jeans (various colors), 65\$") {
            imageView.setImageResource(R.drawable.product07)
        }
        else if (productText == "Lace up Shoes, 190\$") {
            imageView.setImageResource(R.drawable.product08)
        }



        val previous = findViewById<ImageView>(R.id.previous)
        previous.setOnClickListener {
            onBackPressed()
        }

        val modelBtn = findViewById<Button>(R.id.buttontomodel)
        modelBtn.setOnClickListener {
            val intent = Intent(this@ProductActivity, ModelPreview::class.java)
            startActivity(intent)
        }

        val favourite = findViewById<LinearLayout>(R.id.add_to_favorites)
        favourite.setOnClickListener {
            val toast = Toast.makeText(
                applicationContext,
                "Added to favourites",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }

        val cart = findViewById<LinearLayout>(R.id.add_to_cart)
        cart.setOnClickListener {
            val toast = Toast.makeText(applicationContext, "Added to cart", Toast.LENGTH_SHORT)
            toast.show()
        }

    }


}