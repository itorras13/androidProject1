package com.itorras.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgView;
    private ImageButton e_imgBtn, m_imgBtn, c_imgBtn;
    private TextView result_tv, count_tv;
    private ImageView pastCmpView1;
    int count = 0;
    int lastAnimal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize buttons
        e_imgBtn = (ImageButton) findViewById(R.id.btnElephant);
        c_imgBtn = (ImageButton) findViewById(R.id.btnCat);
        m_imgBtn = (ImageButton) findViewById(R.id.btnMouse);

        //intialize imgView
        imgView = (ImageView) findViewById(R.id.viewCmp);
        pastCmpView1 = (ImageView) findViewById(R.id.pastCmp1);
        //intialize result and count TextView
        result_tv = (TextView) findViewById(R.id.textResult);
        count_tv = (TextView) findViewById(R.id.textCount);

        MyOnClickListener myOnClickListener = new MyOnClickListener();
        e_imgBtn.setOnClickListener(myOnClickListener);
        c_imgBtn.setOnClickListener(myOnClickListener);
        m_imgBtn.setOnClickListener(myOnClickListener);

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
            // TODO Auto-generated method stub



            setImage(pastCmpView1, lastAnimal);

            int rand = (int) (Math.random() * 3 + 1); // get a random numbe form 1 to 3

            lastAnimal = rand;
            System.out.println(lastAnimal);

            count++;//
            switch (rand) { /*** rand = 1 means computer is Rock, * 2 represents Paper,* 3 represents scissors*/
                case 1:
                    imgView.setImageResource(R.drawable.elephant); //computer choose Elephant
                    switch (v.getId()) {
                        case R.id.btnElephant: //player choose Elephant
                            result_tv.setText("Result: " + "Tied!");
                            count_tv.setText("Round: " + count);
                            break;
                        case R.id.btnMouse: //player choose Mouse
                            result_tv.setText("Result: " + "Win!");
                            count_tv.setText("Round: " + count);
                            break;
                        case R.id.btnCat: //player choose Cat
                            result_tv.setText("Result: " + "Lose!");
                            count_tv.setText("Round: " + count);
                            break; }
                    break;
                case 2:
                    imgView.setImageResource(R.drawable.mouse); //computer choose Mouse
                    switch (v.getId()) {
                        case R.id.btnElephant:
                            result_tv.setText("Result: " + "Lose!");
                            count_tv.setText("Round: " + count);
                            break;
                        case R.id.btnMouse:
                            result_tv.setText("Result: " + "Tie!");
                            count_tv.setText("Round: " + count);
                            break;
                        case R.id.btnCat:
                            result_tv.setText("Result: " + "Win!");
                            count_tv.setText("Round: " + count);
                            break; }
                    break;
                case 3:
                    imgView.setImageResource(R.drawable.cat); //computer chose Cat
                    switch (v.getId()) {
                        case R.id.btnElephant:
                            result_tv.setText("Result: " + "Win!");
                            count_tv.setText("Round: " + count);
                            break;
                        case R.id.btnMouse:
                            result_tv.setText("Result: " + "Lose!");
                            count_tv.setText("Round: " + count);
                            break;
                        case R.id.btnCat:
                            result_tv.setText("Result: " + "Tie!");
                            count_tv.setText("Round: " + count);
                            break; }
                    break; }
        } }

}


