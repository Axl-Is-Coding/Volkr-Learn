package com.opensource.svgaplayer.a;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.b.e;
import com.opensource.svgaplayer.entities.f;
import com.opensource.svgaplayer.entities.g;
import com.opensource.svgaplayer.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
import kotlin.text.n;

/* JADX INFO: compiled from: SGVADrawer.kt */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f15452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f15453b;

    /* JADX INFO: renamed from: com.opensource.svgaplayer.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SGVADrawer.kt */
    public final class C0143a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final g f15456c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f15457d;

        public C0143a(a aVar, String str, String str2, g gVar) {
            i.b(gVar, "frameEntity");
            this.f15457d = aVar;
            this.f15454a = str;
            this.f15455b = str2;
            this.f15456c = gVar;
        }

        public final g a() {
            return this.f15456c;
        }

        public final String b() {
            return this.f15455b;
        }

        public final String c() {
            return this.f15454a;
        }
    }

    public a(q qVar) {
        i.b(qVar, "videoItem");
        this.f15453b = qVar;
        this.f15452a = new e();
    }

    public final e a() {
        return this.f15452a;
    }

    public final q b() {
        return this.f15453b;
    }

    public final List<C0143a> a(int i) {
        String strB;
        List<f> listG = this.f15453b.g();
        ArrayList arrayList = new ArrayList();
        for (f fVar : listG) {
            C0143a c0143a = null;
            if (i >= 0 && i < fVar.a().size() && (strB = fVar.b()) != null && (n.a(strB, ".matte", false, 2, null) || fVar.a().get(i).a() > 0.0d)) {
                c0143a = new C0143a(this, fVar.c(), fVar.b(), fVar.a().get(i));
            }
            if (c0143a != null) {
                arrayList.add(c0143a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        i.b(canvas, "canvas");
        i.b(scaleType, "scaleType");
        this.f15452a.a(canvas.getWidth(), canvas.getHeight(), (float) this.f15453b.h().b(), (float) this.f15453b.h().a(), scaleType);
    }
}
