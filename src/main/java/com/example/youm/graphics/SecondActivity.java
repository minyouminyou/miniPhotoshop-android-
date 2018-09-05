package com.example.youm.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
        setContentView(new MyGraphicView((this)));
    }
    class MyGraphicView extends View{
        MyGraphicView(Context c){
            super(c);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //이미지를 경로를 이용해서 가져오고자 할 때
//            Bitmap picture1= BitmapFactory.decodeFile();
            Bitmap picture1 = BitmapFactory.decodeResource(getResources(),R.drawable.c1);
            canvas.drawBitmap(picture1,100,100,null);
            Bitmap picture2 = BitmapFactory.decodeResource(getResources(),R.drawable.c3);
            canvas.drawBitmap(picture2,500,500,null);

            //이미지 사이즈를 변경하고자 할 경우
            Bitmap p1_scale = Bitmap.createScaledBitmap(picture1,300,300,false);
            Bitmap p2_scale = Bitmap.createScaledBitmap(picture2,300,300,false);

            canvas.drawBitmap(p1_scale,300,700,null);
            canvas.drawBitmap(p2_scale,300,900,null);
//            p1_scale.recycle();
//            p2_scale.recycle();
//            picture1.recycle();
//            picture2.recycle();

            //이미지 반전
            Matrix m = new Matrix();
            m.preScale(-1,-1);//상하 뒤집기 변환행렬
            Bitmap mb1 = Bitmap.createBitmap(picture2, 0,0,picture1.getWidth(),picture1.getHeight(),m,false);
            Bitmap p3_scale = Bitmap.createScaledBitmap(mb1,300,300,false);
            canvas.drawBitmap(p3_scale,100,300,null);

            //30도 회전
            canvas.rotate(30,500,100);
            canvas.drawBitmap(picture2,500,1000,null);


            canvas.rotate(60,500,100);
            canvas.drawBitmap(picture2,1000,1000,null);

            //확대 방법
            canvas.scale(2,2,0,0);
            canvas.drawBitmap(picture2,1000,500,null);

        }
    }
}
