package com.disabngo.blockynexus.e.b.L;

import android.app.Activity;
import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: InboxModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f9339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f9340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f9341d;

    g(j jVar, int i, Context context, boolean z) {
        this.f9341d = jVar;
        this.f9338a = i;
        this.f9339b = context;
        this.f9340c = z;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        if (this.f9338a == 3) {
            AppToastUtils.showLongPositiveTipToast(this.f9339b, R.string.has_delete);
            if (this.f9340c && !((Activity) this.f9339b).isFinishing()) {
                ((Activity) this.f9339b).finish();
            }
        }
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_INBOX);
    }
}
