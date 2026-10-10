package com.sandboxol.common.widget.rv.pagerv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.R;
import com.sandboxol.common.widget.rv.IListLayout;

/* JADX INFO: loaded from: classes3.dex */
public class PageListLayout implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.page_list_view, viewGroup, z);
    }
}
