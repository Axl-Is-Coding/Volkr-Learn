package com.sandboxol.common.base.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.e;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class GlideApp {
    private GlideApp() {
    }

    public static com.bumptech.glide.c get(Context context) {
        return com.bumptech.glide.c.a(context);
    }

    public static File getPhotoCacheDir(Context context) {
        return com.bumptech.glide.c.b(context);
    }

    @SuppressLint({"VisibleForTests"})
    @Deprecated
    public static void init(com.bumptech.glide.c cVar) {
        com.bumptech.glide.c.a(cVar);
    }

    @SuppressLint({"VisibleForTests"})
    public static void tearDown() {
        com.bumptech.glide.c.i();
    }

    public static GlideRequests with(Context context) {
        return (GlideRequests) com.bumptech.glide.c.c(context);
    }

    public static File getPhotoCacheDir(Context context, String str) {
        return com.bumptech.glide.c.a(context, str);
    }

    @SuppressLint({"VisibleForTests"})
    public static void init(Context context, e eVar) {
        com.bumptech.glide.c.a(context, eVar);
    }

    public static GlideRequests with(Activity activity) {
        return (GlideRequests) com.bumptech.glide.c.a(activity);
    }

    public static GlideRequests with(FragmentActivity fragmentActivity) {
        return (GlideRequests) com.bumptech.glide.c.a(fragmentActivity);
    }

    public static GlideRequests with(Fragment fragment) {
        return (GlideRequests) com.bumptech.glide.c.a(fragment);
    }

    @Deprecated
    public static GlideRequests with(android.app.Fragment fragment) {
        return (GlideRequests) com.bumptech.glide.c.a(fragment);
    }

    public static GlideRequests with(View view) {
        return (GlideRequests) com.bumptech.glide.c.a(view);
    }
}
