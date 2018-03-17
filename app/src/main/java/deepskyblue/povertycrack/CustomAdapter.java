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

class CustomAdapter extends ArrayAdapter<String>
{
    CustomAdapter(Context context, String[] questions) {
        super(context, R.layout.custom_row, questions);
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.custom_row, parent, false);

        String singleQuestionItem = getItem(position);
        TextView stringText = (TextView) customView.findViewById(R.id.stringtext);
        ImageView myImage = (ImageView) customView.findViewById(R.id.imageView);

        stringText.setText(singleQuestionItem);
        myImage.setImageResource(R.drawable.checkmark);
        return customView;
    }
}
