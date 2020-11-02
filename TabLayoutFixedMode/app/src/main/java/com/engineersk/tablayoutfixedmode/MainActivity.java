package com.engineersk.tablayoutfixedmode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar mMaterialToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMaterialToolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(mMaterialToolbar);

        mTabLayout = findViewById(R.id.tab_layout_id);
        mViewPager = findViewById(R.id.view_pager_id);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.addFragment(new OneFragment(),
                getResources().getString(R.string.one_fragment_title));
        viewPagerAdapter.addFragment(new TwoFragment(),
                getResources().getString(R.string.two_fragment_title));
        viewPagerAdapter.addFragment(new ThreeFragment(),
                getResources().getString(R.string.three_fragment_title));

        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}