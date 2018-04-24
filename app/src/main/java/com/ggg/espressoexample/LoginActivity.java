package com.ggg.espressoexample;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String BUNDLE_EMAIL = "BUNDLE_EMAIL";
    private TextInputLayout inputEmail;
    private EditText editEmail;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.input_email);
        editEmail = findViewById(R.id.edit_email);
        buttonNext = findViewById(R.id.button_next);
        buttonNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_next:
                validate();
                break;
        }
    }

    private void validate() {
        if (editEmail.getText().toString().length() > 0){
            if (editEmail.getText().toString().equalsIgnoreCase("test@ggg.com.mx")){
                goToHome(editEmail.getText().toString());
            }else {
                Toast.makeText(this, R.string.error_login_failed, Toast.LENGTH_SHORT).show();
            }

        }else {
            inputEmail.setError(getString(R.string.error_empty_email));
        }
    }

    private void goToHome(String email) {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        homeIntent.putExtra(BUNDLE_EMAIL, email);
        startActivity(homeIntent);
    }
}
