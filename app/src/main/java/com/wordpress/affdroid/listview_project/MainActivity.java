package com.wordpress.affdroid.listview_project;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout search_layout;
    EditText search_et;
    ListView main_list;

    String[] title_string = {"Blackberrys Men's Checkered Casual Red, Blue Shirt", "Highlander Men's Solid Casual Denim Light Blue Shirt", "Highlander Men's Printed Casual Black Shirt", "French Connection Men's Checkered Casual Orange Shirt", "Arrow Men's Checkered Casual Red Shirt", "Brooklyn Blues Men's Solid Casual Purple Shirt", "Highlander Men's Printed Casual Maroon, White Shirt", "Highlander Men's Printed Casual Maroon Shirt", "U.S. Polo Assn. Men's Striped Casual Pink Shirt"};
    String[] desc_string = {"OffersNo Cost EMI & 1 More", "OffersNo Cost EMI & 3 More", "OffersNo Cost EMI", "Offers", "OffersNo Cost EMI & 1 More", "OffersNo Cost EMI & 4 More", "OffersNo Cost EMI", "OffersNo Cost EMI & 1 More", "OffersNo Cost EMI & 2 More"};
    String[] rating_string = {"4.1", "3.2", "4.4", "4.1", "4.4", "3.0", "3.8", "3.5", "4.5"};
    String[] price_string = {"999", "750", "1200", "1100", "600", "350", "799", "815", "1300"};
    int[] img = {R.drawable.singam1, R.drawable.singam2, R.drawable.singam3, R.drawable.singam4, R.drawable.singam5, R.drawable.singam6, R.drawable.singam7, R.drawable.singam8, R.drawable.singam9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        search_layout = (LinearLayout) findViewById(R.id.search_layout);
        search_layout.setVisibility(View.GONE);

        main_list = (ListView) findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter();
        main_list.setAdapter(adapter);

        search_et = (EditText) findViewById(R.id.searchbar);
        search_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Toast.makeText(MainActivity.this, "App in offline mode ;)\n\nContact developer for searching " + search_et.getText(), Toast.LENGTH_SHORT).show();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.search)
            if (search_layout.getVisibility() == View.GONE)
                search_layout.setVisibility(View.VISIBLE);
            else
                search_layout.setVisibility(View.GONE);

        if (id == R.id.fav)
            Toast.makeText(MainActivity.this, "Thanks for that click <3", Toast.LENGTH_SHORT).show();

        if (id == R.id.cart)
            Toast.makeText(MainActivity.this, "Sorry offline", Toast.LENGTH_SHORT).show();
        if (id == android.R.id.home)
            Toast.makeText(MainActivity.this, "press back button :)", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return title_string.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.custom_list, null);

            ImageView img_view = (ImageView) convertView.findViewById(R.id.img_id);
            TextView title = (TextView) convertView.findViewById(R.id.title_id);
            TextView desc = (TextView) convertView.findViewById(R.id.desc_id);
            TextView rating = (TextView) convertView.findViewById(R.id.rating_id);
            TextView price = (TextView) convertView.findViewById(R.id.price_id);

            img_view.setImageResource(img[position]);
            title.setText(title_string[position]);
            desc.setText(desc_string[position]);
            rating.setText(rating_string[position]);
            price.setText(price.getText() + price_string[position]);

            return convertView;
        }
    }
}
