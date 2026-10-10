package com.disabngo.blockynexus.view.activity.videodetail;

import android.content.Context;
import com.disabngo.blockynexus.web.error.VideoOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.greendao.c.Aa;
import com.sandboxol.greendao.entity.VideoDetailInfo;

/* JADX INFO: compiled from: VideoDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
class p extends OnResponseListener<VideoDetailInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnDataListener f11211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f11212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f11213c;

    p(t tVar, OnDataListener onDataListener, Context context) {
        this.f11213c = tVar;
        this.f11211a = onDataListener;
        this.f11212b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VideoDetailInfo videoDetailInfo) {
        Aa.newInstance().a(videoDetailInfo);
        this.f11211a.onSuccess(videoDetailInfo);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        VideoOnError.showErrorTip(this.f11212b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        VideoOnError.showOnServerError(this.f11212b, i);
    }
}
