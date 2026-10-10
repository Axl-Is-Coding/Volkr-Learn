package com.disabngo.blockynexus.e.b.W.b;

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

/* JADX INFO: compiled from: ClanRankViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Integer> f9536a = new ObservableField<>(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f9537b = new ObservableField<>(Integer.valueOf(R.id.rb_week_tab));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f9538c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableList<o> f9539d = new ObservableArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public me.tatarka.bindingcollectionadapter2.g<o> f9540e = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.disabngo.blockynexus.e.b.W.b.e
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f9509a.a(gVar, i, (o) obj);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand<Integer> f9541f = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.W.b.g
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9511a.b(((Integer) obj).intValue());
        }
    });
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> g = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.W.b.f
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9510a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });

    public p(Context context, Bundle bundle) {
        if (bundle != null) {
            this.f9539d.add(new o(context, bundle.getInt("rank_period_type"), 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i == 0) {
            this.f9537b.set(Integer.valueOf(R.id.rb_area_tab));
            this.f9536a.set(Integer.valueOf(i));
        } else if (i == 1) {
            this.f9537b.set(Integer.valueOf(R.id.rb_global_tab));
            this.f9536a.set(Integer.valueOf(i));
        }
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        this.f9537b.set(Integer.valueOf(checkedDataWrapper.getCheckedId()));
        if (checkedDataWrapper.getCheckedId() == R.id.rb_area_tab) {
            this.f9538c.set(0);
        } else if (checkedDataWrapper.getCheckedId() == R.id.rb_global_tab) {
            this.f9538c.set(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, o oVar) {
        gVar.a(408, R.layout.content_rank_clan_detail_page);
    }
}
