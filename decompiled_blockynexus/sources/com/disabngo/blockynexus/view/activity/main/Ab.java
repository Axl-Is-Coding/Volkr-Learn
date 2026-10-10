package com.disabngo.blockynexus.view.activity.main;

import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.AppToastUtils;
import java.util.TimerTask;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Ab extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bc f10745a;

    Ab(bc bcVar) {
        this.f10745a = bcVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        AppToastUtils.showLongNegativeTipToast(BaseApplication.getContext(), R.string.party_version_different);
    }
}
