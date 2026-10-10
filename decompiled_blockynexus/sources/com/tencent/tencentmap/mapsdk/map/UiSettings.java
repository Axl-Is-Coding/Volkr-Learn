package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.rastercore.d.a;

/* JADX INFO: loaded from: classes5.dex */
public final class UiSettings {
    public static final int LOGO_POSITION_CENTER_BOTTOM = 4;
    public static final int LOGO_POSITION_CENTER_TOP = 5;
    public static final int LOGO_POSITION_LEFT_BOTTOM = 0;
    public static final int LOGO_POSITION_LEFT_TOP = 3;
    public static final int LOGO_POSITION_RIGHT_BOTTOM = 1;
    public static final int LOGO_POSITION_RIGHT_TOP = 2;
    public static final int SCALEVIEW_POSITION_CENTER_BOTTOM = 1;
    public static final int SCALEVIEW_POSITION_LEFT_BOTTOM = 0;
    public static final int SCALEVIEW_POSITION_RIGHT_BOTTOM = 2;
    private a.AnonymousClass1 uiSettingsDelegate$41cd271b;

    public UiSettings(a.AnonymousClass1 anonymousClass1) {
        this.uiSettingsDelegate$41cd271b = anonymousClass1;
    }

    protected final int getLogoPosition() {
        return this.uiSettingsDelegate$41cd271b.j();
    }

    protected final int getScaleViewPosition() {
        return this.uiSettingsDelegate$41cd271b.f();
    }

    public final boolean isAnimationEnabled() {
        return this.uiSettingsDelegate$41cd271b.k();
    }

    public final boolean isScaleControlsEnabled() {
        return this.uiSettingsDelegate$41cd271b.g();
    }

    protected final boolean isScrollGesturesEnabled() {
        return this.uiSettingsDelegate$41cd271b.h();
    }

    protected final boolean isZoomGesturesEnabled() {
        return this.uiSettingsDelegate$41cd271b.i();
    }

    protected final void setAllGesturesEnabled(boolean z) {
        this.uiSettingsDelegate$41cd271b.d(z);
    }

    public final void setAnimationEnabled(boolean z) {
        this.uiSettingsDelegate$41cd271b.e(z);
    }

    public final void setLogoPosition(int i) {
        this.uiSettingsDelegate$41cd271b.b(i);
    }

    public final void setLogoPosition(int i, int[] iArr) {
        a.AnonymousClass1 anonymousClass1 = this.uiSettingsDelegate$41cd271b;
        if (anonymousClass1 != null) {
            anonymousClass1.a(i, iArr);
        }
    }

    public final void setLogoScale(float f2) {
        a.AnonymousClass1 anonymousClass1 = this.uiSettingsDelegate$41cd271b;
        if (anonymousClass1 != null) {
            anonymousClass1.a(f2);
        }
    }

    public final void setScaleControlsEnabled(boolean z) {
        this.uiSettingsDelegate$41cd271b.a(z);
    }

    public final void setScaleViewPosition(int i) {
        this.uiSettingsDelegate$41cd271b.c(i);
    }

    public final void setScrollGesturesEnabled(boolean z) {
        this.uiSettingsDelegate$41cd271b.b(z);
    }

    public final void setZoomGesturesEnabled(boolean z) {
        this.uiSettingsDelegate$41cd271b.c(z);
    }
}
