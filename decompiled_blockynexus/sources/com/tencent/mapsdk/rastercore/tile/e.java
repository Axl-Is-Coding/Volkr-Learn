package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class e implements Callable<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f19665a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.tile.a f19667c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f19666b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19668d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.tile.a.b f19669e = null;

    public interface a {
        void a(e eVar);

        void b(e eVar);
    }

    public e(a aVar, com.tencent.mapsdk.rastercore.tile.a aVar2) {
        this.f19665a = aVar;
        this.f19667c = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Bitmap call() throws Exception {
        a aVar = this.f19665a;
        if (aVar != null) {
            aVar.b(this);
        }
        try {
            this.f19666b = f();
            return this.f19666b;
        } finally {
            e();
        }
    }

    private void e() {
        a aVar = this.f19665a;
        if (aVar != null) {
            aVar.a(this);
        }
        this.f19665a = null;
        Bitmap bitmap = this.f19666b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f19666b.recycle();
        }
        this.f19666b = null;
    }

    private Bitmap f() {
        byte[] bArrA;
        StringBuilder sb;
        String str;
        int i = 0;
        Bitmap bitmapDecodeByteArray = null;
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                bArrA = this.f19667c.a(this.f19668d, this.f19669e != null ? this.f19669e.a() : null);
            } catch (Exception e2) {
                new StringBuilder("Error occured:").append(e2.getMessage());
            }
            if (bArrA != null) {
                if (bArrA.length == 1 && bArrA[i] == -1 && this.f19668d) {
                    com.tencent.mapsdk.rastercore.tile.a.a.a().a(this.f19667c, null, true);
                    if (this.f19669e == null || this.f19669e.b() == null) {
                        return null;
                    }
                    return this.f19669e.b();
                } else {
                    try {
                        bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrA, i, bArrA.length);
                        if (bitmapDecodeByteArray != null) {
                            bitmapDecodeByteArray.setDensity(com.tencent.mapsdk.rastercore.d.f.s());
                            if (bArrA.length < 2097152) {
                                try {
                                    com.tencent.mapsdk.rastercore.tile.a.a.a().a(new com.tencent.mapsdk.rastercore.tile.a.b(bArrA, this.f19667c.l()), this.f19667c);
                                } catch (Throwable th) {
                                    if (TencentMap.getErrorListener() != null) {
                                        TencentMap.getErrorListener().collectErrorInfo("TileNetFetcher downLoad function occured exception when call CacheManager Put,the downloaded data length-" + bArrA.length + ";tileInfo:x=" + this.f19667c.b() + ",y=" + this.f19667c.c() + "z=" + this.f19667c.d() + "exceptionInfo:" + th.toString());
                                    }
                                }
                            } else if (TencentMap.getErrorListener() != null) {
                                TencentMap.getErrorListener().collectErrorInfo("TileNetFetcher downLoad function,the downloaded data length-" + bArrA.length + ";tileInfo:x=" + this.f19667c.b() + ",y=" + this.f19667c.c() + "z=" + this.f19667c.d());
                            }
                        }
                    } catch (Exception e3) {
                        new StringBuilder("decoder bitmap error:").append(e3.getMessage());
                    }
                }
                new StringBuilder("Error occured:").append(e2.getMessage());
            }
            if (bitmapDecodeByteArray != null) {
                return bitmapDecodeByteArray;
            }
            if (i2 == 0) {
                Thread.sleep(300L);
                sb = new StringBuilder();
                sb.append(this.f19667c.l());
                str = ",重试次数：2";
            } else if (i2 == 1) {
                Thread.sleep(500L);
                sb = new StringBuilder();
                sb.append(this.f19667c.l());
                str = ",重试次数3";
            } else if (i2 == 2) {
                Thread.sleep(700L);
                sb = new StringBuilder();
                sb.append(this.f19667c.l());
                str = ",重试次数4";
            }
            sb.append(str);
        }
        if (this.f19667c.e().getClass() == com.tencent.mapsdk.rastercore.tile.b.f.class && bitmapDecodeByteArray == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f19667c.l());
            sb2.append(",重试4次，仍然失败");
        }
        return bitmapDecodeByteArray;
    }

    public final Bitmap a() {
        return this.f19666b;
    }

    public final void a(com.tencent.mapsdk.rastercore.tile.a.b bVar) {
        this.f19669e = bVar;
    }

    public final void a(boolean z) {
        this.f19668d = z;
    }

    public final String b() {
        com.tencent.mapsdk.rastercore.tile.a aVar = this.f19667c;
        return aVar != null ? aVar.toString() : "";
    }

    public final void c() {
        Bitmap bitmap = this.f19666b;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f19666b = null;
    }
}
