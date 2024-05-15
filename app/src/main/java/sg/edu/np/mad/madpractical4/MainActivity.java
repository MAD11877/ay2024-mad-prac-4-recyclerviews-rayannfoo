package sg.edu.np.mad.madpractical4;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private boolean followed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // initialise user
        User user = new User("MAD", "MAD Developer", 1, false);

        // Get textviews and button from the layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDesc = findViewById(R.id.tvDesc);
        Button btnFollow = findViewById(R.id.Button1);

        Random random = new Random();

        // Generate a random number within the range of 10 digits
        long max = 9999999999L; // 10^10 - 1
        long number = random.nextLong() % (max + 1);

        tvName.setText(user.name + " " + number);
        btnFollow.setText("Follow");


        btnFollow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i(TAG, "follow button pressed");

                // Toggle text and update followed variable
                if (followed) {
                    btnFollow.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                } else {
                    btnFollow.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }
                followed = !followed;
            }
        });

    }
}