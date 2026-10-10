package androidx.databinding.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.databinding.library.baseAdapters.R;

/* JADX INFO: compiled from: TextViewBindingAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: compiled from: TextViewBindingAdapter.java */
    public interface a {
        void afterTextChanged(Editable editable);
    }

    /* JADX INFO: compiled from: TextViewBindingAdapter.java */
    public interface b {
        void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    /* JADX INFO: compiled from: TextViewBindingAdapter.java */
    public interface c {
        void onTextChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    public static void a(TextView textView, CharSequence charSequence) {
        CharSequence text = textView.getText();
        if (charSequence != text) {
            if (charSequence == null && text.length() == 0) {
                return;
            }
            if (charSequence instanceof Spanned) {
                if (charSequence.equals(text)) {
                    return;
                }
            } else if (!a(charSequence, text)) {
                return;
            }
            textView.setText(charSequence);
        }
    }

    public static void b(TextView textView, Drawable drawable) {
        a(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    public static void c(TextView textView, Drawable drawable) {
        a(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
    }

    public static void d(TextView textView, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 17) {
            b(textView, drawable);
            return;
        }
        a(drawable);
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(drawable, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    public static String a(TextView textView) {
        return textView.getText().toString();
    }

    private static void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    public static void a(TextView textView, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 17) {
            c(textView, drawable);
            return;
        }
        a(drawable);
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], drawable, compoundDrawablesRelative[3]);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence == null) != (charSequence2 == null)) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static void a(TextView textView, b bVar, c cVar, a aVar, androidx.databinding.f fVar) {
        d dVar = (bVar == null && aVar == null && cVar == null && fVar == null) ? null : new d(bVar, cVar, fVar, aVar);
        TextWatcher textWatcher = (TextWatcher) androidx.databinding.a.c.a(textView, dVar, R.id.textWatcher);
        if (textWatcher != null) {
            textView.removeTextChangedListener(textWatcher);
        }
        if (dVar != null) {
            textView.addTextChangedListener(dVar);
        }
    }
}
