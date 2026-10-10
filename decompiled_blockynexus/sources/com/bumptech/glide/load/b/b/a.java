package com.bumptech.glide.load.b.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.a.h;

/* JADX INFO: compiled from: DrawableDecoderCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f4336a = true;

    public static Drawable a(Context context, Context context2, int i) {
        return a(context, context2, i, null);
    }

    private static Drawable b(Context context, int i, Resources.Theme theme) {
        return h.a(context.getResources(), i, theme);
    }

    private static Drawable c(Context context, int i, Resources.Theme theme) {
        if (theme != null) {
            context = new androidx.appcompat.d.d(context, theme);
        }
        return androidx.appcompat.a.a.a.b(context, i);
    }

    public static Drawable a(Context context, int i, Resources.Theme theme) {
        return a(context, context, i, theme);
    }

    private static Drawable a(Context context, Context context2, int i, Resources.Theme theme) {
        try {
            if (f4336a) {
                return c(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return androidx.core.content.b.c(context2, i);
            }
            throw e2;
        } catch (NoClassDefFoundError unused2) {
            f4336a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return b(context2, i, theme);
    }
}
