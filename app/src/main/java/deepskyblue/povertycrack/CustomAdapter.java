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
        TextView stringText = (TextView) customView.findViewById(R.id.textView);
        ImageView myImage = (ImageView) customView.findViewById(R.id.imageView);

        stringText.setText(singleQuestionItem.question);
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
