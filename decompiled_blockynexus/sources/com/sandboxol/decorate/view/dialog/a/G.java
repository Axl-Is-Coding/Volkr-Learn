package com.sandboxol.decorate.view.dialog.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DressBuyListLayout.java */
/* JADX INFO: loaded from: classes3.dex */
public class G implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.decorate_list_view_dress_buy, viewGroup, z);
    }
}
