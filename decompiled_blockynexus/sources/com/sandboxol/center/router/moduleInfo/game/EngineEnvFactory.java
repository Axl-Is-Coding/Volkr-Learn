package com.sandboxol.center.router.moduleInfo.game;

/* JADX INFO: loaded from: classes3.dex */
public class EngineEnvFactory {

    static class EngineEnvFactoryImpl {
        private static AbstractEngineEnv engineEnv1 = new Engine1Env();
        private static AbstractEngineEnv engineEnv2 = new Engine2Env();
        private static AbstractEngineEnv engineEnv3 = new Engine3Env();

        EngineEnvFactoryImpl() {
        }
    }

    public static AbstractEngineEnv v1() {
        return EngineEnvFactoryImpl.engineEnv1;
    }

    public static AbstractEngineEnv v2() {
        return EngineEnvFactoryImpl.engineEnv2;
    }

    public static AbstractEngineEnv v3() {
        return EngineEnvFactoryImpl.engineEnv3;
    }
}
