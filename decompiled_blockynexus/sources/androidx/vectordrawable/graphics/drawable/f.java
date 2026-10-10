package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.a.b;
import cn.qqtheme.framework.widget.WheelView;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AnimatorInflaterCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: compiled from: AnimatorInflaterCompat.java */
    private static class a implements TypeEvaluator<b.C0007b[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b.C0007b[] f2338a;

        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b.C0007b[] evaluate(float f2, b.C0007b[] c0007bArr, b.C0007b[] c0007bArr2) {
            if (!androidx.core.a.b.a(c0007bArr, c0007bArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!androidx.core.a.b.a(this.f2338a, c0007bArr)) {
                this.f2338a = androidx.core.a.b.a(c0007bArr);
            }
            for (int i = 0; i < c0007bArr.length; i++) {
                this.f2338a[i].a(c0007bArr[i], c0007bArr2[i], f2);
            }
            return this.f2338a;
        }
    }

    public static Animator a(Context context, int i) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i) : a(context, context.getResources(), context.getTheme(), i);
    }

    private static boolean a(int i) {
        return i >= 28 && i <= 31;
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, int i) throws Resources.NotFoundException {
        return a(context, resources, theme, i, 1.0f);
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, int i, float f2) throws Resources.NotFoundException {
        XmlResourceParser animation = null;
        try {
            try {
                try {
                    animation = resources.getAnimation(i);
                    return a(context, resources, theme, animation, f2);
                } catch (XmlPullParserException e2) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e2);
                    throw notFoundException;
                }
            } catch (IOException e3) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e3);
                throw notFoundException2;
            }
        } finally {
            if (animation != null) {
                animation.close();
            }
        }
    }

    private static PropertyValuesHolder a(TypedArray typedArray, int i, int i2, int i3, String str) {
        int color;
        int color2;
        int color3;
        float dimension;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        float dimension2;
        float dimension3;
        PropertyValuesHolder propertyValuesHolderOfObject;
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i5 = z2 ? typedValuePeekValue2.type : 0;
        if (i == 4) {
            i = ((z && a(i4)) || (z2 && a(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            b.C0007b[] c0007bArrA = androidx.core.a.b.a(string);
            b.C0007b[] c0007bArrA2 = androidx.core.a.b.a(string2);
            if (c0007bArrA == null && c0007bArrA2 == null) {
                return null;
            }
            if (c0007bArrA == null) {
                if (c0007bArrA2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), c0007bArrA2);
                }
                return null;
            }
            a aVar = new a();
            if (c0007bArrA2 != null) {
                if (androidx.core.a.b.a(c0007bArrA, c0007bArrA2)) {
                    propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, c0007bArrA, c0007bArrA2);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
            } else {
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, c0007bArrA);
            }
            return propertyValuesHolderOfObject;
        }
        g gVarA = i == 3 ? g.a() : null;
        if (z3) {
            if (z) {
                if (i4 == 5) {
                    dimension2 = typedArray.getDimension(i2, WheelView.DividerConfig.FILL);
                } else {
                    dimension2 = typedArray.getFloat(i2, WheelView.DividerConfig.FILL);
                }
                if (z2) {
                    if (i5 == 5) {
                        dimension3 = typedArray.getDimension(i3, WheelView.DividerConfig.FILL);
                    } else {
                        dimension3 = typedArray.getFloat(i3, WheelView.DividerConfig.FILL);
                    }
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension2, dimension3);
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension2);
                }
            } else {
                if (i5 == 5) {
                    dimension = typedArray.getDimension(i3, WheelView.DividerConfig.FILL);
                } else {
                    dimension = typedArray.getFloat(i3, WheelView.DividerConfig.FILL);
                }
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z) {
            if (i4 == 5) {
                color2 = (int) typedArray.getDimension(i2, WheelView.DividerConfig.FILL);
            } else if (a(i4)) {
                color2 = typedArray.getColor(i2, 0);
            } else {
                color2 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    color3 = (int) typedArray.getDimension(i3, WheelView.DividerConfig.FILL);
                } else if (a(i5)) {
                    color3 = typedArray.getColor(i3, 0);
                } else {
                    color3 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z2) {
            if (i5 == 5) {
                color = (int) typedArray.getDimension(i3, WheelView.DividerConfig.FILL);
            } else if (a(i5)) {
                color = typedArray.getColor(i3, 0);
            } else {
                color = typedArray.getInt(i3, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || gVarA == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(gVarA);
        return propertyValuesHolderOfInt;
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        long jB = androidx.core.content.a.i.b(typedArray, xmlPullParser, "duration", 1, 300);
        long jB2 = androidx.core.content.a.i.b(typedArray, xmlPullParser, "startOffset", 2, 0);
        int iB = androidx.core.content.a.i.b(typedArray, xmlPullParser, "valueType", 7, 4);
        if (androidx.core.content.a.i.a(xmlPullParser, "valueFrom") && androidx.core.content.a.i.a(xmlPullParser, "valueTo")) {
            if (iB == 4) {
                iB = a(typedArray, 5, 6);
            }
            PropertyValuesHolder propertyValuesHolderA = a(typedArray, iB, 5, 6, "");
            if (propertyValuesHolderA != null) {
                valueAnimator.setValues(propertyValuesHolderA);
            }
        }
        valueAnimator.setDuration(jB);
        valueAnimator.setStartDelay(jB2);
        valueAnimator.setRepeatCount(androidx.core.content.a.i.b(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(androidx.core.content.a.i.b(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            a(valueAnimator, typedArray2, iB, f2, xmlPullParser);
        }
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String strA = androidx.core.content.a.i.a(typedArray, xmlPullParser, "pathData", 1);
        if (strA != null) {
            String strA2 = androidx.core.content.a.i.a(typedArray, xmlPullParser, "propertyXName", 2);
            String strA3 = androidx.core.content.a.i.a(typedArray, xmlPullParser, "propertyYName", 3);
            if (i != 2) {
            }
            if (strA2 == null && strA3 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            a(androidx.core.a.b.b(strA), objectAnimator, f2 * 0.5f, strA2, strA3);
            return;
        }
        objectAnimator.setPropertyName(androidx.core.content.a.i.a(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void a(Path path, ObjectAnimator objectAnimator, float f2, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(WheelView.DividerConfig.FILL));
        float length = WheelView.DividerConfig.FILL;
        do {
            length += pathMeasure.getLength();
            arrayList.add(Float.valueOf(length));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int iMin = Math.min(100, ((int) (length / f2)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        float f3 = length / (iMin - 1);
        int i = 0;
        float f4 = WheelView.DividerConfig.FILL;
        int i2 = 0;
        while (true) {
            if (i >= iMin) {
                break;
            }
            pathMeasure2.getPosTan(f4 - ((Float) arrayList.get(i2)).floatValue(), fArr3, null);
            fArr[i] = fArr3[0];
            fArr2[i] = fArr3[1];
            f4 += f3;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && f4 > ((Float) arrayList.get(i3)).floatValue()) {
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (propertyValuesHolderOfFloat == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat2);
        } else if (propertyValuesHolderOfFloat2 == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat);
        } else {
            objectAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f2) throws XmlPullParserException, IOException {
        return a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00dd, code lost:
    
        if (r23 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00df, code lost:
    
        if (r13 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e1, code lost:
    
        r1 = new android.animation.Animator[r13.size()];
        r2 = r13.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ef, code lost:
    
        if (r2.hasNext() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f1, code lost:
    
        r1[r14] = (android.animation.Animator) r2.next();
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fd, code lost:
    
        if (r24 != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ff, code lost:
    
        r23.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0103, code lost:
    
        r23.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0106, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.animation.Animator a(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.f.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    private static PropertyValuesHolder[] a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray typedArrayA = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.i);
                    String strA = androidx.core.content.a.i.a(typedArrayA, xmlPullParser, "propertyName", 3);
                    int iB = androidx.core.content.a.i.b(typedArrayA, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder propertyValuesHolderA = a(context, resources, theme, xmlPullParser, strA, iB);
                    if (propertyValuesHolderA == null) {
                        propertyValuesHolderA = a(typedArrayA, iB, 0, 1, strA);
                    }
                    if (propertyValuesHolderA != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(propertyValuesHolderA);
                    }
                    typedArrayA.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }

    private static int a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayA = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.j);
        int i = 0;
        TypedValue typedValueB = androidx.core.content.a.i.b(typedArrayA, xmlPullParser, "value", 0);
        if ((typedValueB != null) && a(typedValueB.type)) {
            i = 3;
        }
        typedArrayA.recycle();
        return i;
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        boolean z = typedValuePeekValue != null;
        int i3 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i2);
        boolean z2 = typedValuePeekValue2 != null;
        return ((z && a(i3)) || (z2 && a(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    private static PropertyValuesHolder a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolderOfKeyframe = null;
        int iA = i;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (iA == 4) {
                    iA = a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe keyframeA = a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), iA, xmlPullParser);
                if (keyframeA != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(keyframeA);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < WheelView.DividerConfig.FILL) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), a(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != WheelView.DividerConfig.FILL) {
                if (fraction2 < WheelView.DividerConfig.FILL) {
                    keyframe.setFraction(WheelView.DividerConfig.FILL);
                } else {
                    arrayList.add(0, a(keyframe, WheelView.DividerConfig.FILL));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i2 = 0; i2 < size; i2++) {
                Keyframe keyframe3 = keyframeArr[i2];
                if (keyframe3.getFraction() < WheelView.DividerConfig.FILL) {
                    if (i2 == 0) {
                        keyframe3.setFraction(WheelView.DividerConfig.FILL);
                    } else {
                        int i3 = size - 1;
                        if (i2 == i3) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i4 = i2;
                            for (int i5 = i2 + 1; i5 < i3 && keyframeArr[i5].getFraction() < WheelView.DividerConfig.FILL; i5++) {
                                i4 = i5;
                            }
                            a(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                        }
                    }
                }
            }
            propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (iA == 3) {
                propertyValuesHolderOfKeyframe.setEvaluator(g.a());
            }
        }
        return propertyValuesHolderOfKeyframe;
    }

    private static Keyframe a(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f2);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f2);
        }
        return Keyframe.ofObject(f2);
    }

    private static void a(Keyframe[] keyframeArr, float f2, int i, int i2) {
        float f3 = f2 / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f3);
            i++;
        }
    }

    private static Keyframe a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Keyframe keyframeOfInt;
        TypedArray typedArrayA = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.j);
        float fA = androidx.core.content.a.i.a(typedArrayA, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue typedValueB = androidx.core.content.a.i.b(typedArrayA, xmlPullParser, "value", 0);
        boolean z = typedValueB != null;
        if (i == 4) {
            i = (z && a(typedValueB.type)) ? 3 : 0;
        }
        if (z) {
            if (i != 0) {
                keyframeOfInt = (i == 1 || i == 3) ? Keyframe.ofInt(fA, androidx.core.content.a.i.b(typedArrayA, xmlPullParser, "value", 0, 0)) : null;
            } else {
                keyframeOfInt = Keyframe.ofFloat(fA, androidx.core.content.a.i.a(typedArrayA, xmlPullParser, "value", 0, WheelView.DividerConfig.FILL));
            }
        } else if (i == 0) {
            keyframeOfInt = Keyframe.ofFloat(fA);
        } else {
            keyframeOfInt = Keyframe.ofInt(fA);
        }
        int iC = androidx.core.content.a.i.c(typedArrayA, xmlPullParser, "interpolator", 1, 0);
        if (iC > 0) {
            keyframeOfInt.setInterpolator(e.a(context, iC));
        }
        typedArrayA.recycle();
        return keyframeOfInt;
    }

    private static ObjectAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        a(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
        return objectAnimator;
    }

    private static ValueAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray typedArrayA = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.g);
        TypedArray typedArrayA2 = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        a(valueAnimator, typedArrayA, typedArrayA2, f2, xmlPullParser);
        int iC = androidx.core.content.a.i.c(typedArrayA, xmlPullParser, "interpolator", 0, 0);
        if (iC > 0) {
            valueAnimator.setInterpolator(e.a(context, iC));
        }
        typedArrayA.recycle();
        if (typedArrayA2 != null) {
            typedArrayA2.recycle();
        }
        return valueAnimator;
    }
}
