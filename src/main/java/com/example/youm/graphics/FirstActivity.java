package com.example.youm.graphics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_first);
        setContentView(new MyGraphicView(this));

    }

    //그래픽 내부 클래스
    public static class MyGraphicView extends View{
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
//            paint.setAntiAlias(true); //도형의 끝을 부드럽게 처리
//            paint.setColor(Color.rgb(154,66,175));
//
//            paint.setStrokeWidth(10);
//            canvas.drawLine(100,100,500,100, paint);
//
//            paint.setColor(Color.RED);
//            paint.setStrokeWidth(20);
//            canvas.drawLine(100,200,800,200, paint);
//
//            paint.setStyle(Paint.Style.FILL);
//            paint.setColor(Color.BLACK);
//            Rect rect1 = new Rect(500,200,200,500);
//            canvas.drawRect(rect1,paint);
//
//            paint.setColor(Color.YELLOW);
//            RectF rect2 = new RectF(300,100,100,300);
//            canvas.drawRoundRect(rect2,200,200 ,paint);
//
//            //이어진 선 그리기
            paint.setColor(Color.GREEN);
            Path path1 = new Path();
            path1.moveTo(600, 900);
            path1.lineTo(100,1500);
            path1.lineTo(1100,1500);
            path1.lineTo(600,900);
            canvas.drawPath(path1,paint);
            paint.setColor(Color.BLACK);
            paint.setTextSize(60);
            canvas.drawText("제목: 산",100,200,paint);
            Path roof = new Path();
            paint.setColor(Color.GREEN);
            paint.setStyle(Paint.Style.FILL);
            roof.moveTo(500,600);
            roof.lineTo(300,800);
            roof.lineTo(700,800);
            roof.lineTo(500,600);
            canvas.drawPath(roof,paint);
        }
    }

}
