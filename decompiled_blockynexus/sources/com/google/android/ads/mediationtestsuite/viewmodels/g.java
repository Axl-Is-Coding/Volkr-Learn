package com.google.android.ads.mediationtestsuite.viewmodels;

import com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel;

/* JADX INFO: compiled from: InfoLabelViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements ListItemViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TestState f12709c;

    public g(String str, String str2) {
        this(str, str2, null);
    }

    public String a() {
        return this.f12708b;
    }

    public TestState b() {
        return this.f12709c;
    }

    public String c() {
        return this.f12707a;
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.ListItemViewModel
    public ListItemViewModel.ViewType getViewType() {
        return ListItemViewModel.ViewType.INFO_LABEL;
    }

    public g(String str, String str2, TestState testState) {
        this.f12707a = str;
        this.f12708b = str2;
        this.f12709c = testState;
    }
}
