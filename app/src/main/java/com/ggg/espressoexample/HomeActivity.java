package com.ggg.espressoexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvEmail = findViewById(R.id.tv_email);

        String email = getIntent().getStringExtra(LoginActivity.BUNDLE_EMAIL);

        if (email != null)
            tvEmail.setText(email);

    }
}
