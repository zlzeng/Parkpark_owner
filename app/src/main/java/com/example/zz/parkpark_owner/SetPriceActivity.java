package com.example.zz.parkpark_owner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class SetPriceActivity extends Activity {

    private TextView mHourTxt;
    private TextView mDayTxt;
    private TextView mMonTxt;

    private TextView mPriceTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_price);

        mHourTxt = (TextView)findViewById(R.id.hour);
        mDayTxt = (TextView)findViewById(R.id.day);
        mMonTxt = (TextView)findViewById(R.id.month);

        mPriceTxt = (TextView)findViewById(R.id.price);

        initialText();

        // set statue bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(0xff599ac0);
    }

    /** initial txt */
    public void initialText() {
        mHourTxt.setTextColor(0xff70b8e2);
        mDayTxt.setTextColor(0xffc9c9c9);
        mMonTxt.setTextColor(0xffc9c9c9);

        mPriceTxt.setText("時租價格");
    }

    /**
     * Back image view click event */
    public void onBackClick(View v) {
        super.onBackPressed();
    }

    /**
     * Save text view click event */
    public void onSaveClick(View v) {
        CreateParkingActivity.mSetPriceVIew.setImageResource(R.mipmap.setprice2);
        super.onBackPressed();
    }

    /** Reset Text color */
    public void resetTxtColor() {
        mHourTxt.setTextColor(0xffc9c9c9);
        mDayTxt.setTextColor(0xffc9c9c9);
        mMonTxt.setTextColor(0xffc9c9c9);
    }

    /**
     * Set Price input type click event */
    public void onSetPriceTypeClick(View v) {
        resetTxtColor();

        switch ( v.getId() ) {
            case R.id.hour:
                mHourTxt.setTextColor(0xff70b8e2);
                mPriceTxt.setText("時租價格");
                break;
            case R.id.day:
                mDayTxt.setTextColor(0xff70b8e2);
                mPriceTxt.setText("日租價格");
                break;
            case R.id.month:
                mMonTxt.setTextColor(0xff70b8e2);
                mPriceTxt.setText("月租價格");
                break;
        }
    }

}
