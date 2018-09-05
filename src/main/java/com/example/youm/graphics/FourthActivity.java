package com.example.youm.graphics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FourthActivity extends AppCompatActivity {
    SingleTouchView drawView;
    LinearLayout paintLayout;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

     drawView = (SingleTouchView)findViewById(R.id.drawView);
        paintLayout = (LinearLayout)findViewById(R.id.paintColor);
        button = (Button)paintLayout.getChildAt(0); //첫번째 버튼이 기본 색상임

        //색상 버튼을 누를 때 호출할 메소드

    }
    public void clickColor(View view){
        if(view!=button){
            String color = view.getTag().toString();
            drawView.setColor(color);
            button=(Button)view;
        }
    }
}
