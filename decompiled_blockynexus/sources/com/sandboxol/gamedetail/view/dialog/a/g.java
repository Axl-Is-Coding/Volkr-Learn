package com.sandboxol.gamedetail.view.dialog.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.gamedetail.R;

/* JADX INFO: compiled from: AuthorListListLayout.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.author_list_list_view, viewGroup, z);
    }
}
