package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: PropertyValuesHolderUtils.java */
/* JADX INFO: loaded from: classes.dex */
class M {
    static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        return Build.VERSION.SDK_INT >= 21 ? PropertyValuesHolder.ofObject(property, (TypeConverter) null, path) : PropertyValuesHolder.ofFloat(new L(property, path), WheelView.DividerConfig.FILL, 1.0f);
    }
}
