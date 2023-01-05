package id.ac.poliban.mi.va.sherli.codingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_first, bt_second, bt_third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_first = findViewById(R.id.bt_first);
        bt_first.setOnClickListener(this);

        bt_second = findViewById(R.id.bt_second);
        bt_second.setOnClickListener(this);

        bt_third = findViewById(R.id.bt_third);
        bt_third.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_first:
                Intent m1 = new Intent(this, FirstActivity.class);
                startActivity(m1);
                break;
            case R.id.bt_second:
                Intent m2 = new Intent(this, SecondActivity.class);
                startActivity(m2);
                break;
            case R.id.bt_third:
                Intent m3 = new Intent(this, ThirdActivity.class);
                startActivity(m3);
                break;
        }
    }

}