package com.example.in441635.tomsampleproject;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.in441635.tomsampleproject.fragments.SampleFragment1;
import com.example.in441635.tomsampleproject.fragments.MapCacheFragment;
import com.example.in441635.tomsampleproject.fragments.SampleFragment3;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener{

    private ActionBar actionBar;

    private FragmentManager fragmentManager;

    private SampleFragment1 sampleFragment1;

    private MapCacheFragment mapCacheFragment;

    private SampleFragment3 sampleFragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getActionBar();
        fragmentManager = getSupportFragmentManager();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionBar.newTab().setText("TAB 1").setTabListener(this);
        ActionBar.Tab tab2 = actionBar.newTab().setText("Mapcache Tab").setTabListener(this);
        ActionBar.Tab tab3 = actionBar.newTab().setText("TAB 3").setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, sampleFragment1, null).commit();

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        Fragment frag = null;

        if (sampleFragment1 == null) {

            sampleFragment1 = new SampleFragment1();

        }

        if (mapCacheFragment == null) {

            mapCacheFragment = new MapCacheFragment();

        }

        if (sampleFragment3 == null) {

            sampleFragment3 = new SampleFragment3();

        }

        switch (tab.getPosition()){

            case 0:{

                frag = sampleFragment1;
                break;

            }

            case 1:{

                frag = mapCacheFragment;
                break;

            }

            case 2:{

                frag = sampleFragment3;
                break;

            }

            default:
        }

        fragmentManager.beginTransaction().replace(R.id.container, frag, null).commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
