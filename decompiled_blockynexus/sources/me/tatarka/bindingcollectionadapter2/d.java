package me.tatarka.bindingcollectionadapter2;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: BindingRecyclerViewAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
public class d<T> extends RecyclerView.a<RecyclerView.w> implements me.tatarka.bindingcollectionadapter2.a<T> {
    private static final Object DATA_INVALIDATION = new Object();
    private final C0248d<T> callback = new C0248d<>(this);
    private LayoutInflater inflater;
    private g<T> itemBinding;
    private b<? super T> itemIds;
    private List<T> items;
    private RecyclerView recyclerView;
    private c viewHolderFactory;

    /* JADX INFO: compiled from: BindingRecyclerViewAdapter.java */
    private static class a extends RecyclerView.w {
        public a(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
        }
    }

    /* JADX INFO: compiled from: BindingRecyclerViewAdapter.java */
    public interface b<T> {
        long a(int i, T t);
    }

    /* JADX INFO: compiled from: BindingRecyclerViewAdapter.java */
    public interface c {
        RecyclerView.w a(ViewDataBinding viewDataBinding);
    }

    private boolean isForDataBinding(List<Object> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != DATA_INVALIDATION) {
                return false;
            }
        }
        return true;
    }

    public T getAdapterItem(int i) {
        return this.items.get(i);
    }

    public g<T> getItemBinding() {
        return this.itemBinding;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        List<T> list = this.items;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public long getItemId(int i) {
        b<? super T> bVar = this.itemIds;
        return bVar == null ? i : bVar.a(i, this.items.get(i));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemViewType(int i) {
        this.itemBinding.a(i, this.items.get(i));
        return this.itemBinding.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        List<T> list;
        if (this.recyclerView == null && (list = this.items) != null && (list instanceof ObservableList)) {
            ((ObservableList) list).addOnListChangedCallback(this.callback);
        }
        this.recyclerView = recyclerView;
    }

    public void onBindBinding(ViewDataBinding viewDataBinding, int i, int i2, int i3, T t) {
        if (this.itemBinding.a(viewDataBinding, t)) {
            viewDataBinding.executePendingBindings();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final void onBindViewHolder(RecyclerView.w wVar, int i) {
        onBindBinding(androidx.databinding.e.a(wVar.itemView), this.itemBinding.b(), this.itemBinding.a(), i, this.items.get(i));
    }

    public ViewDataBinding onCreateBinding(LayoutInflater layoutInflater, int i, ViewGroup viewGroup) {
        return androidx.databinding.e.a(layoutInflater, i, viewGroup, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.inflater == null) {
            this.inflater = LayoutInflater.from(viewGroup.getContext());
        }
        ViewDataBinding viewDataBindingOnCreateBinding = onCreateBinding(this.inflater, i, viewGroup);
        RecyclerView.w wVarOnCreateViewHolder = onCreateViewHolder(viewDataBindingOnCreateBinding);
        viewDataBindingOnCreateBinding.addOnRebindCallback(new me.tatarka.bindingcollectionadapter2.c(this, wVarOnCreateViewHolder));
        return wVarOnCreateViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        List<T> list;
        if (this.recyclerView != null && (list = this.items) != null && (list instanceof ObservableList)) {
            ((ObservableList) list).removeOnListChangedCallback(this.callback);
        }
        this.recyclerView = null;
    }

    public void setItemBinding(g<T> gVar) {
        this.itemBinding = gVar;
    }

    public void setItemIds(b<? super T> bVar) {
        if (this.itemIds != bVar) {
            this.itemIds = bVar;
            setHasStableIds(bVar != null);
        }
    }

    public void setItems(List<T> list) {
        List<T> list2 = this.items;
        if (list2 == list) {
            return;
        }
        if (this.recyclerView != null) {
            if (list2 instanceof ObservableList) {
                ((ObservableList) list2).removeOnListChangedCallback(this.callback);
            }
            if (list instanceof ObservableList) {
                ((ObservableList) list).addOnListChangedCallback(this.callback);
            }
        }
        this.items = list;
        notifyDataSetChanged();
    }

    public void setViewHolderFactory(c cVar) {
        this.viewHolderFactory = cVar;
    }

    /* JADX INFO: renamed from: me.tatarka.bindingcollectionadapter2.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BindingRecyclerViewAdapter.java */
    private static class C0248d<T> extends ObservableList.a<ObservableList<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<d<T>> f22984a;

        C0248d(d<T> dVar) {
            this.f22984a = new WeakReference<>(dVar);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList) {
            d<T> dVar = this.f22984a.get();
            if (dVar == null) {
                return;
            }
            m.a();
            dVar.notifyDataSetChanged();
        }

        @Override // androidx.databinding.ObservableList.a
        public void b(ObservableList observableList, int i, int i2) {
            d<T> dVar = this.f22984a.get();
            if (dVar == null) {
                return;
            }
            m.a();
            dVar.notifyItemRangeInserted(i, i2);
        }

        @Override // androidx.databinding.ObservableList.a
        public void c(ObservableList observableList, int i, int i2) {
            d<T> dVar = this.f22984a.get();
            if (dVar == null) {
                return;
            }
            m.a();
            dVar.notifyItemRangeRemoved(i, i2);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList, int i, int i2) {
            d<T> dVar = this.f22984a.get();
            if (dVar == null) {
                return;
            }
            m.a();
            dVar.notifyItemRangeChanged(i, i2);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList, int i, int i2, int i3) {
            d<T> dVar = this.f22984a.get();
            if (dVar == null) {
                return;
            }
            m.a();
            for (int i4 = 0; i4 < i3; i4++) {
                dVar.notifyItemMoved(i + i4, i2 + i4);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(RecyclerView.w wVar, int i, List<Object> list) {
        if (isForDataBinding(list)) {
            androidx.databinding.e.a(wVar.itemView).executePendingBindings();
        } else {
            super.onBindViewHolder(wVar, i, list);
        }
    }

    public RecyclerView.w onCreateViewHolder(ViewDataBinding viewDataBinding) {
        c cVar = this.viewHolderFactory;
        if (cVar != null) {
            return cVar.a(viewDataBinding);
        }
        return new a(viewDataBinding);
    }
}
