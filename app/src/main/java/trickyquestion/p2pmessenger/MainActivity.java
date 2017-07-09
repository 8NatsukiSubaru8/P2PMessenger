package trickyquestion.p2pmessenger;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Window;

import trickyquestion.p2pmessenger.MainFragments.SwipeFragmentAdapter;
import trickyquestion.p2pmessenger.Splash.SplashActivity;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    public static boolean FIRST_START = true;
    private ActionBar actionBar;
    private ViewPager viewPager;
    private SwipeFragmentAdapter adapter;
    private final String[] tabTitle = new String[]{"Contacts", "Message"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!FIRST_START) showMainScreen();
        else showSplash();
    }

    private void showMainScreen() {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        actionBar = getActionBar();
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.swipe_view_pager);
        adapter = new SwipeFragmentAdapter(getSupportFragmentManager());


        viewPager.setAdapter(adapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (String tabsName : tabTitle) {
            actionBar.addTab(actionBar.newTab().setText(tabsName).setTabListener(this));
        }
    }

    private void showSplash() {
        Intent intent = new Intent(MainActivity.this, SplashActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }
}