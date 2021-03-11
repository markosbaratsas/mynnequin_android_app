package ntua.hci.mynnequin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivityJav extends AppCompatActivity {
    private ExampleAdapter2 adapter;
    private List<ExampleItem2> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_jav);
        fillExampleList();
        setUpRecyclerView();


        ConstraintLayout button_search = (ConstraintLayout) findViewById(R.id.search_button);
        button_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(FavoritesActivityJav.this, SearchViewJav.class));
            }
        });

        ConstraintLayout button_profile = (ConstraintLayout) findViewById(R.id.profile_button);
        button_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(FavoritesActivityJav.this, ProfileActivity.class));
            }
        });

        ConstraintLayout button_favorites = (ConstraintLayout) findViewById(R.id.favorites_button);
        button_favorites.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(FavoritesActivityJav.this, FavoritesActivityJav.class));
            }
        });

        ConstraintLayout button_cart = (ConstraintLayout) findViewById(R.id.cart_button);
        button_cart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(FavoritesActivityJav.this, CartActivityJav.class));
            }
        });

        ImageView pressed_button = (ImageView) findViewById(R.id.favorites_button_icon);
        pressed_button.setImageResource(R.drawable.favorites);
    }

    private void fillExampleList() {
        SharedPreferences sharedPref = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        boolean Sweater = sharedPref.getBoolean("SweaterFavorite", false);
        boolean Pullover = sharedPref.getBoolean("PulloverFavorite", false);
        boolean LooseJeans = sharedPref.getBoolean("LooseJeansFavorite", false);
        boolean Sneakers = sharedPref.getBoolean("SneakersFavorite", false);
        boolean Pants = sharedPref.getBoolean("PantsFavorite", false);
        boolean AllStar = sharedPref.getBoolean("AllStarFavorite", false);
        boolean Jeans = sharedPref.getBoolean("JeansFavorite", false);
        boolean LaceUpShoes = sharedPref.getBoolean("LaceUpShoesFavorite", false);

        int SweaterQuantity = sharedPref.getInt("SweaterQuantity", 0);
        int PulloverQuantity = sharedPref.getInt("PulloverQuantity", 0);
        int LooseJeansQuantity = sharedPref.getInt("LooseJeansQuantity", 0);
        int SneakersQuantity = sharedPref.getInt("SneakersQuantity", 0);
        int PantsQuantity = sharedPref.getInt("PantsQuantity", 0);
        int AllStarQuantity = sharedPref.getInt("AllStarQuantity", 0);
        int JeansQuantity = sharedPref.getInt("JeansQuantity", 0);
        int LaceUpShoesQuantity = sharedPref.getInt("LaceUpShoesQuantity", 0);

        exampleList = new ArrayList<>();
        if(Sweater) exampleList.add(new ExampleItem2(R.drawable.product01, "Sweater, 50$", "Comfortable Sweater with white and navy blue stripes", "product01", "SweaterFavorite", "SweaterQuantity", "SweaterPrice", SweaterQuantity));
        if(Pullover) exampleList.add(new ExampleItem2(R.drawable.product02, "Pullover, 35$", "Perfect autumn pullover in shades of brown", "product02", "PulloverFavorite", "PulloverQuantity", "PulloverPrice", PulloverQuantity));
        if(LooseJeans) exampleList.add(new ExampleItem2(R.drawable.product03, "Loose Jeans, 80$", "Loose jeans for casual and cool outfits", "product03", "LooseJeansFavorite", "LooseJeansQuantity", "LooseJeansPrice", LooseJeansQuantity));
        if(Sneakers) exampleList.add(new ExampleItem2(R.drawable.product04, "Sneakers, 110$", "Comfortable sneakers for sporty looks", "product04", "SneakersFavorite", "SneakersQuantity", "SneakersPrice", SneakersQuantity));
        if(Pants) exampleList.add(new ExampleItem2(R.drawable.product05, "Cool Pants, 90$", "Stylish and cool brown pants", "product05", "PantsFavorite", "PantsQuantity", "PantsPrice", PantsQuantity));
        if(AllStar) exampleList.add(new ExampleItem2(R.drawable.product06, "All Star Shoes, 70$", "Classic white All Star shoes", "product06", "AllStarFavorite", "AllStarQuantity", "AllStarPrice", AllStarQuantity));
        if(Jeans) exampleList.add(new ExampleItem2(R.drawable.product07, "Jeans, 65$", "Comfortable jeans in various colors", "product07", "JeansFavorite", "JeansQuantity", "JeansPrice", JeansQuantity));
        if(LaceUpShoes) exampleList.add(new ExampleItem2(R.drawable.product08, "Lace up Shoes, 190$", "Lace up shoes man for formal occasions", "product08", "LaceUpShoesFavorite", "LaceUpShoesQuantity", "LaceUpShoesPrice", LaceUpShoesQuantity));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view2);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        adapter = new ExampleAdapter2(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void removeFromFavorites(View view){
        TextView textView = (TextView) view;
        SharedPreferences sharedPref = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(textView.getText().toString(), false);
        editor.apply();

        Intent intent = new Intent(this, FavoritesActivityJav.class);
        startActivity(intent);
    }
}