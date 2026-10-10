package com.google.common.base;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: Joiner.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13747a;

    /* JADX INFO: compiled from: Joiner.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f13748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13749b;

        /* synthetic */ a(h hVar, String str, g gVar) {
            this(hVar, str);
        }

        public StringBuilder a(StringBuilder sb, Map<?, ?> map) {
            a(sb, map.entrySet());
            return sb;
        }

        private a(h hVar, String str) {
            this.f13748a = hVar;
            m.a(str);
            this.f13749b = str;
        }

        public <A extends Appendable> A a(A a2, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            m.a(a2);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a2.append(this.f13748a.a(next.getKey()));
                a2.append(this.f13749b);
                a2.append(this.f13748a.a(next.getValue()));
                while (it.hasNext()) {
                    a2.append(this.f13748a.f13747a);
                    Map.Entry<?, ?> next2 = it.next();
                    a2.append(this.f13748a.a(next2.getKey()));
                    a2.append(this.f13749b);
                    a2.append(this.f13748a.a(next2.getValue()));
                }
            }
            return a2;
        }

        public StringBuilder a(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            a(sb, iterable.iterator());
            return sb;
        }

        public StringBuilder a(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                a(sb, it);
                return sb;
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* synthetic */ h(h hVar, g gVar) {
        this(hVar);
    }

    public h b(String str) {
        m.a(str);
        return new g(this, this, str);
    }

    public a c(String str) {
        return new a(this, str, null);
    }

    private h(String str) {
        m.a(str);
        this.f13747a = str;
    }

    public static h a(String str) {
        return new h(str);
    }

    public static h a(char c2) {
        return new h(String.valueOf(c2));
    }

    private h(h hVar) {
        this.f13747a = hVar.f13747a;
    }

    public <A extends Appendable> A a(A a2, Iterator<?> it) throws IOException {
        m.a(a2);
        if (it.hasNext()) {
            a2.append(a(it.next()));
            while (it.hasNext()) {
                a2.append(this.f13747a);
                a2.append(a(it.next()));
            }
        }
        return a2;
    }

    public final StringBuilder a(StringBuilder sb, Iterable<?> iterable) {
        a(sb, iterable.iterator());
        return sb;
    }

    public final StringBuilder a(StringBuilder sb, Iterator<?> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String a(Iterable<?> iterable) {
        return a(iterable.iterator());
    }

    public final String a(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        a(sb, it);
        return sb.toString();
    }

    public final String a(Object[] objArr) {
        return a((Iterable<?>) Arrays.asList(objArr));
    }

    CharSequence a(Object obj) {
        m.a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
