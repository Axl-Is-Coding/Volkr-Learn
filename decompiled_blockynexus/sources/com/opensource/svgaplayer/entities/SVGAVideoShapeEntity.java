package com.opensource.svgaplayer.entities;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import com.umeng.analytics.pro.au;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.text.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SVGAVideoShapeEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SVGAVideoShapeEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Type f15499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, ? extends Object> f15500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f15501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Matrix f15502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Path f15503e;

    /* JADX INFO: compiled from: SVGAVideoShapeEntity.kt */
    public enum Type {
        shape,
        rect,
        ellipse,
        keep
    }

    /* JADX INFO: compiled from: SVGAVideoShapeEntity.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f15505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f15506c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f15509f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f15507d = "butt";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f15508e = "miter";
        private float[] g = new float[0];

        public final int a() {
            return this.f15504a;
        }

        public final String b() {
            return this.f15507d;
        }

        public final void c(int i) {
            this.f15505b = i;
        }

        public final String d() {
            return this.f15508e;
        }

        public final int e() {
            return this.f15509f;
        }

        public final int f() {
            return this.f15505b;
        }

        public final float g() {
            return this.f15506c;
        }

        public final void a(int i) {
            this.f15504a = i;
        }

        public final void b(String str) {
            i.b(str, "<set-?>");
            this.f15508e = str;
        }

        public final float[] c() {
            return this.g;
        }

        public final void a(float f2) {
            this.f15506c = f2;
        }

        public final void b(int i) {
            this.f15509f = i;
        }

        public final void a(String str) {
            i.b(str, "<set-?>");
            this.f15507d = str;
        }

        public final void a(float[] fArr) {
            i.b(fArr, "<set-?>");
            this.g = fArr;
        }
    }

    public SVGAVideoShapeEntity(JSONObject jSONObject) throws JSONException {
        i.b(jSONObject, "obj");
        this.f15499a = Type.shape;
        d(jSONObject);
        a(jSONObject);
        b(jSONObject);
        c(jSONObject);
    }

    private final void a(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("args");
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            i.a((Object) itKeys, "values.keys()");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObjectOptJSONObject.get(next);
                if (obj != null) {
                    map.put(next, obj);
                }
            }
            this.f15500b = map;
        }
    }

    public final Path b() {
        return this.f15503e;
    }

    public final a c() {
        return this.f15501c;
    }

    public final Matrix d() {
        return this.f15502d;
    }

    public final boolean e() {
        return this.f15499a == Type.keep;
    }

    private final void b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("styles");
        if (jSONObjectOptJSONObject != null) {
            a aVar = new a();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("fill");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 4) {
                double dOptDouble = jSONArrayOptJSONArray.optDouble(3);
                double d2 = 255;
                Double.isNaN(d2);
                double dOptDouble2 = jSONArrayOptJSONArray.optDouble(0);
                Double.isNaN(d2);
                int i = (int) (dOptDouble2 * d2);
                double dOptDouble3 = jSONArrayOptJSONArray.optDouble(1);
                Double.isNaN(d2);
                double dOptDouble4 = jSONArrayOptJSONArray.optDouble(2);
                Double.isNaN(d2);
                aVar.a(Color.argb((int) (dOptDouble * d2), i, (int) (dOptDouble3 * d2), (int) (dOptDouble4 * d2)));
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("stroke");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 4) {
                double dOptDouble5 = jSONArrayOptJSONArray2.optDouble(3);
                double d3 = 255;
                Double.isNaN(d3);
                int i2 = (int) (dOptDouble5 * d3);
                double dOptDouble6 = jSONArrayOptJSONArray2.optDouble(0);
                Double.isNaN(d3);
                double dOptDouble7 = jSONArrayOptJSONArray2.optDouble(1);
                Double.isNaN(d3);
                double dOptDouble8 = jSONArrayOptJSONArray2.optDouble(2);
                Double.isNaN(d3);
                aVar.c(Color.argb(i2, (int) (dOptDouble6 * d3), (int) (dOptDouble7 * d3), (int) (dOptDouble8 * d3)));
            }
            aVar.a((float) jSONObjectOptJSONObject.optDouble("strokeWidth", 0.0d));
            String strOptString = jSONObjectOptJSONObject.optString("lineCap", "butt");
            i.a((Object) strOptString, "it.optString(\"lineCap\", \"butt\")");
            aVar.a(strOptString);
            String strOptString2 = jSONObjectOptJSONObject.optString("lineJoin", "miter");
            i.a((Object) strOptString2, "it.optString(\"lineJoin\", \"miter\")");
            aVar.b(strOptString2);
            aVar.b(jSONObjectOptJSONObject.optInt("miterLimit", 0));
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("lineDash");
            if (jSONArrayOptJSONArray3 != null) {
                aVar.a(new float[jSONArrayOptJSONArray3.length()]);
                int length = jSONArrayOptJSONArray3.length();
                for (int i3 = 0; i3 < length; i3++) {
                    aVar.c()[i3] = (float) jSONArrayOptJSONArray3.optDouble(i3, 0.0d);
                }
            }
            this.f15501c = aVar;
        }
    }

    private final void c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("transform");
        if (jSONObjectOptJSONObject != null) {
            Matrix matrix = new Matrix();
            double dOptDouble = jSONObjectOptJSONObject.optDouble(au.at, 1.0d);
            double dOptDouble2 = jSONObjectOptJSONObject.optDouble("b", 0.0d);
            float f2 = (float) 0.0d;
            matrix.setValues(new float[]{(float) dOptDouble, (float) jSONObjectOptJSONObject.optDouble("c", 0.0d), (float) jSONObjectOptJSONObject.optDouble("tx", 0.0d), (float) dOptDouble2, (float) jSONObjectOptJSONObject.optDouble(au.au, 1.0d), (float) jSONObjectOptJSONObject.optDouble("ty", 0.0d), f2, f2, (float) 1.0d});
            this.f15502d = matrix;
        }
    }

    private final void d(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("type");
        if (strOptString != null) {
            if (n.b(strOptString, "shape", true)) {
                this.f15499a = Type.shape;
                return;
            }
            if (n.b(strOptString, "rect", true)) {
                this.f15499a = Type.rect;
            } else if (n.b(strOptString, "ellipse", true)) {
                this.f15499a = Type.ellipse;
            } else if (n.b(strOptString, "keep", true)) {
                this.f15499a = Type.keep;
            }
        }
    }

    public SVGAVideoShapeEntity(ShapeEntity shapeEntity) {
        i.b(shapeEntity, "obj");
        this.f15499a = Type.shape;
        d(shapeEntity);
        a(shapeEntity);
        b(shapeEntity);
        c(shapeEntity);
    }

    private final void d(ShapeEntity shapeEntity) {
        Type type;
        ShapeEntity.ShapeType shapeType = shapeEntity.type;
        if (shapeType != null) {
            int i = d.f15519a[shapeType.ordinal()];
            if (i == 1) {
                type = Type.shape;
            } else if (i == 2) {
                type = Type.rect;
            } else if (i == 3) {
                type = Type.ellipse;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                type = Type.keep;
            }
            this.f15499a = type;
        }
    }

    private final void a(ShapeEntity shapeEntity) {
        String str;
        HashMap map = new HashMap();
        ShapeEntity.ShapeArgs shapeArgs = shapeEntity.shape;
        if (shapeArgs != null && (str = shapeArgs.f15570d) != null) {
            map.put(au.au, str);
        }
        ShapeEntity.EllipseArgs ellipseArgs = shapeEntity.ellipse;
        if (ellipseArgs != null) {
            Float fValueOf = ellipseArgs.x;
            if (fValueOf == null) {
                fValueOf = Float.valueOf(WheelView.DividerConfig.FILL);
            }
            map.put("x", fValueOf);
            Float fValueOf2 = ellipseArgs.y;
            if (fValueOf2 == null) {
                fValueOf2 = Float.valueOf(WheelView.DividerConfig.FILL);
            }
            map.put("y", fValueOf2);
            Float fValueOf3 = ellipseArgs.radiusX;
            if (fValueOf3 == null) {
                fValueOf3 = Float.valueOf(WheelView.DividerConfig.FILL);
            }
            map.put("radiusX", fValueOf3);
            Float fValueOf4 = ellipseArgs.radiusY;
            if (fValueOf4 == null) {
                fValueOf4 = Float.valueOf(WheelView.DividerConfig.FILL);
            }
            map.put("radiusY", fValueOf4);
        }
        ShapeEntity.RectArgs rectArgs = shapeEntity.rect;
        if (rectArgs != null) {
            Float fValueOf5 = rectArgs.x;
            if (fValueOf5 == null) {
                fValueOf5 = Float.valueOf(WheelView.DividerConfig.FILL);
            }
            map.put("x", fValueOf5);
            Float fValueOf6 = rectArgs.y;
            if (fValueOf6 == null) {
                fValueOf6 = Float.valueOf(WheelView.DividerConfig.FILL);
            }
            map.put("y", fValueOf6);
            Float fValueOf7 = rectArgs.width;
            if (fValueOf7 == null) {
                fValueOf7 = Float.valueOf(WheelView.DividerConfig.FILL);
            }
            map.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, fValueOf7);
            Float fValueOf8 = rectArgs.height;
            if (fValueOf8 == null) {
                fValueOf8 = Float.valueOf(WheelView.DividerConfig.FILL);
            }
            map.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, fValueOf8);
            Float fValueOf9 = rectArgs.cornerRadius;
            if (fValueOf9 == null) {
                fValueOf9 = Float.valueOf(WheelView.DividerConfig.FILL);
            }
            map.put("cornerRadius", fValueOf9);
        }
        this.f15500b = map;
    }

    private final void c(ShapeEntity shapeEntity) {
        Transform transform = shapeEntity.transform;
        if (transform != null) {
            Matrix matrix = new Matrix();
            float[] fArr = new float[9];
            Float f2 = transform.f15576a;
            float fFloatValue = f2 != null ? f2.floatValue() : 1.0f;
            Float f3 = transform.f15577b;
            float fFloatValue2 = f3 != null ? f3.floatValue() : WheelView.DividerConfig.FILL;
            Float f4 = transform.f15578c;
            float fFloatValue3 = f4 != null ? f4.floatValue() : WheelView.DividerConfig.FILL;
            Float f5 = transform.f15579d;
            float fFloatValue4 = f5 != null ? f5.floatValue() : 1.0f;
            Float f6 = transform.tx;
            float fFloatValue5 = f6 != null ? f6.floatValue() : WheelView.DividerConfig.FILL;
            Float f7 = transform.ty;
            float fFloatValue6 = f7 != null ? f7.floatValue() : WheelView.DividerConfig.FILL;
            fArr[0] = fFloatValue;
            fArr[1] = fFloatValue3;
            fArr[2] = fFloatValue5;
            fArr[3] = fFloatValue2;
            fArr[4] = fFloatValue4;
            fArr[5] = fFloatValue6;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            matrix.setValues(fArr);
            this.f15502d = matrix;
        }
    }

    private final void b(ShapeEntity shapeEntity) {
        ShapeEntity.ShapeStyle shapeStyle = shapeEntity.styles;
        if (shapeStyle != null) {
            a aVar = new a();
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor = shapeStyle.fill;
            float fFloatValue = WheelView.DividerConfig.FILL;
            if (rGBAColor != null) {
                Float f2 = rGBAColor.f15572a;
                float f3 = 255;
                int iFloatValue = (int) ((f2 != null ? f2.floatValue() : WheelView.DividerConfig.FILL) * f3);
                Float f4 = rGBAColor.r;
                int iFloatValue2 = (int) ((f4 != null ? f4.floatValue() : WheelView.DividerConfig.FILL) * f3);
                Float f5 = rGBAColor.g;
                int iFloatValue3 = (int) ((f5 != null ? f5.floatValue() : WheelView.DividerConfig.FILL) * f3);
                Float f6 = rGBAColor.f15573b;
                aVar.a(Color.argb(iFloatValue, iFloatValue2, iFloatValue3, (int) ((f6 != null ? f6.floatValue() : WheelView.DividerConfig.FILL) * f3)));
            }
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor2 = shapeStyle.stroke;
            if (rGBAColor2 != null) {
                Float f7 = rGBAColor2.f15572a;
                float f8 = 255;
                int iFloatValue4 = (int) ((f7 != null ? f7.floatValue() : WheelView.DividerConfig.FILL) * f8);
                Float f9 = rGBAColor2.r;
                int iFloatValue5 = (int) ((f9 != null ? f9.floatValue() : WheelView.DividerConfig.FILL) * f8);
                Float f10 = rGBAColor2.g;
                int iFloatValue6 = (int) ((f10 != null ? f10.floatValue() : WheelView.DividerConfig.FILL) * f8);
                Float f11 = rGBAColor2.f15573b;
                aVar.c(Color.argb(iFloatValue4, iFloatValue5, iFloatValue6, (int) ((f11 != null ? f11.floatValue() : WheelView.DividerConfig.FILL) * f8)));
            }
            Float f12 = shapeStyle.strokeWidth;
            aVar.a(f12 != null ? f12.floatValue() : WheelView.DividerConfig.FILL);
            ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
            if (lineCap != null) {
                int i = d.f15520b[lineCap.ordinal()];
                if (i == 1) {
                    aVar.a("butt");
                } else if (i == 2) {
                    aVar.a("round");
                } else if (i == 3) {
                    aVar.a(MessengerShareContentUtility.IMAGE_RATIO_SQUARE);
                }
            }
            ShapeEntity.ShapeStyle.LineJoin lineJoin = shapeStyle.lineJoin;
            if (lineJoin != null) {
                int i2 = d.f15521c[lineJoin.ordinal()];
                if (i2 == 1) {
                    aVar.b("bevel");
                } else if (i2 == 2) {
                    aVar.b("miter");
                } else if (i2 == 3) {
                    aVar.b("round");
                }
            }
            Float f13 = shapeStyle.miterLimit;
            if (f13 != null) {
                fFloatValue = f13.floatValue();
            }
            aVar.b((int) fFloatValue);
            aVar.a(new float[3]);
            Float f14 = shapeStyle.lineDashI;
            if (f14 != null) {
                aVar.c()[0] = f14.floatValue();
            }
            Float f15 = shapeStyle.lineDashII;
            if (f15 != null) {
                aVar.c()[1] = f15.floatValue();
            }
            Float f16 = shapeStyle.lineDashIII;
            if (f16 != null) {
                aVar.c()[2] = f16.floatValue();
            }
            this.f15501c = aVar;
        }
    }

    public final void a() {
        if (this.f15503e != null) {
            return;
        }
        e.a().reset();
        Type type = this.f15499a;
        if (type == Type.shape) {
            Map<String, ? extends Object> map = this.f15500b;
            Object obj = map != null ? map.get(au.au) : null;
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str = (String) obj;
            if (str != null) {
                new b(str).a(e.a());
            }
        } else if (type == Type.ellipse) {
            Map<String, ? extends Object> map2 = this.f15500b;
            Object obj2 = map2 != null ? map2.get("x") : null;
            if (!(obj2 instanceof Number)) {
                obj2 = null;
            }
            Number number = (Number) obj2;
            if (number == null) {
                return;
            }
            Map<String, ? extends Object> map3 = this.f15500b;
            Object obj3 = map3 != null ? map3.get("y") : null;
            if (!(obj3 instanceof Number)) {
                obj3 = null;
            }
            Number number2 = (Number) obj3;
            if (number2 == null) {
                return;
            }
            Map<String, ? extends Object> map4 = this.f15500b;
            Object obj4 = map4 != null ? map4.get("radiusX") : null;
            if (!(obj4 instanceof Number)) {
                obj4 = null;
            }
            Number number3 = (Number) obj4;
            if (number3 == null) {
                return;
            }
            Map<String, ? extends Object> map5 = this.f15500b;
            Object obj5 = map5 != null ? map5.get("radiusY") : null;
            Number number4 = (Number) (obj5 instanceof Number ? obj5 : null);
            if (number4 == null) {
                return;
            }
            float fFloatValue = number.floatValue();
            float fFloatValue2 = number2.floatValue();
            float fFloatValue3 = number3.floatValue();
            float fFloatValue4 = number4.floatValue();
            e.a().addOval(new RectF(fFloatValue - fFloatValue3, fFloatValue2 - fFloatValue4, fFloatValue + fFloatValue3, fFloatValue2 + fFloatValue4), Path.Direction.CW);
        } else if (type == Type.rect) {
            Map<String, ? extends Object> map6 = this.f15500b;
            Object obj6 = map6 != null ? map6.get("x") : null;
            if (!(obj6 instanceof Number)) {
                obj6 = null;
            }
            Number number5 = (Number) obj6;
            if (number5 == null) {
                return;
            }
            Map<String, ? extends Object> map7 = this.f15500b;
            Object obj7 = map7 != null ? map7.get("y") : null;
            if (!(obj7 instanceof Number)) {
                obj7 = null;
            }
            Number number6 = (Number) obj7;
            if (number6 == null) {
                return;
            }
            Map<String, ? extends Object> map8 = this.f15500b;
            Object obj8 = map8 != null ? map8.get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) : null;
            if (!(obj8 instanceof Number)) {
                obj8 = null;
            }
            Number number7 = (Number) obj8;
            if (number7 == null) {
                return;
            }
            Map<String, ? extends Object> map9 = this.f15500b;
            Object obj9 = map9 != null ? map9.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) : null;
            if (!(obj9 instanceof Number)) {
                obj9 = null;
            }
            Number number8 = (Number) obj9;
            if (number8 == null) {
                return;
            }
            Map<String, ? extends Object> map10 = this.f15500b;
            Object obj10 = map10 != null ? map10.get("cornerRadius") : null;
            Number number9 = (Number) (obj10 instanceof Number ? obj10 : null);
            if (number9 == null) {
                return;
            }
            float fFloatValue5 = number5.floatValue();
            float fFloatValue6 = number6.floatValue();
            float fFloatValue7 = number7.floatValue();
            float fFloatValue8 = number8.floatValue();
            float fFloatValue9 = number9.floatValue();
            e.a().addRoundRect(new RectF(fFloatValue5, fFloatValue6, fFloatValue7 + fFloatValue5, fFloatValue8 + fFloatValue6), fFloatValue9, fFloatValue9, Path.Direction.CW);
        }
        this.f15503e = new Path();
        Path path = this.f15503e;
        if (path != null) {
            path.set(e.a());
        }
    }
}
