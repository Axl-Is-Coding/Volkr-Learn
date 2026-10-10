package com.facebook.ads.redexgen.X;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.widget.Toast;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ln, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1755Ln implements SensorEventListener {
    public static byte[] A0A;
    public long A04;
    public long A05;
    public long A06;

    @Nullable
    public SensorManager A07;
    public final C2026Wb A08;
    public int A03 = 0;
    public float A00 = -1.0f;
    public float A01 = -1.0f;
    public float A02 = -1.0f;
    public final Set<InterfaceC1754Lm> A09 = new CopyOnWriteArraySet();

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{119, 65, 74, 87, 75, 86, 87, 4, 74, 75, 80, 4, 87, 81, 84, 84, 75, 86, 80, 65, 64, 17, 42, 35, 41, 43, 44, 37, 98, 44, 45, 54, 98, 49, 55, 50, 50, 45, 48, 54, 39, 38, 21, 3, 8, 21, 9, 20};
    }

    public C1755Ln(C2026Wb c2026Wb) {
        this.A08 = c2026Wb;
    }

    private void A01() {
        SensorManager sensorManager;
        this.A07 = (SensorManager) this.A08.getSystemService(A00(42, 6, 41));
        if (this.A07 == null) {
            Toast.makeText(this.A08, A00(0, 21, 107), 1).show();
        }
        boolean zRegisterListener = false;
        try {
            zRegisterListener = this.A07.registerListener(this, this.A07.getDefaultSensor(1), 3);
        } catch (Exception unused) {
            Toast.makeText(this.A08, A00(21, 21, 13), 1).show();
        }
        if (!zRegisterListener && (sensorManager = this.A07) != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public final void A03(InterfaceC1754Lm interfaceC1754Lm) {
        if (this.A09.isEmpty()) {
            A01();
        } else if (this.A09.contains(interfaceC1754Lm)) {
            return;
        }
        this.A09.add(interfaceC1754Lm);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 1) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long now = this.A04;
        if (jElapsedRealtime - now > 500) {
            this.A03 = 0;
        }
        long j = this.A06;
        if (jElapsedRealtime - j > 100) {
            long now2 = jElapsedRealtime - j;
            float speed = (Math.abs(((((sensorEvent.values[0] + sensorEvent.values[1]) + sensorEvent.values[2]) - this.A00) - this.A01) - this.A02) / now2) * 10000.0f;
            if (speed > 800.0f) {
                int i = this.A03 + 1;
                this.A03 = i;
                if (i >= 3) {
                    long now3 = this.A05;
                    if (jElapsedRealtime - now3 > 1000) {
                        this.A05 = jElapsedRealtime;
                        this.A03 = 0;
                        Iterator<InterfaceC1754Lm> it = this.A09.iterator();
                        while (it.hasNext()) {
                            it.next().ABE();
                        }
                    }
                }
                this.A04 = jElapsedRealtime;
            }
            this.A06 = jElapsedRealtime;
            this.A00 = sensorEvent.values[0];
            this.A01 = sensorEvent.values[1];
            this.A02 = sensorEvent.values[2];
        }
    }
}
