package com.example.asus.mymusic;


import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SecondFragment extends Fragment implements View.OnClickListener {
    public Button musicPlay, musicPause, musicStop;
    MediaPlayer mediaPlayer;
    int pausePoint;


    public SecondFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View retView = inflater.inflate(R.layout.fragment_second, container);
        final FragmentActivity fragmentSecond = getActivity();

        musicPlay = (Button) retView.findViewById(R.id.music_play);
        musicPause = (Button) retView.findViewById(R.id.music_pause);
        musicStop = (Button) retView.findViewById(R.id.music_stop);

        musicPlay.setOnClickListener(this);
        musicPause.setOnClickListener(this);
        musicStop.setOnClickListener(this);



        return retView;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.music_play:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getContext(), R.raw.s1);
                    mediaPlayer.start();
                    musicPlay.setVisibility(view.GONE);
                    musicPause.setVisibility(view.VISIBLE);
                    //musicPlay.setBackgroundResource(R.drawable.pause);
                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(pausePoint);
                    mediaPlayer.start();
                    musicPlay.setVisibility(view.GONE);
                    musicPause.setVisibility(view.VISIBLE);
                    //musicPlay.setBackgroundResource(R.drawable.pause);
                    //musicPlay.findViewById(R.id.music_pause);
                }

                break;

            case R.id.music_pause:
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    pausePoint = mediaPlayer.getCurrentPosition();
                    musicPause.setVisibility(view.GONE);
                    musicPlay.setVisibility(view.VISIBLE);
                    //musicPause.setBackgroundResource(R.drawable.play);

                }
                break;

            case R.id.music_stop:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                    musicPause.setVisibility(view.GONE);
                    musicPlay.setVisibility(view.VISIBLE);
                }
                break;




        }

    }
}

