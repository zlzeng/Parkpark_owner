package com.example.zz.parkpark_owner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;


public class SetUserAddrActivity extends Activity {

    public static String mAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_user_addr);

        mAddr = null;

        // set statue bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(0xff599ac0);
    }


    /**
     * Back image view click event */
    public void onBackClick(View v) {
        EditText editAddress = (EditText)findViewById(R.id.editUserAddr);
        mAddr = editAddress.getText().toString();

        UserFragment.mBtnAddr.setText(mAddr);
        super.onBackPressed();
    }


}
