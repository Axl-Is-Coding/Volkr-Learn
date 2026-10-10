package com.sandboxol.tencentmaputils;

import android.content.Context;
import android.util.Log;
import com.sandboxol.common.interfaces.OnDataListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;

/* JADX INFO: compiled from: TencentMapUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static void a(Context context, OnDataListener<TencentLocation> onDataListener) {
        try {
            com.getkeepsafe.relinker.b.a(context, "tencentloc");
        } catch (Exception unused) {
            Log.i("tencentLocation------", "System.loadLibrary() failed");
        }
        TencentLocationManager tencentLocationManager = TencentLocationManager.getInstance(context);
        tencentLocationManager.setCoordinateType(1);
        TencentLocationRequest tencentLocationRequestCreate = TencentLocationRequest.create();
        tencentLocationRequestCreate.setInterval(5000L);
        tencentLocationRequestCreate.setAllowCache(true);
        tencentLocationRequestCreate.setRequestLevel(3);
        Log.i("tencentLocation---", String.valueOf(tencentLocationManager.requestLocationUpdates(tencentLocationRequestCreate, new b(onDataListener, tencentLocationManager))));
    }
}
