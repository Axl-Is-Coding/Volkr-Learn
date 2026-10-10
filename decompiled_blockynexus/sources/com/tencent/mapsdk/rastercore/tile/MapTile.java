package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.tencent.mapsdk.rastercore.d.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class MapTile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.d.f f19615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f19619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f19620f;
    private PointF g;
    private MapSource h;
    private List<a> i = new ArrayList();
    private List<a> j = new ArrayList();

    /* JADX INFO: renamed from: com.tencent.mapsdk.rastercore.tile.MapTile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19621a = new int[MapSource.values().length];

        static {
            try {
                f19621a[MapSource.TENCENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19621a[MapSource.WORLD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum MapSource {
        TENCENT,
        WORLD,
        SATELLITE,
        TRAFFIC,
        CUSTOMER
    }

    public MapTile(com.tencent.mapsdk.rastercore.d.f fVar, int i, int i2, int i3, int i4, MapSource mapSource, List<com.tencent.mapsdk.rastercore.e.a.f> list) {
        int iE;
        this.h = MapSource.TENCENT;
        this.f19615a = fVar;
        this.f19616b = i;
        this.f19617c = i2;
        this.f19618d = i3;
        this.f19619e = i4;
        if (fVar.r() && mapSource == MapSource.TENCENT) {
            iE = 7;
        } else {
            int i5 = AnonymousClass1.f19621a[mapSource.ordinal()];
            iE = i5 != 1 ? i5 != 2 ? 1000 : h.e() : h.a();
        }
        this.f19620f = iE;
        this.h = mapSource;
        a aVar = new a(com.tencent.mapsdk.rastercore.tile.b.b.a(this.f19615a, mapSource), this.f19616b, this.f19617c, this.f19618d, this.f19620f, this.f19619e, mapSource);
        if (this.i.size() > 0) {
            this.i.set(0, aVar);
            this.j.set(0, aVar);
        } else {
            this.i.add(aVar);
            this.j.add(aVar);
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.tencent.mapsdk.rastercore.e.a.f> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public final int a() {
        return this.f19618d;
    }

    public final void a(PointF pointF) {
        this.g = pointF;
    }

    public final void a(com.tencent.mapsdk.rastercore.e.a.f fVar) {
        this.i.size();
        a aVar = new a(fVar, this.f19616b, this.f19617c, this.f19618d);
        this.i.add(aVar);
        this.j.add(aVar);
    }

    public final boolean a(Canvas canvas) {
        List<a> list = this.i;
        boolean zA = true;
        if (list != null && list.size() > 0) {
            Collections.sort(this.j, a.k());
            canvas.save();
            PointF pointF = this.g;
            canvas.translate(pointF.x, pointF.y);
            Iterator<a> it = this.j.iterator();
            while (it.hasNext()) {
                zA &= it.next().a(canvas);
            }
            canvas.restore();
        }
        return zA;
    }

    public final boolean a(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a() != null) {
                return true;
            }
        }
        this.i.clear();
        this.i.addAll(list);
        this.j.clear();
        this.j.addAll(list);
        Iterator<a> it2 = this.i.iterator();
        while (it2.hasNext()) {
            if (it2.next().f() == null) {
                return true;
            }
        }
        return false;
    }

    public final List<a> b() {
        return new ArrayList(this.i);
    }

    public final void b(com.tencent.mapsdk.rastercore.e.a.f fVar) {
        Iterator<a> it = this.i.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.a(fVar)) {
                next.h();
                it.remove();
                return;
            }
        }
    }

    public final void c() {
        Iterator<a> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapTile)) {
            return false;
        }
        MapTile mapTile = (MapTile) obj;
        return this.f19616b == mapTile.f19616b && this.f19617c == mapTile.f19617c && this.f19618d == mapTile.f19618d && this.f19619e == mapTile.f19619e && this.f19620f == mapTile.f19620f;
    }

    public final int hashCode() {
        return (this.f19616b * 7) + (this.f19617c * 11) + (this.f19618d * 13);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MapTile(");
        sb.append(this.f19616b);
        sb.append(",");
        sb.append(this.f19617c);
        sb.append(",");
        sb.append(this.f19618d);
        sb.append(",");
        sb.append(this.h);
        sb.append(")");
        return sb.toString();
    }
}
