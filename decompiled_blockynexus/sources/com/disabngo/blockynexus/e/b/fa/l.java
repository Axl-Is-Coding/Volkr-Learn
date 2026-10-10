package com.disabngo.blockynexus.e.b.fa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0634kf;
import com.disabngo.blockynexus.view.widget.SecretQuestionPopupWindow;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.SecretQuestionInfo;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: SecretQuestionViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f9776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f9777b;
    private View o;
    private View p;
    private AbstractC0634kf q;
    private Bundle r;
    private List<SecretQuestionInfo> s;
    private SecretQuestionPopupWindow t;
    private String v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f9778c = new ObservableField<>(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f9779d = new ObservableField<>(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableList<String> f9780e = new ObservableArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableList<String> f9781f = new ObservableArrayList();
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.fa.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f9770a.i();
        }
    });
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.fa.f
        @Override // rx.functions.Action0
        public final void call() {
            this.f9771a.j();
        }
    });
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.fa.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f9773a.h();
        }
    });
    public ReplyCommand j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.fa.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f9772a.f();
        }
    });
    public ObservableField<String> k = new ObservableField<>("");
    public ObservableField<String> l = new ObservableField<>("");
    public ObservableField<String> m = new ObservableField<>("");
    public ObservableField<String> n = new ObservableField<>("");
    private boolean u = false;

    public l(Context context, Bundle bundle) {
        this.f9776a = context;
        this.r = bundle;
        this.f9777b = new j(context);
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if ("".equals(this.l.get()) || this.l.get().trim().length() < 1) {
            Context context = this.f9776a;
            AppToastUtils.showShortNegativeTipToast(context, context.getResources().getString(R.string.question_result_empty));
            return;
        }
        if ("".equals(this.n.get()) || this.f9776a.getResources().getString(R.string.please_select).equals(this.n.get())) {
            Context context2 = this.f9776a;
            AppToastUtils.showShortNegativeTipToast(context2, context2.getResources().getString(R.string.please_select));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SecretQuestionInfo secretQuestionInfo : this.s) {
            if (secretQuestionInfo.getQuestion().equals(this.m.get())) {
                SecretQuestionInfo secretQuestionInfo2 = new SecretQuestionInfo();
                secretQuestionInfo2.setId(secretQuestionInfo.getId());
                secretQuestionInfo2.setQuestion(secretQuestionInfo.getQuestion());
                secretQuestionInfo2.setAnswer(this.k.get());
                arrayList.add(secretQuestionInfo2);
            } else if (secretQuestionInfo.getQuestion().equals(this.n.get())) {
                SecretQuestionInfo secretQuestionInfo3 = new SecretQuestionInfo();
                secretQuestionInfo3.setId(secretQuestionInfo.getId());
                secretQuestionInfo3.setQuestion(secretQuestionInfo.getQuestion());
                secretQuestionInfo3.setAnswer(this.l.get());
                arrayList.add(secretQuestionInfo3);
            }
        }
        this.f9777b.a(this.f9776a, this.u ? "v2" : "v1", arrayList, this.v, new k(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if ("".equals(this.k.get()) || this.k.get().trim().length() < 1) {
            Context context = this.f9776a;
            AppToastUtils.showShortNegativeTipToast(context, context.getResources().getString(R.string.question_result_empty));
            return;
        }
        if ("".equals(this.m.get()) || this.f9776a.getResources().getString(R.string.please_select).equals(this.m.get())) {
            Context context2 = this.f9776a;
            AppToastUtils.showShortNegativeTipToast(context2, context2.getResources().getString(R.string.please_select));
            return;
        }
        this.f9778c.set(true);
        for (String str : this.f9780e) {
            if (!this.m.get().equals(str)) {
                this.f9781f.add(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.t = new SecretQuestionPopupWindow(this.f9776a, this.f9780e, this.q.f8519c);
        this.t.setOnItemClickListener(new SecretQuestionPopupWindow.OnItemClickListener() { // from class: com.disabngo.blockynexus.e.b.fa.c
            @Override // com.disabngo.blockynexus.view.widget.SecretQuestionPopupWindow.OnItemClickListener
            public final void onClick(int i, long j) {
                this.f9767a.a(i, j);
            }
        });
        this.t.showLocation(this.o);
    }

    private void initData() {
        Bundle bundle = this.r;
        if (bundle != null) {
            this.s = bundle.getParcelableArrayList(StringConstant.SECRET_QUESTION);
            this.u = this.r.getBoolean(StringConstant.IS_FINISH_EMAIL_VERIFY);
            this.v = this.r.getString(StringConstant.SECRET_AUTHCODE);
            Iterator<SecretQuestionInfo> it = this.s.iterator();
            while (it.hasNext()) {
                this.f9780e.add(it.next().getQuestion());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.t = new SecretQuestionPopupWindow(this.f9776a, this.f9781f, this.q.f8520d);
        this.t.setOnItemClickListener(new SecretQuestionPopupWindow.OnItemClickListener() { // from class: com.disabngo.blockynexus.e.b.fa.b
            @Override // com.disabngo.blockynexus.view.widget.SecretQuestionPopupWindow.OnItemClickListener
            public final void onClick(int i, long j) {
                this.f9766a.b(i, j);
            }
        });
        this.t.showLocation(this.p);
    }

    void a(AbstractC0634kf abstractC0634kf) {
        this.q = abstractC0634kf;
        this.o = abstractC0634kf.f8521e;
        this.p = abstractC0634kf.f8522f;
    }

    public /* synthetic */ void b(int i, long j) {
        this.n.set(this.f9781f.get(i));
    }

    void onBack() {
        final TwoButtonDialog twoButtonDialog = new TwoButtonDialog(this.f9776a);
        twoButtonDialog.setTitleText(this.f9776a.getResources().getString(R.string.tip));
        twoButtonDialog.setLeftButtonText(R.string.cancel);
        twoButtonDialog.setRightButtonText(R.string.confirm);
        twoButtonDialog.setDetailText(R.string.not_save_secret_question_tips);
        twoButtonDialog.setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.fa.d
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f9768a.a(twoButtonDialog);
            }
        });
        twoButtonDialog.show();
    }

    public /* synthetic */ void a(int i, long j) {
        this.m.set(this.f9780e.get(i));
    }

    public /* synthetic */ void a(TwoButtonDialog twoButtonDialog) {
        twoButtonDialog.dismiss();
        ((Activity) this.f9776a).finish();
    }
}
