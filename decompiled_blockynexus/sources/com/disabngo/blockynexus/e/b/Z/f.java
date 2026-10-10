package com.disabngo.blockynexus.e.b.Z;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: compiled from: ReportViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f9610c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Z.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9605a.f();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f9611d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Z.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9604a.h();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f9612e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Z.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9607a.i();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9613f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Z.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9606a.j();
        }
    });

    public f(Context context, long j) {
        this.f9608a = context;
        this.f9609b = j;
    }

    private void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(StringConstant.REPORT_REASON, str);
        bundle.putLong(StringConstant.REPORT_USER_ID, this.f9609b);
        Context context = this.f9608a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.aa.e.class, context.getString(R.string.report), bundle);
        Context context2 = this.f9608a;
        if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
            return;
        }
        ((Activity) this.f9608a).finish();
    }

    public /* synthetic */ void f() {
        a("A");
    }

    public /* synthetic */ void h() {
        a("B");
    }

    public /* synthetic */ void i() {
        a("C");
    }

    public /* synthetic */ void j() {
        a("D");
    }
}
