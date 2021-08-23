package com.paves.pavesvet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Splash_Screen_Activity extends AppCompatActivity {
    //Variables
    Animation top_animation, bottom_animation;
    TextView slogan, company_name;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen_);

        top_animation = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottom_animation = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        logo = findViewById(R.id.imageView4);
        slogan= findViewById(R.id.textView4);
        company_name = findViewById(R.id.textView5);

        logo.setAnimation(top_animation);
        slogan.setAnimation(top_animation);
        company_name.setAnimation(bottom_animation);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen_Activity.this, SelectionActivity.class);
                Splash_Screen_Activity.this.startActivity(intent);
                Splash_Screen_Activity.this.finish();
            }
        }, 4000);
    }
}
