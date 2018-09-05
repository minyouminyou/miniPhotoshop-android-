package com.example.youm.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SingleTouchView extends View {
    Paint paint=new Paint();
    Path path=new Path();
    int paintColor=0xfff2d5e7;
    Paint canvasPaint;
    Canvas drawCanvas;
    Bitmap canvasBitmap;

    public SingleTouchView(Context context, AttributeSet attrs)
    {
        super(context,attrs);
        //그림그리기 위한 도구 초기화
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10f);
        paint.setColor(paintColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        canvasBitmap=Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        drawCanvas=new Canvas(canvasBitmap);
        canvasPaint=new Paint(Paint.DITHER_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(canvasBitmap,0,0,canvasPaint);
        canvas.drawPath(path,paint);//손가락 터치시 Path 로 이어진 선을 구한후 그리기
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX=event.getX();
        float touchY=event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawCanvas.drawPath(path,paint);
                path.reset();
                break;
            default://그 이외의 이벤트시 종료
                return  false;
        }
        invalidate(); //onDraw 호출
        return true;
    }


    public void setColor(String newColor)
    {
        invalidate();
        paintColor= Color.parseColor(newColor);//String색상->int색상
        paint.setColor(paintColor);
    }
}









