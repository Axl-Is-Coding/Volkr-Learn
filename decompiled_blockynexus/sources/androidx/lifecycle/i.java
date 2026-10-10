package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: LifecycleRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends Lifecycle {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference<g> f1601d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.arch.core.b.a<f, a> f1599b = new androidx.arch.core.b.a<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1602e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1603f = false;
    private boolean g = false;
    private ArrayList<Lifecycle.State> h = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Lifecycle.State f1600c = Lifecycle.State.INITIALIZED;

    /* JADX INFO: compiled from: LifecycleRegistry.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Lifecycle.State f1604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e f1605b;

        a(f fVar, Lifecycle.State state) {
            this.f1605b = Lifecycling.a(fVar);
            this.f1604a = state;
        }

        void a(g gVar, Lifecycle.Event event) {
            Lifecycle.State stateA = i.a(event);
            this.f1604a = i.a(this.f1604a, stateA);
            this.f1605b.a(gVar, event);
            this.f1604a = stateA;
        }
    }

    public i(g gVar) {
        this.f1601d = new WeakReference<>(gVar);
    }

    private Lifecycle.State c(f fVar) {
        Map.Entry<f, a> entryB = this.f1599b.b(fVar);
        Lifecycle.State state = null;
        Lifecycle.State state2 = entryB != null ? entryB.getValue().f1604a : null;
        if (!this.h.isEmpty()) {
            state = this.h.get(r0.size() - 1);
        }
        return a(a(this.f1600c, state2), state);
    }

    private void d(Lifecycle.State state) {
        if (this.f1600c == state) {
            return;
        }
        this.f1600c = state;
        if (this.f1603f || this.f1602e != 0) {
            this.g = true;
            return;
        }
        this.f1603f = true;
        d();
        this.f1603f = false;
    }

    private void e(Lifecycle.State state) {
        this.h.add(state);
    }

    private static Lifecycle.Event f(Lifecycle.State state) {
        int i = h.f1598b[state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return Lifecycle.Event.ON_START;
            }
            if (i == 3) {
                return Lifecycle.Event.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + state);
            }
        }
        return Lifecycle.Event.ON_CREATE;
    }

    @Deprecated
    public void a(Lifecycle.State state) {
        b(state);
    }

    public void b(Lifecycle.State state) {
        d(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(f fVar) {
        g gVar;
        Lifecycle.State state = this.f1600c;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        a aVar = new a(fVar, state2);
        if (this.f1599b.b(fVar, aVar) == null && (gVar = this.f1601d.get()) != null) {
            boolean z = this.f1602e != 0 || this.f1603f;
            Lifecycle.State stateC = c(fVar);
            this.f1602e++;
            while (aVar.f1604a.compareTo(stateC) < 0 && this.f1599b.contains(fVar)) {
                e(aVar.f1604a);
                aVar.a(gVar, f(aVar.f1604a));
                c();
                stateC = c(fVar);
            }
            if (!z) {
                d();
            }
            this.f1602e--;
        }
    }

    public void b(Lifecycle.Event event) {
        d(a(event));
    }

    private boolean b() {
        if (this.f1599b.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.f1599b.a().getValue().f1604a;
        Lifecycle.State state2 = this.f1599b.e().getValue().f1604a;
        return state == state2 && this.f1600c == state2;
    }

    private void c() {
        this.h.remove(r0.size() - 1);
    }

    private static Lifecycle.Event c(Lifecycle.State state) {
        int i = h.f1598b[state.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        }
        if (i == 2) {
            return Lifecycle.Event.ON_DESTROY;
        }
        if (i == 3) {
            return Lifecycle.Event.ON_STOP;
        }
        if (i == 4) {
            return Lifecycle.Event.ON_PAUSE;
        }
        if (i != 5) {
            throw new IllegalArgumentException("Unexpected state value " + state);
        }
        throw new IllegalArgumentException();
    }

    private void d() {
        g gVar = this.f1601d.get();
        if (gVar != null) {
            while (!b()) {
                this.g = false;
                if (this.f1600c.compareTo(this.f1599b.a().getValue().f1604a) < 0) {
                    a(gVar);
                }
                Map.Entry<f, a> entryE = this.f1599b.e();
                if (!this.g && entryE != null && this.f1600c.compareTo(entryE.getValue().f1604a) > 0) {
                    b(gVar);
                }
            }
            this.g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    @Override // androidx.lifecycle.Lifecycle
    public void b(f fVar) {
        this.f1599b.remove(fVar);
    }

    private void b(g gVar) {
        androidx.arch.core.b.b<f, a>.d dVarC = this.f1599b.c();
        while (dVarC.hasNext() && !this.g) {
            Map.Entry next = dVarC.next();
            a aVar = (a) next.getValue();
            while (aVar.f1604a.compareTo(this.f1600c) < 0 && !this.g && this.f1599b.contains((f) next.getKey())) {
                e(aVar.f1604a);
                aVar.a(gVar, f(aVar.f1604a));
                c();
            }
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State a() {
        return this.f1600c;
    }

    static Lifecycle.State a(Lifecycle.Event event) {
        switch (h.f1597a[event.ordinal()]) {
            case 1:
            case 2:
                return Lifecycle.State.CREATED;
            case 3:
            case 4:
                return Lifecycle.State.STARTED;
            case 5:
                return Lifecycle.State.RESUMED;
            case 6:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    private void a(g gVar) {
        Iterator<Map.Entry<f, a>> itDescendingIterator = this.f1599b.descendingIterator();
        while (itDescendingIterator.hasNext() && !this.g) {
            Map.Entry<f, a> next = itDescendingIterator.next();
            a value = next.getValue();
            while (value.f1604a.compareTo(this.f1600c) > 0 && !this.g && this.f1599b.contains(next.getKey())) {
                Lifecycle.Event eventC = c(value.f1604a);
                e(a(eventC));
                value.a(gVar, eventC);
                c();
            }
        }
    }

    static Lifecycle.State a(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }
}
