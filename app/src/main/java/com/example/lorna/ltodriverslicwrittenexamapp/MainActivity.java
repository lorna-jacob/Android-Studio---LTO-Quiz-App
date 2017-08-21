package com.example.lorna.ltodriverslicwrittenexamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    QuestionLibrary questionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mChoice1;
    private Button mChoice2;
    private Button mChoice3;

    private int mScore = 0;
    private int mQuestionNumber = 0;
    private String mAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mChoice1 = (Button)findViewById(R.id.choice1);
        mChoice2 = (Button)findViewById(R.id.choice2);
        mChoice3 = (Button)findViewById(R.id.choice3);

        updateQuestionView();

        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mChoice1.getText() == mAnswer) {
                    mScore += 1;
                    updateScoreView(mScore);
                    updateQuestionView();

                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestionView();
                }

            }
        });

        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mChoice2.getText() == mAnswer) {
                    mScore += 1;
                    updateScoreView(mScore);
                    updateQuestionView();

                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestionView();
                }

            }
        });

        mChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mChoice3.getText() == mAnswer) {
                    mScore += 1;
                    updateScoreView(mScore);
                    updateQuestionView();

                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestionView();
                }

            }
        });
    }

    private void updateScoreView(int score) {
        mScoreView.setText("" + score);
    }

    private void updateQuestionView() {
        mQuestionView.setText(questionLibrary.getQuestion(mQuestionNumber));
        mChoice1.setText((questionLibrary.getChoice1(mQuestionNumber)));
        mChoice2.setText((questionLibrary.getChoice2(mQuestionNumber)));
        mChoice3.setText((questionLibrary.getChoice3(mQuestionNumber)));
        mAnswer = questionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber += 1;
    }
}
