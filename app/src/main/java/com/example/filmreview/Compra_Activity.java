package com.example.filmreview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Compra_Activity extends AppCompatActivity {

    private List<Integer> cesta_compra;
    private TextView cestaText;

    private ListView listCompra;

    public static TextView producto;
    public static TextView gamePrice;
    public static int actualValue;

    private NumberPicker numPick;
    private int numOFProducts;



    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        gamePrice = findViewById(R.id.compras_Precio);

        cesta_compra = new ArrayList<>();

        cestaText = findViewById(R.id.compras_total);


        producto = findViewById(R.id.compras_producto);

        listCompra = findViewById(R.id.list_Compra);
        AdapdadorSimple a = new AdapdadorSimple(this,MainActivity.data);
        listCompra.setAdapter(a);

        numPick = findViewById(R.id.compras_numberPicker);
        numPick.setMinValue(1);
        numPick.setMaxValue(99);
        numPick.setValue(1);
        numPick.setWrapSelectorWheel(false);

        numPick.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int ov, int nv) {
                numOFProducts = nv;
            }
        });

        add = findViewById(R.id.compras_addButtton);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(actualValue > 0){
                    for(int i = 0; i < numOFProducts ; i++){
                        cesta_compra.add(actualValue);
                    }
                    int totalValue = 0;
                    for(int i : cesta_compra){
                        totalValue += i;
                    }
                    cestaText.setText("Lista de la compra: " + cesta_compra.size() + " productos = " + totalValue + " €");
                }

            }
        });


    }
}