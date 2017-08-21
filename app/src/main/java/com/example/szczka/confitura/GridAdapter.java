package com.example.szczka.confitura;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.szczka.confitura.adapter.EndangeredItem;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    List<EndangeredItem> mItems;

    public GridAdapter() {
        super();
        mItems = new ArrayList<EndangeredItem>();
        EndangeredItem nama = new EndangeredItem();
        nama.setName("Platinium Partner");
        nama.setThumbnail(R.drawable.volvo);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("");
        nama.setThumbnail(R.drawable.blank);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Gold Partner");
        nama.setThumbnail(R.drawable.colibra);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Gold Partner");
        nama.setThumbnail(R.drawable.itkontrakt);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Gold Partner");
        nama.setThumbnail(R.drawable.ocando);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Bronze Partner");
        nama.setThumbnail(R.drawable.datax);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Partner");
        nama.setThumbnail(R.drawable.pwr);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Partner");
        nama.setThumbnail(R.drawable.asp);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Partner");
        nama.setThumbnail(R.drawable.blank);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Partner");
        nama.setThumbnail(R.drawable.blank);
        mItems.add(nama);





    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        EndangeredItem nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imgThumbnail;
        public TextView tvspecies;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvspecies = (TextView)itemView.findViewById(R.id.status);

        }
    }


    
}