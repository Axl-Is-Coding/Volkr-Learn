package com.twitter.sdk.android.core.internal.oauth;

import com.tendcloud.tenddata.aa;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.s;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.ByteString;

/* JADX INFO: compiled from: OAuth1aParameters.java */
/* JADX INFO: loaded from: classes5.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SecureRandom f20190a = new SecureRandom();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f20191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f20192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f20193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f20194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f20195f;
    private final Map<String, String> g;

    e(q qVar, s sVar, String str, String str2, String str3, Map<String, String> map) {
        this.f20191b = qVar;
        this.f20192c = sVar;
        this.f20193d = str;
        this.f20194e = str2;
        this.f20195f = str3;
        this.g = map;
    }

    private String b() {
        return String.valueOf(System.nanoTime()) + String.valueOf(Math.abs(f20190a.nextLong()));
    }

    private String c() {
        s sVar = this.f20192c;
        return com.twitter.sdk.android.core.internal.a.f.c(this.f20191b.b()) + '&' + com.twitter.sdk.android.core.internal.a.f.c(sVar != null ? sVar.f20268c : null);
    }

    private String d() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    public String a() {
        String strB = b();
        String strD = d();
        return a(strB, strD, a(a(strB, strD)));
    }

    String a(String str, String str2) {
        String str3;
        URI uriCreate = URI.create(this.f20195f);
        TreeMap<String, String> treeMapA = com.twitter.sdk.android.core.internal.a.f.a(uriCreate, true);
        Map<String, String> map = this.g;
        if (map != null) {
            treeMapA.putAll(map);
        }
        String str4 = this.f20193d;
        if (str4 != null) {
            treeMapA.put("oauth_callback", str4);
        }
        treeMapA.put("oauth_consumer_key", this.f20191b.a());
        treeMapA.put("oauth_nonce", str);
        treeMapA.put("oauth_signature_method", "HMAC-SHA1");
        treeMapA.put("oauth_timestamp", str2);
        s sVar = this.f20192c;
        if (sVar != null && (str3 = sVar.f20267b) != null) {
            treeMapA.put("oauth_token", str3);
        }
        treeMapA.put("oauth_version", "1.0");
        return this.f20194e.toUpperCase(Locale.ENGLISH) + '&' + com.twitter.sdk.android.core.internal.a.f.a(uriCreate.getScheme() + aa.f19741a + uriCreate.getHost() + uriCreate.getPath()) + '&' + a(treeMapA);
    }

    private String a(TreeMap<String, String> treeMap) {
        StringBuilder sb = new StringBuilder();
        int size = treeMap.size();
        int i = 0;
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append(com.twitter.sdk.android.core.internal.a.f.a(com.twitter.sdk.android.core.internal.a.f.a(entry.getKey())));
            sb.append("%3D");
            sb.append(com.twitter.sdk.android.core.internal.a.f.a(com.twitter.sdk.android.core.internal.a.f.a(entry.getValue())));
            i++;
            if (i < size) {
                sb.append("%26");
            }
        }
        return sb.toString();
    }

    String a(String str) {
        try {
            String strC = c();
            byte[] bytes = str.getBytes("UTF8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(strC.getBytes("UTF8"), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            byte[] bArrDoFinal = mac.doFinal(bytes);
            return ByteString.of(bArrDoFinal, 0, bArrDoFinal.length).base64();
        } catch (UnsupportedEncodingException e2) {
            n.e().e("Twitter", "Failed to calculate signature", e2);
            return "";
        } catch (InvalidKeyException e3) {
            n.e().e("Twitter", "Failed to calculate signature", e3);
            return "";
        } catch (NoSuchAlgorithmException e4) {
            n.e().e("Twitter", "Failed to calculate signature", e4);
            return "";
        }
    }

    String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("OAuth");
        a(sb, "oauth_callback", this.f20193d);
        a(sb, "oauth_consumer_key", this.f20191b.a());
        a(sb, "oauth_nonce", str);
        a(sb, "oauth_signature", str3);
        a(sb, "oauth_signature_method", "HMAC-SHA1");
        a(sb, "oauth_timestamp", str2);
        s sVar = this.f20192c;
        a(sb, "oauth_token", sVar != null ? sVar.f20267b : null);
        a(sb, "oauth_version", "1.0");
        return sb.substring(0, sb.length() - 1);
    }

    private void a(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(' ');
            sb.append(com.twitter.sdk.android.core.internal.a.f.a(str));
            sb.append("=\"");
            sb.append(com.twitter.sdk.android.core.internal.a.f.a(str2));
            sb.append("\",");
        }
    }
}
