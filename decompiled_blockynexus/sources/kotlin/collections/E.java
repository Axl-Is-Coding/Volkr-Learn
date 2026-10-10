package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Sets.kt */
/* JADX INFO: loaded from: classes5.dex */
public class E extends D {
    public static final <T> Set<T> a() {
        return EmptySet.INSTANCE;
    }

    public static <T> Set<T> a(T... tArr) {
        kotlin.jvm.internal.i.b(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length > 0 ? i.d(tArr) : a();
    }
}
