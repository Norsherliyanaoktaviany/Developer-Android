package id.ac.poliban.mi.va.sherli.materialme_resourcesherli;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

/***
 * Detail Activity that is launched when a list item is clicked.
 * It shows more info on the sport.
 */
public class DetailActivity extends AppCompatActivity {

    /**
     * Initializes the activity, filling in the data from the Intent.
     *
     * @param savedInstanceState Contains information about the saved state
     *                           of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getSupportActionBar()!=null) getSupportActionBar().setTitle("Material Me! Sherli Resource");

        // Initialize the views.
        TextView sportsTitle = findViewById(R.id.titleDetail);
        ImageView sportsImage = findViewById(R.id.sportsImageDetail);

        // Set the text from the Intent extra.
        sportsTitle.setText(getIntent().getStringExtra("title"));

        // Load the image using the Glide library and the Intent extra.
        Glide.with(this)
                .load(getIntent()
                        .getIntExtra("image_resource",0))
                .into(sportsImage);
    }
}
