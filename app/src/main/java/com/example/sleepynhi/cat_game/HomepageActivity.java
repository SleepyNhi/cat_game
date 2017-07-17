package com.example.sleepynhi.cat_game;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.sleepynhi.cat_game.Fragments.HomeFragment;
import com.example.sleepynhi.cat_game.Fragments.YardFragment;
import com.example.sleepynhi.cat_game.dialog.MenuDialog;
import com.example.sleepynhi.cat_game.playableObjects.Player;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomepageActivity extends BaseActivity implements View.OnTouchListener{

    private GestureDetector gestureDetector;
    private TextView tv_home;
    private TextView tv_yard;
    public static Player player;
    private Animation slideAnimation;
    private Animation slideinAnimation;

    @BindView(R.id.hp_tv)
    TextView hp_tv;

    @OnClick(R.id.hp_tv)
    public void onTv(){
        hp_tv.setVisibility(View.INVISIBLE);
    }



    @OnClick(R.id.activity_play_bt)
    public void onPlayGame(){
        Intent intent = new Intent(this, GameActivity.class);
        this.startActivity(intent);
    }

    private Animation rotateAnimation;

    @BindView(R.id.activity_homepage_menu)
    Button menuBT;
    @OnClick(R.id.activity_homepage_menu)
    public void menubt(View view){
        menuBT.startAnimation(rotateAnimation);
        MenuDialog menuDialog = new MenuDialog(this);
        menuDialog.setCanceledOnTouchOutside(true);
        menuDialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ButterKnife.bind(this);
        initialView();
        setListener();
        initialAnimation();
        player = new Player(this);

        gestureDetector = new GestureDetector(this, new HomepageActivity.simpleGestureListener());

        hp_tv.setOnTouchListener(this);
        hp_tv.setFocusable(true);
        hp_tv.setClickable(true);

//        Intent svc=new Intent(this, TestAudioActivity.class);
//        startService(svc);

    }

    private void initialView() {
        tv_home = (TextView) findViewById(R.id.activity_homepage_homebt);
        tv_yard = (TextView) findViewById(R.id.activity_homepage_yardbt);

    }
    private void setListener() {
        final HomeFragment homeFragment = new HomeFragment();
        final YardFragment yardFragment = new YardFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_homepage_rl,homeFragment).commit();


        tv_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv_yard.setTextColor(Color.BLACK);
                tv_home.setTextColor(Color.WHITE);
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_homepage_rl,homeFragment).commit();
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_yard.setTextColor(Color.WHITE);
                tv_home.setTextColor(Color.BLACK);
                //Toast.makeText(MainActivity.this, "You clicked work", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_homepage_rl,yardFragment).commit();
            }
        };
        tv_yard.setOnClickListener(listener);

    }

    private void initialAnimation(){

        rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        slideAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_slideout);
        slideinAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_slidein);
    }




    public boolean onTouch(View v, MotionEvent event) {

        return gestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 50;
        private static final int SWIPE_VELOCITY_THRESHOLD = 50;


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

        hp_tv.setVisibility(View.VISIBLE);
        hp_tv.startAnimation(slideinAnimation);

    }

    public void onSwipeLeft() {

        hp_tv.setVisibility(View.VISIBLE);
        hp_tv.startAnimation(slideAnimation);

    }

}

