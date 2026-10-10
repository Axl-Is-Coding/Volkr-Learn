package com.disabngo.blockynexus.e.b.w;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Rd;
import com.disabngo.blockynexus.e.b.t.C0924c;
import com.google.android.material.textfield.TextInputEditText;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.SecretQuestionInfo;
import com.sandboxol.center.utils.SystemHelper;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.TemplateNewUtils;
import java.util.ArrayList;
import rx.functions.Action0;

/* JADX INFO: compiled from: ForgetPswByEmailOrSecretQuestionViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f10262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Rd f10263c;
    public String h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f10264d = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableList<SecretQuestionInfo> f10265e = new ObservableArrayList();
    public ObservableField<String> g = new ObservableField<>();
    public ObservableField<Boolean> i = new ObservableField<>(true);
    public ReplyCommand j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.w.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f10257a.i();
        }
    });
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.w.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f10259a.h();
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.w.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f10258a.j();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private f f10266f = new f();

    public h(final Context context, Bundle bundle, Rd rd) {
        this.f10261a = context;
        this.f10262b = bundle;
        this.f10263c = rd;
        TextInputEditText textInputEditText = rd.f7833a;
        textInputEditText.setSelection(textInputEditText.getText().length());
        initData();
        Messenger.getDefault().register(this, MessageToken.TOKEN_RESET_PASSWORD, new Action0() { // from class: com.disabngo.blockynexus.e.b.w.a
            @Override // rx.functions.Action0
            public final void call() {
                h.b(context);
            }
        });
    }

    private void f() {
        this.f10266f.a(this.f10261a, this.g.get(), new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f10264d.get().booleanValue()) {
            AppToastUtils.showShortNegativeTipToast(this.f10261a, R.string.not_set_secret_question);
            return;
        }
        if (!SystemHelper.isNumeric(this.g.get())) {
            AppToastUtils.showShortNegativeTipToast(this.f10261a, R.string.user_not_exist);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(StringConstant.UID, this.g.get());
        Context context = this.f10261a;
        TemplateUtils.startTemplate(context, C0924c.class, context.getString(R.string.item_view_forget_password), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ObservableField<String> observableField = this.g;
        if (observableField == null || observableField.get() == null || this.g.get().equals("")) {
            AppToastUtils.showShortNegativeTipToast(this.f10261a, R.string.input_id);
        } else {
            f();
        }
    }

    private void initData() {
        Bundle bundle = this.f10262b;
        if (bundle != null) {
            this.g.set(bundle.getString(StringConstant.UID));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f10265e.size() <= 0) {
            AppToastUtils.showShortNegativeTipToast(this.f10261a, R.string.not_set_secret_question);
            return;
        }
        if (!SystemHelper.isNumeric(this.g.get())) {
            AppToastUtils.showShortNegativeTipToast(this.f10261a, R.string.user_not_exist);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(StringConstant.UID, this.g.get());
        bundle.putString("user_id", this.h);
        bundle.putString(StringConstant.TYPE_FROM_FRAGMENT, this.f10261a.getResources().getString(R.string.item_view_forget_password));
        bundle.putParcelableArrayList(StringConstant.SECRET_QUESTION, (ArrayList) this.f10265e);
        Context context = this.f10261a;
        TemplateNewUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ha.f.class, context.getString(R.string.item_view_forget_password), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f10263c.f7835c.setTextColor(!this.f10264d.get().booleanValue() ? androidx.core.content.b.a(this.f10261a, R.color.secret_email_question_disable) : androidx.core.content.b.a(this.f10261a, R.color.itemTextDefaultColor));
        this.f10263c.f7836d.setTextColor(this.f10265e.size() <= 0 ? androidx.core.content.b.a(this.f10261a, R.color.secret_email_question_disable) : androidx.core.content.b.a(this.f10261a, R.color.itemTextDefaultColor));
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    static /* synthetic */ void b(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing()) {
                return;
            }
            activity.finish();
        }
    }
}
