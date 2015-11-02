package com.example.sliding.mainview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button button;
    private View leftItemView;
    private View contentView;
    public LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        leftItemView = inflater.inflate(R.layout.layout_leftitem, null);
        contentView = inflater.inflate(R.layout.layout_content, null);

        button = (Button) leftItemView.findViewById(R.id.leftitem_mode_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
