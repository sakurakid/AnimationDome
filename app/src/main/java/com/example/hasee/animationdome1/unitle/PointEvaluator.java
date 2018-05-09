package com.example.hasee.animationdome1.unitle;

import android.animation.TypeEvaluator;

/**
 * Created by hasee on 2018/5/9.
 * 自己写的估值器
 */

public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        //讲动画的初始值和结束值强制转换为Point对象
        Point startPoint = (Point)startValue;
        Point endPoint = (Point)endValue;

        //根据fraction来计算当前的x和y的值
        float x = startPoint.getX()+fraction*(endPoint.getX()-startPoint.getX());
        float y = startPoint.getY()+fraction*(endPoint.getY()-startPoint.getY());
        //将算好的坐标封装好给一个新的Point对象并返回
        Point point = new Point(x,y);
      return point;
    }
}
