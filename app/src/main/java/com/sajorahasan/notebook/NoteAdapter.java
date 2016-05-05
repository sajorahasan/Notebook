package com.sajorahasan.notebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sajor on 30-04-2016.
 */
public class NoteAdapter extends ArrayAdapter<Note> {

    public static class ViewHolder{
        TextView title;
        TextView note;
        ImageView noteIcon;
    }

    public NoteAdapter(Context context, ArrayList<Note> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the data item for this position
        Note note = getItem(position);

        //ceate a new viewHolder
        ViewHolder viewHolder;

        //Check if an existing view is being reused, otherwise inflate a new view from custom row layout
        if (convertView == null) {
            //if we don't have a view that is being used create one, and make sure you create a
            //view holder along with it to save our view references to.
            viewHolder =new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);

            //set our views to our view holder so that we np longer have to go back and use findviewbyid every time we have a new row
            viewHolder.title=(TextView)convertView.findViewById(R.id.listItemNoteTitle);
            viewHolder.note=(TextView)convertView.findViewById(R.id.listItemNoteBody);
            viewHolder.noteIcon=(ImageView) convertView.findViewById(R.id.listItemNoteImg);

            //use setTag to remember our viewHolder which is holding our references to our widgets
            convertView.setTag(viewHolder);
        }else {
            //we already have a view so just goto our viewHolder and grab the widgets from it.
            viewHolder=(ViewHolder)convertView.getTag();
        }


        //populate the data into the template view using the data object.
        viewHolder.title.setText(note.getTitle());
        viewHolder.note.setText(note.getMessage());
        viewHolder.noteIcon.setImageResource(note.getAssociatedDrawable());

        //now that we modified the view to display appropriate data,
        //return it so it will be displayed.
        return convertView;
    }
}
