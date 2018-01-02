package com.bysoftware.kodla.android.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bysoftware.kodla.android.R;
import com.bysoftware.kodla.android.view.model.Tip;

import java.util.List;

public class TipAdapter extends ArrayAdapter<Tip> {

    private List<Tip> movieList;

    public TipAdapter(Context context, int resource, List<Tip> objects) {
        super(context, resource, objects);
        this.movieList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        Tip tip = movieList.get(position);
        ViewHolder viewHolder;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            viewHolder = new ViewHolder();
            rowView = inflater.inflate(R.layout.row_icon, parent, false);
            viewHolder.tip = (TextView) rowView.findViewById(R.id.textViewTip);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        viewHolder.tip.setText(tip.getTip());

        return rowView;
    }

    public static class ViewHolder {
        public TextView tip;
    }
}