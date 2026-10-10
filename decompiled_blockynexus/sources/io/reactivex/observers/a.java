package io.reactivex.observers;

import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.a;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: BaseTestConsumer.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T, U extends a<T, U>> implements io.reactivex.disposables.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f22741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Thread f22742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f22743f;
    protected int g;
    protected int h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final List<T> f22739b = new VolatileSizeArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final List<Throwable> f22740c = new VolatileSizeArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final CountDownLatch f22738a = new CountDownLatch(1);
}
