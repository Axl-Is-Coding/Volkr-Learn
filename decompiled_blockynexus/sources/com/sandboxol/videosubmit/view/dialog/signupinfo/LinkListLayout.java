package com.sandboxol.videosubmit.view.dialog.signupinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.common.widget.rv.datarv.DataListLayout;
import com.sandboxol.videosubmit.R;

/* JADX INFO: loaded from: classes4.dex */
public class LinkListLayout extends DataListLayout {
    @Override // com.sandboxol.common.widget.rv.datarv.DataListLayout, com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return e.a(LayoutInflater.from(context), R.layout.videosubmit_list_link, viewGroup, z);
    }
}
