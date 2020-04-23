package com.example.kapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button button = findViewById(R.id.button_registration);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openRegistration();
            }
        });

    }

    void openRegistration()
    {
       Intent openregistration_intent = new Intent(this,Registration.class);
       startActivity(openregistration_intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_content,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.share_button :
                    Intent share_intent =new Intent(Intent.ACTION_SEND);
                    share_intent.setType("text/plain");
                    String share_body ="Your Body Here please click on this link http://vnit.ac.in/";
                    String share_subject="share subject";
                    share_intent.putExtra(Intent.EXTRA_TEXT,share_body).putExtra(Intent.EXTRA_SUBJECT,share_subject);

                    startActivity(Intent.createChooser(share_intent,"Share Using"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
