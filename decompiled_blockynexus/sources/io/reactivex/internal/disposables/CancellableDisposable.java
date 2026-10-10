package io.reactivex.internal.disposables;

import io.reactivex.b.f;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class CancellableDisposable extends AtomicReference<f> implements io.reactivex.disposables.b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f fVar) {
        super(fVar);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        f andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e2) {
            io.reactivex.exceptions.a.b(e2);
            io.reactivex.e.a.b(e2);
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == null;
    }
}
