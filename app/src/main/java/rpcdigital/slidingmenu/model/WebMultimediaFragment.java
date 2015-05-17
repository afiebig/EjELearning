package rpcdigital.slidingmenu.model;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.rpcDigital.R;

public class WebMultimediaFragment extends Fragment{

    public WebMultimediaFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_web_multimedia, container, false);

        return rootView;
    }


}
