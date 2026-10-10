package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: GifHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f4198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f4199c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f4197a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4200d = 0;

    private boolean c() {
        return this.f4199c.f4192b != 0;
    }

    private int d() {
        try {
            return this.f4198b.get() & 255;
        } catch (Exception unused) {
            this.f4199c.f4192b = 1;
            return 0;
        }
    }

    private void e() {
        this.f4199c.f4194d.f4185a = l();
        this.f4199c.f4194d.f4186b = l();
        this.f4199c.f4194d.f4187c = l();
        this.f4199c.f4194d.f4188d = l();
        int iD = d();
        boolean z = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.f4199c.f4194d.f4189e = (iD & 64) != 0;
        if (z) {
            this.f4199c.f4194d.k = a(iPow);
        } else {
            this.f4199c.f4194d.k = null;
        }
        this.f4199c.f4194d.j = this.f4198b.position();
        o();
        if (c()) {
            return;
        }
        c cVar = this.f4199c;
        cVar.f4193c++;
        cVar.f4195e.add(cVar.f4194d);
    }

    private void f() {
        this.f4200d = d();
        if (this.f4200d > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.f4200d) {
                try {
                    i2 = this.f4200d - i;
                    this.f4198b.get(this.f4197a, i, i2);
                    i += i2;
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f4200d, e2);
                    }
                    this.f4199c.f4192b = 1;
                    return;
                }
            }
        }
    }

    private void g() {
        b(Integer.MAX_VALUE);
    }

    private void h() {
        d();
        int iD = d();
        b bVar = this.f4199c.f4194d;
        bVar.g = (iD & 28) >> 2;
        if (bVar.g == 0) {
            bVar.g = 1;
        }
        this.f4199c.f4194d.f4190f = (iD & 1) != 0;
        int iL = l();
        if (iL < 2) {
            iL = 10;
        }
        b bVar2 = this.f4199c.f4194d;
        bVar2.i = iL * 10;
        bVar2.h = d();
        d();
    }

    private void i() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f4199c.f4192b = 1;
            return;
        }
        j();
        if (!this.f4199c.h || c()) {
            return;
        }
        c cVar = this.f4199c;
        cVar.f4191a = a(cVar.i);
        c cVar2 = this.f4199c;
        cVar2.l = cVar2.f4191a[cVar2.j];
    }

    private void j() {
        this.f4199c.f4196f = l();
        this.f4199c.g = l();
        this.f4199c.h = (d() & 128) != 0;
        this.f4199c.i = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.f4199c.j = d();
        this.f4199c.k = d();
    }

    private void k() {
        do {
            f();
            byte[] bArr = this.f4197a;
            if (bArr[0] == 1) {
                this.f4199c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f4200d <= 0) {
                return;
            }
        } while (!c());
    }

    private int l() {
        return this.f4198b.getShort();
    }

    private void m() {
        this.f4198b = null;
        Arrays.fill(this.f4197a, (byte) 0);
        this.f4199c = new c();
        this.f4200d = 0;
    }

    private void n() {
        int iD;
        do {
            iD = d();
            this.f4198b.position(Math.min(this.f4198b.position() + iD, this.f4198b.limit()));
        } while (iD > 0);
    }

    private void o() {
        d();
        n();
    }

    public d a(ByteBuffer byteBuffer) {
        m();
        this.f4198b = byteBuffer.asReadOnlyBuffer();
        this.f4198b.position(0);
        this.f4198b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public c b() {
        if (this.f4198b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (c()) {
            return this.f4199c;
        }
        i();
        if (!c()) {
            g();
            c cVar = this.f4199c;
            if (cVar.f4193c < 0) {
                cVar.f4192b = 1;
            }
        }
        return this.f4199c;
    }

    public void a() {
        this.f4198b = null;
        this.f4199c = null;
    }

    private int[] a(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f4198b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f4199c.f4192b = 1;
        }
        return iArr;
    }

    private void b(int i) {
        boolean z = false;
        while (!z && !c() && this.f4199c.f4193c <= i) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 == 1) {
                    n();
                } else if (iD2 == 249) {
                    this.f4199c.f4194d = new b();
                    h();
                } else if (iD2 == 254) {
                    n();
                } else if (iD2 != 255) {
                    n();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.f4197a[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        k();
                    } else {
                        n();
                    }
                }
            } else if (iD == 44) {
                c cVar = this.f4199c;
                if (cVar.f4194d == null) {
                    cVar.f4194d = new b();
                }
                e();
            } else if (iD != 59) {
                this.f4199c.f4192b = 1;
            } else {
                z = true;
            }
        }
    }
}
