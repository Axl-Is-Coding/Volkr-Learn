package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6F, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6F {
    public static String[] A03;
    public final Context A00;
    public final AnonymousClass69 A01;
    public final EnumC13936c A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"COmePc5O6jQNBThxNrU00eLA0sP62Ofb", "1OlTUJms59QGnZv6uedBszpwZ8CEYVJ", "oD0bBsFyrWHU6", "C7a4pm2tyO8SrXv1cdlxK2sPFdgwB5ae", "g8qGNC4JJd68o", "wdv0nL8gPgDp5YXIgWNDO16SJnt", "h7h0bvqqYit4L8HKMEE", "ho5Id5lQMxy9uaRyjuF"};
    }

    public C6F(Context context, AnonymousClass69 anonymousClass69, EnumC13936c enumC13936c) {
        this.A01 = anonymousClass69;
        this.A00 = context;
        this.A02 = enumC13936c;
    }

    public final void A01(MotionEvent motionEvent) {
        int toolType;
        int toolType2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Context context = this.A00;
        String packageName = context == null ? "" : context.getPackageName();
        EnumC13936c enumC13936c = this.A02;
        EnumC13936c enumC13936c2 = EnumC13936c.A0G;
        if (A03[7].length() != 16) {
            String[] strArr = A03;
            strArr[6] = "q52vtyV4o3lWIqbyVHb";
            strArr[6] = "q52vtyV4o3lWIqbyVHb";
            C14026l c14026l = enumC13936c == enumC13936c2 ? null : new C14026l(packageName);
            float f2 = 1.0f;
            char c2 = 1;
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 1:
                case 3:
                case 5:
                case 6:
                    int pointerId = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(pointerId);
                    if (Build.VERSION.SDK_INT >= 14) {
                        toolType = motionEvent.getToolType(pointerId);
                    } else {
                        toolType = -1;
                    }
                    this.A01.A02(new WV(jElapsedRealtime, c14026l, new C6J(motionEvent.getActionMasked(), pointerId2, toolType, new float[]{motionEvent.getRawX(), motionEvent.getRawY()}, motionEvent.getSize(pointerId), Math.min(motionEvent.getPressure(pointerId), 1.0f), motionEvent.getOrientation(pointerId))), AnonymousClass68.A0E);
                    return;
                case 2:
                case 4:
                    int i = 0;
                    while (i < motionEvent.getPointerCount()) {
                        int pointerId3 = motionEvent.getPointerId(i);
                        String[] strArr2 = A03;
                        if (strArr2[2].length() == strArr2[4].length()) {
                            String[] strArr3 = A03;
                            strArr3[1] = "FtxLtPKiBWyCq8d2bMsvLwchXj4m1FL";
                            strArr3[5] = "2ZHjPJSTqIAuT8ks3iUv9R1XL7D";
                            if (Build.VERSION.SDK_INT >= 14) {
                                toolType2 = motionEvent.getToolType(i);
                            } else {
                                toolType2 = -1;
                            }
                            int actionMasked = motionEvent.getActionMasked();
                            float[] fArr = new float[2];
                            fArr[0] = motionEvent.getRawX();
                            fArr[c2] = motionEvent.getRawY();
                            this.A01.A02(new WV(jElapsedRealtime, c14026l, new C6J(actionMasked, pointerId3, toolType2, fArr, motionEvent.getSize(i), Math.min(motionEvent.getPressure(i), f2), motionEvent.getOrientation(i))), AnonymousClass68.A0E);
                            i++;
                            f2 = 1.0f;
                            c2 = 1;
                        }
                        break;
                    }
                    return;
                default:
                    return;
            }
        }
        throw new RuntimeException();
    }
}
