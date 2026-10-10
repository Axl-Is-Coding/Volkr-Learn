package com.disabngo.blockynexus.e.b.C;

import android.content.Context;
import com.disabngo.blockynexus.entity.GroupInfoParam;
import com.disabngo.blockynexus.web.GroupChatApi;

/* JADX INFO: compiled from: GroupEditModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    public void a(Context context, GroupInfoParam groupInfoParam) {
        GroupChatApi.updateGroupInfo(context, groupInfoParam, new h(this, context, groupInfoParam));
    }
}
