/**
 * Github API Calls
 * <p>
 * <p>
 * Get repos list
 * "https://api.github.com/users/gorgonsmaze/repos"
 * <p>
 * Get starred list
 * "https://api.github.com/users/gorgonsmaze/starred"
 **/

/** "https://api.github.com/users/gorgonsmaze/repos" request produces
 *
 {
     "id": 73977017,
     "name": "ripta-api",
     "full_name": "GorgonsMaze/ripta-api",
     "owner": {
     "login": "GorgonsMaze",
     "id": 12011826,
     "avatar_url": "https://avatars3.githubusercontent.com/u/12011826?v=4",
     "gravatar_id": "",
     "url": "https://api.github.com/users/GorgonsMaze",
     "html_url": "https://github.com/GorgonsMaze",
     "followers_url": "https://api.github.com/users/GorgonsMaze/followers",
     "following_url": "https://api.github.com/users/GorgonsMaze/following{/other_user}",
     "gists_url": "https://api.github.com/users/GorgonsMaze/gists{/gist_id}",
     "starred_url": "https://api.github.com/users/GorgonsMaze/starred{/owner}{/repo}",
     "subscriptions_url": "https://api.github.com/users/GorgonsMaze/subscriptions",
     "organizations_url": "https://api.github.com/users/GorgonsMaze/orgs",
     "repos_url": "https://api.github.com/users/GorgonsMaze/repos",
     "events_url": "https://api.github.com/users/GorgonsMaze/events{/privacy}",
     "received_events_url": "https://api.github.com/users/GorgonsMaze/received_events",
     "type": "User",
     "site_admin": false
    },
     "private": false,
     "html_url": "https://github.com/GorgonsMaze/ripta-api",
     "description": null,
     "fork": true,
     "url": "https://api.github.com/repos/GorgonsMaze/ripta-api",
     "forks_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/forks",
     "keys_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/keys{/key_id}",
     "collaborators_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/collaborators{/collaborator}",
     "teams_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/teams",
     "hooks_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/hooks",
     "issue_events_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/issues/events{/number}",
     "events_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/events",
     "assignees_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/assignees{/user}",
     "branches_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/branches{/branch}",
     "tags_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/tags",
     "blobs_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/git/blobs{/sha}",
     "git_tags_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/git/tags{/sha}",
     "git_refs_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/git/refs{/sha}",
     "trees_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/git/trees{/sha}",
     "statuses_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/statuses/{sha}",
     "languages_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/languages",
     "stargazers_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/stargazers",
     "contributors_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/contributors",
     "subscribers_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/subscribers",
     "subscription_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/subscription",
     "commits_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/commits{/sha}",
     "git_commits_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/git/commits{/sha}",
     "comments_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/comments{/number}",
     "issue_comment_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/issues/comments{/number}",
     "contents_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/contents/{+path}",
     "compare_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/compare/{base}...{head}",
     "merges_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/merges",
     "archive_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/{archive_format}{/ref}",
     "downloads_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/downloads",
     "issues_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/issues{/number}",
     "pulls_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/pulls{/number}",
     "milestones_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/milestones{/number}",
     "notifications_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/notifications{?since,all,participating}",
     "labels_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/labels{/name}",
     "releases_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/releases{/id}",
     "deployments_url": "https://api.github.com/repos/GorgonsMaze/ripta-api/deployments",
     "created_at": "2016-11-17T01:18:15Z",
     "updated_at": "2016-12-02T22:53:23Z",
     "pushed_at": "2017-09-10T11:47:09Z",
     "git_url": "git://github.com/GorgonsMaze/ripta-api.git",
     "ssh_url": "git@github.com:GorgonsMaze/ripta-api.git",
     "clone_url": "https://github.com/GorgonsMaze/ripta-api.git",
     "svn_url": "https://github.com/GorgonsMaze/ripta-api",
     "homepage": null,
     "size": 10357,
     "stargazers_count": 0,
     "watchers_count": 0,
     "language": "JavaScript",
     "has_issues": false,
     "has_projects": true,
     "has_downloads": true,
     "has_wiki": true,
     "has_pages": false,
     "forks_count": 1,
     "mirror_url": null,
     "open_issues_count": 0,
     "forks": 1,
     "open_issues": 0,
     "watchers": 0,
     "default_branch": "master"
 }

 **/

package com.githubsearch.githubsearch;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import static android.R.attr.drawable;
import static android.R.attr.height;
import static android.R.attr.width;
import static android.os.Build.VERSION_CODES.O;

