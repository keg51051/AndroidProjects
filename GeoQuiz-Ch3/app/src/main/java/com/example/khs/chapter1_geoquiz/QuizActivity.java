package com.example.khs.chapter1_geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mPrevButton;
    private ImageButton mNextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };
    private boolean[] mQuestionsAnswered = new boolean[mQuestionBank.length];
    private int mCurrentIndex = 0;
    private int mTrueAnswer = 0;
    private double score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
//        Log.d(TAG, "Current question index: " + mCurrentIndex);
//        Question question;
//        try {
//            question = mQuestionBank[mCurrentIndex];
//        } catch (ArrayIndexOutOfBoundsException ex) {
//// Log a message at "error" log level, along with an exception stack trace
//            Log.e(TAG, "Index was out of bounds", ex);
//        }
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
            mQuestionsAnswered = savedInstanceState.getBooleanArray(KEY_INDEX);
        }

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        updateQuestion();

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                //toast.setGravity(Gravity.TOP,0,0);
                //toast.show();
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                //toast.setGravity(Gravity.TOP,0,0);
                //toast.show();
            }
        });
        mPrevButton = (ImageButton) findViewById(R.id.previous_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex == 0) {
                    mCurrentIndex = mQuestionBank.length - 1;
                    updateQuestion();
                    mTrueButton.setEnabled(!mQuestionsAnswered[mCurrentIndex]);
                    mFalseButton.setEnabled(!mQuestionsAnswered[mCurrentIndex]);
                } else {
                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                    updateQuestion();
                    mTrueButton.setEnabled(!mQuestionsAnswered[mCurrentIndex]);
                    mFalseButton.setEnabled(!mQuestionsAnswered[mCurrentIndex]);
                }
            }
        });
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
                mTrueButton.setEnabled(!mQuestionsAnswered[mCurrentIndex]);
                mFalseButton.setEnabled(!mQuestionsAnswered[mCurrentIndex]);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
        savedInstanceState.putBooleanArray(KEY_INDEX, mQuestionsAnswered);
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void updateQuestion() {
//        mTrueButton.setEnabled(!mQuestionsAnswered[mCurrentIndex]);
//        mFalseButton.setEnabled(!mQuestionsAnswered[mCurrentIndex]);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
        if (mQuestionsAnswered[5]) {
            Toast.makeText(this, Double.toString(score)+"% is your percentage score", Toast.LENGTH_LONG)
                    .show();
        }
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
            mTrueAnswer++;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        score = (mTrueAnswer * 100) / 6;
        Toast toast = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,0);
        toast.show();

        mQuestionsAnswered[mCurrentIndex] = true;
        mTrueButton.setEnabled(false);
        mFalseButton.setEnabled(false);
    }
}
