package com.example.hasee.animationdome1;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hasee.animationdome1.unitle.ColorEvaluator;
import com.example.hasee.animationdome1.unitle.MyView2;

public class Main4Activity extends AppCompatActivity {
    MyView2 myView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        myView2 = (MyView2)findViewById(R.id.MyView2);
        ObjectAnimator animator =  ObjectAnimator.ofObject(myView2,"color",new ColorEvaluator(),"#0000FF","#FF0000");
        animator.setDuration(8000);
        animator.start();
    }
}
