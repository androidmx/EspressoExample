package com.ggg.espressoexample.login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ggg.espressoexample.home.HomeActivity;
import com.ggg.espressoexample.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Login.View{

    public static final String BUNDLE_EMAIL = "BUNDLE_EMAIL";
    private TextInputLayout inputEmail;
    private EditText editEmail;
    private Button buttonNext;
    private Login.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.input_email);
        editEmail = findViewById(R.id.edit_email);
        buttonNext = findViewById(R.id.button_next);
        buttonNext.setOnClickListener(this);
        presenter = new LoginPresenter(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_next:
                presenter.validaUser(getUserName());
                break;
        }
    }

    /**
     * LoginView methods
     * **/

    @Override
    public void usuarioValido() {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        //homeIntent.putExtra(BUNDLE_EMAIL, email);
        startActivity(homeIntent);
    }

    @Override
    public void error() {
        Toast.makeText(this, R.string.error_login_failed, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void usuarioVacio() {
        inputEmail.setError(getString(R.string.error_empty_email));
    }

    @Override
    public String getUserName() {
        return editEmail.getText().toString();
    }
}
