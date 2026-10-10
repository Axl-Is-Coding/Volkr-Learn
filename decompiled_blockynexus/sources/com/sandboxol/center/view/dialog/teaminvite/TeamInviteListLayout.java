package com.sandboxol.center.view.dialog.teaminvite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.common.widget.rv.IListLayout;

/* JADX INFO: loaded from: classes3.dex */
public class TeamInviteListLayout implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return e.a(LayoutInflater.from(context), R.layout.base_team_invite_data_list_view, viewGroup, z);
    }
}
