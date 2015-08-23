package com.example.zz.parkpark_owner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.zip.Inflater;


public class SetTimeActivity extends Activity {

    private RelativeLayout mCard;

    public static class CalendarType {
        public final static int HOURS = 0;
        public final static int DAY   = 1;
        public final static int MONTH = 2;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);

        mCard = (RelativeLayout)findViewById(R.id.card_settime);
        initialViewByRecords();

        // set statue bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(0xff599ac0);
    }

    /**
     * change card view */
    public void initialViewByRecords() {
        mCard.setVisibility(View.VISIBLE);

        ImageView testImg = (ImageView)mCard.findViewById(R.id.testImg);
        testImg.setImageBitmap(CreateParkingActivity.mPhoto);

        TextView testTxt = (TextView)mCard.findViewById(R.id.testTxt);
        testTxt.setText(SetAddressActivity.mAddress);
    }

    /**
     * Back image click event */
    public void onBackClick(View v) {
        super.onBackPressed();
    }

    /**
     * Set time detail click event */
    public void onSetTimeDetailClick(View v) {
        Intent intent = new Intent(this, SetTimeDetailActivity.class);
        Bundle bundle = new Bundle();
        switch ( v.getId() ) {
            case R.id.hour_calendar:
                bundle.putInt("type", CalendarType.HOURS);
                break;
            case R.id.day_calendar:
                bundle.putInt("type", CalendarType.DAY);
                break;
            case R.id.month_calendar:
                bundle.putInt("type", CalendarType.MONTH);
                break;
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
