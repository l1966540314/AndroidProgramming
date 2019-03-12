package com.study.liuhao.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.study.liuhao.geoquiz.answer_is_true";

    private static final String EXTRA_ANSWER_SHOWN = "com.study.liuhao.geoquiz.answer_shown";

    private static final String TAG = "QuizActivity";

    private boolean mAnswerIsTrue;

    private TextView mAnswerTextView;

    private Button mShowAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        mShowAnswer = (Button) findViewById(R.id.show_answer_button);

        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswerIsTrue){
                   mAnswerTextView.setText(R.string.true_button);
                }else {
                   mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShowResult(true);
            }
        });

    }

    public static Intent newIntent(Context packageContext, Boolean answerIsTrue){
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
    }

    private void setAnswerShowResult(boolean isAnswerShow){

        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShow);
        setResult(RESULT_OK,data);
    }
}
