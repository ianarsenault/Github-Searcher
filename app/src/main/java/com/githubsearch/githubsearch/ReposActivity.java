package com.githubsearch.githubsearch;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.provider.Settings.System.DATE_FORMAT;
import static com.githubsearch.githubsearch.R.layout.item_listview_row;


public class ReposActivity extends AppCompatActivity {

    private ImageView profilePicture;
    private TextView username;
    private JSONArray repoArray;

    private static final String KEY_NAME = "name";
    private static final String KEY_FULLNAME = "full_name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_REPO_URL = "svn_url";
    private static final String KEY_LAST_UPDATE = "pushed_at";
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_FORKS_COUNT = "forks_count";

    private String repoName;
    private String repoFullName;
    private String repoDescription;
    private String repoUrl;
    private String lastRepoUpdate;
    private String repoLanguage;
    private int repoForksCount;

    ImageView image;



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


        // TODO Format Last Repo Update DATE TIME!!!!

        username.setText("@" + loginId);

        final ArrayList<RepoInformation> myRepoList = new ArrayList<RepoInformation>();

        for (int i = 0; i < repoArray.length(); i++) {
            try {
                JSONObject json_repo = repoArray.getJSONObject(i);
                repoName = json_repo.getString(KEY_NAME);
                repoFullName = json_repo.getString(KEY_FULLNAME);
                repoDescription = json_repo.getString(KEY_DESCRIPTION);
                repoUrl = json_repo.getString(KEY_REPO_URL);
                lastRepoUpdate = json_repo.getString(KEY_LAST_UPDATE);
                repoForksCount = json_repo.getInt(KEY_FORKS_COUNT);
                repoLanguage = json_repo.getString(KEY_LANGUAGE);

                // "2017-09-10T11:47:09Z"
                String newLastRepoUpdate = "Updated: " + lastRepoUpdate.substring(11,19) + " on " + lastRepoUpdate.substring(0, 10);

                myRepoList.add(new RepoInformation(repoName, repoDescription, repoUrl, newLastRepoUpdate, repoForksCount, repoLanguage));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        RepoInformationAdapter adapter = new RepoInformationAdapter(getApplicationContext(),
                item_listview_row, myRepoList);

        ListView repoResults = (ListView) findViewById(R.id.listViewRepo);
        repoResults.setAdapter(adapter);

        repoResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Get each items repo url here on click
                final TextView tv = (TextView) view.findViewById(R.id.tvRepoUrl);
                String repositoryURL = tv.getText().toString();
                //Toast.makeText(getApplicationContext(), repositoryURL, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(repositoryURL));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    startActivity(intent);
                }
            }
        });

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
