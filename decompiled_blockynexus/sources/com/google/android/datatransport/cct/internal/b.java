package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

/* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Configurator f12744a = new b();

    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class a implements ObjectEncoder<com.google.android.datatransport.cct.internal.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f12745a = new a();

        private a() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(com.google.android.datatransport.cct.internal.a aVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("sdkVersion", aVar.m());
            objectEncoderContext.add("model", aVar.j());
            objectEncoderContext.add("hardware", aVar.f());
            objectEncoderContext.add("device", aVar.d());
            objectEncoderContext.add("product", aVar.l());
            objectEncoderContext.add("osBuild", aVar.k());
            objectEncoderContext.add("manufacturer", aVar.h());
            objectEncoderContext.add("fingerprint", aVar.e());
            objectEncoderContext.add("locale", aVar.g());
            objectEncoderContext.add("country", aVar.c());
            objectEncoderContext.add("mccMnc", aVar.i());
            objectEncoderContext.add("applicationBuild", aVar.b());
        }
    }

    /* JADX INFO: renamed from: com.google.android.datatransport.cct.internal.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class C0102b implements ObjectEncoder<o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final C0102b f12746a = new C0102b();

        private C0102b() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(o oVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("logRequest", oVar.b());
        }
    }

    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class c implements ObjectEncoder<ClientInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f12747a = new c();

        private c() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("clientType", clientInfo.c());
            objectEncoderContext.add("androidClientInfo", clientInfo.b());
        }
    }

    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class d implements ObjectEncoder<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f12748a = new d();

        private d() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(p pVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("eventTimeMs", pVar.b());
            objectEncoderContext.add("eventCode", pVar.a());
            objectEncoderContext.add("eventUptimeMs", pVar.c());
            objectEncoderContext.add("sourceExtension", pVar.e());
            objectEncoderContext.add("sourceExtensionJsonProto3", pVar.f());
            objectEncoderContext.add("timezoneOffsetSeconds", pVar.g());
            objectEncoderContext.add("networkConnectionInfo", pVar.d());
        }
    }

    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class e implements ObjectEncoder<q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f12749a = new e();

        private e() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(q qVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("requestTimeMs", qVar.g());
            objectEncoderContext.add("requestUptimeMs", qVar.h());
            objectEncoderContext.add("clientInfo", qVar.b());
            objectEncoderContext.add("logSource", qVar.d());
            objectEncoderContext.add("logSourceName", qVar.e());
            objectEncoderContext.add("logEvent", qVar.c());
            objectEncoderContext.add("qosTier", qVar.f());
        }
    }

    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class f implements ObjectEncoder<NetworkConnectionInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f f12750a = new f();

        private f() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("networkType", networkConnectionInfo.c());
            objectEncoderContext.add("mobileSubtype", networkConnectionInfo.b());
        }
    }

    private b() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(o.class, C0102b.f12746a);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.e.class, C0102b.f12746a);
        encoderConfig.registerEncoder(q.class, e.f12749a);
        encoderConfig.registerEncoder(k.class, e.f12749a);
        encoderConfig.registerEncoder(ClientInfo.class, c.f12747a);
        encoderConfig.registerEncoder(g.class, c.f12747a);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.a.class, a.f12745a);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.d.class, a.f12745a);
        encoderConfig.registerEncoder(p.class, d.f12748a);
        encoderConfig.registerEncoder(i.class, d.f12748a);
        encoderConfig.registerEncoder(NetworkConnectionInfo.class, f.f12750a);
        encoderConfig.registerEncoder(n.class, f.f12750a);
    }
}
