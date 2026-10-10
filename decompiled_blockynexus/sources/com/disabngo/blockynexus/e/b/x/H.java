package com.disabngo.blockynexus.e.b.x;

import com.disabngo.blockynexus.entity.FriendStatus;
import com.disabngo.blockynexus.entity.StatusBean;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.utils.FriendStatusTimeRecorder;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.imchat.config.ChatSharedConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: FriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class H extends OnResponseListener<FriendStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f10284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ I f10285b;

    H(I i, List list) {
        this.f10285b = i;
        this.f10284a = list;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(FriendStatus friendStatus) {
        if (friendStatus == null) {
            this.f10285b.f10288c.onSuccess(this.f10284a);
            return;
        }
        FriendStatusTimeRecorder.getInstance().setSystemCurrentTime(friendStatus.getCurrentTime());
        SharedUtils.putLong(this.f10285b.f10287b, ChatSharedConstant.SERVER_TIME, friendStatus.getCurrentTime());
        List<StatusBean> status = friendStatus.getStatus();
        J.c((List<Friend>) this.f10284a, (List<StatusBean>) status);
        ArrayList<Friend> arrayList = new ArrayList();
        J.b(this.f10285b.f10287b, (List<Friend>) this.f10284a, (List<Friend>) arrayList);
        Collections.sort(this.f10284a, new com.disabngo.blockynexus.d.o());
        for (Friend friend : arrayList) {
            this.f10284a.remove(friend);
            this.f10284a.add(0, friend);
        }
        J.b((List<Long>) J.d(this.f10284a), (List<Long>) J.c(status), this.f10285b.f10289d);
        Messenger.getDefault().send(new FriendStatus(friendStatus.getCurFriendCount(), friendStatus.getMaxFriendCount()), MessageToken.TOKEN_FRIEND_TOTAL_SIZE);
        this.f10285b.f10288c.onSuccess(this.f10284a);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10285b.f10288c.onSuccess(this.f10284a);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10285b.f10288c.onSuccess(this.f10284a);
    }
}
