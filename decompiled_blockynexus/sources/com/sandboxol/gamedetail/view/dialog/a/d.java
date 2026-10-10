package com.sandboxol.gamedetail.view.dialog.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.gamedetail.R;
import com.sandboxol.gamedetail.a.AbstractC2678g;
import com.sandboxol.greendao.entity.AuthorInfo;
import java.util.List;

/* JADX INFO: compiled from: AuthorListDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<AuthorInfo> f18119a;

    public d(Context context, List<AuthorInfo> list, boolean z) {
        super(context);
        this.f18119a = list;
        a(context, z);
    }

    private void a(Context context, boolean z) {
        AbstractC2678g abstractC2678g = (AbstractC2678g) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.dialog_author_list, (ViewGroup) null, false);
        setContentView(abstractC2678g.getRoot());
        abstractC2678g.a(new i(context, this, this.f18119a, z));
    }
}
