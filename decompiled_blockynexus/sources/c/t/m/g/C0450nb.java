package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.umeng.analytics.pro.au;

/* JADX INFO: renamed from: c.t.m.g.nb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class C0450nb implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile C0450nb f3313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SensorManager f3314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f3315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f3317e;

    private C0450nb(Context context) {
        this.f3314b = (SensorManager) context.getSystemService(au.ab);
        this.f3315c = this.f3314b != null;
    }

    public static C0450nb a(Context context) {
        if (f3313a == null) {
            f3313a = new C0450nb(context);
        }
        return f3313a;
    }

    public final double b() {
        double d2;
        if (!this.f3316d) {
            return Double.NaN;
        }
        synchronized (this) {
            d2 = this.f3317e;
        }
        return d2;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 11) {
                float[] fArr = new float[16];
                float[] fArr2 = new float[3];
                SensorManager.getRotationMatrixFromVector(fArr, sensorEvent.values);
                SensorManager.getOrientation(fArr, fArr2);
                double d2 = fArr2[0];
                synchronized (this) {
                    Double.isNaN(d2);
                    this.f3317e = (d2 * 180.0d) / 3.1415926d;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(Handler handler) {
        if (this.f3315c && !this.f3316d) {
            try {
                Sensor defaultSensor = this.f3314b.getDefaultSensor(11);
                if (defaultSensor == null || handler == null) {
                    return;
                }
                this.f3314b.registerListener(this, defaultSensor, 3, handler);
                this.f3316d = true;
            } catch (Throwable unused) {
            }
        }
    }

    public final void a() {
        if (this.f3315c && this.f3316d) {
            this.f3316d = false;
            synchronized (this) {
                this.f3317e = Double.NaN;
            }
            this.f3314b.unregisterListener(this);
        }
    }
}
