package com.tencent.mapsdk.rastercore.tile.b;

import android.os.Build;
import com.tencent.mapsdk.rastercore.d.h;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class f extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicInteger f19660b = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f19661a;

    public f(int i) {
        super(i);
        this.f19661a = new String[]{"https://s0.map.gtimg.com/oversea", "https://s1.map.gtimg.com/oversea", "https://s2.map.gtimg.com/oversea", "https://s3.map.gtimg.com/oversea"};
    }

    static /* synthetic */ String a(int i) {
        StringBuilder sb = new StringBuilder(256);
        sb.append("key=");
        sb.append(com.tencent.mapsdk.rastercore.f.b.a(com.tencent.mapsdk.rastercore.d.f.a()));
        sb.append("&appid=sdk&logid=ditu");
        sb.append("&ver=");
        sb.append(com.tencent.mapsdk.rastercore.f.b.b("1.3.2.1"));
        sb.append("&suid=");
        sb.append(com.tencent.mapsdk.rastercore.f.b.a());
        sb.append("&pf=Android_2D");
        sb.append("&hm=");
        sb.append(com.tencent.mapsdk.rastercore.f.b.b(Build.MODEL));
        sb.append("&os=");
        sb.append(Integer.toString(Build.VERSION.SDK_INT));
        sb.append("&nt=");
        sb.append(com.tencent.mapsdk.rastercore.c.b(com.tencent.mapsdk.rastercore.d.f.a()));
        sb.append("&dpi=");
        sb.append(Integer.toString(com.tencent.mapsdk.rastercore.f.b.b(com.tencent.mapsdk.rastercore.d.f.a())));
        sb.append("&scrn=");
        sb.append(com.tencent.mapsdk.rastercore.f.b.c(com.tencent.mapsdk.rastercore.d.f.a()));
        sb.append("&pname=");
        sb.append(com.tencent.mapsdk.rastercore.f.b.d(com.tencent.mapsdk.rastercore.d.f.a()));
        sb.append("&pid=");
        sb.append(com.tencent.mapsdk.rastercore.f.b.b(com.tencent.mapsdk.rastercore.d.f.a().getPackageName()));
        sb.append("&psv=");
        sb.append(com.tencent.mapsdk.rastercore.f.b.e(com.tencent.mapsdk.rastercore.d.f.a()));
        sb.append("&wtc=");
        sb.append(Integer.toString(i));
        return sb.toString();
    }

    public static void a() {
        final int i = f19660b.get();
        new Thread(new Runnable() { // from class: com.tencent.mapsdk.rastercore.tile.b.f.1
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mapsdk.rastercore.f.a aVarA = com.tencent.mapsdk.rastercore.f.a.a();
                int iB = aVarA != null ? aVarA.b("worldTileCount") : -1;
                if (iB > 0 || i > 0) {
                    int i2 = iB > 0 ? iB + i : i;
                    String str = "https://pr.map.qq.com/pingd?" + f.a(i2);
                    try {
                        int responseCode = ((HttpURLConnection) new URL(str).openConnection()).getResponseCode();
                        if (aVarA == null) {
                            return;
                        }
                        if (responseCode != 200) {
                            aVarA.a("worldTileCount", i2);
                        } else {
                            new StringBuilder("url:").append(str);
                            aVarA.a(new String[]{"worldTileCount"});
                        }
                    } catch (IOException unused) {
                        if (aVarA != null) {
                            aVarA.a("worldTileCount", i2);
                        }
                    }
                }
            }
        }).start();
        f19660b.set(0);
    }

    @Override // com.tencent.mapsdk.raster.model.UrlTileProvider
    public URL getTileUrl(int i, int i2, int i3, Object... objArr) {
        String str = this.f19661a[a.a(i + i2, this.f19661a.length)] + "?z=" + i3 + "&x=" + i + "&y=" + i2 + "&styleid=" + h.e() + "&scene=" + h.f() + "&version=" + h.g() + "&ch=" + com.tencent.mapsdk.rastercore.d.f.q();
        try {
            f19660b.incrementAndGet();
            return new URL(str);
        } catch (MalformedURLException unused) {
            new StringBuilder("Unable to new URL with ").append(str);
            return null;
        }
    }
}
