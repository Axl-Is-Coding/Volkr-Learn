package com.disabngo.blockynexus.e.a.a;

import android.app.Activity;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.tencent.map.geolocation.TencentLocation;

/* JADX INFO: compiled from: StartGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f9083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TencentLocation f9084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnDataListener f9085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ l f9086d;

    k(l lVar, Activity activity, TencentLocation tencentLocation, OnDataListener onDataListener) {
        this.f9086d = lVar;
        this.f9083a = activity;
        this.f9084b = tencentLocation;
        this.f9085c = onDataListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9083a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        SharedUtils.putString(this.f9083a, SharedConstant.FRIEND_MATCH_LONGITUDE, String.valueOf(this.f9084b.getLongitude()));
        SharedUtils.putString(this.f9083a, SharedConstant.FRIEND_MATCH_LATITUDE, String.valueOf(this.f9084b.getLatitude()));
        OnDataListener onDataListener = this.f9085c;
        if (onDataListener != null) {
            onDataListener.onSuccess(this.f9084b);
        }
    }
}
