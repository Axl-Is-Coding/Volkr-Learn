package com.sandbox.login.f.a.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.io.File;

/* JADX INFO: compiled from: MakeRoleFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends BaseFragment<E, com.sandbox.login.c.z> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SetPasswordForm f15831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f15833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f15834e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15830a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f15835f = new ObservableField<>(false);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(com.sandbox.login.c.z zVar, E e2) {
        zVar.a(e2);
    }

    public SetPasswordForm g() {
        return this.f15831b;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.login_fragment_make_role;
    }

    public String h() {
        return this.f15832c;
    }

    public File i() {
        return this.f15833d;
    }

    public Bitmap j() {
        return this.f15834e;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i == 2 && i2 == -1 && intent != null) {
                com.sandbox.login.e.d dVarB = com.sandbox.login.e.d.b();
                Context context = this.context;
                D d2 = this.binding;
                this.f15832c = dVarB.a(context, ((com.sandbox.login.c.z) d2).E, ((com.sandbox.login.c.z) d2).s);
                this.f15833d = com.sandbox.login.e.d.b().a();
                this.f15834e = com.sandbox.login.e.d.b().a(this.context);
                this.f15835f.set(true);
                VM vm = this.viewModel;
                if (vm != 0) {
                    ((E) vm).b(4);
                    return;
                }
                return;
            }
            return;
        }
        if (intent == null) {
            VM vm2 = this.viewModel;
            if (vm2 != 0) {
                ((E) vm2).K();
                return;
            }
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            VM vm3 = this.viewModel;
            if (vm3 != 0) {
                ((E) vm3).K();
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            com.sandbox.login.e.d.b().a(data, this);
        } else {
            com.sandbox.login.e.d.b().a(com.sandbox.login.e.d.b().a(this.context, data), this);
        }
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public void a(SetPasswordForm setPasswordForm) {
        this.f15831b = setPasswordForm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public E getViewModel() {
        E e2 = new E(this.activity, (com.sandbox.login.c.z) this.binding, this, this.f15835f);
        e2.a(this.f15830a);
        if (this.f15830a) {
            ReportDataAdapter.onEvent(this.context, EventConstant.BUILDWIN_TIME);
        }
        return e2;
    }

    public void a(boolean z) {
        this.f15830a = z;
    }
}
