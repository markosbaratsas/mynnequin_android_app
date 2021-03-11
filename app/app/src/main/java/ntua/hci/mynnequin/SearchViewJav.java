package ntua.hci.mynnequin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchViewJav extends AppCompatActivity {
    private ExampleAdapter adapter;
    private List<ExampleItem> exampleList;
    public SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_jav);
        fillExampleList();
        setUpRecyclerView();
        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        ConstraintLayout button_search = (ConstraintLayout) findViewById(R.id.search_button);
        button_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SearchViewJav.this, SearchViewJav.class));
            }
        });

        ConstraintLayout button_profile = (ConstraintLayout) findViewById(R.id.profile_button);
        button_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SearchViewJav.this, ProfileActivity.class));
            }
        });

        ConstraintLayout button_favorites = (ConstraintLayout) findViewById(R.id.favorites_button);
        button_favorites.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SearchViewJav.this, FavoritesActivityJav.class));
            }
        });

        ConstraintLayout button_cart = (ConstraintLayout) findViewById(R.id.cart_button);
        button_cart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SearchViewJav.this, CartActivityJav.class));
            }
        });



        ImageView pressed_button = (ImageView) findViewById(R.id.search_button_icon);
        pressed_button.setImageResource(R.drawable.search);






//        SharedPreferences preferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
//        preferences.edit().remove("SweaterFavorite").commit();
//        preferences.edit().remove("PulloverFavorite").commit();
//        preferences.edit().remove("LooseJeansFavorite").commit();
//        preferences.edit().remove("SneakersFavorite").commit();
//        preferences.edit().remove("PantsFavorite").commit();
//        preferences.edit().remove("AllStarFavorite").commit();
//        preferences.edit().remove("JeansFavorite").commit();
//        preferences.edit().remove("LaceUpShoesFavorite").commit();
//
//        preferences.edit().remove("SweaterQuantity").commit();
//        preferences.edit().remove("PulloverQuantity").commit();
//        preferences.edit().remove("LooseJeansQuantity").commit();
//        preferences.edit().remove("SneakersQuantity").commit();
//        preferences.edit().remove("PantsQuantity").commit();
//        preferences.edit().remove("AllStarQuantity").commit();
//        preferences.edit().remove("JeansQuantity").commit();
//        preferences.edit().remove("LaceUpShoesQuantity").commit();
//
//        preferences.edit().remove("SweaterPrice").commit();
//        preferences.edit().remove("PulloverPrice").commit();
//        preferences.edit().remove("LooseJeansPrice").commit();
//        preferences.edit().remove("SneakersPrice").commit();
//        preferences.edit().remove("PantsPrice").commit();
//        preferences.edit().remove("AllStarPrice").commit();
//        preferences.edit().remove("JeansPrice").commit();
//        preferences.edit().remove("LaceUpShoesPrice").commit();
    }

    public void goToProductActivity(View view) {
        Intent intent = new Intent(SearchViewJav.this, ProductActivityJav.class);
        Bundle b = new Bundle();
        TextView c = (TextView) view.findViewById(R.id.text_view1);
        String productText = c.getText().toString();
        b.putString("productText", productText);
        intent.putExtras(b);
        startActivity(intent);
    }


    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.product01, "Sweater, 50$", "sweater white navy blue stripes", "product01"));
        exampleList.add(new ExampleItem(R.drawable.product02, "Pullover, 35$", "pullover shades brown autumn", "product02"));
        exampleList.add(new ExampleItem(R.drawable.product03, "Loose Jeans, 80$", "loose jeans casual cool", "product03"));
        exampleList.add(new ExampleItem(R.drawable.product04, "Sneakers, 110$", "sneakers sporty comfortable", "product04"));
        exampleList.add(new ExampleItem(R.drawable.product05, "Cool Pants, 90$", "stylish cool brown pants", "product05"));
        exampleList.add(new ExampleItem(R.drawable.product06, "All Star Shoes, 70$", "classic white all star shoes", "product06"));
        exampleList.add(new ExampleItem(R.drawable.product07, "Jeans, 65$", "comfortable jeans black blue casual various colors", "product07"));
        exampleList.add(new ExampleItem(R.drawable.product08, "Lace up Shoes, 190$", "lace up shoes man formal", "product08"));
    }
    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        adapter = new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void getText() {
        return;
    }



    public void expand(View view) {
        searchView.setIconified(false);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.example_menu, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return true;
//    }
}