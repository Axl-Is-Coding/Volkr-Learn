package com.unity3d.services.ar.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.WindowManager;
import com.google.ar.core.Session;

/* JADX INFO: loaded from: classes5.dex */
@TargetApi(23)
public class DisplayRotationHelper implements DisplayManager.DisplayListener {
    private final Context context;
    private final Display display;
    private boolean viewportChanged;
    private int viewportHeight;
    private int viewportWidth;

    DisplayRotationHelper(Context context) {
        this.context = context;
        this.display = ((WindowManager) context.getSystemService(WindowManager.class)).getDefaultDisplay();
    }

    public int getRotation() {
        return this.display.getRotation();
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i) {
        this.viewportChanged = true;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i) {
    }

    void onPause() {
        ((DisplayManager) this.context.getSystemService(DisplayManager.class)).unregisterDisplayListener(this);
    }

    void onResume() {
        ((DisplayManager) this.context.getSystemService(DisplayManager.class)).registerDisplayListener(this, null);
    }

    void onSurfaceChanged(int i, int i2) {
        this.viewportWidth = i;
        this.viewportHeight = i2;
        this.viewportChanged = true;
    }

    void updateSessionIfNeeded(Session session) {
        if (this.viewportChanged) {
            session.setDisplayGeometry(this.display.getRotation(), this.viewportWidth, this.viewportHeight);
            this.viewportChanged = false;
        }
    }
}
