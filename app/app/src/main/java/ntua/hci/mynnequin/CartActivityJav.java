package ntua.hci.mynnequin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartActivityJav extends AppCompatActivity {
    private ExampleAdapter3 adapter;
    private List<ExampleItem2> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_jav);
        fillExampleList();
        setUpRecyclerView();


        // menu
        ConstraintLayout button_search = (ConstraintLayout) findViewById(R.id.search_button);
        button_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(CartActivityJav.this, SearchViewJav.class));
            }
        });

        ConstraintLayout button_profile = (ConstraintLayout) findViewById(R.id.profile_button);
        button_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(CartActivityJav.this, ProfileActivity.class));
            }
        });

        ConstraintLayout button_favorites = (ConstraintLayout) findViewById(R.id.favorites_button);
        button_favorites.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(CartActivityJav.this, FavoritesActivityJav.class));
            }
        });

        ConstraintLayout button_cart = (ConstraintLayout) findViewById(R.id.cart_button);
        button_cart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(CartActivityJav.this, CartActivityJav.class));
            }
        });

        ImageView pressed_button = (ImageView) findViewById(R.id.cart_button_icon);
        pressed_button.setImageResource(R.drawable.cart2);
    }

    @SuppressLint("SetTextI18n")
    private void fillExampleList() {
        SharedPreferences sharedPref = getSharedPreferences("sharedPrefs", MODE_PRIVATE);

        int SweaterQuantity = sharedPref.getInt("SweaterQuantity", 0);
        int PulloverQuantity = sharedPref.getInt("PulloverQuantity", 0);
        int LooseJeansQuantity = sharedPref.getInt("LooseJeansQuantity", 0);
        int SneakersQuantity = sharedPref.getInt("SneakersQuantity", 0);
        int PantsQuantity = sharedPref.getInt("PantsQuantity", 0);
        int AllStarQuantity = sharedPref.getInt("AllStarQuantity", 0);
        int JeansQuantity = sharedPref.getInt("JeansQuantity", 0);
        int LaceUpShoesQuantity = sharedPref.getInt("LaceUpShoesQuantity", 0);

        int SweaterPrice = sharedPref.getInt("SweaterPrice", 50);
        int PulloverPrice = sharedPref.getInt("PulloverPrice", 35);
        int LooseJeansPrice = sharedPref.getInt("LooseJeansPrice", 80);
        int SneakersPrice = sharedPref.getInt("SneakersPrice", 110);
        int PantsPrice = sharedPref.getInt("PantsPrice", 90);
        int AllStarPrice = sharedPref.getInt("AllStarPrice", 70);
        int JeansPrice = sharedPref.getInt("JeansPrice", 65);
        int LaceUpShoesPrice = sharedPref.getInt("LaceUpShoesPrice", 190);

        int totalQuantity = 0;
        int totalPrice = 0;
        exampleList = new ArrayList<>();
        if(SweaterQuantity>0){
            exampleList.add(new ExampleItem2(R.drawable.product01, "Sweater, 50$", "Comfortable Sweater with white and navy blue stripes", "product01", "SweaterFavorite", "SweaterQuantity", "SweaterPrice", SweaterQuantity));
            totalPrice += SweaterQuantity*SweaterPrice;
            totalQuantity += SweaterQuantity;
        }
        if(PulloverQuantity>0){
            exampleList.add(new ExampleItem2(R.drawable.product02, "Pullover, 35$", "Perfect autumn pullover in shades of brown", "product02", "PulloverFavorite", "PulloverQuantity", "PulloverPrice", PulloverQuantity));
            totalPrice += PulloverQuantity*PulloverPrice;
            totalQuantity += PulloverQuantity;
        }
        if(LooseJeansQuantity>0){
            exampleList.add(new ExampleItem2(R.drawable.product03, "Loose Jeans, 80$", "Loose jeans for casual and cool outfits", "product03", "LooseJeansFavorite", "LooseJeansQuantity", "LooseJeansPrice", LooseJeansQuantity));
            totalPrice += LooseJeansQuantity*LooseJeansPrice;
            totalQuantity += LooseJeansQuantity;
        }
        if(SneakersQuantity>0){
            exampleList.add(new ExampleItem2(R.drawable.product04, "Sneakers, 110$", "Comfortable sneakers for sporty looks", "product04", "SneakersFavorite", "SneakersQuantity", "SneakersPrice", SneakersQuantity));
            totalPrice += SneakersQuantity*SneakersPrice;
            totalQuantity += SneakersQuantity;
        }
        if(PantsQuantity>0){
            exampleList.add(new ExampleItem2(R.drawable.product05, "Cool Pants, 90$", "Stylish and cool brown pants", "product05", "PantsFavorite", "PantsQuantity", "PantsPrice", PantsQuantity));
            totalPrice += PantsQuantity*PantsPrice;
            totalQuantity += PantsQuantity;
        }
        if(AllStarQuantity>0){
            exampleList.add(new ExampleItem2(R.drawable.product06, "All Star Shoes, 70$", "Classic white All Star shoes", "product06", "AllStarFavorite", "AllStarQuantity", "AllStarPrice", AllStarQuantity));
            totalPrice += AllStarQuantity*AllStarPrice;
            totalQuantity += AllStarQuantity;
        }
        if(JeansQuantity>0){
            exampleList.add(new ExampleItem2(R.drawable.product07, "Jeans, 65$", "Comfortable jeans in various colors", "product07", "JeansFavorite", "JeansQuantity", "JeansPrice", JeansQuantity));
            totalPrice += JeansQuantity*JeansPrice;
            totalQuantity += JeansQuantity;
        }
        if(LaceUpShoesQuantity>0){
            exampleList.add(new ExampleItem2(R.drawable.product08, "Lace up Shoes, 190$", "Lace up shoes man for formal occasions", "product08", "LaceUpShoesFavorite", "LaceUpShoesQuantity", "LaceUpShoesPrice", LaceUpShoesQuantity));
            totalPrice += LaceUpShoesQuantity*LaceUpShoesPrice;
            totalQuantity += LaceUpShoesQuantity;
        }

        TextView total_price = findViewById(R.id.total_price);
        total_price.setText("Total price: " + String.valueOf(totalPrice));
        TextView total_items = findViewById(R.id.total_items);
        total_items.setText("Total items: " + String.valueOf(totalQuantity));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view3);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        adapter = new ExampleAdapter3(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void decreaseQuantity(View view) {
        TextView textView = (TextView) view;
        SharedPreferences sharedPref = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        int itemQuantity = sharedPref.getInt(textView.getText().toString(), 0);
        editor.putInt(textView.getText().toString(), itemQuantity-1);
        editor.apply();


        Intent intent = new Intent(this, CartActivityJav.class);
        startActivity(intent);
    }

    public void increaseQuantity(View view) {
        TextView textView = (TextView) view;
        SharedPreferences sharedPref = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        int itemQuantity = sharedPref.getInt(textView.getText().toString(), 0);
        editor.putInt(textView.getText().toString(), itemQuantity + 1);
        editor.apply();

        Intent intent = new Intent(this, CartActivityJav.class);
        startActivity(intent);
    }

    public void pressChekout(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Checkout to be implemented soon!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}