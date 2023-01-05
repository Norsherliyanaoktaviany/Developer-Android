package id.ac.poliban.mi.va.sherli.loginandsqlite;

import static id.ac.poliban.mi.va.sherli.loginandsqlite.LoginActivity.SP_FILE;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import id.ac.poliban.mi.va.sherli.loginandsqlite.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding b;


    @RequiresApi(api = Build.VERSION_CODES.ECLAIR_0_1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.etRegBornDate.setOnClickListener(this::showDatePickerDialog);
        b.btRegRegister.setOnClickListener(this::doRegister);
    }

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR_0_1)
    private void showDatePickerDialog(View view) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy",
                Locale.getDefault());
        Calendar mCalendar = Calendar.getInstance();
        new DatePickerDialog(this,
                (datePicker, year, month, dayOfMonth) -> {
                  Calendar newDate = Calendar.getInstance();
                  newDate.set(year, month, dayOfMonth);
                  b.etRegBornDate.setText(sdf.format(newDate.getTime()));
                },
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void doRegister(View view) {
        if (b.etRegName.getText().toString().isEmpty() ||
                b.etRegUsername.getText().toString().isEmpty() ||
                b.etRegPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "Name, username atau password tidak boleh kosong",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sp = getSharedPreferences(SP_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", b.etRegName.getText().toString());
        editor.putString("born place", b.etRegBornPlace.getText().toString());
        editor.putString("born date", b.etRegBornDate.getText().toString());
        editor.putString("username", b.etRegUsername.getText().toString());
        editor.putString("password", b.etRegPassword.getText().toString());
        editor.putBoolean("loginStatus", false);
        editor.apply();

        finish();
    }

}