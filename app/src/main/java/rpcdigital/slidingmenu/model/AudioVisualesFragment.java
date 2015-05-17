package rpcdigital.slidingmenu.model;

import android.app.Fragment;
import android.media.session.MediaController;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import android.net.Uri;

import com.example.android.rpcDigital.R;

public class AudioVisualesFragment extends Fragment{

    public AudioVisualesFragment(){}

    private VideoView mVideoView;
    private MediaController mController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_audio_visuales, container, false);
        mVideoView = (VideoView) rootView.findViewById(R.id.videoViewav);
        Uri path = Uri.parse("android.resource://com.example.android.navigationdrawerexample/"+R.raw.video1);
        mVideoView.setVideoURI(path);
        mVideoView.start();

        return rootView;
    }
}
