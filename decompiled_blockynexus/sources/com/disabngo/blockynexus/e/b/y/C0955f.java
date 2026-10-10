package com.disabngo.blockynexus.e.b.y;

import androidx.databinding.ObservableField;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.y.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CheckGameInfoUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class C0955f extends OnResponseListener<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f10371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0956g f10372b;

    C0955f(C0956g c0956g, List list) {
        this.f10372b = c0956g;
        this.f10371a = list;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        if (game != null) {
            this.f10372b.g.f10383a = game;
        }
        C0956g c0956g = this.f10372b;
        c0956g.g.b(c0956g.f10373a, c0956g.f10376d, this.f10371a, c0956g.f10377e, new com.google.gson.j().a(this.f10372b.g.f10383a));
        ObservableField observableField = this.f10372b.f10378f;
        if (observableField != null) {
            observableField.set(false);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        C0956g c0956g = this.f10372b;
        c0956g.g.b(c0956g.f10373a, c0956g.f10376d, this.f10371a, c0956g.f10377e, new com.google.gson.j().a(this.f10372b.g.f10383a));
        ObservableField observableField = this.f10372b.f10378f;
        if (observableField != null) {
            observableField.set(false);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        C0956g c0956g = this.f10372b;
        c0956g.g.b(c0956g.f10373a, c0956g.f10376d, this.f10371a, c0956g.f10377e, new com.google.gson.j().a(this.f10372b.g.f10383a));
        ObservableField observableField = this.f10372b.f10378f;
        if (observableField != null) {
            observableField.set(false);
        }
    }
}
