package rpcdigital.slidingmenu.model;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.rpcDigital.R;

public class MediosDigitalesFragment extends Fragment{

    public MediosDigitalesFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_medios_digitales, container, false);

        return rootView;
    }


}
