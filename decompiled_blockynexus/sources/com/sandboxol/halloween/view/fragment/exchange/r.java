package com.sandboxol.halloween.view.fragment.exchange;

import android.content.Context;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.halloween.entity.ExchangeResponse;

/* JADX INFO: compiled from: ExchangeModel.java */
/* JADX INFO: loaded from: classes4.dex */
class r {

    /* JADX INFO: compiled from: ExchangeModel.java */
    interface a {
        void a(int i);
    }

    /* JADX INFO: compiled from: ExchangeModel.java */
    interface b {
        void a(ExchangeResponse exchangeResponse);
    }

    public static void a(Context context, long j, b bVar) {
        com.sandboxol.halloween.web.g.a(context, j, new p(bVar, context));
    }

    public static void a(Context context, int i, a aVar) {
        com.sandboxol.halloween.web.g.a(context, i, (OnResponseListener<Integer>) new q(aVar, context));
    }
}
