package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes5.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i) {
        super(i);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        io.reactivex.disposables.b andSet;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                io.reactivex.disposables.b bVar = get(i);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (bVar != disposableHelper && (andSet = getAndSet(i, disposableHelper)) != DisposableHelper.DISPOSED && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    public io.reactivex.disposables.b replaceResource(int i, io.reactivex.disposables.b bVar) {
        io.reactivex.disposables.b bVar2;
        do {
            bVar2 = get(i);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return null;
            }
        } while (!compareAndSet(i, bVar2, bVar));
        return bVar2;
    }

    public boolean setResource(int i, io.reactivex.disposables.b bVar) {
        io.reactivex.disposables.b bVar2;
        do {
            bVar2 = get(i);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return false;
            }
        } while (!compareAndSet(i, bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }
}
