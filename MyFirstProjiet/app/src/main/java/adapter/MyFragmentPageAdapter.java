package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.administrator.myfirstprojiet.MainActivity;

import fragment.ConcernPageFragment;
import fragment.HomepageFragment;
import fragment.MyHomepageFragment;
import fragment.SearchFragment;

/**
 * Created by Administrator on 2016/11/25.
 */
public class MyFragmentPageAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 4;
    private HomepageFragment homepageFragment = null;
    private SearchFragment searchFragment = null;
    private ConcernPageFragment concernPageFragment = null;
    private MyHomepageFragment myHomepageFragment = null;

    public MyFragmentPageAdapter(FragmentManager fm) {
        super(fm);
        homepageFragment = new HomepageFragment();
        searchFragment = new SearchFragment();
        concernPageFragment = new ConcernPageFragment();
        myHomepageFragment = new MyHomepageFragment();

    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = homepageFragment;
                break;
            case MainActivity.PAGE_TWO:
                fragment = searchFragment;
                break;
            case MainActivity.PAGE_THREE:
                fragment = concernPageFragment;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = myHomepageFragment;
                break;
        }
        return fragment;
    }
}
