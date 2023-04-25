package com.example.mympgraph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnBarChart;
    Button btnPieChart;
    Button btnRadarChart;
    Button btnStackedHBarChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBarChart = (Button)findViewById(R.id.buttonBarChart);
        btnPieChart = (Button)findViewById(R.id.buttonPieChart);
        btnRadarChart = (Button)findViewById(R.id.buttonRadarChart);
        btnStackedHBarChart = (Button)findViewById(R.id.buttonStackHBarChart);

        btnBarChart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, BarChartActivity.class);
                startActivity(intent);
            }
        });

        btnPieChart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, PieChartActivity.class);
                startActivity(intent);
            }
        });

        btnRadarChart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, RadarChartActivity.class);
                startActivity(intent);
            }
        });

        btnStackedHBarChart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, StackedHorizontalBarActivity.class);
                startActivity(intent);
            }
        });

    }
}