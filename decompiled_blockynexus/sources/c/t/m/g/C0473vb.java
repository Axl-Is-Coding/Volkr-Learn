package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: renamed from: c.t.m.g.vb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class C0473vb {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinkedList<a> f3431c = new LinkedList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3429a = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3430b = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private _a f3432d = new _a();

    /* JADX INFO: renamed from: c.t.m.g.vb$a */
    /* JADX INFO: compiled from: TL */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f3433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f3434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f3435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private double f3436d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f3437e;

        a() {
        }

        static a a(TencentLocation tencentLocation) {
            a aVar = new a();
            aVar.f3433a = tencentLocation.getLatitude();
            aVar.f3434b = tencentLocation.getLongitude();
            aVar.f3435c = tencentLocation.getTime();
            aVar.f3436d = tencentLocation.getSpeed();
            if (TencentLocationUtils.isFromGps(tencentLocation)) {
                aVar.f3437e = tencentLocation.getAccuracy() < 100.0f ? 3 : 2;
            } else {
                aVar.f3437e = tencentLocation.getAccuracy() >= 500.0f ? 1 : 2;
            }
            return aVar;
        }

        public final String toString() {
            return "[" + this.f3433a + "," + this.f3434b + "]";
        }
    }

    public final synchronized void a() {
        this.f3431c.clear();
        this.f3432d.a();
    }

    public final synchronized void a(TencentLocation tencentLocation) {
        this.f3431c.add(a.a(tencentLocation));
        if (this.f3431c.size() > this.f3429a) {
            this.f3431c.removeFirst();
        }
    }

    public final synchronized void a(Ob ob) {
        double d2;
        double d3;
        long j;
        C0473vb c0473vb = this;
        synchronized (this) {
            try {
                if (!ob.getProvider().equalsIgnoreCase("gps") || Ha.a().d("gps_kalman")) {
                    if (c0473vb.f3431c.size() == 0) {
                        return;
                    }
                    _a _aVar = c0473vb.f3432d;
                    double latitude = ob.getLatitude();
                    double longitude = ob.getLongitude();
                    double accuracy = ob.getAccuracy();
                    long time = ob.getTime();
                    if (accuracy < 1.0d) {
                        accuracy = 1.0d;
                    }
                    if (time - _aVar.f3074c >= 20000) {
                        _aVar.a();
                    }
                    _aVar.f3072a = (float) (Math.abs(latitude - _aVar.f3075d) * 1000000.0d);
                    _aVar.f3073b = (float) (Math.abs(longitude - _aVar.f3076e) * 1000000.0d);
                    if (_aVar.f3077f < 0.0d) {
                        _aVar.f3074c = time;
                        _aVar.f3075d = latitude;
                        _aVar.f3076e = longitude;
                        _aVar.f3077f = accuracy * accuracy;
                    } else {
                        long j2 = time - _aVar.f3074c;
                        if (j2 < 1000) {
                            j2 = 1000;
                        }
                        if (j2 > 0) {
                            try {
                                double d4 = _aVar.f3077f;
                                double d5 = j2;
                                Double.isNaN(d5);
                                _aVar.f3077f = d4 + d5;
                                double d6 = _aVar.g;
                                Double.isNaN(d5);
                                _aVar.g = d6 + d5;
                            } catch (Throwable th) {
                                th = th;
                            }
                        }
                        double d7 = _aVar.f3077f;
                        double d8 = accuracy * accuracy;
                        double d9 = _aVar.f3077f + d8;
                        double d10 = accuracy;
                        double d11 = _aVar.f3072a * 5.0f;
                        Double.isNaN(d11);
                        double d12 = d7 / (d9 + d11);
                        double d13 = _aVar.g;
                        double d14 = _aVar.g + d8;
                        double d15 = _aVar.f3073b * 5.0f;
                        Double.isNaN(d15);
                        double d16 = d13 / (d14 + d15);
                        if (d12 >= 0.4d && d16 >= 0.4d) {
                            double d17 = _aVar.f3075d;
                            if ((_aVar.h <= 0.0d || latitude - _aVar.f3075d <= 0.0d) && (_aVar.h >= 0.0d || latitude - _aVar.f3075d >= 0.0d)) {
                                d2 = longitude;
                                d3 = d16;
                            } else {
                                double d18 = _aVar.f3075d;
                                d3 = d16;
                                double d19 = _aVar.h;
                                d2 = longitude;
                                double d20 = j2 / 1000;
                                Double.isNaN(d20);
                                _aVar.f3075d = d18 + (d19 * d20);
                            }
                            _aVar.f3075d += (latitude - _aVar.f3075d) * d12;
                            double d21 = _aVar.f3075d - d17;
                            double d22 = j2 / 1000;
                            Double.isNaN(d22);
                            _aVar.h = d21 / d22;
                            double d23 = _aVar.f3076e;
                            if ((_aVar.i > 0.0d && d2 - _aVar.f3076e > 0.0d) || (_aVar.i < 0.0d && d2 - _aVar.f3076e < 0.0d)) {
                                double d24 = _aVar.f3076e;
                                double d25 = _aVar.i;
                                double d26 = j2 / 1000;
                                Double.isNaN(d26);
                                _aVar.f3076e = d24 + (d25 * d26);
                            }
                            _aVar.f3076e += (d2 - _aVar.f3076e) * d3;
                            double d27 = _aVar.f3076e - d23;
                            double d28 = j2 / 1000;
                            Double.isNaN(d28);
                            _aVar.i = d27 / d28;
                            _aVar.f3077f = (1.0d - d12) * _aVar.f3077f;
                            _aVar.g = (1.0d - d3) * _aVar.g;
                            j = time;
                            _aVar.f3074c = j;
                        } else {
                            d2 = longitude;
                            d3 = d16;
                            j = time;
                            if ((_aVar.h > 0.0d && latitude - _aVar.f3075d > 0.0d) || (_aVar.h < 0.0d && latitude - _aVar.f3075d < 0.0d)) {
                                double d29 = _aVar.f3075d;
                                double d30 = _aVar.h;
                                double d31 = j2 / 1000;
                                Double.isNaN(d31);
                                _aVar.f3075d = d29 + (d30 * d31);
                            }
                            if ((_aVar.i > 0.0d && d2 - _aVar.f3076e > 0.0d) || (_aVar.i < 0.0d && d2 - _aVar.f3076e < 0.0d)) {
                                double d32 = _aVar.f3076e;
                                double d33 = _aVar.i;
                                double d34 = j2 / 1000;
                                Double.isNaN(d34);
                                _aVar.f3076e = d32 + (d33 * d34);
                            }
                            double d35 = _aVar.f3077f;
                            double d36 = j2;
                            Double.isNaN(d36);
                            _aVar.f3077f = d35 - d36;
                            double d37 = _aVar.g;
                            Double.isNaN(d36);
                            _aVar.g = d37 - d36;
                        }
                        if (d10 == 30.0d && d12 >= 0.5d && d3 >= 0.5d) {
                            _aVar.f3075d = latitude;
                            _aVar.f3076e = d2;
                            _aVar.h = 0.0d;
                            _aVar.i = 0.0d;
                            _aVar.f3074c = j;
                            _aVar.f3077f = d8;
                        }
                        c0473vb = this;
                    }
                    double d38 = c0473vb.f3432d.f3075d;
                    double d39 = c0473vb.f3432d.f3076e;
                    Jb jb = ob.f2970b;
                    double dRound = Math.round(d38 * 1000000.0d);
                    Double.isNaN(dRound);
                    jb.f2936a = dRound / 1000000.0d;
                    Jb jb2 = ob.f2970b;
                    double dRound2 = Math.round(d39 * 1000000.0d);
                    Double.isNaN(dRound2);
                    jb2.f2937b = dRound2 / 1000000.0d;
                    return;
                }
                return;
            } catch (Throwable th2) {
                th = th2;
            }
            throw th;
        }
    }

    final synchronized boolean a(a aVar, C0423eb c0423eb, boolean z) {
        if (c0423eb != null) {
            if (this.f3431c != null && this.f3431c.size() != 0) {
                if (aVar.f3437e == 3) {
                    return true;
                }
                if (aVar.f3437e == 1 && !Xb.a(c0423eb) && !Xb.b(c0423eb) && !z) {
                    return true;
                }
                if (aVar.f3435c - this.f3431c.getLast().f3435c > 120000) {
                    this.f3431c.clear();
                    return true;
                }
                if (this.f3431c.size() >= this.f3430b) {
                    ListIterator<a> listIterator = this.f3431c.listIterator(this.f3431c.size());
                    int i = 0;
                    int i2 = 0;
                    while (listIterator.hasPrevious()) {
                        a aVarPrevious = listIterator.previous();
                        double dA = Vb.a(aVarPrevious.f3433a, aVarPrevious.f3434b, aVar.f3433a, aVar.f3434b);
                        double dAbs = Math.abs(aVarPrevious.f3435c - aVar.f3435c) + 1;
                        Double.isNaN(dAbs);
                        if (!(dA / (dAbs / 1000.0d) <= 100.0d)) {
                            i++;
                        }
                        i2++;
                        if (i2 > this.f3430b) {
                            break;
                        }
                    }
                    if (i > 1) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }
}
