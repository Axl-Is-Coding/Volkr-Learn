package com.disabngo.blockynexus.view.fragment.updateuserinfo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.B;
import com.disabngo.blockynexus.databinding.AbstractC0559dg;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.io.File;

/* JADX INFO: compiled from: UpdateUserInfoFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends TemplateFragment<UpdateUserInfoViewModel, AbstractC0559dg> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f12063b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0559dg abstractC0559dg, UpdateUserInfoViewModel updateUserInfoViewModel) {
        abstractC0559dg.a(updateUserInfoViewModel);
    }

    public File g() {
        return this.f12063b;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_update_user_info;
    }

    public String h() {
        return this.f12062a;
    }

    public void i() {
        B.b().b(this.context, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (intent == null || (data = intent.getData()) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                B.b().a(data, this);
                return;
            } else {
                B.b().a(B.b().a(this.context, data), this);
                return;
            }
        }
        if (i == 2 && i2 == -1 && intent != null) {
            this.f12062a = B.b().a(this.context, ((AbstractC0559dg) this.binding).f8268b);
            this.f12063b = B.b().a();
            ((UpdateUserInfoViewModel) this.viewModel).j();
        }
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause((Activity) this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume((Activity) this.context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public UpdateUserInfoViewModel getViewModel() {
        return new UpdateUserInfoViewModel(this.context, this);
    }
}
