package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayDeque<c> f180b;

    private class LifecycleOnBackPressedCancellable implements androidx.activity.a, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Lifecycle f181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private androidx.activity.a f183c;

        LifecycleOnBackPressedCancellable(Lifecycle lifecycle, c cVar) {
            this.f181a = lifecycle;
            this.f182b = cVar;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.e
        public void a(g gVar, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.f183c = OnBackPressedDispatcher.this.addCancellableCallback(this.f182b);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar = this.f183c;
                if (aVar != null) {
                    aVar.cancel();
                }
            }
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f181a.b(this);
            this.f182b.b(this);
            androidx.activity.a aVar = this.f183c;
            if (aVar != null) {
                aVar.cancel();
                this.f183c = null;
            }
        }
    }

    private class a implements androidx.activity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f185a;

        a(c cVar) {
            this.f185a = cVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f180b.remove(this.f185a);
            this.f185a.b(this);
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    public void a() {
        Iterator<c> itDescendingIterator = this.f180b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            c next = itDescendingIterator.next();
            if (next.b()) {
                next.a();
                return;
            }
        }
        Runnable runnable = this.f179a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addCallback(c cVar) {
        addCancellableCallback(cVar);
    }

    androidx.activity.a addCancellableCallback(c cVar) {
        this.f180b.add(cVar);
        a aVar = new a(cVar);
        cVar.a(aVar);
        return aVar;
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f180b = new ArrayDeque<>();
        this.f179a = runnable;
    }

    public void addCallback(g gVar, c cVar) {
        Lifecycle lifecycle = gVar.getLifecycle();
        if (lifecycle.a() == Lifecycle.State.DESTROYED) {
            return;
        }
        cVar.a(new LifecycleOnBackPressedCancellable(lifecycle, cVar));
    }
}
