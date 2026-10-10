package com.tencent.mapsdk.rastercore;

import android.content.Context;
import android.os.AsyncTask;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.d.h;
import com.tencent.mapsdk.rastercore.tile.MapTile;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f19478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f19479b;

    public interface a {
        void b(boolean z);
    }

    class b extends AsyncTask<String, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<a> f19480a;

        public b(a aVar) {
            this.f19480a = new WeakReference<>(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            if (strArr != null && strArr.length > 0) {
                InputStream gZIPInputStream = null;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                    if (httpURLConnection.getResponseCode() == 200) {
                        String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                        gZIPInputStream = headerField != null && headerField.length() > 0 && headerField.toLowerCase().contains("gzip") ? new GZIPInputStream(httpURLConnection.getInputStream()) : httpURLConnection.getInputStream();
                        Boolean boolValueOf = Boolean.valueOf(d.this.a(new String(c.a(gZIPInputStream))));
                        c.a((Closeable) gZIPInputStream);
                        return boolValueOf;
                    }
                } catch (Throwable th) {
                    c.a((Closeable) gZIPInputStream);
                    throw th;
                }
                c.a((Closeable) gZIPInputStream);
            }
            return false;
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Boolean bool) {
            Boolean bool2 = bool;
            super.onPostExecute(bool2);
            WeakReference<a> weakReference = this.f19480a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f19480a.get().b(bool2.booleanValue());
        }
    }

    public d(Context context, a aVar) {
        this.f19479b = "https://overseactrl.map.qq.com/?apikey=" + com.tencent.mapsdk.rastercore.f.b.a(context) + "&ver=1.3.2&ctrlpf=grid&ctrlmb=and&ctrlver=" + h.i() + "&frontier=" + com.tencent.mapsdk.rastercore.f.a.a().b("");
        this.f19478a = new b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        String strOptString;
        if (str != null && str.length() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("error", Integer.MIN_VALUE) != 0) {
                    h.a(false);
                    com.tencent.mapsdk.rastercore.f.a.a().a("world_map_enable", false);
                    String string = jSONObject.getJSONObject("info").getJSONArray("detail").toString();
                    com.tencent.mapsdk.rastercore.f.a.a().a("world_map_logo_change_rule_json", string);
                    h.a(string);
                    return true;
                }
                h.a(true);
                com.tencent.mapsdk.rastercore.f.a.a().a("world_map_enable", true);
                JSONObject jSONObject2 = jSONObject.getJSONObject("info");
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("frontier");
                if (jSONObjectOptJSONObject != null && (strOptString = jSONObjectOptJSONObject.optString("path")) != null && strOptString.length() != 0) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strOptString).openConnection();
                        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                        if (httpURLConnection.getResponseCode() == 200) {
                            String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                            if (headerField != null && headerField.length() > 0) {
                                headerField.toLowerCase().contains("gzip");
                            }
                            String str2 = new String(c.a((InputStream) new GZIPInputStream(httpURLConnection.getInputStream())));
                            e.a();
                            com.tencent.mapsdk.rastercore.f.a.a().a("", e.b(str2));
                            e.a().a(str2);
                        }
                    } catch (Throwable unused) {
                    }
                }
                int i = jSONObject2.getInt("version");
                if (!(i != h.i())) {
                    return false;
                }
                h.m();
                JSONObject jSONObject3 = jSONObject2.getJSONObject("tilesrc");
                int iOptInt = jSONObject3.optInt(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, 1000);
                int iOptInt2 = jSONObject3.optInt("scene", 0);
                int iOptInt3 = jSONObject3.optInt("version", com.tencent.mapsdk.rastercore.b.f19436e);
                if (iOptInt3 != h.g()) {
                    com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.WORLD);
                }
                String string2 = jSONObject2.getJSONArray("detail").toString();
                h.a(iOptInt2, iOptInt, iOptInt3, i, null, string2);
                com.tencent.mapsdk.rastercore.f.a.a().a("world_map_tile_url_regex", (String) null);
                com.tencent.mapsdk.rastercore.f.a.a().a("world_map_version", iOptInt3);
                com.tencent.mapsdk.rastercore.f.a.a().a("world_map_style", iOptInt);
                com.tencent.mapsdk.rastercore.f.a.a().a("world_map_scene", iOptInt2);
                com.tencent.mapsdk.rastercore.f.a.a().a("world_map_logo_change_rule_json", string2);
                com.tencent.mapsdk.rastercore.f.a.a().a("world_map_protocol_version", i);
                return true;
            } catch (Throwable unused2) {
                com.tencent.mapsdk.rastercore.f.a.a().a("world_map_protocol_version", 0);
            }
        }
        return false;
    }

    public final void a() {
        this.f19478a.execute(this.f19479b);
    }
}
