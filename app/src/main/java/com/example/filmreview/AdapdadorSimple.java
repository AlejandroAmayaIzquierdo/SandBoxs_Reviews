package com.example.filmreview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapdadorSimple extends BaseAdapter {

    private LayoutInflater inflater = null;

    private Context context;
    private String[][] data;



    public AdapdadorSimple(Context context, String[][] data){
        this.context = context;
        this.data = data;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.elemento_lista_simple,null);

        TextView title = (TextView) vista.findViewById(R.id.game_title);
        TextView price = (TextView) vista.findViewById(R.id.game_cost);

        title.setText(data[i][0]);
        price.setText(data[i][5] + " €");

        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView game = view.findViewById(R.id.game_title);
                Compra_Activity.producto.setText(game.getText());

                TextView t = view.findViewById(R.id.game_cost);
                String text = t.getText().subSequence(0 ,t.getText().length() - 2).toString();
                Compra_Activity.gamePrice.setText(text);
                Compra_Activity.actualValue = Integer.valueOf(text);


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
