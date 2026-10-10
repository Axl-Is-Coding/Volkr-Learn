package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements Iterator<kotlin.d.d>, kotlin.jvm.internal.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22862a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f22863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f22864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private kotlin.d.d f22865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f22866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ e f22867f;

    d(e eVar) {
        this.f22867f = eVar;
        this.f22863b = kotlin.d.h.a(eVar.f22869b, 0, eVar.f22868a.length());
        this.f22864c = this.f22863b;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a() {
        /*
            r6 = this;
            int r0 = r6.f22864c
            r1 = 0
            if (r0 >= 0) goto Lc
            r6.f22862a = r1
            r0 = 0
            r6.f22865d = r0
            goto La2
        Lc:
            kotlin.text.e r0 = r6.f22867f
            int r0 = kotlin.text.e.c(r0)
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L25
            int r0 = r6.f22866e
            int r0 = r0 + r3
            r6.f22866e = r0
            int r0 = r6.f22866e
            kotlin.text.e r4 = r6.f22867f
            int r4 = kotlin.text.e.c(r4)
            if (r0 >= r4) goto L33
        L25:
            int r0 = r6.f22864c
            kotlin.text.e r4 = r6.f22867f
            java.lang.CharSequence r4 = kotlin.text.e.b(r4)
            int r4 = r4.length()
            if (r0 <= r4) goto L49
        L33:
            int r0 = r6.f22863b
            kotlin.d.d r1 = new kotlin.d.d
            kotlin.text.e r4 = r6.f22867f
            java.lang.CharSequence r4 = kotlin.text.e.b(r4)
            int r4 = kotlin.text.o.a(r4)
            r1.<init>(r0, r4)
            r6.f22865d = r1
            r6.f22864c = r2
            goto La0
        L49:
            kotlin.text.e r0 = r6.f22867f
            kotlin.jvm.a.c r0 = kotlin.text.e.a(r0)
            kotlin.text.e r4 = r6.f22867f
            java.lang.CharSequence r4 = kotlin.text.e.b(r4)
            int r5 = r6.f22864c
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.invoke(r4, r5)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L79
            int r0 = r6.f22863b
            kotlin.d.d r1 = new kotlin.d.d
            kotlin.text.e r4 = r6.f22867f
            java.lang.CharSequence r4 = kotlin.text.e.b(r4)
            int r4 = kotlin.text.o.a(r4)
            r1.<init>(r0, r4)
            r6.f22865d = r1
            r6.f22864c = r2
            goto La0
        L79:
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.f22863b
            kotlin.d.d r4 = kotlin.d.e.d(r4, r2)
            r6.f22865d = r4
            int r2 = r2 + r0
            r6.f22863b = r2
            int r2 = r6.f22863b
            if (r0 != 0) goto L9d
            r1 = 1
        L9d:
            int r2 = r2 + r1
            r6.f22864c = r2
        La0:
            r6.f22862a = r3
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.d.a():void");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f22862a == -1) {
            a();
        }
        return this.f22862a == 1;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public kotlin.d.d next() {
        if (this.f22862a == -1) {
            a();
        }
        if (this.f22862a == 0) {
            throw new NoSuchElementException();
        }
        kotlin.d.d dVar = this.f22865d;
        if (dVar == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        this.f22865d = null;
        this.f22862a = -1;
        return dVar;
    }
}
