package com.magomed.gamzatov.afisha.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.magomed.gamzatov.afisha.fragment.AbstractTabFragment;
import com.magomed.gamzatov.afisha.fragment.CinemasFragment;
import com.magomed.gamzatov.afisha.fragment.SeeNowFragment;
import com.magomed.gamzatov.afisha.fragment.TheatresFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractTabFragment> tabs;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        initTabsMap(context);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, CinemasFragment.getInstance(context));
        tabs.put(1, SeeNowFragment.getInstance(context));
        tabs.put(2, TheatresFragment.getInstance(context));
//        tabs.put(3, BirthdaysFragment.getInstance(context));
    }
}
