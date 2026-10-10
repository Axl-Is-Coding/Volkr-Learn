package com.uc.crashsdk.a;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f20495a = !e.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f20497c;

    public e(int i) {
        this.f20496b = i;
        this.f20497c = null;
    }

    public final boolean a() {
        int i = this.f20496b;
        if (i == 451 || i == 452) {
            return com.uc.crashsdk.e.b(this.f20496b, this.f20497c);
        }
        switch (i) {
            case 351:
            case 352:
            case 353:
            case 354:
                return h.b(i, this.f20497c);
            default:
                switch (i) {
                    case 751:
                    case 752:
                    case 753:
                        return com.uc.crashsdk.f.a(i, this.f20497c);
                    default:
                        a.d("crashsdk", "Unknown sync runnable: " + toString());
                        if (f20495a) {
                            return false;
                        }
                        throw new AssertionError();
                }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.f20496b;
        if (i == 10) {
            f.a(i, this.f20497c);
            return;
        }
        if (i == 500) {
            d.a(i);
            return;
        }
        if (i == 700) {
            com.uc.crashsdk.f.b(i);
            return;
        }
        if (i == 800) {
            g.a(i);
            return;
        }
        if (i == 201 || i == 202) {
            com.uc.crashsdk.a.a(this.f20496b);
            return;
        }
        switch (i) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
                com.uc.crashsdk.b.a(i);
                return;
            default:
                switch (i) {
                    case 301:
                    case 302:
                    case 303:
                        h.a(i, this.f20497c);
                        return;
                    default:
                        switch (i) {
                            case 401:
                            case 402:
                            case 403:
                                break;
                            default:
                                switch (i) {
                                    case 405:
                                    case 406:
                                    case 407:
                                    case 408:
                                    case 409:
                                    case 410:
                                    case 411:
                                    case 412:
                                    case 413:
                                    case 414:
                                    case 415:
                                    case 416:
                                        break;
                                    default:
                                        a.d("crashsdk", "Unknown async runnable: " + toString());
                                        if (!f20495a) {
                                            throw new AssertionError();
                                        }
                                        return;
                                }
                                break;
                        }
                        com.uc.crashsdk.e.a(this.f20496b, this.f20497c);
                        return;
                }
        }
    }

    public String toString() {
        return super.toString() + "@action_" + this.f20496b;
    }

    public e(int i, Object[] objArr) {
        this.f20496b = i;
        this.f20497c = objArr;
    }
}
