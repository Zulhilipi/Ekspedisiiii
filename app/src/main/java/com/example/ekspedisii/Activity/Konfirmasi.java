package com.example.ekspedisii.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ekspedisii.API.APIRequestData;
import com.example.ekspedisii.API.RetroServer;
import com.example.ekspedisii.Model.ResponseModel;
import com.example.ekspedisii.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Konfirmasi extends AppCompatActivity {
    private EditText etNo_Surat, etPengirim, etPenerima, etTujuan, etStatus_Surat, etKeterangan;
    private Button btnSimpan;
    private String no_surat, pengirim, penerima, tujuan, status_surat, keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);

        etNo_Surat = findViewById(R.id.et_nosurat);
        etPengirim = findViewById(R.id.et_pengirim);
        etPenerima = findViewById(R.id.et_penerima);
        etTujuan = findViewById(R.id.et_tujuan);
        etStatus_Surat = findViewById(R.id.et_statussurat);
        etKeterangan = findViewById(R.id.et_keterangan);
        btnSimpan = findViewById(R.id.btn_simpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no_surat = etNo_Surat.getText().toString();
                pengirim = etPengirim.getText().toString();
                penerima = etPenerima.getText().toString();
                tujuan = etTujuan.getText().toString();
                status_surat = etStatus_Surat.getText().toString();
                keterangan = etKeterangan.getText().toString();

                if(no_surat.trim().equals("")){
                    etNo_Surat.setError("Mohon Di Isi");
                }
                else if(pengirim.trim().equals("")){
                    etPengirim.setError("Mohon Di Isi");
                }
                else if(penerima.trim().equals("")){
                    etPenerima.setError("Mohon Di Isi");
                }
                else if(tujuan.trim().equals("")){
                    etTujuan.setError("Mohon Di Isi");
                }
                else if(status_surat.trim().equals("")){
                    etStatus_Surat.setError("Mohon Di Isi");
                }
                else if(keterangan.trim().equals("")){
                    etKeterangan.setError("Mohon Di Isi");
                }
                else{
                    createdata();
                }
            }
        });

    }

    private void createdata(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> simpanData = ardData.ardCreateData(no_surat, pengirim, penerima, tujuan, status_surat, keterangan);

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(Konfirmasi.this, "kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(Konfirmasi.this, "Gagal Menghubungi Server | "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}