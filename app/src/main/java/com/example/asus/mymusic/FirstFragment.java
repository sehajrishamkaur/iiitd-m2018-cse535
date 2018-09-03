package com.example.asus.mymusic;


import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private ArrayList<SongDetails> songsList = new ArrayList<SongDetails>();
    RecyclerView recyclerView;
    SeekBar seekBar;
    RVAdapter rvAdapter;
    MediaPlayer mediaPlayer;
    String myURL = "http://faculty.iiitd.ac.in/~mukulika/s1.mp3";
    public Button dnldSong,dnlded;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View retView = inflater.inflate(R.layout.fragment_first, container);
        final FragmentActivity fragmentSecond = getActivity();
        recyclerView = (RecyclerView) retView.findViewById(R.id.recyclerView);


      /*  dnldSong = (Button) retView.findViewById(R.id.downloadSong);
        dnlded= (Button) retView.findViewById(R.id.downloaded);*/

        SongDetails songDetails = new SongDetails("Ringtone", "Mukulika Maity", "http://faculty.iiitd.ac.in/~mukulika/s1.mp3");
        songsList.add(songDetails);

        rvAdapter = new RVAdapter(this.getContext(), songsList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rvAdapter);

        rvAdapter.setOnitemClickListner(new RVAdapter.OnitemClickListner() {
            @Override
            public void onItemClick(final Button btn, final View v, final SongDetails info, int position) {

                        try {

                            if (btn.getText().toString().equals("Stop")) {
                                btn.setText("Play");
                                mediaPlayer.stop();
                                mediaPlayer.reset();
                                mediaPlayer.release();
                                mediaPlayer = null;

                            } else {


                                    ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                                    NetworkInfo networkInfo = cm.getActiveNetworkInfo();
                                    if (networkInfo == null || !networkInfo.isConnected())
                                    {
                                        Toast.makeText(getActivity(), "Network not Connected", Toast.LENGTH_SHORT).show();

                                    }
                                    else
                                    {
                                        Toast.makeText(getActivity(), "Playing mp3 file", Toast.LENGTH_SHORT).show();
                                    }

                                mediaPlayer = new MediaPlayer();
                                mediaPlayer.setDataSource(info.getUrl());


                                final Uri music_uri = Uri.parse(myURL);

                                mediaPlayer.prepareAsync();


                                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(MediaPlayer mp) {

                                        /*SecondFragment secondFragment=new SecondFragment();
                                        FragmentManager fragmentManager=getFragmentManager();
                                        fragmentManager.beginTransaction().replace(R.id.second_fragment,secondFragment);*/


                                        mp.start();
                                        btn.setText("Stop");


                                        if (PermissionCheck.readAndWriteExternalStorage(getContext())) {

                                            DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);




                                                DownloadManager.Request request = new DownloadManager.Request( music_uri );
                                                request.setTitle( "Data Download" );
                                                request.setDescription( "File is being downloaded" );
                                                String nameOfFile = URLUtil.guessFileName( myURL, null,
                                                        MimeTypeMap.getFileExtensionFromUrl( myURL ) );
                                                request.setDestinationInExternalPublicDir( Environment.DIRECTORY_DOWNLOADS, nameOfFile );
                                                manager.enqueue( request );

                                        }


                                    }
                                });



                            }
                        } catch (IOException e) {

                        }

                }


        });


        return retView;
    }


}

