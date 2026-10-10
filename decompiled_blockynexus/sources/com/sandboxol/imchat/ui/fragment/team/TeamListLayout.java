package com.sandboxol.imchat.ui.fragment.team;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public class TeamListLayout implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return e.a(LayoutInflater.from(context), R.layout.layout_team, viewGroup, z);
    }
}
