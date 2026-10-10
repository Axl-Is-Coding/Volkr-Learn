package com.disabngo.blockynexus.view.activity.overviewrank;

import android.app.Activity;
import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import me.tatarka.bindingcollectionadapter2.l;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: OverViewRankViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f11056b = new ObservableField<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f11057c = new ObservableField<>(Integer.valueOf(R.id.rb_week_tab));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Integer> f11058d = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableList<j> f11059e = new ObservableArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public me.tatarka.bindingcollectionadapter2.g<j> f11060f = me.tatarka.bindingcollectionadapter2.g.a(new l() { // from class: com.disabngo.blockynexus.view.activity.overviewrank.e
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f11043a.a(gVar, i, (j) obj);
        }
    });
    public ReplyCommand<Integer> g = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.activity.overviewrank.d
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11042a.b(((Integer) obj).intValue());
        }
    });
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> h = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.activity.overviewrank.b
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11040a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.overviewrank.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f11041a.f();
        }
    });

    public k(Context context) {
        this.f11055a = context;
        this.f11059e.add(new j(context, "week"));
        this.f11059e.add(new j(context, "overall"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i == 0) {
            this.f11057c.set(Integer.valueOf(R.id.rb_week_tab));
            this.f11056b.set(Integer.valueOf(i));
        } else if (i == 1) {
            this.f11057c.set(Integer.valueOf(R.id.rb_overall_tab));
            this.f11056b.set(Integer.valueOf(i));
        }
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        this.f11057c.set(Integer.valueOf(checkedDataWrapper.getCheckedId()));
        if (checkedDataWrapper.getCheckedId() == R.id.rb_week_tab) {
            this.f11058d.set(0);
            ReportDataAdapter.onEvent(this.f11055a, EventConstant.RANK_WEEK_CLICK);
        } else if (checkedDataWrapper.getCheckedId() == R.id.rb_overall_tab) {
            this.f11058d.set(1);
            ReportDataAdapter.onEvent(this.f11055a, EventConstant.RANK_ALL_CLICK);
        }
    }

    public /* synthetic */ void f() {
        ((Activity) this.f11055a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, j jVar) {
        if (i == 0) {
            gVar.a(386, R.layout.content_rank_week_type_page);
        } else {
            gVar.a(386, R.layout.content_rank_overall_type_page);
        }
    }
}
