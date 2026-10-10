package me.tatarka.bindingcollectionadapter2;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.tatarka.bindingcollectionadapter2.k;

/* JADX INFO: compiled from: LayoutManagers.java */
/* JADX INFO: loaded from: classes5.dex */
class j implements k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f22997a;

    j(int i) {
        this.f22997a = i;
    }

    @Override // me.tatarka.bindingcollectionadapter2.k.a
    public RecyclerView.i a(RecyclerView recyclerView) {
        return new GridLayoutManager(recyclerView.getContext(), this.f22997a);
    }
}
