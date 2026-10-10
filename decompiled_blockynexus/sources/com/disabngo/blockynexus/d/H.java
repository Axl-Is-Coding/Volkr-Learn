package com.disabngo.blockynexus.d;

import android.util.Log;
import com.sandboxol.center.entity.ResCheckEntity;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: ResCheck.java */
/* JADX INFO: loaded from: classes2.dex */
class H extends OnResponseListener<ResCheckEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f7190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ I f7191b;

    H(I i, int i2) {
        this.f7191b = i;
        this.f7190a = i2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ResCheckEntity resCheckEntity) {
        Log.e(this.f7191b.f7192a, new com.google.gson.j().a(resCheckEntity));
        this.f7191b.f7197f = 0;
        if (this.f7191b.f7196e != null) {
            this.f7191b.f7196e.a(resCheckEntity.isUpdate(), resCheckEntity.getUrl(), resCheckEntity.getMd5());
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        Log.e(this.f7191b.f7192a, "code  " + i + "  msg " + str);
        this.f7191b.a(this.f7190a);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.e(this.f7191b.f7192a, "code  " + i);
        this.f7191b.a(this.f7190a);
    }
}
