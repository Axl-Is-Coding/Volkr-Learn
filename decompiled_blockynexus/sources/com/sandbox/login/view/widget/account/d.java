package com.sandbox.login.view.widget.account;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.sandbox.login.R;
import com.sandboxol.common.widget.rv.IListLayout;

/* JADX INFO: compiled from: AccountListLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return androidx.databinding.e.a(LayoutInflater.from(context), R.layout.login_data_list_view, viewGroup, z);
    }
}
