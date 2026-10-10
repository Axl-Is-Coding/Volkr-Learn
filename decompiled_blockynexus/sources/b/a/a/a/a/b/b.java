package b.a.a.a.a.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: AdvertisingIdHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f2457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2458b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExecutorService f2459c = Executors.newSingleThreadExecutor();

    /* JADX INFO: compiled from: AdvertisingIdHelper.java */
    private class a implements Callable<String> {
        private a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(o.a());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    com.bytedance.sdk.openadsdk.utils.o.b("gaid-", "getAdvertisingId: " + id);
                    b.b(id);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.c("AdvertisingIdHelper", "getAdvertisingIdInfo error", th);
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(o.a());
                if (advertisingIdInfo2 != null) {
                    b.this.f2458b = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.openadsdk.utils.o.c("AdvertisingIdHelper", "getAdvertisingIdInfo error", th2);
            }
            com.bytedance.sdk.openadsdk.utils.o.b("AdvertisingIdHelper", "mGAId:" + b.this.f2458b + " , get gaid consume time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return b.this.f2458b;
        }
    }

    private b() {
    }

    public String b() {
        try {
            this.f2458b = com.bytedance.sdk.openadsdk.multipro.d.a.b("name_gaid", "gaid", "");
            com.bytedance.sdk.openadsdk.utils.o.c("gaid-", "getGAIdTimeOut-mGAId=" + this.f2458b);
            if (TextUtils.isEmpty(this.f2458b)) {
                FutureTask futureTask = new FutureTask(new a());
                this.f2459c.execute(futureTask);
                this.f2458b = (String) futureTask.get(500000L, TimeUnit.MICROSECONDS);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdvertisingIdHelper", "getGAIdTimeOut error", th);
        }
        return this.f2458b;
    }

    public static b a() {
        if (f2457a == null) {
            synchronized (b.class) {
                if (f2457a == null) {
                    f2457a = new b();
                }
            }
        }
        return f2457a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.d.a.a("name_gaid", "gaid", str);
    }
}
