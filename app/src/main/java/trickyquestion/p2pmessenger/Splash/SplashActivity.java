package trickyquestion.p2pmessenger.Splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import trickyquestion.p2pmessenger.MainActivity;
import trickyquestion.p2pmessenger.R;

public class SplashActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener{
    private ViewPager viewPager;
    private SliderAdapter adapter;
    private Button btnSkip, btnLetsStart;
    private ImageButton btnNext;
    private LinearLayout layoutDots;
    private ImageView[] dots;
    private int images[] = new int[] {
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_image_slider_activity);
        allocate();
        setDots();
        setListener();
    }

    /** Initialized all variables */
    private void allocate() {
        viewPager = (ViewPager) findViewById(R.id.start_view_page);
        adapter = new SliderAdapter(this, images);
        viewPager.setAdapter(adapter);
        btnNext = (ImageButton) findViewById(R.id.btn_next);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnLetsStart = (Button) findViewById(R.id.btn_lets_start);
        layoutDots = (LinearLayout) findViewById(R.id.view_pager_dots);
    }

    /** For show indicator dots */
    private void setDots() {
        dots = new ImageView[adapter.getCount()];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.notselected_item));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(16, 0, 16, 0);
            layoutDots.addView(dots[i], params);
        }
        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }
    /** All listener here */
    private void setListener() {
        viewPager.addOnPageChangeListener(this);
        btnNext.setOnClickListener(this);
        btnSkip.setOnClickListener(this);
        btnLetsStart.setOnClickListener(this);
    }

    /** Below all implementation listener */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next: {
                if (viewPager.getCurrentItem() < adapter.getCount())
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                break;
            }
            case R.id.btn_skip: {
                MainActivity.FIRST_START = false;
                finish();
                break;
            }
            case R.id.btn_lets_start: {
//                A.FIRST_START = false;
                finish();
                break;
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < adapter.getCount(); i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.notselected_item));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));

        if (position + 1 == adapter.getCount()) {
            btnNext.setVisibility(View.GONE);
            btnSkip.setVisibility(View.GONE);
            btnLetsStart.setVisibility(View.VISIBLE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
            btnSkip.setVisibility(View.VISIBLE);
            btnLetsStart.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

}
