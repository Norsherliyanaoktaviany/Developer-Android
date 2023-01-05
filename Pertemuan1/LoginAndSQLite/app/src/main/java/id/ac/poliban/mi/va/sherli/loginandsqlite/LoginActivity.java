package id.ac.poliban.mi.va.sherli.loginandsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import id.ac.poliban.mi.va.sherli.loginandsqlite.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    public static final String SP_FILE = "login_sp";
    private ActivityLoginBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.tvRegister.setOnClickListener(this::doRegister);
        b.btLogin.setOnClickListener(this::doLogin);
    }

    private void doLogin(View view) {
        if (b.etUsername.getText().toString().isEmpty() ||
                b.etPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "Username dan password tidak boleh kosong!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sp = getSharedPreferences(SP_FILE, MODE_PRIVATE);
        String username = sp.getString("username", null);
        String password = sp.getString("password", null);

        if (b.etUsername.getText().toString().equals(username) ||
                b.etPassword.getText().toString().equals(password)) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("loginStatus", true);

            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        else
            Toast.makeText(this, "Username atau password tidak cocok",
                    Toast.LENGTH_SHORT).show();
    }

    private void doRegister(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (fileSharedPreferencesExists()) {
            b.tvNotAMember.setVisibility(View.GONE);
            b.tvRegister.setVisibility(View.GONE);
        }
    }

    private boolean fileSharedPreferencesExists() {
        File file = new File(getApplicationContext().getApplicationInfo().dataDir +
                "/shared_prefs/", SP_FILE + ".xml");
        return file.exists();
    }

}