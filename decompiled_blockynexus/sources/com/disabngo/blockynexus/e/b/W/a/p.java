package com.disabngo.blockynexus.e.b.W.a;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action1;

/* JADX INFO: compiled from: ActiveRankViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Integer> f9498a = new ObservableField<>(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f9499b = new ObservableField<>(Integer.valueOf(R.id.rb_week_tab));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f9500c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableList<o> f9501d = new ObservableArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public me.tatarka.bindingcollectionadapter2.g<o> f9502e = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.disabngo.blockynexus.e.b.W.a.g
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f9473a.a(gVar, i, (o) obj);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand<Integer> f9503f = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.W.a.f
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9472a.b(((Integer) obj).intValue());
        }
    });
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> g = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.W.a.e
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9471a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });

    public p(Context context, Bundle bundle) {
        if (bundle != null) {
            int i = bundle.getInt("rank_period_type");
            this.f9501d.add(new o(context, i, 0));
            this.f9501d.add(new o(context, i, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i == 0) {
            this.f9499b.set(Integer.valueOf(R.id.rb_area_tab));
            this.f9498a.set(Integer.valueOf(i));
        } else if (i == 1) {
            this.f9499b.set(Integer.valueOf(R.id.rb_global_tab));
            this.f9498a.set(Integer.valueOf(i));
        }
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        this.f9499b.set(Integer.valueOf(checkedDataWrapper.getCheckedId()));
        if (checkedDataWrapper.getCheckedId() == R.id.rb_area_tab) {
            this.f9500c.set(0);
        } else if (checkedDataWrapper.getCheckedId() == R.id.rb_global_tab) {
            this.f9500c.set(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, o oVar) {
        gVar.a(356, R.layout.content_rank_active_detail_page);
    }
}
