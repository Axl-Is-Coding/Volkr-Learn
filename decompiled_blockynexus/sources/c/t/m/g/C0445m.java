package c.t.m.g;

import android.os.Build;
import c.t.m.g.qc;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: c.t.m.g.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0445m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    URL f3300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f3301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3302f;
    public String g;

    public C0445m(URL url, String str) {
        this.f3297a = qc.a.a("direct_access_use_schedule", 0, 1, 1) == 1;
        this.f3298b = qc.a.a("direct_https_use_sche", 0, 1, 1) == 1;
        this.f3299c = qc.a.a("direct_access_domain_try_times", 1, 8, 2);
        this.g = "";
        this.f3300d = url;
        this.f3301e = str;
    }

    public final List<gc> a(boolean z, boolean z2) {
        gc gcVar = new gc(this.f3300d.getHost());
        int i = 3;
        gcVar.f3217e = (byte) 3;
        try {
            ArrayList arrayList = new ArrayList();
            if (!z) {
                arrayList.add(gcVar);
                gcVar.f3215c = 1;
                return arrayList;
            }
            if (!qc.i() && this.f3297a && (!z2 || this.f3298b)) {
                if (!z2 || Build.VERSION.SDK_INT > 18) {
                    oc ocVarA = C0439k.a(this.f3300d.getHost());
                    List<gc> list = ocVarA.f3335c;
                    this.f3302f = ocVarA.f3336d;
                    this.g = ocVarA.f3334b;
                    return list;
                }
                for (int i2 = 0; i2 < this.f3299c; i2++) {
                    arrayList.add(gcVar);
                }
                gcVar.f3215c = 10;
                return arrayList;
            }
            for (int i3 = 0; i3 < this.f3299c; i3++) {
                arrayList.add(gcVar);
            }
            if (qc.i()) {
                i = 2;
            } else if (this.f3297a) {
                i = 4;
            }
            gcVar.f3215c = i;
            return arrayList;
        } catch (Exception unused) {
            ArrayList arrayList2 = new ArrayList();
            for (int i4 = 0; i4 < this.f3299c; i4++) {
                arrayList2.add(gcVar);
            }
            gcVar.f3215c = 8;
            return arrayList2;
        }
    }
}
