package com.disabngo.blockynexus.e.b.x;

import android.net.Uri;
import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: FriendFragment.java */
/* JADX INFO: loaded from: classes2.dex */
class r implements com.sandboxol.greendao.a.c<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f10314a;

    r(s sVar) {
        this.f10314a = sVar;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        if (friend != null) {
            N.a(String.valueOf(friend.getUserId()), friend.getAlias(), Uri.parse(friend.getPicUrl()));
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
