package com.example.youm.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ThirdActivity extends AppCompatActivity {
    MyGraphicView myGraphicView;
    ImageButton zoomInBtn, zoomOutBtn,roateBtn,brightBtn,darkBtn,grayBtn;

    static float scaleX=1, scaleY=1;
    static float angle =0;
    static float color =1;
    static float satur=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        myGraphicView = new MyGraphicView(this);
        setTitle("미니포토샵");
        LinearLayout canvasLayout = (LinearLayout) findViewById(R.id.paintContent);
        canvasLayout.addView(myGraphicView);
        zoomInBtn = (ImageButton)findViewById(R.id.ZoomIn);
        zoomOutBtn = (ImageButton)findViewById(R.id.ZoomOut);
        roateBtn = (ImageButton)findViewById(R.id.rotate);
        brightBtn = (ImageButton)findViewById(R.id.bright);
        darkBtn = (ImageButton)findViewById(R.id.dark);
        grayBtn = (ImageButton)findViewById(R.id.gray);

        zoomInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX+0.2f;
                scaleY = scaleY+0.2f;
                myGraphicView.invalidate();
            }
        });
        zoomOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX-0.2f;
                scaleY = scaleY-0.2f;
                myGraphicView.invalidate();
            }
        });

        roateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle +=20;
                myGraphicView.invalidate();
            }
        });
        brightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color+=0.2f;
                myGraphicView.invalidate();
            }
        });
        darkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color -= 0.2f;
                myGraphicView.invalidate();
            }
        });
        grayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                satur = satur==0?1:0;
                myGraphicView.invalidate();
            }
        });

    }
    class MyGraphicView extends View{
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            //레나 이미지 정가운데 나타내기
            Bitmap pic = BitmapFactory.decodeResource(getResources(),R.drawable.lena256);
            int picX=(this.getWidth()-pic.getWidth())/2;
            int picY=(this.getHeight()-pic.getHeight())/2;
            //1,2. 확대/축소
            canvas.scale(scaleX,scaleY,this.getWidth()/2,this.getHeight()/2);

            //3
            canvas.rotate(angle,this.getWidth()/2,this.getHeight()/2);

            //4
            Paint paint = new Paint();
            float []array ={
                    color,0,0,0,0,0,
                    color,0,0,0,0,0,
                    color,0,0,0,0,0,1,0};
            ColorMatrix cm = new ColorMatrix(array);

            if (satur ==0){
                cm.setSaturation(satur);
            }
            paint.setColorFilter(new ColorMatrixColorFilter(cm));


            canvas.drawBitmap(pic,picX,picY,paint);
            pic.recycle();
        }
    }
}
