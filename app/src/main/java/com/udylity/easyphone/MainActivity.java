package com.udylity.easyphone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    String prompt = "Testing";
    static final int check = 1234;

    // For variables
    Button appbutton, weather, searchfornewapps;
    ImageButton phone, email, browser, texting, voicebutton;

    // Home and back buttons
    private boolean mHomeDown;
    private boolean mBackDown;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup() {
        phone = (ImageButton) findViewById(R.id.phonebutton);
        texting = (ImageButton) findViewById(R.id.textingbutton);
        browser = (ImageButton) findViewById(R.id.internetbutton);
        email = (ImageButton) findViewById(R.id.emailbutton);
        weather = (Button) findViewById(R.id.weatherbutton);
        appbutton = (Button) findViewById(R.id.applicationsbutton);
        searchfornewapps = (Button) findViewById(R.id.searchforappsonmarket);
        phone.setOnClickListener(this);
        texting.setOnClickListener(this);
        browser.setOnClickListener(this);
        email.setOnClickListener(this);
        appbutton.setOnClickListener(this);
        weather.setOnClickListener(this);
        searchfornewapps.setOnClickListener(this);
    }

    public void onClick(View v) {
        // Sets up on click messages
        switch (v.getId()) {

            case R.id.phonebutton:
                Intent phoneIntent = new Intent(this, Phonedialer.class);
                startActivity(phoneIntent);
                break;

            case R.id.textingbutton:
                break;

            case R.id.internetbutton:
                Intent webbrowserIntent = new Intent(this, Browser.class);
                startActivity(webbrowserIntent);
                break;

            case R.id.emailbutton:
                Intent emailIntent = new Intent(this, Email.class);
                startActivity(emailIntent);
                break;

            case R.id.applicationsbutton:
                // Intent appsIntent = new Intent (Startpage.this, Apps.class);
                // startActivity(appsIntent);
                break;

            case R.id.weatherbutton:
                Intent weatherIntent = new Intent(this, Weather.class);
                startActivity(weatherIntent);
                break;

            case R.id.searchforappsonmarket:

                break;

        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    mBackDown = true;
                    return true;
                case KeyEvent.KEYCODE_HOME:
                    mHomeDown = true;
                    return true;
            }
        } else if (event.getAction() == KeyEvent.ACTION_UP) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    if (!event.isCanceled()) {
                        // Do BACK behavior.
                    }
                    mBackDown = true;
                    return true;
                case KeyEvent.KEYCODE_HOME:
                    if (!event.isCanceled()) {
                        // Do HOME behavior.
                    }
                    mHomeDown = true;
                    return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!hasFocus) {
            mBackDown = mHomeDown = false;
        }
    }

}
