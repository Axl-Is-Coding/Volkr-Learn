package c.t.m.g;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: renamed from: c.t.m.g.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0412b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f3092a;

    /* JADX INFO: renamed from: c.t.m.g.b$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final C0412b f3093a = new C0412b(0);
    }

    private C0412b() {
        this.f3092a = (ThreadPoolExecutor) Executors.newCachedThreadPool(new hc("halley_" + fc.c() + "_BusinessTaskPool"));
    }

    /* synthetic */ C0412b(byte b2) {
        this();
    }
}
