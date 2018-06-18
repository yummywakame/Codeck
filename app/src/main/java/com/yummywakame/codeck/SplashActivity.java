package com.yummywakame.codeck;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;

    /**
     * Creates a fade-in splash screen.
     * Resource/Tutorial: https://youtu.be/h_hTuaEpc-8
     *
     * @param savedInstanceState is not used for this splash screen
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Blur background image
        ImageView bgImgView = findViewById(R.id.main_background);
        Bitmap bitmap = ((BitmapDrawable) bgImgView.getDrawable()).getBitmap();
        bgImgView.setImageBitmap(new BlurUtils().blur(SplashActivity.this, bitmap, 15.5f));

        // locate image to fade in
        logo = findViewById(R.id.fadein_codeck_logo);
        Animation introFade = AnimationUtils.loadAnimation(this, R.anim.intro_fade_animation);
        logo.startAnimation(introFade);

        // after timer, proceed to MainActivity
        final Intent goToMainActivity = new Intent(this, MainActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(goToMainActivity);
                    finish();
                }
            }
        };
        timer.start();
    }
}
