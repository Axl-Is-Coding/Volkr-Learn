package com.disabngo.blockynexus.view.fragment.more;

import android.content.Context;
import android.view.animation.Animation;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.He;
import com.sandboxol.center.aims.MainPageAnimation;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: MoreFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class A extends BaseFragment<MoreViewModel, He> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MoreViewModel f11837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11838b;

    public A(Context context) {
        this.f11837a = new MoreViewModel(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(He he, MoreViewModel moreViewModel) {
        this.f11837a = moreViewModel;
        he.a(moreViewModel);
    }

    public String g() {
        return this.f11838b;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_more;
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return new MainPageAnimation(z, 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        this.f11837a.m();
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
    public MoreViewModel getViewModel() {
        this.f11837a.a((He) this.binding);
        return this.f11837a;
    }

    public void a(String str) {
        this.f11838b = str;
    }
}
