package com.google.android.ads.mediationtestsuite.viewmodels;

import android.content.Context;
import com.google.android.ads.mediationtestsuite.dataobjects.Caption;
import com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel;
import java.util.List;

/* JADX INFO: compiled from: DetailItemViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements ListItemViewModel {
    private boolean checked;

    public abstract List<Caption> getCaptions();

    public abstract String getDetailText(Context context);

    public abstract String getTitleText(Context context);

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel
    public ListItemViewModel.ViewType getViewType() {
        return ListItemViewModel.ViewType.DETAIL_ITEM;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public boolean shouldEnableCheckbox() {
        return false;
    }

    public abstract boolean shouldShowCheckbox();
}
