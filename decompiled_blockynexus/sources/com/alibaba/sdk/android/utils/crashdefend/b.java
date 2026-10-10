package com.alibaba.sdk.android.utils.crashdefend;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: CrashDefendManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f3948b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.utils.c f85a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private c f87a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private ExecutorService f90b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.utils.crashdefend.a f86a = new com.alibaba.sdk.android.utils.crashdefend.a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final List<c> f88a = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f3950e = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int[] f89a = new int[5];

    /* JADX INFO: compiled from: CrashDefendManager.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f3951a;

        a(d dVar) {
            this.f3951a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            do {
                try {
                    Thread.sleep(1000L);
                    d dVar = this.f3951a;
                    dVar.f3958d--;
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    Log.d("UtilsSDK", e2.getMessage(), e2);
                }
            } while (this.f3951a.f3958d > 0);
            if (this.f3951a.f3958d <= 0) {
                b.this.b(this.f3951a.f3957b);
                e.a(b.this.f3949a, b.this.f86a, (List<c>) b.this.f88a);
                return;
            }
            return;
        }
    }

    private b(Context context, com.alibaba.sdk.android.utils.c cVar) {
        this.f90b = null;
        this.f3949a = context;
        this.f85a = cVar;
        this.f90b = new f().a();
        for (int i = 0; i < 5; i++) {
            this.f89a[i] = (i * 5) + 5;
        }
        this.f3950e.put("sdkId", "utils");
        this.f3950e.put("sdkVersion", "1.1.4");
        try {
            a();
            b();
        } catch (Exception e2) {
            Log.d("UtilsSDK", e2.getMessage(), e2);
        }
    }

    private void b() {
        this.f87a = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f88a) {
            for (c cVar : this.f88a) {
                if (cVar.crashCount >= cVar.f3953a) {
                    arrayList.add(cVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c cVar2 = (c) it.next();
                if (cVar2.f3955c < 5) {
                    if (cVar2.f91a < this.f86a.f3947a - ((long) this.f89a[cVar2.f3955c])) {
                        this.f87a = cVar2;
                        break;
                    }
                } else {
                    Log.i("UtilsSDK", "SDK " + cVar2.f93a + " has been closed");
                }
            }
            if (this.f87a == null) {
                Log.i("UtilsSDK", "NO SDK restore");
            } else {
                this.f87a.f3955c++;
                Log.i("UtilsSDK", this.f87a.f93a + " will restore --- startSerialNumber:" + this.f87a.f91a + "   crashCount:" + this.f87a.crashCount);
            }
        }
    }

    public void d(String str, String str2) {
    }

    public static synchronized b a(Context context, com.alibaba.sdk.android.utils.c cVar) {
        if (f3948b == null) {
            f3948b = new b(context, cVar);
        }
        return f3948b;
    }

    private void a() {
        if (e.m37a(this.f3949a, this.f86a, this.f88a)) {
            this.f86a.f3947a++;
        } else {
            this.f86a.f3947a = 1L;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m35a(c cVar, SDKMessageCallback sDKMessageCallback) {
        c cVarA;
        if (cVar != null && sDKMessageCallback != null) {
            try {
                if (TextUtils.isEmpty(cVar.f95b) || TextUtils.isEmpty(cVar.f93a) || (cVarA = a(cVar, sDKMessageCallback)) == null) {
                    return false;
                }
                boolean zM34a = m34a(cVarA);
                if (cVarA.crashCount == cVarA.f3953a) {
                    a(cVarA.f93a, cVarA.f95b, cVarA.crashCount, cVarA.f3953a);
                }
                cVarA.crashCount++;
                e.a(this.f3949a, this.f86a, this.f88a);
                if (zM34a) {
                    a(cVarA);
                    Log.i("UtilsSDK", "START:" + cVarA.f93a + " --- limit:" + cVarA.f3953a + "  count:" + (cVarA.crashCount - 1) + "  restore:" + cVarA.f3955c + "  startSerialNumber:" + cVarA.f91a + "  registerSerialNumber:" + cVarA.f94b);
                } else {
                    sDKMessageCallback.crashDefendMessage(cVarA.f3953a, cVarA.crashCount - 1);
                    Log.i("UtilsSDK", "STOP:" + cVarA.f93a + " --- limit:" + cVarA.f3953a + "  count:" + (cVarA.crashCount - 1) + "  restore:" + cVarA.f3955c + "  startSerialNumber:" + cVarA.f91a + "  registerSerialNumber:" + cVarA.f94b);
                }
                return true;
            } catch (Exception e2) {
                Log.d("UtilsSDK", e2.getMessage(), e2);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        int i = cVar.f3955c;
        if (i > 0) {
            b(cVar.f93a, cVar.f95b, i, 5);
        }
        cVar.crashCount = 0;
        cVar.f3955c = 0;
    }

    private void b(String str, String str2, int i, int i2) {
        if (this.f85a == null) {
            return;
        }
        HashMap map = new HashMap();
        map.putAll(this.f3950e);
        map.put("crashSdkId", str);
        map.put("crashSdkVer", str2);
        map.put("recoverCount", String.valueOf(i));
        map.put("recoverThreshold", String.valueOf(i2));
        this.f85a.sendCustomHit("utils_biz_recover", 0L, map);
    }

    private c a(c cVar, SDKMessageCallback sDKMessageCallback) {
        synchronized (this.f88a) {
            c cVar2 = null;
            if (this.f88a != null && this.f88a.size() > 0) {
                Iterator<c> it = this.f88a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next != null && next.f93a.equals(cVar.f93a)) {
                        if (!next.f95b.equals(cVar.f95b)) {
                            next.f95b = cVar.f95b;
                            next.f3953a = cVar.f3953a;
                            next.f3954b = cVar.f3954b;
                            next.crashCount = 0;
                            next.f3955c = 0;
                        }
                        if (next.f3956d) {
                            Log.i("UtilsSDK", "SDK " + cVar.f93a + " has been registered");
                            return null;
                        }
                        next.f3956d = true;
                        next.f92a = sDKMessageCallback;
                        next.f94b = this.f86a.f3947a;
                        cVar2 = next;
                    }
                }
            }
            if (cVar2 == null) {
                cVar2 = (c) cVar.clone();
                cVar2.f3956d = true;
                cVar2.f92a = sDKMessageCallback;
                cVar2.crashCount = 0;
                cVar2.f94b = this.f86a.f3947a;
                this.f88a.add(cVar2);
            }
            return cVar2;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m34a(c cVar) {
        if (cVar.crashCount < cVar.f3953a) {
            cVar.f91a = cVar.f94b;
            return true;
        }
        c cVar2 = this.f87a;
        if (cVar2 == null || !cVar2.f93a.equals(cVar.f93a)) {
            return false;
        }
        cVar.crashCount = cVar.f3953a - 1;
        cVar.f91a = cVar.f94b;
        return true;
    }

    private void a(c cVar) {
        if (cVar == null) {
            return;
        }
        d dVar = new d();
        dVar.f3957b = cVar;
        dVar.f3958d = cVar.f3954b;
        a(dVar);
        SDKMessageCallback sDKMessageCallback = cVar.f92a;
        if (sDKMessageCallback != null) {
            sDKMessageCallback.crashDefendMessage(cVar.f3953a, cVar.crashCount - 1);
        }
    }

    private void a(d dVar) {
        if (dVar == null || dVar.f3957b == null) {
            return;
        }
        this.f90b.execute(new a(dVar));
    }

    private void a(String str, String str2, int i, int i2) {
        if (this.f85a == null) {
            return;
        }
        HashMap map = new HashMap();
        map.putAll(this.f3950e);
        map.put("crashSdkId", str);
        map.put("crashSdkVer", str2);
        map.put("curCrashCount", String.valueOf(i));
        map.put("crashThreshold", String.valueOf(i2));
        this.f85a.sendCustomHit("utils_biz_crash", 0L, map);
    }
}
