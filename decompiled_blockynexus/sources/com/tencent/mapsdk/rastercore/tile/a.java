package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.Tile;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.raster.model.TileProvider;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.h;
import com.tencent.mapsdk.rastercore.tile.MapTile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    private static final Comparator<a> m = new C0173a(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MapTile.MapSource f19625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19627f;
    private TileProvider g;
    private Bitmap h;
    private String i;
    private boolean j;
    private volatile boolean k;
    private com.tencent.mapsdk.rastercore.e.a.f l;

    /* JADX INFO: renamed from: com.tencent.mapsdk.rastercore.tile.a$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        b f19631d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.tencent.mapsdk.rastercore.d.f f19632e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private com.tencent.mapsdk.rastercore.d.b f19633f;
        private PaintFlagsDrawFilter i;
        private int g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList<MapTile> f19628a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<MapTile> f19629b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ArrayList<MapTile> f19630c = null;
        private List<com.tencent.mapsdk.rastercore.e.a.f> h = new ArrayList();

        public AnonymousClass1(com.tencent.mapsdk.rastercore.d.f fVar) {
            this.f19632e = fVar;
            this.f19633f = fVar.c();
            this.f19631d = new b(fVar);
        }

        public static int a(MapTile.MapSource mapSource) {
            int i = d.f19664a[mapSource.ordinal()];
            if (i == 1) {
                return h.g();
            }
            if (i == 2) {
                return h.b();
            }
            if (i != 3) {
                return -1;
            }
            return h.d();
        }

        private ArrayList<MapTile> a(int i) {
            return a(this.f19633f.b(), i, this.f19633f.getWidth(), this.f19633f.getHeight(), this.f19632e.f().d());
        }

        private static void a(ArrayList<MapTile> arrayList) {
            if (arrayList == null) {
                return;
            }
            Iterator<MapTile> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            arrayList.clear();
        }

        private static void a(ArrayList<MapTile> arrayList, ArrayList<MapTile> arrayList2, ArrayList<MapTile> arrayList3) {
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                MapTile mapTile = arrayList.get(i);
                if (mapTile != null) {
                    List<a> listB = null;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= arrayList2.size()) {
                                break;
                            }
                            MapTile mapTile2 = arrayList2.get(i2);
                            if (mapTile2.equals(mapTile)) {
                                listB = mapTile2.b();
                                arrayList2.remove(i2);
                                break;
                            }
                            i2++;
                        }
                    }
                    if ((listB == null || mapTile.a(listB)) && arrayList3 != null) {
                        arrayList3.add(mapTile);
                    }
                }
            }
            if (arrayList2 != null) {
                for (MapTile mapTile3 : arrayList2) {
                    if (mapTile3 != null && mapTile3.b() != null) {
                        try {
                            mapTile3.c();
                        } catch (Exception unused) {
                        }
                    }
                }
                arrayList2.clear();
            }
        }

        private static void a(List<MapTile> list, com.tencent.mapsdk.rastercore.e.a.f fVar) {
            if (list == null) {
                return;
            }
            Iterator<MapTile> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(fVar);
            }
        }

        private boolean a(Canvas canvas, ArrayList<MapTile> arrayList) {
            double dB = this.f19633f.d().b();
            PointF pointFA = this.f19633f.a();
            boolean z = true;
            if (arrayList != null && arrayList.size() > 0) {
                int iA = arrayList.get(0).a();
                int iA2 = this.f19633f.d().a();
                if (this.f19632e.f().e()) {
                    iA2--;
                }
                double dPow = Math.pow(2.0d, iA2 - iA) * dB;
                if (dPow != 1.0d) {
                    Matrix matrix = new Matrix();
                    canvas.save();
                    matrix.reset();
                    float f2 = (float) dPow;
                    matrix.postScale(f2, f2, pointFA.x, pointFA.y);
                    canvas.concat(matrix);
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    try {
                        MapTile mapTile = arrayList.get(i);
                        if (mapTile != null && !mapTile.a(canvas)) {
                            z = false;
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (dPow != 1.0d) {
                    canvas.restore();
                }
            }
            return z;
        }

        private static void b(List<MapTile> list, com.tencent.mapsdk.rastercore.e.a.f fVar) {
            if (list == null) {
                return;
            }
            Iterator<MapTile> it = list.iterator();
            while (it.hasNext()) {
                it.next().b(fVar);
            }
        }

        PointF a(int i, int i2, int i3, int i4, PointF pointF, int i5, int i6, int i7, int i8) {
            PointF pointF2 = new PointF();
            if (i >= 0 && i2 >= 0) {
                double d2 = i8;
                if (i < Math.pow(2.0d, d2) && i2 < Math.pow(2.0d, d2)) {
                    pointF2.x = ((i - i3) * i7) + pointF.x;
                    pointF2.y = ((i2 - i4) * i7) + pointF.y;
                    float f2 = pointF2.x;
                    float f3 = i7;
                    if (f2 + f3 > WheelView.DividerConfig.FILL && f2 < i5) {
                        float f4 = pointF2.y;
                        if (f3 + f4 > WheelView.DividerConfig.FILL && f4 < i6) {
                            return pointF2;
                        }
                    }
                }
            }
            return null;
        }

        public com.tencent.mapsdk.rastercore.e.a.f a(TileOverlayOptions tileOverlayOptions) {
            com.tencent.mapsdk.rastercore.e.a.f fVar = new com.tencent.mapsdk.rastercore.e.a.f(this.f19632e, tileOverlayOptions);
            this.h.add(fVar);
            a(this.f19629b, fVar);
            a((List<MapTile>) null, fVar);
            a(this.f19630c, fVar);
            this.f19632e.a(false, false);
            return fVar;
        }

        public ArrayList<MapTile> a(com.tencent.mapsdk.rastercore.b.f fVar, int i, int i2, int i3, int i4) {
            int i5;
            double dC = com.tencent.mapsdk.rastercore.b.d.c(i + (this.f19632e.f().e() ? 1 : 0));
            MapTile.MapSource mapSourceC = this.f19632e.f().c();
            double dB = fVar.b() - (-2.003750834E7d);
            double d2 = i4;
            Double.isNaN(d2);
            double d3 = d2 * dC;
            int i6 = (int) (dB / d3);
            Double.isNaN(i6 * i4);
            int iA = (int) ((2.003750834E7d - fVar.a()) / d3);
            double d4 = iA * i4;
            Double.isNaN(d4);
            com.tencent.mapsdk.rastercore.b.f fVar2 = new com.tencent.mapsdk.rastercore.b.f((r2 * dC) - 2.003750834E7d, 2.003750834E7d - (d4 * dC));
            PointF pointFA = this.f19633f.a();
            PointF pointF = new PointF();
            double dB2 = (fVar2.b() - fVar.b()) / dC;
            double d5 = pointFA.x;
            Double.isNaN(d5);
            pointF.x = (float) (dB2 + d5);
            double d6 = pointFA.y;
            double dA = (fVar2.a() - fVar.a()) / dC;
            Double.isNaN(d6);
            pointF.y = (float) (d6 - dA);
            MapTile mapTile = new MapTile(this.f19632e, i6, iA, i, a(mapSourceC), mapSourceC, this.h);
            mapTile.a(pointF);
            ArrayList<MapTile> arrayList = new ArrayList<>();
            arrayList.add(mapTile);
            int i7 = 1;
            while (true) {
                int i8 = i6 - i7;
                int i9 = i8;
                boolean z = false;
                while (true) {
                    i5 = i6 + i7;
                    if (i9 > i5) {
                        break;
                    }
                    int i10 = iA + i7;
                    int i11 = i9;
                    ArrayList<MapTile> arrayList2 = arrayList;
                    PointF pointFA2 = a(i9, i10, i6, iA, pointF, i2, i3, i4, i);
                    if (pointFA2 != null) {
                        if (!z) {
                            z = true;
                        }
                        MapTile mapTile2 = new MapTile(this.f19632e, i11, i10, i, a(mapSourceC), mapSourceC, this.h);
                        mapTile2.a(pointFA2);
                        arrayList2.add(mapTile2);
                    }
                    int i12 = iA - i7;
                    PointF pointFA3 = a(i11, i12, i6, iA, pointF, i2, i3, i4, i);
                    if (pointFA3 != null) {
                        if (!z) {
                            z = true;
                        }
                        MapTile mapTile3 = new MapTile(this.f19632e, i11, i12, i, a(mapSourceC), mapSourceC, this.h);
                        mapTile3.a(pointFA3);
                        arrayList2.add(mapTile3);
                    }
                    i9 = i11 + 1;
                    arrayList = arrayList2;
                }
                ArrayList<MapTile> arrayList3 = arrayList;
                int i13 = (iA + i7) - 1;
                while (i13 > iA - i7) {
                    int i14 = i5;
                    int i15 = i13;
                    PointF pointFA4 = a(i5, i13, i6, iA, pointF, i2, i3, i4, i);
                    if (pointFA4 != null) {
                        if (!z) {
                            z = true;
                        }
                        MapTile mapTile4 = new MapTile(this.f19632e, i14, i15, i, a(mapSourceC), mapSourceC, this.h);
                        mapTile4.a(pointFA4);
                        arrayList3.add(mapTile4);
                    }
                    PointF pointFA5 = a(i8, i15, i6, iA, pointF, i2, i3, i4, i);
                    if (pointFA5 != null) {
                        if (!z) {
                            z = true;
                        }
                        MapTile mapTile5 = new MapTile(this.f19632e, i8, i15, i, a(mapSourceC), mapSourceC, this.h);
                        mapTile5.a(pointFA5);
                        arrayList3.add(mapTile5);
                    }
                    i13 = i15 - 1;
                    i5 = i14;
                }
                if (!z) {
                    return arrayList3;
                }
                i7++;
                arrayList = arrayList3;
            }
        }

        public void a() {
            a((ArrayList<MapTile>) null);
            a(this.f19629b);
            a(this.f19630c);
            this.f19631d.a();
        }

        public void a(boolean z, boolean z2) {
            a.AnonymousClass1 anonymousClass1F;
            int i;
            ArrayList<MapTile> arrayList;
            int iA;
            ArrayList<MapTile> arrayList2;
            int iA2;
            if (!z) {
                MapTile.MapSource mapSource = MapTile.MapSource.TENCENT;
                MapTile.MapSource mapSource2 = this.f19632e.l() == 2 ? MapTile.MapSource.SATELLITE : (!h.h() || this.f19633f.d().a() <= 7 || b()) ? MapTile.MapSource.TENCENT : MapTile.MapSource.WORLD;
                if (this.f19632e.f().c() != mapSource2) {
                    this.f19632e.f().a(mapSource2);
                    ArrayList<MapTile> arrayList3 = this.f19629b;
                    if (arrayList3 != null) {
                        arrayList3.clear();
                    }
                    ArrayList<MapTile> arrayList4 = this.f19630c;
                    if (arrayList4 != null) {
                        arrayList4.clear();
                    }
                }
            }
            if (this.f19632e.f().e()) {
                anonymousClass1F = this.f19632e.f();
                i = 512;
            } else {
                anonymousClass1F = this.f19632e.f();
                i = 256;
            }
            anonymousClass1F.a(i);
            int iA3 = this.f19633f.d().a();
            if (this.f19632e.f().e()) {
                iA3--;
            }
            ArrayList<MapTile> arrayList5 = this.f19629b;
            if (arrayList5 == null || arrayList5.size() <= 0) {
                arrayList = null;
                iA = -1;
            } else {
                iA = this.f19629b.get(0).a();
                arrayList = this.f19629b;
            }
            int i2 = iA - iA3;
            if (i2 != 0 || z2) {
                ArrayList<MapTile> arrayList6 = this.f19630c;
                if (arrayList6 == null || arrayList6.size() <= 0) {
                    arrayList2 = null;
                    iA2 = -1;
                } else {
                    iA2 = this.f19630c.get(0).a();
                    arrayList2 = this.f19630c;
                }
                if (iA3 == iA2 && iA2 != -1) {
                    this.f19629b = arrayList2;
                }
                if (Math.abs(i2) == 1) {
                    this.f19630c = arrayList;
                }
            }
            ArrayList<MapTile> arrayList7 = new ArrayList<>();
            ArrayList<MapTile> arrayList8 = this.f19630c;
            if (arrayList8 != null && arrayList8.size() > 0) {
                ArrayList<MapTile> arrayListA = a(this.f19630c.get(0).a());
                a(arrayListA, this.f19630c, null);
                this.f19630c = arrayListA;
            }
            ArrayList<MapTile> arrayListA2 = a(iA3);
            a(arrayListA2, this.f19629b, arrayList7);
            this.f19629b = arrayListA2;
            this.f19631d.a(arrayList7);
            this.f19632e.c().invalidate();
        }

        public boolean a(Canvas canvas) {
            a(canvas, (ArrayList<MapTile>) null);
            a(canvas, this.f19630c);
            if (this.i == null) {
                this.i = new PaintFlagsDrawFilter(0, 2);
            }
            canvas.setDrawFilter(this.i);
            boolean zA = a(canvas, this.f19629b);
            canvas.setDrawFilter(null);
            if (!zA) {
                return false;
            }
            ArrayList<MapTile> arrayList = this.f19630c;
            if (arrayList == null) {
                return true;
            }
            arrayList.clear();
            return true;
        }

        public boolean a(com.tencent.mapsdk.rastercore.e.a.f fVar) {
            boolean zRemove = this.h.remove(fVar);
            if (zRemove) {
                b(this.f19629b, fVar);
                b(null, fVar);
                b(this.f19630c, fVar);
            }
            this.f19632e.a(false, false);
            return zRemove;
        }

        public boolean b() {
            com.tencent.mapsdk.rastercore.b.f[] fVarArrB = this.f19632e.b().b();
            com.tencent.mapsdk.rastercore.d.e.a();
            return com.tencent.mapsdk.rastercore.d.e.a(fVarArrB, com.tencent.mapsdk.rastercore.d.e.c("china"));
        }
    }

    /* JADX INFO: renamed from: com.tencent.mapsdk.rastercore.tile.a$a, reason: collision with other inner class name */
    static final class C0173a implements Comparator<a> {
        private C0173a() {
        }

        /* synthetic */ C0173a(byte b2) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(a aVar, a aVar2) {
            a aVar3 = aVar;
            a aVar4 = aVar2;
            if (aVar3 == null) {
                return -1;
            }
            if (aVar4 == null) {
                return 1;
            }
            return Float.compare(aVar3.j(), aVar4.j());
        }
    }

    public a(TileProvider tileProvider, int i, int i2, int i3, int i4, int i5, MapTile.MapSource mapSource) {
        this.f19627f = 0;
        this.j = true;
        this.k = false;
        this.g = tileProvider;
        this.f19622a = i;
        this.f19623b = i2;
        this.f19624c = i3;
        this.f19625d = mapSource;
        this.f19626e = i5;
        this.f19627f = i4;
    }

    public a(com.tencent.mapsdk.rastercore.e.a.f fVar, int i, int i2, int i3) {
        this.f19627f = 0;
        this.j = true;
        this.k = false;
        this.g = fVar.f();
        this.f19622a = i;
        this.f19623b = i2;
        this.f19624c = i3;
        this.l = fVar;
        this.i = fVar.g();
        this.j = fVar.h();
    }

    public static Comparator<a> k() {
        return m;
    }

    public final String a() {
        return this.i;
    }

    public final void a(Bitmap bitmap) {
        this.h = bitmap;
        if (bitmap != null) {
            this.h.setDensity(com.tencent.mapsdk.rastercore.d.f.s());
        }
    }

    public final boolean a(Canvas canvas) {
        Bitmap bitmap;
        com.tencent.mapsdk.rastercore.e.a.f fVar = this.l;
        if ((fVar == null || fVar.e()) && (bitmap = this.h) != null && !bitmap.isRecycled()) {
            try {
                canvas.drawBitmap(this.h, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, (Paint) null);
                return true;
            } catch (Exception unused) {
                Bitmap bitmap2 = this.h;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    this.h.recycle();
                }
                this.h = null;
            }
        }
        return false;
    }

    public final boolean a(com.tencent.mapsdk.rastercore.e.a.f fVar) {
        com.tencent.mapsdk.rastercore.e.a.f fVar2 = this.l;
        if (fVar2 == null) {
            return false;
        }
        return fVar2.equals(fVar);
    }

    public final byte[] a(boolean z, String str) {
        Tile tile;
        try {
            if (this.f19627f == 7 && this.f19625d == MapTile.MapSource.TENCENT) {
                tile = this.g.getTile(this.f19622a, this.f19623b, this.f19624c, this.f19625d, Integer.valueOf(this.f19626e), Integer.valueOf(this.f19627f));
            } else {
                tile = this.g.getTile(this.f19622a, this.f19623b, this.f19624c, this.f19625d, Integer.valueOf(this.f19626e), str, Boolean.valueOf(z));
                if (tile != null) {
                    return tile.getData();
                }
            }
            if (tile != null) {
                return tile.getData();
            }
            return null;
        } catch (Exception e2) {
            new StringBuilder("get tile raises exception:").append(e2.getMessage());
            return null;
        }
    }

    public final int b() {
        return this.f19622a;
    }

    public final int c() {
        return this.f19623b;
    }

    public final int d() {
        return this.f19624c;
    }

    public final TileProvider e() {
        return this.g;
    }

    public final Bitmap f() {
        return this.h;
    }

    public final boolean g() {
        return this.j;
    }

    public final void h() {
        this.k = true;
        Bitmap bitmap = this.h;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.h.recycle();
        }
        this.h = null;
    }

    public final boolean i() {
        return this.k;
    }

    public final float j() {
        com.tencent.mapsdk.rastercore.e.a.f fVar = this.l;
        if (fVar != null) {
            return fVar.a();
        }
        return Float.NEGATIVE_INFINITY;
    }

    public final int l() {
        return this.f19626e;
    }

    public final MapTile.MapSource m() {
        return this.f19625d;
    }

    public final int n() {
        return this.f19627f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this.f19622a);
        sb.append("_");
        sb.append(this.f19623b);
        sb.append("_");
        sb.append(this.f19624c);
        sb.append("_");
        sb.append(this.f19627f);
        sb.append("_");
        sb.append(this.f19626e);
        sb.append("_");
        sb.append(this.f19625d);
        sb.append("_");
        sb.append(this.g.getClass().getCanonicalName());
        return sb.toString();
    }
}
