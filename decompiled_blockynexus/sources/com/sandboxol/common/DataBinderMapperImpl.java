package com.sandboxol.common;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.b;
import androidx.databinding.d;
import androidx.databinding.library.baseAdapters.a;
import com.sandboxol.common.databinding.ActivitySingleTemplateBindingImpl;
import com.sandboxol.common.databinding.ActivityTemplateBindingImpl;
import com.sandboxol.common.databinding.CommonDialogAppLoadingBindingImpl;
import com.sandboxol.common.databinding.DataListViewBindingImpl;
import com.sandboxol.common.databinding.PageListViewBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DataBinderMapperImpl extends b {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);
    private static final int LAYOUT_ACTIVITYSINGLETEMPLATE = 1;
    private static final int LAYOUT_ACTIVITYTEMPLATE = 2;
    private static final int LAYOUT_COMMONDIALOGAPPLOADING = 3;
    private static final int LAYOUT_DATALISTVIEW = 4;
    private static final int LAYOUT_PAGELISTVIEW = 5;

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
        static final HashMap<String, Integer> sKeys = new HashMap<>(5);

        static {
            sKeys.put("layout/activity_single_template_0", Integer.valueOf(R.layout.activity_single_template));
            sKeys.put("layout/activity_template_0", Integer.valueOf(R.layout.activity_template));
            sKeys.put("layout/common_dialog_app_loading_0", Integer.valueOf(R.layout.common_dialog_app_loading));
            sKeys.put("layout/data_list_view_0", Integer.valueOf(R.layout.data_list_view));
            sKeys.put("layout/page_list_view_0", Integer.valueOf(R.layout.page_list_view));
        }

        private InnerLayoutIdLookup() {
        }
    }

    static {
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.activity_single_template, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.activity_template, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.common_dialog_app_loading, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.data_list_view, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.page_list_view, 5);
    }

    @Override // androidx.databinding.b
    public List<b> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new a());
        arrayList.add(new com.sandboxol.messager.a());
        return arrayList;
    }

    @Override // androidx.databinding.b
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        if (i2 == 1) {
            if ("layout/activity_single_template_0".equals(tag)) {
                return new ActivitySingleTemplateBindingImpl(dVar, view);
            }
            throw new IllegalArgumentException("The tag for activity_single_template is invalid. Received: " + tag);
        }
        if (i2 == 2) {
            if ("layout/activity_template_0".equals(tag)) {
                return new ActivityTemplateBindingImpl(dVar, view);
            }
            throw new IllegalArgumentException("The tag for activity_template is invalid. Received: " + tag);
        }
        if (i2 == 3) {
            if ("layout/common_dialog_app_loading_0".equals(tag)) {
                return new CommonDialogAppLoadingBindingImpl(dVar, view);
            }
            throw new IllegalArgumentException("The tag for common_dialog_app_loading is invalid. Received: " + tag);
        }
        if (i2 == 4) {
            if ("layout/data_list_view_0".equals(tag)) {
                return new DataListViewBindingImpl(dVar, view);
            }
            throw new IllegalArgumentException("The tag for data_list_view is invalid. Received: " + tag);
        }
        if (i2 != 5) {
            return null;
        }
        if ("layout/page_list_view_0".equals(tag)) {
            return new PageListViewBindingImpl(dVar, view);
        }
        throw new IllegalArgumentException("The tag for page_list_view is invalid. Received: " + tag);
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
    public ViewDataBinding getDataBinder(d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
