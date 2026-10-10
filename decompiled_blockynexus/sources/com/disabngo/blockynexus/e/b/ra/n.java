package com.disabngo.blockynexus.e.b.ra;

import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRank;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeRankViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f10150b = new ObservableField<>(Integer.valueOf(R.id.rbWeek));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f10151c = new ObservableField<>(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<TribeRank> f10152d = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> f10153e = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.ra.e
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10132a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableList<l> f10154f = new ObservableArrayList();
    public me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<l>> g = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.disabngo.blockynexus.e.b.ra.g
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f10134a.bindView(gVar, i, (ListItemViewModel) obj);
        }
    });
    public ReplyCommand<Integer> h = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.ra.f
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10133a.c(((Integer) obj).intValue());
        }
    });

    public n(Context context) {
        this.f10149a = context;
        for (int i = 0; i < 3; i++) {
            this.f10154f.add(new l(context, b(i)));
        }
        c(0);
        f();
    }

    private String b(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "week" : StringConstant.VIDEO_TYPE_ALL : "month" : "week";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<l> listItemViewModel) {
        gVar.a(354, R.layout.content_tribe_rank_page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (i == 0) {
            this.f10150b.set(Integer.valueOf(R.id.rbWeek));
        } else if (i == 1) {
            this.f10150b.set(Integer.valueOf(R.id.rbMonth));
        } else if (i == 2) {
            this.f10150b.set(Integer.valueOf(R.id.rbAll));
        }
        f();
    }

    private void f() {
        TribeApi.getMyTribeRank(this.f10149a, b(this.f10151c.get().intValue()), new m(this));
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        this.f10150b.set(Integer.valueOf(checkedDataWrapper.getCheckedId()));
        int checkedId = checkedDataWrapper.getCheckedId();
        if (checkedId == R.id.rbAll) {
            this.f10151c.set(2);
        } else if (checkedId == R.id.rbMonth) {
            this.f10151c.set(1);
        } else if (checkedId == R.id.rbWeek) {
            this.f10151c.set(0);
        }
        f();
    }
}
