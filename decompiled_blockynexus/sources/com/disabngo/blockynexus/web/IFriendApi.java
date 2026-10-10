package com.disabngo.blockynexus.web;

import com.disabngo.blockynexus.entity.FriendRequestAdd;
import com.disabngo.blockynexus.entity.FriendRequests;
import com.disabngo.blockynexus.entity.FriendStatus;
import com.disabngo.blockynexus.entity.RecommendFriendEntity;
import com.disabngo.blockynexus.entity.StatusBean;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.FriendFollowResponse;
import com.umeng.analytics.pro.au;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IFriendApi {
    @DELETE("/friend/api/v1/friends/black")
    Observable<HttpResponse> addToBlacklist(@Query("friendId") long j);

    @GET("/friend/api/v1/friends/follow")
    Observable<HttpResponse<PageData<FriendFollowResponse>>> followFriendsList(@Header(au.M) String str, @Query("pageNo") int i, @Query("pageSize") int i2);

    @POST("/friend/api/v1/friends")
    Observable<HttpResponse> friendAdd(@Body FriendRequestAdd friendRequestAdd);

    @POST("/friend/api/v1/friends/{friendId}/alias")
    Observable<HttpResponse> friendAddAlias(@Path("friendId") long j, @Query("alias") String str);

    @PUT("/friend/api/v1/friends/{friendId}/agreement")
    Observable<HttpResponse> friendAgreeAdd(@Path("friendId") long j);

    @DELETE("/friend/api/v1/friends")
    Observable<HttpResponse> friendDelete(@Query("friendId") long j);

    @DELETE("/friend/api/v1/friends/{friendId}/alias")
    Observable<HttpResponse> friendDeleteAlias(@Path("friendId") long j);

    @GET("/friend/api/v2/friends/{friendId}")
    Observable<HttpResponse<Friend>> friendDetails(@Path("friendId") long j, @Header(au.M) String str);

    @GET("/friend/api/v1/friends/{friendId}/gaming")
    Observable<HttpResponse<StatusBean>> friendGamingInfo(@Header(au.M) String str, @Path("friendId") long j);

    @GET("/friend/api/v1/friends")
    Observable<HttpResponse<PageData<Friend>>> friendList(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/friend/api/v1/friends/recommendation/new")
    Observable<HttpResponse<List<RecommendFriendEntity>>> friendRecommendation(@Query("searchType") int i, @Query(au.M) String str, @Query("gameId") String str2, @Query("sex") Integer num, @Query("searchText") String str3);

    @GET("/friend/api/v1/friends/recommendation")
    Observable<HttpResponse<List<RecommendFriendEntity>>> friendRecommendation(@Header(au.M) String str);

    @PUT("/friend/api/v1/friends/{friendId}/rejection")
    Observable<HttpResponse> friendRefuseAdd(@Path("friendId") long j);

    @GET("/friend/api/v1/friends/requests")
    Observable<HttpResponse<PageData<FriendRequests>>> friendRequestsList(@Query("pageNo") int i, @Query("pageSize") int i2, @Header(au.M) String str);

    @GET("/friend/api/v1/friends/info/{nickName}")
    Observable<HttpResponse<PageData<Friend>>> friendSearchList(@Path("nickName") String str, @Query("pageNo") int i, @Query("pageSize") int i2, @Query("fuzzyQuery") String str2);

    @GET("/friend/api/v2/friends/status")
    Observable<HttpResponse<FriendStatus>> friendStatus(@Header(au.M) String str);

    @GET("/friend/api/v1/friends/info/id/{id}")
    Observable<HttpResponse<Friend>> searchFriendById(@Path("id") long j);
}
