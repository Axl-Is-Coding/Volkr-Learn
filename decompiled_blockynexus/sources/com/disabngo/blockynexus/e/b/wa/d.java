package com.disabngo.blockynexus.e.b.wa;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.xa.g;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action1;

/* JADX INFO: compiled from: VideoViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseFragment f10269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseFragment f10270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g f10271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.disabngo.blockynexus.e.b.ya.c f10272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f10273f;
    public ObservableField<Integer> g = new ObservableField<>(Integer.valueOf(R.id.rbRecommend));
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> h = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.wa.a
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10267a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });

    public d(Context context, b bVar) {
        this.f10268a = context;
        this.f10269b = bVar;
        initData();
        initView();
    }

    private void b(int i) {
        if (i == R.id.rbAll) {
            this.g.set(Integer.valueOf(R.id.rbAll));
            a(1, this.f10269b, this.f10272e, null);
            ReportDataAdapter.onEvent(this.f10268a, EventConstant.VEDIO_ALL_CLICK);
        } else {
            if (i != R.id.rbRecommend) {
                return;
            }
            this.g.set(Integer.valueOf(R.id.rbRecommend));
            a(0, this.f10269b, this.f10271d, null);
            ReportDataAdapter.onEvent(this.f10268a, EventConstant.VEDIO_RECO_CLICK);
        }
    }

    private void initData() {
        if (this.f10273f == null) {
            this.f10273f = new c();
        }
    }

    private void initView() {
        b(R.id.rbRecommend);
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        b(checkedDataWrapper.getCheckedId());
    }

    public void a(int i, BaseFragment baseFragment, BaseFragment baseFragment2, Bundle bundle) {
        AbstractC0336n fragmentManager = baseFragment.getFragmentManager();
        if (fragmentManager != null) {
            F fA = fragmentManager.a();
            fA.a(0);
            if (baseFragment2 == null) {
                if (i == 0) {
                    this.f10271d = new g();
                    baseFragment2 = this.f10271d;
                    if (bundle != null) {
                        baseFragment2.setArguments(bundle);
                    }
                    if (fragmentManager.a("VideoRecommendFragment") == null) {
                        fA.a(R.id.flVideo, baseFragment2, "VideoRecommendFragment");
                        fA.c(baseFragment2);
                    }
                } else if (i == 1) {
                    this.f10272e = new com.disabngo.blockynexus.e.b.ya.c();
                    baseFragment2 = this.f10272e;
                    if (bundle != null) {
                        baseFragment2.setArguments(bundle);
                    }
                    if (fragmentManager.a("VideoTotalFragment") == null) {
                        fA.a(R.id.flVideo, baseFragment2, "VideoTotalFragment");
                        fA.c(baseFragment2);
                    }
                }
            }
            BaseFragment baseFragment3 = this.f10270c;
            if (baseFragment3 != null) {
                fA.c(baseFragment3);
            }
            fA.e(baseFragment2);
            this.f10270c = baseFragment2;
            fA.b();
        }
    }
}
