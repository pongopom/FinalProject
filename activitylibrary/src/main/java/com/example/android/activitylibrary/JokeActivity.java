package com.example.android.activitylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

//Step 2: Create an Android Library

public class JokeActivity extends AppCompatActivity {

    private static final String JOKE_SAVED_KEY = "joke_saved_key";
    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        if (this.getActionBar() != null) {
            this.getActionBar().setDisplayHomeAsUpEnabled(true);
        } else if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        TextView textView = findViewById(R.id.textView);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            mJoke = intent.getStringExtra(Intent.EXTRA_TEXT);
        } else {
            mJoke = savedInstanceState.getString(JOKE_SAVED_KEY);
        }
        textView.setText(mJoke);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // save instanceState for device rotation
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(JOKE_SAVED_KEY, mJoke);
    }

}
