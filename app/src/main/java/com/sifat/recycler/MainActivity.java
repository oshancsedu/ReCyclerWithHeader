package com.sifat.recycler;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.sifat.recycler.ui.DoubleHeaderFragment;
import com.sifat.recycler.ui.InlineStickyHeaderFragment;
import com.sifat.recycler.ui.StickyHeaderFragment;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HeaderPagerAdapter adapter = new HeaderPagerAdapter(this.getSupportFragmentManager());

        ViewPager pager = (ViewPager) this.findViewById(R.id.pager);
        pager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/edubarr/header-decor"));
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class HeaderPagerAdapter extends FragmentPagerAdapter {

        public HeaderPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new StickyHeaderFragment();

                case 1:
                    return new InlineStickyHeaderFragment();

                case 2:
                    return new DoubleHeaderFragment();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Sticky Header";

                case 1:
                    return "Sticky Header - Inline";

                case 2:
                    return "Double Header";

                default:
                    return null;
            }
        }
    }
}
