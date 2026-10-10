package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class ListenerHolders {
    private final Set<ListenerHolder<?>> zajo = Collections.newSetFromMap(new WeakHashMap());

    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(L l, Looper looper, String str) {
        Preconditions.checkNotNull(l, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(looper, l, str);
    }

    @KeepForSdk
    public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L l, String str) {
        Preconditions.checkNotNull(l, "Listener must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        Preconditions.checkNotEmpty(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey<>(l, str);
    }

    public final void release() {
        Iterator<ListenerHolder<?>> it = this.zajo.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.zajo.clear();
    }

    public final <L> ListenerHolder<L> zaa(L l, Looper looper, String str) {
        ListenerHolder<L> listenerHolderCreateListenerHolder = createListenerHolder(l, looper, str);
        this.zajo.add(listenerHolderCreateListenerHolder);
        return listenerHolderCreateListenerHolder;
    }
}
