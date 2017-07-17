package com.example.sleepynhi.cat_game;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GestureActivity extends BaseActivity implements View.OnTouchListener {
    @BindView(R.id.quiztv)
    TextView quiztv;

    @BindView(R.id.bingotv)
    TextView bingotv;

    private Animation slideAnimation;
    private Animation slideinAnimation;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        ButterKnife.bind(this);
        initialAnimation();
        gestureDetector = new GestureDetector(this, new simpleGestureListener());
        quiztv.setOnTouchListener(this);
        quiztv.setFocusable(true);
        quiztv.setClickable(true);
    }


    private void initialAnimation() {
        slideAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_slideout);
        slideinAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_slidein);
    }


    public boolean onTouch(View v, MotionEvent event) {

        return gestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;


        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            boolean result = false;

            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(distanceX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {

                                onSwipeRight();


                        } else {
                            onSwipeLeft();
                        }
                        result = true;
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }


            return super.onScroll(e1, e2, distanceX, distanceY);

        }

    }
    public void onSwipeRight() {

        bingotv.setVisibility(View.VISIBLE);
        bingotv.startAnimation(slideinAnimation);

    }

    public void onSwipeLeft() {

        bingotv.setVisibility(View.INVISIBLE);
        bingotv.startAnimation(slideAnimation);

    }

}
