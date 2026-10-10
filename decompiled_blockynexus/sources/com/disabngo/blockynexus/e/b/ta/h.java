package com.disabngo.blockynexus.e.b.ta;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.x.C0935C;
import com.disabngo.blockynexus.entity.TribeShopPageList;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeShopCarViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<TribeShopPageList> f10191b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f10194e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f10192c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0935C f10193d = new C0935C();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f10195f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ta.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f10187a.i();
        }
    });
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ta.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f10188a.h();
        }
    });

    public h(Context context, List<TribeShopPageList> list) {
        this.f10190a = context;
        this.f10191b = list;
        this.f10194e = new i(context, R.string.tribe_not_goods, list);
        f();
    }

    private void f() {
        int price = 0;
        for (TribeShopPageList tribeShopPageList : this.f10191b) {
            if (tribeShopPageList.getHasPurchase() != 1) {
                price += tribeShopPageList.getPrice();
            }
        }
        this.f10192c.set(Integer.valueOf(price));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String[] strArr = new String[this.f10191b.size()];
        int size = this.f10191b.size();
        for (int i = 0; i < size; i++) {
            strArr[i] = String.valueOf(this.f10191b.get(i).getId());
        }
        TribeApi.buyDecoration(this.f10190a, strArr, new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Context context = this.f10190a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ka.h.class, context.getString(R.string.tribe_donate));
    }
}
