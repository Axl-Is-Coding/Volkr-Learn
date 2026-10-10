package com.bytedance.sdk.openadsdk.g.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.g.a.a;
import com.bytedance.sdk.openadsdk.g.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GifLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f6767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f6768b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, d> f6769c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: compiled from: GifLoader.java */
    public static class a implements InterfaceC0088b {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.g.a.b.InterfaceC0088b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.g.a.b.InterfaceC0088b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.g.a.b.InterfaceC0088b
        public void a(String str, byte[] bArr) {
        }

        @Override // com.bytedance.sdk.openadsdk.g.a.b.InterfaceC0088b
        public void b(c cVar) {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.g.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GifLoader.java */
    public interface InterfaceC0088b {
        void a();

        void a(c cVar);

        void a(String str, byte[] bArr);

        void b(c cVar);
    }

    /* JADX INFO: compiled from: GifLoader.java */
    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.g.a.c f6791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        m f6792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<InterfaceC0088b> f6793c = Collections.synchronizedList(new ArrayList());

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        VAdError f6794d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        byte[] f6795e;

        public d(com.bytedance.sdk.openadsdk.g.a.c cVar, InterfaceC0088b interfaceC0088b) {
            this.f6791a = cVar;
            a(interfaceC0088b);
        }

        void a(InterfaceC0088b interfaceC0088b) {
            if (interfaceC0088b != null) {
                this.f6793c.add(interfaceC0088b);
            }
        }

        boolean a() {
            return this.f6794d == null && this.f6795e != null;
        }
    }

    public b(l lVar) {
        this.f6767a = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC0088b interfaceC0088b, int i, int i2, ImageView.ScaleType scaleType) {
        byte[] bArr;
        String strA = com.bytedance.sdk.openadsdk.g.a.a.a().a(str, i, i2, scaleType);
        final a.C0087a c0087aB = com.bytedance.sdk.openadsdk.g.a.a.a().b(strA);
        if (c0087aB != null && (bArr = c0087aB.f6766a) != null) {
            final c cVar = new c(bArr, interfaceC0088b, strA, str);
            this.f6768b.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0088b interfaceC0088b2 = interfaceC0088b;
                    if (interfaceC0088b2 != null) {
                        interfaceC0088b2.a(str, c0087aB.f6766a);
                    }
                    InterfaceC0088b interfaceC0088b3 = interfaceC0088b;
                    if (interfaceC0088b3 != null) {
                        interfaceC0088b3.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.f6769c.get(strA);
        if (dVar != null) {
            dVar.a(interfaceC0088b);
            return;
        }
        com.bytedance.sdk.openadsdk.g.a.c cVarA = a(str, i, i2, scaleType, strA);
        d dVar2 = new d(cVarA, interfaceC0088b);
        this.f6767a.a(cVarA);
        this.f6769c.put(strA, dVar2);
    }

    public void a(String str, InterfaceC0088b interfaceC0088b, int i, int i2) {
        a(str, interfaceC0088b, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void a(final String str, final InterfaceC0088b interfaceC0088b, final int i, final int i2, final ImageView.ScaleType scaleType) {
        if (interfaceC0088b != null) {
            this.f6768b.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0088b interfaceC0088b2 = interfaceC0088b;
                    if (interfaceC0088b2 != null) {
                        interfaceC0088b2.a();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.i.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC0088b, i, i2, scaleType);
            }
        }, 5);
    }

    /* JADX INFO: compiled from: GifLoader.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f6786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0088b f6787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f6788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f6789d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final VAdError f6790e;

        public c(byte[] bArr, InterfaceC0088b interfaceC0088b, String str, String str2) {
            this.f6786a = bArr;
            this.f6787b = interfaceC0088b;
            this.f6788c = str;
            this.f6789d = str2;
            this.f6790e = null;
        }

        public c(VAdError vAdError, InterfaceC0088b interfaceC0088b, String str, String str2) {
            this.f6790e = vAdError;
            this.f6787b = interfaceC0088b;
            this.f6788c = str;
            this.f6789d = str2;
            this.f6786a = null;
        }
    }

    private com.bytedance.sdk.openadsdk.g.a.c a(final String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        return new com.bytedance.sdk.openadsdk.g.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.g.a.b.4
            @Override // com.bytedance.sdk.openadsdk.g.a.c.a
            public void a(String str3, byte[] bArr) {
                d dVar = (d) b.this.f6769c.get(str2);
                if (dVar != null) {
                    for (InterfaceC0088b interfaceC0088b : dVar.f6793c) {
                        if (interfaceC0088b != null) {
                            interfaceC0088b.a(str3, bArr);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<byte[]> mVar) {
                d dVar = (d) b.this.f6769c.remove(str2);
                if (dVar != null) {
                    dVar.f6792b = mVar;
                    dVar.f6794d = mVar.f5540c;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<byte[]> mVar) {
                d dVar = (d) b.this.f6769c.remove(str2);
                if (dVar != null) {
                    dVar.f6792b = mVar;
                    dVar.f6795e = mVar.f5538a;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean zA = dVar.a();
        List<InterfaceC0088b> list = dVar.f6793c;
        if (list != null) {
            for (InterfaceC0088b interfaceC0088b : list) {
                if (interfaceC0088b != null) {
                    if (zA) {
                        interfaceC0088b.a(new c(dVar.f6795e, interfaceC0088b, str, str2));
                    } else {
                        interfaceC0088b.b(new c(dVar.f6794d, interfaceC0088b, str, str2));
                    }
                }
            }
            dVar.f6793c.clear();
        }
    }

    public static a a() {
        return new a();
    }
}
