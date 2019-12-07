# ZMPAndroidChart
基于MPAndroidChart开发PieChart扇形图、圆环图

## 引入ZMPAndroidChart

**方式一：Gradle方法引入**

在相应Module目录下的build.gradle文件中添加如下代码：
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
	implementation 'com.github.zrunker:ZMPAndroidChart:Tag'
}
```

**方式二：Maven方式引入**

```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>

<dependency>
	<groupId>com.github.zrunker</groupId>
	<artifactId>ZMPAndroidChart</artifactId>
	<version>v1.0</version>
</dependency>
```

**方式三：导入lib库**

下载ZMPAndroidChart工程，找到工程中的zmpandroidchartlib包，引入你的工程：
```
dependencies {
    ...
    implementation project(':zmpandroidchartlib')
}
```

## 具体使用

**ZPieChart扇形图**

一、引入布局文件
```
<cc.ibooker.zmpandroidchartlib.ZPieChart
    android:id="@+id/z_pie_chart"
    android:layout_width="match_parent"
    android:layout_height="250dp" />
```

二、显示数据
```
// 初始化控件
private void initView() {
    // 扇形图
    pieChart = findViewById(R.id.z_pie_chart);
    initPieChart();
}

// 显示扇形图
private void initPieChart() {
    // 初始化数据数据
    ArrayList<PieChartBean> list = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
        PieChartBean<String> pieChartBean = new PieChartBean<>();
        list.add(pieChartBean);
        if (i == 0) {
            pieChartBean.setColorStr("#1B9E0D");
            pieChartBean.setProportion(0.3f);
            pieChartBean.setLabel("运费冻结");
        } else if (i == 1) {
            pieChartBean.setColorStr("#67E020");
            pieChartBean.setProportion(0.1f);
            pieChartBean.setLabel("待扣税金");
        } else {
            pieChartBean.setColorStr("#E02020");
            pieChartBean.setProportion(0.6f);
            pieChartBean.setLabel("可提现余额");
        }
    }
    // 显示数据
    pieChart.setPieData(list);
}
```

**ZRingChart圆环图**

一、引入布局文件
```
<cc.ibooker.zmpandroidchartlib.ZRingChart
    android:id="@+id/z_pie_chart"
    android:layout_width="match_parent"
    android:layout_height="250dp" />
```

二、显示数据
```
// 初始化控件
private void initView() {
    // 扇形图
    pieChart = findViewById(R.id.z_pie_chart);
    initPieChart();
}

// 显示扇形图
private void initPieChart() {
    // 初始化数据数据
    ArrayList<PieChartBean> list = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
        PieChartBean<String> pieChartBean = new PieChartBean<>();
        list.add(pieChartBean);
        if (i == 0) {
            pieChartBean.setColorStr("#1B9E0D");
            pieChartBean.setProportion(0.3f);
            pieChartBean.setLabel("运费冻结");
        } else if (i == 1) {
            pieChartBean.setColorStr("#67E020");
            pieChartBean.setProportion(0.1f);
            pieChartBean.setLabel("待扣税金");
        } else {
            pieChartBean.setColorStr("#E02020");
            pieChartBean.setProportion(0.6f);
            pieChartBean.setLabel("可提现余额");
        }
    }

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
```

最终效果图：
![最终效果图](https://github.com/zrunker/ZMPAndroidChart/blob/master/device-2019-12-07-115637.png)
