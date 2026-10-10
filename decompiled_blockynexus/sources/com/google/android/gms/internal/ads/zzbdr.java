package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import cn.qqtheme.framework.widget.WheelView;
import com.umeng.analytics.pro.au;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdr implements SensorEventListener {
    private final SensorManager zzehi;
    private final Display zzehk;
    private float[] zzehn;
    private Handler zzeho;
    private zzbdt zzehp;
    private final float[] zzehl = new float[9];
    private final float[] zzehm = new float[9];
    private final Object zzehj = new Object();

    zzbdr(Context context) {
        this.zzehi = (SensorManager) context.getSystemService(au.ab);
        this.zzehk = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private final void zzl(int i, int i2) {
        float[] fArr = this.zzehm;
        float f2 = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f2;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == WheelView.DividerConfig.FILL && fArr[1] == WheelView.DividerConfig.FILL && fArr[2] == WheelView.DividerConfig.FILL) {
            return;
        }
        synchronized (this.zzehj) {
            if (this.zzehn == null) {
                this.zzehn = new float[9];
            }
        }
        SensorManager.getRotationMatrixFromVector(this.zzehl, fArr);
        int rotation = this.zzehk.getRotation();
        if (rotation == 1) {
            SensorManager.remapCoordinateSystem(this.zzehl, 2, 129, this.zzehm);
        } else if (rotation == 2) {
            SensorManager.remapCoordinateSystem(this.zzehl, 129, 130, this.zzehm);
        } else if (rotation != 3) {
            System.arraycopy(this.zzehl, 0, this.zzehm, 0, 9);
        } else {
            SensorManager.remapCoordinateSystem(this.zzehl, 130, 1, this.zzehm);
        }
        zzl(1, 3);
        zzl(2, 6);
        zzl(5, 7);
        synchronized (this.zzehj) {
            System.arraycopy(this.zzehm, 0, this.zzehn, 0, 9);
        }
        zzbdt zzbdtVar = this.zzehp;
        if (zzbdtVar != null) {
            zzbdtVar.zzux();
        }
    }

    final void start() {
        if (this.zzeho != null) {
            return;
        }
        Sensor defaultSensor = this.zzehi.getDefaultSensor(11);
        if (defaultSensor == null) {
            zzbbq.zzfc("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        this.zzeho = new zzdvo(handlerThread.getLooper());
        if (this.zzehi.registerListener(this, defaultSensor, 0, this.zzeho)) {
            return;
        }
        zzbbq.zzfc("SensorManager.registerListener failed.");
        stop();
    }

    final void stop() {
        if (this.zzeho == null) {
            return;
        }
        this.zzehi.unregisterListener(this);
        this.zzeho.post(new zzbdq(this));
        this.zzeho = null;
    }

    final void zza(zzbdt zzbdtVar) {
        this.zzehp = zzbdtVar;
    }

    final boolean zza(float[] fArr) {
        synchronized (this.zzehj) {
            if (this.zzehn == null) {
                return false;
            }
            System.arraycopy(this.zzehn, 0, fArr, 0, this.zzehn.length);
            return true;
        }
    }
}
