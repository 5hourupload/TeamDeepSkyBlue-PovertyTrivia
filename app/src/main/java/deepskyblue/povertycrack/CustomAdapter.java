package deepskyblue.povertycrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Johnny on 3/17/2018.
 */

class CustomAdapter extends ArrayAdapter<Question>
{
    CustomAdapter(Context context, Question[] questions)
    {
        super(context, R.layout.custom_row, questions);
    }

    //    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.custom_row, parent, false);

        Question singleQuestionItem = getItem(position);
        TextView questionText = (TextView) customView.findViewById(R.id.questionResult);
        TextView answerText = (TextView) customView.findViewById(R.id.answerResult);
        ImageView myImage = (ImageView) customView.findViewById(R.id.imageView);

        questionText.setText(singleQuestionItem.question);
        answerText.setText(singleQuestionItem.answer);

        if (singleQuestionItem.correct)
        {
            myImage.setImageResource(R.drawable.checkmark);
            return customView;
        }
        else
        {
            myImage.setImageResource(R.drawable.cross);
        }
        return customView;
    }
}
