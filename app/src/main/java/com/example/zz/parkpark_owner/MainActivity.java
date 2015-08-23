package com.example.zz.parkpark_owner;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {

    public static Context mContext;

    private List<Fragment> mFragments;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpFragments();

        mContext = getApplicationContext();

        // set statue bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(0xff599ac0);
    }

    /**
     * initial fragments */
    private void setUpFragments() {
        mFragmentManager = getFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();

        mFragments = new ArrayList<>();
        mFragments.add( new ParkingFragment() ); // index 0
        mFragments.add( new WalletFragment() ); // index 1
        mFragments.add( new UserFragment() ); // index 2
        mFragments.add( new ManagerFragment() ); // index 3
        mFragments.add(new BootomPanelFragment());    // index 4

        for (int i=0; i<5; i++)
            mFragmentTransaction.add( R.id.tab, mFragments.get(i) );

        for (int i=1; i<4; i++)
            mFragmentTransaction.hide( mFragments.get(i) );

        mFragmentTransaction.commit();

    }

    /**
     * Hide all the fragments */
    private void hideAllFragments() {
        mFragmentTransaction = mFragmentManager.beginTransaction();

        for (int i=0; i<4; i++)
            mFragmentTransaction.hide( mFragments.get(i) );

        mFragmentTransaction.commit();
    }

    /**
     * Main activity bottom panel clikc event*/
    public void onBottomPanelClick(View v) {
        hideAllFragments();
        BootomPanelFragment.resetBtnClkState();

        mFragmentTransaction = mFragmentManager.beginTransaction();
        ImageView tmp = (ImageView)v;
        switch ( v.getId() ) {
            case R.id.nav_parking:
                mFragmentTransaction.show(mFragments.get(0));
                tmp.setImageResource(R.mipmap.parking);
                break;
            case R.id.nav_manage:
                mFragmentTransaction.show(mFragments.get(3));
                tmp.setImageResource(R.mipmap.date2);
                break;
            case R.id.nav_wallet:
                mFragmentTransaction.show(mFragments.get(1));
                tmp.setImageResource(R.mipmap.wallet2);
                break;
            case R.id.nav_user:
                mFragmentTransaction.show(mFragments.get(2));
                tmp.setImageResource(R.mipmap.profile2);
                break;
        }

        mFragmentTransaction.commit();

    }

    /**
     * User Fragment Panel Click event */
    public void onPanelClick(View v) {
        Intent intent = null;

        switch ( v.getId() ) {
            case R.id.panel_car:
                intent = new Intent(this, VerifyActivity.class);
                break;
            case R.id.panel_addr:
                intent = new Intent(this, SetUserAddrActivity.class);
                break;
            case R.id.panel_phone:
                intent = new Intent(this, SetUserPhoneActivity.class);
                break;
        }
        startActivity(intent);
    }

    /**
     * Create Parking Spot event */
    public void onCreateParking(View v) {
        Intent intent = new Intent(this, CreateParkingActivity.class);
        startActivity(intent);
    }

    /**
     * Manager Card Click event */
    public void onCardManagerClick(View v) {
        if (ManagerFragment.mCardManager.getVisibility() == View.VISIBLE) {
            Intent intent = new Intent(this, SetTimeActivity.class);
            startActivity(intent);
        }

    }

    /**
     * Add card btn click event (WalletFragment) */
    public void onAddCardClick(View v) {
        View framelayout = findViewById(R.id.widget_paypal);
        View btn = findViewById(R.id.btn_add_card);
        if (framelayout.getVisibility() == View.INVISIBLE) {
            WalletFragment.addCardBtnDown(framelayout, btn);
        } else {
            WalletFragment.addCardBtnUp(framelayout, btn);
        }
    }


}
