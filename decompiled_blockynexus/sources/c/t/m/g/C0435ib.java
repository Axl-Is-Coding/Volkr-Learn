package c.t.m.g;

import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: renamed from: c.t.m.g.ib, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public class C0435ib {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile C0435ib f3239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f3240b = WheelView.DividerConfig.FILL;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f3241c = WheelView.DividerConfig.FILL;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f3242d = 100.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f3243e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f3244f = false;

    private C0435ib() {
    }

    public static C0435ib a() {
        if (f3239a == null) {
            synchronized (C0435ib.class) {
                if (f3239a == null) {
                    f3239a = new C0435ib();
                }
            }
        }
        return f3239a;
    }
}
