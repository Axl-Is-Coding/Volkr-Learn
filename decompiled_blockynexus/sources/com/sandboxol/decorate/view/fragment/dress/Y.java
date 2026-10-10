package com.sandboxol.decorate.view.fragment.dress;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import com.sandboxol.center.aims.MainPageAnimation;
import com.sandboxol.common.base.app.TemplateFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.c.AbstractC2597w;
import com.sandboxol.decorate.widget.DressMenuButton;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: DressFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public class Y extends TemplateFragment<va, AbstractC2597w> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f17405b = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC2597w abstractC2597w, va vaVar) {
        abstractC2597w.a(vaVar);
    }

    public String g() {
        return this.f17404a;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_dress;
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onBackPressed() {
        if (this.f17405b) {
            com.sandboxol.decorate.manager.q.a().f17201a.set(true);
        }
        super.onBackPressed();
    }

    @Override // com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.sandboxol.decorate.manager.j.c().a(DressMenuButton.MenuItem.CLOTH, new com.sandboxol.decorate.manager.a.b());
        com.sandboxol.decorate.manager.j.c().a(DressMenuButton.MenuItem.DEC, new com.sandboxol.decorate.manager.a.a());
        com.sandboxol.decorate.manager.j.c().a(DressMenuButton.MenuItem.MAN, new com.sandboxol.decorate.manager.a.e());
        com.sandboxol.decorate.manager.j.c().a(DressMenuButton.MenuItem.FUN, new com.sandboxol.decorate.manager.a.d());
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return new MainPageAnimation(z, 1);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessagerClient.getIns().unRegisterMsg(Y.class);
    }

    @Override // com.sandboxol.common.base.app.TemplateFragment
    public void onLeftButtonClick(View view) {
        if (this.f17405b) {
            com.sandboxol.decorate.manager.q.a().f17201a.set(true);
        }
        super.onLeftButtonClick(view);
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

    public void a(String str) {
        this.f17404a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public va getViewModel() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f17405b = arguments.getBoolean("otherEntrances");
        }
        return new va(getActivity(), (AbstractC2597w) this.binding, this.f17405b);
    }
}
