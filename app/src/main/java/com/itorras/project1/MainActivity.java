package com.itorras.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayDeque;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

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
    int lastAnimal = 0;
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

        MyOnClickListener myOnClickListener = new MyOnClickListener();
        e_imgBtn.setOnClickListener(myOnClickListener);
        c_imgBtn.setOnClickListener(myOnClickListener);
        m_imgBtn.setOnClickListener(myOnClickListener);


        RandomOnClickListener randomOnClickListener = new RandomOnClickListener();
        randomBtn.setOnClickListener(randomOnClickListener);

    }

    public void setImage(ImageView imgView, int animal) {

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

            setImage(pastCmpView1, lastAnimals[0]);
            setImage(pastCmpView2, lastAnimals[1]);
            setImage(pastCmpView3, lastAnimals[2]);

            int rand = (int) (Math.random() * 3 + 1); // get a random numbe form 1 to 3

            for (int i = 2; i > 0; i--){
                lastAnimals[i] = lastAnimals[i-1];
            }
            lastAnimals[0] = rand;

            count++;//
            switch (rand) { /*** rand = 1 means computer is Elephant, * 2 represents Mouse,* 3 represents Cat*/
                case 1:
                    cmpView.setImageResource(R.drawable.elephant); //computer choose Elephant
                    switch (v.getId()) {
                        case R.id.btnElephant: //player choose Elephant
                            playerView.setImageResource(R.drawable.elephant);
                            result_tv.setText("Result: " + "Tied!");
                            count_tv.setText("Round: " + count);
                            break;
                        case R.id.btnMouse: //player choose Mouse
                            playerView.setImageResource(R.drawable.mouse);
                            result_tv.setText("Result: " + "Win!");
                            count_tv.setText("Round: " + count);
                            playerWinCount++;
                            win_tv.setText("Player Win Count: " + playerWinCount);
                            break;
                        case R.id.btnCat: //player choose Cat
                            playerView.setImageResource(R.drawable.cat);
                            result_tv.setText("Result: " + "Lose!");
                            count_tv.setText("Round: " + count);
                            compWinCount++;
                            comp_win_tv.setText("Computer Win Count: " + compWinCount);
                            break; }
                    break;
                case 2:
                    cmpView.setImageResource(R.drawable.mouse); //computer choose Mouse
                    switch (v.getId()) {
                        case R.id.btnElephant:
                            playerView.setImageResource(R.drawable.elephant);
                            result_tv.setText("Result: " + "Lose!");
                            count_tv.setText("Round: " + count);
                            compWinCount++;
                            comp_win_tv.setText("Computer Win Count: " + compWinCount);
                            break;
                        case R.id.btnMouse:
                            playerView.setImageResource(R.drawable.mouse);
                            result_tv.setText("Result: " + "Tie!");
                            count_tv.setText("Round: " + count);
                            break;
                        case R.id.btnCat:
                            playerView.setImageResource(R.drawable.cat);
                            result_tv.setText("Result: " + "Win!");
                            count_tv.setText("Round: " + count);
                            playerWinCount++;
                            win_tv.setText("Player Win Count: " + playerWinCount);
                            break; }
                    break;
                case 3:
                    cmpView.setImageResource(R.drawable.cat); //computer chose Cat
                    switch (v.getId()) {
                        case R.id.btnElephant:
                            playerView.setImageResource(R.drawable.elephant);
                            result_tv.setText("Result: " + "Win!");
                            count_tv.setText("Round: " + count);
                            playerWinCount++;
                            win_tv.setText("Player Win Count: " + playerWinCount);
                            break;
                        case R.id.btnMouse:
                            playerView.setImageResource(R.drawable.mouse);
                            result_tv.setText("Result: " + "Lose!");
                            count_tv.setText("Round: " + count);
                            compWinCount++;
                            comp_win_tv.setText("Computer Win Count: " + compWinCount);
                            break;
                        case R.id.btnCat:
                            playerView.setImageResource(R.drawable.cat);
                            result_tv.setText("Result: " + "Tie!");
                            count_tv.setText("Round: " + count);
                            break; }
                    break; }
        } }

        private class RandomOnClickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
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


