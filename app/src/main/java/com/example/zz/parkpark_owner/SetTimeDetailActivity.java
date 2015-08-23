package com.example.zz.parkpark_owner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class SetTimeDetailActivity extends Activity {

    private RelativeLayout mCard;
    public boolean [] clickFlags;
    public long mYear;

    public TextView mYearTxt;
    private List<RelativeLayout> calendars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time_detail);

        mCard = (RelativeLayout)findViewById(R.id.card_settime_detail);
        mYearTxt = (TextView)findViewById(R.id.years);

        initial();

        Bundle bundle = this.getIntent().getExtras();
        buildLayout( bundle.getInt("type") );

        // set statue bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(0xff599ac0);
    }

    /** initial when creating the activity */
    public void initial() {
        mYear = 2015;
        initialInfoCard();
        initialFlags();
        initialCalendars();
    }

    /** initial info card */
    public void initialInfoCard() {
        mCard.setVisibility(View.VISIBLE);

        ImageView testImg = (ImageView)mCard.findViewById(R.id.testImg);
        testImg.setImageBitmap(CreateParkingActivity.mPhoto);

        TextView testTxt = (TextView)mCard.findViewById(R.id.testTxt);
        testTxt.setText(SetAddressActivity.mAddress);
    }

    /** initial months txt click flags */
    public void initialFlags() {
        clickFlags = new boolean[12];
        for (int i=0; i<12; i++) {
            clickFlags[i] = false;
        }
    }

    /**
     * initial calendar type */
    public void initialCalendars() {
        calendars = new ArrayList<>();
        calendars.add( (RelativeLayout)findViewById(R.id.h_calendar) ); // index 0
        calendars.add( (RelativeLayout)findViewById(R.id.d_calendar) ); // index 1
        calendars.add( (RelativeLayout)findViewById(R.id.m_calendar) ); // index 2
    }

    /**
     * hide all calendar */
    public void hideAllCalendar() {
        RelativeLayout tmp;
        for (int pos=0; pos < 3; pos++) {
            tmp = calendars.get(pos);
            tmp.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * build evaluation */
    public void buildLayout(int calendarType) {
        TextView title = (TextView)findViewById(R.id.set_detail_time_title);
        hideAllCalendar();

        switch (calendarType) {
            case SetTimeActivity.CalendarType.DAY:
                calendars.get(calendarType).setVisibility(View.VISIBLE);
                title.setText("設置日租時間");
                break;
            case SetTimeActivity.CalendarType.HOURS:
                calendars.get(calendarType).setVisibility(View.VISIBLE);
                title.setText("設置時租時間");
                break;
            case SetTimeActivity.CalendarType.MONTH:
                calendars.get(calendarType).setVisibility(View.VISIBLE);
                title.setText("設置月租時間");
                break;
        }

    }

    /**
     * change months txt click flags */
    public boolean changeFlags(View v) {

        switch ( v.getId() ) {
            case R.id.m1:
                clickFlags[0] = !clickFlags[0];
                return clickFlags[0];
            case R.id.m2:
                clickFlags[1] = !clickFlags[1];
                return clickFlags[1];
            case R.id.m3:
                clickFlags[2] = !clickFlags[2];
                return clickFlags[2];
            case R.id.m4:
                clickFlags[3] = !clickFlags[3];
                return clickFlags[3];
            case R.id.m5:
                clickFlags[4] = !clickFlags[4];
                return clickFlags[4];
            case R.id.m6:
                clickFlags[5] = !clickFlags[5];
                return clickFlags[5];
            case R.id.m7:
                clickFlags[6] = !clickFlags[6];
                return clickFlags[6];
            case R.id.m8:
                clickFlags[7] = !clickFlags[7];
                return clickFlags[7];
            case R.id.m9:
                clickFlags[8] = !clickFlags[8];
                return clickFlags[8];
            case R.id.m10:
                clickFlags[9] = !clickFlags[9];
                return clickFlags[9];
            case R.id.m11:
                clickFlags[10] = !clickFlags[10];
                return clickFlags[10];
            case R.id.m12:
                clickFlags[11] = !clickFlags[11];
                return clickFlags[11];
        }

        return false;
    }

    /**
     * change txt button color */
    public void onChangeColorClick(View v) {
        TextView tmp = (TextView)v;


        if (changeFlags(v)) {
            tmp.setTextColor(0xffffffff);
            tmp.setBackgroundColor(0xff70b8e2);
        } else {
            tmp.setTextColor(0xffc9c9c9);
            tmp.setBackgroundColor(0xffffffff);
        }
    }

    /**
     * change years view color */
    public void onChangeYearsClick(View v) {
        String tmp = "";
        switch (v.getId()) {
            case R.id.prev:
                mYear--;
                break;
            case R.id.next:
                mYear++;
                break;
        }
        tmp += mYear;
        if (mYear >= 2015) {
            mYearTxt.setText(tmp);
        }
        else {
            mYear = 2015;
            mYearTxt.setText("2015");
        }
    }

    /**
     * Sure button click */
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setMessage("请确定信息无误!").setTitle("通知");
        builder.setMessage("请确定信息无误!");
        builder.setPositiveButton("確定",null).setNegativeButton("取消",null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    /**
     * Back image click event */
    public void onBackClick(View v) {
        super.onBackPressed();
    }
}
