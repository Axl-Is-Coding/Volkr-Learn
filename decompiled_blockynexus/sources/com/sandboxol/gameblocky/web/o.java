package com.sandboxol.gameblocky.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.MiniGameToken;

/* JADX INFO: compiled from: BlockyGameApi.java */
/* JADX INFO: loaded from: classes3.dex */
class o extends HttpSubscriber<MiniGameToken, HttpResponse<MiniGameToken>> {
    o(OnResponseListener onResponseListener) {
        super(onResponseListener);
    }

    @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return true;
    }
}
