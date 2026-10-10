package com.sandboxol.gamedetail.c.a.b;

import android.content.Context;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: GameDetailIntroduceTopItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
class l implements com.sandboxol.greendao.a.c<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f18067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ m f18068b;

    l(m mVar, Context context) {
        this.f18068b = mVar;
        this.f18067a = context;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        if (friend == null || friend.getNickName() == null) {
            return;
        }
        this.f18068b.f18073e.set(true);
        this.f18068b.f18071c = true;
        this.f18068b.g.set(this.f18067a.getString(R.string.gamedetail_is_friend));
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
