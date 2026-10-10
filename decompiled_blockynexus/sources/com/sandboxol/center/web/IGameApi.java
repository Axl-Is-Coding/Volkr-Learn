package com.sandboxol.center.web;

import com.sandboxol.center.entity.AdsTurntableInfo;
import com.sandboxol.center.entity.AllGameIdInfo;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.entity.AppEngineUpgradeResponse;
import com.sandboxol.center.entity.CampaignRank;
import com.sandboxol.center.entity.ChatRoomResponse;
import com.sandboxol.center.entity.GameDetailShop;
import com.sandboxol.center.entity.GameRankingInfo;
import com.sandboxol.center.entity.GameResInfo;
import com.sandboxol.center.entity.GameUpdateContentInfo;
import com.sandboxol.center.entity.GameWarmUpResponse;
import com.sandboxol.center.entity.PartyCreateGameConfig;
import com.sandboxol.center.entity.RankInfo;
import com.sandboxol.center.entity.ResCheckEntity;
import com.sandboxol.center.entity.SystemAnnouncementInfo;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.TypePageData;
import com.sandboxol.greendao.entity.AuthorInfo;
import com.sandboxol.greendao.entity.Dispatch;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.MiniGameToken;
import com.umeng.analytics.pro.au;
import java.util.List;
import java.util.Map;
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
public interface IGameApi {
    @PUT("/game/api/v1/games/{gameId}/appreciation")
    Observable<HttpResponse<Integer>> appreciation(@Path("gameId") String str);

    @GET("/game/api/v1/games")
    Observable<HttpResponse<PageData<Game>>> category(@Query("pageNo") int i, @Query("pageSize") int i2, @Query("orderType") String str, @Query("typeId") long j, @Query("order") String str2, @Query("isPublish") int i3, @Header(au.M) String str3);

    @PUT("/game/api/v1/games/engine")
    Observable<HttpResponse> countUploadVersion(@Query("engineVersion") String str, @Query("newEngineVersion") int i, @Header("CloudFront-Viewer-Country") String str2);

    @DELETE("/game/api/v1/game/chat/room")
    Observable<HttpResponse> deleteChatRoom(@Query("roomId") String str);

    @POST("/v1/follow")
    Observable<HttpResponse<Dispatch>> followGame(@Body Map<String, Object> map, @Header("x-shahe-uid") long j, @Header("x-shahe-token") String str);

    @GET("/game/api/v1/flow/game/auth")
    Observable<HttpResponse<MiniGameToken>> followGameAuth(@Query("typeId") String str, @Query("targetId") long j, @Query("gameVersion") int i, @Query("regionId") String str2, @Header("CloudFront-Viewer-Country") String str3);

    @GET("/game/api/v1/games/playlist/friends")
    Observable<HttpResponse<List<Game>>> friendPlayList(@Header(au.M) String str);

    @GET("/game/api/v2/games/{gameId}")
    Observable<HttpResponse<Game>> gameDetail(@Path("gameId") String str, @Query("appVersion") int i, @Header(au.M) String str2, @Header("engineVersion") long j);

    @GET("/game/api/v1/games/warmup/{gameId}/languages/{language}")
    Observable<HttpResponse<GameWarmUpResponse>> gamePreheat(@Path("gameId") String str, @Path(au.M) String str2);

    @PUT("/game/api/v1/game/record/ads")
    Observable<HttpResponse<Long>> getAdsGameDouble(@Header(au.M) String str);

    @GET("/game/api/v1/game/{gameId}/turntable/props")
    Observable<HttpResponse<String>> getAdsTurnHaveReward(@Path("gameId") String str, @Header(au.M) String str2);

    @GET("/game/api/v1/game/{gameId}/turntable")
    Observable<HttpResponse<List<AdsTurntableInfo>>> getAdsTurntableInfo(@Path("gameId") String str, @Header(au.M) String str2);

    @PUT("/game/api/v1/game/{gameId}/turntable")
    Observable<HttpResponse<Long>> getAdsTurntableReward(@Path("gameId") String str, @Header(au.M) String str2);

    @GET("/game/api/v1/games/all/open/party")
    Observable<HttpResponse<List<AllGameIdInfo>>> getAllGameIdInfo(@Header(au.M) String str, @Query("appVersion") int i);

    @GET("/game/api/v1/games/team/member/{teamId}")
    Observable<HttpResponse<List<AuthorInfo>>> getAuthorList(@Path("teamId") long j, @Header(au.M) String str);

    @POST("/game/api/v1/game/chat/room")
    Observable<HttpResponse<ChatRoomResponse>> getChatRoom(@Query("roomName") String str);

    @GET("/game/api/v2/games/recommendation/type")
    Observable<HttpResponse<PageData<Game>>> getGameByType(@Header(au.M) String str, @Query("type") String str2, @Query("pageNo") int i, @Query("pageSize") int i2, @Query(au.w) String str3);

    @GET("/shop/api/v2/shop/game/props/new")
    Observable<HttpResponse<List<GameDetailShop>>> getGameDetailShop(@Header("userId") long j, @Header("Access-Token") String str, @Header(au.M) String str2, @Query("gameId") String str3, @Query("engineVersion") int i);

