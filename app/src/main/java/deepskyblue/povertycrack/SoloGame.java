package deepskyblue.povertycrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.sql.SQLOutput;
import java.text.DecimalFormat;

import static deepskyblue.povertycrack.MainActivity.multChoiceQuestions;
import static deepskyblue.povertycrack.MainActivity.results;
import static deepskyblue.povertycrack.MainActivity.sliderQuestions;
import static deepskyblue.povertycrack.MainActivity.trueFalseQuestions;

public class SoloGame extends AppCompatActivity
{
    public int count = 0;
    public int streak = 0;
    public int highScore = 0;
    public int score = 0;
    ConstraintLayout tf;
    ConstraintLayout mc;
    ConstraintLayout sl;
    ConstraintLayout qr;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionbox_template);
        tf = findViewById(R.id.tf_view);
        mc = findViewById(R.id.mc_view);
        sl = findViewById(R.id.slider_view);
        qr = findViewById(R.id.question_result);
        newQuestion();
    }

    //every new question that is called in main calls this method
    //This method calls the appropriate method to execute the question

    private void newQuestion()
    {
        Question currentQuestion;
        count++;
        switch ((int) (Math.random() * 2))
        {
            case 0:
                currentQuestion = trueFalseQuestions.pop();
                currentQuestion.num = count;
                highLow(currentQuestion);
                break;
            case 1:
                currentQuestion = multChoiceQuestions.pop();
                currentQuestion.num = count;
                multipleChoice(currentQuestion);
                break;
            case 2:
                currentQuestion = sliderQuestions.pop();
                currentQuestion.num = count;
                slider(currentQuestion);
                break;
        }

        TextView streakCounter = findViewById(R.id.streakCounter);
        String streakText = "Streak: " + streak;
        streakCounter.setText(streakText);

        TextView scoreCounter = findViewById(R.id.scoreCounter);
        String scoreText = "Score: " + score;
        scoreCounter.setText(scoreText);
    }

    //Check functions for each type of question
    //Parameters include the selected answer compared to the correct answer
    private void checkAnswer(String selectedA, Question question)
    {
        if (selectedA.equals(question.answer))
        {
            question.correct = true;
            streak++;
            if (score == 0)
            {
                score++;
            }
            else
            {
                score += streak;
            }
        }
        else
        {
            streak = 0;
            score--;
        }
        if(score > highScore){
            highScore = score;
        }
        handleResults(selectedA, question);
    }


    private void checkS(int sliderSelection, Question question)
    {
        if (sliderSelection == Integer.parseInt(question.answer))
        {
            question.correct = true;
            streak++;
            if (score == 0)
            {
                score++;
            }
            else
            {
                score += streak;
            }
        }
        else
        {
            streak = 0;
            score--;
        }
        if(score > highScore){
            highScore = score;
        }
        handleResults(Integer.toString(sliderSelection), question);
    }

    //Function called for a true or false question
    private void highLow(final Question question)
    {
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question.question);

        clearLayouts();
        tf.setVisibility(View.VISIBLE);

        Button True = findViewById(R.id.buttonTrue);
        //sets up onclick listeners for both buttons that call the check function above
        True.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checkAnswer("True", question);
            }
        });
        Button False = findViewById(R.id.buttonFalse);
        False.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checkAnswer("False", question);
            }
        });
    }

    private void multipleChoice(final Question question)
    {
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question.question);
        clearLayouts();

        mc.setVisibility(View.VISIBLE);
        System.out.println(question.answer);

        String[] Answers = new String[4];
        String number = question.answer.replace(",", "").replace("$", "").replace("-", "");
        int correctAnswerTemp = -1;
        try
        {
            correctAnswerTemp = Integer.parseInt(number);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        int random = (int) (Math.random() * 4);
        Answers[random] = question.answer;
        for (int i = 0; i < 4; i++)
        {
            if (i == random) continue;
            int value = correctAnswerTemp + (int) Math.round(((Math.random() * 10) - 5) * 5000);
            DecimalFormat formatter = new DecimalFormat("##,###");
            Answers[i] = "$" + formatter.format(value);
        }
        //final String correctAnswer = correctAnswerTemp;
        final String[] finalAnswers = Answers;
        Button buttonOption1 = findViewById(R.id.questionOption1);
        System.out.println(finalAnswers[0]);
        buttonOption1.setText(finalAnswers[0]);
        buttonOption1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checkAnswer(finalAnswers[0], question);
            }
        });
        Button buttonOption2 = findViewById(R.id.questionOption2);
        buttonOption2.setText(finalAnswers[1]);
        buttonOption2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checkAnswer(finalAnswers[1], question);
            }
        });
        Button buttonOption3 = findViewById(R.id.questionOption3);
        buttonOption3.setText(finalAnswers[2]);
        buttonOption3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checkAnswer(finalAnswers[2], question);
            }
        });
        Button buttonOption4 = findViewById(R.id.questionOption4);
        buttonOption4.setText(finalAnswers[3]);
        buttonOption4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checkAnswer(finalAnswers[3], question);
            }
        });
    }

    private void slider(final Question question)
    {
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question.question);
        clearLayouts();
        sl.setVisibility(View.VISIBLE);
        final SeekBar slider = findViewById(R.id.slider);
        slider.setMax(100000);
        slider.setMax(50000);

        //int newMax = (int)(Integer.parseInt(Answer) + (Integer.parseInt(Answer) * Math.random()));
        //slider.setMax(newMax);
        Button sliderButton = findViewById(R.id.sliderButton);
        sliderButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checkS(slider.getProgress(), question);
            }
        });
    }

    private void clearLayouts()
    {
        tf.setVisibility(View.INVISIBLE);
        mc.setVisibility(View.INVISIBLE);
        sl.setVisibility(View.INVISIBLE);
        qr.setVisibility(View.INVISIBLE);
    }

    private void handleResults(String answer, Question question)
    {
        results.add(question);
        clearLayouts();
        qr.setVisibility(View.VISIBLE);
        TextView comment = findViewById(R.id.comment);
        TextView correctAnswer = findViewById(R.id.correct_answer);
        if (question.correct)
        {
            comment.setText("You guessed correctly!");
            correctAnswer.setText(question.answer);
        }
        else
        {
            comment.setText("Incorrect! You guessed " + answer + ".\n The correct answer is:");
            correctAnswer.setText(question.answer);
        }


        Button nextQuestion = findViewById(R.id.next_question);
        nextQuestion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                newQuestion();
            }
        });

        if (results.size() >= 2)
        {
            if (!results.get(results.size() - 1).correct && !results.get(results.size() - 2).correct)
            {
                Intent newIntent = new Intent(getApplicationContext(), ResultScreen.class);
                startActivity(newIntent);
            }
        }
    }

}