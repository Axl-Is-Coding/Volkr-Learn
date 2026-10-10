package com.tencent.tp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.umeng.analytics.pro.au;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes5.dex */
public class m implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile m f19704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SensorManager f19705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set f19708e = new TreeSet();

    private m() {
    }

    public static m a() {
        if (f19704a == null) {
            synchronized (m.class) {
                if (f19704a == null) {
                    f19704a = new m();
                }
            }
        }
        return f19704a;
    }

    public void a(Context context) {
        if (this.f19706c) {
            return;
        }
        this.f19706c = true;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService(au.ab);
            if (sensorManager == null) {
                return;
            }
            this.f19705b = sensorManager;
            this.f19707d = 0;
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
        } catch (Throwable unused) {
            r.a(q.a("Dido NzinjmHvivbzm avdgzy"));
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr == null || fArr.length < 3) {
            this.f19705b.unregisterListener(this);
            return;
        }
        this.f19708e.add(Integer.valueOf((int) (fArr[2] * 10.0f)));
        int i = this.f19707d;
        this.f19707d = i + 1;
        if (i > 1024 || (this.f19707d > 64 && this.f19708e.size() > 12)) {
            this.f19705b.unregisterListener(this);
            if (this.f19707d > 1000) {
                r.a(q.a("NzinjmXcvibzOjjHpxc"));
            }
            try {
                r.c(q.a("NzinjmXio:") + this.f19708e.size() + q.a(" XcvibzXio:") + this.f19707d);
            } catch (Throwable unused) {
            }
        }
    }
}
