package com.sandboxol.decorate.manager;

import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.decorate.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ShopListFilter.java */
/* JADX INFO: loaded from: classes3.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f17206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f17207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f17208d;

    /* JADX INFO: compiled from: ShopListFilter.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final s f17209a = new s();
    }

    public static s c() {
        return a.f17209a;
    }

    public List<String> a() {
        return this.f17208d;
    }

    public void b(String str) {
        this.f17205a = str;
    }

    public String d() {
        this.f17205a = this.f17207c.get(0);
        return this.f17205a;
    }

    public String e() {
        this.f17206b = this.f17208d.get(0);
        return this.f17206b;
    }

    public List<String> f() {
        return this.f17207c;
    }

    public String g() {
        return this.f17205a;
    }

    public boolean h() {
        return this.f17205a.equals(d()) && this.f17206b.equals(e());
    }

    public void i() {
        b(this.f17207c.get(0));
        a(this.f17208d.get(0));
    }

    private s() {
        this.f17207c = new ArrayList();
        this.f17207c.add(BaseApplication.getContext().getString(R.string.decorate_new_dress_sort_default));
        this.f17207c.add(BaseApplication.getContext().getString(R.string.decorate_new_dress_sort_time));
        this.f17207c.add(BaseApplication.getContext().getString(R.string.decorate_new_dress_sort_price));
        this.f17208d = new ArrayList();
        this.f17208d.add(BaseApplication.getContext().getString(R.string.decorate_new_dress_filter_default));
        this.f17208d.add(BaseApplication.getContext().getString(R.string.decorate_new_dress_filter_gold));
        this.f17208d.add(BaseApplication.getContext().getString(R.string.decorate_new_dress_filter_diamond));
        this.f17208d.add(BaseApplication.getContext().getString(R.string.decorate_new_dress_filter_has));
    }

    public void a(String str) {
        this.f17206b = str;
    }

    public String b() {
        return this.f17206b;
    }
}
