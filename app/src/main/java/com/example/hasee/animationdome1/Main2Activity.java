package com.example.hasee.animationdome1;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private ValueAnimator valueAnimator;//整形估值器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        mButton2 = (Button)findViewById(R.id.btn_play2);
//        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.set_animation1);
//        //载入xml动画
//        animator.setTarget(mButton2.getLayoutParams().width);
//        //设置动画对象
//        animator.start();
//        //启动
        mButton3 = (Button)findViewById(R.id.btn_play3);
        mButton3.setOnClickListener(this);
//
        //创建动画对象
        mButton1 = (Button)findViewById(R.id.btn_play1);
        //1设置属性数值的初始值和结束值
        valueAnimator = ValueAnimator.ofInt(mButton1.getLayoutParams().width,500);
//        初始值 = 当前按钮的宽度
//        结束值 = 500
        ValueAnimator.ofInt();//里面内置了整形估值器，默认看如何变化

        //2设置动画的各种属性
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(5);


        //3将属性数值手动赋值给对象的属性 这里是将值付给按钮的宽度
        //更新监听器，数值每次变化都会调用这个方法

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                //获取每次变化的值

                mButton1.getLayoutParams().width = currentValue;
                //每次赋值

                mButton1.requestLayout();
                //4刷新视图。重新绘制


            }
        });
        //5启动动画
        valueAnimator.start();

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play3:
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
                break;
        }

    }
}
