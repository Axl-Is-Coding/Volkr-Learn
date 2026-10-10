package com.disabngo.blockynexus.view.dialog.activity;

import android.content.Context;
import com.disabngo.blockynexus.entity.ActivityTaskTitleList;
import com.sandboxol.common.utils.DateUtils;
import com.tendcloud.tenddata.ab;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/* JADX INFO: compiled from: ActivityTaskCountDownUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static w f11510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f11511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Timer f11512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ActivityTaskTitleList f11513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f11514e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f11515f = 0;
    private long g = 0;
    private long h = 0;
    private long i = 0;
    private long j = 0;
    private long k = 0;
    private List<Long> l = new ArrayList();
    private List<Long> m = new ArrayList();
    private int n = 0;
    private int o = 0;
    private boolean p;

    private w(Context context) {
        this.f11511b = context;
    }

    private void c() {
        this.f11512c = new Timer();
        this.f11512c.schedule(new v(this), ab.R, ab.R);
    }

    public static w a(Context context) {
        if (f11510a == null) {
            f11510a = new w(context);
        }
        return f11510a;
    }

    public void b(List<Long> list) {
        List<Long> list2 = this.l;
        if (list2 == null) {
            return;
        }
        if (list2.size() > 0) {
            this.l.clear();
        }
        this.l.addAll(list);
        if (this.f11512c == null) {
            c();
        }
    }

    public void a(ActivityTaskTitleList activityTaskTitleList) {
        if (activityTaskTitleList == null) {
            return;
        }
        this.f11513d = activityTaskTitleList;
        this.n = 0;
        this.o = 0;
        this.p = DateUtils.isWeekend(activityTaskTitleList.getServerTime());
        this.g = activityTaskTitleList.getServerTime();
        this.h = activityTaskTitleList.getCumulativeTime() * 60 * 1000;
        long j = this.g;
        this.i = j - (j % 86400000);
        this.j = this.i + 86400000;
    }

    public boolean b() {
        return this.p;
    }

    public void a(List<Long> list) {
        List<Long> list2 = this.m;
        if (list2 == null) {
            return;
        }
        if (list2.size() > 0) {
            this.m.clear();
        }
        this.m.addAll(list);
        if (this.f11512c == null) {
            c();
        }
    }

    public long a() {
        return this.k;
    }

    public void a(long j) {
        this.f11514e = j;
    }
}
