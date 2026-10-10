package com.sandboxol.gamedetail.c.a.a;

import androidx.fragment.app.FragmentActivity;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailDataLogic.java */
/* JADX INFO: loaded from: classes3.dex */
class B implements com.sandboxol.greendao.a.c<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ P f17894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f17895b;

    B(E e2, P p) {
        this.f17895b = e2;
        this.f17894a = p;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        if (game == null) {
            FragmentActivity activity = this.f17894a.getActivity();
            if (activity != null) {
                new LoadingDialog(activity).show();
            }
            this.f17895b.a(this.f17894a.g().i(), 1, this.f17895b.g, this.f17894a.g().F);
            return;
        }
        this.f17895b.b(game);
        E e2 = this.f17895b;
        e2.a(game, 2, e2.g, this.f17894a.g().F);
        this.f17895b.a(game);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
