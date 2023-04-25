package com.example.mympgraph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

//
//class CustomBarChartRenderer extends BarChartRenderer {
//    public CustomBarChartRenderer(BarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
//        super(chart, animator, viewPortHandler);
//    }
//}


public class StackedHorizontalBarActivity extends AppCompatActivity {

    HorizontalBarChart stackedBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stacked_horizontal_bar);
        setupStackedHorizontalBarChart();

    }



    private void setupStackedHorizontalBarChart() {
        stackedBarChart = (HorizontalBarChart) findViewById(R.id.stacked_horizontalBar_chart);
//        CustomBarChartRenderer customRenderer = new CustomBarChartRenderer(stackedBarChart, stackedBarChart.getAnimator(), stackedBarChart.getViewPortHandler());
//        stackedBarChart.setRenderer(customRenderer);

        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();
        yValues.add(new BarEntry(1f, new float[] {12f,46f,23f,60f}));

        BarDataSet hbarDataSet;
        hbarDataSet = new BarDataSet(yValues, "");
        hbarDataSet.setStackLabels(new String[] {"집중", "졸림", "자리비움", "기타"});

        // Custom colors
        ArrayList<Integer> customColors = new ArrayList<>();
        customColors.add(ContextCompat.getColor(this, R.color.orange1));
        customColors.add(ContextCompat.getColor(this, R.color.skyblue2));
        customColors.add(ContextCompat.getColor(this, R.color.green3));
        customColors.add(ContextCompat.getColor(this, R.color.grey4));
        hbarDataSet.setColors(customColors);
        hbarDataSet.setValueTextSize(14.0f);
        hbarDataSet.setValueTypeface(Typeface.DEFAULT_BOLD);
        hbarDataSet.setValueTextColor(ContextCompat.getColor(this, R.color.white));

        BarData data = new BarData(hbarDataSet);
        data.setHighlightEnabled(false);

        XAxis xAxis = stackedBarChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(false);

        YAxis leftAxis = stackedBarChart.getAxisLeft();
        YAxis rightAxis = stackedBarChart.getAxisRight();

        leftAxis.setDrawGridLines(false);
        rightAxis.setDrawGridLines(false);

        stackedBarChart.getDescription().setEnabled(false);
        stackedBarChart.getAxisLeft().setDrawLabels(false);
        stackedBarChart.getAxisRight().setDrawLabels(false);
        stackedBarChart.setDrawGridBackground(false);
        stackedBarChart.setDrawValueAboveBar(false);

        stackedBarChart.setData(data);
        stackedBarChart.invalidate();

    }
}