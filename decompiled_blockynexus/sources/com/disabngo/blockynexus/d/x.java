package com.disabngo.blockynexus.d;

import android.content.Context;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.greendao.entity.TribeMember;
import java.util.List;

/* JADX INFO: compiled from: GroupUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class x implements com.sandboxol.greendao.a.c<List<TribeMember>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f7242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ y f7243b;

    x(y yVar, Context context) {
        this.f7243b = yVar;
        this.f7242a = context;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<TribeMember> list) {
        if (list == null || list.size() == 0) {
            TribeApi.tribeMember(this.f7242a, 24, new w(this));
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
