package com.sandboxol.tencentmaputils;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.common.DataBinderMapperImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f18909a = new SparseIntArray(0);

    /* JADX INFO: renamed from: com.sandboxol.tencentmaputils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class C0165a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f18910a = new SparseArray<>(9);

        static {
            f18910a.put(0, "_all");
            f18910a.put(1, "showEmptyView");
            f18910a.put(2, "item");
            f18910a.put(3, "refreshing");
            f18910a.put(4, "emptyText");
            f18910a.put(5, "viewModel");
            f18910a.put(6, "ViewModel");
            f18910a.put(7, "loadingMore");
        }
    }

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f18911a = new HashMap<>(0);
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
        return C0165a.f18910a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View view, int i) {
        if (f18909a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f18911a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f18909a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
