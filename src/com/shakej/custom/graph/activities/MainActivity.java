package com.shakej.custom.graph.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.shakej.custom.graph.R;

public class MainActivity extends Activity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    ((Button) findViewById(R.id.btn_circle_graph)).setOnClickListener(new OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        startActivity(new Intent(MainActivity.this, CircleGraphActivity.class));
      }
    });
    ((Button) findViewById(R.id.btn_water_graph)).setOnClickListener(new OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        startActivity(new Intent(MainActivity.this, WaterGraphActivity.class));
      }
    });
  }
  
  
  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }
  
  
  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    String url = "https://github.com/ShakeJ/Android-Circle-Graph";
    Intent i = new Intent(Intent.ACTION_VIEW);
    i.setData(Uri.parse(url));
    startActivity(i);
    return super.onOptionsItemSelected(item);
  }
  
}
