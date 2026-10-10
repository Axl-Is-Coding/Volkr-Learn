package com.disabngo.blockynexus.e.b.L;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.MailInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: InboxModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener<List<MailInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f9344b;

    i(j jVar, Context context) {
        this.f9344b = jVar;
        this.f9343a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<MailInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (MailInfo mailInfo : list) {
            if (mailInfo.getStatus() == 2) {
                arrayList.add(Long.valueOf(mailInfo.getId()));
            }
        }
        if (arrayList.size() != 0) {
            this.f9344b.a(this.f9343a, 3, (Long[]) arrayList.toArray(new Long[arrayList.size()]), false);
        } else {
            AppToastUtils.showShortNegativeTipToast(this.f9343a, R.string.email_no_more_delete_email);
        }
    }
}
