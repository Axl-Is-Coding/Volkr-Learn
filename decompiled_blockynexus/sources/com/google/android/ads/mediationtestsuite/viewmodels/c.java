package com.google.android.ads.mediationtestsuite.viewmodels;

import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel;

/* JADX INFO: compiled from: AdLoadViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements ListItemViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NetworkConfig f12701a;

    public c(NetworkConfig networkConfig) {
        this.f12701a = networkConfig;
    }

    public NetworkConfig a() {
        return this.f12701a;
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel
    public ListItemViewModel.ViewType getViewType() {
        return ListItemViewModel.ViewType.AD_LOAD;
    }
}
