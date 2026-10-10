package com.disabngo.blockynexus.e.b.W;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.IListLayout;

/* JADX INFO: compiled from: RankPageListLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return e.a(LayoutInflater.from(context), R.layout.rank_page_list_view, viewGroup, z);
    }
}
