package trickyquestion.p2pmessenger.Splash;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SliderAdapter extends PagerAdapter{
    private final Context context;

    SliderAdapter (Context context, int [] imageResources) {
        this.context = context;
        this.imageResources = imageResources;
    }

    @Override
    public int getCount() {
        return imageResources.length;
    }

    private int[] imageResources;

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == ((ImageView) obj);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(imageResources[position]);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        ((ViewPager) container).removeView((ImageView) obj);
    }
}
