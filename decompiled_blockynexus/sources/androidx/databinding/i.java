package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: MergedDataBinderMapper.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<Class<? extends b>> f1358a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<b> f1359b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f1360c = new CopyOnWriteArrayList();

    public void a(b bVar) {
        if (this.f1358a.add((Class<? extends b>) bVar.getClass())) {
            this.f1359b.add(bVar);
            Iterator<b> it = bVar.collectDependencies().iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
    }

    @Override // androidx.databinding.b
    public String convertBrIdToString(int i) {
        Iterator<b> it = this.f1359b.iterator();
        while (it.hasNext()) {
            String strConvertBrIdToString = it.next().convertBrIdToString(i);
            if (strConvertBrIdToString != null) {
                return strConvertBrIdToString;
            }
        }
        if (a()) {
            return convertBrIdToString(i);
        }
        return null;
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View view, int i) {
        Iterator<b> it = this.f1359b.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = it.next().getDataBinder(dVar, view, i);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (a()) {
            return getDataBinder(dVar, view, i);
        }
        return null;
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Iterator<b> it = this.f1359b.iterator();
        while (it.hasNext()) {
            int layoutId = it.next().getLayoutId(str);
            if (layoutId != 0) {
                return layoutId;
            }
        }
        if (a()) {
            return getLayoutId(str);
        }
        return 0;
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View[] viewArr, int i) {
        Iterator<b> it = this.f1359b.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = it.next().getDataBinder(dVar, viewArr, i);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (a()) {
            return getDataBinder(dVar, viewArr, i);
        }
        return null;
    }

    private boolean a() {
        boolean z = false;
        for (String str : this.f1360c) {
            try {
                Class<?> cls = Class.forName(str);
                if (b.class.isAssignableFrom(cls)) {
                    a((b) cls.newInstance());
                    this.f1360c.remove(str);
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e2) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e2);
            } catch (InstantiationException e3) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e3);
            }
        }
        return z;
    }
}
