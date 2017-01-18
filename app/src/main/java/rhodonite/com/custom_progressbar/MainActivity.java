package rhodonite.com.custom_progressbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

/***/
    private static int mLevel_1 = 0;
    private int fromLevel_1 = 0;
    private static int toLevel_1 = 0;
    public static final int MAX_LEVEL_1 = 10000;
    public static  int LEVEL_DIFF_1 = 100;
    public static  int DELAY_1 = 100;
/***/
    private static int mLevel_2 = 0;
    private int fromLevel_2 = 0;
    private static int toLevel_2 = 0;
    public static final int MAX_LEVEL_2 = 10000;
    public static int LEVEL_DIFF_2 = 100;
    public static int DELAY_2 = 100;
/***/
    Button bt_1,bt_2,bt_3,bt_4;
    ClipDrawable mImageDrawable_1,mImageDrawable_2;
    ImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_1 = (Button) this.findViewById(R.id.button);
        bt_2 = (Button) this.findViewById(R.id.button2);
        bt_3 = (Button) this.findViewById(R.id.button3);
        bt_4 = (Button) this.findViewById(R.id.button4);
        img1 = (ImageView) this.findViewById(R.id.imageView_1);
        img2 = (ImageView) this.findViewById(R.id.imageView_2);
        mImageDrawable_1 = (ClipDrawable) img1.getDrawable();
        mImageDrawable_2 = (ClipDrawable) img2.getDrawable();
        mImageDrawable_1.setLevel(mLevel_1);
        mImageDrawable_2.setLevel(mLevel_2);
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawview_1();
            }
        });
        bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanview_1();
            }
        });
        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawview_2();
            }
        });
        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUpHandler_2.removeCallbacks(animateUpImage_2);
            }
        });
    }
    private Handler mUpHandler_1 = new Handler();
    private Runnable animateUpImage_1 = new Runnable() {

        @Override
        public void run() {
            doTheUpAnimation_1(fromLevel_1, toLevel_1);
        }
    };

    private Handler mDownHandler_1 = new Handler();
    private Runnable animateDownImage_1 = new Runnable() {

        @Override
        public void run() {
            doTheDownAnimation_1(fromLevel_1, toLevel_1);
        }
    };
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void doTheUpAnimation_1(int fromLevel, int toLevel) {
        mLevel_1 += LEVEL_DIFF_1;
        mImageDrawable_1.setLevel(mLevel_1);
        if (mLevel_1 <= toLevel) {
            mUpHandler_1.postDelayed(animateUpImage_1, DELAY_1);
        } else {
            mUpHandler_1.removeCallbacks(animateUpImage_1);
            this.fromLevel_1 = toLevel;


        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void doTheDownAnimation_1(int fromLevel, int toLevel) {
        mLevel_1 -= mLevel_1;
        mImageDrawable_1.setLevel(mLevel_1);
        if (mLevel_1 >= toLevel) {
            mDownHandler_1.postDelayed(animateDownImage_1, 0);
        } else {
            mDownHandler_1.removeCallbacks(animateDownImage_1);
            this.fromLevel_1 = toLevel;

        }
    }
    private void cleanview_1()
    {
        int temp_level = (0* MAX_LEVEL_1) / 100;

        if (toLevel_1 == temp_level || temp_level > MAX_LEVEL_1) {
            return;
        }
        toLevel_1 = (temp_level <= MAX_LEVEL_1) ? temp_level : toLevel_1;
        if (toLevel_1 > fromLevel_1) {
        } else {
            mUpHandler_1.removeCallbacks(animateUpImage_1);
            this.fromLevel_1 = toLevel_1;
            mDownHandler_1.post(animateDownImage_1);
        }
    }

    private void drawview_1()
    {
        int temp_level = (100 * MAX_LEVEL_1) / 100;

        if (toLevel_1 == temp_level || temp_level > MAX_LEVEL_1) {
            return;
        }
        toLevel_1 = (temp_level <= MAX_LEVEL_1) ? temp_level : toLevel_1;
        if (toLevel_1 > fromLevel_1) {
            mDownHandler_1.removeCallbacks(animateDownImage_1);
            this.fromLevel_1 = toLevel_1;
            mUpHandler_1.post(animateUpImage_1);
        } else {

        }

    }

    private Handler mUpHandler_2 = new Handler();
    private Runnable animateUpImage_2 = new Runnable() {

        @Override
        public void run() {
            doTheUpAnimation_2(fromLevel_2, toLevel_2);
        }
    };

    private Handler mDownHandler_2 = new Handler();
    private Runnable animateDownImage_2 = new Runnable() {

        @Override
        public void run() {
            doTheDownAnimation_2(fromLevel_2, toLevel_2);
        }
    };
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void doTheUpAnimation_2(int fromLevel, int toLevel) {
        mLevel_2 += LEVEL_DIFF_2;
        mImageDrawable_2.setLevel(mLevel_2);

        if (mLevel_2 <= toLevel) {
            mUpHandler_2.postDelayed(animateUpImage_2, DELAY_2);

        } else {
            mUpHandler_2.removeCallbacks(animateUpImage_2);
            this.fromLevel_2 = toLevel;
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void doTheDownAnimation_2(int fromLevel, int toLevel) {
        mLevel_2 -= mLevel_2;
        mImageDrawable_2.setLevel(mLevel_2);
        if (mLevel_2 >= toLevel) {
            mDownHandler_2.postDelayed(animateDownImage_2, 0);
        } else {
            mDownHandler_2.removeCallbacks(animateDownImage_2);
            this.fromLevel_2 = toLevel;

        }
    }

    private void cleanview_2()
    {
        int temp_level = (0* MAX_LEVEL_2) / 100;

        if (toLevel_2 == temp_level || temp_level > MAX_LEVEL_2) {
            return;
        }
        toLevel_2 = (temp_level <= MAX_LEVEL_2) ? temp_level : toLevel_2;
        if (toLevel_2 > fromLevel_2) {
        } else {
            mUpHandler_2.removeCallbacks(animateUpImage_2);
            this.fromLevel_2 = toLevel_2;
            mDownHandler_2.post(animateDownImage_2);
        }
    }

    private void drawview_2()
    {
        int temp_level = (100 * MAX_LEVEL_2) / 100;

        if (toLevel_2 == temp_level || temp_level > MAX_LEVEL_2) {
            mUpHandler_2.post(animateUpImage_2);
            return;
        }
        toLevel_2 = (temp_level <= MAX_LEVEL_2) ? temp_level : toLevel_2;
        if (toLevel_2 > fromLevel_2) {
            mDownHandler_2.removeCallbacks(animateDownImage_2);
            this.fromLevel_2 = toLevel_2;
            mUpHandler_2.post(animateUpImage_2);
        } else {
        }

    }
}
