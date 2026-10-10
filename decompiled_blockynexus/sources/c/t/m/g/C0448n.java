package c.t.m.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: c.t.m.g.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0448n extends AbstractC0442l {
    private static boolean p;
    public String A;
    private gc B;
    private String C;
    private String D;
    private boolean r;
    private int t;
    private r v;
    private C0457q w;
    private C0445m x;
    private boolean z;
    public boolean q = true;
    private boolean s = false;
    public int u = -1;
    private C0439k y = C0439k.a();

    public C0448n(String str, Map<String, String> map, byte[] bArr, int i, String str2, boolean z, String str3) {
        this.r = false;
        this.f3284b = str;
        this.f3285c = false;
        this.f3286d = map;
        this.f3287e = bArr;
        this.f3288f = i;
        this.g = str2;
        this.r = false;
        this.t = 0;
        this.z = z;
        this.C = str3;
    }

    public static C0448n a(String str, Map<String, String> map, byte[] bArr, int i, String str2) {
        return new C0448n(str, map, bArr, i, str2, false, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0124  */
    @Override // c.t.m.g.AbstractC0442l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final c.t.m.g.C0457q a() {
        /*
            Method dump skipped, instruction units count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.C0448n.a():c.t.m.g.q");
    }

    @Override // c.t.m.g.AbstractC0442l
    public final void a(boolean z) {
        r rVar = this.v;
        if (rVar != null) {
            if (this.i) {
                rVar.i = true;
            }
            HashMap map = new HashMap();
            if (z) {
                map.put("B46", "1");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(this.k);
                map.put("B22", sb.toString());
            }
            if (!C0455pa.a(this.A)) {
                map.put("B15", this.A);
            }
            if (!C0455pa.a(this.C)) {
                map.put("B54", this.C);
            }
            HashMap map2 = new HashMap();
            map2.put("B82", this.g);
            if (this.l != 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.l);
                map2.put("B83", sb2.toString());
            }
            map2.put("B44", this.f3283a);
            if (!TextUtils.isEmpty(this.f3283a) && !this.f3283a.equals(this.D)) {
                map2.put("B49", this.D);
            }
            gc gcVar = this.B;
            if (gcVar != null) {
                if (!gcVar.b()) {
                    map2.put("B10", this.B.a());
                }
                if (this.B.f3215c != -1) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.B.f3215c);
                    map2.put("B45", sb3.toString());
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append((int) this.B.f3217e);
                map2.put("B202", sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.B.f3216d);
                map2.put("B204", sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.s ? 1 : 0);
                map2.put("B203", sb6.toString());
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.o.get());
            map2.put("B53", sb7.toString());
            if (!TextUtils.isEmpty(this.x.g)) {
                map2.put("B26", this.x.g);
            }
            if (this.j) {
                map2.put("B97", "1");
            }
            if (this.u != -1) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(this.u);
                map2.put("B211", sb8.toString());
            }
            this.v.a(map, map2);
        }
    }
}
