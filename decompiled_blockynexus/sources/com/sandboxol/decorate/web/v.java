package com.sandboxol.decorate.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.IOnResponseAdapter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.adapter.DataOnResponseAdapter;
import com.sandboxol.greendao.entity.BuyDressResponse;

/* JADX INFO: compiled from: ShopApi.java */
/* JADX INFO: loaded from: classes3.dex */
class v extends HttpSubscriber<BuyDressResponse, HttpResponse<BuyDressResponse>> {
    v(OnResponseListener onResponseListener) {
        super(onResponseListener);
    }

    @Override // com.sandboxol.common.base.web.BaseSubscriber
    public IOnResponseAdapter<BuyDressResponse> getOnResponseAdapter() {
        return new DataOnResponseAdapter();
    }
}
