package com.githubsearch.githubsearch;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.githubsearch.githubsearch.R.id.layoutxx;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 10;
    private EditText githubUsername;
    private FloatingActionButton searchBtn;
    private ProgressBar progressBar;

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
                String profileUrl = "https://api.github.com/users/" + username;
                String repoUrl = "https://api.github.com/users/" + username + "/repos";
                String starUrl = "https://api.github.com/users/" + username + "/starred";
                if (username.isEmpty()) {
                    Snackbar.make(view, "You must enter a Github Username!", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                } else {
                    new RetrieveUserInfo().execute(profileUrl);
                }
            }
        });

    }



    private class RetrieveUserInfo extends AsyncTask<String, Void, String> {

        private Exception exception;

        protected void onPreExecute() {
//            githubUsername.setText("");
            // Show loader spinning or something
            progressBar.setVisibility(View.VISIBLE);
        }

        protected String doInBackground(String... args) {
            String urlProfile = args[0];
            // Do some validation here

            try {
                URL url = new URL(urlProfile);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                }
                finally{
                    urlConnection.disconnect();
                }
            }
            catch(Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {

            progressBar.setVisibility(View.INVISIBLE);

            if(response == null) {
//                response = "THERE WAS AN ERROR";

//                Toast.makeText(getApplicationContext(),"That user name does not exist", Toast.LENGTH_LONG).show();

                Snackbar.make(MainActivity.this.findViewById(android.R.id.content), "That user name does not exist", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                return;

            } else {
                //            progressBar.setVisibility(View.GONE);
                Log.i("INFO", response);

                // Create intent to pass json object to Profile page
                Intent i = new Intent(getApplicationContext(), com.githubsearch.githubsearch.Profile.class);
                i.putExtra("profilekey", response.toString());
                startActivityForResult(i, REQUEST_CODE);
            }


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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
