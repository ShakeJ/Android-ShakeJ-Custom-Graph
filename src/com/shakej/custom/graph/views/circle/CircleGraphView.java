package com.shakej.custom.graph.views.circle;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.shakej.custom.graph.R;

public class CircleGraphView extends LinearLayout
{
  private Context context;
  private LinearLayout container;
  
  
  public CircleGraphView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    this.context = context;
    init();
  }
  
  
  @SuppressLint("InflateParams")
  private void init()
  {
    View view = LayoutInflater.from(context).inflate(R.layout.view_circle_graph, null);
    container = (LinearLayout) view.findViewById(R.id.container);
    
    this.addView(view);
  }
  
  
  public void setData(final ArrayList<GraphBean> beans)
  {
    container.removeAllViews();
    
    this.post(new Runnable()
    {
      @Override
      public void run()
      {
        int totalPercentage = 0;
        for (int i = 0; i < beans.size(); i++)
        {
          totalPercentage += beans.get(i).percentage;
        }
        
        int displayHeight = getHeight();
        Log.w("WARN", "Display Height : " + displayHeight);
        
        for (int i = 0; i < beans.size(); i++)
        {
          double beanPercentage = (double) beans.get(i).percentage / (double) totalPercentage;
          int viewHeight = (int) (displayHeight * beanPercentage);
          beans.get(i).viewHeight = viewHeight;
        }
        
        for (int i = 0; i < beans.size(); i++)
        {
          InnerCircleView graphView = new InnerCircleView(context);
          graphView.setData(beans.get(i));
          container.addView(graphView);
        }
      }
    });
    
  }
}
