package cc.ibooker.zmpandroidchartlib.dto;

/**
 * 折线图数据
 *
 * @author 邹峰立
 */
public class LineChartBean<T> implements Comparable<LineChartBean> {
    private float x;
    private float y;
    private T data;

    public LineChartBean() {
        super();
    }

    public LineChartBean(float x, float y, T data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LineChartBean{" +
                "x=" + x +
                ", y=" + y +
                ", data=" + data +
                '}';
    }

    @Override
    public int compareTo(LineChartBean lineChartBean) {
        return (int) (getX() * 1000000 - lineChartBean.getX() * 1000000);
    }
}
