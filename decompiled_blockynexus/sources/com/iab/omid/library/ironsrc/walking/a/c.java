package com.iab.omid.library.ironsrc.walking.a;

import com.iab.omid.library.ironsrc.walking.a.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class c implements b.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<b> f14567c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f14568d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Runnable> f14565a = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f14566b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f14565a);

    private void a() {
        this.f14568d = this.f14567c.poll();
        b bVar = this.f14568d;
        if (bVar != null) {
            bVar.a(this.f14566b);
        }
    }

    @Override // com.iab.omid.library.ironsrc.walking.a.b.a
    public void a(b bVar) {
        this.f14568d = null;
        a();
    }

    public void b(b bVar) {
        bVar.a(this);
        this.f14567c.add(bVar);
        if (this.f14568d == null) {
            a();
        }
    }
}
