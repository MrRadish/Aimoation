package activity.ds.qianfeng.com.aimoation;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class AnimationFrameActivity extends ActionBarActivity implements View.OnClickListener {

    private ImageView imageView;
    private AnimationDrawable anim;
    private boolean flag=true;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_frame);
        imageView = ((ImageView) findViewById(R.id.image));
        imageView.setBackgroundResource(R.drawable.anim_list);
//        findViewById(R.id.btn_play).setOnClickListener(this);
//        findViewById(R.id.btn_stop).setOnClickListener(this);
        anim = (AnimationDrawable) imageView.getBackground();
        imageView.setOnClickListener(this);
        player=MediaPlayer.create(this,R.drawable.aw);
    }


    @Override
    public void onClick(View view) {
        if(flag){
            anim.start();
            player.start();
            flag=false;
        }else{
            anim.stop();
            player.stop();
            flag=true;
        }

    }
}
