package cc.ibooker.zmpandroidchartlib;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;

import java.util.ArrayList;
import java.util.List;

import cc.ibooker.zmpandroidchartlib.dto.PieChartBean;

/**
 * 圆环图
 *
 * @author 邹峰立
 */
public class ZRingChart extends PieChart {
    private PieData pieData;
    private PieDataSet pieDataSet;
    private Legend mLegend;// 图例
    private Description mDescription;// 图表描述区

    // 获取PieDataSet
    public PieDataSet getPieDataSet() {
        return pieDataSet;
    }

    // 获取PieData
    public PieData getPieData() {
        return pieData;
    }

    // 得到图片Legend
    public Legend getLegend() {
        if (mLegend == null)
            mLegend = super.getLegend();
        return mLegend;
    }

    // 得到图表描述区
    public Description getDescription() {
        if (mDescription == null)
            mDescription = super.getDescription();
        return mDescription;
    }

    public ZRingChart(Context context) {
        this(context, null);
    }

    public ZRingChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZRingChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPieChart();
    }

    // 初始化
    private void initPieChart() {
        // 隐藏半透明圈
        setTransparentCircleRadius(0f);
        // 设置中间圆半径
        setHoleRadius(62f);

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
        setLegendYEntrySpace(10f);
        // 图例文字的颜色
        setLegendTextColor(Color.parseColor("#999999"));
        // 图例文字的大小
        setLegendTextSize(12);

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
    public ZRingChart setPieData(ArrayList<PieChartBean> list, String legendLabel) {
        if (list != null && list.size() > 0) {
            List<PieEntry> yVals = new ArrayList<>();
            List<Integer> colors = new ArrayList<>();
            for (PieChartBean data : list) {
                PieEntry pieEntry = new PieEntry(data.getProportion(), data.getLabel(), data.getData());
                yVals.add(pieEntry);
                // 添加颜色
                colors.add(data.getColor());
            }

            if (yVals.size() > 0) {
                pieDataSet = new PieDataSet(yVals, legendLabel);
                pieDataSet.setColors(colors);
            }

//            // 是否在图上显示数值
//            setPieDataSetDrawValues(false);

            // 待显示数据
            pieData = new PieData(pieDataSet);
            // 设置显示文字大小
            setPieDataSetValueTextSize(15);

            // 显示数据
            setData(pieData);
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
    public ZRingChart setPieData(ArrayList<PieChartBean> list) {
        return setPieData(list, null);
    }

    /**
     * 是否在图上显示数值
     *
     * @param enabled true/false
     */
    public ZRingChart setPieDataSetDrawValues(boolean enabled) {
        if (pieDataSet != null)
            pieDataSet.setDrawValues(enabled);
        return this;
    }

    /**
     * 格式化显示的数据为%百分比
     *
     * @param f 格式化
     */
    public ZRingChart setPieDataValueFormatter(IValueFormatter f) {
        if (pieData != null)
            pieData.setValueFormatter(f);
        return this;
    }

    /**
     * 设置饼状Item被选中时变化的距离
     *
     * @param shift 距离
     */
    public ZRingChart setPieDataSetSelectionShift(float shift) {
        if (pieDataSet != null)
            pieDataSet.setSelectionShift(shift);
        return this;
    }

    /**
     * 设置每条之前的间隙
     *
     * @param spaceDp 间隙
     */
    public ZRingChart setPieDataSetSliceSpace(float spaceDp) {
        if (pieDataSet != null)
            pieDataSet.setSliceSpace(spaceDp);
        return this;
    }

    /**
     * 设置Y值的位置是在圆内还是圆外
     *
     * @param yValuePosition Y值的位置
     */
    public ZRingChart setPieDataSetYValuePosition(PieDataSet.ValuePosition yValuePosition) {
        if (pieDataSet != null)
            pieDataSet.setYValuePosition(yValuePosition);
        return this;
    }

    /**
     * 当值位置为外边线时，表示线的颜色。
     *
     * @param valueLineColor 线的颜色
     */
    public ZRingChart setPieDataSetValueLineColor(int valueLineColor) {
        if (pieDataSet != null)
            pieDataSet.setValueLineColor(valueLineColor);
        return this;
    }

    /**
     * 当ValuePosits为OutsiDice时，指示偏移为切片大小的百分比
     *
     * @param valueLinePart1OffsetPercentage 偏移为切片大小的百分比
     */
    public ZRingChart setPieDataSetValueLinePart1OffsetPercentage(float valueLinePart1OffsetPercentage) {
        if (pieDataSet != null)
            pieDataSet.setValueLinePart1OffsetPercentage(valueLinePart1OffsetPercentage);
        return this;
    }

    /**
     * 当值位置为外边线时，表示线的后半段长度。
     *
     * @param valueLinePart2Length 后半段长度
     */
    public ZRingChart setPieDataSetValueLinePart2Length(float valueLinePart2Length) {
        if (pieDataSet != null)
            pieDataSet.setValueLinePart2Length(valueLinePart2Length);
        return this;
    }

    /**
     * 当值位置为外边线时，表示线的前半段长度。
     *
     * @param valueLinePart1Length 前半段长度
     */
    public ZRingChart setPieDataSetValueLinePart1Length(float valueLinePart1Length) {
        if (pieDataSet != null)
            pieDataSet.setValueLinePart1Length(valueLinePart1Length);
        return this;
    }

    /**
     * 设置图表文字的样式
     *
     * @param tf 文字的样式
     */
    public ZRingChart setPieDataSetValueTypeface(Typeface tf) {
        if (pieDataSet != null)
            pieDataSet.setValueTypeface(tf);
        return this;
    }

    /**
     * 设置图表文字的颜色
     *
     * @param color 颜色值 16进制
     */
    public ZRingChart setPieDataSetValueTextColor(int color) {
        if (pieDataSet != null)
            pieDataSet.setValueTextColor(color);
        return this;
    }

    /**
     * 设置图表文字的大小
     *
     * @param size 文字大小 dp
     */
    public ZRingChart setPieDataSetValueTextSize(float size) {
        if (pieDataSet != null)
            pieDataSet.setValueTextSize(size);
        return this;
    }

    /**
     * 设置图例显示方向
     *
     * @param value 显示方向，水平或垂直
     */
    public ZRingChart setLegendOrientation(Legend.LegendOrientation value) {
        if (mLegend != null)
            mLegend.setOrientation(value);
        return this;
    }

    /**
     * 设置图例垂直方向显示位置
     *
     * @param value 上中下
     */
    public ZRingChart setLegendVerticalAlignment(Legend.LegendVerticalAlignment value) {
        if (mLegend != null)
            mLegend.setVerticalAlignment(value);
        return this;
    }

    /**
     * 设置图例水平方向显示位置
     *
     * @param value 左中右
     */
    public ZRingChart setLegendHorizontalAlignment(Legend.LegendHorizontalAlignment value) {
        if (mLegend != null)
            mLegend.setHorizontalAlignment(value);
        return this;
    }

    /**
     * x轴的间距
     *
     * @param space 待显示间距
     */
    public ZRingChart setLegendXEntrySpace(float space) {
        if (mLegend != null)
            mLegend.setXEntrySpace(space);
        return this;
    }

    /**
     * y轴的间距
     *
     * @param space 待显示间距
     */
    public ZRingChart setLegendYEntrySpace(float space) {
        if (mLegend != null)
            mLegend.setYEntrySpace(space);
        return this;
    }

    /**
     * 图例的y偏移量
     *
     * @param yOffset 偏移值
     */
    public ZRingChart setLegendYOffset(float yOffset) {
        if (mLegend != null)
            mLegend.setYOffset(yOffset);
        return this;
    }

    /**
     * 图例x的偏移量
     *
     * @param xOffset 偏移值
     */
    public ZRingChart setLegendXOffset(float xOffset) {
        if (mLegend != null)
            mLegend.setXOffset(xOffset);
        return this;
    }

    /**
     * 图例文字的颜色
     *
     * @param color 待显示颜色 16进制
     */
    public ZRingChart setLegendTextColor(int color) {
        if (mLegend != null)
            mLegend.setTextColor(color);
        return this;
    }

    /**
     * 图例文字的大小
     *
     * @param size 文字的大小 dp
     */
    public ZRingChart setLegendTextSize(float size) {
        if (mLegend != null)
            mLegend.setTextSize(size);
        return this;
    }

    /**
     * 设置图例色块形状
     *
     * @param shape 形状 圆形，方形
     */
    public ZRingChart setLegendForm(Legend.LegendForm shape) {
        if (mLegend != null)
            mLegend.setForm(shape);
        return this;
    }

    /**
     * 设置Description是否显示
     *
     * @param enabled 是否显示
     */
    public ZRingChart setDescriptionEnabled(boolean enabled) {
        if (mDescription != null)
            mDescription.setEnabled(enabled);
        return this;
    }
}
