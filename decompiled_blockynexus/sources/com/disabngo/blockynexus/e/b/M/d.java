package com.disabngo.blockynexus.e.b.M;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.StarCodeUserIncomeInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;

/* JADX INFO: compiled from: IncomePageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends ListItemViewModel<StarCodeUserIncomeInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f9348a;

    public d(Context context, StarCodeUserIncomeInfo starCodeUserIncomeInfo) {
        super(context, starCodeUserIncomeInfo);
        this.f9348a = new ObservableField<>();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public StarCodeUserIncomeInfo getItem() {
        int status = ((StarCodeUserIncomeInfo) this.item).getStatus();
        if (status == 0) {
            this.f9348a.set(this.context.getString(R.string.item_income_tv_left, ((StarCodeUserIncomeInfo) this.item).getNickName()));
        } else if (status == 1) {
            this.f9348a.set(this.context.getString(R.string.item_income_tv_left_convert));
        } else if (status == 2) {
            this.f9348a.set(this.context.getString(R.string.item_income_tv_left_refund, ((StarCodeUserIncomeInfo) this.item).getNickName()));
        }
        return (StarCodeUserIncomeInfo) super.getItem();
    }
}