    @GET("/game/api/v1/game/revision/list/by/condition")
    Observable<HttpResponse<TypePageData<Game>>> getGameListByCondition(@Header(au.M) String str, @Query("isFilter") int i, @Query("sortType") String str2, @Query("filterTypeId") long j, @Query("pageNo") int i2, @Query("pageSize") int i3, @Query(au.w) String str3);

    @GET("/game/api/v1/game/revision/list/recommend")
    Observable<HttpResponse<List<Game>>> getGameListGuessYouLike(@Header(au.M) String str, @Query("isFilter") int i, @Query(au.w) String str2);

    @GET("/game/api/v1/game/revision/list/more")
    Observable<HttpResponse<PageData<Game>>> getGameListMore(@Header(au.M) String str, @Query("isFilter") int i, @Query(au.w) String str2, @Query("pageNo") int i2, @Query("pageSize") int i3);

    @GET("/game/api/v1/games/{gameId}/uses/rank")
    Observable<HttpResponse<CampaignRank>> getGameMyRank(@Header(au.M) String str, @Path("gameId") String str2, @Query("type") String str3);

    @GET("/game/api/v1/games/{gameId}/rank")
    Observable<HttpResponse<RankInfo<CampaignRank>>> getGameRank(@Header(au.M) String str, @Path("gameId") String str2, @Query("type") String str3, @Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/game/api/v1/games/app-engine/check-update")
    Observable<HttpResponse<List<AppEngineResourceUpdateResult>>> getGameResource(@Query("engineVersion") long j, @Query("commonResVersion") long j2, @Query("gameResVersion") long j3, @Query("gameType") String str, @Query("engineType") String str2, @Header(au.M) String str3);

    @GET("/game/api/v1/category/list/by/language")
    Observable<HttpResponse<List<GameRankingInfo>>> getGameTypeList(@Header(au.M) String str);

    @GET("/game/api/v1/games/update/tip/info/app/{gameId}")
    Observable<HttpResponse<GameUpdateContentInfo>> getGameUpdateContent(@Path("gameId") String str, @Header(au.M) String str2, @Query("engineVersion") int i, @Query("isNew") int i2);

    @GET("/game/api/v1/games/update/list/{userId}")
    Observable<HttpResponse<Map<String, Integer>>> getGameUpdateContentList(@Path("userId") long j, @Header(au.M) String str, @Query("oldEngineVersion") int i, @Query("newEngineVersion") int i2);

    @GET("/game/api/v1/games/config/app/{gameId}")
    Observable<HttpResponse<PartyCreateGameConfig>> getPartyCreateGameConfig(@Path("gameId") String str, @Header(au.M) String str2);

    @GET("/v1/game-res")
    Observable<HttpResponse<GameResInfo>> getResInfo(@Query("gameType") String str, @Query("engineVersion") int i, @Query("resVersion") int i2);

    @GET("/game/api/v1/games/stop/announcement/info")
    Observable<HttpResponse<SystemAnnouncementInfo>> getStopServiceAnnouncementInfo(@Header(au.M) String str);

    @GET("/game/api/v1/games/announcement/info")
    Observable<HttpResponse<SystemAnnouncementInfo>> getSystemAnnouncementInfo(@Header(au.M) String str, @Header("gameId") String str2);

    @GET("/game/api/v1/games/ugc")
    Observable<HttpResponse<PageData<Game>>> getUGCGameList(@Query(au.M) String str, @Query("pageSize") int i, @Query("pageNo") int i2, @Query(au.w) String str2);

    @GET("/game/api/v1/games/ugc/status")
    Observable<HttpResponse<List<String>>> getUGCGameStatus(@Query("newEngineVersion") int i);

    @GET("/game/api/v1/games/app-engine/upgrade")
    Observable<HttpResponse<AppEngineUpgradeResponse>> getUpgradeInfo(@Query("engineVersion") long j, @Query("resVersion") long j2, @Query("gameType") String str, @Header(au.M) String str2);

    @GET("/game/api/v1/games/{gameId}")
    Observable<HttpResponse<Game>> miniGameDetail(@Path("gameId") String str, @Header(au.M) String str2);

    @GET("/v1/game-map")
    Observable<HttpResponse<MiniGameToken>> miniGameMap(@Query("mapName") String str, @Query("gameType") String str2, @Query("engineVersion") long j);

    @GET("/game/api/v2/game/auth")
    Observable<HttpResponse<MiniGameToken>> miniGameToken(@Query("typeId") String str, @Query("targetId") long j, @Query("gameVersion") int i, @Header("CloudFront-Viewer-Country") String str2);

    @POST("/v1/dispatch")
    Observable<HttpResponse<Dispatch>> newMiniGameDispatcher(@Body Map<String, Object> map, @Header("x-shahe-uid") long j, @Header("x-shahe-token") String str);

    @GET("/game/api/v1/games/playlist/recently")
    Observable<HttpResponse<List<Game>>> recentlyPlayList(@Header(au.M) String str, @Query("isFilter") int i);

    @GET("/game/api/v2/games/recommendation")
    Observable<HttpResponse<List<Game>>> recommendation(@Header(au.M) String str);

    @GET("/game/api/v1/games/resource/version")
    Observable<HttpResponse<ResCheckEntity>> resCheck(@Query("ver") int i, @Query("platform") String str);
}
