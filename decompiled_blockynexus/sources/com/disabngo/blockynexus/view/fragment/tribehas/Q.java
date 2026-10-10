package com.disabngo.blockynexus.view.fragment.tribehas;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.messenger.Messenger;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeHasModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<String> f11985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableField<String> f11986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObservableField<String> f11987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ObservableField<Integer> f11988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ObservableField<String> f11989f;
    private ObservableField<List<String>> g;
    private ObservableField<String> h;

    public Q(Context context, ObservableField<String> observableField, ObservableField<String> observableField2, ObservableField<String> observableField3, ObservableField<Integer> observableField4, ObservableField<String> observableField5, ObservableField<List<String>> observableField6, ObservableField<String> observableField7) {
        this.f11984a = context;
        this.f11985b = observableField;
        this.f11986c = observableField2;
        this.f11987d = observableField3;
        this.f11988e = observableField4;
        this.f11989f = observableField5;
        this.g = observableField6;
        this.h = observableField7;
        c();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        TribeApi.tribeBaseInfo(this.f11984a, new N(this));
    }

    private void d() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_TRIBE_HAS, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.n
            @Override // rx.functions.Action0
            public final void call() {
                this.f12011a.c();
            }
        });
    }

    public void a() {
        TribeApi.getTribeNotice(this.f11984a, new O(this));
    }

    public void b() {
        Messenger.getDefault().unregister(this);
    }

    public static void a(Context context) {
        TribeApi.getMyTribeGold(context, new P(context));
    }
}
