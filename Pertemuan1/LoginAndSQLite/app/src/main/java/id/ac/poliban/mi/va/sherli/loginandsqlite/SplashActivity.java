package id.ac.poliban.mi.va.sherli.loginandsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //tunda eksekusi selama 300 ms (3 detik)
        new Handler(Looper.myLooper()).postDelayed(() -> {
            //jalankan activity LoginActivity
            startActivity(new Intent(this, LoginActivity.class));
            finish(); //hancurkan SpalshActivity
        }, 3000); //3 detik
    }
}