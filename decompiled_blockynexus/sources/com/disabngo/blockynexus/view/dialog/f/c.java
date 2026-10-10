package com.disabngo.blockynexus.view.dialog.f;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.ScrapHistoryInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;

/* JADX INFO: compiled from: ScrapHistoryItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends ListItemViewModel<ScrapHistoryInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f11558a;

    public c(Context context, ScrapHistoryInfo scrapHistoryInfo) {
        super(context, scrapHistoryInfo);
        this.f11558a = new ObservableField<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        if (((ScrapHistoryInfo) this.item).getAmount() <= 1) {
            this.f11558a.set(((ScrapHistoryInfo) this.item).getRewardName());
            return;
        }
        this.f11558a.set(((ScrapHistoryInfo) this.item).getRewardName() + " x" + ((ScrapHistoryInfo) this.item).getAmount());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ScrapHistoryInfo getItem() {
        f();
        return (ScrapHistoryInfo) super.getItem();
    }
}
