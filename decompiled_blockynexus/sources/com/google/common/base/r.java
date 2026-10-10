package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Splitter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f13758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f13760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13761d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Splitter.java */
    static abstract class a extends AbstractIterator<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CharSequence f13762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final c f13763d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f13764e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f13765f = 0;
        int g;

        protected a(r rVar, CharSequence charSequence) {
            this.f13763d = rVar.f13758a;
            this.f13764e = rVar.f13759b;
            this.g = rVar.f13761d;
            this.f13762c = charSequence;
        }

        abstract int a(int i);

        abstract int b(int i);

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.AbstractIterator
        public String a() {
            int iB;
            int i = this.f13765f;
            while (true) {
                int i2 = this.f13765f;
                if (i2 == -1) {
                    return b();
                }
                iB = b(i2);
                if (iB == -1) {
                    iB = this.f13762c.length();
                    this.f13765f = -1;
                } else {
                    this.f13765f = a(iB);
                }
                int i3 = this.f13765f;
                if (i3 == i) {
                    this.f13765f = i3 + 1;
                    if (this.f13765f >= this.f13762c.length()) {
                        this.f13765f = -1;
                    }
                } else {
                    while (i < iB && this.f13763d.c(this.f13762c.charAt(i))) {
                        i++;
                    }
                    while (iB > i && this.f13763d.c(this.f13762c.charAt(iB - 1))) {
                        iB--;
                    }
                    if (!this.f13764e || i != iB) {
                        break;
                    }
                    i = this.f13765f;
                }
            }
            int i4 = this.g;
            if (i4 == 1) {
                iB = this.f13762c.length();
                this.f13765f = -1;
                while (iB > i && this.f13763d.c(this.f13762c.charAt(iB - 1))) {
                    iB--;
                }
            } else {
                this.g = i4 - 1;
            }
            return this.f13762c.subSequence(i, iB).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Splitter.java */
    interface b {
        Iterator<String> a(r rVar, CharSequence charSequence);
    }

    private r(b bVar) {
        this(bVar, false, c.n, Integer.MAX_VALUE);
    }

    private r(b bVar, boolean z, c cVar, int i) {
        this.f13760c = bVar;
        this.f13759b = z;
        this.f13758a = cVar;
        this.f13761d = i;
    }

    public static r a(char c2) {
        return a(c.b(c2));
    }

    public r b(c cVar) {
        m.a(cVar);
        return new r(this.f13760c, this.f13759b, cVar, this.f13761d);
    }

    public static r a(c cVar) {
        m.a(cVar);
        return new r(new q(cVar));
    }

    private Iterator<String> b(CharSequence charSequence) {
        return this.f13760c.a(this, charSequence);
    }

    public r a() {
        return b(c.f13733a);
    }

    public List<String> a(CharSequence charSequence) {
        m.a(charSequence);
        Iterator<String> itB = b(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itB.hasNext()) {
            arrayList.add(itB.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
