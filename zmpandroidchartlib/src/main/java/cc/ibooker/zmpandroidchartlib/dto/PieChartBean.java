package cc.ibooker.zmpandroidchartlib.dto;

import android.graphics.Color;
import android.text.TextUtils;

/**
 * 扇形、圆环图数据
 *
 * @author 邹峰立
 */
public class PieChartBean<T> {
    private int color;// 扇形颜色 16进制
    private String colorStr;// 扇形颜色 字符串
    private float chartData;// 图表数据/比例
    private String label;// 图例对应色块标签
    private T data;// 真实数据

    public PieChartBean() {
        super();
    }

    public String getColorStr() {
        return colorStr;
    }

    public void setColorStr(String colorStr) {
        if (!TextUtils.isEmpty(colorStr))
            this.color = Color.parseColor(colorStr);
        this.colorStr = colorStr;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getChartData() {
        return chartData;
    }

    public void setChartData(float chartData) {
        this.chartData = chartData;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PieChartBean{" +
                "color=" + color +
                ", chartData=" + chartData +
                ", label='" + label + '\'' +
                ", data=" + data +
                '}';
    }
}
