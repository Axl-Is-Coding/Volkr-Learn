package com.bytedance.sdk.openadsdk.core.video.c;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ae;
import com.bytedance.sdk.openadsdk.utils.i;
import com.bytedance.sdk.openadsdk.utils.p;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayableCache.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<h, b> f6425c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, JSONObject> f6426d = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f6427e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Set<String> f6428f = Collections.synchronizedSet(new HashSet());
    private Handler g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PlayableCache.java */
    public interface InterfaceC0081a {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: PlayableCache.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f6442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f6443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f6444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f6445d;

        private b() {
        }

        public long a() {
            return this.f6443b - this.f6442a;
        }

        public long b() {
            return this.f6445d - this.f6444c;
        }

        public b c(long j) {
            this.f6444c = j;
            return this;
        }

        public b d(long j) {
            this.f6445d = j;
            return this;
        }

        public b a(long j) {
            this.f6442a = j;
            return this;
        }

        public b b(long j) {
            this.f6443b = j;
            return this;
        }
    }

    private a() {
    }

    private boolean c(File file) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return false;
        }
        return Arrays.asList(list).contains("index.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        if (TextUtils.isEmpty(this.f6424b)) {
            try {
                File file = new File(o.a().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.f6424b = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.e("PlayableCache", "init root path error: " + th);
            }
        }
        return this.f6424b;
    }

    public void b() {
        if (this.f6427e.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.i.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles;
                try {
                    String strC = a.this.c();
                    if (!TextUtils.isEmpty(strC)) {
                        File file = new File(strC);
                        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                            for (File file2 : fileArrListFiles) {
                                try {
                                    a.this.a(new File(file2, "tt_open_ad_sdk_check_res.dat"), true);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
                a.this.f6427e.set(true);
            }
        }, 5);
    }

    private void b(File file) {
        try {
            if (file.exists()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (file.setLastModified(jCurrentTimeMillis)) {
                    return;
                }
                file.renameTo(file);
                if (file.lastModified() < jCurrentTimeMillis) {
                    com.bytedance.sdk.openadsdk.utils.o.d("PlayableCache", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static a a() {
        if (f6423a == null) {
            synchronized (a.class) {
                if (f6423a == null) {
                    f6423a = new a();
                }
            }
        }
        return f6423a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        File file = new File(d(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public boolean a(h hVar) {
        if (this.f6427e.get() && hVar != null && hVar.v() != null && hVar.v().j() != null) {
            try {
                String strA = com.bytedance.sdk.openadsdk.utils.h.a(hVar.v().j());
                if (this.f6426d.get(strA) == null) {
                    return false;
                }
                return c(new File(c(), strA));
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(File file, boolean z) {
        byte[] bArrD;
        if (file == null) {
            return null;
        }
        try {
            if (!file.exists() || !file.isFile() || !file.canRead() || (bArrD = i.d(file)) == null || bArrD.length <= 0) {
                return null;
            }
            String strB = com.bytedance.sdk.openadsdk.core.a.b(new String(bArrD), com.bytedance.sdk.openadsdk.core.b.c());
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strB);
            if (z && jSONObject.length() > 0) {
                this.f6426d.put(file.getParentFile().getName(), jSONObject);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public WebResourceResponse a(String str, String str2, String str3) {
        try {
            if (!this.f6427e.get() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                if (str3.startsWith("http") && str3.contains("?")) {
                    str3 = str3.split("\\?")[0];
                    if (str3.endsWith("/")) {
                        str3 = str3.substring(0, str3.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
            String strA = p.a(o.a(), str3);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            String strA2 = com.bytedance.sdk.openadsdk.utils.h.a(str);
            if (TextUtils.isEmpty(strA2)) {
                return null;
            }
            File file = new File(c(), strA2);
            if (c(file)) {
                String strA3 = a(str2);
                if (TextUtils.isEmpty(strA3)) {
                    return null;
                }
                String strReplace = str3.replace(strA3, "");
                if (TextUtils.isEmpty(strReplace)) {
                    return null;
                }
                File file2 = new File(file, strReplace);
                if (a(strA2, strReplace, file2)) {
                    return new WebResourceResponse(strA, "utf-8", new FileInputStream(file2));
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.c("PlayableCache", "playable intercept error: ", th);
        }
        return null;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("\\?");
        if (strArrSplit != null && strArrSplit.length == 2) {
            if (strArrSplit[0] != null && strArrSplit[0].endsWith("/")) {
                str = str.substring(0, strArrSplit.length - 1);
            }
            if (strArrSplit[0] != null && strArrSplit[0].endsWith("index.html")) {
                str = strArrSplit[0];
            }
        }
        return str.replace("index.html", "");
    }

    private boolean a(String str, String str2, File file) {
        JSONObject jSONObject;
        String strOptString;
        return (file == null || !file.exists() || (jSONObject = this.f6426d.get(str)) == null || (strOptString = jSONObject.optString(str2)) == null || !strOptString.equalsIgnoreCase(com.bytedance.sdk.openadsdk.utils.h.a(file))) ? false : true;
    }

    public void a(final h hVar, final InterfaceC0081a interfaceC0081a) {
        if (hVar != null && hVar.v() != null && !TextUtils.isEmpty(hVar.v().j())) {
            final String strJ = hVar.v().j();
            if (this.f6428f.contains(strJ)) {
                return;
            }
            this.f6425c.put(hVar, new b().a(System.currentTimeMillis()));
            com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar);
            final String strA = com.bytedance.sdk.openadsdk.utils.h.a(strJ);
            final File file = new File(c(), strA);
            if (c(file)) {
                com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, -702, (String) null);
                b(file);
                this.f6425c.remove(hVar);
                a(interfaceC0081a, true);
                return;
            }
            try {
                i.c(file);
            } catch (Throwable unused) {
            }
            this.f6428f.add(strJ);
            d.a(o.a()).a(strJ, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.2
                @Override // com.bytedance.sdk.adnet.b.b.a
                public File a(String str) {
                    return null;
                }

                @Override // com.bytedance.sdk.adnet.b.c.a
                public void a(long j, long j2) {
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(final m<File> mVar) {
                    a.this.f6428f.remove(strJ);
                    final b bVar = (b) a.this.f6425c.remove(hVar);
                    if (bVar != null) {
                        bVar.b(System.currentTimeMillis());
                    }
                    if (mVar != null && mVar.f5538a != null) {
                        com.bytedance.sdk.openadsdk.i.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.2.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                long jB;
                                long j;
                                boolean z = true;
                                try {
                                    if (bVar != null) {
                                        bVar.c(System.currentTimeMillis());
                                    }
                                    ae.a(((File) mVar.f5538a).getAbsolutePath(), a.this.c());
                                    if (bVar != null) {
                                        bVar.d(System.currentTimeMillis());
                                    }
                                    if (bVar != null) {
                                        long jA = bVar.a();
                                        jB = bVar.b();
                                        j = jA;
                                    } else {
                                        jB = 0;
                                        j = 0;
                                    }
                                    com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, j, jB);
                                    a.this.a(file);
                                    try {
                                        a.this.a(new File(file, "tt_open_ad_sdk_check_res.dat"), true);
                                    } catch (Throwable unused2) {
                                    }
                                } catch (Throwable th) {
                                    com.bytedance.sdk.openadsdk.utils.o.c("PlayableCache", "unzip error: ", th);
                                    com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, -704, th.getMessage());
                                    z = false;
                                }
                                try {
                                    ((File) mVar.f5538a).delete();
                                } catch (Throwable unused3) {
                                }
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                a.this.a(interfaceC0081a, z);
                            }
                        }, 5);
                        return;
                    }
                    int iIntValue = -700;
                    if (mVar != null) {
                        long j = mVar.h;
                        if (j != 0) {
                            iIntValue = Long.valueOf(j).intValue();
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, iIntValue, (String) null);
                    a.this.a(interfaceC0081a, false);
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public void a(String str, File file2) {
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public File b(String str) {
                    return new File(a.this.d(), strA + ".zip");
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<File> mVar) {
                    com.bytedance.sdk.adnet.core.i iVar;
                    int i;
                    a.this.f6428f.remove(strJ);
                    a.this.f6425c.remove(hVar);
                    int iIntValue = -700;
                    String message = null;
                    if (mVar != null) {
                        long j = mVar.h;
                        if (j != 0) {
                            iIntValue = Long.valueOf(j).intValue();
                        } else {
                            VAdError vAdError = mVar.f5540c;
                            if (vAdError != null && (iVar = vAdError.networkResponse) != null && (i = iVar.f5524a) != 0) {
                                iIntValue = i;
                            }
                        }
                        VAdError vAdError2 = mVar.f5540c;
                        if (vAdError2 != null) {
                            message = vAdError2.getMessage();
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, iIntValue, message);
                    a.this.a(interfaceC0081a, false);
                }
            });
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, -701, (String) null);
        a(interfaceC0081a, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final InterfaceC0081a interfaceC0081a, final boolean z) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (interfaceC0081a != null) {
                interfaceC0081a.a(z);
            }
        } else if (interfaceC0081a != null) {
            this.g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.3
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0081a interfaceC0081a2 = interfaceC0081a;
                    if (interfaceC0081a2 != null) {
                        interfaceC0081a2.a(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        b(file);
        try {
            com.bytedance.sdk.openadsdk.core.h.b().o().a(file);
        } catch (Throwable unused) {
        }
    }
}
