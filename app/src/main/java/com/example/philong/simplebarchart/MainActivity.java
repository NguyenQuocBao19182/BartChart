package com.example.philong.simplebarchart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart bChart;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bChart=findViewById(R.id.barchar_1);


       //hiệu ứng cho biểu đồ
        bChart.setDrawBarShadow(false); //vẽ thanh bóng
        bChart.setDrawValueAboveBar(true); //Vẽ giá trị trên thanh
        bChart.setMaxVisibleValueCount(50); //Giá trị hiển thị tối đa
        bChart.setPinchZoom(false);
        bChart.setDrawGridBackground(true); //nền lưới thô


        ArrayList<BarEntry> barEntries=new ArrayList<>(); //mảng chạy từ index 0 nếu k thêm vào thì máy tự nhận là bắt đầu từ 0
        barEntries.add(new BarEntry(0,20f));
        barEntries.add(new BarEntry(1,18f));
        barEntries.add(new BarEntry(2,15f));
        barEntries.add(new BarEntry(3,14f));
        barEntries.add(new BarEntry(4,25f));
        barEntries.add(new BarEntry(5,30f));
        barEntries.add(new BarEntry(6,30f));
        barEntries.add(new BarEntry(7,30f));
        barEntries.add(new BarEntry(8,50f));
        barEntries.add(new BarEntry(9,30f));
        barEntries.add(new BarEntry(10,30f));
        barEntries.add(new BarEntry(11,30f));



        BarDataSet barDataSet=new BarDataSet(barEntries,"Tổng tiền theo tháng (Nghìn/VNĐ)"); //tạo 1 barDataset để đổ list vào

        BarData data=new BarData(barDataSet); //tạo adapter để đổ dataset vào
        data.setBarWidth(0.9f);  //độ rộng mỗi bar (thanh)
        bChart.setData(data); //đổ dữ liệu từ adapter vào Chart

        String[] months=new String[]{"Th1", "Th2", "Th3", "Th4", "Th5", "Th6", "Th7", "Th8", "Th9", "Th10", "Th11", "Th12"};
        XAxis xAxis=bChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValues(months));
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED); //thêm chi tiết tháng xuống bottom
    }

    //
    public class MyXAxisValues implements IAxisValueFormatter{
        private String[] mValues;
        public MyXAxisValues(String[] values) {
        this.mValues=values;
        }


        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int) value];
        }
    }
}
