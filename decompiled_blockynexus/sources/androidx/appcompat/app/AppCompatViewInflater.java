package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.fa;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.umeng.analytics.pro.ci;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private final Object[] mConstructorArgs = new Object[2];
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final int[] sOnClickAttrs = {R.attr.onClick};
    private static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> sConstructorMap = new a.a.b();

    private static class DeclaredOnClickListener implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f237d;

        public DeclaredOnClickListener(View view, String str) {
            this.f234a = view;
            this.f235b = str;
        }

        private void a(Context context, String str) {
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f235b, View.class)) != null) {
                        this.f236c = method;
                        this.f237d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f234a.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f234a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f235b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f234a.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f236c == null) {
                a(this.f234a.getContext(), this.f235b);
            }
            try {
                this.f236c.invoke(this.f237d, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    private void checkOnClickListener(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || ViewCompat.x(view)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new DeclaredOnClickListener(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    private View createViewByPrefix(Context context, String str, String str2) throws InflateException, ClassNotFoundException {
        String str3;
        Constructor<? extends View> constructor = sConstructorMap.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);
            sConstructorMap.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.mConstructorArgs);
    }

    private View createViewFromTag(Context context, String str, AttributeSet attributeSet) {
        if (str.equals(ViewHierarchyConstants.VIEW_KEY)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return createViewByPrefix(context, str, null);
            }
            for (int i = 0; i < sClassPrefixList.length; i++) {
                View viewCreateViewByPrefix = createViewByPrefix(context, str, sClassPrefixList[i]);
                if (viewCreateViewByPrefix != null) {
                    return viewCreateViewByPrefix;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr = this.mConstructorArgs;
            objArr[0] = null;
            objArr[1] = null;
        }
    }

    private static Context themifyContext(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.View, 0, 0);
        int resourceId = z ? typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_theme, 0)) != 0) {
            Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof androidx.appcompat.d.d) && ((androidx.appcompat.d.d) context).a() == resourceId) ? context : new androidx.appcompat.d.d(context, resourceId) : context;
    }

    private void verifyNotNull(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected AppCompatAutoCompleteTextView createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    protected AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    protected AppCompatCheckedTextView createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    protected AppCompatEditText createEditText(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    protected AppCompatImageButton createImageButton(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    protected AppCompatImageView createImageView(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    protected AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    protected AppCompatRatingBar createRatingBar(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    protected AppCompatSeekBar createSeekBar(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    protected AppCompatSpinner createSpinner(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    protected AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    protected AppCompatToggleButton createToggleButton(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    protected View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    final View createView(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View viewCreateTextView;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = themifyContext(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = fa.a(context2);
        }
        byte b2 = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    b2 = 11;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    b2 = 8;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    b2 = 10;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    b2 = 0;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    b2 = 5;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    b2 = 12;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    b2 = 4;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    b2 = 7;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    b2 = ci.k;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    b2 = 1;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    b2 = 9;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    b2 = 6;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    b2 = 3;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    b2 = 2;
                }
                break;
        }
        switch (b2) {
            case 0:
                viewCreateTextView = createTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 1:
                viewCreateTextView = createImageView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 2:
                viewCreateTextView = createButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 3:
                viewCreateTextView = createEditText(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 4:
                viewCreateTextView = createSpinner(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 5:
                viewCreateTextView = createImageButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 6:
                viewCreateTextView = createCheckBox(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 7:
                viewCreateTextView = createRadioButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 8:
                viewCreateTextView = createCheckedTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 9:
                viewCreateTextView = createAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 10:
                viewCreateTextView = createMultiAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 11:
                viewCreateTextView = createRatingBar(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 12:
                viewCreateTextView = createSeekBar(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case 13:
                viewCreateTextView = createToggleButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            default:
                viewCreateTextView = createView(context2, str, attributeSet);
                break;
        }
        if (viewCreateTextView == null && context != context2) {
            viewCreateTextView = createViewFromTag(context2, str, attributeSet);
        }
        if (viewCreateTextView != null) {
            checkOnClickListener(viewCreateTextView, attributeSet);
        }
        return viewCreateTextView;
    }
}
