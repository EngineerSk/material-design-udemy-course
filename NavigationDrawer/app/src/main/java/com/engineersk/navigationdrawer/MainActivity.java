package com.engineersk.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.inbox_id:{
                Toast.makeText(this, "inbox", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.starred_id:{
                Toast.makeText(this, "starred", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.send_id:{
                Toast.makeText(this, "send", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.drafts_id:{
                Toast.makeText(this, "Drafts", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.all_mail_id:{
                Toast.makeText(this, "All mail", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.trash_id:{
                Toast.makeText(this, "Trash", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.spam_id:{
                Toast.makeText(this, "Spam", Toast.LENGTH_LONG).show();
                break;
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}