package com.zoro.jinliangliang.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

import com.zoro.jinliangliang.R;

public class AnimationActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        btn = findViewById(R.id.btn);
//        TranslateAnimation animation = new TranslateAnimation(0,300,0,300);
//        animation.setDuration(15000);
//        animation.setFillAfter(true);
//        btn.startAnimation(animation);
        btn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                performAnimate();
                Toast.makeText(AnimationActivity.this,"alalla", Toast.LENGTH_LONG).show();
            }
        });
//        float [] x= {0f,60f,120f,180f};
//        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(btn,"translationX", x);
//        objectAnimatorX.setDuration(2000);
//        objectAnimatorX.start();
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,300);

    }

    private void performAnimate(){
        ViewWrapper wrapper = new ViewWrapper(btn);
        ObjectAnimator.ofInt(wrapper,"width",1500).setDuration(3000).start();
    }

    private class ViewWrapper{
        private View mTarget;

        public ViewWrapper(View mTarget) {
            this.mTarget = mTarget;
        }

       public int getWidth(){
            return mTarget.getLayoutParams().width;
       }

       public void setWidth(int width){
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
       }
    }
}
