package c.t.m.g;

import java.util.Iterator;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Rb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3002a;

    Rb(String str) {
        this.f3002a = str;
    }

    final StringBuilder a(StringBuilder sb, Iterator<?> it) {
        Object next;
        if (it.hasNext() && (next = it.next()) != null) {
            sb.append(next.toString());
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(this.f3002a);
                sb.append(next2.toString());
            }
        }
        return sb;
    }
}
