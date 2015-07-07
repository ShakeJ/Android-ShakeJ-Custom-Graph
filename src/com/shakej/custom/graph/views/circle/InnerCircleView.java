package com.shakej.custom.graph.views.circle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shakej.custom.graph.R;

public class InnerCircleView extends LinearLayout
{
  private Context context;
  private TextView title;
  private ImageView circleView;
  private TextView circleText;
  private TextView description;
  private RelativeLayout circleContainer;
  
  
  public InnerCircleView(Context context)
  {
    super(context);
    this.context = context;
    init();
  }
  
  
  public InnerCircleView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    this.context = context;
    init();
  }
  
  
  @SuppressLint({ "InflateParams" })
  private void init()
  {
    View view = LayoutInflater.from(context).inflate(R.layout.view_inner_graph, null);
    title = (TextView) view.findViewById(R.id.title);
    circleView = (ImageView) view.findViewById(R.id.circle_view);
    circleText = (TextView) view.findViewById(R.id.circle_text);
    description = (TextView) view.findViewById(R.id.description);
    circleContainer = (RelativeLayout) view.findViewById(R.id.circle_container);
    this.addView(view);
  }
  
  
  public void setData(GraphBean bean)
  {
    title.setText(bean.title);
    circleText.setText(bean.percentage + "%");
    description.setText(bean.description);
    int height = bean.viewHeight;
    this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, height));
    
    GradientDrawable drawable = new GradientDrawable();
    if (!TextUtils.isEmpty(bean.colorCode))
    {
      try
      {
        drawable.setColor(Color.parseColor(bean.colorCode));
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
      drawable.setColor(Color.BLACK);
    drawable.setShape(GradientDrawable.OVAL);
    drawable.setSize(height, height);
    circleView.setImageDrawable(drawable);
    
  }
}
