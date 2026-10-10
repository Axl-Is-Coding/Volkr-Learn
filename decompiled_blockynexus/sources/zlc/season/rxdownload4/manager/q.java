package zlc.season.rxdownload4.manager;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: Status.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class q {
    public static final boolean a(p pVar) {
        kotlin.jvm.internal.i.b(pVar, "$this$isEndStatus");
        if ((pVar instanceof C2959h) || (pVar instanceof l) || (pVar instanceof o) || (pVar instanceof C2955d)) {
            return false;
        }
        if ((pVar instanceof k) || (pVar instanceof C2953b) || (pVar instanceof C2958g) || (pVar instanceof C2954c)) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }
}
