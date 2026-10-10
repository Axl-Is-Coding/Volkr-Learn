package com.sandboxol.gameblocky.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.greendao.entity.Dispatch;
import com.sandboxol.greendao.entity.MiniGameToken;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IBlockyGameApi {
    @POST("/v1/follow")
    Observable<HttpResponse<Dispatch>> followGame(@Body Map<String, Object> map, @Header("x-shahe-uid") long j, @Header("x-shahe-token") String str);

    @GET("/game/api/v1/flow/game/auth")
    Observable<HttpResponse<MiniGameToken>> followGameAuth(@Query("typeId") String str, @Query("targetId") long j, @Query("gameVersion") int i, @Header("CloudFront-Viewer-Country") String str2);

    @GET("/v1/game-map")
    Observable<HttpResponse<MiniGameToken>> miniGameMap(@Query("mapName") String str, @Query("gameType") String str2, @Query("engineVersion") long j);

    @GET("/game/api/v2/game/auth")
    Observable<HttpResponse<MiniGameToken>> miniGameToken(@Query("typeId") String str, @Query("targetId") long j, @Query("gameVersion") int i, @Header("CloudFront-Viewer-Country") String str2);

    @POST("/v1/dispatch")
    Observable<HttpResponse<Dispatch>> newMiniGameDispatcher(@Body Map<String, Object> map, @Header("x-shahe-uid") long j, @Header("x-shahe-token") String str);
}
