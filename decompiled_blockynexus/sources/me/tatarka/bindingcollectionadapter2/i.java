package me.tatarka.bindingcollectionadapter2;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.tatarka.bindingcollectionadapter2.k;

/* JADX INFO: compiled from: LayoutManagers.java */
/* JADX INFO: loaded from: classes5.dex */
class i implements k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f22995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f22996b;

    i(int i, boolean z) {
        this.f22995a = i;
        this.f22996b = z;
    }

    @Override // me.tatarka.bindingcollectionadapter2.k.a
    public RecyclerView.i a(RecyclerView recyclerView) {
        return new LinearLayoutManager(recyclerView.getContext(), this.f22995a, this.f22996b);
    }
}
