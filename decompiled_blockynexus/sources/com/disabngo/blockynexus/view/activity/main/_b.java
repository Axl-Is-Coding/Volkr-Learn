package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.disabngo.blockynexus.web.CampaignApi;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class _b implements com.sandboxol.greendao.a.c<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f10869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bc f10871c;

    _b(bc bcVar, boolean z, Context context) {
        this.f10871c = bcVar;
        this.f10869a = z;
        this.f10870b = context;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        if (this.f10869a && bool.booleanValue()) {
            return;
        }
        if (this.f10869a || bool.booleanValue()) {
            CampaignApi.signInList(this.f10870b, new Zb(this));
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
