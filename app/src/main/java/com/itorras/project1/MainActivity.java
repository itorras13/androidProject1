package com.itorras.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    // Declare imageviews and buttons
    private ImageView playerView, cmpView;
    private ImageView pastCmpView1;
    private ImageView pastCmpView2;
    private ImageView pastCmpView3;
    private ImageButton e_imgBtn, m_imgBtn, c_imgBtn;
    private Button randomBtn;
    private TextView result_tv, count_tv, win_tv, comp_win_tv;

    int count = 0;
    int playerWinCount = 0;
    int compWinCount = 0;

    // array to keep track of last animals played by computer
    int[] lastAnimals = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize buttons
        e_imgBtn = (ImageButton) findViewById(R.id.btnElephant);
        c_imgBtn = (ImageButton) findViewById(R.id.btnCat);
        m_imgBtn = (ImageButton) findViewById(R.id.btnMouse);
        randomBtn = (Button) findViewById(R.id.random);

        //intialize Image Views
        playerView = (ImageView) findViewById(R.id.playerMove);
        cmpView = (ImageView) findViewById(R.id.cmpMove);
        pastCmpView1 = (ImageView) findViewById(R.id.pastCmp1);
        pastCmpView2 = (ImageView) findViewById(R.id.pastCmp2);
        pastCmpView3 = (ImageView) findViewById(R.id.pastCmp3);
        //intialize result and count TextView
        result_tv = (TextView) findViewById(R.id.textResult);
        count_tv = (TextView) findViewById(R.id.textCount);
        win_tv = (TextView) findViewById(R.id.winCount);
        comp_win_tv = (TextView) findViewById(R.id.compWinCount);

        // onClickListener for the player's buttons
        MyOnClickListener myOnClickListener = new MyOnClickListener();
        e_imgBtn.setOnClickListener(myOnClickListener);
        c_imgBtn.setOnClickListener(myOnClickListener);
        m_imgBtn.setOnClickListener(myOnClickListener);

        // onClickListener for the random button
        RandomOnClickListener randomOnClickListener = new RandomOnClickListener();
        randomBtn.setOnClickListener(randomOnClickListener);

    }

    public void setImage(ImageView imgView, int animal) {
        // method takes in an imageView object and sets an animal to it

        switch( animal ) {
            case 1:
                imgView.setImageResource(R.drawable.elephant);
                break;
            case 2:
                imgView.setImageResource(R.drawable.mouse);
                break;
            case 3:
                imgView.setImageResource(R.drawable.cat);
                break;
        }

    }


    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            // Display the last three animals played by the computer
            setImage(pastCmpView1, lastAnimals[0]);
            setImage(pastCmpView2, lastAnimals[1]);
            setImage(pastCmpView3, lastAnimals[2]);

            // Pick a random number from 1-3 that represents the computer's choice
            int rand = (int) (Math.random() * 3 + 1);
            setImage(cmpView, rand);

            // Update the array storing the last 3 animals played by the computer
            for (int i = 2; i > 0; i--){
                lastAnimals[i] = lastAnimals[i-1];
            }
            lastAnimals[0] = rand;

            count++;//
            switch (rand) { // rand = 1 means computer chose elephant, 2 represents mouse,3 represents cat
                case 1:
                    switch (v.getId()) {
                        case R.id.btnElephant: //both chose elephant, so it's a tie
                            setImage(playerView, 1);
                            result_tv.setTextColor(Color.parseColor("#ff6ec7"));
                            result_tv.setText("Tie!");
                            count_tv.setText("Round: " + count);
                            break;
                        case R.id.btnMouse: //player chose mouse and computer chose elephant, so player wins
                            setImage(playerView, 2);
                            result_tv.setTextColor(Color.parseColor("#009900"));
                            result_tv.setText("You Win!");
                            count_tv.setText("Round: " + count);
                            playerWinCount++; // increase player win count
                            win_tv.setText("Player Win Count: " + playerWinCount);
                            break;
                        case R.id.btnCat: //player chose cat and computer chose elephant, so computer wins
                            setImage(playerView, 3);
                            result_tv.setTextColor(Color.parseColor("#b20000"));
                            result_tv.setText("You Lose!");
                            count_tv.setText("Round: " + count);
                            compWinCount++; // increase computer win count
                            comp_win_tv.setText("Computer Win Count: " + compWinCount);
                            break; }
                    break;
                case 2:
                    switch (v.getId()) {
                        case R.id.btnElephant:
                            setImage(playerView, 1);
                            result_tv.setTextColor(Color.parseColor("#b20000"));
                            result_tv.setText("You Lose!");
                            count_tv.setText("Round: " + count);
                            compWinCount++;
                            comp_win_tv.setText("Computer Win Count: " + compWinCount);
                            break;
                        case R.id.btnMouse:
                            setImage(playerView, 2);
                            result_tv.setTextColor(Color.parseColor("#ff6ec7"));
                            result_tv.setText("Tie!");
                            count_tv.setText("Round: " + count);
                            break;
                        case R.id.btnCat:
                            setImage(playerView, 3);
                            result_tv.setTextColor(Color.parseColor("#009900"));
                            result_tv.setText("You Win!");
                            count_tv.setText("Round: " + count);
                            playerWinCount++;
                            win_tv.setText("Player Win Count: " + playerWinCount);
                            break; }
                    break;
                case 3:
                    switch (v.getId()) {
                        case R.id.btnElephant:
                            setImage(playerView, 1);
                            result_tv.setTextColor(Color.parseColor("#009900"));
                            result_tv.setText("You Win!");
                            count_tv.setText("Round: " + count);
                            playerWinCount++;
                            win_tv.setText("Player Win Count: " + playerWinCount);
                            break;
                        case R.id.btnMouse:
                            setImage(playerView, 2);
                            result_tv.setTextColor(Color.parseColor("#b20000"));
                            result_tv.setText("You Lose!");
                            count_tv.setText("Round: " + count);
                            compWinCount++;
                            comp_win_tv.setText("Computer Win Count: " + compWinCount);
                            break;
                        case R.id.btnCat:
                            setImage(playerView, 3);
                            result_tv.setTextColor(Color.parseColor("#ff6ec7"));
                            result_tv.setText("Tie!");
                            count_tv.setText("Round: " + count);
                            break; }
                    break; }
        } }

        private class RandomOnClickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                // When the random button is clicked, a random int is chosen from 1-3 to represent
                // the a random choice for the player. 1=elephant, 2=mouse, 3=cat.
                // This then simulates a button click for the animal that was picked.

                int rand = (int) (Math.random() * 3 + 1);

                switch (rand) {

                    case 1:
                        e_imgBtn.performClick();
                        break;
                    case 2:
                        m_imgBtn.performClick();
                        break;
                    case 3:
                        c_imgBtn.performClick();
                        break;
                }

            }

        }

}


