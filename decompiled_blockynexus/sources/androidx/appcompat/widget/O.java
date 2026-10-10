package androidx.appcompat.widget;

/* JADX INFO: compiled from: RtlSpacingHelper.java */
/* JADX INFO: loaded from: classes.dex */
class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f563a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f564b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f565c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f566d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f567e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f568f = 0;
    private boolean g = false;
    private boolean h = false;

    O() {
    }

    public int a() {
        return this.g ? this.f563a : this.f564b;
    }

    public int b() {
        return this.f563a;
    }

    public int c() {
        return this.f564b;
    }

    public int d() {
        return this.g ? this.f564b : this.f563a;
    }

    public void a(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.f567e = i;
            this.f563a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f568f = i2;
            this.f564b = i2;
        }
    }

    public void b(int i, int i2) {
        this.f565c = i;
        this.f566d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f563a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f564b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f563a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f564b = i2;
        }
    }

    public void a(boolean z) {
        if (z == this.g) {
            return;
        }
        this.g = z;
        if (!this.h) {
            this.f563a = this.f567e;
            this.f564b = this.f568f;
            return;
        }
        if (z) {
            int i = this.f566d;
            if (i == Integer.MIN_VALUE) {
                i = this.f567e;
            }
            this.f563a = i;
            int i2 = this.f565c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f568f;
            }
            this.f564b = i2;
            return;
        }
        int i3 = this.f565c;
        if (i3 == Integer.MIN_VALUE) {
            i3 = this.f567e;
        }
        this.f563a = i3;
        int i4 = this.f566d;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f568f;
        }
        this.f564b = i4;
    }
}
