package ntua.hci.mynnequin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ProductActivityJav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_jav);


        Intent intent = this.getIntent();
        TextView resultTv = (TextView) findViewById(R.id.product_name);
        String productText = intent.getStringExtra("productText");
        resultTv.setText(productText);

        ImageView imageView = findViewById(R.id.product_image);
        TextView textView = findViewById(R.id.product_name_favorites);
        TextView textViewQuantity = findViewById(R.id.product_name_cart_quantity);
        if ( productText.equals("Sweater, 50$") ) {
            imageView.setImageResource(R.drawable.product01);
            textView.setText("SweaterFavorite");
            textViewQuantity.setText("SweaterQuantity");
        }
        else if ( productText.equals("Pullover, 35$") ) {
            imageView.setImageResource(R.drawable.product02);
            textView.setText("PulloverFavorite");
            textViewQuantity.setText("PulloverQuantity");
        }
        else if ( productText.equals("Loose Jeans, 80$") ) {
            imageView.setImageResource(R.drawable.product03);
            textView.setText("LooseJeansFavorite");
            textViewQuantity.setText("LooseJeansQuantity");
        }
        else if ( productText.equals("Sneakers, 110$") ) {
            imageView.setImageResource(R.drawable.product04);
            textView.setText("SneakersFavorite");
            textViewQuantity.setText("SneakersQuantity");
        }
        else if ( productText.equals("Cool Pants, 90$")) {
            imageView.setImageResource(R.drawable.product05);
            textView.setText("PantsFavorite");
            textViewQuantity.setText("PantsQuantity");
        }
        else if ( productText.equals("All Star Shoes, 70$") ) {
            imageView.setImageResource(R.drawable.product06);
            textView.setText("AllStarFavorite");
            textViewQuantity.setText("AllStarQuantity");
        }
        else if ( productText.equals("Jeans, 65$") ) {
            imageView.setImageResource(R.drawable.product07);
            textView.setText("JeansFavorite");
            textViewQuantity.setText("JeansQuantity");
        }
        else if ( productText.equals("Lace up Shoes, 190$") ) {
            imageView.setImageResource(R.drawable.product08);
            textView.setText("LaceUpShoesFavorite");
            textViewQuantity.setText("LaceUpShoesQuantity");
        }

        SharedPreferences sharedPref = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        boolean itemFavorite = sharedPref.getBoolean(textView.getText().toString(), false);
        if ( itemFavorite ) {
            TextView addToFavTv = findViewById(R.id.add_to_favorites_txt);
            addToFavTv.setText("Remove from Favorites");
        }

        ImageView previous = (ImageView) findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Button modelBtn = (Button) findViewById(R.id.buttontomodel);
        modelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ProductActivityJav.this, ModelPreview.class));
            }
        });


        LinearLayout favourite = (LinearLayout) findViewById(R.id.add_to_favorites);
        favourite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences sharedPref = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
                TextView textView = findViewById(R.id.product_name_favorites);
                boolean itemFavorite = sharedPref.getBoolean(textView.getText().toString(), false);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean(textView.getText().toString(), !itemFavorite);
                editor.apply();

                Context context = getApplicationContext();

                TextView addToFavTv = findViewById(R.id.add_to_favorites_txt);
                CharSequence text;
                if ( !itemFavorite ) {
                    addToFavTv.setText("Remove from Favorites");
                    text = "Added to favourites";
                }
                else {
                    addToFavTv.setText("Add to Favorites");
                    text = "Removed from favourites";
                }

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });


        LinearLayout cart = (LinearLayout) findViewById(R.id.add_to_cart);
        cart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Added to cart";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                TextView textView = findViewById(R.id.product_name_cart_quantity);
                SharedPreferences sharedPref = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
                int itemQuantity = sharedPref.getInt(textView.getText().toString(), 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt(textView.getText().toString(), itemQuantity+1);
                editor.apply();
            }
        });
    }
}