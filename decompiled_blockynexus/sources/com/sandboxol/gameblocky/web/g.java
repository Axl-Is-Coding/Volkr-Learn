package com.sandboxol.gameblocky.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.MiniGameToken;

/* JADX INFO: compiled from: BlockyGameApi.java */
/* JADX INFO: loaded from: classes3.dex */
class g extends HttpSubscriber<MiniGameToken, HttpResponse<MiniGameToken>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f17749a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    g(h hVar, OnResponseListener onResponseListener) {
        super(onResponseListener);
        this.f17749a = hVar;
    }

    @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return true;
    }
}
