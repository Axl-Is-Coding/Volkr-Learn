package c.t.m.g;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;

/* JADX INFO: renamed from: c.t.m.g.gb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
final class C0429gb extends AbstractC0426fb {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LruCache<String, Pair<Double, Double>> f3212d;

    public C0429gb(String str) {
        super(str, "check cell");
        this.f3212d = new LruCache<>(100);
    }

    @Override // c.t.m.g.AbstractC0426fb
    public final void a() {
        super.a();
        this.f3212d.evictAll();
    }

    @Override // c.t.m.g.AbstractC0426fb
    protected final boolean b(Bundle bundle) {
        String string = bundle.getString("cellkey");
        Location location = (Location) bundle.getParcelable("location");
        if (location == null) {
            return true;
        }
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        Pair<Double, Double> pair = this.f3212d.get(string);
        if (pair != null) {
            return Vb.a(location.getLatitude(), location.getLongitude(), ((Double) pair.first).doubleValue(), ((Double) pair.second).doubleValue()) < 6000.0d;
        }
        this.f3212d.put(string, Pair.create(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
        return true;
    }
}
