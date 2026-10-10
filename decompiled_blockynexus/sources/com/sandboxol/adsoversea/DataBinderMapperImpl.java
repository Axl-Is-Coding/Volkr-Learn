package com.sandboxol.adsoversea;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.b;
import androidx.databinding.library.baseAdapters.a;
import com.sandboxol.ads.iron.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DataBinderMapperImpl extends b {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys = new SparseArray<>(9);

        static {
            sKeys.put(0, "_all");
            sKeys.put(1, "showEmptyView");
            sKeys.put(2, "item");
            sKeys.put(3, "refreshing");
            sKeys.put(4, "emptyText");
            sKeys.put(5, "viewModel");
            sKeys.put(6, "ViewModel");
            sKeys.put(7, "loadingMore");
        }

        private InnerBrLookup() {
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(0);

        private InnerLayoutIdLookup() {
        }
    }

    @Override // androidx.databinding.b
    public List<b> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new a());
        arrayList.add(new d());
        arrayList.add(new com.sandboxol.ads.mob.d());
        arrayList.add(new com.sandboxol.common.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.messager.a());
        return arrayList;
    }

    @Override // androidx.databinding.b
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View view, int i) {
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
