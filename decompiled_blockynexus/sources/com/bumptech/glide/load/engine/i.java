package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.DecodeJob;

/* JADX INFO: compiled from: DecodeJob.java */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f4573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f4574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ int[] f4575c = new int[EncodeStrategy.values().length];

    static {
        try {
            f4575c[EncodeStrategy.SOURCE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4575c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f4574b = new int[DecodeJob.Stage.values().length];
        try {
            f4574b[DecodeJob.Stage.RESOURCE_CACHE.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f4574b[DecodeJob.Stage.DATA_CACHE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f4574b[DecodeJob.Stage.SOURCE.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f4574b[DecodeJob.Stage.FINISHED.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f4574b[DecodeJob.Stage.INITIALIZE.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        f4573a = new int[DecodeJob.RunReason.values().length];
        try {
            f4573a[DecodeJob.RunReason.INITIALIZE.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f4573a[DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f4573a[DecodeJob.RunReason.DECODE_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
