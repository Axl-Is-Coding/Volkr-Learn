package com.disabngo.blockynexus.e.b.D;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.datarv.DataListLayout;

/* JADX INFO: compiled from: GroupInfoListLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class y extends DataListLayout {
    @Override // com.sandboxol.common.widget.rv.datarv.DataListLayout, com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.list_member, viewGroup, z);
    }
}
