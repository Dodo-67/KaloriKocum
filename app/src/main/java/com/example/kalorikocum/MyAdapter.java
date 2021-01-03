package com.example.kalorikocum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kalorikocum.R;

public class MyAdapter extends ArrayAdapter<String> {
    String[] names;
    String[] icerik;
    int[] resim;
    Context mContext;

    public MyAdapter(@NonNull Context context, String[] Yemekisimleri, String[] icerik, int[] resim) {
        super(context, R.layout.listview_item);
        this.names = Yemekisimleri;
        this.icerik = icerik;
        this.resim = resim;
        this.mContext = context;

    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mresim = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textView);
            mViewHolder.micerik = (TextView) convertView.findViewById(R.id.icerik);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mresim.setImageResource(resim[position]);
        mViewHolder.mName.setText(names[position]);
        mViewHolder.micerik.setText(icerik[position]);

        return convertView;
    }

    static class ViewHolder {
        ImageView mresim;
        TextView mName,micerik;
    }
}
