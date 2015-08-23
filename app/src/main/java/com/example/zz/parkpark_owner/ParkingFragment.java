package com.example.zz.parkpark_owner;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParkingFragment extends Fragment {

    public static ImageView testImg;
    public static TextView testTxt;
    public static RelativeLayout mCard;
    public static ImageView mCreateParking;

    public ParkingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_parking, container, false);
        //testImg = (ImageView)v.findViewById(R.id.testImg);
        //testTxt = (TextView)v.findViewById(R.id.testTxt);

        mCard = (RelativeLayout)v.findViewById(R.id.card);
        testImg = (ImageView)mCard.findViewById(R.id.testImg);
        testTxt = (TextView)mCard.findViewById(R.id.testTxt);

        mCreateParking = (ImageView)v.findViewById(R.id.create_parking);

        return v;
    }

    public static void moveCreateParking(int margintop) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)mCreateParking.getLayoutParams();
        params.setMargins(0, margintop, 0, 0);
        mCreateParking.setLayoutParams(params);
    }


}
