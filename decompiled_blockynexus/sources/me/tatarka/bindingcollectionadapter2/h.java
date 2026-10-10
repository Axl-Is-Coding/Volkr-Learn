package me.tatarka.bindingcollectionadapter2;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.tatarka.bindingcollectionadapter2.k;

/* JADX INFO: compiled from: LayoutManagers.java */
/* JADX INFO: loaded from: classes5.dex */
class h implements k.a {
    h() {
    }

    @Override // me.tatarka.bindingcollectionadapter2.k.a
    public RecyclerView.i a(RecyclerView recyclerView) {
        return new LinearLayoutManager(recyclerView.getContext());
    }
}
