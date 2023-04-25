package com.example.mympgraph;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class RadarChartActivity extends AppCompatActivity {

    RadarChart radarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar_chart);
        setupRadarChart();

    }

    private void setupRadarChart() {
        radarChart = (RadarChart) findViewById(R.id.radar_chart);
        //radarChart.setBackgroundColor(Color.rgb(60, 65, 82));

        radarChart.getDescription().setEnabled(false);

        radarChart.setWebLineWidth(1f);
        radarChart.setWebColor(Color.LTGRAY);
        radarChart.setWebLineWidthInner(1f);
        radarChart.setWebColorInner(Color.LTGRAY);
        radarChart.setWebAlpha(100);
        YAxis yAxis = radarChart.getYAxis();
        yAxis.setAxisMinimum(0f);

        ArrayList<RadarEntry> timeFocused = new ArrayList<>();
        timeFocused.add(new RadarEntry(89));
        timeFocused.add(new RadarEntry(70));
        timeFocused.add(new RadarEntry(93));
        timeFocused.add(new RadarEntry(99));
        timeFocused.add(new RadarEntry(79));
        timeFocused.add(new RadarEntry(50));

        ArrayList<RadarEntry> timeSpent = new ArrayList<>();
        timeSpent.add(new RadarEntry(93));
        timeSpent.add(new RadarEntry(99));
        timeSpent.add(new RadarEntry(89));
        timeSpent.add(new RadarEntry(75));
        timeSpent.add(new RadarEntry(79));
        timeSpent.add(new RadarEntry(90));

        RadarDataSet radaDataCourseFocused = new RadarDataSet(timeFocused, "과목별");
        radaDataCourseFocused.setColor(Color.BLUE);
        radaDataCourseFocused.setLineWidth(2f);
        radaDataCourseFocused.setValueTextColor(Color.BLUE);
        radaDataCourseFocused.setValueTextSize(14f);
        radaDataCourseFocused.setFillColor(ColorTemplate.rgb("55A8FF"));
        radaDataCourseFocused.setDrawFilled(true);
        radaDataCourseFocused.setFillAlpha(180);
        radaDataCourseFocused.setDrawHighlightCircleEnabled(true);
        radaDataCourseFocused.setDrawHighlightIndicators(false);


        RadarDataSet radaDataCourseSpent = new RadarDataSet(timeSpent, "과목별");
        radaDataCourseSpent.setColor(Color.RED);
        radaDataCourseSpent.setLineWidth(2f);
        radaDataCourseSpent.setValueTextColor(Color.RED);
        radaDataCourseSpent.setValueTextSize(14f);
        radaDataCourseSpent.setFillColor(ColorTemplate.rgb("F88F29"));
        radaDataCourseSpent.setDrawFilled(true);
        radaDataCourseSpent.setFillAlpha(180);
        radaDataCourseSpent.setDrawHighlightCircleEnabled(true);
        radaDataCourseSpent.setDrawHighlightIndicators(false);


        String [] labels = {"수학", "영어", "국어", "과학", "역사", "기타"};

        RadarData radaData = new RadarData();
        radaData.addDataSet(radaDataCourseFocused);
        radaData.addDataSet(radaDataCourseSpent);

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        radarChart.setData(radaData);
    }
}