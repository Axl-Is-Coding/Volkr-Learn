package com.sandboxol.common.widget.rv.datarv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.common.R;
import com.sandboxol.common.widget.rv.IListLayout;

/* JADX INFO: loaded from: classes3.dex */
public class DataListLayout implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return e.a(LayoutInflater.from(context), R.layout.data_list_view, viewGroup, z);
    }
}
