package com.disabngo.blockynexus.view.fragment.more;

import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: MoreViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class D implements com.sandboxol.greendao.a.c<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MoreViewModel f11841a;

    D(MoreViewModel moreViewModel) {
        this.f11841a = moreViewModel;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        J.a(this.f11841a.f11846a, friend, new FriendActivityIntentInfo(AccountCenter.newInstance().userId.get().longValue(), 4));
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
