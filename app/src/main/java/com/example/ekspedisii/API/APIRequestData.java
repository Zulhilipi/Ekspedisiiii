package com.example.ekspedisii.API;

import com.example.ekspedisii.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface  APIRequestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel> ardCreateData(
            @Field("no_surat") String no_surat,
            @Field("pengirim") String pengirim,
            @Field("penerima") String penerima,
            @Field("tujuan") String tujuan,
            @Field("status_surat") String status_surat,
            @Field("keterangan") String keterangan);
}
