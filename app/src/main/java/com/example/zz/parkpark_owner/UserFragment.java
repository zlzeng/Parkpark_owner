package com.example.zz.parkpark_owner;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    public static TextView mBtnAddr;
    public static TextView mBtnPhone;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user, container, false);

        mBtnAddr = (TextView)v.findViewById(R.id.btn_address);
        mBtnPhone = (TextView)v.findViewById(R.id.btn_phone);

        return v;
    }


}
