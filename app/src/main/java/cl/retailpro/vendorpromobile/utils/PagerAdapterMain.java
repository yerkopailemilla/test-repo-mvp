package cl.retailpro.vendorpromobile.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import cl.retailpro.vendorpromobile.view.PremisesFragment;
import cl.retailpro.vendorpromobile.view.ResumenFragment;

public class PagerAdapterMain extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PagerAdapterMain(FragmentManager fm, int tabs) {
        super(fm);
        this.numberOfTabs = tabs;
    }

    @Override
    public Fragment getItem(int tabPosition) {
        switch (tabPosition){
            case 0:
                return new ResumenFragment();
            case 1:
                return new PremisesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
