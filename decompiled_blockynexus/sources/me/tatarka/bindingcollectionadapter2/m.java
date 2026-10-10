package me.tatarka.bindingcollectionadapter2;

import android.os.Looper;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes5.dex */
class m {
    static void a(ViewDataBinding viewDataBinding, int i, int i2) {
        String resourceName = viewDataBinding.getRoot().getContext().getResources().getResourceName(i2);
        throw new IllegalStateException("Could not bind variable '" + androidx.databinding.e.a(i) + "' in layout '" + resourceName + "'");
    }

    static void a() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalStateException("You must only modify the ObservableList on the main thread.");
        }
    }
}
