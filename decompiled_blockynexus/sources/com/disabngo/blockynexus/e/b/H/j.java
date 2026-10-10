package com.disabngo.blockynexus.e.b.H;

import android.content.Context;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.JoinGroupRequest;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: GroupVerificationModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    public static void a(Context context, JoinGroupRequest joinGroupRequest, OnResponseListener<GroupInfo> onResponseListener) {
        GroupChatApi.putGroupRequest(context, joinGroupRequest, onResponseListener);
    }

    public static void b(Context context, JoinGroupRequest joinGroupRequest, OnResponseListener onResponseListener) {
        GroupChatApi.putRefuseGroupRequest(context, joinGroupRequest, onResponseListener);
    }
}
