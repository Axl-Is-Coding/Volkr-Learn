package com.sandboxol.gameblocky.web;

import com.sandboxol.common.base.web.HttpResponse;
import okhttp3.x;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IBlockyUserApi {
    @POST("/user/api/{version}/directory/file")
    @Multipart
    Observable<HttpResponse<String>> uploadFile(@Query("fileName") String str, @Query("directory") String str2, @Part x.b bVar);
}
