package com.engineersk.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1_id: {
                Toast.makeText(MainActivity.this, "item 1 is selected",
                        Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.item2_id: {
                Toast.makeText(MainActivity.this, "item 2 is selected",
                        Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.item3_id: {
                Toast.makeText(MainActivity.this, "item 3 is selected",
                        Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.search_id:{
                Toast.makeText(MainActivity.this, "Search",
                        Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.cart_id:{
                Toast.makeText(MainActivity.this, "Cart",
                        Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}