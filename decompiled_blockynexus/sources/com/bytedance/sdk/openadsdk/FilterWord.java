package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FilterWord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<FilterWord> f5587d;

    public FilterWord(String str, String str2) {
        this.f5584a = str;
        this.f5585b = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.f5587d == null) {
            this.f5587d = new ArrayList();
        }
        this.f5587d.add(filterWord);
    }

    public String getId() {
        return this.f5584a;
    }

    public boolean getIsSelected() {
        return this.f5586c;
    }

    public String getName() {
        return this.f5585b;
    }

    public List<FilterWord> getOptions() {
        return this.f5587d;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.f5587d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.f5584a) || TextUtils.isEmpty(this.f5585b)) ? false : true;
    }

    public void setId(String str) {
        this.f5584a = str;
    }

    public void setIsSelected(boolean z) {
        this.f5586c = z;
    }

    public void setName(String str) {
        this.f5585b = str;
    }

    public FilterWord() {
    }
}
