package com.disabngo.blockynexus.view.activity.videodetail;

import android.content.Context;
import com.disabngo.blockynexus.web.error.VideoOnError;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.greendao.c.Aa;
import com.sandboxol.greendao.entity.VideoDetailInfo;

/* JADX INFO: compiled from: VideoDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
class q extends OnResponseListener<VideoDetailInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LoadingDialog f11214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnDataListener f11215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f11216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ t f11217d;

    q(t tVar, LoadingDialog loadingDialog, OnDataListener onDataListener, Context context) {
        this.f11217d = tVar;
        this.f11214a = loadingDialog;
        this.f11215b = onDataListener;
        this.f11216c = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VideoDetailInfo videoDetailInfo) {
        if (this.f11214a.isShowing()) {
            this.f11214a.dismiss();
        }
        Aa.newInstance().a(videoDetailInfo);
        this.f11215b.onSuccess(videoDetailInfo);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (this.f11214a.isShowing()) {
            this.f11214a.dismiss();
        }
        VideoOnError.showErrorTip(this.f11216c, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (this.f11214a.isShowing()) {
            this.f11214a.dismiss();
        }
        VideoOnError.showOnServerError(this.f11216c, i);
    }
}
