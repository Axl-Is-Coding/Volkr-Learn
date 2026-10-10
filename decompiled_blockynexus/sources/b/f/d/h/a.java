package b.f.d.h;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import com.ironsource.sdk.utils.f;
import com.ironsource.sdk.utils.i;
import com.sandboxol.center.web.http.HttpCode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: DownloadManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f2740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerC0044a f2741b = a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Thread f2742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2743d;

    /* JADX INFO: compiled from: DownloadManager.java */
    static class b implements Callable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2746b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f2747c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f2748d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f2749e;

        public b(String str, String str2, String str3, long j, String str4) {
            this.f2745a = str;
            this.f2746b = str2;
            this.f2747c = str3;
            this.f2748d = j;
            this.f2749e = str4;
        }

        int a(byte[] bArr, String str) throws Exception {
            return com.ironsource.sdk.utils.e.a(bArr, str);
        }

        boolean a(String str, String str2) throws Exception {
            return com.ironsource.sdk.utils.e.e(str, str2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public d call() {
            int i;
            if (this.f2748d == 0) {
                this.f2748d = 1L;
            }
            d dVarA = null;
            for (int i2 = 0; i2 < this.f2748d && ((i = (dVarA = a(this.f2745a, i2)).f2751b) == 1008 || i == 1009); i2++) {
            }
            if (dVarA != null && dVarA.f2752c != null) {
                String str = this.f2746b + File.separator + this.f2747c;
                String str2 = this.f2749e + File.separator + "tmp_" + this.f2747c;
                try {
                    if (a(dVarA.f2752c, str2) == 0) {
                        dVarA.f2751b = HttpCode.PASSWORD_NOT_SET;
                    } else if (!a(str2, str)) {
                        dVarA.f2751b = 1020;
                    }
                } catch (FileNotFoundException unused) {
                    dVarA.f2751b = 1018;
                } catch (Error e2) {
                    if (!TextUtils.isEmpty(e2.getMessage())) {
                        f.c("DownloadManager", e2.getMessage());
                    }
                    dVarA.f2751b = 1019;
                } catch (Exception e3) {
                    if (!TextUtils.isEmpty(e3.getMessage())) {
                        f.c("DownloadManager", e3.getMessage());
                    }
                    dVarA.f2751b = 1009;
                }
            }
            return dVarA;
        }

        byte[] a(InputStream inputStream) throws IOException {
            return a.a(inputStream);
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x0138 A[PHI: r4 r9
          0x0138: PHI (r4v13 java.net.HttpURLConnection) = 
          (r4v6 java.net.HttpURLConnection)
          (r4v7 java.net.HttpURLConnection)
          (r4v8 java.net.HttpURLConnection)
          (r4v9 java.net.HttpURLConnection)
          (r4v14 java.net.HttpURLConnection)
         binds: [B:58:0x00e1, B:95:0x0126, B:86:0x0116, B:104:0x0136, B:77:0x0106] A[DONT_GENERATE, DONT_INLINE]
          0x0138: PHI (r9v16 int) = (r9v6 int), (r9v8 int), (r9v9 int), (r9v10 int), (r9v18 int) binds: [B:58:0x00e1, B:95:0x0126, B:86:0x0116, B:104:0x0136, B:77:0x0106] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:121:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00f1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        b.f.d.h.a.d a(java.lang.String r8, int r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 320
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.d.h.a.b.a(java.lang.String, int):b.f.d.h.a$d");
        }
    }

    /* JADX INFO: compiled from: DownloadManager.java */
    public interface c {
        void onFileDownloadFail(com.ironsource.sdk.data.e eVar);

        void onFileDownloadSuccess(com.ironsource.sdk.data.e eVar);
    }

    /* JADX INFO: compiled from: DownloadManager.java */
    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        byte[] f2752c;

        d() {
        }
    }

    /* JADX INFO: compiled from: DownloadManager.java */
    static class e implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f2754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f2755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f2756d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f2757e;
        private String g;
        Handler h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f2753a = 3;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f2758f = 3;

        e(com.ironsource.sdk.data.e eVar, Handler handler, String str, String str2) {
            this.f2755c = eVar.c();
            this.f2756d = eVar.e();
            this.f2757e = a(this.f2755c);
            this.g = str;
            this.h = handler;
            this.f2754b = str2;
        }

        String a(String str) {
            return i.c(this.f2755c);
        }

        /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
            java.lang.UnsupportedOperationException
            	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
            	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
                r11 = this;
                com.ironsource.sdk.data.e r0 = new com.ironsource.sdk.data.e
                java.lang.String r1 = r11.f2757e
                java.lang.String r2 = r11.f2756d
                r0.<init>(r1, r2)
                android.os.Message r1 = r11.a()
                r1.obj = r0
                java.lang.String r2 = r11.g
                java.lang.String r3 = r11.f2756d
                java.lang.String r6 = r11.a(r2, r3)
                r2 = 1017(0x3f9, float:1.425E-42)
                if (r6 != 0) goto L28
                r1.what = r2
                java.lang.String r2 = "unable_to_create_folder"
                r0.f(r2)
                android.os.Handler r0 = r11.h
                r0.sendMessage(r1)
                goto L6c
            L28:
                java.lang.String r5 = r11.f2755c
                java.lang.String r7 = r0.c()
                long r8 = r11.f2758f
                java.lang.String r10 = r11.f2754b
                r4 = r11
                b.f.d.h.a$b r3 = r4.a(r5, r6, r7, r8, r10)
                b.f.d.h.a$d r3 = r3.call()
                int r3 = r3.f2751b
                r4 = 200(0xc8, float:2.8E-43)
                if (r3 == r4) goto L63
                r4 = 404(0x194, float:5.66E-43)
                if (r3 == r4) goto L54
                r4 = 1018(0x3fa, float:1.427E-42)
                if (r3 == r4) goto L54
                r4 = 1019(0x3fb, float:1.428E-42)
                if (r3 == r4) goto L54
                switch(r3) {
                    case 1004: goto L54;
                    case 1005: goto L54;
                    case 1006: goto L54;
                    default: goto L50;
                }
            L50:
                switch(r3) {
                    case 1008: goto L54;
                    case 1009: goto L54;
                    case 1010: goto L54;
                    case 1011: goto L54;
                    default: goto L53;
                }
            L53:
                goto L6c
            L54:
                java.lang.String r3 = r11.a(r3)
                r1.what = r2
                r0.f(r3)
                android.os.Handler r0 = r11.h
                r0.sendMessage(r1)
                goto L6c
            L63:
                r0 = 1016(0x3f8, float:1.424E-42)
                r1.what = r0
                android.os.Handler r0 = r11.h
                r0.sendMessage(r1)
            L6c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.d.h.a.e.run():void");
        }

        b a(String str, String str2, String str3, long j, String str4) {
            return new b(str, str2, str3, j, str4);
        }

        Message a() {
            return new Message();
        }

        String a(String str, String str2) {
            return com.ironsource.sdk.utils.e.d(str, str2);
        }

        String a(int i) {
            String str = "not defined message for " + i;
            if (i != 404) {
                if (i == 1018) {
                    return "file not found exception";
                }
                if (i == 1019) {
                    return "out of memory exception";
                }
                switch (i) {
                    case 1004:
                        return "malformed url exception";
                    case 1005:
                        break;
                    case HttpCode.PASSWORD_NOT_SET /* 1006 */:
                        return "http empty response";
                    default:
                        switch (i) {
                            case 1008:
                                return "socket timeout exception";
                            case 1009:
                                return "io exception";
                            case 1010:
                                return "uri syntax exception";
                            case HybridPlusWebView.LOAD_BEGIN /* 1011 */:
                                return "http error code";
                            default:
                                return str;
                        }
                }
            }
            return "http not found";
        }
    }

    private a(String str) {
        this.f2743d = str;
        com.ironsource.sdk.utils.e.a(this.f2743d, "temp");
        com.ironsource.sdk.utils.e.d(this.f2743d, "temp");
    }

    public static synchronized a a(String str) {
        if (f2740a == null) {
            f2740a = new a(str);
        }
        return f2740a;
    }

    public void b(com.ironsource.sdk.data.e eVar) {
        this.f2742c = new Thread(new e(eVar, this.f2741b, this.f2743d, b()));
        this.f2742c.start();
    }

    public boolean c() {
        Thread thread = this.f2742c;
        return thread != null && thread.isAlive();
    }

    public synchronized void d() {
        f2740a = null;
        if (this.f2741b != null) {
            this.f2741b.a();
            this.f2741b = null;
        }
    }

    /* JADX INFO: renamed from: b.f.d.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadManager.java */
    static class HandlerC0044a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c f2744a;

        HandlerC0044a() {
        }

        void a(c cVar) {
            if (cVar == null) {
                throw new IllegalArgumentException();
            }
            this.f2744a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = this.f2744a;
            if (cVar == null) {
                f.c("DownloadManager", "OnPreCacheCompletion listener is null, msg: " + message.toString());
                return;
            }
            try {
                int i = message.what;
                if (i == 1016) {
                    cVar.onFileDownloadSuccess((com.ironsource.sdk.data.e) message.obj);
                } else if (i == 1017) {
                    cVar.onFileDownloadFail((com.ironsource.sdk.data.e) message.obj);
                }
            } catch (Throwable th) {
                f.c("DownloadManager", "handleMessage | Got exception: " + th.getMessage());
                th.printStackTrace();
            }
        }

        public void a() {
            this.f2744a = null;
        }
    }

    HandlerC0044a a() {
        return new HandlerC0044a();
    }

    String b() {
        return this.f2743d + File.separator + "temp";
    }

    public void a(c cVar) {
        this.f2741b.a(cVar);
    }

    public void a(com.ironsource.sdk.data.e eVar) {
        new Thread(new e(eVar, this.f2741b, this.f2743d, b())).start();
    }

    static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr, 0, bArr.length);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
