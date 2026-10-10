package com.disabngo.blockynexus.e.b.o;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.greendao.c.P;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.o.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChatModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0895s implements com.sandboxol.greendao.a.c<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f10011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ v f10013c;

    C0895s(v vVar, int i, Context context) {
        this.f10013c = vVar;
        this.f10011a = i;
        this.f10012b = context;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        if (this.f10011a == 0 && friend == null) {
            Friend friend2 = new Friend();
            friend2.setNickName(this.f10012b.getString(R.string.friend_system_message));
            friend2.setUserId(32L);
            friend2.setPicUrl(UrlConstant.IC_CUSTOM_SERVICE);
            friend2.setStatus(10);
            P.newInstance().a(friend2, new C0894r(this));
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
