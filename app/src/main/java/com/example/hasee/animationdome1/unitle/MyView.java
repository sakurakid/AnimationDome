package com.example.hasee.animationdome1.unitle;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by hasee on 2018/5/9.
 * 自己写的自定义View
 */

public class MyView extends View {

    public static final float RADIUS = 70f; //圆的半径
    private  Point currentPoint;//当前的坐标
    private Paint mPaint;//画笔


    public MyView(Context context) {
        super(context);
        //初始化画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
    }
    //先在起始点画圆，然后通过监听当前坐标值的变化，每次变化就重新绘制一遍

    @Override
    protected void onDraw(Canvas canvas) {
        //第一次
        if (currentPoint==null){
            currentPoint = new Point(RADIUS,RADIUS);
            //画园
            float x =currentPoint.getX();
            float y =currentPoint.getY();
            canvas.drawCircle(x,y,RADIUS,mPaint);

            //将属性动画作用到View
            //1创建初始动画点的对象点和结束动画时候点的对象点
            Point startPoint = new Point(RADIUS,RADIUS);
            Point endPoint = new Point(700,1000);
            //2创建动画的对象 设置初始值 结束值
            ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(),startPoint,endPoint);
            anim.setDuration(5000);

            //3通过值 的改变 来更新监听器，将当前的值赋值给对象
            //这里是将坐标对象赋值给当前坐标对象
            //当前Point对象每更新一次就调用一次
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    currentPoint = (Point)animation.getAnimatedValue();
                    //将每次变化后的估值器返回的Point对象赋值给当前的Pointduix

                    invalidate();//刷新

                }
            });
            anim.start();

        }else {
            //坐标不为0则画圆
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x,y,RADIUS,mPaint);
        }
    }
}
