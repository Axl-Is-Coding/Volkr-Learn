package com.disabngo.blockynexus.view.activity.tribesearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.IListLayout;

/* JADX INFO: compiled from: TribeSearchPageListLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.tribe_page_list_view, viewGroup, z);
    }
}
