package com.example.hasee.animationdome1;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.hasee.animationdome1.unitle.ColorEvaluator;
import com.example.hasee.animationdome1.unitle.MyView2;

public class Main3Activity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    MyView2 myView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button1 = (Button)findViewById(R.id.btn_ow1);
        button2 = (Button)findViewById(R.id.btn_ow2);
        button3 = (Button)findViewById(R.id.btn_ow3);
        button4 = (Button)findViewById(R.id.btn_ow4);
        ObjectAnimator animator = ObjectAnimator.ofFloat(button1,"alpha",1f,0f,1f);
        //第一个参数是动画的对象 第二个是操作的对象的属性 第三个是初始值 最后一个是结束的值
        animator.setDuration(5000);
        animator.setRepeatCount(-1);

        animator.start();

//
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(button2,"rotation",0f,360f);
        animator1.setDuration(5000);
        animator1.setRepeatCount(-1);
        animator1.start();

        float curTranslationX = button3.getTranslationX();
        //获取当前位置
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(button3,"translationX",curTranslationX,300,curTranslationX);
        animator2.setDuration(5000);
        animator2.setRepeatCount(-1);
        animator2.start();

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(button4,"scaleX",1f,3f,1f);
        animator3.setDuration(5000);
        animator3.setRepeatCount(-1);
        animator3.start();

        myView2 = (MyView2)findViewById(R.id.MyView2);
        ObjectAnimator anim4 = ObjectAnimator.ofObject(myView2, "color", new ColorEvaluator(),
                "#0000FF", "#FF0000");
        anim4.setDuration(5000);
        anim4.start();



    }
}
