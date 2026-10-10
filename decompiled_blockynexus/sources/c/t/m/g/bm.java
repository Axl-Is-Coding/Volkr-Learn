package c.t.m.g;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class bm extends LinkedHashMap<String, String> {
    bm() {
        super(8, 1.0f, true);
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry<String, String> entry) {
        return size() > 8;
    }
}
