package cc.ibooker.zmpandroidchartlib;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import cc.ibooker.zmpandroidchartlib.dto.PieChartBean;

/**
 * 扇形图
 *
 * @author 邹峰立
 */
public class ZPieChart extends BasePieChart {

    public ZPieChart(Context context) {
        this(context, null);
    }

    public ZPieChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZPieChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPieChart();
    }

    // 初始化
    private void initPieChart() {
//        // 中间实心圆半径
//        setHoleRadius(0f);
//        // 中间半透明圆半径
//        setTransparentCircleRadius(0f);

        // 隐藏中心圆
        setDrawHoleEnabled(false);

        // 隐藏扇形的内容描述
//        setDrawSliceText(false);
        setDrawEntryLabels(false);

        // 图相对于上下左右的偏移
        setExtraOffsets(10, 10, 10, 10);
        // 初始旋转角度
        setRotationAngle(0);
        // 不可以手动旋转
        setRotationEnabled(false);

        mLegend = getLegend();
        // 设置图例垂直排列
        setLegendOrientation(Legend.LegendOrientation.VERTICAL);
        // 图例居中显示
        setLegendVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
        // 图例右对其
        setLegendHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        // 设置图例色块为圆角
        setLegendForm(Legend.LegendForm.CIRCLE);
        // y轴的间距
        setLegendYEntrySpace(5f);
        // 图例文字的颜色
        setLegendTextColor(Color.parseColor("#000000"));
        // 图例文字的大小
        setLegendTextSize(14);

        mDescription = getDescription();
        // 取消右下角描述
        setDescriptionEnabled(false);
    }

    /**
     * 设置数据
     *
     * @param list        待显示数据
     * @param legendLabel 图例标签
     */
    public ZPieChart setPieData(ArrayList<PieChartBean> list, String legendLabel) {
        if (list != null && list.size() > 0) {
            List<PieEntry> yVals = new ArrayList<>();
            List<Integer> colors = new ArrayList<>();
            for (PieChartBean data : list) {
                PieEntry pieEntry = new PieEntry(data.getChartData(), data.getLabel(), data.getData());
                yVals.add(pieEntry);
                // 添加颜色
                colors.add(data.getColor());
            }

            if (yVals.size() > 0) {
                pieDataSet = new PieDataSet(yVals, legendLabel);
                pieDataSet.setColors(colors);
            }

            // 是否在图上显示数值
            setPieDataSetDrawValues(false);

            // 待显示数据
            pieData = new PieData(pieDataSet);
            this.setData(pieData);
            // 刷新
            invalidate();
        }
        return this;
    }

    /**
     * 设置数据
     *
     * @param list 待显示数据
     */
    public ZPieChart setPieData(ArrayList<PieChartBean> list) {
        return setPieData(list, null);
    }

}
