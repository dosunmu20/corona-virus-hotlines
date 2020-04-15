package com.example.coronavirushelplines;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class test extends AppCompatActivity {

    @BindView(R.id.testBackButton)
    FrameLayout testBackButton;

    @BindView(R.id.cardOne)
    CardView cardOne;

    @BindView(R.id.cardTwo)
    CardView cardTwo;

    @BindView(R.id.cardThree)
    CardView cardThree;

    @BindView(R.id.cardFour)
    CardView cardFour;

    @BindView(R.id.cardFive)
    CardView cardFive;

    @BindView(R.id.cardSix)
    CardView cardSix;

    @BindView(R.id.yesRBOne)
    RadioButton yesRBOne;

    @BindView(R.id.yesRBTwo)
    RadioButton yesRBTwo;

    @BindView(R.id.yesRBThree)
    RadioButton yesRBThree;

    @BindView(R.id.yesRBFour)
    RadioButton yesRBFour;

    @BindView(R.id.yesRBFive)
    RadioButton yesRBFive;

    @BindView(R.id.yesRBSix)
    RadioButton yesRBSix;

    @BindView(R.id.noRBOne)
    RadioButton noRBOne;

    @BindView(R.id.noRBTwo)
    RadioButton noRBTwo;

    @BindView(R.id.noRBThree)
    RadioButton noRBThree;

    @BindView(R.id.noRBFour)
    RadioButton noRBFour;

    @BindView(R.id.noRBFive)
    RadioButton noRBFive;

    @BindView(R.id.noRBSix)
    RadioButton noRBSix;

    @BindView(R.id.seeResult)
    Button btnSeeResult;

    private int answerOne, answerTwo, answerThree, answerFour, answerFive, answerSix;
    private boolean checked = false;

    private View.OnClickListener seeResultListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sendResultStatus();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        testBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setRBOneClickListeners();
        btnSeeResult.setOnClickListener(seeResultListener);

    }

    public int checkRBStatus (RadioButton radioButton1, RadioButton radioButton2, CardView cardView){

        int answer;

      if (radioButton1.isChecked() && !radioButton2.isChecked()){
          cardView.setCardBackgroundColor(getResources().getColor(R.color.green));
          answer = 1;
           checked = radioButton1.isChecked();

      } else if (radioButton2.isChecked() && !radioButton1.isChecked()){
          cardView.setCardBackgroundColor(getResources().getColor(R.color.red));
          answer = 0;
           checked = radioButton2.isChecked();
      }
            else {
                  answer = 0;
                  checked = false;
      }
            return answer;
    }

    public int checkRBSixStatus (RadioButton radioButton1, RadioButton radioButton2, CardView cardView){

        int answer;

        if (radioButton1.isChecked() && !radioButton2.isChecked()){
            cardView.setCardBackgroundColor(getResources().getColor(R.color.green));
            answer = 3;
            checked = radioButton1.isChecked();

        } else if (radioButton2.isChecked() && !radioButton1.isChecked()){
            cardView.setCardBackgroundColor(getResources().getColor(R.color.red));
            answer = 0;
            checked = radioButton2.isChecked();
        }
        else {
            answer = 0;
            checked = false;
        }
        return answer;
    }

    private View.OnClickListener rbOneClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            answerOne = checkRBStatus(yesRBOne, noRBOne, cardOne);
        }
    };

    private View.OnClickListener rbTwoClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            answerTwo = checkRBStatus(yesRBTwo, noRBTwo, cardTwo);
        }
    };

    private View.OnClickListener rbThreeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            answerThree = checkRBStatus(yesRBThree, noRBThree, cardThree);
        }
    };

    private View.OnClickListener rbFourClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            answerFour = checkRBStatus(yesRBFour, noRBFour, cardFour);
        }
    };

    private View.OnClickListener rbFiveClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        answerFive = checkRBStatus(yesRBFive, noRBFive, cardFive);
        }
    };

    private View.OnClickListener rbSixClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            answerSix = checkRBSixStatus(yesRBSix, noRBSix, cardSix);
        }
    };

    public void setRBOneClickListeners(){
        yesRBOne.setOnClickListener(rbOneClickListener);
        yesRBTwo.setOnClickListener(rbTwoClickListener);
        yesRBThree.setOnClickListener(rbThreeClickListener);
        yesRBFour.setOnClickListener(rbFourClickListener);
        yesRBFive.setOnClickListener(rbFiveClickListener);
        yesRBSix.setOnClickListener(rbSixClickListener);

        noRBOne.setOnClickListener(rbOneClickListener);
        noRBTwo.setOnClickListener(rbTwoClickListener);
        noRBFour.setOnClickListener(rbFourClickListener);
        noRBThree.setOnClickListener(rbThreeClickListener);
        noRBFive.setOnClickListener(rbFiveClickListener);
        noRBSix.setOnClickListener(rbSixClickListener);

    }



    public int doResult (){
         return answerOne + answerTwo + answerThree + answerFour + answerSix + answerFive;
    }

    public void sendResultStatus(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


        int result = doResult();

        if (!checked){
            Toast.makeText(this, R.string.take_not_being_Taken, Toast.LENGTH_LONG).show();
        } else {
            switch (result){
                case 0:

                    alertDialogBuilder.setMessage(R.string.zero_case);
                    alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    break;
                case 1: case 2: case 3:
//                    Toast.makeText(this, R.string.rest_and_observe, Toast.LENGTH_LONG).show();
                    alertDialogBuilder.setMessage(R.string.rest_and_observe);
                    alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    break;
                case 4: case 5:
//                    Toast.makeText(this, R.string.mild_symptoms, Toast.LENGTH_LONG).show();
                    alertDialogBuilder.setMessage(R.string.mild_symptoms);
                    alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    break;
                case 6: case 7: case 8:
//                    Toast.makeText(this,R.string.severe_symptoms, Toast.LENGTH_LONG).show();
                    alertDialogBuilder.setMessage(R.string.severe_symptoms);
                    alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    break;

                default:
//                    Toast.makeText(this, getString(R.string.default_case), Toast.LENGTH_LONG).show();

                    alertDialogBuilder.setMessage(R.string.default_case);
                    alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    break;
            }

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }


}