public class Profile extends AppCompatActivity {
    private static final int REQUEST_CODE = 10;
    private TextView varDumpDisplay;
    private ImageView profilePicture;
    private TextView username;
    private TextView name;
    private TextView location;
    private TextView following;
    private TextView followers;
    private Button btnRepos;
    private Button btnStars;

    private FloatingActionButton chromeBtn;

    private static final String KEY_AVATAR = "avatar_url";
    private static final String KEY_LOGIN = "login";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_NAME = "name";
    private static final String KEY_FOLLOWING = "following";
    private static final String KEY_FOLLOWERS = "followers";
    private static final String KEY_NUM_OF_REPOS = "public_repos";
    private static final String KEY_HTML_URL = "html_url";
    private static final String KEY_STARRED_URL = "starred_url";
    private static final String KEY_REPOS_URL = "repos_url";
    private static final String KEY_MEMBER_SINCE = "created_at";

    // Key Value variables
    private String profileUrl;
    private String avatarUrl;
    private String login;
    private String fullname;
    private String lction;
    private int gFollowers;
    private int gFollowing;
    private String gEmail;
    private int gNumberOfRepos;

    JSONArray repoArray;
    JSONArray starsArray;
//    private String repoJsonArrayString;
//    private String starsJsonArrayString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.github_icon);
        setSupportActionBar(toolbar);


        // set variables by IDs
        profilePicture = (ImageView) findViewById(R.id.imageViewProfilePicture);
        username = (TextView) findViewById(R.id.textViewUsername);
        name = (TextView) findViewById(R.id.textViewName);
        location = (TextView) findViewById(R.id.textViewLocation);
        following = (TextView) findViewById(R.id.textViewFollowing);
        followers = (TextView) findViewById(R.id.textViewFollowers);
        btnRepos = (Button) findViewById(R.id.buttonRepos);
        btnStars = (Button) findViewById(R.id.buttonStars);

        btnRepos.setEnabled(false);
        btnStars.setEnabled(false);

        Intent i = getIntent();
        String profileJsonString = i.getStringExtra("profilekey");
        String profileRepoUrl = i.getStringExtra("repoUrl");
        String profileStarsUrl = i.getStringExtra("starsUrl");

        // Make call to API for Repos and Stars
        new RetrieveRepoAndStarInfo().execute(profileRepoUrl, profileStarsUrl);

//        Toast.makeText(this, profileRepoUrl + " " + profileStarsUrl, Toast.LENGTH_LONG).show();

        try {
            JSONObject profileObj = new JSONObject(profileJsonString);

//            Log.i("Repo size: ", String.valueOf(repoArray.length()));
//            Log.i("Stars size: ", String.valueOf(starsArray.length()));

//            Log.i("Repo Array", repoArray.toString());

            profileUrl = profileObj.getString(KEY_HTML_URL);
            avatarUrl = profileObj.getString(KEY_AVATAR);
            login = profileObj.getString(KEY_LOGIN);
            fullname = profileObj.getString(KEY_NAME);
            lction = profileObj.getString(KEY_LOCATION);
            gFollowers = profileObj.getInt(KEY_FOLLOWERS);
            gFollowing = profileObj.getInt(KEY_FOLLOWING);
            gEmail = profileObj.getString(KEY_EMAIL);
            gNumberOfRepos = profileObj.getInt(KEY_NUM_OF_REPOS);


        } catch (JSONException e) {
            Log.e("My App: ", "unexpected JSON Exception", e);
        }



        // DISPLAY DATA
        // Using Picasso lib to load profile image
        Picasso.with(this)
                .load(avatarUrl)
                .error(R.drawable.profilepicture)
                .into(profilePicture);

        // TODO ERROR HANDLE FOR NULL OR BLANK RETURNS

        username.setText("@" + login);
        name.setText(fullname);
        location.setText(lction);
        followers.setText("Followers: " + String.valueOf(gFollowers));
        following.setText("Following: " + String.valueOf(gFollowing));
        btnRepos.setText("Repos - " + String.valueOf(gNumberOfRepos));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabChrome);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlString = "http://www.github.com"; // test url string
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(profileUrl));
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

        btnRepos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /** TOAST CENTERED ON TOP EXAMPLE **/
