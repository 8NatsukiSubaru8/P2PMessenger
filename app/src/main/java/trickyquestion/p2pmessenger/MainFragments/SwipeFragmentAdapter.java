package trickyquestion.p2pmessenger.MainFragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SwipeFragmentAdapter extends FragmentPagerAdapter{
    private final int FRAGMENT_COUNT = 3;

    public SwipeFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: {
                ProfileFragment pf = new ProfileFragment();
                return pf;
            }
            case 1: {
                NewsFragment nf = new NewsFragment();
                return nf;
            }
            case 2: {
                MessageFragment mf = new MessageFragment();
                return mf;
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
}
