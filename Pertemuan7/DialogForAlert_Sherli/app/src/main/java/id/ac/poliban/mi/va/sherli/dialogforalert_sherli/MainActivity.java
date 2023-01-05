package id.ac.poliban.mi.va.sherli.dialogforalert_sherli;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * This app shows a button to trigger a standard alert dialog.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Creates the view.
     *
     * @param savedInstanceState Saved instance state bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Handles the Alert button click. Builds the alert dialog with a title,
     * message, and OK and Cancel buttons. Also defines Toast messages to appear
     * depending on which alert button is clicked, and shows the alert dialog.
     *
     * @param view  The view in which the alert will appear.
     */
    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder =
                new AlertDialog.Builder(MainActivity.this);

        // Set the dialog title and message.
        myAlertBuilder.setTitle(R.string.alert_title);
        myAlertBuilder.setMessage(R.string.alert_message);

        // Add the dialog buttons.
        myAlertBuilder.setPositiveButton(R.string.ok_button,
                (dialog, which) -> {
                    // User clicked OK button.
                    Toast.makeText(getApplicationContext(),
                            R.string.pressed_ok,
                            Toast.LENGTH_SHORT).show();
                });

        myAlertBuilder.setNegativeButton(R.string.cancel_button,
                (dialog, which) -> {
                    // User cancelled the dialog.
                    Toast.makeText(getApplicationContext(),
                            R.string.pressed_cancel,
                            Toast.LENGTH_SHORT).show();
                });
        // Create and show the AlertDialog.
        myAlertBuilder.show();
    }
}