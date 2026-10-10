package com.disabngo.blockynexus.e.b.la;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.B;
import com.disabngo.blockynexus.databinding.Gf;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.io.File;

/* JADX INFO: compiled from: TribeCreateFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends TemplateFragment<n, Gf> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f9907b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Gf gf, n nVar) {
        gf.a(nVar);
    }

    public File g() {
        return this.f9907b;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_tribe_create;
    }

    public String h() {
        return this.f9906a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i == 2 && i2 == -1 && intent != null) {
                this.f9906a = B.b().a(this.context, ((Gf) this.binding).f7495b);
                this.f9907b = B.b().a();
                return;
            }
            return;
        }
        if (intent == null || (data = intent.getData()) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            B.b().a(data, this);
        } else {
            B.b().a(B.b().a(this.context, data), this);
        }
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause(this.context);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume(this.context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public n getViewModel() {
        return new n(getActivity(), this, (Gf) this.binding, getArguments().getBoolean("tribe.is.create"));
    }
}
