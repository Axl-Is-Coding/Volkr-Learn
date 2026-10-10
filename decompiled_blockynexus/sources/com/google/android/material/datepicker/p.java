package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: MaterialDatePicker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p<S> extends DialogInterfaceOnCancelListenerC0327e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Object f13328a = "CONFIRM_BUTTON_TAG";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object f13329b = "CANCEL_BUTTON_TAG";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f13330c = "TOGGLE_BUTTON_TAG";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashSet<q<? super S>> f13331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedHashSet<View.OnClickListener> f13332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13333f;
    private e<S> g;
    private z<S> h;
    private C2230b i;
    private MaterialCalendar<S> j;
    private CheckableImageButton k;

    static /* synthetic */ void d(p pVar) {
        pVar.i();
        throw null;
    }

    private void i() {
        this.j = MaterialCalendar.a(this.g, b(requireContext()), this.i);
        this.h = this.k.isChecked() ? s.a(this.g, this.i) : this.j;
        j();
        throw null;
    }

    private void j() {
        g();
        throw null;
    }

    public String g() {
        throw null;
    }

    public final S h() {
        throw null;
    }

    private int b(Context context) {
        int i = this.f13333f;
        return i != 0 ? i : this.g.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CheckableImageButton checkableImageButton) {
        String string;
        if (this.k.isChecked()) {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.k.setContentDescription(string);
    }

    static boolean a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.i.b.a(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{android.R.attr.windowFullscreen});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }
}
