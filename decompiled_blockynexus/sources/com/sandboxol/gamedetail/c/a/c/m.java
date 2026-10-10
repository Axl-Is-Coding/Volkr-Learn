package com.sandboxol.gamedetail.c.a.c;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.gamedetail.R;

/* JADX INFO: compiled from: GameDetailRankPageViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends ListItemViewModel<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f18092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f18093b;

    public m(Context context, String str, String str2) {
        super(context, str);
        this.f18093b = new j();
        this.f18092a = new l(context, R.string.gamedetail_tribe_rank_not, str, str2);
    }
}
