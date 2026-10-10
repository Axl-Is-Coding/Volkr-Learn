package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ViewCompat;
import io.rong.common.dlog.DLog;

/* JADX INFO: loaded from: classes2.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = {R.attr.state_checked};
    private boolean checkable;
    private boolean checked;
    private boolean pressable;

    static class a extends androidx.customview.a.c {
        public static final Parcelable.Creator<a> CREATOR = new b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f13437c;

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel) {
            this.f13437c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f13437c ? 1 : 0);
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel);
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isPressable() {
        return this.pressable;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        return this.checked ? ImageButton.mergeDrawableStates(super.onCreateDrawableState(i + DRAWABLE_STATE_CHECKED.length), DRAWABLE_STATE_CHECKED) : super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.a());
        setChecked(aVar.f13437c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f13437c = this.checked;
        return aVar;
    }

    public void setCheckable(boolean z) {
        if (this.checkable != z) {
            this.checkable = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.checkable || this.checked == z) {
            return;
        }
        this.checked = z;
        refreshDrawableState();
        sendAccessibilityEvent(DLog.CRS);
    }

    public void setPressable(boolean z) {
        this.pressable = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.pressable) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.checkable = true;
        this.pressable = true;
        ViewCompat.a(this, new com.google.android.material.internal.a(this));
    }
}
