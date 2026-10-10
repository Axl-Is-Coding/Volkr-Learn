package me.iwf.photopicker.widget;

import android.widget.ImageView;

/* JADX INFO: compiled from: TouchImageView.java */
/* JADX INFO: loaded from: classes5.dex */
/* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f22974a = new int[ImageView.ScaleType.values().length];

    static {
        try {
            f22974a[ImageView.ScaleType.CENTER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f22974a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f22974a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f22974a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f22974a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
