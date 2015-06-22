package com.shakej.circle.graph.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;

import com.shakej.circle.graph.R;
import com.shakej.circle.graph.views.CircleGraphView;
import com.shakej.circle.graph.views.GraphBean;

public class MainActivity extends Activity
{
  private CircleGraphView circleGraphView;
  
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    circleGraphView = (CircleGraphView) findViewById(R.id.circle_graph);
    
    //Test array
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
