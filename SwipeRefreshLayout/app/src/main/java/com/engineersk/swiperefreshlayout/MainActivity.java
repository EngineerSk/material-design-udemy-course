package com.engineersk.swiperefreshlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private WebView mWebView;
    private WebViewClient mWebViewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_id);
        mWebView = findViewById(R.id.web_view_id);

        mWebView.loadUrl("https://www.google.com");

        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            Log.d(TAG, "onCreate: reload...");
            mWebView.reload();
        });
        mWebViewClient = new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d(TAG, "onPageFinished: ");
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                Log.d(TAG, "onPageCommitVisible: ");
                mSwipeRefreshLayout.setColorSchemeResources(R.color.color_finish_refresh);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                Log.d(TAG, "onLoadResource: ");
                mSwipeRefreshLayout.setColorSchemeResources(R.color.color_load_refresh);
            }
        };

        mWebView.setWebViewClient(mWebViewClient);
    }
}