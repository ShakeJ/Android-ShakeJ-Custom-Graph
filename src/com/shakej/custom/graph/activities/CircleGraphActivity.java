package com.shakej.custom.graph.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;

import com.shakej.custom.graph.R;
import com.shakej.custom.graph.views.circle.CircleGraphView;
import com.shakej.custom.graph.views.circle.GraphBean;

public class CircleGraphActivity extends Activity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_circle_graph);
    CircleGraphView circleGraphView = (CircleGraphView) findViewById(R.id.circle_graph);
    
    ArrayList<GraphBean> beans = new ArrayList<GraphBean>();
    GraphBean bean = new GraphBean(32, "Monday", "Description", "#203d12");
    beans.add(bean);
    bean = new GraphBean(38, "TuseDay", "Description", "#800000");
    beans.add(bean);
    bean = new GraphBean(18, "WendesDay", "Description", "#808000");
    beans.add(bean);
    bean = new GraphBean(12, "FriDay", "Description", "#2341df");
    beans.add(bean);
    
    circleGraphView.setData(beans);
  }
}
