package com.example.zz.parkpark_owner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;


public class CreateParkingActivity extends Activity {

    public static Context mContext;
    public static ImageView mSetAddressView;
    public static ImageView mSetPriceVIew;

    public static Bitmap mPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_parking);

        mContext = getApplicationContext();

        mSetAddressView = (ImageView)findViewById(R.id.set_address);
        mSetAddressView.setImageResource(R.mipmap.setaddress);

        mSetPriceVIew = (ImageView)findViewById(R.id.set_price);
        mSetPriceVIew.setImageResource(R.mipmap.setprice);

        ImageView imageView = (ImageView)findViewById(R.id.camera);
        imageView.setImageResource(android.R.color.transparent);


        // set statue bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(0xff599ac0);
    }

    /**
     * Photo widget click event */
    public void onCameraClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1889);
    }

    /**
     * Camera capture image and display on imageView */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView imageView = (ImageView)findViewById(R.id.camera);
        if (requestCode == 1889 && resultCode == RESULT_OK) {
            mPhoto = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(mPhoto);
            ParkingFragment.testImg.setImageBitmap(mPhoto);
        }
    }

    /**
     * Set Address click event*/
    public void onSetAddressClick(View v) {
        Intent intent = new Intent(this, SetAddressActivity.class);
        startActivity(intent);
    }

    /** Set price click event */
    public void onSetPriceClick(View v) {
        Intent intent = new Intent(this, SetPriceActivity.class);
        startActivity(intent);
    }

    /** Back Img click event */
    public void onCreateParkingBackClick(View v) {
        super.onBackPressed();
    }

    /**
     * Save Txt click event */
    public void onCreateParkingSaveClick(View v) {
        ParkingFragment.mCard.setVisibility(View.VISIBLE);

        ParkingFragment.testTxt.setText(SetAddressActivity.mAddress);
        ParkingFragment.moveCreateParking(650);

        ManagerFragment.changeViewByRecords(true);

        super.onBackPressed();
    }



}
