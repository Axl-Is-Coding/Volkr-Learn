package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import com.tencent.mapsdk.rastercore.tile.MapTile;
import com.tencent.mapsdk.rastercore.tile.e;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeUnit f19646a = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f19647b = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.d.f f19648c;
    private ExecutorService h;
    private ExecutorService i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, List<a>> f19649d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, List<a>> f19650e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BlockingQueue<Runnable> f19651f = new LinkedBlockingQueue();
    private final BlockingQueue<Runnable> g = new LinkedBlockingQueue();
    private ThreadFactory j = new ThreadFactory(this) { // from class: com.tencent.mapsdk.rastercore.tile.b.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f19652a = 0;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder("TileFetchThread#");
            int i = this.f19652a;
            this.f19652a = i + 1;
            sb.append(i);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setPriority(10);
            return thread;
        }
    };

    public b(com.tencent.mapsdk.rastercore.d.f fVar) {
        int i;
        int i2;
        this.f19648c = fVar;
        if (f19647b < 4) {
            i = 3;
            i2 = 3;
        } else {
            i = 4;
            i2 = 4;
        }
        this.i = new ThreadPoolExecutor(i, i2, 30L, TimeUnit.SECONDS, this.g, this.j);
        this.h = new ThreadPoolExecutor(1, 1, 30L, f19646a, this.f19651f);
    }

    static /* synthetic */ void a(b bVar, a aVar, boolean z, com.tencent.mapsdk.rastercore.tile.a.b bVar2) {
        String string = aVar.toString();
        synchronized (bVar.f19649d) {
            List<a> list = bVar.f19649d.get(string);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVar);
                bVar.f19649d.put(string, arrayList);
                try {
                    e eVar = new e(bVar, aVar);
                    eVar.a(z);
                    eVar.a(bVar2);
                    if (!bVar.i.isShutdown()) {
                        bVar.i.submit(eVar);
                    }
                } catch (Exception e2) {
                    new StringBuilder("Submit get error:").append(e2.getMessage());
                }
            }
            list.add(aVar);
        }
    }

    public final void a() {
        BlockingQueue<Runnable> blockingQueue = this.f19651f;
        if (blockingQueue != null) {
            blockingQueue.clear();
        }
        BlockingQueue<Runnable> blockingQueue2 = this.g;
        if (blockingQueue2 != null) {
            blockingQueue2.clear();
        }
        ExecutorService executorService = this.h;
        if (executorService != null) {
            executorService.shutdownNow();
            this.h = null;
        }
        ExecutorService executorService2 = this.i;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.i = null;
        }
    }

    @Override // com.tencent.mapsdk.rastercore.tile.e.a
    public final void a(e eVar) {
        List<a> listRemove;
        if (eVar != null) {
            String strB = eVar.b();
            Bitmap bitmapA = eVar.a();
            synchronized (this.f19649d) {
                listRemove = this.f19650e.remove(strB);
                this.f19649d.remove(strB);
            }
            if (listRemove != null && bitmapA != null && !bitmapA.isRecycled()) {
                for (a aVar : listRemove) {
                    if (!aVar.i()) {
                        aVar.a(bitmapA.copy(bitmapA.getConfig(), false));
                    }
                }
            }
            eVar.c();
        }
        this.f19648c.c().postInvalidate();
    }

    public final void a(final ArrayList<MapTile> arrayList) {
        if (com.tencent.mapsdk.rastercore.f.b.a(arrayList)) {
            return;
        }
        this.f19651f.clear();
        Runnable runnable = new Runnable() { // from class: com.tencent.mapsdk.rastercore.tile.b.2
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mapsdk.rastercore.tile.a.b bVarA;
                b.this.g.clear();
                synchronized (b.this.f19649d) {
                    b.this.f19649d.clear();
                    b.this.f19649d.putAll(b.this.f19650e);
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    for (a aVar : ((MapTile) arrayList.get(i)).b()) {
                        try {
                            bVarA = com.tencent.mapsdk.rastercore.tile.a.a.a().a(aVar);
                        } catch (Throwable th) {
                            if (TencentMap.getErrorListener() != null) {
                                TencentMap.getErrorListener().collectErrorInfo("TileEngineManager getTiles Runnable call CacheManager Get occured Exception,tileInfo:x=" + aVar.b() + ",y=" + aVar.c() + ",z=" + aVar.d() + "Exception Info:" + th.toString());
                            }
                            bVarA = null;
                        }
                        if (bVarA.b() != null && bVarA.d() == aVar.l()) {
                            aVar.a(bVarA.b());
                        } else if (bVarA.b() != null && bVarA.d() != aVar.l() && aVar.m() == MapTile.MapSource.TENCENT) {
                            StringBuilder sb = new StringBuilder("Have got cache,but version is not ok,tileBitmap.getVersion：");
                            sb.append(bVarA.d());
                            sb.append(",tileData.getVersion:");
                            sb.append(aVar.l());
                            b.a(b.this, aVar, true, bVarA);
                        } else if (bVarA.b() == null) {
                            b.a(b.this, aVar, false, null);
                        }
                    }
                    b.this.f19648c.c().postInvalidate();
                }
            }
        };
        try {
            if (this.h.isShutdown()) {
                return;
            }
            this.h.execute(runnable);
        } catch (Exception e2) {
            new StringBuilder("getTiles get error:").append(e2.getMessage());
        }
    }

    @Override // com.tencent.mapsdk.rastercore.tile.e.a
    public final void b(e eVar) {
        if (eVar != null) {
            String strB = eVar.b();
            synchronized (this.f19649d) {
                this.f19650e.put(strB, this.f19649d.remove(strB));
            }
        }
    }
}
