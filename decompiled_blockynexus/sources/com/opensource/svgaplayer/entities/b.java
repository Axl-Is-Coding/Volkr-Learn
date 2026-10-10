package com.opensource.svgaplayer.entities;

import android.graphics.Path;
import java.util.StringTokenizer;
import kotlin.jvm.internal.i;
import kotlin.text.n;
import kotlin.text.o;

/* JADX INFO: compiled from: SVGAPathEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Path f15517b;

    public b(String str) {
        i.b(str, "originValue");
        this.f15516a = o.a((CharSequence) str, (CharSequence) ",", false, 2, (Object) null) ? n.a(str, ",", " ", false, 4, (Object) null) : str;
    }

    public final void a(Path path) {
        i.b(path, "toPath");
        Path path2 = this.f15517b;
        if (path2 != null) {
            path.set(path2);
            return;
        }
        Path path3 = new Path();
        StringTokenizer stringTokenizer = new StringTokenizer(this.f15516a, "MLHVCSQRAZmlhvcsqraz", true);
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            i.a((Object) strNextToken, "segment");
            if (!(strNextToken.length() == 0)) {
                if (c.f15518a.contains(strNextToken)) {
                    if (i.a((Object) strNextToken, (Object) "Z") || i.a((Object) strNextToken, (Object) "z")) {
                        a(path3, strNextToken, new StringTokenizer("", ""));
                    }
                    str = strNextToken;
                } else {
                    a(path3, str, new StringTokenizer(strNextToken, " "));
                }
            }
        }
        this.f15517b = path3;
        path.set(path3);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(android.graphics.Path r16, java.lang.String r17, java.util.StringTokenizer r18) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.entities.b.a(android.graphics.Path, java.lang.String, java.util.StringTokenizer):void");
    }
}
