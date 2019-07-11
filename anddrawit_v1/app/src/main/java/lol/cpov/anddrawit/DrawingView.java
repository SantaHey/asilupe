package lol.cpov.anddrawit;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;


public class DrawingView extends View {

    private int paintColor;
    private Paint drawPaint;
    private Path path;

    private LinkedList<PointF> points;
    private LinkedList<Integer> temps;
    
    private int MILLIS_TO_WAIT = 20;
    private int timeInit;   // pour calculer le temps entre chaque point
    private Chronometre chronometre = Chronometre.start();

    private Handler handler;


    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();

        path = new Path();
        points = new LinkedList<>();
        temps = new LinkedList<>();
        handler = new Handler();
    }


    private void setupDrawing(){
        drawPaint = new Paint(Paint.ANTI_ALIAS_FLAG);;
        paintColor = Color.parseColor( "#C70039");

        drawPaint.setColor(paintColor);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeWidth(20);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    public void onDraw(Canvas canvas) {
       canvas.drawPath(path, drawPaint);
    }

    public void dessiner() {
        path = drawInit(path);
        invalidate();

        final int[] i = {1};
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                //for (int i = 1; i < points.size(); i++) {
                if (i[0]++ < points.size()-1) {

                    //long time = TIMETOWAIT;
                    long time = TimeUnit.NANOSECONDS.toMillis(temps.get(i[0]));

                    path = drawPath(path, i[0]);
                    postInvalidateDelayed(time);
                    invalidate();
                    handler.postDelayed(this, time);
                }
            }
        };

        handler.post(runnable);
        invalidate();
    }

    public Path drawInit(Path path) {
        path.reset();
        path.moveTo(points.get(0).x, points.get(0).y);
        path.lineTo(points.get(0).x, points.get(0).y);
        return path;
    }

    public Path drawPath(Path path, int index) {
        path.lineTo(points.get(index).x, points.get(index).y);
        return path;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getRawX();
        float touchY = event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                points.clear();
                temps.clear();
                timeInit = chronometre.elapsed();
                break;
            case MotionEvent.ACTION_MOVE:
                points.add(new PointF(touchX, touchY));
                temps.add(chronometre.elapsed() - timeInit);
                timeInit = chronometre.elapsed();
                break;
            case MotionEvent.ACTION_UP:
                points.add(new PointF(touchX, touchY));
                temps.add(chronometre.elapsed() - timeInit);
                String s = "";
                for (int i = 0 ;i<points.size();i++)
                {
                    s += points.get(i).x + ", ";
                    s += temps.get(i);
                }
                Log.d("Array Value", s);
                dessiner();
                break;
            default:
                return false;
        }
        return true;
    }
}