package com.sandboxol.gameblocky.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Dispatch;

/* JADX INFO: compiled from: BlockyGameApi.java */
/* JADX INFO: loaded from: classes3.dex */
class k extends HttpSubscriber<Dispatch, HttpResponse<Dispatch>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f17755a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k(l lVar, OnResponseListener onResponseListener) {
        super(onResponseListener);
        this.f17755a = lVar;
    }

    @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return true;
    }
}
