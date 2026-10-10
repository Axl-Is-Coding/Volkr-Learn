package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.core.view.l;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import io.rong.common.dlog.DLog;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ViewHierarchy {
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    private static final String CLASS_RCTTEXTVIEW = "com.facebook.react.views.view.ReactTextView";
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    private static final String TAG = "com.facebook.appevents.codeless.internal.ViewHierarchy";
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>(null);
    private static Method methodFindTouchTargetView = null;

    public static View findRCTRootView(View view) {
        while (view != null) {
            if (isRCTRootView(view)) {
                return view;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    public static List<View> getChildrenOfView(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                arrayList.add(viewGroup.getChildAt(i));
            }
        }
        return arrayList;
    }

    public static int getClassTypeBitmask(View view) {
        int i = view instanceof ImageView ? 2 : 0;
        if (view.isClickable()) {
            i |= 32;
        }
        if (isAdapterViewItem(view)) {
            i |= 512;
        }
        if (!(view instanceof TextView)) {
            return ((view instanceof Spinner) || (view instanceof DatePicker)) ? i | 4096 : view instanceof RatingBar ? i | 65536 : view instanceof RadioGroup ? i | 16384 : ((view instanceof ViewGroup) && isRCTButton(view, RCTRootViewReference.get())) ? i | 64 : i;
        }
        int i2 = i | 1024 | 1;
        if (view instanceof Button) {
            i2 |= 4;
            if (view instanceof Switch) {
                i2 |= 8192;
            } else if (view instanceof CheckBox) {
                i2 |= 32768;
            }
        }
        return view instanceof EditText ? i2 | DLog.CRS : i2;
    }

    public static JSONObject getDictionaryOfView(View view) {
        if (view.getClass().getName().equals(CLASS_RCTROOTVIEW)) {
            RCTRootViewReference = new WeakReference<>(view);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            updateBasicInfoOfView(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<View> childrenOfView = getChildrenOfView(view);
            for (int i = 0; i < childrenOfView.size(); i++) {
                jSONArray.put(getDictionaryOfView(childrenOfView.get(i)));
            }
            jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
        } catch (JSONException e2) {
            Log.e(TAG, "Failed to create JSONObject for view.", e2);
        }
        return jSONObject;
    }

    private static JSONObject getDimensionOfView(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("top", view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view.getWidth());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, view.getHeight());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, view.getVisibility());
        } catch (JSONException e2) {
            Log.e(TAG, "Failed to create JSONObject for dimension.", e2);
        }
        return jSONObject;
    }

    public static View.OnClickListener getExistingOnClickListener(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj != null && (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) != null) {
                declaredField.setAccessible(true);
                return (View.OnClickListener) declaredField.get(obj);
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }

    public static View.OnTouchListener getExistingOnTouchListener(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj != null && (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) != null) {
                declaredField.setAccessible(true);
                return (View.OnTouchListener) declaredField.get(obj);
            }
            return null;
        } catch (ClassNotFoundException e2) {
            Utility.logd(TAG, e2);
            return null;
        } catch (IllegalAccessException e3) {
            Utility.logd(TAG, e3);
            return null;
        } catch (NoSuchFieldException e4) {
            Utility.logd(TAG, e4);
            return null;
        }
    }

    public static String getHintOfView(View view) {
        CharSequence hint = view instanceof EditText ? ((EditText) view).getHint() : view instanceof TextView ? ((TextView) view).getHint() : null;
        return hint == null ? "" : hint.toString();
    }

    public static ViewGroup getParentOfView(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    public static String getTextOfView(View view) {
        String text;
        Object selectedItem;
        CharSequence charSequenceValueOf = null;
        if (view instanceof TextView) {
            charSequenceValueOf = ((TextView) view).getText();
            if (view instanceof Switch) {
                text = ((Switch) view).isChecked() ? "1" : "0";
                charSequenceValueOf = text;
                break;
            }
        } else if (view instanceof Spinner) {
            Spinner spinner = (Spinner) view;
            if (spinner.getCount() > 0 && (selectedItem = spinner.getSelectedItem()) != null) {
                charSequenceValueOf = selectedItem.toString();
            }
        } else {
            if (view instanceof DatePicker) {
                DatePicker datePicker = (DatePicker) view;
                charSequenceValueOf = String.format("%04d-%02d-%02d", Integer.valueOf(datePicker.getYear()), Integer.valueOf(datePicker.getMonth()), Integer.valueOf(datePicker.getDayOfMonth()));
            } else if (view instanceof TimePicker) {
                TimePicker timePicker = (TimePicker) view;
                charSequenceValueOf = String.format("%02d:%02d", Integer.valueOf(timePicker.getCurrentHour().intValue()), Integer.valueOf(timePicker.getCurrentMinute().intValue()));
            } else if (view instanceof RadioGroup) {
                RadioGroup radioGroup = (RadioGroup) view;
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                int childCount = radioGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = radioGroup.getChildAt(i);
                    if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                        text = ((RadioButton) childAt).getText();
                        charSequenceValueOf = text;
                        break;
                    }
                }
            } else if (view instanceof RatingBar) {
                charSequenceValueOf = String.valueOf(((RatingBar) view).getRating());
            }
        }
        return charSequenceValueOf == null ? "" : charSequenceValueOf.toString();
    }

    public static View getTouchReactView(float[] fArr, View view) {
        initTouchTargetHelperMethods();
        Method method = methodFindTouchTargetView;
        if (method != null && view != null) {
            try {
                View view2 = (View) method.invoke(null, fArr, view);
                if (view2 != null && view2.getId() > 0) {
                    View view3 = (View) view2.getParent();
                    if (view3 != null) {
                        return view3;
                    }
                    return null;
                }
            } catch (IllegalAccessException e2) {
                Utility.logd(TAG, e2);
            } catch (InvocationTargetException e3) {
                Utility.logd(TAG, e3);
            }
        }
        return null;
    }

    private static float[] getViewLocationOnScreen(View view) {
        view.getLocationOnScreen(new int[2]);
        return new float[]{r1[0], r1[1]};
    }

    private static void initTouchTargetHelperMethods() {
        if (methodFindTouchTargetView != null) {
            return;
        }
        try {
            methodFindTouchTargetView = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, float[].class, ViewGroup.class);
            methodFindTouchTargetView.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            Utility.logd(TAG, e2);
        } catch (NoSuchMethodException e3) {
            Utility.logd(TAG, e3);
        }
    }

    private static boolean isAdapterViewItem(View view) {
        ViewParent parent = view.getParent();
        return (parent instanceof AdapterView) || (parent instanceof l);
    }

    public static boolean isRCTButton(View view, View view2) {
        View touchReactView;
        return view.getClass().getName().equals(CLASS_RCTVIEWGROUP) && (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) != null && touchReactView.getId() == view.getId();
    }

    public static boolean isRCTRootView(View view) {
        return view.getClass().getName().equals(CLASS_RCTROOTVIEW);
    }

    public static boolean isRCTTextView(View view) {
        return view.getClass().getName().equals(CLASS_RCTTEXTVIEW);
    }

    public static boolean isRCTViewGroup(View view) {
        return view.getClass().getName().equals(CLASS_RCTVIEWGROUP);
    }

    public static void setOnClickListener(View view, View.OnClickListener onClickListener) {
        Field declaredField;
        Field declaredField2;
        Object obj = null;
        try {
            try {
                declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                try {
                    declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                } catch (ClassNotFoundException | NoSuchFieldException unused) {
                    declaredField2 = null;
                }
            } catch (Exception unused2) {
                return;
            }
        } catch (ClassNotFoundException | NoSuchFieldException unused3) {
            declaredField = null;
        }
        if (declaredField == null || declaredField2 == null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        declaredField.setAccessible(true);
        declaredField2.setAccessible(true);
        try {
            declaredField.setAccessible(true);
            obj = declaredField.get(view);
        } catch (IllegalAccessException unused4) {
        }
        if (obj == null) {
            view.setOnClickListener(onClickListener);
        } else {
            declaredField2.set(obj, onClickListener);
        }
    }

    public static void updateAppearanceOfView(View view, JSONObject jSONObject, float f2) {
        Bitmap bitmap;
        TextView textView;
        Typeface typeface;
        try {
            JSONObject jSONObject2 = new JSONObject();
            if ((view instanceof TextView) && (typeface = (textView = (TextView) view).getTypeface()) != null) {
                jSONObject2.put(ViewHierarchyConstants.TEXT_SIZE, textView.getTextSize());
                jSONObject2.put(ViewHierarchyConstants.TEXT_IS_BOLD, typeface.isBold());
                jSONObject2.put(ViewHierarchyConstants.TEXT_IS_ITALIC, typeface.isItalic());
                jSONObject.put(ViewHierarchyConstants.TEXT_STYLE, jSONObject2);
            }
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if (!(drawable instanceof BitmapDrawable) || view.getHeight() / f2 > 44.0f || view.getWidth() / f2 > 44.0f || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
                    return;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                jSONObject.put(ViewHierarchyConstants.ICON_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
            }
        } catch (JSONException e2) {
            Utility.logd(TAG, e2);
        }
    }

    public static void updateBasicInfoOfView(View view, JSONObject jSONObject) {
        try {
            String textOfView = getTextOfView(view);
            String hintOfView = getHintOfView(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getCanonicalName());
            jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
            jSONObject.put("id", view.getId());
            if (SensitiveUserDataUtils.isSensitiveUserData(view)) {
                jSONObject.put(ViewHierarchyConstants.TEXT_KEY, "");
                jSONObject.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
            } else {
                jSONObject.put(ViewHierarchyConstants.TEXT_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
            }
            jSONObject.put(ViewHierarchyConstants.HINT_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
            if (tag != null) {
                jSONObject.put("tag", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
            }
            if (contentDescription != null) {
                jSONObject.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
            }
            jSONObject.put(ViewHierarchyConstants.DIMENSION_KEY, getDimensionOfView(view));
        } catch (JSONException e2) {
            Utility.logd(TAG, e2);
        }
    }
}