//                Toast toast=Toast.makeText(getApplicationContext(),"This is advanced toast",Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.TOP | Gravity.CENTER,0,171);
//                View v=toast.getView();
//                TextView  view1=(TextView)v.findViewById(android.R.id.message);
//                v.setBackgroundResource(R.color.blankUsernameColor);
//                toast.show();

                if (repoArray.length() > 0) {

                    // TODO SEND repoArray over through INTENT new Fragment OR Activity
                    Intent i = new Intent(getApplicationContext(), com.githubsearch.githubsearch.ReposActivity.class);
                    i.putExtra("profileimage", avatarUrl);
                    i.putExtra("userid", login);
                    i.putExtra("reposarray", repoArray.toString());
                    startActivityForResult(i, REQUEST_CODE);

//                    Toast toast = Toast.makeText(getApplicationContext(), "There are " + String.valueOf(repoArray.length()), Toast.LENGTH_SHORT);
//                    toast.show();
                }
                else {
                    Snackbar snackbar = Snackbar.make(Profile.this.findViewById(android.R.id.content), "Looks like this user has no repos!", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null);
                    snackbar.show();
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blankUsernameColor));
                    TextView tv = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                    tv.setGravity(Gravity.CENTER_HORIZONTAL);
                }

            }
        });


        btnStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (starsArray.length() > 0) {

                    // TODO SEND starsArray over through INTENT new Fragment OR Activity
                    Intent i = new Intent(getApplicationContext(), com.githubsearch.githubsearch.StarsActivity.class);
                    i.putExtra("profileimage", avatarUrl);
                    i.putExtra("userid", login);
                    i.putExtra("starsarray", starsArray.toString());
                    startActivityForResult(i, REQUEST_CODE);
//
//                    Toast toast = Toast.makeText(getApplicationContext(), "There are " + String.valueOf(starsArray.length()), Toast.LENGTH_SHORT);
//                    toast.show();
                }
                else {
                    Snackbar snackbar = Snackbar.make(Profile.this.findViewById(android.R.id.content), "Looks like this user has no starred repos!", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null);
                    snackbar.show();
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blankUsernameColor));
                    TextView tv = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                    tv.setGravity(Gravity.CENTER_HORIZONTAL);
                }

            }
        });


        ((ImageButton) findViewById(R.id.imageButtonEmail)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // TODO: ADD BACKGROUND/BORDER COLOR TO IMAGE
//                        Toast toast = Toast.makeText(getApplicationContext(), "EMAIL BUTTON PRESSED" , Toast.LENGTH_SHORT);
//                        toast.show();
//                        ImageButton imgView = (ImageButton ) view;
//                        imgView.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                        view.invalidate();
                        break;

                    case MotionEvent.ACTION_UP:
                        if (gEmail.equals("null")) {
                            Snackbar snackbar = Snackbar.make(Profile.this.findViewById(android.R.id.content), "No email for @" + login, Snackbar.LENGTH_SHORT)
                                    .setAction("Action", null);
                            snackbar.show();
                            View snackbarView = snackbar.getView();
                            snackbarView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                            TextView tv = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                            tv.setGravity(Gravity.CENTER_HORIZONTAL);

                        } else {

                            // TODO OPEN UP USER EMAIL APPLICATION => PASS EMAIL
                            Toast emailToast = Toast.makeText(getApplicationContext(), gEmail, Toast.LENGTH_SHORT);
                            emailToast.show();
                        }

                        break;

                    case MotionEvent.ACTION_CANCEL:
                        ImageButton imgView = (ImageButton) view;
                        imgView.getBackground().clearColorFilter();
                        imgView.invalidate();
                        break;

                }
                return false;
            }
        });


    }


    private class RetrieveRepoAndStarInfo extends AsyncTask<String, Void, JSONArray[]> {

        private Exception exception;

        protected void onPreExecute() {
            // Show progress bar
            //progressBar.setVisibility(View.VISIBLE);
        }

        protected JSONArray[] doInBackground(String... urls) {
            JSONParser jsonParser = new JSONParser();
            String urlRepo = urls[0];
            String urlStars = urls[1];

            JSONArray[] jsons = new JSONArray[2];
            jsons[0] = jsonParser.getJSONArrayFromUrl(urlRepo);
            jsons[1] = jsonParser.getJSONArrayFromUrl(urlStars);

            return jsons;

        }

        protected void onPostExecute(JSONArray[] jsons) {
            if (jsons[0] == null) {
                // Set progress bar invisible
                //progressBar.setVisibility(View.INVISIBLE);
                return;
            }

            // Enable buttons
            btnRepos.setEnabled(true);
            btnStars.setEnabled(true);

            String response = jsons.toString();
            repoArray = jsons[0];
            starsArray = jsons[1];


            Log.i("LENGTH OF REPO ARRAY: ", String.valueOf(repoArray.length()));
            Log.i("LENGHT OF STARS ARRAY: ", String.valueOf(starsArray.length()));
            Log.i("REPOS RESPONSE ", repoArray.toString());
            Log.i("STARS RESPONSE", starsArray.toString());

            Toast.makeText(getApplicationContext(), "Repo length: " + String.valueOf(repoArray.length()), Toast.LENGTH_SHORT).show();


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
