package info.androidhive.androidanimations;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;

public class FlyingBird extends Activity implements AnimationListener {

	ImageView imgLogo;
	Button btnStart;

	// Animation
	Animation animSequential;
	
	private static final String DEBUG_TAG = "MyActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flyingbird);

		imgLogo = (ImageView) findViewById(R.id.imgLogo);
		//btnStart = (Button) findViewById(R.id.btnStart);

		// load the animation
		animSequential = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.flyingbird);

		// set animation listener
		animSequential.setAnimationListener(this);

		// button click event
//		btnStart.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// start the animation
//				imgLogo.startAnimation(animSequential);
//			}
//		});

	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){ 
	        
	    int action = MotionEventCompat.getActionMasked(event);
	        
	    switch(action) {
	        case (MotionEvent.ACTION_DOWN) :
	            Log.d(DEBUG_TAG,"Action was DOWN");
	        imgLogo.startAnimation(animSequential);
	            return true;
	        case (MotionEvent.ACTION_MOVE) :
	            Log.d(DEBUG_TAG,"Action was MOVE");
	            return true;
	        case (MotionEvent.ACTION_UP) :
	            Log.d(DEBUG_TAG,"Action was UP");
	            return true;
	        case (MotionEvent.ACTION_CANCEL) :
	            Log.d(DEBUG_TAG,"Action was CANCEL");
	            return true;
	        case (MotionEvent.ACTION_OUTSIDE) :
	            Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
	                    "of current screen element");
	            return true;      
	        default : 
	            return super.onTouchEvent(event);
	    }  }

	@Override
	public void onAnimationEnd(Animation animation) {
		// Take any action after completing the animation

		// check for zoom in animation
		if (animation == animSequential) {
		}

	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub

	}

}