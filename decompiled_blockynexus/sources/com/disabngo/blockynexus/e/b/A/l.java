package com.disabngo.blockynexus.e.b.A;

import android.content.Context;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.messenger.Messenger;
import java.util.List;

/* JADX INFO: compiled from: GroupBannedModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    public List<GroupMember> a(GroupInfo groupInfo) {
        return y.b().b(groupInfo.getGroupMembers(), AccountCenter.newInstance().userId.get().longValue()) ? y.b().a(groupInfo.getGroupMembers()) : y.b().b(groupInfo.getGroupMembers());
    }

    public void a(Context context, long j, long j2) {
        GroupChatApi.putRemoveBanMember(context, j, j2, new k(this, context));
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_BAN_BOTTOM_DIALOG);
    }
}
