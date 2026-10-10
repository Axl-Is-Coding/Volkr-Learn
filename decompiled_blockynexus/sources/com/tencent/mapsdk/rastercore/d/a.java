package com.tencent.mapsdk.rastercore.d;

import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.rastercore.tile.MapTile;
import com.tencent.tencentmap.mapsdk.map.Overlay;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f19482e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f19483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<com.tencent.mapsdk.rastercore.e.c> f19484b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SortedMap<String, com.tencent.mapsdk.rastercore.e.a.c> f19485c = new TreeMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0172a f19486d = new C0172a(this, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19487f = 0;

    /* JADX INFO: renamed from: com.tencent.mapsdk.rastercore.d.a$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected float f19488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected int f19489b;
        private f l;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MapTile.MapSource f19491d = MapTile.MapSource.TENCENT;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f19492e = 256;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f19493f = true;
        private boolean g = true;
        private boolean h = false;
        private boolean i = true;
        private int j = 0;
        private int k = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Handler f19490c = new d(this);

        protected AnonymousClass1(f fVar) {
            this.f19488a = 0.9f;
            this.f19489b = 0;
            this.l = fVar;
            new DisplayMetrics();
            int i = f.a().getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                this.f19489b = 1;
                this.f19488a = 0.5f;
                return;
            }
            if (i <= 160) {
                this.f19489b = 2;
                this.f19488a = 0.8f;
                return;
            }
            if (i <= 240) {
                this.f19489b = 3;
                this.f19488a = 0.87f;
            } else if (i <= 320) {
                this.f19488a = 1.0f;
                this.f19489b = 4;
            } else if (i <= 480) {
                this.f19488a = 1.5f;
                this.f19489b = 5;
            } else {
                this.f19488a = 1.8f;
                this.f19489b = 6;
            }
        }

        public int a() {
            return this.f19489b;
        }

        public void a(float f2) {
            f fVar = this.l;
            if (fVar != null) {
                fVar.a(f2);
            }
        }

        public void a(int i) {
            this.f19492e = i;
        }

        public void a(int i, int[] iArr) {
            f fVar = this.l;
            if (fVar != null) {
                fVar.a(i, iArr);
            }
        }

        public void a(MapTile.MapSource mapSource) {
            this.f19491d = mapSource;
        }

        public void a(boolean z) {
            this.h = z;
            this.f19490c.obtainMessage(1).sendToTarget();
        }

        public float b() {
            return this.f19488a;
        }

        public void b(int i) {
            this.j = i;
            this.l.b(i);
        }

        public void b(boolean z) {
            this.f19493f = z;
        }

        public MapTile.MapSource c() {
            return this.f19491d;
        }

        public void c(int i) {
            this.k = i;
            this.l.c(i);
        }

        public void c(boolean z) {
            this.g = z;
        }

        public int d() {
            return this.f19492e;
        }

        public void d(boolean z) {
            c(z);
            b(z);
        }

        public void e(boolean z) {
            this.i = z;
        }

        public boolean e() {
            return this.f19491d == MapTile.MapSource.WORLD;
        }

        public int f() {
            return this.k;
        }

        public boolean g() {
            return this.h;
        }

        public boolean h() {
            return this.f19493f;
        }

        public boolean i() {
            return this.g;
        }

        public int j() {
            return this.j;
        }

        public boolean k() {
            return this.i;
        }
    }

    /* JADX INFO: renamed from: com.tencent.mapsdk.rastercore.d.a$a, reason: collision with other inner class name */
    class C0172a implements Comparator<Object> {
        private C0172a(a aVar) {
        }

        /* synthetic */ C0172a(a aVar, byte b2) {
            this(aVar);
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            com.tencent.mapsdk.rastercore.e.c cVar = (com.tencent.mapsdk.rastercore.e.c) obj;
            com.tencent.mapsdk.rastercore.e.c cVar2 = (com.tencent.mapsdk.rastercore.e.c) obj2;
            if (cVar == null || cVar2 == null) {
                return 0;
            }
            try {
                if (cVar.getZIndex() > cVar2.getZIndex()) {
                    return 1;
                }
                return cVar.getZIndex() < cVar2.getZIndex() ? -1 : 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
    }

    public a(f fVar) {
        this.f19483a = fVar;
    }

    public static String a(String str) {
        f19482e++;
        return str + f19482e;
    }

    public final com.tencent.mapsdk.rastercore.e.a.c a(MarkerOptions markerOptions) {
        com.tencent.mapsdk.rastercore.e.a.c cVar = new com.tencent.mapsdk.rastercore.e.a.c(this.f19483a, markerOptions);
        this.f19485c.put(cVar.m(), cVar);
        return cVar;
    }

    public final com.tencent.mapsdk.rastercore.e.a a(CircleOptions circleOptions) {
        com.tencent.mapsdk.rastercore.e.a aVar = new com.tencent.mapsdk.rastercore.e.a(this.f19483a, circleOptions);
        a(aVar);
        return aVar;
    }

    public final com.tencent.mapsdk.rastercore.e.b a(GroundOverlayOptions groundOverlayOptions) {
        com.tencent.mapsdk.rastercore.e.b bVar = new com.tencent.mapsdk.rastercore.e.b(this.f19483a, groundOverlayOptions);
        a(bVar);
        return bVar;
    }

    public final com.tencent.mapsdk.rastercore.e.d a(PolygonOptions polygonOptions) {
        com.tencent.mapsdk.rastercore.e.d dVar = new com.tencent.mapsdk.rastercore.e.d(this.f19483a, polygonOptions);
        a(dVar);
        return dVar;
    }

    public final com.tencent.mapsdk.rastercore.e.e a(PolylineOptions polylineOptions) {
        com.tencent.mapsdk.rastercore.e.a.d dVar = new com.tencent.mapsdk.rastercore.e.a.d(this.f19483a, polylineOptions);
        a(dVar);
        return dVar;
    }

    public final void a() {
        try {
            Iterator<Map.Entry<String, com.tencent.mapsdk.rastercore.e.a.c>> it = this.f19485c.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().c();
            }
            this.f19485c.clear();
            Iterator<com.tencent.mapsdk.rastercore.e.c> it2 = this.f19484b.iterator();
            while (it2.hasNext()) {
                it2.next().destroy();
            }
            this.f19484b.clear();
            if (Build.VERSION.SDK_INT <= 11 || this.f19483a.c() == null) {
                return;
            }
            this.f19483a.c().setLayerType(2, null);
        } catch (Exception unused) {
        }
    }

    public final void a(Canvas canvas) {
        int size = this.f19484b.size();
        for (com.tencent.mapsdk.rastercore.e.c cVar : this.f19484b) {
            if (cVar.isVisible() && (size <= 20 || cVar.checkInBounds())) {
                cVar.draw(canvas);
            }
        }
    }

    public final void a(com.tencent.mapsdk.rastercore.e.c cVar) {
        b(cVar.getId());
        this.f19484b.add(cVar);
        if (Build.VERSION.SDK_INT > 11 && !(cVar instanceof com.tencent.mapsdk.rastercore.e.a)) {
            int i = this.f19487f + 1;
            this.f19487f = i;
            if (i > 0 && this.f19483a.c() != null) {
                this.f19483a.c().setLayerType(1, null);
            }
        }
        if (this.f19487f > 0) {
            this.f19483a.f(false);
        }
        c();
        this.f19483a.a(false, false);
    }

    public final boolean a(MotionEvent motionEvent) {
        for (com.tencent.mapsdk.rastercore.e.c cVar : this.f19484b) {
            if (cVar instanceof Overlay) {
                ((Overlay) cVar).onTouchEvent(motionEvent, this.f19483a.d());
            }
        }
        return false;
    }

    @Deprecated
    public final boolean a(GeoPoint geoPoint) {
        boolean z;
        Iterator<com.tencent.mapsdk.rastercore.e.c> it = this.f19484b.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.tencent.mapsdk.rastercore.e.c next = it.next();
            if ((next instanceof Overlay) && ((Overlay) next).onTap(geoPoint, this.f19483a.d())) {
                z = true;
                break;
            }
        }
        if (!z) {
            for (com.tencent.mapsdk.rastercore.e.c cVar : this.f19484b) {
                if (cVar instanceof Overlay) {
                    ((Overlay) cVar).onEmptyTap(geoPoint);
                }
            }
        }
        return z;
    }

    public final boolean a(GeoPoint geoPoint, MotionEvent motionEvent) {
        for (com.tencent.mapsdk.rastercore.e.c cVar : this.f19484b) {
            if ((cVar instanceof Overlay) && ((Overlay) cVar).onLongPress(geoPoint, motionEvent, this.f19483a.d())) {
                return true;
            }
        }
        return false;
    }

    protected final void b() {
        a();
    }

    public final boolean b(String str) {
        com.tencent.mapsdk.rastercore.e.c next;
        Iterator<com.tencent.mapsdk.rastercore.e.c> it = this.f19484b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && next.getId().equals(str)) {
                break;
            }
        }
        if (next == null) {
            return false;
        }
        boolean zRemove = this.f19484b.remove(next);
        if (Build.VERSION.SDK_INT > 11 && zRemove && !(next instanceof com.tencent.mapsdk.rastercore.e.a)) {
            int i = this.f19487f - 1;
            this.f19487f = i;
            if (i == 0 && this.f19483a.c() != null) {
                this.f19483a.c().setLayerType(1, null);
            }
        }
        if (this.f19487f <= 0) {
            this.f19483a.f(true);
        }
        this.f19483a.a(false, false);
        return zRemove;
    }

    public final void c() {
        Object[] array = this.f19484b.toArray();
        Arrays.sort(array, this.f19486d);
        this.f19484b.clear();
        for (Object obj : array) {
            this.f19484b.add((com.tencent.mapsdk.rastercore.e.c) obj);
        }
    }

    public final boolean c(String str) {
        com.tencent.mapsdk.rastercore.e.a.c cVarRemove = this.f19485c.remove(str);
        if (cVarRemove == null) {
            return false;
        }
        cVarRemove.c();
        return true;
    }
}
