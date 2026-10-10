package com.sandboxol.gameblocky.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Dispatch;

/* JADX INFO: compiled from: BlockyGameApi.java */
/* JADX INFO: loaded from: classes3.dex */
class j extends HttpSubscriber<Dispatch, HttpResponse<Dispatch>> {
    j(OnResponseListener onResponseListener) {
        super(onResponseListener);
    }

    @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return true;
    }
}
