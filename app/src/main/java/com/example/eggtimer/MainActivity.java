package com.example.eggtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    SeekBar mySeekbar ;

    ListView myListview;


    public void generateTimesTable(int timesTable) {

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {

            timesTableContent.add(  Integer.toString(i * timesTable) );

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        myListview.setAdapter(arrayAdapter);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
myListview    = (ListView)findViewById(R.id.myListview);
mySeekbar    = (SeekBar) findViewById(R.id.mySeekbar);
        mySeekbar.setMax(20);
        mySeekbar.setProgress(10);

        mySeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;

                if (progress < min) {

                    timesTable = min;
                    mySeekbar.setProgress(min);

                } else {

                    timesTable = progress;

                }

                generateTimesTable(timesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(10);
    }
}

/*
public class MainActivity extends AppCompatActivity {
    ListView mylistView;



    void createTable(int timesTable){

        ArrayList<String> table = new ArrayList<String>();
        int i;
        for(i=1;i<=12;i++){
            table.add(Integer.toString(timesTable*i));
        }

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, table);

        mylistView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylistView = (ListView) findViewById(R.id.myListview) ;



        SeekBar seekBar = (SeekBar)findViewById(R.id.mySeekbar);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timesTable;

                if(progress < min)
                {
                    timesTable = min;
                    seekBar.setProgress(min);
                }
                else
                {
                    timesTable=progress;
                }

                createTable(timesTable);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        createTable(10);

    }
}*/