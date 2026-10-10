package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
/* JADX INFO: loaded from: classes.dex */
class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final RectF f521a = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f522b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f523c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f524d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f525e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f526f = -1.0f;
    private float g = -1.0f;
    private float h = -1.0f;
    private int[] i = new int[0];
    private boolean j = false;
    private TextPaint k;
    private final TextView l;
    private final Context m;

    E(TextView textView) {
        this.l = textView;
        this.m = this.l.getContext();
    }

    private void h() {
        this.f524d = 0;
        this.g = -1.0f;
        this.h = -1.0f;
        this.f526f = -1.0f;
        this.i = new int[0];
        this.f525e = false;
    }

    private boolean i() {
        if (k() && this.f524d == 1) {
            if (!this.j || this.i.length == 0) {
                int iFloor = ((int) Math.floor((this.h - this.g) / this.f526f)) + 1;
                int[] iArr = new int[iFloor];
                for (int i = 0; i < iFloor; i++) {
                    iArr[i] = Math.round(this.g + (i * this.f526f));
                }
                this.i = a(iArr);
            }
            this.f525e = true;
        } else {
            this.f525e = false;
        }
        return this.f525e;
    }

    private boolean j() {
        this.j = this.i.length > 0;
        if (this.j) {
            this.f524d = 1;
            int[] iArr = this.i;
            this.g = iArr[0];
            this.h = iArr[r0 - 1];
            this.f526f = -1.0f;
        }
        return this.j;
    }

    private boolean k() {
        return !(this.l instanceof AppCompatEditText);
    }

    void a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.m.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.f524d = typedArrayObtainStyledAttributes.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            a(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!k()) {
            this.f524d = 0;
            return;
        }
        if (this.f524d == 1) {
            if (!this.j) {
                DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                a(dimension2, dimension3, dimension);
            }
            i();
        }
    }

    void b(int i) {
        if (k()) {
            if (i == 0) {
                h();
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
            DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (i()) {
                a();
            }
        }
    }

    int c() {
        return Math.round(this.g);
    }

    int d() {
        return Math.round(this.f526f);
    }

    int[] e() {
        return this.i;
    }

    int f() {
        return this.f524d;
    }

    boolean g() {
        return k() && this.f524d != 0;
    }

    int b() {
        return Math.round(this.h);
    }

    private StaticLayout b(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic;
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.k, i);
        StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(this.l.getLineSpacingExtra(), this.l.getLineSpacingMultiplier()).setIncludePad(this.l.getIncludeFontPadding()).setBreakStrategy(this.l.getBreakStrategy()).setHyphenationFrequency(this.l.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                textDirectionHeuristic = this.l.getTextDirectionHeuristic();
            } else {
                textDirectionHeuristic = (TextDirectionHeuristic) b(this.l, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
            }
            builderObtain.setTextDirection(textDirectionHeuristic);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return builderObtain.build();
    }

    void a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (k()) {
            DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (i()) {
                a();
            }
        }
    }

    private StaticLayout b(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.k, i, alignment, this.l.getLineSpacingMultiplier(), this.l.getLineSpacingExtra(), this.l.getIncludeFontPadding());
    }

    private static <T> T b(Object obj, String str, T t) {
        try {
            return (T) b(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return t;
        }
    }

    void a(int[] iArr, int i) throws IllegalArgumentException {
        if (k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.i = a(iArrCopyOf);
                if (!j()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.j = false;
            }
            if (i()) {
                a();
            }
        }
    }

    private static Method b(String str) {
        try {
            Method declaredMethod = f522b.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f522b.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    private void a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.i = a(iArr);
            j();
        }
    }

    private int[] a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    private void a(float f2, float f3, float f4) throws IllegalArgumentException {
        if (f2 <= WheelView.DividerConfig.FILL) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        }
        if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        }
        if (f4 > WheelView.DividerConfig.FILL) {
            this.f524d = 1;
            this.g = f2;
            this.h = f3;
            this.f526f = f4;
            this.j = false;
            return;
        }
        throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
    }

    void a() {
        boolean zBooleanValue;
        if (g()) {
            if (this.f525e) {
                if (this.l.getMeasuredHeight() <= 0 || this.l.getMeasuredWidth() <= 0) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    zBooleanValue = this.l.isHorizontallyScrollable();
                } else {
                    zBooleanValue = ((Boolean) b(this.l, "getHorizontallyScrolling", false)).booleanValue();
                }
                int measuredWidth = zBooleanValue ? 1048576 : (this.l.getMeasuredWidth() - this.l.getTotalPaddingLeft()) - this.l.getTotalPaddingRight();
                int height = (this.l.getHeight() - this.l.getCompoundPaddingBottom()) - this.l.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (f521a) {
                    f521a.setEmpty();
                    f521a.right = measuredWidth;
                    f521a.bottom = height;
                    float fA = a(f521a);
                    if (fA != this.l.getTextSize()) {
                        a(0, fA);
                    }
                }
            }
            this.f525e = true;
        }
    }

    void a(int i, float f2) {
        Resources resources;
        Context context = this.m;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        a(TypedValue.applyDimension(i, f2, resources.getDisplayMetrics()));
    }

    private void a(float f2) {
        if (f2 != this.l.getPaint().getTextSize()) {
            this.l.getPaint().setTextSize(f2);
            boolean zIsInLayout = Build.VERSION.SDK_INT >= 18 ? this.l.isInLayout() : false;
            if (this.l.getLayout() != null) {
                this.f525e = false;
                try {
                    Method methodB = b("nullLayouts");
                    if (methodB != null) {
                        methodB.invoke(this.l, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!zIsInLayout) {
                    this.l.requestLayout();
                } else {
                    this.l.forceLayout();
                }
                this.l.invalidate();
            }
        }
    }

    private int a(RectF rectF) {
        int length = this.i.length;
        if (length != 0) {
            int i = length - 1;
            int i2 = 1;
            int i3 = 0;
            while (i2 <= i) {
                int i4 = (i2 + i) / 2;
                if (a(this.i[i4], rectF)) {
                    int i5 = i4 + 1;
                    i3 = i2;
                    i2 = i5;
                } else {
                    i3 = i4 - 1;
                    i = i3;
                }
            }
            return this.i[i3];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    void a(int i) {
        TextPaint textPaint = this.k;
        if (textPaint == null) {
            this.k = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.k.set(this.l.getPaint());
        this.k.setTextSize(i);
    }

    StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return b(charSequence, alignment, i, i2);
        }
        if (i3 >= 16) {
            return b(charSequence, alignment, i);
        }
        return a(charSequence, alignment, i);
    }

    private boolean a(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.l.getText();
        TransformationMethod transformationMethod = this.l.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.l)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.l.getMaxLines() : -1;
        a(i);
        StaticLayout staticLayoutA = a(text, (Layout.Alignment) b(this.l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutA.getLineCount() <= maxLines && staticLayoutA.getLineEnd(staticLayoutA.getLineCount() - 1) == text.length())) && ((float) staticLayoutA.getHeight()) <= rectF.bottom;
    }

    private StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.k, i, alignment, ((Float) a(this.l, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.l, "mSpacingAdd", Float.valueOf(WheelView.DividerConfig.FILL))).floatValue(), ((Boolean) a(this.l, "mIncludePad", true)).booleanValue());
    }

    private static <T> T a(Object obj, String str, T t) {
        try {
            Field fieldA = a(str);
            return fieldA == null ? t : (T) fieldA.get(obj);
        } catch (IllegalAccessException e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return t;
        }
    }

    private static Field a(String str) {
        try {
            Field declaredField = f523c.get(str);
            if (declaredField == null && (declaredField = TextView.class.getDeclaredField(str)) != null) {
                declaredField.setAccessible(true);
                f523c.put(str, declaredField);
            }
            return declaredField;
        } catch (NoSuchFieldException e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return null;
        }
    }
}
