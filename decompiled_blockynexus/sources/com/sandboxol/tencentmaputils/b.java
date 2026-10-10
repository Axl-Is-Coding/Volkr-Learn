package com.sandboxol.tencentmaputils;

import android.util.Log;
import com.sandboxol.common.interfaces.OnDataListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;

/* JADX INFO: compiled from: TencentMapUtils.java */
/* JADX INFO: loaded from: classes4.dex */
class b implements TencentLocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnDataListener f18912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TencentLocationManager f18913b;

    b(OnDataListener onDataListener, TencentLocationManager tencentLocationManager) {
        this.f18912a = onDataListener;
        this.f18913b = tencentLocationManager;
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        if (i != 0) {
            Log.i("tencentLocation------", String.valueOf(i));
            return;
        }
        Log.i("tencentLocation------", "success");
        this.f18912a.onSuccess(tencentLocation);
        this.f18913b.removeUpdates(this);
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public void onStatusUpdate(String str, int i, String str2) {
    }
}
