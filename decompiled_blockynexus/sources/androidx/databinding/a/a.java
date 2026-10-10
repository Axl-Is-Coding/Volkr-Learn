package androidx.databinding.a;

import android.widget.CompoundButton;

/* JADX INFO: compiled from: CompoundButtonBindingAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isChecked() != z) {
            compoundButton.setChecked(z);
        }
    }
}
