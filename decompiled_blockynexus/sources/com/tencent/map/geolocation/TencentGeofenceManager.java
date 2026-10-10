package com.tencent.map.geolocation;

import android.app.PendingIntent;
import android.content.Context;
import android.text.TextUtils;
import c.t.m.g.dn;
import c.t.m.g.du;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes5.dex */
public class TencentGeofenceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private du f19397a;

    public TencentGeofenceManager(Context context) {
        this.f19397a = new du(context);
    }

    public void addFence(TencentGeofence tencentGeofence, PendingIntent pendingIntent) {
        du duVar = this.f19397a;
        duVar.a();
        if (tencentGeofence == null || pendingIntent == null) {
            throw new NullPointerException();
        }
        StringBuilder sb = new StringBuilder("addFence: , geofence=");
        sb.append(tencentGeofence);
        sb.append(", intent=");
        sb.append(pendingIntent);
        dn dnVar = new dn(tencentGeofence, tencentGeofence.getExpireAt(), "packageName", pendingIntent);
        du.b bVar = duVar.g;
        List<dn> list = bVar.f3134a;
        synchronized (bVar) {
            int size = list.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                dn dnVar2 = list.get(size);
                if (tencentGeofence.equals(dnVar2.f3118a) && pendingIntent.equals(dnVar2.f3122e)) {
                    list.remove(size);
                    break;
                }
                size--;
            }
            list.add(dnVar);
            duVar.d();
        }
    }

    public void destroy() {
        du duVar = this.f19397a;
        if (duVar.h) {
            return;
        }
        duVar.b();
        duVar.f3127a.unregisterReceiver(duVar);
        synchronized (duVar.g) {
            Arrays.fill(duVar.g.f3139f, -1.0f);
            duVar.c();
        }
        duVar.i = false;
        duVar.h = true;
    }

    public void removeAllFences() {
        du duVar = this.f19397a;
        duVar.a();
        synchronized (duVar.g) {
            duVar.f3128b.b();
            duVar.c();
        }
    }

    public void removeFence(TencentGeofence tencentGeofence) {
        du duVar = this.f19397a;
        duVar.a();
        if (tencentGeofence != null) {
            synchronized (duVar.g) {
                Iterator<dn> it = duVar.g.f3134a.iterator();
                while (it.hasNext()) {
                    if (tencentGeofence.equals(it.next().f3118a)) {
                        it.remove();
                    }
                }
                duVar.d();
            }
        }
    }

    public void removeFence(String str) {
        du duVar = this.f19397a;
        duVar.a();
        synchronized (duVar.g) {
            Iterator<dn> it = duVar.g.f3134a.iterator();
            while (it.hasNext()) {
                TencentGeofence tencentGeofence = it.next().f3118a;
                if (tencentGeofence == null || TextUtils.equals(tencentGeofence.getTag(), str)) {
                    it.remove();
                }
            }
            StringBuilder sb = new StringBuilder("removeFence: ");
            sb.append(str);
            sb.append(" removed --> schedule update fence");
            duVar.d();
        }
    }
}
