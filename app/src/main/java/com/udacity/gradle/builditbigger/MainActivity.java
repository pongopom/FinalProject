package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.activitylibrary.JokeActivity;
import com.example.android.jokelibrary.JokeClass;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Step 3: Setup GCE
    public void tellJoke(View view) {
        new FetchAJoke() {
            @Override
            protected void onPostExecute(String s) {
                if (s != null) {
                    Intent intent = new Intent(MainActivity.this, JokeActivity.class);
                    intent.putExtra(Intent.EXTRA_TEXT, JokeClass.pickAJoke());
                    MainActivity.this.startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Unable to fetch a joke make sure the server is running", Toast.LENGTH_LONG).show();
                }
            }
        }.execute();

       // STEP 2 uncomment the code below to directaly call the jokeLibrary you will need to comment out the code above as well
      //  Intent intent = new Intent(this, JokeActivity.class);
      //   intent.putExtra(JokeActivity.JOKE_INTENT_KEY, JokeClass.pickAJoke());
      //   this.startActivity(intent);

      //  STEP 1 uncomment the line below to see a toast this code was used in step 1 of the project
      //   Toast.makeText(this, JokeClass.pickAJoke(), Toast.LENGTH_SHORT).show();
    }
}
















