package com.sandboxol.gamedetail.c.a.c;

import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.gamedetail.R;
import rx.functions.Action1;

/* JADX INFO: compiled from: GameDetailRankViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class n extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Integer> f18094a = new ObservableField<>(Integer.valueOf(R.id.rb_week));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> f18095b = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.gamedetail.c.a.c.e
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f18082a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<m>> f18096c = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.sandboxol.gamedetail.c.a.c.c
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f18080a.bindView(gVar, i, (ListItemViewModel) obj);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableList<m> f18097d = new ObservableArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand<Integer> f18098e = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.gamedetail.c.a.c.d
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f18081a.c(((Integer) obj).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Integer> f18099f = new ObservableField<>(0);

    public n(Context context, String str) {
        this.f18097d.add(new m(context, "week", str));
        this.f18097d.add(new m(context, "month", str));
        this.f18097d.add(new m(context, StringConstant.VIDEO_TYPE_ALL, str));
    }

    private void b(int i) {
        this.f18094a.set(Integer.valueOf(i));
        if (i == R.id.rb_week) {
            this.f18099f.set(0);
        } else if (i == R.id.rb_month) {
            this.f18099f.set(1);
        } else if (i == R.id.rb_all) {
            this.f18099f.set(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<m> listItemViewModel) {
        gVar.a(com.sandboxol.gamedetail.a.l, R.layout.content_game_detail_rank_page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (i == 0) {
            this.f18094a.set(Integer.valueOf(R.id.rb_week));
        } else if (i == 1) {
            this.f18094a.set(Integer.valueOf(R.id.rb_month));
        } else {
            if (i != 2) {
                return;
            }
            this.f18094a.set(Integer.valueOf(R.id.rb_all));
        }
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        b(checkedDataWrapper.getCheckedId());
    }
}
