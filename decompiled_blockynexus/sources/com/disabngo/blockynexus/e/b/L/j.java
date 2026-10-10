package com.disabngo.blockynexus.e.b.L;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.MailBoxApi;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: InboxModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    public void a(Context context, int i, Long[] lArr, boolean z) {
        MailBoxApi.mailOperation(context, i, lArr, new g(this, i, context, z));
    }

    public void b(Context context) {
        MailBoxApi.hasNewEmail(context, new h(this));
    }

    public void a(Context context, long j, OnResponseListener<String> onResponseListener) {
        MailBoxApi.getAttachment(context, j, onResponseListener);
    }

    public void a(Context context) {
        AppToastUtils.showShortNegativeTipToast(context, R.string.email_is_delete);
        MailBoxApi.mailList(context, new i(this, context));
    }
}
