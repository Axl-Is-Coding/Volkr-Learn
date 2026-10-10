package me.tatarka.bindingcollectionadapter2;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: LayoutManagers.java */
/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: compiled from: LayoutManagers.java */
    public interface a {
        RecyclerView.i a(RecyclerView recyclerView);
    }

    public static a a() {
        return new h();
    }

    public static a a(int i, boolean z) {
        return new i(i, z);
    }

    public static a a(int i) {
        return new j(i);
    }
}
