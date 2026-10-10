package com.disabngo.blockynexus.web;

import android.content.Context;
import com.disabngo.blockynexus.entity.CreateGroupPrice;
import com.disabngo.blockynexus.entity.GroupAdminsParam;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupInfoParam;
import com.disabngo.blockynexus.entity.GroupInviteCount;
import com.disabngo.blockynexus.entity.GroupOwnerRecall;
import com.disabngo.blockynexus.entity.GroupParam;
import com.disabngo.blockynexus.entity.GroupRemoveParam;
import com.disabngo.blockynexus.entity.GroupRequest;
import com.disabngo.blockynexus.entity.GroupTransferParam;
import com.disabngo.blockynexus.entity.JoinGroupRequest;
import com.sandboxol.center.web.http.AuthTokenHttpPageSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class GroupChatApi {
    private static final IGroupChatApi api = (IGroupChatApi) RetrofitFactory.httpsCreate("https://d32gv25kv9q34j.cloudfront.net", IGroupChatApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void banOrUnbanAllMember(final Context context, final long j, final OnResponseListener<GroupInfo> onResponseListener) {
        api.putBanOrUnbanAllMember(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.T
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.banOrUnbanAllMember(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void createGroupChat(final Context context, final GroupParam groupParam, final OnResponseListener<GroupInfo> onResponseListener) {
        api.createGroupChat(groupParam).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Y
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.createGroupChat(context, groupParam, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void enterGroupByEmail(final Context context, final long j, final OnResponseListener<GroupInfo> onResponseListener) {
        api.inviteMemberToGroupByEmail(j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.da
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.enterGroupByEmail(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getCreateGroupTypeAndPrice(final Context context, final OnResponseListener<CreateGroupPrice> onResponseListener) {
        api.getCreateGroupTypeAndPrice().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.P
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.getCreateGroupTypeAndPrice(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGroupChatList(final Context context, final int i, final int i2, final OnResponseListener<PageData<GroupInfo>> onResponseListener) {
        api.getGroupChatList(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.M
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.getGroupChatList(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGroupInfo(final Context context, final long j, final OnResponseListener<GroupInfo> onResponseListener) {
        api.getGroupInfo(j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.S
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.getGroupInfo(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGroupInviteCount(final Context context, final long j, final OnResponseListener<GroupInviteCount> onResponseListener) {
        api.getGroupInviteCount(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.O
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.getGroupInviteCount(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGroupRequestMessage(final Context context, final int i, final int i2, final OnResponseListener<PageData<GroupRequest>> onResponseListener) {
        api.getGroupRequestMessage(i, i2, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.L
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.getGroupRequestMessage(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void ownerRecallMessage(final Context context, final GroupOwnerRecall groupOwnerRecall, final OnResponseListener onResponseListener) {
        api.postOwnerRecallMessage(groupOwnerRecall, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.W
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.ownerRecallMessage(context, groupOwnerRecall, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postBanMember(final Context context, final long j, final long j2, final int i, final OnResponseListener<GroupInfo> onResponseListener) {
        api.postBanMember(j, j2, i, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.K
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.postBanMember(context, j, j2, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postJoinGroupApply(final Context context, final long j, final String str, final OnResponseListener onResponseListener) {
        api.postJoinGroupRequest(j, str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ba
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.postJoinGroupApply(context, j, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postJoinGroupInvite(final Context context, final long j, final List<Long> list, final OnResponseListener onResponseListener) {
        api.postInviteGroupRequest(j, list, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.X
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.postJoinGroupInvite(context, j, list, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void putGroupRequest(final Context context, final JoinGroupRequest joinGroupRequest, final OnResponseListener<GroupInfo> onResponseListener) {
        api.putJoinGroupRequest(joinGroupRequest, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.aa
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.putGroupRequest(context, joinGroupRequest, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void putRefuseGroupRequest(final Context context, final JoinGroupRequest joinGroupRequest, final OnResponseListener onResponseListener) {
        api.putRefuseGroupRequest(joinGroupRequest, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Q
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.putRefuseGroupRequest(context, joinGroupRequest, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void putRemoveBanMember(final Context context, final long j, final long j2, final OnResponseListener<GroupInfo> onResponseListener) {
        api.putRemoveBanMember(j, j2, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.V
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.putRemoveBanMember(context, j, j2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void quitGroup(final Context context, final long j, final String str, final OnResponseListener<PageData<GroupInfo>> onResponseListener) {
        api.quitGroup(j, str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.Z
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.quitGroup(context, j, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void removeMemberFromGroup(final Context context, final GroupRemoveParam groupRemoveParam, final OnResponseListener<GroupInfo> onResponseListener) {
        api.removeMemberFromGroup(groupRemoveParam).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ca
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.removeMemberFromGroup(context, groupRemoveParam, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setGroupManager(final Context context, final GroupAdminsParam groupAdminsParam, final OnResponseListener<GroupInfo> onResponseListener) {
        api.setGroupManager(groupAdminsParam).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.N
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.setGroupManager(context, groupAdminsParam, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void transferGroupOwner(final Context context, final GroupTransferParam groupTransferParam, final OnResponseListener<GroupInfo> onResponseListener) {
        api.transferGroupOwner(groupTransferParam).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.U
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.transferGroupOwner(context, groupTransferParam, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void updateGroupInfo(final Context context, final GroupInfoParam groupInfoParam, final OnResponseListener<GroupInfo> onResponseListener) {
        api.updateGroupInfo(groupInfoParam).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ea
            @Override // rx.functions.Action0
            public final void call() {
                GroupChatApi.updateGroupInfo(context, groupInfoParam, onResponseListener);
            }
        })));
    }
}
