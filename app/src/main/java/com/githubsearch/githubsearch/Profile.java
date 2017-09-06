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

    private static final String KEY_AVATAR = "avatar_url";
    private static final String KEY_LOGIN = "login";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_BLOG = "blog";
    private static final String KEY_NAME = "name";
    private static final String KEY_FOLLOWING = "following";
    private static final String KEY_FOLLOWERS = "followers";
    private static final String KEY_NUM_OF_REPOS = "public_repos";
    private static final String KEY_SITE_URL = "url";
    private static final String KEY_STARRED_URL = "starred_url";
    private static final String KEY_REPOS_URL = "repos_url";
    private static final String KEY_MEMBER_SINCE = "created_at";

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
            Log.d("My App: ",jObj.toString());
            // Display unordered JSON
            varDumpDisplay.setText(jObj.toString().replace("\\",""));

        } catch (JSONException e) {
            Log.e("My App: ", "unexpected JSON Exception", e);
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
