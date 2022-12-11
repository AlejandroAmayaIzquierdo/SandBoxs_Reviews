package com.example.filmreview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class AdaptadorComplex extends BaseAdapter {

    private LayoutInflater inflater = null;

    private Context context;
    private String[][] data;
    private int[] dataImg;

    public AdaptadorComplex(Context context, String[][] data, int[] images){
        this.context = context;
        this.data = data;
        this.dataImg = images;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.elemento_lista,null);

        TextView title = (TextView) vista.findViewById(R.id.game_title);
        TextView duration = (TextView) vista.findViewById(R.id.game_long);
        TextView developer = (TextView) vista.findViewById(R.id.game_developer);
        ImageView image = (ImageView) vista.findViewById(R.id.game_imageView);
        RatingBar rating = (RatingBar) vista.findViewById(R.id.game_RatingBar);

        title.setText(data[i][0]);
        developer.setText(data[i][1]);
        duration.setText(data[i][2] + " Horas");
        image.setImageResource(Integer.valueOf(dataImg[i]));
        rating.setProgress(Integer.valueOf(data[i][3]));

        image.setTag(i);
        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visorImage = new Intent(context,activity_game.class);
                int tag = (Integer)view.findViewById(R.id.game_imageView).getTag();
                visorImage.putExtra("IMG",MainActivity.dataImg[tag]);
                visorImage.putExtra("DESC",data[tag][4]);
                context.startActivity(visorImage);
            }
        });

        return vista;
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
