package com.hessamahmadi71d.smallapk;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView storyText;
    private Button choice1;
    private Button choice2;

    private int state = 0; // tracks where in the story we are

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyText = findViewById(R.id.storyText);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);

        updateStory();

        choice1.setOnClickListener(v -> {
            handleChoice(1);
        });

        choice2.setOnClickListener(v -> {
            handleChoice(2);
        });
    }

    private void handleChoice(int choice) {
        if (state == 0) {
            if (choice == 1) state = 1; // deeper forest
            else state = 2;             // follow path
        } else if (state == 1) {
            if (choice == 1) state = 3; // magical powers
            else state = 4;             // beast appears
        } else if (state == 2) {
            if (choice == 1) state = 5; // rest at inn
            else state = 6;             // villagers crown you
        } else {
            state = 0; // restart game
        }
        updateStory();
    }

    private void updateStory() {
        switch (state) {
            case 0:
                storyText.setText("🌲 You wake up in a mysterious forest.\nDo you want to:\n1) Explore deeper\n2) Follow a path?");
                choice1.setText("Explore");
                choice2.setText("Path");
                break;
            case 1:
                storyText.setText("You venture deeper into the forest...\nYou find a glowing object.\nDo you:\n1) Pick it up\n2) Ignore it?");
                choice1.setText("Pick up");
                choice2.setText("Ignore");
                break;
            case 2:
                storyText.setText("You follow the path and reach a village.\nDo you:\n1) Enter the inn\n2) Talk to villagers?");
                choice1.setText("Inn");
                choice2.setText("Villagers");
                break;
            case 3:
                storyText.setText("✨ The object grants you magical powers! You win!\n\nPlay again?");
                choice1.setText("Yes");
                choice2.setText("No");
                break;
            case 4:
                storyText.setText("😱 A wild beast appears and you run away... Game over.\n\nPlay again?");
                choice1.setText("Yes");
                choice2.setText("No");
                break;
            case 5:
                storyText.setText("🍗 You rest at the inn, have a feast, and live happily ever after!\n\nPlay again?");
                choice1.setText("Yes");
                choice2.setText("No");
                break;
            case 6:
                storyText.setText("👥 The villagers crown you their leader! You live a legendary life.\n\nPlay again?");
                choice1.setText("Yes");
                choice2.setText("No");
                break;
        }
    }
}
