
package salatiga.app.suggestion.suggestionappadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import salatiga.app.suggestion.suggestionappadmin.ui.ListSuggestionActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView etUsername, etPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);
        initView();
    }

    private void initView() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.login){
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if(username.isEmpty()){
                etUsername.setError("Harus diisi");
                etUsername.requestFocus();
            }else if(password.isEmpty()){
                etPassword.setError("Harus diisi");
                etPassword.requestFocus();
            }else{
                if(username.equals("ADMINSDM") && password.equals("admin")){
                    Intent intent = new Intent(getApplicationContext(), ListSuggestionActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Username atau password salah", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
