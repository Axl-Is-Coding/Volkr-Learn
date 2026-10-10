package com.disabngo.blockynexus.e.b.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.animation.Animation;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0785yd;
import com.disabngo.blockynexus.entity.ConversationClickStateHolder;
import com.disabngo.blockynexus.view.activity.main.nc;
import com.sandboxol.center.aims.MainPageAnimation;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.o.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChatFragment.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ValidFragment"})
public class C0891o extends BaseFragment<x, AbstractC0785yd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private nc f10001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private x f10002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10003c;

    public C0891o(nc ncVar, Context context) {
        this.f10001a = ncVar;
        this.f10002b = new x(context, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0785yd abstractC0785yd, x xVar) {
        abstractC0785yd.a(xVar);
        abstractC0785yd.a(this.f10001a);
    }

    public String g() {
        return this.f10003c;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_chat;
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return new MainPageAnimation(z, 3);
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
        try {
            ConversationClickStateHolder.getInstance().setState(1);
        } catch (Exception unused) {
            ReportDataAdapter.onEvent(this.context, EventConstant.ON_RESUME_EXCEPTION, "ChatFragment");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public x getViewModel() {
        return this.f10002b;
    }

    public void a(String str) {
        this.f10003c = str;
    }
}
