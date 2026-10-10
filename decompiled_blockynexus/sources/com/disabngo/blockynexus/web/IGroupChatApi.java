package com.disabngo.blockynexus.web;

import com.disabngo.blockynexus.entity.CreateGroupPrice;
import com.disabngo.blockynexus.entity.GroupAdminsParam;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupInfoParam;
import com.disabngo.blockynexus.entity.GroupInviteCount;
import com.disabngo.blockynexus.entity.GroupInviteParam;
import com.disabngo.blockynexus.entity.GroupOwnerRecall;
import com.disabngo.blockynexus.entity.GroupParam;
import com.disabngo.blockynexus.entity.GroupRemoveParam;
import com.disabngo.blockynexus.entity.GroupRequest;
import com.disabngo.blockynexus.entity.GroupTransferParam;
import com.disabngo.blockynexus.entity.JoinGroupRequest;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.umeng.analytics.pro.au;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IGroupChatApi {
    @POST("/msg/api/v2/msg/group/chat")
    Observable<HttpResponse<GroupInfo>> createGroupChat(@Body GroupParam groupParam);

    @GET("/msg/api/v1/group/chat/price")
    Observable<HttpResponse<CreateGroupPrice>> getCreateGroupTypeAndPrice();

    @GET("/msg/api/v1/msg/group/chat/list")
    Observable<HttpResponse<PageData<GroupInfo>>> getGroupChatList(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/msg/api/v1/msg/group/chat/info")
    Observable<HttpResponse<GroupInfo>> getGroupInfo(@Query("groupId") long j);

    @GET("/msg/api/v1/msg/group/chat/invite/count")
    Observable<HttpResponse<GroupInviteCount>> getGroupInviteCount(@Query("groupId") long j, @Header(au.M) String str);

    @GET("/msg/api/v1/msg/group/chat/request/list")
    Observable<HttpResponse<PageData<GroupRequest>>> getGroupRequestMessage(@Query("pageNo") int i, @Query("pageSize") int i2, @Header(au.M) String str);

    @POST("/msg/api/v1/msg/group/chat/add")
    Observable<HttpResponse<GroupInfo>> inviteMemberToGroup(@Body GroupInviteParam groupInviteParam);

    @POST("/msg/api/v1/msg/group/chat/mail/add")
    Observable<HttpResponse<GroupInfo>> inviteMemberToGroupByEmail(@Query("groupId") long j);

    @POST("/msg/api/v1/msg/group/chat/forbidden/member")
    Observable<HttpResponse<GroupInfo>> postBanMember(@Query("groupId") long j, @Query("memberId") long j2, @Query("minute") int i, @Header(au.M) String str);

    @POST("/msg/api/v1/msg/group/chat/invite")
    Observable<HttpResponse> postInviteGroupRequest(@Query("groupId") long j, @Query("memberIds") List<Long> list, @Header(au.M) String str);

    @POST("/msg/api/v1/msg/group/chat/apply")
    Observable<HttpResponse> postJoinGroupRequest(@Query("groupId") long j, @Query("msg") String str, @Header(au.M) String str2);

    @POST("/msg/api/v1/msg/group/chat/recall/message")
    Observable<HttpResponse> postOwnerRecallMessage(@Body GroupOwnerRecall groupOwnerRecall, @Header(au.M) String str);

    @PUT("/msg/api/v1/msg/group/chat/forbidden")
    Observable<HttpResponse<GroupInfo>> putBanOrUnbanAllMember(@Query("groupId") long j, @Header(au.M) String str);

    @PUT("/msg/api/v1/msg/group/chat/agreement")
    Observable<HttpResponse<GroupInfo>> putJoinGroupRequest(@Body JoinGroupRequest joinGroupRequest, @Header(au.M) String str);

    @PUT("/msg/api/v1/msg/group/chat/reject")
    Observable<HttpResponse> putRefuseGroupRequest(@Body JoinGroupRequest joinGroupRequest, @Header(au.M) String str);

    @PUT("/msg/api/v1/msg/group/chat/remove/forbidden/member")
    Observable<HttpResponse<GroupInfo>> putRemoveBanMember(@Query("groupId") long j, @Query("memberId") long j2, @Header(au.M) String str);

    @PUT("/msg/api/v1/msg/group/chat/quit")
    Observable<HttpResponse<PageData<GroupInfo>>> quitGroup(@Query("groupId") long j, @Query("groupName") String str);

    @PUT("/msg/api/v1/msg/group/chat/kickOut")
    Observable<HttpResponse<GroupInfo>> removeMemberFromGroup(@Body GroupRemoveParam groupRemoveParam);

    @PUT("/msg/api/v1/msg/group/chat/set/manager")
    Observable<HttpResponse<GroupInfo>> setGroupManager(@Body GroupAdminsParam groupAdminsParam);

    @PUT("/msg/api/v1/msg/group/chat/transfer")
    Observable<HttpResponse<GroupInfo>> transferGroupOwner(@Body GroupTransferParam groupTransferParam);

    @PUT("/msg/api/v1/msg/group/chat/modify")
    Observable<HttpResponse<GroupInfo>> updateGroupInfo(@Body GroupInfoParam groupInfoParam);
}
