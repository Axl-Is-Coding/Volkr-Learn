package me.iwf.photopicker;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.DataBinderMapperImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f22887a = new SparseIntArray(0);

    /* JADX INFO: renamed from: me.iwf.photopicker.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class C0246a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f22888a = new SparseArray<>(9);

        static {
            f22888a.put(0, "_all");
            f22888a.put(1, "showEmptyView");
            f22888a.put(2, "item");
            f22888a.put(3, "refreshing");
            f22888a.put(4, "emptyText");
            f22888a.put(5, "viewModel");
            f22888a.put(6, "ViewModel");
            f22888a.put(7, "loadingMore");
        }
    }

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f22889a = new HashMap<>(0);
    }

    @Override // androidx.databinding.b
    public List<androidx.databinding.b> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.a());
        arrayList.add(new DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.messager.a());
        return arrayList;
    }

    @Override // androidx.databinding.b
    public String convertBrIdToString(int i) {
        return C0246a.f22888a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View view, int i) {
        if (f22887a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f22889a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f22887a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
