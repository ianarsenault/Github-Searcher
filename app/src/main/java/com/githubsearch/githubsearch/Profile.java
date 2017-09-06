package com.githubsearch.githubsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {

    private TextView varDumpDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.github_icon);
        setSupportActionBar(toolbar);

        varDumpDisplay = (TextView) findViewById(R.id.tvJSONResult);

        Intent i = getIntent();
        String jsonString = i.getStringExtra("profilekey");

        // Ordered JSON from Github
//        varDumpDisplay.setText(jsonString);


        try {
            JSONObject jObj = new JSONObject(jsonString);
            Log.d("My App",jObj.toString());
            // Display unordered JSON
            varDumpDisplay.setText(jObj.toString().replace("\\",""));

        } catch (JSONException e) {
            Log.e("MYAPP", "unexpected JSON Exception", e);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.back_home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
