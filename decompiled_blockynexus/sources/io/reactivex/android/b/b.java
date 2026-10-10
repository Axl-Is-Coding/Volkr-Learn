package io.reactivex.android.b;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.x;

/* JADX INFO: compiled from: AndroidSchedulers.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final x f21760a = io.reactivex.android.a.a.b(new io.reactivex.android.b.a());

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AndroidSchedulers.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x f21761a = new c(new Handler(Looper.getMainLooper()), false);
    }

    public static x a() {
        return io.reactivex.android.a.a.a(f21760a);
    }
}
