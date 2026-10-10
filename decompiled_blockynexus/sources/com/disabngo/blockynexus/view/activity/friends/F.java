package com.disabngo.blockynexus.view.activity.friends;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class F {
    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, FriendActivityIntentInfo friendActivityIntentInfo, Friend friend) {
        FriendApi.friendDeleteAlias(context, friendActivityIntentInfo.getFriendId(), new A(this, context, friend, friendActivityIntentInfo));
    }

    public void c(Activity activity, long j) {
        FriendApi.friendAgreeAdd(activity, j, new x(this, j, activity));
    }

    public void b(Activity activity, long j) {
        FriendApi.friendDelete(activity, j, new D(this, j, activity));
    }

    public void a(Context context, FriendActivityIntentInfo friendActivityIntentInfo, Friend friend) {
        EditTextDialog editTextDialogC = new EditTextDialog(context).c(context.getString(R.string.add_friend_alias));
        if (TextUtils.isEmpty(friend.getAlias())) {
            editTextDialogC.b(context.getString(R.string.input_friend_alias));
        } else {
            editTextDialogC.a(friend.getAlias());
        }
        editTextDialogC.a(new y(this, context, friendActivityIntentInfo, friend)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, FriendActivityIntentInfo friendActivityIntentInfo, Friend friend, String str) {
        FriendApi.friendAddAlias(context, friendActivityIntentInfo.getFriendId(), str, new z(this, context, str, friend, friendActivityIntentInfo));
    }

    public void a(Activity activity, FriendActivityIntentInfo friendActivityIntentInfo, int i) {
        new EditTextDialog(activity).c(activity.getString(R.string.add_friend)).b(activity.getString(R.string.send_apply_for_friend_msg)).a(new C(this, friendActivityIntentInfo, activity, i)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i) {
        if (i == 4) {
            ReportDataAdapter.onEvent(context, EventConstant.APPLY_RECOM_FRI, "Friend Detail Page");
        } else if (i == 5) {
            ReportDataAdapter.onEvent(context, EventConstant.APPLY_FILTER_FRI, "Friend Detail Page");
        } else {
            if (i != 6) {
                return;
            }
            ReportDataAdapter.onEvent(context, EventConstant.APPLY_SEARCH_FRI, "Friend Detail Page");
        }
    }

    public void a(Activity activity, FriendActivityIntentInfo friendActivityIntentInfo, Friend friend) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b("friend.user.id", friendActivityIntentInfo.getFriendId());
        if (!TextUtils.isEmpty(friend.getAlias())) {
            fVar.b("friend.nickname", friend.getAlias());
        } else {
            fVar.b("friend.nickname", friend.getNickName());
        }
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_ENTER_FRIEND_CHAT, fVar);
        ReportDataAdapter.onEvent(activity, EventConstant.CHAT_SEND_CLICK);
        activity.finish();
    }

    public void a(Activity activity, long j) {
        FriendApi.addToBlacklist(activity, j, new E(this, j, activity));
    }
}
