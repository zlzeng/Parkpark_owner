package com.example.zz.parkpark_owner;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManagerFragment extends Fragment {

    public static ImageView mNoCarInfo;
    public static RelativeLayout mCardManager;
    public static ImageView mArrow;

    public ManagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_manager, container, false);

        mNoCarInfo = (ImageView)v.findViewById(R.id.nocarinfo);
        mCardManager = (RelativeLayout)v.findViewById(R.id.card_manager);
        mArrow = (ImageView)mCardManager.findViewById(R.id.arrow);

        return v;
    }

    public static void changeViewByRecords(boolean haveRecord) {
        if ( haveRecord == true ) {
            mNoCarInfo.setVisibility(View.INVISIBLE);
            mCardManager.setVisibility(View.VISIBLE);
            mArrow.setVisibility(View.VISIBLE);

            ImageView testImg = (ImageView)mCardManager.findViewById(R.id.testImg);
            TextView  testTxt = (TextView)mCardManager.findViewById(R.id.testTxt);
            testImg.setImageBitmap(CreateParkingActivity.mPhoto);
            testTxt.setText(SetAddressActivity.mAddress);
        }
    }


}
