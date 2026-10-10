package com.disabngo.blockynexus.e.b.y;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.y.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CheckGameInfoUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class C0954e implements com.sandboxol.greendao.a.c<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f10368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GameMassage f10369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0958i f10370d;

    C0954e(C0958i c0958i, Context context, String str, GameMassage gameMassage) {
        this.f10370d = c0958i;
        this.f10367a = context;
        this.f10368b = str;
        this.f10369c = gameMassage;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        C0958i c0958i = this.f10370d;
        c0958i.a(this.f10367a, this.f10368b, this.f10369c, (ObservableField<Boolean>) c0958i.f10385c, game);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        if (this.f10370d.f10385c != null) {
            this.f10370d.f10385c.set(false);
        }
    }
}
