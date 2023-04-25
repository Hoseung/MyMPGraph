package com.example.mympgraph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;;

public class BarChartActivity extends AppCompatActivity {

    BarChart barChart;

    private void highlightBar(BarChart barChart, int xValue, int dataSetIndex) {
        barChart.highlightValue(xValue, dataSetIndex);
    }

    private void setupBarChart() {
        barChart = (BarChart) findViewById(R.id.bar_chart);

        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(false);
        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(false);
        barChart.getDescription().setEnabled(false);
        barChart.getAxisLeft().setDrawLabels(false);
        barChart.getAxisRight().setDrawLabels(false);

        YAxis leftAxis = barChart.getAxisLeft();
        YAxis rightAxis = barChart.getAxisRight();
        XAxis xAxis = barChart.getXAxis();

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);

        leftAxis.setTextSize(10f);
        leftAxis.setDrawLabels(false);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawGridLines(false);

        rightAxis.setDrawAxisLine(false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawLabels(false);

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1, 10.2f));
        barEntries.add(new BarEntry(2, 12.2f));
        barEntries.add(new BarEntry(3, 14.2f));
        barEntries.add(new BarEntry(4, 17f));
        barEntries.add(new BarEntry(5, 16f));
        barEntries.add(new BarEntry(6, 14.6f));
        barEntries.add(new BarEntry(7, 8.6f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "집중도");
        barDataSet.setColors(ContextCompat.getColor(this, R.color.orange1));
        barDataSet.setHighLightColor(ContextCompat.getColor(this, R.color.grey4));
        barDataSet.setHighLightAlpha(255); // fully opaque, gray color
        barDataSet.setDrawValues(false);
        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.9f);

        barChart.setData(data);

        barChart.invalidate(); // refresh?
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        setupBarChart();
        // Highlight my location
        // Only 1 dataset, me at the 6-th bar
        highlightBar(barChart,6,0);

    }
}