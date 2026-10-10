package com.disabngo.blockynexus.e.b.O;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.animation.Animation;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Fe;
import com.disabngo.blockynexus.view.activity.main.nc;
import com.sandboxol.center.aims.MainPageAnimation;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.FrameAnimationUtil;

/* JADX INFO: compiled from: MakeFriendFragment.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ValidFragment"})
public class n extends BaseFragment<t, Fe> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FrameAnimationUtil f9375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameAnimationUtil f9376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private nc f9377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private t f9378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9379e;

    public n(nc ncVar, Context context) {
        this.f9377c = ncVar;
        this.f9378d = new t(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(Fe fe, t tVar) {
        fe.a(tVar);
        fe.a(this.f9377c);
    }

    public String g() {
        return this.f9379e;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_make_friend;
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return new MainPageAnimation(z, 2);
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ReportDataAdapter.onPause(this.context);
        FrameAnimationUtil frameAnimationUtil = this.f9375a;
        if (frameAnimationUtil == null || this.f9376b == null) {
            return;
        }
        frameAnimationUtil.release();
        this.f9376b.release();
        this.f9375a = null;
        this.f9376b = null;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment, com.trello.rxlifecycle.components.support.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onResume(this.context);
        try {
            this.f9375a = new FrameAnimationUtil(this.context, ((Fe) this.binding).f7451e, R.array.ic_make_clan, 50, true);
            this.f9376b = new FrameAnimationUtil(this.context, ((Fe) this.binding).f7450d, R.array.ic_make_friend, 40, true);
        } catch (Exception unused) {
            ReportDataAdapter.onEvent(this.activity, EventConstant.ON_RESUME_EXCEPTION, "MakeFriendFragment");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public t getViewModel() {
        return this.f9378d;
    }

    public void a(String str) {
        this.f9379e = str;
    }
}
