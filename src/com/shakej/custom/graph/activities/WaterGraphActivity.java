package com.shakej.custom.graph.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.shakej.custom.graph.R;
import com.shakej.custom.graph.views.water.WaterGraphView;

public class WaterGraphActivity extends Activity
{
  private WaterGraphView waterGraphView;
  
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_water_graph);
    
    waterGraphView = (WaterGraphView) findViewById(R.id.water_graph);
    waterGraphView.setData(100, 700);
    
    final EditText editMount = (EditText) findViewById(R.id.mount);
    final EditText editTotal = (EditText) findViewById(R.id.total);
    ((Button) findViewById(R.id.btn_generate)).setOnClickListener(new OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        int mount = 0;
        int total = 0;
        if (!TextUtils.isEmpty(editMount.getText().toString()))
          mount = Integer.parseInt(editMount.getText().toString());
        
        if (!TextUtils.isEmpty(editTotal.getText().toString()))
          total = Integer.parseInt(editTotal.getText().toString());
        
        waterGraphView.setData(mount, total);
      }
    });
  }
}
