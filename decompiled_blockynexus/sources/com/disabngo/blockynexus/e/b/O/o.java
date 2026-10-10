package com.disabngo.blockynexus.e.b.O;

import android.content.Context;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: MakeFriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f9381b;

    o(q qVar, Context context) {
        this.f9381b = qVar;
        this.f9380a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(this.f9380a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9380a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        if (Long.parseLong(str) == 0) {
            TribeCenter.newInstance().tribeClanId.set(0L);
            y.b().l(0L);
        } else {
            TribeCenter.newInstance().tribeClanId.set(Long.valueOf(str));
            this.f9381b.a(this.f9380a, Long.parseLong(str));
            y.b().l(Long.valueOf(str).longValue());
            ReportDataAdapter.onEvent(this.f9380a, EventConstant.CLAN_HAS_CLAN);
        }
    }
}
