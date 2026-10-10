package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.i;
import java.util.ArrayList;

/* JADX INFO: compiled from: CompositeDisposable.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements b, io.reactivex.internal.disposables.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    i<b> f21771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f21772b;

    @Override // io.reactivex.internal.disposables.a
    public boolean a(b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean b(b bVar) {
        io.reactivex.internal.functions.a.a(bVar, "disposable is null");
        if (!this.f21772b) {
            synchronized (this) {
                if (!this.f21772b) {
                    i<b> iVar = this.f21771a;
                    if (iVar == null) {
                        iVar = new i<>();
                        this.f21771a = iVar;
                    }
                    iVar.a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.a
    public boolean c(b bVar) {
        io.reactivex.internal.functions.a.a(bVar, "disposables is null");
        if (this.f21772b) {
            return false;
        }
        synchronized (this) {
            if (this.f21772b) {
                return false;
            }
            i<b> iVar = this.f21771a;
            if (iVar != null && iVar.b(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f21772b) {
            return;
        }
        synchronized (this) {
            if (this.f21772b) {
                return;
            }
            this.f21772b = true;
            i<b> iVar = this.f21771a;
            this.f21771a = null;
            a(iVar);
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f21772b;
    }

    public int a() {
        if (this.f21772b) {
            return 0;
        }
        synchronized (this) {
            if (this.f21772b) {
                return 0;
            }
            i<b> iVar = this.f21771a;
            return iVar != null ? iVar.c() : 0;
        }
    }

    void a(i<b> iVar) {
        if (iVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : iVar.a()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw ExceptionHelper.b((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }
}
