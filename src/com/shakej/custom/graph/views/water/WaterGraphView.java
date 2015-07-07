package com.shakej.custom.graph.views.water;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shakej.custom.graph.R;

public class WaterGraphView extends LinearLayout
{
  private Context context;
  private View view;
  
  
  public WaterGraphView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    this.context = context;
    init();
  }
  
  
  @SuppressLint("InflateParams")
  private void init()
  {
    view = LayoutInflater.from(context).inflate(R.layout.view_water_graph, null);
    this.addView(view);
  }
  
  
  public void setData(int now, int total)
  {
    double percentage = ((double) now / (double) total);
    percentage = percentage * 100;
    Log.w("WARN", "Food water percentage:" + percentage);
    
    //total 10, watermount 1~10
    int waterMount = 0;
    if (percentage > 9)
    {
      if (percentage > 99)
        waterMount = -1;
      else
      {
        String str = Integer.toString((int) percentage);
        str = str.substring(0, 1);
        Log.w("WARN", "Str : " + str);
        
        waterMount = Integer.parseInt(str);
      }
    }
    Log.w("WARN", "Food waterMount : " + waterMount);
    displayWaterMount(waterMount);
  }
  
  
  private void displayWaterMount(int waterMount)
  {
    for (int i = 1; i < 11; i++)
    {
      String resourceId = "water_" + i;
      
      ImageView waterView = (ImageView) view.findViewById(context.getResources().getIdentifier(resourceId, "id", context.getPackageName()));
      Log.w("WARN", "" + waterView);
      if (waterMount == -1)
        waterView.setImageResource(R.drawable.ic_water_full);
      else
      {
        if (i > waterMount)
          waterView.setImageResource(R.drawable.ic_water);
        else
          waterView.setImageResource(R.drawable.ic_water_full);
      }
    }
  }
}
