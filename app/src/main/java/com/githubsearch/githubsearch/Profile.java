/**
 *  Github API Calls
 *
 *
 *  Get repos list
 *  "https://api.github.com/users/gorgonsmaze/repos"
 *
 * Get starred list
 * "https://api.github.com/users/gorgonsmaze/starred"
 *
 */

/**
 {"received_events_url":"https://api.github.com\/users\/GorgonsMaze\/received_events",
 "organizations_url":"https:\/\/api.github.com\/users\/GorgonsMaze\/orgs",
 "avatar_url":"https:\/\/avatars3.githubusercontent.com\/u\/12011826?v=4",
 "gravatar_id":"",
 "public_gists":5,
 "location":"localhost",
 "site_admin":false,
 "blog":"https:\/\/keybase.io\/ian_a",
 "type":"User",
 "id":12011826,
 "following":19,
 "followers":11,
 "public_repos":34,
 "name":"Ian Arsenault",
 "following_url":"https:\/\/api.github.com\/users\/GorgonsMaze\/following{\/other_user}",
 "created_at":"2015-04-18T20:54:01Z",
 "events_url":"https:\/\/api.github.com\/users\/GorgonsMaze\/events{\/privacy}",
 "login":"GorgonsMaze",
 "subscriptions_url":"https:\/\/api.github.com\/users\/GorgonsMaze\/subscriptions",
 "repos_url":"https:\/\/api.github.com\/users\/GorgonsMaze\/repos",
 "gists_url":"https:\/\/api.github.com\/users\/GorgonsMaze\/gists{\/gist_id}",
 "starred_url":"https:\/\/api.github.com\/users\/GorgonsMaze\/starred{\/owner}{\/repo}",
 "url":"https:\/\/api.github.com\/users\/GorgonsMaze",
 "html_url":"https:\/\/github.com\/GorgonsMaze",
 "hireable":true,
 "updated_at":"2017-08-24T04:20:07Z",
 "bio":null,
 "email":null,
 "company":null,
 "followers_url":"https:\/\/api.github.com\/users\/GorgonsMaze\/followers"}

 **/

package com.githubsearch.githubsearch;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
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

    private TextView varDumpDisplay;
    private ImageView profilePicture;
    private TextView username;
    private TextView name;
    private TextView location;
    private TextView following;
    private TextView followers;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.github_icon);
        setSupportActionBar(toolbar);


        // set variables by IDs
        profilePicture = (ImageView) findViewById(R.id.imageViewProfilePicture);
//        varDumpDisplay = (TextView) findViewById(R.id.tvJSONResult);

        username = (TextView) findViewById(R.id.textViewUsername);
        name = (TextView) findViewById(R.id.textViewName);
        location = (TextView) findViewById(R.id.textViewLocation);
        following = (TextView) findViewById(R.id.textViewFollowing);
        followers = (TextView) findViewById(R.id.textViewFollowers);

        Intent i = getIntent();
        String jsonString = i.getStringExtra("profilekey");

        try {
            JSONObject jObj = new JSONObject(jsonString);
            int size = jObj.length();
            // Log GET
            Log.d("My App: ", jObj.toString());

            profileUrl = jObj.getString(KEY_HTML_URL);
            avatarUrl = jObj.getString(KEY_AVATAR);
            login = jObj.getString(KEY_LOGIN);
            fullname = jObj.getString(KEY_NAME);
            lction = jObj.getString(KEY_LOCATION);
            gFollowers = jObj.getInt(KEY_FOLLOWERS);
            gFollowing = jObj.getInt(KEY_FOLLOWING);
            gEmail = jObj.getString(KEY_EMAIL);



            // Using Picasso lib
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


//            varDumpDisplay.setText("Avatar URL : " + avatarUrl +"Login: " + username
//                + "\n Name: " + name);


            // Display unordered JSON


//            varDumpDisplay.setText("Lenght is " + size + "\n" + jObj.toString().replace("\\",""));

        } catch (JSONException e) {
            Log.e("My App: ", "unexpected JSON Exception", e);
        }


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



        ((ImageButton)findViewById(R.id.imageButtonEmail)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
//                        Toast toast = Toast.makeText(getApplicationContext(), "EMAIL BUTTON PRESSED" , Toast.LENGTH_SHORT);
//                        toast.show();
//                        ImageButton imgView = (ImageButton ) view;
//                        imgView.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                        view.invalidate();
                        break;

                    case MotionEvent.ACTION_UP:
                        Toast emailToast = Toast.makeText(getApplicationContext(), gEmail , Toast.LENGTH_SHORT);
                        emailToast.show();
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
