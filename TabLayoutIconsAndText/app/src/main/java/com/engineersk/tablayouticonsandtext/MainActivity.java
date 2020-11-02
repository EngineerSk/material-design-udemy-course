package com.engineersk.tablayouticonsandtext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    public static final int RECENTS_TAB_INDEX = 0;
    public static final int FAVORITES_TAB_INDEX = 1;
    private static final int NEARBY_TAB_INDEX = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialToolbar toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tab_layout_id);
        ViewPager viewPager = findViewById(R.id.view_pager_id);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new RecentsFragment(),
                getResources().getString(R.string.recents_fragment));
        viewPagerAdapter.addFragment(new FavoritesFragment(),
                getResources().getString(R.string.favorites_fragment));
        viewPagerAdapter.addFragment(new NearbyFragment(),
                getResources().getString(R.string.nearby_fragment));

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(RECENTS_TAB_INDEX).setIcon(R.drawable.ic_baseline_phone_48);
        tabLayout.getTabAt(FAVORITES_TAB_INDEX).setIcon(R.drawable.ic_baseline_favorite_48);
        tabLayout.getTabAt(NEARBY_TAB_INDEX).setIcon(R.drawable.ic_baseline_account_box_48);
    }
}