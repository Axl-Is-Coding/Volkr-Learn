package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.At, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC1502At {
    public static final ByteBuffer A00 = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    boolean A47(int i, int i2, int i3) throws C1501As;

    ByteBuffer A6h();

    int A6i();

    int A6j();

    int A6k();

    boolean A7j();

    boolean A7n();

    void ACD();

    void ACE(ByteBuffer byteBuffer);

    void flush();

    void reset();
}
