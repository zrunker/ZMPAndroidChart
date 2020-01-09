package cc.ibooker.zmpandroidchart;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;

import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import cc.ibooker.zmpandroidchartlib.ZLineChart;
import cc.ibooker.zmpandroidchartlib.ZPieChart;
import cc.ibooker.zmpandroidchartlib.ZRingChart;
import cc.ibooker.zmpandroidchartlib.dto.LineChartBean;
import cc.ibooker.zmpandroidchartlib.dto.PieChartBean;

public class MainActivity extends AppCompatActivity {
    private ZRingChart pieChart;
    private ZPieChart zPieChart;
    private ZLineChart zLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    // 初始化控件
    private void initView() {
        // 扇形图
        zPieChart = findViewById(R.id.z_pie_chart_1);
        // 圆环图
        pieChart = findViewById(R.id.z_pie_chart);
        // 折线图
        zLineChart = findViewById(R.id.z_line_chart);

        // 初始化图形
        initPieChart();
        // 初始化折线图
        initLineChart();
    }

    // 显示扇形图 - 圆环图
    private void initPieChart() {
        // 初始化数据数据
        ArrayList<PieChartBean> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            PieChartBean<String> pieChartBean = new PieChartBean<>();
            list.add(pieChartBean);
            if (i == 0) {
                pieChartBean.setColorStr("#1B9E0D");
                pieChartBean.setChartData(3000.5f);
                pieChartBean.setLabel("支出运费(万元)");
            } else if (i == 1) {
                pieChartBean.setColorStr("#67E020");
                pieChartBean.setChartData(1000.37f);
                pieChartBean.setLabel("支出税(万元)");
            } else {
                pieChartBean.setColorStr("#E02020");
                pieChartBean.setChartData(6000.78f);
                pieChartBean.setLabel("总利润(万元)");
            }
        }

        // 设置扇形图
        zPieChart.setPieData(list);

        // 设置圆环图
        // 设置中间文字
        pieChart.setCenterText(generateCenterText(8888.88f));
        pieChart.setCenterTextColor(Color.parseColor("#999999"));
        pieChart.setCenterTextSize(12);
        // 显示数据
        pieChart.setPieData(list);
    }

    /**
     * 中间文字绘制
     *
     * @param sum 总数
     */
    private SpannableString generateCenterText(float sum) {
        String total = Float.toString(sum);
        SpannableString s = new SpannableString("总收入\n" + total + "\n（万元）");
        int start = 4;
        int end = 4 + total.length();
        s.setSpan(new RelativeSizeSpan(2f), start, end, 0);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), start, end, 0);
        return s;
    }

    // 初始化折线图数据
    private void initLineChart() {
        ArrayList<LineChartBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            LineChartBean lineChartBean = new LineChartBean();
            lineChartBean.setX(i);
            lineChartBean.setY(10 + i);
            list.add(lineChartBean);
        }
        for (int i = 0; i < 5; i++) {
            LineChartBean lineChartBean = new LineChartBean();
            lineChartBean.setX(10 - i);
            lineChartBean.setY(15 - i);
            list.add(lineChartBean);
        }
        zLineChart.setLineChartData(list, null)
                .enableDashedLine(10f, 5f, 0f)
                .setColor(Color.BLACK)
                .setCircleColor(Color.BLACK)
                .setLineWidth(1f)
                .setCircleRadius(3f)
                .setDrawCircleHole(false)
                .setValueTextSize(9f)
                .setDrawFilled(true)
                .setFormLineWidth(1f)
                .setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f))
                .setFormSize(15f)
                .setFillColor(Color.YELLOW)
                .setMode(LineDataSet.Mode.CUBIC_BEZIER)
                .enableDashedHighlightLine(10f, 5f, 0f);
    }
}





