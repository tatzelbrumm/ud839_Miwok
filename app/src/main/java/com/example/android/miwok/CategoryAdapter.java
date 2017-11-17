package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static java.security.AccessController.getContext;


/**
 * Created by cmaier on 16.11.17.
 *
 * Provides the appropriate {@link Fragment} for a view pager.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private int[] titles = {
            R.string.category_numbers,
            R.string.category_family,
            R.string.category_colors,
            R.string.category_phrases
    };

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            case 3:
                return new PhrasesFragment();
        }
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getString(titles[position]);
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
