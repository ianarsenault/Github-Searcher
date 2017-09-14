package com.githubsearch.githubsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ReposActivity extends AppCompatActivity {

    private ImageView profilePicture;
    private TextView username;
    private JSONArray repoArray;

    private static final String KEY_NAME = "name";
    private static final String KEY_FULLNAME = "full_name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_REPO_URL = "url";
    private static final String KEY_LAST_UPDATE = "updated_at";
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_FORKS_COUNT = "forks_count";

    private String repoName;
    private String repoFullName;
    private String repoDescription;
    private String repoUrl;
    private String lastRepoUpdate;
    private String repoLanguage;
    private int repoForksCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.github_icon);
        setSupportActionBar(toolbar);


        profilePicture = (ImageView) findViewById(R.id.imageViewProfilePicture);
        username = (TextView) findViewById(R.id.textViewUsername);

        Intent intent = getIntent();
        String profileImageUrl = intent.getStringExtra("profileimage");
        String loginId = intent.getStringExtra("userid");
        String profileRepoArrayString = intent.getStringExtra("reposarray");

        try {
            repoArray = new JSONArray(profileRepoArrayString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Using Picasso lib to load profile image
        Picasso.with(this)
                .load(profileImageUrl)
                .error(R.drawable.profilepicture)
                .into(profilePicture);

        username.setText("@" + loginId);

        ListView repoResults = (ListView) findViewById(R.id.listViewRepo);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);


        for (int i = 0; i < repoArray.length(); i++) {
            try {
                JSONObject json_repo = repoArray.getJSONObject(i);
                repoName = json_repo.getString(KEY_NAME);
                repoFullName = json_repo.getString(KEY_FULLNAME);
                repoDescription = json_repo.getString(KEY_DESCRIPTION);
                repoUrl = json_repo.getString(KEY_REPO_URL);
                lastRepoUpdate = json_repo.getString(KEY_LAST_UPDATE);
                repoForksCount = json_repo.getInt(KEY_FORKS_COUNT);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            // TODO: CHECK FOR NULL VALUES - DISPLAY ACCORDINGLY

            adapter.add(repoFullName + "\n"
                    + repoDescription + "\n"
                    + lastRepoUpdate + "\n"
                    + String.valueOf(repoForksCount));


        }

        repoResults.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_repos, menu);
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
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.back_to_profile) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
