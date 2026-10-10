package me.tatarka.bindingcollectionadapter2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: BindingViewPagerAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
public class f<T> extends androidx.viewpager.widget.a implements me.tatarka.bindingcollectionadapter2.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g<T> f22985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b<T> f22986b = new b<>(this);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<T> f22987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LayoutInflater f22988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a<T> f22989e;

    /* JADX INFO: compiled from: BindingViewPagerAdapter.java */
    public interface a<T> {
        CharSequence a(int i, T t);
    }

    public void a(g<T> gVar) {
        this.f22985a = gVar;
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        List<T> list = this.f22987c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.a
    public int getItemPosition(Object obj) {
        Object tag = ((View) obj).getTag();
        if (this.f22987c == null) {
            return -2;
        }
        for (int i = 0; i < this.f22987c.size(); i++) {
            if (tag == this.f22987c.get(i)) {
                return i;
            }
        }
        return -2;
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
    @Override // androidx.viewpager.widget.a
    public CharSequence getPageTitle(int i) {
        a<T> aVar = this.f22989e;
        if (aVar == null) {
            return null;
        }
        return aVar.a(i, this.f22987c.get(i));
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.f22988d == null) {
            this.f22988d = LayoutInflater.from(viewGroup.getContext());
        }
        T t = this.f22987c.get(i);
        this.f22985a.a(i, t);
        ViewDataBinding viewDataBindingA = a(this.f22988d, this.f22985a.a(), viewGroup);
        a(viewDataBindingA, this.f22985a.b(), this.f22985a.a(), i, t);
        viewGroup.addView(viewDataBindingA.getRoot());
        viewDataBindingA.getRoot().setTag(t);
        return viewDataBindingA.getRoot();
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void a(List<T> list) {
        List<T> list2 = this.f22987c;
        if (list2 == list) {
            return;
        }
        if (list2 instanceof ObservableList) {
            ((ObservableList) list2).removeOnListChangedCallback(this.f22986b);
        }
        if (list instanceof ObservableList) {
            ((ObservableList) list).addOnListChangedCallback(this.f22986b);
        }
        this.f22987c = list;
        notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: BindingViewPagerAdapter.java */
    private static class b<T> extends ObservableList.a<ObservableList<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<f<T>> f22990a;

        b(f<T> fVar) {
            this.f22990a = new WeakReference<>(fVar);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList) {
            f<T> fVar = this.f22990a.get();
            if (fVar == null) {
                return;
            }
            m.a();
            fVar.notifyDataSetChanged();
        }

        @Override // androidx.databinding.ObservableList.a
        public void b(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        @Override // androidx.databinding.ObservableList.a
        public void c(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList, int i, int i2, int i3) {
            a(observableList);
        }
    }

    public ViewDataBinding a(LayoutInflater layoutInflater, int i, ViewGroup viewGroup) {
        return androidx.databinding.e.a(layoutInflater, i, viewGroup, false);
    }

    public void a(ViewDataBinding viewDataBinding, int i, int i2, int i3, T t) {
        if (this.f22985a.a(viewDataBinding, t)) {
            viewDataBinding.executePendingBindings();
        }
    }

    public void a(a<T> aVar) {
        this.f22989e = aVar;
    }
}
