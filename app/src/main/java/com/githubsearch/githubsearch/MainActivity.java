package com.githubsearch.githubsearch;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.R.attr.type;
import static android.R.id.message;
import static android.support.design.widget.Snackbar.make;
import static com.githubsearch.githubsearch.R.id.layoutxx;
import static com.githubsearch.githubsearch.R.id.snackbar_action;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 10;
    private EditText githubUsername;
    private FloatingActionButton searchBtn;
    private ProgressBar progressBar;
    private String profileUrl;
    private String repoUrl;
    private String starsUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.github_icon);
        setSupportActionBar(toolbar);

        githubUsername = (EditText) findViewById(R.id.editTextGithubUsernameSearch);
        searchBtn = (FloatingActionButton) findViewById(R.id.floatingActionButtonSearch);
        progressBar = (ProgressBar) findViewById(R.id.progressBarCircle);

        progressBar.setVisibility(View.INVISIBLE);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = githubUsername.getText().toString();
                profileUrl = "https://api.github.com/users/" + username;
                repoUrl = "https://api.github.com/users/" + username + "/repos";
                starsUrl = "https://api.github.com/users/" + username + "/starred";
                if (username.isEmpty()) {

                    Snackbar snackbar = Snackbar.make(MainActivity.this.findViewById(android.R.id.content), "You must enter a Github Username!", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null);
                    snackbar.show();
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blankUsernameColor));
                    TextView tv = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                    tv.setGravity(Gravity.CENTER_HORIZONTAL);

                } else {
                    new RetrieveProfileInfo().execute(profileUrl);
                }
            }
        });

    }


    private class RetrieveProfileInfo extends AsyncTask<String, Void, JSONObject[]> {

        private Exception exception;

        protected void onPreExecute() {
            // Show progress bar
            progressBar.setVisibility(View.VISIBLE);
        }

        protected JSONObject[] doInBackground(String... urls) {
            JSONParser jsonParser = new JSONParser();
            String urlProfile = urls[0];


            JSONObject[] jsons = new JSONObject[1];
            jsons[0] = jsonParser.getJSONFromUrl(urlProfile);

            return jsons;

        }

        protected void onPostExecute(JSONObject[] jsons) {
            if (jsons[0] == null) {
                Snackbar snackbar = Snackbar.make(MainActivity.this.findViewById(android.R.id.content), "That user name does not exist!", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null);
                snackbar.show();
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                TextView tv = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                tv.setGravity(Gravity.CENTER_HORIZONTAL);


                // Set progress bar invisible
                progressBar.setVisibility(View.INVISIBLE);

                return;
            }

            String response = jsons.toString();
            JSONObject githubProfile = jsons[0];

            // Set progress bar invisible
            progressBar.setVisibility(View.INVISIBLE);


//            int maxLogSize = 2000;
//            for (int i = 0; i <= githubRepos.toString().length() / maxLogSize; i++) {
//                int start = i * maxLogSize;
//                int end = (i + 1) * maxLogSize;
//                end = end > githubRepos.toString().length() ? githubRepos.toString().length() : end;
//                android.util.Log.d("REPOS RESPONSE", githubRepos.toString().substring(start, end));
//            }
//
//            for (int i = 0; i <= githubStars.toString().length() / maxLogSize; i++) {
//                int start = i * maxLogSize;
//                int end = (i + 1) * maxLogSize;
//                end = end > githubStars.toString().length() ? githubStars.toString().length() : end;
//                android.util.Log.d("STARS RESPONSE", githubStars.toString().substring(start, end));
//            }


            Log.i("INFO", response);
            Log.i("PROFILE RESPONSE ", githubProfile.toString());

            // Create intent to pass json object and Urls to Profile page
            Intent i = new Intent(getApplicationContext(), com.githubsearch.githubsearch.Profile.class);
            i.putExtra("profilekey", githubProfile.toString());
            i.putExtra("repoUrl", repoUrl);
            i.putExtra("starsUrl", starsUrl);
            startActivityForResult(i, REQUEST_CODE);

        }
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
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
