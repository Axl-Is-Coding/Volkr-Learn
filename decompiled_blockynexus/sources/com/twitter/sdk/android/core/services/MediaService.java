package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.models.h;
import okhttp3.G;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/* JADX INFO: loaded from: classes5.dex */
public interface MediaService {
    @POST("https://upload.twitter.com/1.1/media/upload.json")
    @Multipart
    Call<h> upload(@Part("media") G g, @Part("media_data") G g2, @Part("additional_owners") G g3);
}
