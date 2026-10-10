package com.disabngo.blockynexus.e.a.a;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.interfaces.OnViewClickListener;
import com.disabngo.blockynexus.view.dialog.NoticeDialog;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.SystemAnnouncementInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: StartGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener<SystemAnnouncementInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnViewClickListener f9080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ l f9081c;

    i(l lVar, Context context, OnViewClickListener onViewClickListener) {
        this.f9081c = lVar;
        this.f9079a = context;
        this.f9080b = onViewClickListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(SystemAnnouncementInfo systemAnnouncementInfo) {
        AppInfoCenter.newInstance().setStopServiceAnnouncementInfo(systemAnnouncementInfo == null ? new SystemAnnouncementInfo() : systemAnnouncementInfo);
        if (systemAnnouncementInfo == null || !systemAnnouncementInfo.isIsShow()) {
            this.f9080b.onClick();
        } else {
            Context context = this.f9079a;
            new NoticeDialog(context, context.getString(R.string.stop_service_announcement), systemAnnouncementInfo).show();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9080b.onClick();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9080b.onClick();
        ServerOnError.showOnServerError(this.f9079a, i);
    }
}
