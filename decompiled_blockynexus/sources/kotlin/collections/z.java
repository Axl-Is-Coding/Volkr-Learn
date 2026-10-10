package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: MapsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class z extends y {
    public static <K, V> Map<K, V> a(Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.i.b(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        kotlin.jvm.internal.i.a((Object) mapSingletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return mapSingletonMap;
    }
}
