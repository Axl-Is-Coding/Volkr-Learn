package com.disabngo.blockynexus.view.dialog.a;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.UserSignInResponse;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.DateUtils;
import rx.functions.Action0;

/* JADX INFO: compiled from: ActivitySignUpViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f11463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UserSignInResponse f11464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f11465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f11466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f11467f;
    public com.disabngo.blockynexus.e.b.X.a g = new com.disabngo.blockynexus.e.b.X.a();
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.a.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f11449a.f();
        }
    });
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.a.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f11448a.h();
        }
    });
    public ObservableField<String> j = new ObservableField<>();

    public k(Context context, d dVar, UserSignInResponse userSignInResponse) {
        this.f11462a = context;
        this.f11463b = dVar;
        this.f11464c = userSignInResponse;
        if (userSignInResponse == null || userSignInResponse.getUserSignInList().size() != 8) {
            dVar.dismiss();
            return;
        }
        this.f11466e = new e(context, dVar, userSignInResponse, userSignInResponse.getUserSignInList().get(6));
        this.f11467f = new e(context, dVar, userSignInResponse, userSignInResponse.getUserSignInList().get(7));
        this.f11465d = new f(context, dVar, R.string.no_data, userSignInResponse);
        this.j.set(context.getString(R.string.activity_sign_in_left, DateUtils.timeStamp2Date(userSignInResponse.getRemainingTime(), "dd")));
    }

    public /* synthetic */ void f() {
        this.f11463b.dismiss();
    }

    public /* synthetic */ void h() {
        new h().a(this.f11462a, this.f11463b, this.f11464c);
    }
}
