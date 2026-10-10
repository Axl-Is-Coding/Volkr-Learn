package b.e.a.a.a.a;

import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public float a(int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            return WheelView.DividerConfig.FILL;
        }
        float f2 = i / i2;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }
}
