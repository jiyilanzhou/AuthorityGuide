package com.archermind.authorityguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/21.
 */
public class CheatActivity extends Activity{
    public static final String EXTRA_ANSWER_IS_TRUE = "answer_is_true";
    public static final String EXTRA_ANSWER_SHOW = "answer_shown";
    private boolean mAnswerIsTrue;
    private Button mShowAnswer;
    private TextView mAnswerTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        mAnswerIsTrue = bundle.getBoolean(EXTRA_ANSWER_IS_TRUE);
        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
        setAnswerShownResult(false);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });
    }

    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOW,isAnswerShown);
        setResult(RESULT_OK,data);
    }
}
