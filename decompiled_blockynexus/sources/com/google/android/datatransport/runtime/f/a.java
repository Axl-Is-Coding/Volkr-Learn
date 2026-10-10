package com.google.android.datatransport.runtime.f;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.EnumMap;

/* JADX INFO: compiled from: PriorityMapping.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SparseArray<Priority> f12944a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static EnumMap<Priority, Integer> f12945b = new EnumMap<>(Priority.class);

    static {
        f12945b.put(Priority.DEFAULT, 0);
        f12945b.put(Priority.VERY_LOW, 1);
        f12945b.put(Priority.HIGHEST, 2);
        for (K k : f12945b.keySet()) {
            f12944a.append(f12945b.get(k).intValue(), k);
        }
    }

    public static Priority a(int i) {
        Priority priority = f12944a.get(i);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i);
    }

    public static int a(Priority priority) {
        Integer num = f12945b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }
}
