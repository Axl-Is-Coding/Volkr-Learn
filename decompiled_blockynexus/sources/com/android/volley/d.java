package com.android.volley;

/* JADX INFO: compiled from: DefaultRetryPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f3995d;

    public d() {
        this(2500, 1, 1.0f);
    }

    @Override // com.android.volley.o
    public int a() {
        return this.f3993b;
    }

    @Override // com.android.volley.o
    public int b() {
        return this.f3992a;
    }

    protected boolean c() {
        return this.f3993b <= this.f3994c;
    }

    public d(int i, int i2, float f2) {
        this.f3992a = i;
        this.f3994c = i2;
        this.f3995d = f2;
    }

    @Override // com.android.volley.o
    public void a(VolleyError volleyError) throws VolleyError {
        this.f3993b++;
        int i = this.f3992a;
        this.f3992a = i + ((int) (i * this.f3995d));
        if (!c()) {
            throw volleyError;
        }
    }
}
