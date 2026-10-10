package c.t.m.g;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static double[][] f2994a = {new double[]{53.540307d, 122.380829d}, new double[]{53.399707d, 120.821285d}, new double[]{52.749594d, 119.919891d}, new double[]{49.95122d, 116.580048d}, new double[]{47.901614d, 115.437469d}, new double[]{47.070122d, 118.381805d}, new double[]{45.213004d, 112.009735d}, new double[]{42.714732d, 107.83493d}, new double[]{42.779275d, 100.100555d}, new double[]{42.90816d, 96.49704d}, new double[]{44.43378d, 95.442352d}, new double[]{45.614037d, 91.091766d}, new double[]{47.606163d, 91.003876d}, new double[]{49.439557d, 87.180634d}, new double[]{47.398349d, 82.961884d}, new double[]{44.964798d, 79.753876d}, new double[]{42.358544d, 79.885712d}, new double[]{40.513799d, 73.689423d}, new double[]{36.5626d, 73.758774d}, new double[]{33.760882d, 76.457977d}, new double[]{31.989442d, 77.688446d}, new double[]{28.497661d, 84.280243d}, new double[]{27.166695d, 88.394279d}, new double[]{26.755421d, 92.118645d}, new double[]{27.936181d, 97.379379d}, new double[]{24.166802d, 97.115707d}, new double[]{21.350781d, 99.972153d}, new double[]{21.105d, 101.707993d}, new double[]{23.120154d, 105.355453d}, new double[]{21.915019d, 106.646605d}, new double[]{21.350781d, 107.684555d}, new double[]{16.762468d, 109.002914d}, new double[]{18.729502d, 111.174774d}, new double[]{21.2689d, 112.782211d}, new double[]{22.998852d, 117.176743d}, new double[]{25.019304d, 119.973391d}, new double[]{27.117813d, 120.890121d}, new double[]{27.76133d, 121.821041d}, new double[]{30.097613d, 123.451653d}, new double[]{33.155948d, 120.999985d}, new double[]{35.209722d, 120.143051d}, new double[]{36.914764d, 122.913322d}, new double[]{39.842286d, 124.273911d}, new double[]{41.294317d, 128.272934d}, new double[]{42.815551d, 131.197872d}, new double[]{45.02695d, 133.172836d}, new double[]{48.04871d, 135.040512d}, new double[]{48.618385d, 134.337387d}, new double[]{47.886881d, 131.700668d}, new double[]{49.196064d, 130.536118d}, new double[]{50.708634d, 127.613754d}, new double[]{53.13359d, 125.833969d}, new double[]{53.657661d, 123.329086d}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static double f2995b = 360.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static double f2996c = 360.0d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static double f2997d = -360.0d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static double f2998e = -360.0d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static List<a> f2999f = new ArrayList();

    /* JADX INFO: compiled from: TL */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f3000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f3001b;

        public a(double d2, double d3) {
            this.f3000a = d2;
            this.f3001b = d3;
        }
    }

    static {
        a();
    }

    private static void a() {
        int i = 0;
        while (true) {
            double[][] dArr = f2994a;
            if (i >= dArr.length) {
                return;
            }
            double d2 = dArr[i][0];
            double d3 = dArr[i][1];
            if (d2 < f2996c) {
                f2996c = d2;
            }
            if (d2 > f2998e) {
                f2998e = d2;
            }
            if (d3 < f2995b) {
                f2995b = d3;
            }
            if (d3 > f2997d) {
                f2997d = d3;
            }
            f2999f.add(new a(d2, d3));
            i++;
        }
    }

    public static boolean a(double d2, double d3) {
        if (d2 < f2996c || d3 < f2995b || d2 > f2998e || d3 > f2997d) {
            return false;
        }
        a aVar = f2999f.get(0);
        int size = f2999f.size();
        a aVar2 = aVar;
        int i = 1;
        int i2 = 0;
        while (i <= size) {
            a aVar3 = f2999f.get(i % size);
            if (d2 > Math.min(aVar2.f3000a, aVar3.f3000a) && d2 <= Math.max(aVar2.f3000a, aVar3.f3000a) && d3 <= Math.max(aVar2.f3001b, aVar3.f3001b) && Math.abs(aVar2.f3000a - aVar3.f3000a) >= 1.0E-8d) {
                double d4 = aVar2.f3000a;
                double d5 = aVar3.f3001b;
                double d6 = aVar2.f3001b;
                double d7 = (((d2 - d4) * (d5 - d6)) / (aVar3.f3000a - d4)) + d6;
                if (Math.abs(d6 - d5) < 1.0E-8d || d3 <= d7) {
                    i2++;
                }
            }
            i++;
            aVar2 = aVar3;
        }
        return i2 % 2 != 0;
    }
}
