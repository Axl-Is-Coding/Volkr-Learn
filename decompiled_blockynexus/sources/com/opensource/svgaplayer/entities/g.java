package com.opensource.svgaplayer.entities;

import android.graphics.Matrix;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.Layout;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import com.umeng.analytics.pro.au;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.jvm.internal.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SVGAVideoSpriteFrameEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f15526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.opensource.svgaplayer.b.c f15527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Matrix f15528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f15529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<SVGAVideoShapeEntity> f15530e;

    public g(JSONObject jSONObject) {
        int i;
        boolean z;
        i.b(jSONObject, "obj");
        this.f15527b = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.f15528c = new Matrix();
        this.f15530e = m.a();
        this.f15526a = jSONObject.optDouble("alpha", 0.0d);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("layout");
        if (jSONObjectOptJSONObject != null) {
            this.f15527b = new com.opensource.svgaplayer.b.c(jSONObjectOptJSONObject.optDouble("x", 0.0d), jSONObjectOptJSONObject.optDouble("y", 0.0d), jSONObjectOptJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0.0d), jSONObjectOptJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0.0d));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("transform");
        if (jSONObjectOptJSONObject2 != null) {
            i = 0;
            z = true;
            float f2 = (float) 0.0d;
            this.f15528c.setValues(new float[]{(float) jSONObjectOptJSONObject2.optDouble(au.at, 1.0d), (float) jSONObjectOptJSONObject2.optDouble("c", 0.0d), (float) jSONObjectOptJSONObject2.optDouble("tx", 0.0d), (float) jSONObjectOptJSONObject2.optDouble("b", 0.0d), (float) jSONObjectOptJSONObject2.optDouble(au.au, 1.0d), (float) jSONObjectOptJSONObject2.optDouble("ty", 0.0d), f2, f2, (float) 1.0d});
        } else {
            i = 0;
            z = true;
        }
        String strOptString = jSONObject.optString("clipPath");
        if (strOptString != null) {
            if (strOptString.length() <= 0 ? false : z) {
                this.f15529d = new b(strOptString);
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("shapes");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            while (i < length) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject3 != null) {
                    arrayList.add(new SVGAVideoShapeEntity(jSONObjectOptJSONObject3));
                }
                i++;
            }
            this.f15530e = u.b((Iterable) arrayList);
        }
    }

    public final double a() {
        return this.f15526a;
    }

    public final com.opensource.svgaplayer.b.c b() {
        return this.f15527b;
    }

    public final b c() {
        return this.f15529d;
    }

    public final List<SVGAVideoShapeEntity> d() {
        return this.f15530e;
    }

    public final Matrix e() {
        return this.f15528c;
    }

    public final void a(List<SVGAVideoShapeEntity> list) {
        i.b(list, "<set-?>");
        this.f15530e = list;
    }

    public g(FrameEntity frameEntity) {
        i.b(frameEntity, "obj");
        this.f15527b = new com.opensource.svgaplayer.b.c(0.0d, 0.0d, 0.0d, 0.0d);
        this.f15528c = new Matrix();
        this.f15530e = m.a();
        this.f15526a = frameEntity.alpha != null ? r0.floatValue() : WheelView.DividerConfig.FILL;
        Layout layout = frameEntity.layout;
        if (layout != null) {
            Float f2 = layout.x;
            double dFloatValue = f2 != null ? f2.floatValue() : WheelView.DividerConfig.FILL;
            Float f3 = layout.y;
            double dFloatValue2 = f3 != null ? f3.floatValue() : WheelView.DividerConfig.FILL;
            Float f4 = layout.width;
            this.f15527b = new com.opensource.svgaplayer.b.c(dFloatValue, dFloatValue2, f4 != null ? f4.floatValue() : WheelView.DividerConfig.FILL, layout.height != null ? r0.floatValue() : WheelView.DividerConfig.FILL);
        }
        Transform transform = frameEntity.transform;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f5 = transform.f15576a;
            float fFloatValue = f5 != null ? f5.floatValue() : 1.0f;
            Float f6 = transform.f15577b;
            float fFloatValue2 = f6 != null ? f6.floatValue() : WheelView.DividerConfig.FILL;
            Float f7 = transform.f15578c;
            float fFloatValue3 = f7 != null ? f7.floatValue() : WheelView.DividerConfig.FILL;
            Float f8 = transform.f15579d;
            float fFloatValue4 = f8 != null ? f8.floatValue() : 1.0f;
            Float f9 = transform.tx;
            float fFloatValue5 = f9 != null ? f9.floatValue() : WheelView.DividerConfig.FILL;
            Float f10 = transform.ty;
            float fFloatValue6 = f10 != null ? f10.floatValue() : WheelView.DividerConfig.FILL;
            fArr[0] = fFloatValue;
            fArr[1] = fFloatValue3;
            fArr[2] = fFloatValue5;
            fArr[3] = fFloatValue2;
            fArr[4] = fFloatValue4;
            fArr[5] = fFloatValue6;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            this.f15528c.setValues(fArr);
        }
        String str = frameEntity.clipPath;
        if (str != null) {
            str = str.length() > 0 ? str : null;
            if (str != null) {
                this.f15529d = new b(str);
            }
        }
        List<ShapeEntity> list = frameEntity.shapes;
        i.a((Object) list, "obj.shapes");
        ArrayList arrayList = new ArrayList(n.a(list, 10));
        for (ShapeEntity shapeEntity : list) {
            i.a((Object) shapeEntity, "it");
            arrayList.add(new SVGAVideoShapeEntity(shapeEntity));
        }
        this.f15530e = arrayList;
    }
}
