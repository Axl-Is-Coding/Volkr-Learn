package com.sandboxol.gamedetail.view.dialog.a;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.AuthorInfo;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: AuthorListViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f18130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f18131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f18132c = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f18133d = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.view.dialog.a.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f18118a.f();
        }
    });

    public i(Context context, d dVar, List<AuthorInfo> list, boolean z) {
        this.f18130a = dVar;
        this.f18131b = new h(context, R.string.no_data, list, z);
    }

    public /* synthetic */ void f() {
        this.f18130a.dismiss();
    }
}
