package com.bumptech.glide.load.b.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.m;
import java.util.List;

/* JADX INFO: compiled from: ResourceDrawableDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements m<Uri, Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4338a;

    public d(Context context) {
        this.f4338a = context.getApplicationContext();
    }

    private int b(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return a(context, uri);
        }
        if (pathSegments.size() == 1) {
            return a(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.m
    public boolean a(Uri uri, l lVar) {
        return uri.getScheme().equals("android.resource");
    }

    @Override // com.bumptech.glide.load.m
    public C<Drawable> a(Uri uri, int i, int i2, l lVar) {
        Context contextA = a(uri, uri.getAuthority());
        return c.a(a.a(this.f4338a, contextA, b(contextA, uri)));
    }

    private Context a(Uri uri, String str) {
        if (str.equals(this.f4338a.getPackageName())) {
            return this.f4338a;
        }
        try {
            return this.f4338a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.f4338a.getPackageName())) {
                return this.f4338a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    private int a(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int a(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }
}
