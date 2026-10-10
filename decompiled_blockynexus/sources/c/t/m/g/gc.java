package c.t.m.g;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte f3217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte f3218f;
    private String[] g;

    public gc() {
        this.f3213a = "";
        this.f3214b = -1;
        this.f3215c = -1;
        this.f3216d = -1;
        this.f3218f = (byte) 1;
    }

    public gc(String str) {
        this.f3213a = "";
        this.f3214b = -1;
        this.f3215c = -1;
        this.f3216d = -1;
        this.f3218f = (byte) 1;
        this.f3213a = str;
        this.f3214b = -1;
    }

    public final String a() {
        return this.f3213a + ":" + this.f3214b;
    }

    public final boolean a(gc gcVar) {
        return gcVar != null && this.f3213a.equals(gcVar.f3213a) && this.f3214b == gcVar.f3214b;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.g = str.split(":");
        String[] strArr = this.g;
        if (strArr.length != 2) {
            return false;
        }
        this.f3213a = strArr[0];
        if (!C0455pa.d(this.f3213a)) {
            return false;
        }
        try {
            this.f3214b = Integer.parseInt(this.g[1]);
            if (this.f3214b >= 0) {
                if (this.f3214b <= 65535) {
                    return true;
                }
            }
            return false;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean b() {
        return this.f3217e == 3;
    }

    public final String toString() {
        return this.f3213a + ":" + this.f3214b + ",protocalType:" + ((int) this.f3218f) + ",ipType:" + ((int) this.f3217e);
    }
}
