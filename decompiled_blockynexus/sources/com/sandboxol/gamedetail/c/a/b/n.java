package com.sandboxol.gamedetail.c.a.b;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailIntroduceViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class n extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f18075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f18076b = new e();

    public n(Context context, Game game) {
        this.f18075a = new h(context, R.string.no_data, game);
    }
}
