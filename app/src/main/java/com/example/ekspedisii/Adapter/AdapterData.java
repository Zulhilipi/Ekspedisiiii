package com.example.ekspedisii.Adapter;

import static com.example.ekspedisii.R.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ekspedisii.Model.DataModel;
import com.example.ekspedisii.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<DataModel> listData;

    public AdapterData(Context ctx, List<DataModel> listData) {
        this.ctx = ctx;
        this.listData = listData;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listData.get(position);

        holder.id.setText(String.valueOf(dm.getId()));
        holder.nosurat.setText(dm.getNo_surat());
        holder.pengirim.setText(dm.getPengirim());
        holder.tujuan.setText(dm.getTujuan());
        holder.alamat.setText(dm.getAlamat());
        holder.keterangan.setText(dm.getKeterangan());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView id, nosurat, pengirim, tujuan, alamat,keterangan;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            nosurat = itemView.findViewById(R.id.nosurat);
            pengirim = itemView.findViewById(R.id.pengirim);
            tujuan = itemView.findViewById(R.id.tujuan);
            alamat = itemView.findViewById(R.id.alamat);
            keterangan = itemView.findViewById(R.id.keterangan);

        }
    }
}
