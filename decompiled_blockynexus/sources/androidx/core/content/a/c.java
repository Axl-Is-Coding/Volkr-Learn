package androidx.core.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: FontResourcesParserCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public interface a {
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final C0009c[] f1043a;

        public b(C0009c[] c0009cArr) {
            this.f1043a = c0009cArr;
        }

        public C0009c[] a() {
            return this.f1043a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.content.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class C0009c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f1047d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1048e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1049f;

        public C0009c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f1044a = str;
            this.f1045b = i;
            this.f1046c = z;
            this.f1047d = str2;
            this.f1048e = i2;
            this.f1049f = i3;
        }

        public String a() {
            return this.f1044a;
        }

        public int b() {
            return this.f1049f;
        }

        public int c() {
            return this.f1048e;
        }

        public String d() {
            return this.f1047d;
        }

        public int e() {
            return this.f1045b;
        }

        public boolean f() {
            return this.f1046c;
        }
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.core.d.a f1050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1052c;

        public d(androidx.core.d.a aVar, int i, int i2) {
            this.f1050a = aVar;
            this.f1052c = i;
            this.f1051b = i2;
        }

        public int a() {
            return this.f1052c;
        }

        public androidx.core.d.a b() {
            return this.f1050a;
        }

        public int c() {
            return this.f1051b;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static a c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new d(new androidx.core.d.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(d(xmlPullParser, resources));
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0009c[]) arrayList.toArray(new C0009c[arrayList.size()]));
    }

    private static C0009c d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_fontWeight) ? R.styleable.FontFamilyFont_fontWeight : R.styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_fontStyle) ? R.styleable.FontFamilyFont_fontStyle : R.styleable.FontFamilyFont_android_fontStyle, 0);
        int i2 = typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_ttcIndex) ? R.styleable.FontFamilyFont_ttcIndex : R.styleable.FontFamilyFont_android_ttcIndex;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_fontVariationSettings) ? R.styleable.FontFamilyFont_fontVariationSettings : R.styleable.FontFamilyFont_android_fontVariationSettings);
        int i3 = typedArrayObtainAttributes.getInt(i2, 0);
        int i4 = typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_font) ? R.styleable.FontFamilyFont_font : R.styleable.FontFamilyFont_android_font;
        int resourceId = typedArrayObtainAttributes.getResourceId(i4, 0);
        String string2 = typedArrayObtainAttributes.getString(i4);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new C0009c(string2, i, z, string, i3, resourceId);
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
