package c.t.m.g;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: renamed from: c.t.m.g.jb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public final class C0438jb extends ScanCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BluetoothManager f3258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BluetoothAdapter f3259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BluetoothLeScanner f3260d;
    private boolean j;
    private a k;
    private HandlerThread l;
    private byte[] m = new byte[0];
    private List<Ab> g = new LinkedList();
    private List<Ab> h = new LinkedList();
    private String[] i = "AB8190D5-D11E-4941-ACC4-42F30510B408,FDA50693-A4E2-4FB1-AFCF-C6EB07647825".split(",");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ScanSettings f3261e = new ScanSettings.Builder().setScanMode(1).build();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<ScanFilter> f3262f = new ArrayList();

    /* JADX INFO: renamed from: c.t.m.g.jb$a */
    /* JADX INFO: compiled from: TL */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                switch (message.what) {
                    case 99001:
                        C0438jb.this.f3259c = C0438jb.this.f3258b == null ? null : C0438jb.this.f3258b.getAdapter();
                        if (C0438jb.this.f3259c != null) {
                            C0438jb.this.f3260d = C0438jb.this.f3259c.getBluetoothLeScanner();
                        }
                        C0438jb.this.c();
                        break;
                    case 99002:
                        if (C0438jb.this.j) {
                            C0438jb.e(C0438jb.this);
                        }
                        break;
                    case 99003:
                        C0438jb.a(C0438jb.this, (ScanResult) message.obj);
                        break;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public C0438jb(Context context) {
        this.f3257a = context;
        this.f3258b = (BluetoothManager) this.f3257a.getSystemService("bluetooth");
        for (String str : this.i) {
            List<ScanFilter> list = this.f3262f;
            byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            System.arraycopy(a(str.replace("-", "")), 0, bArr, 2, 16);
            list.add(new ScanFilter.Builder().setManufacturerData(76, bArr, new byte[]{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0}).build());
        }
    }

    static /* synthetic */ void e(C0438jb c0438jb) {
        try {
            synchronized (c0438jb.m) {
                if (c0438jb.f3257a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                    if (c0438jb.f3260d != null) {
                        c0438jb.f3260d.stopScan(c0438jb);
                    }
                    c0438jb.f3259c = null;
                    c0438jb.j = false;
                    synchronized (c0438jb.g) {
                        c0438jb.g.clear();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onBatchScanResults(List<ScanResult> list) {
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanFailed(int i) {
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int i, ScanResult scanResult) {
        a aVar = this.k;
        if (aVar != null) {
            Message messageObtainMessage = aVar.obtainMessage();
            messageObtainMessage.what = 99003;
            messageObtainMessage.obj = scanResult;
            aVar.sendMessage(messageObtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        try {
            if (!this.f3257a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                return -1;
            }
            if (this.f3259c == null || !this.f3259c.isEnabled() || this.f3260d == null) {
                return -2;
            }
            this.f3260d.startScan(this.f3262f, this.f3261e, this);
            this.j = true;
            return 0;
        } catch (Throwable unused) {
            return -3;
        }
    }

    public final List<Ab> b() {
        List<Ab> list;
        synchronized (this.g) {
            this.h.clear();
            for (Ab ab : this.g) {
                if (System.currentTimeMillis() - ab.f2876f <= 5000) {
                    this.h.add((Ab) ab.clone());
                }
            }
            this.g.clear();
            list = this.h;
        }
        return list;
    }

    public final void a(Handler handler) {
        synchronized (this.m) {
            if (this.k == null) {
                if (handler != null && handler.getLooper() != null) {
                    this.k = new a(handler.getLooper());
                } else {
                    this.l = new HandlerThread("thread-bleloc");
                    this.l.start();
                    this.k = new a(this.l.getLooper());
                }
            }
            this.k.sendEmptyMessage(99001);
        }
    }

    public final void a() {
        synchronized (this.m) {
            if (this.k != null) {
                this.k.removeCallbacksAndMessages(null);
                this.k.sendEmptyMessage(99002);
                this.k = null;
            }
            if (this.l != null) {
                this.l = null;
            }
        }
    }

    private void a(Ab ab) {
        synchronized (this.g) {
            if (ab != null) {
                this.g.add(ab);
            }
        }
    }

    private static byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    static /* synthetic */ void a(C0438jb c0438jb, ScanResult scanResult) {
        if (scanResult == null) {
            return;
        }
        try {
            BluetoothDevice device = scanResult.getDevice();
            int rssi = scanResult.getRssi();
            byte[] bytes = scanResult.getScanRecord().getBytes();
            if (bytes != null && bytes.length >= 30) {
                c0438jb.a(Ab.a(device, rssi, bytes));
            }
        } catch (Throwable unused) {
        }
    }
}
