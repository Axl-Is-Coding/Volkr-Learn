package com.disabngo.blockynexus.utils.logic;

import android.content.Context;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class E implements com.sandboxol.greendao.a.c<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Long f10522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f10523c;

    E(F f2, Context context, Long l) {
        this.f10523c = f2;
        this.f10521a = context;
        this.f10522b = l;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        com.disabngo.blockynexus.e.b.x.J.a(this.f10521a, friend, new FriendActivityIntentInfo(this.f10522b.longValue(), 2));
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
