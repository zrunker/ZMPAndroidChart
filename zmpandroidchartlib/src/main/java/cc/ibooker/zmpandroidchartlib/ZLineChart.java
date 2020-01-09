package cc.ibooker.zmpandroidchartlib;

import android.content.Context;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Collections;

import cc.ibooker.zmpandroidchartlib.dto.LineChartBean;

/**
 * 自定义折线图
 *
 * @author 邹峰立
 */
public class ZLineChart extends LineChart {
    private LineDataSet lineDataSet;
    private Legend mLegend;// 图例
    private Description mDescription;// 图表描述区

    public ZLineChart(Context context) {
        this(context, null);
    }

    public ZLineChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZLineChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initZLineChart();
    }

    // 初始化
    private void initZLineChart() {
        // 图例
        mLegend = getLegend();
        // 不显示图例
        mLegend.setEnabled(false);

        // 描述
        mDescription = getDescription();
        // 取消右下角描述
        mDescription.setEnabled(false);
    }

    // 获取LineDataSet
    private LineDataSet getLineDataSet() {
        if (getData() != null && getData().getDataSetCount() > 0)
            lineDataSet = (LineDataSet) getData().getDataSetByIndex(0);
        return lineDataSet;
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

    /**
     * 设置数据
     *
     * @param list  待设置数据
     * @param label 图例标签
     */
    public ZLineChart setLineChartData(ArrayList<LineChartBean> list, String label) {
        if (list != null && list.size() > 0) {
            Collections.sort(list);
            ArrayList<Entry> values = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                LineChartBean data = list.get(i);
                Entry entry = new Entry(data.getX(), data.getY());
                values.add(entry);
            }
            if (getData() != null && getData().getDataSetCount() > 0) {
                lineDataSet = (LineDataSet) getData().getDataSetByIndex(0);
                lineDataSet.setValues(values);
                lineDataSet.setLabel(label);
                getData().notifyDataChanged();
                notifyDataSetChanged();
            } else {
                lineDataSet = new LineDataSet(values, label);
                LineData lineData = new LineData(lineDataSet);
                setData(lineData);
            }
        }
        return this;
    }

    /**
     * 设置数据
     *
     * @param list 待设置数据
     */
    public ZLineChart setLineChartData(ArrayList<LineChartBean> list) {
        return setLineChartData(list, null);
    }

    /**
     * 使线条以虚线模式绘制，例如
     * <p>
     * "- - - - - -". 只有在关闭硬件加速时，此选项才起作用。
     * <p>
     * 请记住，硬件加速可以提高性能。
     *
     * @param lineLength  线段的长度
     * @param spaceLength 碎片之间的空间长度
     * @param phase       相位偏移，单位为度（通常使用0）
     **/
    public ZLineChart enableDashedLine(float lineLength, float spaceLength, float phase) {
        if (lineDataSet != null)
            lineDataSet.enableDashedLine(lineLength, spaceLength, phase);
        return this;
    }

    /**
     * 使突出显示线以虚线模式绘制，例如这样的“----”
     *
     * @param lineLength  线段的长度
     * @param spaceLength 线段之间的间距长度
     * @param phase       相位偏移，单位为度（通常使用0）
     */
    public ZLineChart enableDashedHighlightLine(float lineLength, float spaceLength, float phase) {
        if (lineDataSet != null)
            lineDataSet.enableDashedHighlightLine(lineLength, spaceLength, phase);
        return this;
    }

    /**
     * 设置此数据集应使用的唯一颜色。
     * <p>
     * 在内部，这将重新创建颜色数组并添加指定的颜色。
     *
     * @param color 颜色
     */
    public ZLineChart setColor(int color) {
        if (lineDataSet != null)
            lineDataSet.setColor(color);
        return this;
    }


    /**
     * 设置此数据集应使用的唯一颜色。
     * <p>
     * 在内部，这将重新创建颜色数组并添加指定的颜色。
     *
     * @param color 颜色
     */
    public ZLineChart setCircleColor(int color) {
        if (lineDataSet != null)
            lineDataSet.setCircleColor(color);
        return this;
    }

    /**
     * 设置图表的线宽（最小值=0.2f，最大值=10f）；默认值1f注意：
     * <p>
     * 细线==性能更好，粗线==性能更差
     *
     * @param width 宽度
     */
    public ZLineChart setLineWidth(float width) {
        if (lineDataSet != null)
            lineDataSet.setLineWidth(width);
        return this;
    }

    /**
     * 设置绘制圆的半径。
     * <p>
     * 默认半径=4f，最小值=1f
     *
     * @param radius 半径
     */
    public ZLineChart setCircleRadius(float radius) {
        if (lineDataSet != null)
            lineDataSet.setCircleRadius(radius);
        return this;
    }

    /**
     * 将此设置为true以允许在每个数据圆中绘制孔。
     *
     * @param enabled 是否启用
     */
    public ZLineChart setDrawCircleHole(boolean enabled) {
        if (lineDataSet != null)
            lineDataSet.setDrawCircleHole(enabled);
        return this;
    }

    /**
     * 设置折线图上字体大小
     *
     * @param size 字体大小
     */
    public ZLineChart setValueTextSize(float size) {
        if (lineDataSet != null)
            lineDataSet.setValueTextSize(size);
        return this;
    }

    /**
     * 绘制填充模式
     *
     * @param filled 是否填充
     */
    public ZLineChart setDrawFilled(boolean filled) {
        if (lineDataSet != null)
            lineDataSet.setDrawFilled(filled);
        return this;
    }

    /**
     * 设置表格线条宽度
     *
     * @param formLineWidth 宽度值
     */
    public ZLineChart setFormLineWidth(float formLineWidth) {
        if (lineDataSet != null)
            lineDataSet.setFormLineWidth(formLineWidth);
        return this;
    }

    /**
     * 设置表格线条虚线效果
     *
     * @param dashPathEffect 虚线效果
     */
    public ZLineChart setFormLineDashEffect(DashPathEffect dashPathEffect) {
        if (lineDataSet != null)
            lineDataSet.setFormLineDashEffect(dashPathEffect);
        return this;
    }

    /**
     * 设置表格字体大小
     *
     * @param formSize 字体大小
     */
    public ZLineChart setFormSize(float formSize) {
        if (lineDataSet != null)
            lineDataSet.setFormSize(formSize);
        return this;
    }

    /**
     * 设置用于填充线下区域的颜色。
     * <p>
     * 重置最终设置为“可填充”。
     *
     * @param color 颜色
     */
    public ZLineChart setFillColor(int color) {
        if (lineDataSet != null)
            lineDataSet.setFillColor(color);
        return this;
    }

    /**
     * 设置折线图Mode LineDataSet.Mode.LINEAR LineDataSet.Mode.CUBIC_BEZIER
     *
     * @param mode 模式
     */
    public ZLineChart setMode(LineDataSet.Mode mode) {
        if (lineDataSet != null)
            lineDataSet.setMode(mode);
        return this;
    }

    /**
     * 设置图例显示方向
     *
     * @param value 显示方向，水平或垂直
     */
    public ZLineChart setLegendOrientation(Legend.LegendOrientation value) {
        if (mLegend != null)
            mLegend.setOrientation(value);
        return this;
    }

    /**
     * 设置图例垂直方向显示位置
     *
     * @param value 上中下
     */
    public ZLineChart setLegendVerticalAlignment(Legend.LegendVerticalAlignment value) {
        if (mLegend != null)
            mLegend.setVerticalAlignment(value);
        return this;
    }

    /**
     * 设置图例水平方向显示位置
     *
     * @param value 左中右
     */
    public ZLineChart setLegendHorizontalAlignment(Legend.LegendHorizontalAlignment value) {
        if (mLegend != null)
            mLegend.setHorizontalAlignment(value);
        return this;
    }

    /**
     * x轴的间距
     *
     * @param space 待显示间距
     */
    public ZLineChart setLegendXEntrySpace(float space) {
        if (mLegend != null)
            mLegend.setXEntrySpace(space);
        return this;
    }

    /**
     * y轴的间距
     *
     * @param space 待显示间距
     */
    public ZLineChart setLegendYEntrySpace(float space) {
        if (mLegend != null)
            mLegend.setYEntrySpace(space);
        return this;
    }

    /**
     * 图例的y偏移量
     *
     * @param yOffset 偏移值
     */
    public ZLineChart setLegendYOffset(float yOffset) {
        if (mLegend != null)
            mLegend.setYOffset(yOffset);
        return this;
    }

    /**
     * 图例x的偏移量
     *
     * @param xOffset 偏移值
     */
    public ZLineChart setLegendXOffset(float xOffset) {
        if (mLegend != null)
            mLegend.setXOffset(xOffset);
        return this;
    }

    /**
     * 图例文字的颜色
     *
     * @param color 待显示颜色 16进制
     */
    public ZLineChart setLegendTextColor(int color) {
        if (mLegend != null)
            mLegend.setTextColor(color);
        return this;
    }

    /**
     * 图例文字的大小
     *
     * @param size 文字的大小 dp
     */
    public ZLineChart setLegendTextSize(float size) {
        if (mLegend != null)
            mLegend.setTextSize(size);
        return this;
    }

    /**
     * 设置图例色块形状
     *
     * @param shape 形状 圆形，方形
     */
    public ZLineChart setLegendForm(Legend.LegendForm shape) {
        if (mLegend != null)
            mLegend.setForm(shape);
        return this;
    }

    /**
     * 设置Description是否显示
     *
     * @param enabled 是否显示
     */
    public ZLineChart setDescriptionEnabled(boolean enabled) {
        if (mDescription != null)
            mDescription.setEnabled(enabled);
        return this;
    }

    /**
     * 设置Description显示文本
     *
     * @param text 待显示文本
     */
    public ZLineChart setDescriptionText(String text) {
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
    public ZLineChart setDescriptionPosition(float x, float y) {
        if (mDescription != null)
            mDescription.setPosition(x, y);
        return this;
    }

    /**
     * 设置Description文本方向
     *
     * @param align 文本方向
     */
    public ZLineChart setDescriptionTextAlign(Paint.Align align) {
        if (mDescription != null)
            mDescription.setTextAlign(align);
        return this;
    }
}



