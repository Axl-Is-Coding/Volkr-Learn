package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C0305s;
import androidx.appcompat.widget.ia;
import androidx.core.view.C0313a;
import androidx.core.view.C0319g;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.l.n;
import io.rong.common.dlog.DLog;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_TextInputLayout;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator animator;
    private com.google.android.material.l.i boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private final int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private final int boxStrokeWidthDefaultPx;
    private final int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    private com.google.android.material.l.i boxUnderline;
    final com.google.android.material.internal.e collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    private ColorStateList counterTextColor;
    private TextView counterView;
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;
    private final int defaultStrokeColor;
    private final int disabledColor;
    private final int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<b> editTextAttachedListeners;
    private final LinkedHashSet<c> endIconChangedListeners;
    private final SparseArray<t> endIconDelegates;
    private Drawable endIconDummyDrawable;
    private final FrameLayout endIconFrame;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;
    private final CheckableImageButton endIconView;
    private final CheckableImageButton errorIconView;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasEndIconTintList;
    private boolean hasEndIconTintMode;
    private boolean hasStartIconTintList;
    private boolean hasStartIconTintMode;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private final int hoveredFilledBackgroundColor;
    private final int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final v indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private boolean restoringSavedState;
    private com.google.android.material.l.n shapeAppearanceModel;
    private Drawable startIconDummyDrawable;
    private View.OnLongClickListener startIconOnLongClickListener;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;
    private final CheckableImageButton startIconView;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class a extends C0313a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TextInputLayout f13657d;

        public a(TextInputLayout textInputLayout) {
            this.f13657d = textInputLayout;
        }

        @Override // androidx.core.view.C0313a
        public void a(View view, androidx.core.view.accessibility.b bVar) {
            super.a(view, bVar);
            EditText editText = this.f13657d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f13657d.getHint();
            CharSequence error = this.f13657d.getError();
            CharSequence counterOverflowDescription = this.f13657d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                bVar.h(text);
            } else if (z2) {
                bVar.h(hint);
            }
            if (z2) {
                bVar.e(hint);
                if (!z && z2) {
                    z4 = true;
                }
                bVar.p(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                bVar.d(error);
                bVar.f(true);
            }
        }
    }

    public interface b {
        void a(TextInputLayout textInputLayout);
    }

    public interface c {
        void a(TextInputLayout textInputLayout, int i);
    }

    static class d extends androidx.customview.a.c {
        public static final Parcelable.Creator<d> CREATOR = new F();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f13658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f13659d;

        d(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f13658c) + "}";
        }

        @Override // androidx.customview.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f13658c, parcel, i);
            parcel.writeInt(this.f13659d ? 1 : 0);
        }

        d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13658c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f13659d = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private void applyBoxAttributes() {
        com.google.android.material.l.i iVar = this.boxBackground;
        if (iVar == null) {
            return;
        }
        iVar.setShapeAppearanceModel(this.shapeAppearanceModel);
        if (canDrawOutlineStroke()) {
            this.boxBackground.a(this.boxStrokeWidthPx, this.boxStrokeColor);
        }
        this.boxBackgroundColor = calculateBoxBackgroundColor();
        this.boxBackground.a(ColorStateList.valueOf(this.boxBackgroundColor));
        if (this.endIconMode == 3) {
            this.editText.getBackground().invalidateSelf();
        }
        applyBoxUnderlineAttributes();
        invalidate();
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderline == null) {
            return;
        }
        if (canDrawStroke()) {
            this.boxUnderline.a(ColorStateList.valueOf(this.boxStrokeColor));
        }
        invalidate();
    }

    private void applyCutoutPadding(RectF rectF) {
        float f2 = rectF.left;
        int i = this.boxLabelCutoutPaddingPx;
        rectF.left = f2 - i;
        rectF.top -= i;
        rectF.right += i;
        rectF.bottom += i;
    }

    private void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    private void applyIconTint(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = androidx.core.graphics.drawable.a.i(drawable).mutate();
            if (z) {
                androidx.core.graphics.drawable.a.a(drawable, colorStateList);
            }
            if (z2) {
                androidx.core.graphics.drawable.a.a(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
    }

    private void assignBoxBackgroundByMode() {
        int i = this.boxBackgroundMode;
        if (i == 0) {
            this.boxBackground = null;
            this.boxUnderline = null;
            return;
        }
        if (i == 1) {
            this.boxBackground = new com.google.android.material.l.i(this.shapeAppearanceModel);
            this.boxUnderline = new com.google.android.material.l.i();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.hintEnabled || (this.boxBackground instanceof i)) {
                this.boxBackground = new com.google.android.material.l.i(this.shapeAppearanceModel);
            } else {
                this.boxBackground = new i(this.shapeAppearanceModel);
            }
            this.boxUnderline = null;
        }
    }

    private int calculateBoxBackgroundColor() {
        return this.boxBackgroundMode == 1 ? com.google.android.material.d.a.a(com.google.android.material.d.a.a(this, R.attr.colorSurface, 0), this.boxBackgroundColor) : this.boxBackgroundColor;
    }

    private Rect calculateCollapsedTextBounds(Rect rect) {
        EditText editText = this.editText;
        if (editText == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.tmpBoundsRect;
        rect2.bottom = rect.bottom;
        int i = this.boxBackgroundMode;
        if (i == 1) {
            rect2.left = rect.left + editText.getCompoundPaddingLeft();
            rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
            rect2.right = rect.right - this.editText.getCompoundPaddingRight();
            return rect2;
        }
        if (i != 2) {
            rect2.left = rect.left + editText.getCompoundPaddingLeft();
            rect2.top = getPaddingTop();
            rect2.right = rect.right - this.editText.getCompoundPaddingRight();
            return rect2;
        }
        rect2.left = rect.left + editText.getPaddingLeft();
        rect2.top = rect.top - calculateLabelMarginTop();
        rect2.right = rect.right - this.editText.getPaddingRight();
        return rect2;
    }

    private int calculateExpandedLabelBottom(Rect rect, Rect rect2, float f2) {
        return this.boxBackgroundMode == 1 ? (int) (rect2.top + f2) : rect.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(Rect rect, float f2) {
        return isSingleLineFilledTextField() ? (int) (rect.centerY() - (f2 / 2.0f)) : rect.top + this.editText.getCompoundPaddingTop();
    }

    private Rect calculateExpandedTextBounds(Rect rect) {
        if (this.editText == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.tmpBoundsRect;
        float fH = this.collapsingTextHelper.h();
        rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
        rect2.top = calculateExpandedLabelTop(rect, fH);
        rect2.right = rect.right - this.editText.getCompoundPaddingRight();
        rect2.bottom = calculateExpandedLabelBottom(rect, rect2, fH);
        return rect2;
    }

    private int calculateLabelMarginTop() {
        float fD;
        if (!this.hintEnabled) {
            return 0;
        }
        int i = this.boxBackgroundMode;
        if (i == 0 || i == 1) {
            fD = this.collapsingTextHelper.d();
        } else {
            if (i != 2) {
                return 0;
            }
            fD = this.collapsingTextHelper.d() / 2.0f;
        }
        return (int) fD;
    }

    private boolean canDrawOutlineStroke() {
        return this.boxBackgroundMode == 2 && canDrawStroke();
    }

    private boolean canDrawStroke() {
        return this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0;
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((i) this.boxBackground).u();
        }
    }

    private void collapseHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z && this.hintAnimationEnabled) {
            animateToExpansionFraction(1.0f);
        } else {
            this.collapsingTextHelper.b(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof i);
    }

    private void dispatchOnEditTextAttached() {
        Iterator<b> it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void dispatchOnEndIconChanged(int i) {
        Iterator<c> it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this, i);
        }
    }

    private void drawBoxUnderline(Canvas canvas) {
        com.google.android.material.l.i iVar = this.boxUnderline;
        if (iVar != null) {
            Rect bounds = iVar.getBounds();
            bounds.top = bounds.bottom - this.boxStrokeWidthPx;
            this.boxUnderline.draw(canvas);
        }
    }

    private void drawHint(Canvas canvas) {
        if (this.hintEnabled) {
            this.collapsingTextHelper.a(canvas);
        }
    }

    private void expandHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z && this.hintAnimationEnabled) {
            animateToExpansionFraction(WheelView.DividerConfig.FILL);
        } else {
            this.collapsingTextHelper.b(WheelView.DividerConfig.FILL);
        }
        if (cutoutEnabled() && ((i) this.boxBackground).t()) {
            closeCutout();
        }
        this.hintExpanded = true;
    }

    private t getEndIconDelegate() {
        t tVar = this.endIconDelegates.get(this.endIconMode);
        return tVar != null ? tVar : this.endIconDelegates.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) {
            return this.errorIconView;
        }
        if (hasEndIcon() && isEndIconVisible()) {
            return this.endIconView;
        }
        return null;
    }

    private boolean hasEndIcon() {
        return this.endIconMode != 0;
    }

    private boolean hasStartIcon() {
        return getStartIconDrawable() != null;
    }

    private boolean isSingleLineFilledTextField() {
        return this.boxBackgroundMode == 1 && (Build.VERSION.SDK_INT < 16 || this.editText.getMinLines() <= 1);
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        setEditTextBoxBackground();
        updateTextInputBoxState();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.a(rectF);
            applyCutoutPadding(rectF);
            rectF.offset(-getPaddingLeft(), WheelView.DividerConfig.FILL);
            ((i) this.boxBackground).a(rectF);
        }
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.editText != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.endIconMode != 3 && !(editText instanceof TextInputEditText)) {
            Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.editText = editText;
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new a(this));
        this.collapsingTextHelper.c(this.editText.getTypeface());
        this.collapsingTextHelper.a(this.editText.getTextSize());
        int gravity = this.editText.getGravity();
        this.collapsingTextHelper.b((gravity & (-113)) | 48);
        this.collapsingTextHelper.d(gravity);
        this.editText.addTextChangedListener(new B(this));
        if (this.defaultHintTextColor == null) {
            this.defaultHintTextColor = this.editText.getHintTextColors();
        }
        if (this.hintEnabled) {
            if (TextUtils.isEmpty(this.hint)) {
                this.originalHint = this.editText.getHint();
                setHint(this.originalHint);
                this.editText.setHint((CharSequence) null);
            }
            this.isProvidingHint = true;
        }
        if (this.counterView != null) {
            updateCounter(this.editText.getText().length());
        }
        updateEditTextBackground();
        this.indicatorViewController.a();
        this.startIconView.bringToFront();
        this.endIconFrame.bringToFront();
        this.errorIconView.bringToFront();
        dispatchOnEditTextAttached();
        updateLabelState(false, true);
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground()) {
            ViewCompat.a(this.editText, this.boxBackground);
        }
    }

    private void setErrorIconVisible(boolean z) {
        this.errorIconView.setVisibility(z ? 0 : 8);
        this.endIconFrame.setVisibility(z ? 8 : 0);
        if (hasEndIcon()) {
            return;
        }
        updateIconDummyDrawables();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.hint)) {
            return;
        }
        this.hint = charSequence;
        this.collapsingTextHelper.a(charSequence);
        if (this.hintExpanded) {
            return;
        }
        openCutout();
    }

    private static void setIconClickable(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zX = ViewCompat.x(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = zX || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zX);
        checkableImageButton.setPressable(zX);
        checkableImageButton.setLongClickable(z);
        ViewCompat.f(checkableImageButton, z2 ? 1 : 2);
    }

    private static void setIconOnClickListener(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private static void setIconOnLongClickListener(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        EditText editText = this.editText;
        return (editText == null || this.boxBackground == null || editText.getBackground() != null || this.boxBackgroundMode == 0) ? false : true;
    }

    private void tintEndIconOnError(boolean z) {
        if (!z || getEndIconDrawable() == null) {
            applyEndIconTint();
            return;
        }
        Drawable drawableMutate = androidx.core.graphics.drawable.a.i(getEndIconDrawable()).mutate();
        androidx.core.graphics.drawable.a.b(drawableMutate, this.indicatorViewController.e());
        this.endIconView.setImageDrawable(drawableMutate);
    }

    private void updateBoxUnderlineBounds(Rect rect) {
        com.google.android.material.l.i iVar = this.boxUnderline;
        if (iVar != null) {
            int i = rect.bottom;
            iVar.setBounds(rect.left, i - this.boxStrokeWidthFocusedPx, rect.right, i);
        }
    }

    private void updateCounter() {
        if (this.counterView != null) {
            EditText editText = this.editText;
            updateCounter(editText == null ? 0 : editText.getText().length());
        }
    }

    private static void updateCounterContentDescription(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    private void updateCounterTextAppearanceAndColor() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.counterView;
        if (textView != null) {
            setTextAppearanceCompatWithErrorFallback(textView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (!this.counterOverflowed || (colorStateList = this.counterOverflowTextColor) == null) {
                return;
            }
            this.counterView.setTextColor(colorStateList);
        }
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        int iMax;
        if (this.editText == null || this.editText.getMeasuredHeight() >= (iMax = Math.max(this.endIconView.getMeasuredHeight(), this.startIconView.getMeasuredHeight()))) {
            return false;
        }
        this.editText.setMinimumHeight(iMax);
        return true;
    }

    private boolean updateIconDummyDrawables() {
        boolean z;
        if (this.editText == null) {
            return false;
        }
        if (hasStartIcon() && isStartIconVisible() && this.startIconView.getMeasuredWidth() > 0) {
            if (this.startIconDummyDrawable == null) {
                this.startIconDummyDrawable = new ColorDrawable();
                this.startIconDummyDrawable.setBounds(0, 0, (this.startIconView.getMeasuredWidth() - this.editText.getPaddingLeft()) + C0319g.a((ViewGroup.MarginLayoutParams) this.startIconView.getLayoutParams()), 1);
            }
            Drawable[] drawableArrA = TextViewCompat.a(this.editText);
            Drawable drawable = drawableArrA[0];
            Drawable drawable2 = this.startIconDummyDrawable;
            if (drawable != drawable2) {
                TextViewCompat.a(this.editText, drawable2, drawableArrA[1], drawableArrA[2], drawableArrA[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.startIconDummyDrawable != null) {
                Drawable[] drawableArrA2 = TextViewCompat.a(this.editText);
                TextViewCompat.a(this.editText, null, drawableArrA2[1], drawableArrA2[2], drawableArrA2[3]);
                this.startIconDummyDrawable = null;
                z = true;
            }
            z = false;
        }
        CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
        if (endIconToUpdateDummyDrawable == null || endIconToUpdateDummyDrawable.getMeasuredWidth() <= 0) {
            if (this.endIconDummyDrawable == null) {
                return z;
            }
            Drawable[] drawableArrA3 = TextViewCompat.a(this.editText);
            if (drawableArrA3[2] == this.endIconDummyDrawable) {
                TextViewCompat.a(this.editText, drawableArrA3[0], drawableArrA3[1], this.originalEditTextEndDrawable, drawableArrA3[3]);
                z = true;
            }
            this.endIconDummyDrawable = null;
            return z;
        }
        if (this.endIconDummyDrawable == null) {
            this.endIconDummyDrawable = new ColorDrawable();
            this.endIconDummyDrawable.setBounds(0, 0, (endIconToUpdateDummyDrawable.getMeasuredWidth() - this.editText.getPaddingRight()) + C0319g.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()), 1);
        }
        Drawable[] drawableArrA4 = TextViewCompat.a(this.editText);
        Drawable drawable3 = drawableArrA4[2];
        Drawable drawable4 = this.endIconDummyDrawable;
        if (drawable3 == drawable4) {
            return z;
        }
        this.originalEditTextEndDrawable = drawableArrA4[2];
        TextViewCompat.a(this.editText, drawableArrA4[0], drawableArrA4[1], drawable4, drawableArrA4[3]);
        return true;
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int iCalculateLabelMarginTop = calculateLabelMarginTop();
            if (iCalculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = iCalculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    public void addOnEditTextAttachedListener(b bVar) {
        this.editTextAttachedListeners.add(bVar);
        if (this.editText != null) {
            bVar.a(this);
        }
    }

    public void addOnEndIconChangedListener(c cVar) {
        this.endIconChangedListeners.add(cVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.inputFrame.addView(view, layoutParams2);
        this.inputFrame.setLayoutParams(layoutParams);
        updateInputLayoutMargins();
        setEditText((EditText) view);
    }

    void animateToExpansionFraction(float f2) {
        if (this.collapsingTextHelper.j() == f2) {
            return;
        }
        if (this.animator == null) {
            this.animator = new ValueAnimator();
            this.animator.setInterpolator(com.google.android.material.a.a.f13082b);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener(new E(this));
        }
        this.animator.setFloatValues(this.collapsingTextHelper.j(), f2);
        this.animator.start();
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    boolean cutoutIsOpen() {
        return cutoutEnabled() && ((i) this.boxBackground).t();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText;
        if (this.originalHint == null || (editText = this.editText) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence hint = editText.getHint();
        this.editText.setHint(this.originalHint);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.editText.setHint(hint);
            this.isProvidingHint = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawHint(canvas);
        drawBoxUnderline(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.inDrawableStateChanged) {
            return;
        }
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.e eVar = this.collapsingTextHelper;
        boolean zA = eVar != null ? eVar.a(drawableState) | false : false;
        updateLabelState(ViewCompat.C(this) && isEnabled());
        updateEditTextBackground();
        updateTextInputBoxState();
        if (zA) {
            invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.editText;
        return editText != null ? editText.getBaseline() + getPaddingTop() + calculateLabelMarginTop() : super.getBaseline();
    }

    com.google.android.material.l.i getBoxBackground() {
        int i = this.boxBackgroundMode;
        if (i == 1 || i == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxBackground.b();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxBackground.c();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxBackground.o();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.n();
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.counterEnabled && this.counterOverflowed && (textView = this.counterView) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    public CharSequence getError() {
        if (this.indicatorViewController.l()) {
            return this.indicatorViewController.d();
        }
        return null;
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.e();
    }

    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    final int getErrorTextCurrentColor() {
        return this.indicatorViewController.e();
    }

    public CharSequence getHelperText() {
        if (this.indicatorViewController.m()) {
            return this.indicatorViewController.g();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.h();
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.d();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.f();
    }

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.l();
    }

    final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.i();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.m();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.endIconMode == 1;
    }

    boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    public boolean isStartIconVisible() {
        return this.startIconView.getVisibility() == 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.editText;
        if (editText != null) {
            Rect rect = this.tmpRect;
            com.google.android.material.internal.f.a(this, editText, rect);
            updateBoxUnderlineBounds(rect);
            if (this.hintEnabled) {
                this.collapsingTextHelper.a(calculateCollapsedTextBounds(rect));
                this.collapsingTextHelper.b(calculateExpandedTextBounds(rect));
                this.collapsingTextHelper.n();
                if (!cutoutEnabled() || this.hintExpanded) {
                    return;
                }
                openCutout();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean zUpdateEditTextHeightBasedOnIcon = updateEditTextHeightBasedOnIcon();
        boolean zUpdateIconDummyDrawables = updateIconDummyDrawables();
        if (zUpdateEditTextHeightBasedOnIcon || zUpdateIconDummyDrawables) {
            this.editText.post(new D(this));
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        setError(dVar.f13658c);
        if (dVar.f13659d) {
            this.endIconView.post(new C(this));
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        if (this.indicatorViewController.c()) {
            dVar.f13658c = getError();
        }
        dVar.f13659d = hasEndIcon() && this.endIconView.isChecked();
        return dVar;
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z) {
        if (this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    public void removeOnEditTextAttachedListener(b bVar) {
        this.editTextAttachedListeners.remove(bVar);
    }

    public void removeOnEndIconChangedListener(c cVar) {
        this.endIconChangedListeners.remove(cVar);
    }

    public void setBoxBackgroundColor(int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            this.defaultFilledBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(androidx.core.content.b.a(getContext(), i));
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.boxBackgroundMode) {
            return;
        }
        this.boxBackgroundMode = i;
        if (this.editText != null) {
            onApplyBoxBackgroundMode();
        }
    }

    public void setBoxCornerRadii(float f2, float f3, float f4, float f5) {
        if (this.boxBackground.n() == f2 && this.boxBackground.o() == f3 && this.boxBackground.c() == f5 && this.boxBackground.b() == f4) {
            return;
        }
        n.a aVarN = this.shapeAppearanceModel.n();
        aVarN.d(f2);
        aVarN.e(f3);
        aVarN.c(f5);
        aVarN.b(f4);
        this.shapeAppearanceModel = aVarN.a();
        applyBoxAttributes();
    }

    public void setBoxCornerRadiiResources(int i, int i2, int i3, int i4) {
        setBoxCornerRadii(getContext().getResources().getDimension(i), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i3));
    }

    public void setBoxStrokeColor(int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            if (z) {
                this.counterView = new AppCompatTextView(getContext());
                this.counterView.setId(R.id.textinput_counter);
                Typeface typeface = this.typeface;
                if (typeface != null) {
                    this.counterView.setTypeface(typeface);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.a(this.counterView, 2);
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.b(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.counterMaxLength != i) {
            if (i > 0) {
                this.counterMaxLength = i;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.counterOverflowTextAppearance != i) {
            this.counterOverflowTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.counterTextAppearance != i) {
            this.counterTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.endIconView.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.endIconView.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    public void setEndIconMode(int i) {
        int i2 = this.endIconMode;
        this.endIconMode = i;
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().a(this.boxBackgroundMode)) {
            getEndIconDelegate().a();
            applyEndIconTint();
            dispatchOnEndIconChanged(i2);
        } else {
            throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + i);
        }
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.endIconView, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            this.hasEndIconTintList = true;
            applyEndIconTint();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            this.hasEndIconTintMode = true;
            applyEndIconTint();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (isEndIconVisible() != z) {
            this.endIconView.setVisibility(z ? 0 : 4);
            updateIconDummyDrawables();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.indicatorViewController.l()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.j();
        } else {
            this.indicatorViewController.a(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        this.indicatorViewController.a(z);
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.i(drawable).mutate();
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.i(drawable).mutate();
            androidx.core.graphics.drawable.a.a(drawable, mode);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i) {
        this.indicatorViewController.b(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.a(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (isHelperTextEnabled()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.b(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.b(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.indicatorViewController.b(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.indicatorViewController.c(i);
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(DLog.CRS);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (this.hintEnabled) {
                CharSequence hint = this.editText.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            } else {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.collapsingTextHelper.a(i);
        this.focusedTextColor = this.collapsingTextHelper.b();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.a(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.endIconMode != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    public void setStartIconCheckable(boolean z) {
        this.startIconView.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        setIconOnClickListener(this.startIconView, onClickListener, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.startIconView, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            this.hasStartIconTintList = true;
            applyStartIconTint();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            this.hasStartIconTintMode = true;
            applyStartIconTint();
        }
    }

    public void setStartIconVisible(boolean z) {
        if (isStartIconVisible() != z) {
            this.startIconView.setVisibility(z ? 0 : 8);
            updateIconDummyDrawables();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void setTextAppearanceCompatWithErrorFallback(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.TextViewCompat.d(r3, r4)     // Catch: java.lang.Exception -> L1a
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1a
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1a
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1a
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1a
        L18:
            r4 = 0
            r0 = 0
        L1a:
            if (r0 == 0) goto L2e
            int r4 = com.google.android.material.R.style.TextAppearance_AppCompat_Caption
            androidx.core.widget.TextViewCompat.d(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R.color.design_error
            int r4 = androidx.core.content.b.a(r4, r0)
            r3.setTextColor(r4)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.setTextAppearanceCompatWithErrorFallback(android.widget.TextView, int):void");
    }

    public void setTextInputAccessibilityDelegate(a aVar) {
        EditText editText = this.editText;
        if (editText != null) {
            ViewCompat.a(editText, aVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            this.collapsingTextHelper.c(typeface);
            this.indicatorViewController.a(typeface);
            TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void updateEditTextBackground() {
        Drawable background;
        TextView textView;
        EditText editText = this.editText;
        if (editText == null || this.boxBackgroundMode != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (androidx.appcompat.widget.F.a(background)) {
            background = background.mutate();
        }
        if (this.indicatorViewController.c()) {
            background.setColorFilter(C0305s.a(this.indicatorViewController.e(), PorterDuff.Mode.SRC_IN));
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            background.setColorFilter(C0305s.a(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.a.b(background);
            this.editText.refreshDrawableState();
        }
    }

    void updateLabelState(boolean z) {
        updateLabelState(z, false);
    }

    void updateTextInputBoxState() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.boxBackground == null || this.boxBackgroundMode == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.editText) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.editText) != null && editText.isHovered());
        if (!isEnabled()) {
            this.boxStrokeColor = this.disabledColor;
        } else if (this.indicatorViewController.c()) {
            this.boxStrokeColor = this.indicatorViewController.e();
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.boxStrokeColor = textView.getCurrentTextColor();
        } else if (z2) {
            this.boxStrokeColor = this.focusedStrokeColor;
        } else if (z3) {
            this.boxStrokeColor = this.hoveredStrokeColor;
        } else {
            this.boxStrokeColor = this.defaultStrokeColor;
        }
        tintEndIconOnError(this.indicatorViewController.c() && getEndIconDelegate().b());
        if (getErrorIconDrawable() != null && this.indicatorViewController.l() && this.indicatorViewController.c()) {
            z = true;
        }
        setErrorIconVisible(z);
        if ((z3 || z2) && isEnabled()) {
            this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
        } else {
            this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        }
        if (this.boxBackgroundMode == 1) {
            if (!isEnabled()) {
                this.boxBackgroundColor = this.disabledFilledBackgroundColor;
            } else if (z3) {
                this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
            } else {
                this.boxBackgroundColor = this.defaultFilledBackgroundColor;
            }
        }
        applyBoxAttributes();
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    private void updateLabelState(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.editText;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.editText;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean zC = this.indicatorViewController.c();
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.a(colorStateList2);
            this.collapsingTextHelper.b(this.defaultHintTextColor);
        }
        if (!zIsEnabled) {
            this.collapsingTextHelper.a(ColorStateList.valueOf(this.disabledColor));
            this.collapsingTextHelper.b(ColorStateList.valueOf(this.disabledColor));
        } else if (zC) {
            this.collapsingTextHelper.a(this.indicatorViewController.f());
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.a(textView.getTextColors());
        } else if (z4 && (colorStateList = this.focusedTextColor) != null) {
            this.collapsingTextHelper.a(colorStateList);
        }
        if (z3 || (isEnabled() && (z4 || zC))) {
            if (z2 || this.hintExpanded) {
                collapseHint(z);
                return;
            }
            return;
        }
        if (z2 || !this.hintExpanded) {
            expandHint(z);
        }
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.indicatorViewController.l());
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            applyStartIconTint();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(com.google.android.material.internal.s.a(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.indicatorViewController = new v(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet<>();
        this.endIconMode = 0;
        this.endIconDelegates = new SparseArray<>();
        this.endIconChangedListeners = new LinkedHashSet<>();
        this.collapsingTextHelper = new com.google.android.material.internal.e(this);
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.inputFrame = new FrameLayout(context2);
        this.inputFrame.setAddStatesFromChildren(true);
        addView(this.inputFrame);
        this.endIconFrame = new FrameLayout(context2);
        this.endIconFrame.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 8388629));
        this.inputFrame.addView(this.endIconFrame);
        this.collapsingTextHelper.b(com.google.android.material.a.a.f13081a);
        this.collapsingTextHelper.a(com.google.android.material.a.a.f13081a);
        this.collapsingTextHelper.b(8388659);
        ia iaVarB = com.google.android.material.internal.s.b(context2, attributeSet, R.styleable.TextInputLayout, i, DEF_STYLE_RES, R.styleable.TextInputLayout_counterTextAppearance, R.styleable.TextInputLayout_counterOverflowTextAppearance, R.styleable.TextInputLayout_errorTextAppearance, R.styleable.TextInputLayout_helperTextTextAppearance, R.styleable.TextInputLayout_hintTextAppearance);
        this.hintEnabled = iaVarB.a(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(iaVarB.e(R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = iaVarB.a(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.shapeAppearanceModel = com.google.android.material.l.n.a(context2, attributeSet, i, DEF_STYLE_RES).a();
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = iaVarB.b(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = iaVarB.c(R.styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = iaVarB.c(R.styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float fA = iaVarB.a(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fA2 = iaVarB.a(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fA3 = iaVarB.a(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fA4 = iaVarB.a(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        n.a aVarN = this.shapeAppearanceModel.n();
        if (fA >= WheelView.DividerConfig.FILL) {
            aVarN.d(fA);
        }
        if (fA2 >= WheelView.DividerConfig.FILL) {
            aVarN.e(fA2);
        }
        if (fA3 >= WheelView.DividerConfig.FILL) {
            aVarN.c(fA3);
        }
        if (fA4 >= WheelView.DividerConfig.FILL) {
            aVarN.b(fA4);
        }
        this.shapeAppearanceModel = aVarN.a();
        ColorStateList colorStateListA = com.google.android.material.i.c.a(context2, iaVarB, R.styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateListA != null) {
            this.defaultFilledBackgroundColor = colorStateListA.getDefaultColor();
            this.boxBackgroundColor = this.defaultFilledBackgroundColor;
            if (colorStateListA.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateListA.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            } else {
                ColorStateList colorStateListA2 = androidx.appcompat.a.a.a.a(context2, R.color.mtrl_filled_background_color);
                this.disabledFilledBackgroundColor = colorStateListA2.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateListA2.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        } else {
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        if (iaVarB.g(R.styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListA3 = iaVarB.a(R.styleable.TextInputLayout_android_textColorHint);
            this.focusedTextColor = colorStateListA3;
            this.defaultHintTextColor = colorStateListA3;
        }
        ColorStateList colorStateListA4 = com.google.android.material.i.c.a(context2, iaVarB, R.styleable.TextInputLayout_boxStrokeColor);
        if (colorStateListA4 != null && colorStateListA4.isStateful()) {
            this.defaultStrokeColor = colorStateListA4.getDefaultColor();
            this.disabledColor = colorStateListA4.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateListA4.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            this.focusedStrokeColor = colorStateListA4.getColorForState(new int[]{android.R.attr.state_focused}, -1);
        } else {
            this.focusedStrokeColor = iaVarB.a(R.styleable.TextInputLayout_boxStrokeColor, 0);
            this.defaultStrokeColor = androidx.core.content.b.a(context2, R.color.mtrl_textinput_default_box_stroke_color);
            this.disabledColor = androidx.core.content.b.a(context2, R.color.mtrl_textinput_disabled_color);
            this.hoveredStrokeColor = androidx.core.content.b.a(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        }
        if (iaVarB.g(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(iaVarB.g(R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        int iG = iaVarB.g(R.styleable.TextInputLayout_errorTextAppearance, 0);
        boolean zA = iaVarB.a(R.styleable.TextInputLayout_errorEnabled, false);
        this.errorIconView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_end_icon, (ViewGroup) this.inputFrame, false);
        this.inputFrame.addView(this.errorIconView);
        this.errorIconView.setVisibility(8);
        if (iaVarB.g(R.styleable.TextInputLayout_errorIconDrawable)) {
            setErrorIconDrawable(iaVarB.b(R.styleable.TextInputLayout_errorIconDrawable));
        }
        if (iaVarB.g(R.styleable.TextInputLayout_errorIconTint)) {
            setErrorIconTintList(com.google.android.material.i.c.a(context2, iaVarB, R.styleable.TextInputLayout_errorIconTint));
        }
        if (iaVarB.g(R.styleable.TextInputLayout_errorIconTintMode)) {
            setErrorIconTintMode(com.google.android.material.internal.v.a(iaVarB.d(R.styleable.TextInputLayout_errorIconTintMode, -1), (PorterDuff.Mode) null));
        }
        this.errorIconView.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        ViewCompat.f(this.errorIconView, 2);
        this.errorIconView.setClickable(false);
        this.errorIconView.setPressable(false);
        this.errorIconView.setFocusable(false);
        int iG2 = iaVarB.g(R.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean zA2 = iaVarB.a(R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceE = iaVarB.e(R.styleable.TextInputLayout_helperText);
        boolean zA3 = iaVarB.a(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(iaVarB.d(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = iaVarB.g(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.counterOverflowTextAppearance = iaVarB.g(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.startIconView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this.inputFrame, false);
        this.inputFrame.addView(this.startIconView);
        this.startIconView.setVisibility(8);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (iaVarB.g(R.styleable.TextInputLayout_startIconDrawable)) {
            setStartIconDrawable(iaVarB.b(R.styleable.TextInputLayout_startIconDrawable));
            if (iaVarB.g(R.styleable.TextInputLayout_startIconContentDescription)) {
                setStartIconContentDescription(iaVarB.e(R.styleable.TextInputLayout_startIconContentDescription));
            }
            setStartIconCheckable(iaVarB.a(R.styleable.TextInputLayout_startIconCheckable, true));
        }
        if (iaVarB.g(R.styleable.TextInputLayout_startIconTint)) {
            setStartIconTintList(com.google.android.material.i.c.a(context2, iaVarB, R.styleable.TextInputLayout_startIconTint));
        }
        if (iaVarB.g(R.styleable.TextInputLayout_startIconTintMode)) {
            setStartIconTintMode(com.google.android.material.internal.v.a(iaVarB.d(R.styleable.TextInputLayout_startIconTintMode, -1), (PorterDuff.Mode) null));
        }
        setHelperTextEnabled(zA2);
        setHelperText(charSequenceE);
        setHelperTextTextAppearance(iG2);
        setErrorEnabled(zA);
        setErrorTextAppearance(iG);
        setCounterTextAppearance(this.counterTextAppearance);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        if (iaVarB.g(R.styleable.TextInputLayout_errorTextColor)) {
            setErrorTextColor(iaVarB.a(R.styleable.TextInputLayout_errorTextColor));
        }
        if (iaVarB.g(R.styleable.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(iaVarB.a(R.styleable.TextInputLayout_helperTextTextColor));
        }
        if (iaVarB.g(R.styleable.TextInputLayout_hintTextColor)) {
            setHintTextColor(iaVarB.a(R.styleable.TextInputLayout_hintTextColor));
        }
        if (iaVarB.g(R.styleable.TextInputLayout_counterTextColor)) {
            setCounterTextColor(iaVarB.a(R.styleable.TextInputLayout_counterTextColor));
        }
        if (iaVarB.g(R.styleable.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(iaVarB.a(R.styleable.TextInputLayout_counterOverflowTextColor));
        }
        setCounterEnabled(zA3);
        setBoxBackgroundMode(iaVarB.d(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        this.endIconView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_end_icon, (ViewGroup) this.endIconFrame, false);
        this.endIconFrame.addView(this.endIconView);
        this.endIconView.setVisibility(8);
        this.endIconDelegates.append(-1, new h(this));
        this.endIconDelegates.append(0, new w(this));
        this.endIconDelegates.append(1, new A(this));
        this.endIconDelegates.append(2, new g(this));
        this.endIconDelegates.append(3, new s(this));
        if (iaVarB.g(R.styleable.TextInputLayout_endIconMode)) {
            setEndIconMode(iaVarB.d(R.styleable.TextInputLayout_endIconMode, 0));
            if (iaVarB.g(R.styleable.TextInputLayout_endIconDrawable)) {
                setEndIconDrawable(iaVarB.b(R.styleable.TextInputLayout_endIconDrawable));
            }
            if (iaVarB.g(R.styleable.TextInputLayout_endIconContentDescription)) {
                setEndIconContentDescription(iaVarB.e(R.styleable.TextInputLayout_endIconContentDescription));
            }
            setEndIconCheckable(iaVarB.a(R.styleable.TextInputLayout_endIconCheckable, true));
        } else if (iaVarB.g(R.styleable.TextInputLayout_passwordToggleEnabled)) {
            setEndIconMode(iaVarB.a(R.styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            setEndIconDrawable(iaVarB.b(R.styleable.TextInputLayout_passwordToggleDrawable));
            setEndIconContentDescription(iaVarB.e(R.styleable.TextInputLayout_passwordToggleContentDescription));
            if (iaVarB.g(R.styleable.TextInputLayout_passwordToggleTint)) {
                setEndIconTintList(com.google.android.material.i.c.a(context2, iaVarB, R.styleable.TextInputLayout_passwordToggleTint));
            }
            if (iaVarB.g(R.styleable.TextInputLayout_passwordToggleTintMode)) {
                setEndIconTintMode(com.google.android.material.internal.v.a(iaVarB.d(R.styleable.TextInputLayout_passwordToggleTintMode, -1), (PorterDuff.Mode) null));
            }
        }
        if (!iaVarB.g(R.styleable.TextInputLayout_passwordToggleEnabled)) {
            if (iaVarB.g(R.styleable.TextInputLayout_endIconTint)) {
                setEndIconTintList(com.google.android.material.i.c.a(context2, iaVarB, R.styleable.TextInputLayout_endIconTint));
            }
            if (iaVarB.g(R.styleable.TextInputLayout_endIconTintMode)) {
                setEndIconTintMode(com.google.android.material.internal.v.a(iaVarB.d(R.styleable.TextInputLayout_endIconTintMode, -1), (PorterDuff.Mode) null));
            }
        }
        iaVarB.a();
        ViewCompat.f(this, 2);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    void updateCounter(int i) {
        boolean z = this.counterOverflowed;
        if (this.counterMaxLength == -1) {
            this.counterView.setText(String.valueOf(i));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            if (ViewCompat.c(this.counterView) == 1) {
                ViewCompat.e(this.counterView, 0);
            }
            this.counterOverflowed = i > this.counterMaxLength;
            updateCounterContentDescription(getContext(), this.counterView, i, this.counterMaxLength, this.counterOverflowed);
            if (z != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
                if (this.counterOverflowed) {
                    ViewCompat.e(this.counterView, 1);
                }
            }
            this.counterView.setText(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)));
        }
        if (this.editText == null || z == this.counterOverflowed) {
            return;
        }
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
    }
}
