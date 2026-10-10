package com.disabngo.blockynexus.e.b.t;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.t.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EnsureEmailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0927f extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f10182d = new ObservableField<>("");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f10183e = new ObservableField<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f10184f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.t.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f10176a.h();
        }
    });

    public C0927f(Context context, String str) {
        this.f10179a = context;
        this.f10180b = str;
        f();
    }

    private void f() {
        UserApi.getTipsEmail(this.f10179a, Long.valueOf(this.f10180b).longValue(), new C0925d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        UserApi.sendFullEmailToVerify(this.f10179a, Long.valueOf(this.f10180b).longValue(), this.f10183e.get(), new C0926e(this));
    }
}
