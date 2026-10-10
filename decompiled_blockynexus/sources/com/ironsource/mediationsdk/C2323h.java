package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.center.web.http.HttpCode;
import io.grpc.internal.GrpcUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AuctionHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2323h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14836e;
    private com.ironsource.mediationsdk.utils.a g;
    private InterfaceC2321g h;
    private C2374v i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14832a = "1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14833b = "102";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14834c = "103";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14835d = "102";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14837f = com.ironsource.mediationsdk.utils.j.e();

    /* JADX INFO: renamed from: com.ironsource.mediationsdk.h$a */
    /* JADX INFO: compiled from: AuctionHandler.java */
    static class a extends AsyncTask<Object, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<InterfaceC2321g> f14838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f14839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f14840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f14841d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f14842e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List<C2325i> f14843f;
        private C2325i g;
        private long h;
        private int i;
        private String j = "other";

        a(InterfaceC2321g interfaceC2321g) {
            this.f14838a = new WeakReference<>(interfaceC2321g);
        }

        private void a(long j, long j2) {
            long time = j - (new Date().getTime() - j2);
            if (time > 0) {
                SystemClock.sleep(time);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Object... objArr) {
            long time;
            int responseCode;
            this.h = new Date().getTime();
            try {
                URL url = new URL((String) objArr[0]);
                this.f14839b = (JSONObject) objArr[1];
                boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
                int iIntValue = ((Integer) objArr[3]).intValue();
                long jLongValue = ((Long) objArr[4]).longValue();
                this.i = 0;
                HttpURLConnection httpURLConnectionA = null;
                while (this.i < iIntValue) {
                    try {
                        time = new Date().getTime();
                        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "Auction Handler: auction trial " + (this.i + 1) + " out of " + iIntValue + " max trials", 0);
                        httpURLConnectionA = a(url, jLongValue);
                        a(httpURLConnectionA, this.f14839b);
                        responseCode = httpURLConnectionA.getResponseCode();
                    } catch (SocketTimeoutException unused) {
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                        this.f14840c = HttpCode.PASSWORD_NOT_SET;
                        this.f14841d = "Connection timed out";
                    } catch (Exception e2) {
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                        this.f14840c = 1000;
                        this.f14841d = e2.getMessage();
                        this.j = "other";
                        return false;
                    }
                    if (responseCode == 200) {
                        try {
                            a(a(httpURLConnectionA), zBooleanValue);
                            httpURLConnectionA.disconnect();
                            return true;
                        } catch (JSONException e3) {
                            if (e3.getMessage() == null || !e3.getMessage().equalsIgnoreCase("decryption error")) {
                                this.f14840c = 1002;
                                this.f14841d = "Auction parsing error";
                            } else {
                                this.f14840c = IntConstant.PERMISSION_STORAGE_DOWNLOAD;
                                this.f14841d = "Auction decryption error";
                            }
                            this.j = "parsing";
                            httpURLConnectionA.disconnect();
                            return false;
                        }
                    }
                    this.f14840c = 1001;
                    this.f14841d = "Auction status not 200 error, error code response from server - " + responseCode;
                    httpURLConnectionA.disconnect();
                    if (this.i < iIntValue - 1) {
                        a(jLongValue, time);
                    }
                    this.i++;
                }
                this.i = iIntValue - 1;
                this.j = "trials_fail";
                return false;
            } catch (Exception e4) {
                this.f14840c = HttpCode.THIRD_PART_ACCOUNT_ALREADY_BIND_OTHER_USER;
                this.f14841d = e4.getMessage();
                this.i = 0;
                this.j = "other";
                return false;
            }
        }

        private void a(HttpURLConnection httpURLConnection, JSONObject jSONObject) throws IOException {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(String.format("{\"request\" : \"%1$s\"}", com.ironsource.mediationsdk.utils.i.b("C38FB23A402222A0C17D34A92F971D1F", jSONObject.toString())));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
        }

        private HttpURLConnection a(URL url, long j) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpURLConnection.setReadTimeout((int) j);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            return httpURLConnection;
        }

        private void a(String str, boolean z) throws JSONException {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (z) {
                    try {
                        jSONObject = new JSONObject(com.ironsource.mediationsdk.utils.i.a("C38FB23A402222A0C17D34A92F971D1F", jSONObject.getString("response")));
                    } catch (Exception unused) {
                        throw new JSONException("decryption error");
                    }
                }
                AuctionDataUtils.a aVarA = AuctionDataUtils.b().a(jSONObject);
                this.f14842e = aVarA.a();
                this.f14843f = aVarA.e();
                this.g = aVarA.d();
                this.f14840c = aVarA.b();
                this.f14841d = aVarA.c();
                return;
            }
            throw new JSONException("empty response");
        }

        private String a(HttpURLConnection httpURLConnection) throws IOException {
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            InterfaceC2321g interfaceC2321g = this.f14838a.get();
            if (interfaceC2321g == null) {
                return;
            }
            long time = new Date().getTime() - this.h;
            if (bool.booleanValue()) {
                interfaceC2321g.a(this.f14843f, this.f14842e, this.g, this.i + 1, time);
            } else {
                interfaceC2321g.a(this.f14840c, this.f14841d, this.i + 1, this.j, time);
            }
        }
    }

    public C2323h(String str, com.ironsource.mediationsdk.utils.a aVar, InterfaceC2321g interfaceC2321g) {
        this.f14836e = str;
        this.g = aVar;
        this.h = interfaceC2321g;
    }

    public void a(Context context, Map<String, Object> map, List<String> list, AuctionHistory auctionHistory, int i, C2374v c2374v) {
        this.i = c2374v;
        a(context, map, list, auctionHistory, i);
    }

    public void a(Context context, Map<String, Object> map, List<String> list, AuctionHistory auctionHistory, int i) {
        try {
            boolean z = com.ironsource.mediationsdk.utils.j.d() == 1;
            new a(this.h).execute(this.g.n(), a(context, map, list, auctionHistory, i, z), Boolean.valueOf(z), Integer.valueOf(this.g.h()), Long.valueOf(this.g.m()));
        } catch (Exception e2) {
            this.h.a(1000, e2.getMessage(), 0, "other", 0L);
        }
    }

    public void a(C2325i c2325i, int i, C2325i c2325i2, String str) {
        Iterator<String> it = c2325i.a().iterator();
        while (it.hasNext()) {
            AuctionDataUtils.b().e(AuctionDataUtils.b().a(it.next(), i, c2325i, "", "", str));
        }
        if (c2325i2 != null) {
            Iterator<String> it2 = c2325i2.a().iterator();
            while (it2.hasNext()) {
                AuctionDataUtils.b().e(AuctionDataUtils.b().a(it2.next(), i, c2325i, "", "102", str));
            }
        }
    }

    public void a(C2325i c2325i, int i, C2325i c2325i2) {
        Iterator<String> it = c2325i.d().iterator();
        while (it.hasNext()) {
            AuctionDataUtils.b().e(AuctionDataUtils.b().a(it.next(), i, c2325i, "", "", ""));
        }
        if (c2325i2 != null) {
            Iterator<String> it2 = c2325i2.d().iterator();
            while (it2.hasNext()) {
                AuctionDataUtils.b().e(AuctionDataUtils.b().a(it2.next(), i, c2325i, "", "102", ""));
            }
        }
    }

    public void a(CopyOnWriteArrayList<AbstractC2373ua> copyOnWriteArrayList, ConcurrentHashMap<String, C2325i> concurrentHashMap, int i, C2325i c2325i, C2325i c2325i2) {
        boolean z = false;
        boolean zY = false;
        for (AbstractC2373ua abstractC2373ua : copyOnWriteArrayList) {
            String strR = abstractC2373ua.r();
            if (strR.equals(c2325i2.b())) {
                z = true;
                zY = abstractC2373ua.y();
            } else {
                C2325i c2325i3 = concurrentHashMap.get(strR);
                String strE = c2325i3.e();
                String str = z ? zY ? "102" : "103" : "1";
                Iterator<String> it = c2325i3.c().iterator();
                while (it.hasNext()) {
                    AuctionDataUtils.b().e(AuctionDataUtils.b().a(it.next(), i, c2325i2, strE, str, ""));
                }
            }
        }
        if (c2325i != null) {
            Iterator<String> it2 = c2325i.c().iterator();
            while (it2.hasNext()) {
                AuctionDataUtils.b().e(AuctionDataUtils.b().a(it2.next(), i, c2325i2, "", "102", ""));
            }
        }
    }

    private JSONObject a(Context context, Map<String, Object> map, List<String> list, AuctionHistory auctionHistory, int i, boolean z) throws JSONException {
        new JSONObject();
        JSONObject jSONObjectA = AuctionDataUtils.b().a(context, map, list, auctionHistory, i, this.f14837f, this.g, this.i);
        jSONObjectA.put("adUnit", this.f14836e);
        jSONObjectA.put("doNotEncryptResponse", z ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        return jSONObjectA;
    }
}
