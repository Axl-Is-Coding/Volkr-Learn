package com.disabngo.blockynexus.e.b.xa;

import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0544cd;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.BannerEntity;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: VideoRecommendViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractC0544cd f10345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableList<String> f10346b = new ObservableArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableList<String> f10347c = new ObservableArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableList<BannerEntity> f10348d = new ObservableArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f10349e = new ObservableField<>(Integer.valueOf(R.id.rbNew));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> f10350f = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.xa.d
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10326a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });
    public me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<p>> g = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.disabngo.blockynexus.e.b.xa.e
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f10327a.bindView(gVar, i, (ListItemViewModel) obj);
        }
    });
    public ObservableList<p> h = new ObservableArrayList();
    public ReplyCommand<Integer> i = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.xa.c
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10325a.c(((Integer) obj).intValue());
        }
    });
    public ObservableField<Integer> j = new ObservableField<>(0);
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.xa.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f10324a.onRefresh();
        }
    });
    public ReplyCommand<Integer> l = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.xa.f
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10328a.a((Integer) obj);
        }
    });
    public ObservableField<Boolean> m = new ObservableField<>(true);
    private i n;
    private Context o;

    public q(Context context, AbstractC0544cd abstractC0544cd) {
        this.f10345a = abstractC0544cd;
        this.o = context;
        b(context);
    }

    private void b(Context context) {
        if (this.n == null) {
            this.n = new i();
        }
        if (this.h.isEmpty()) {
            this.h.add(new p(context, "new", null));
            this.h.add(new p(context, "top", null));
        }
        this.n.a(context, this.f10347c, this.f10346b, this.f10348d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<p> listItemViewModel) {
        gVar.a(1, R.layout.content_app_video_recommend_page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        this.m.set(true);
        if (i == 0) {
            this.h.get(0).a(this.m);
            this.f10349e.set(Integer.valueOf(R.id.rbNew));
            a(16, 14);
        } else {
            if (i != 1) {
                return;
            }
            this.h.get(1).a(this.m);
            this.f10349e.set(Integer.valueOf(R.id.rbHot));
            a(14, 16);
        }
    }

    private void onLoadMore() {
        i iVar = this.n;
        if (iVar != null) {
            iVar.a(this.f10349e.get().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRefresh() {
        i iVar = this.n;
        if (iVar != null) {
            iVar.a(this.o, this.f10347c, this.f10346b, this.f10348d);
            this.n.b(this.f10349e.get().intValue());
        }
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        b(checkedDataWrapper.getCheckedId());
    }

    public /* synthetic */ void a(Integer num) {
        onLoadMore();
    }

    private void a(int i, int i2) {
        AbstractC0544cd abstractC0544cd = this.f10345a;
        if (abstractC0544cd != null) {
            abstractC0544cd.f8226c.setTextSize(2, i);
            this.f10345a.f8225b.setTextSize(2, i2);
        }
    }

    private void b(int i) {
        this.m.set(true);
        if (i == R.id.rbHot) {
            this.h.get(1).a(this.m);
            this.j.set(1);
            a(14, 16);
            ReportDataAdapter.onEvent(this.o, EventConstant.VEDIO_BEST_CLICK);
            return;
        }
        if (i != R.id.rbNew) {
            return;
        }
        this.h.get(0).a(this.m);
        this.j.set(0);
        a(16, 14);
        ReportDataAdapter.onEvent(this.o, EventConstant.VEDIO_NEWEST_CLICK);
    }
}
