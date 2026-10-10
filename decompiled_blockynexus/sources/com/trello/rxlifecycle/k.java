package com.trello.rxlifecycle;

/* JADX INFO: compiled from: RxLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
/* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f20091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f20092b = new int[FragmentEvent.values().length];

    static {
        try {
            f20092b[FragmentEvent.ATTACH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20092b[FragmentEvent.CREATE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20092b[FragmentEvent.CREATE_VIEW.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20092b[FragmentEvent.START.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f20092b[FragmentEvent.RESUME.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f20092b[FragmentEvent.PAUSE.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f20092b[FragmentEvent.STOP.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f20092b[FragmentEvent.DESTROY_VIEW.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f20092b[FragmentEvent.DESTROY.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f20092b[FragmentEvent.DETACH.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        f20091a = new int[ActivityEvent.values().length];
        try {
            f20091a[ActivityEvent.CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f20091a[ActivityEvent.START.ordinal()] = 2;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f20091a[ActivityEvent.RESUME.ordinal()] = 3;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f20091a[ActivityEvent.PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f20091a[ActivityEvent.STOP.ordinal()] = 5;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f20091a[ActivityEvent.DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused16) {
        }
    }
}
