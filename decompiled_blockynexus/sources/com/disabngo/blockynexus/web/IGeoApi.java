package com.disabngo.blockynexus.web;

import com.disabngo.blockynexus.entity.UserMapInfo;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.greendao.entity.UserGameCareerTotalData;
import com.umeng.analytics.pro.au;
import io.rong.imkit.plugin.LocationConst;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IGeoApi {
    @GET("/geoinfo/api/v1/user/game/career/data/{userId}")
    Observable<HttpResponse<UserGameCareerTotalData>> getUserGameCareerTotalData(@Path("userId") long j, @Header(au.M) String str);

    @GET("/geoinfo/api/v1/userGeoInfo")
    Observable<HttpResponse<List<UserMapInfo>>> getUserMapInfoList(@Header(au.M) String str);

    @POST("/geoinfo/api/v1/userGeoInfo")
    Observable<HttpResponse> postUserGeoInfo(@Query(LocationConst.LONGITUDE) double d2, @Query(LocationConst.LATITUDE) double d3);
}
