package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: ImageLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f5392b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f5394d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f5391a = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5393c = 50;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, a> f5395e = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, a> f5396f = Collections.synchronizedMap(new HashMap());
    private final Handler g = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: ImageLoader.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Request<?> f5416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private m<Bitmap> f5417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap f5418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private VAdError f5419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<c> f5420e = Collections.synchronizedList(new ArrayList());

        public a(Request<?> request, c cVar) {
            this.f5416a = request;
            this.f5420e.add(cVar);
        }

        public m<Bitmap> b() {
            return this.f5417b;
        }

        public void a(VAdError vAdError) {
            this.f5419d = vAdError;
        }

        public VAdError a() {
            return this.f5419d;
        }

        public void a(m<Bitmap> mVar) {
            this.f5417b = mVar;
        }

        public void a(c cVar) {
            this.f5420e.add(cVar);
        }
    }

    /* JADX INFO: compiled from: ImageLoader.java */
    public interface b {
        Bitmap a(String str);

        String a(String str, int i, int i2, ImageView.ScaleType scaleType);

        void a(String str, Bitmap bitmap);
    }

    /* JADX INFO: compiled from: ImageLoader.java */
    public class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bitmap f5422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final InterfaceC0070d f5423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f5424d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f5425e;

        public c(Bitmap bitmap, String str, String str2, InterfaceC0070d interfaceC0070d) {
            this.f5422b = bitmap;
            this.f5425e = str;
            this.f5424d = str2;
            this.f5423c = interfaceC0070d;
        }

        public Bitmap a() {
            return this.f5422b;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.adnet.b.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImageLoader.java */
    public interface InterfaceC0070d extends m.a<Bitmap> {
        void a();

        void a(c cVar, boolean z);

        void b();
    }

    public d(l lVar, b bVar) {
        this.f5392b = lVar;
        this.f5394d = bVar == null ? new com.bytedance.sdk.adnet.b.a() : bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, final InterfaceC0070d interfaceC0070d, int i, int i2, ImageView.ScaleType scaleType) {
        this.g.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                interfaceC0070d.a();
            }
        });
        String strA = a(str, i, i2, scaleType);
        Bitmap bitmapA = this.f5394d.a(strA);
        if (bitmapA != null) {
            final c cVar = new c(bitmapA, str, null, null);
            this.g.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.3
                @Override // java.lang.Runnable
                public void run() {
                    interfaceC0070d.a(cVar, true);
                    interfaceC0070d.b();
                }
            });
            return;
        }
        c cVar2 = new c(null, str, strA, interfaceC0070d);
        a aVar = this.f5395e.get(strA);
        if (aVar == null) {
            aVar = this.f5396f.get(strA);
        }
        if (aVar != null) {
            aVar.a(cVar2);
            return;
        }
        Request<Bitmap> requestA = a(str, i, i2, scaleType, strA);
        this.f5392b.a(requestA);
        this.f5395e.put(strA, new a(requestA, cVar2));
    }

    public void a(String str, InterfaceC0070d interfaceC0070d) {
        a(str, interfaceC0070d, 0, 0);
    }

    public void a(String str, InterfaceC0070d interfaceC0070d, int i, int i2) {
        a(str, interfaceC0070d, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void a(final String str, final InterfaceC0070d interfaceC0070d, final int i, final int i2, final ImageView.ScaleType scaleType) {
        this.f5391a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.b(str, interfaceC0070d, i, i2, scaleType);
            }
        });
    }

    protected Request<Bitmap> a(String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        return new e(str, new m.a<Bitmap>() { // from class: com.bytedance.sdk.adnet.b.d.4
            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(final m<Bitmap> mVar) {
                d.this.f5391a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        d.this.a(str2, mVar);
                    }
                });
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(final m<Bitmap> mVar) {
                d.this.f5391a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        d.this.b(str2, mVar);
                    }
                });
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565);
    }

    protected void a(String str, m<Bitmap> mVar) {
        this.f5394d.a(str, mVar.f5538a);
        a aVarRemove = this.f5395e.remove(str);
        if (aVarRemove != null) {
            aVarRemove.f5418c = mVar.f5538a;
            aVarRemove.a(mVar);
            a(str, aVarRemove);
        }
    }

    private void a(final String str, a aVar) {
        this.f5396f.put(str, aVar);
        this.g.postDelayed(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                a aVar2 = (a) d.this.f5396f.get(str);
                if (aVar2 != null) {
                    for (c cVar : aVar2.f5420e) {
                        if (cVar.f5423c != null) {
                            if (aVar2.a() == null) {
                                cVar.f5422b = aVar2.f5418c;
                                cVar.f5423c.a(cVar, false);
                            } else {
                                cVar.f5423c.b(aVar2.b());
                            }
                            cVar.f5423c.b();
                        }
                    }
                }
                d.this.f5396f.remove(str);
            }
        }, this.f5393c);
    }

    protected void b(String str, m<Bitmap> mVar) {
        a aVarRemove = this.f5395e.remove(str);
        if (aVarRemove != null) {
            aVarRemove.a(mVar.f5540c);
            aVarRemove.a(mVar);
            a(str, aVarRemove);
        }
    }

    private String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        String strA = this.f5394d.a(str, i, i2, scaleType);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(str);
        return sb.toString();
    }
}
