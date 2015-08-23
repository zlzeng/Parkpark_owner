package com.example.zz.parkpark_owner;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BootomPanelFragment extends Fragment {

    public static View bottomPanel;

    public BootomPanelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bottomPanel = inflater.inflate(R.layout.fragment_bootom_panel, container, false);
        return bottomPanel;
    }

    public static void resetBtnClkState() {
        ImageView imageView1 = (ImageView)bottomPanel.findViewById(R.id.nav_parking);
        imageView1.setImageResource(R.mipmap.parking2);

        ImageView imageView2 = (ImageView)bottomPanel.findViewById(R.id.nav_manage);
        imageView2.setImageResource(R.mipmap.dates);

        ImageView imageView3 = (ImageView)bottomPanel.findViewById(R.id.nav_wallet);
        imageView3.setImageResource(R.mipmap.wallet);

        ImageView imageView4 = (ImageView)bottomPanel.findViewById(R.id.nav_user);
        imageView4.setImageResource(R.mipmap.profile);


    }


}
