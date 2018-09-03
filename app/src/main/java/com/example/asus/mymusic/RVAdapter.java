package com.example.asus.mymusic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.Holder> {

    ArrayList<SongDetails> songsList;
    Context context;
    OnitemClickListner onitemClickListner;

    RVAdapter(Context context, ArrayList<SongDetails> songsList)
    {
        this.context=context;
        this.songsList=songsList;
    }

    public interface OnitemClickListner
    {
        void onItemClick(Button btn,View v, SongDetails info,int position);
    }

    public void setOnitemClickListner(OnitemClickListner onitemClickListner)
    {
        this.onitemClickListner=onitemClickListner;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.song_row,viewGroup,false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i)
    {
        final SongDetails sd = songsList.get(i);
        holder.titleSong.setText(sd.Title);
        holder.artistSong.setText(sd.Artist);
        holder.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onitemClickListner!=null)
                {
                    onitemClickListner.onItemClick(holder.btnDownload,v,sd,i);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView titleSong,artistSong;
        Button btnDownload;
        public Holder(@NonNull View itemView) {
            super(itemView);
            titleSong=(TextView)itemView.findViewById(R.id.songTitle);
            artistSong=(TextView)itemView.findViewById(R.id.artistName);
            btnDownload=(Button) itemView.findViewById(R.id.downloadSong);

        }
    }
}
