package deepskyblue.povertycrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Creates a list view using a base template of custom_row and an array
 * Created by Johnny on 3/17/2018.
 */

class CustomAdapter extends ArrayAdapter<Question>
{
    CustomAdapter(Context context, Question[] questions)
    {
        super(context, R.layout.custom_row, questions);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        //creates a new layoutinflater
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.custom_row, parent, false);

        //gets the position of the question from the questions array
        Question singleQuestionItem = getItem(position);

        //creates an editable object
        TextView questionText = (TextView) customView.findViewById(R.id.questionResult);
        TextView answerText = (TextView) customView.findViewById(R.id.answerResult);
        ImageView myImage = (ImageView) customView.findViewById(R.id.imageView);

        //sets the text of the question from the question object at a given position
        questionText.setText(singleQuestionItem.question);
        //sets the text of the answer from the question object at a given position
        answerText.setText(singleQuestionItem.answer);

        //checks if question was answer correctly and sets the image as a check or a cross
        if (singleQuestionItem.correct)//answer was correct
        {
            myImage.setImageResource(R.drawable.checkmark);//sets image as a checkmark
            return customView;//returns the designed row
        }
        else
        {
            myImage.setImageResource(R.drawable.cross);//sets image as a cross
        }
        return customView;//returns the deisgned row
    }
}
