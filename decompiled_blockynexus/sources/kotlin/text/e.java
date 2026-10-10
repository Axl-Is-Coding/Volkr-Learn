package kotlin.text;

import java.util.Iterator;
import kotlin.Pair;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes5.dex */
final class e implements kotlin.e.a<kotlin.d.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f22868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.jvm.a.c<CharSequence, Integer, Pair<Integer, Integer>> f22871d;

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence charSequence, int i, int i2, kotlin.jvm.a.c<? super CharSequence, ? super Integer, Pair<Integer, Integer>> cVar) {
        kotlin.jvm.internal.i.b(charSequence, "input");
        kotlin.jvm.internal.i.b(cVar, "getNextMatch");
        this.f22868a = charSequence;
        this.f22869b = i;
        this.f22870c = i2;
        this.f22871d = cVar;
    }

    @Override // kotlin.e.a
    public Iterator<kotlin.d.d> iterator() {
        return new d(this);
    }
}
