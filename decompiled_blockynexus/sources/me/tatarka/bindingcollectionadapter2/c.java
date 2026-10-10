package me.tatarka.bindingcollectionadapter2;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: BindingRecyclerViewAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
class c extends androidx.databinding.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView.w f22976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f22977b;

    c(d dVar, RecyclerView.w wVar) {
        this.f22977b = dVar;
        this.f22976a = wVar;
    }

    @Override // androidx.databinding.j
    public void b(ViewDataBinding viewDataBinding) {
        int adapterPosition;
        if (this.f22977b.recyclerView == null || this.f22977b.recyclerView.isComputingLayout() || (adapterPosition = this.f22976a.getAdapterPosition()) == -1) {
            return;
        }
        this.f22977b.notifyItemChanged(adapterPosition, d.DATA_INVALIDATION);
    }

    @Override // androidx.databinding.j
    public boolean c(ViewDataBinding viewDataBinding) {
        return this.f22977b.recyclerView != null && this.f22977b.recyclerView.isComputingLayout();
    }
}
