package cc.ibooker.zmpandroidchartlib;

import android.content.Context;
import android.graphics.Paint;
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
 * PieChart基类
 *
 * @author 邹峰立
 */
public class BasePieChart extends PieChart {
    protected PieData pieData;
    protected PieDataSet pieDataSet;
    protected Legend mLegend;// 图例
    protected Description mDescription;// 图表描述区

    // 获取PieDataSet
    public PieDataSet getPieDataSet() {
        return pieDataSet;
    }

    // 获取PieData
    public PieData getPieData() {
        return pieData;
    }

    // 得到图列Legend
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

    public BasePieChart(Context context) {
        super(context);
    }

    public BasePieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BasePieChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 设置数据
     *
     * @param list        待显示数据
     * @param legendLabel 图例标签
     */
    public BasePieChart setPieData(ArrayList<PieChartBean> list, String legendLabel) {
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

            // 待显示数据
            pieData = new PieData(pieDataSet);

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
    public BasePieChart setPieData(ArrayList<PieChartBean> list) {
        return setPieData(list, null);
    }

    /**
     * 是否在图上显示数值
     *
     * @param enabled true/false
     */
    public BasePieChart setPieDataSetDrawValues(boolean enabled) {
        if (pieDataSet != null)
            pieDataSet.setDrawValues(enabled);
        return this;
    }

    /**
     * 格式化显示的数据为%百分比
     *
     * @param f 格式化
     */
    public BasePieChart setPieDataValueFormatter(IValueFormatter f) {
        if (pieData != null)
            pieData.setValueFormatter(f);
        return this;
    }

    /**
     * 设置饼状Item被选中时变化的距离
     *
     * @param shift 距离
     */
    public BasePieChart setPieDataSetSelectionShift(float shift) {
        if (pieDataSet != null)
            pieDataSet.setSelectionShift(shift);
        return this;
    }

    /**
     * 设置每条之前的间隙
     *
     * @param spaceDp 间隙
     */
    public BasePieChart setPieDataSetSliceSpace(float spaceDp) {
        if (pieDataSet != null)
            pieDataSet.setSliceSpace(spaceDp);
        return this;
    }

    /**
     * 设置Y值的位置是在圆内还是圆外
     *
     * @param yValuePosition Y值的位置
     */
    public BasePieChart setPieDataSetYValuePosition(PieDataSet.ValuePosition yValuePosition) {
        if (pieDataSet != null)
            pieDataSet.setYValuePosition(yValuePosition);
        return this;
    }

    /**
     * 当值位置为外边线时，表示线的颜色。
     *
     * @param valueLineColor 线的颜色
     */
    public BasePieChart setPieDataSetValueLineColor(int valueLineColor) {
        if (pieDataSet != null)
            pieDataSet.setValueLineColor(valueLineColor);
        return this;
    }

    /**
     * 当ValuePosits为OutsiDice时，指示偏移为切片大小的百分比
     *
     * @param valueLinePart1OffsetPercentage 偏移为切片大小的百分比
     */
    public BasePieChart setPieDataSetValueLinePart1OffsetPercentage(float valueLinePart1OffsetPercentage) {
        if (pieDataSet != null)
            pieDataSet.setValueLinePart1OffsetPercentage(valueLinePart1OffsetPercentage);
        return this;
    }

    /**
     * 当值位置为外边线时，表示线的后半段长度。
     *
     * @param valueLinePart2Length 后半段长度
     */
    public BasePieChart setPieDataSetValueLinePart2Length(float valueLinePart2Length) {
        if (pieDataSet != null)
            pieDataSet.setValueLinePart2Length(valueLinePart2Length);
        return this;
    }

    /**
     * 当值位置为外边线时，表示线的前半段长度。
     *
     * @param valueLinePart1Length 前半段长度
     */
    public BasePieChart setPieDataSetValueLinePart1Length(float valueLinePart1Length) {
        if (pieDataSet != null)
            pieDataSet.setValueLinePart1Length(valueLinePart1Length);
        return this;
    }

    /**
     * 设置图表文字的样式
     *
     * @param tf 文字的样式
     */
    public BasePieChart setPieDataSetValueTypeface(Typeface tf) {
        if (pieDataSet != null)
            pieDataSet.setValueTypeface(tf);
        return this;
    }

    /**
     * 设置图表文字的颜色
     *
     * @param color 颜色值 16进制
     */
    public BasePieChart setPieDataSetValueTextColor(int color) {
        if (pieDataSet != null)
            pieDataSet.setValueTextColor(color);
        return this;
    }

    /**
     * 设置图表文字的大小
     *
     * @param size 文字大小 dp
     */
    public BasePieChart setPieDataSetValueTextSize(float size) {
        if (pieDataSet != null)
            pieDataSet.setValueTextSize(size);
        return this;
    }

    /**
     * 设置图例显示方向
     *
     * @param value 显示方向，水平或垂直
     */
    public BasePieChart setLegendOrientation(Legend.LegendOrientation value) {
        if (mLegend != null)
            mLegend.setOrientation(value);
        return this;
    }

    /**
     * 设置图例垂直方向显示位置
     *
     * @param value 上中下
     */
    public BasePieChart setLegendVerticalAlignment(Legend.LegendVerticalAlignment value) {
        if (mLegend != null)
            mLegend.setVerticalAlignment(value);
        return this;
    }

    /**
     * 设置图例水平方向显示位置
     *
     * @param value 左中右
     */
    public BasePieChart setLegendHorizontalAlignment(Legend.LegendHorizontalAlignment value) {
        if (mLegend != null)
            mLegend.setHorizontalAlignment(value);
        return this;
    }

    /**
     * x轴的间距
     *
     * @param space 待显示间距
     */
    public BasePieChart setLegendXEntrySpace(float space) {
        if (mLegend != null)
            mLegend.setXEntrySpace(space);
        return this;
    }

    /**
     * y轴的间距
     *
     * @param space 待显示间距
     */
    public BasePieChart setLegendYEntrySpace(float space) {
        if (mLegend != null)
            mLegend.setYEntrySpace(space);
        return this;
    }

    /**
     * 图例的y偏移量
     *
     * @param yOffset 偏移值
     */
    public BasePieChart setLegendYOffset(float yOffset) {
        if (mLegend != null)
            mLegend.setYOffset(yOffset);
        return this;
    }

    /**
     * 图例x的偏移量
     *
     * @param xOffset 偏移值
     */
    public BasePieChart setLegendXOffset(float xOffset) {
        if (mLegend != null)
            mLegend.setXOffset(xOffset);
        return this;
    }

    /**
     * 图例文字的颜色
     *
     * @param color 待显示颜色 16进制
     */
    public BasePieChart setLegendTextColor(int color) {
        if (mLegend != null)
            mLegend.setTextColor(color);
        return this;
    }

    /**
     * 图例文字的大小
     *
     * @param size 文字的大小 dp
     */
    public BasePieChart setLegendTextSize(float size) {
        if (mLegend != null)
            mLegend.setTextSize(size);
        return this;
    }

    /**
     * 设置图例色块形状
     *
     * @param shape 形状 圆形，方形
     */
    public BasePieChart setLegendForm(Legend.LegendForm shape) {
        if (mLegend != null)
            mLegend.setForm(shape);
        return this;
    }

    /**
     * 设置Description是否显示
     *
     * @param enabled 是否显示
     */
    public BasePieChart setDescriptionEnabled(boolean enabled) {
        if (mDescription != null)
            mDescription.setEnabled(enabled);
        return this;
    }

    /**
     * 设置Description显示文本
     *
     * @param text 待显示文本
     */
    public BasePieChart setDescriptionText(String text) {
        if (mDescription != null)
            mDescription.setText(text);
        return this;
    }

    /**
     * 设置Description在屏幕上的显示位置
     *
     * @param x - X轴偏移
     * @param y - Y轴偏移
     */
    public BasePieChart setDescriptionPosition(float x, float y) {
        if (mDescription != null)
            mDescription.setPosition(x, y);
        return this;
    }

    /**
     * 设置Description文本方向
     *
     * @param align 文本方向
     */
    public BasePieChart setDescriptionTextAlign(Paint.Align align) {
        if (mDescription != null)
            mDescription.setTextAlign(align);
        return this;
    }
}
