package activity.ds.qianfeng.com.aimoation;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button btnStart;
    private ImageView imgEarth;
    private ImageView imgMon;
    private Animation anim;
    private ImageView imgSun;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = ((Button) findViewById(R.id.btn_start));
        imgEarth = ((ImageView) findViewById(R.id.img_earth));
        imgMon = ((ImageView) findViewById(R.id.img_mon));
        imgSun = ((ImageView) findViewById(R.id.img_sum));
        anim = AnimationUtils.loadAnimation(this, R.anim.anim_test);
        btnStart.setOnClickListener(this);
        imageView = ((ImageView) findViewById(R.id.image_demo));
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.image_demo){
            imageView.startAnimation(anim);
        }else {
            roate();
        }
    }

    private void roate() {
        //地球绕太阳
        float px1=imgSun.getX()+imgSun.getWidth()/2-imgEarth.getX();
        float py1=imgSun.getY()+imgSun.getHeight()/2-imgEarth.getY();
        RotateAnimation rtSun=new RotateAnimation(0,360,px1,py1);
        rtSun.setDuration(10000);

        AnimationSet set=new AnimationSet(true);

        //月亮绕太阳
        float px2=imgSun.getX()+imgSun.getWidth()/2-imgMon.getX();
        float py2=imgSun.getY()+imgSun.getHeight()/2-imgMon.getY();
        RotateAnimation rtMon=new RotateAnimation(0,360,px2,py2);
        rtMon.setDuration(10000);
        //获取锚点,月亮绕地球
        float px=imgEarth.getX()+imgEarth.getWidth()/2-imgMon.getX();
        float py=imgEarth.getY()+imgEarth.getHeight()/2-imgMon.getY();
        RotateAnimation rtEarth=new RotateAnimation(0,360*5,px,py);
        rtEarth.setDuration(10000);
        //启动动画
        set.addAnimation(rtEarth);
        set.addAnimation(rtMon);
        imgMon.startAnimation(set);
        imgEarth.startAnimation(rtSun);
    }
}
