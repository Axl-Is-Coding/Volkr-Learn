package me.tatarka.bindingcollectionadapter2;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.d;
import me.tatarka.bindingcollectionadapter2.k;

/* JADX INFO: compiled from: BindingRecyclerViewAdapters.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {
    public static <T> void a(RecyclerView recyclerView, g<T> gVar, List<T> list, d<T> dVar, d.b<? super T> bVar, d.c cVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("itemBinding must not be null");
        }
        d<T> dVar2 = (d) recyclerView.getAdapter();
        if (dVar == null) {
            dVar = dVar2 == null ? new d<>() : dVar2;
        }
        dVar.setItemBinding(gVar);
        dVar.setItems(list);
        dVar.setItemIds(bVar);
        dVar.setViewHolderFactory(cVar);
        if (dVar2 != dVar) {
            recyclerView.setAdapter(dVar);
        }
    }

    public static void a(RecyclerView recyclerView, k.a aVar) {
        recyclerView.setLayoutManager(aVar.a(recyclerView));
    }
}
