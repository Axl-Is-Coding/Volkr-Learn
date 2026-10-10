package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;

/* JADX INFO: compiled from: NewUMIDTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class m extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21217a = "newumid";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21218b;

    public m(Context context) {
        super(f21217a);
        this.f21218b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return UMEnvelopeBuild.imprintProperty(this.f21218b, au.f20663f, null);
    }
}
