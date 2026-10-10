package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.SystemAnnouncementInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Wb extends OnResponseListener<SystemAnnouncementInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10856b;

    Wb(bc bcVar, Context context) {
        this.f10856b = bcVar;
        this.f10855a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(SystemAnnouncementInfo systemAnnouncementInfo) {
        if (systemAnnouncementInfo == null) {
            AppInfoCenter.newInstance().setStopServiceAnnouncementInfo(new SystemAnnouncementInfo());
        } else {
            AppInfoCenter.newInstance().setStopServiceAnnouncementInfo(systemAnnouncementInfo);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10855a, i);
    }
}
