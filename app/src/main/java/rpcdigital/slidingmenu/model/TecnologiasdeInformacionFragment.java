package rpcdigital.slidingmenu.model;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.rpcDigital.R;

public class TecnologiasdeInformacionFragment extends Fragment{

    public TecnologiasdeInformacionFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tecnologias_de_informacion, container, false);

        return rootView;
    }


}
