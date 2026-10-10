package com.bytedance.sdk.adnet.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.adnet.b.c;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.face.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f5375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f5376d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f5374b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, C0069b> f5373a = Collections.synchronizedMap(new LinkedHashMap());

    /* JADX INFO: compiled from: FileLoader.java */
    public interface a extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, l lVar) {
        this.f5376d = context;
        this.f5375c = lVar;
    }

    private C0069b b(String str, a aVar, boolean z) {
        File fileB = aVar != null ? aVar.b(str) : null;
        return new C0069b(str, fileB == null ? new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath() : fileB.getAbsolutePath(), aVar, z);
    }

    public void a(String str, a aVar) {
        a(str, aVar, true);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.adnet.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FileLoader.java */
    class C0069b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f5380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f5381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<a> f5382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f5383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c f5384e;

        C0069b(String str, String str2, a aVar, boolean z) {
            this.f5380a = str;
            this.f5381b = str2;
            this.f5383d = z;
            a(aVar);
        }

        void a(a aVar) {
            if (aVar == null) {
                return;
            }
            if (this.f5382c == null) {
                this.f5382c = Collections.synchronizedList(new ArrayList());
            }
            this.f5382c.add(aVar);
        }

        public boolean equals(Object obj) {
            return obj instanceof C0069b ? ((C0069b) obj).f5380a.equals(this.f5380a) : super.equals(obj);
        }

        void a() {
            this.f5384e = new c(this.f5381b, this.f5380a, new c.a() { // from class: com.bytedance.sdk.adnet.b.b.b.1
                @Override // com.bytedance.sdk.adnet.b.c.a
                public void a(long j, long j2) {
                    List<a> list = C0069b.this.f5382c;
                    if (list != null) {
                        Iterator<a> it = list.iterator();
                        while (it.hasNext()) {
                            try {
                                it.next().a(j, j2);
                            } catch (Throwable th) {
                                o.a(th, "file loader onDownloadProgress error", new Object[0]);
                            }
                        }
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<File> mVar) {
                    List<a> list = C0069b.this.f5382c;
                    if (list != null) {
                        Iterator<a> it = list.iterator();
                        while (it.hasNext()) {
                            try {
                                it.next().b(mVar);
                            } catch (Throwable th) {
                                o.a(th, "file loader onErrorResponse error", new Object[0]);
                            }
                        }
                        C0069b.this.f5382c.clear();
                    }
                    b.this.f5373a.remove(C0069b.this.f5380a);
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(m<File> mVar) {
                    List<a> list = C0069b.this.f5382c;
                    if (list != null) {
                        for (a aVar : list) {
                            try {
                                aVar.a(mVar);
                            } catch (Throwable th) {
                                o.a(th, "file loader onResponse error", new Object[0]);
                            }
                            try {
                                aVar.a(C0069b.this.f5380a, mVar.f5538a);
                            } catch (Throwable th2) {
                                o.a(th2, "file loader putFile error", new Object[0]);
                            }
                        }
                        C0069b.this.f5382c.clear();
                    }
                    b.this.f5373a.remove(C0069b.this.f5380a);
                }
            });
            this.f5384e.setTag("FileLoader#" + this.f5380a);
            b.this.f5375c.a(this.f5384e);
        }
    }

    public void a(String str, final a aVar, boolean z) {
        C0069b c0069b;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (a(str) && (c0069b = this.f5373a.get(str)) != null) {
            c0069b.a(aVar);
            return;
        }
        final File fileA = aVar.a(str);
        if (fileA != null && aVar != null) {
            this.f5374b.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(fileA.length(), fileA.length());
                    aVar.a(m.a(fileA, (a.C0073a) null));
                }
            });
        } else {
            a(b(str, aVar, z));
        }
    }

    private void a(C0069b c0069b) {
        if (c0069b == null) {
            return;
        }
        c0069b.a();
        this.f5373a.put(c0069b.f5380a, c0069b);
    }

    private boolean a(String str) {
        return this.f5373a.containsKey(str);
    }

    private String a() {
        File file = new File(com.bytedance.sdk.adnet.a.b(this.f5376d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }
}
