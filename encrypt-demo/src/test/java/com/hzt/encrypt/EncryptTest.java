package com.hzt.encrypt;

import com.hzt.encrypt.common.RSAKey;
import com.hzt.encrypt.util.AES;
import com.hzt.encrypt.util.RSA;
import org.junit.jupiter.api.Test;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName RESTest.java
 * @Description TODO
 */
public class EncryptTest {
    @Test
    public void AEStest() throws Exception {
        System.out.println(RSA.decrypt("WGOvmeb0Cyaqt+y3vhVTLHLxRkFVV54yMIOhA73O3KNi1ZF1sjFKrOb60KV/eejxJIhs0LCtJG1vm0C9RNhSA7Lo8srJMKhCTDvShIXwOZR9t6/thTqOTQkATp7eCtZv6sL6GAm9CsI4BS7GEOqQyCfjLtTUZYdc8KYd3AQDsMI=",
                RSAKey.serverPrivateKey));

    }
    @Test
    public void AEStest2() throws Exception {
        String aesKey = RSA.decrypt("nSzjsGldt/3AfmUcPJ05oxDpj3Z/U898AqtcSpT3Phct2e1XMsOguakq1elia+ZR+4p3QALrzkFMUhrv+J1YLkdrSnm2TWoANT7qohlMYQJjc8mfZbGqhD2ih11bGZlwtNVX99ZLdlwtEU70SbUmnzZsgy6aOYSlBsrZcuWx9T8=",
                RSAKey.clientPrivateKey);
        System.out.println(AES.decryptFromBase64("k1kSB+Yuyw4mwgCGx/Kgzg==", aesKey));

    }
    @Test
    public void AEStest3() throws Exception {
        //String aesKey = "1234567891234567";//SecureRandomUtil.getRandom(16);
        //System.out.println(aesKey);
        //String encryptToBase64 = AES.encryptToBase64("1234567891234567", aesKey);
        //System.out.println(encryptToBase64);
        System.out.println(AES.decryptFromBase64("AH8ooAF6ie+HApdqwJsAShagYQOrjFpIPvDx6enowjoAMyPtThzH1TRvIVSh8Emmb4KgobMDyXUHUIpTX4AtS20gFXjrgNB50mmlwwrXhNG5NFcKjmjv1U/S20QjNUT6WQX+D7IcoL3jci7FHvdWG1A73Y0POTvIndR0qoFng82O6wYAYZLNhl1A/kNlCU8esdBuNhvitSzpLHI5Lm3kJJ0EYBjLAWBImJoayTnnR5fljt+mlMw2w49354Kaqs8hqgMpFRKj3qf+D9s6nsSFIx1YOhzvZy/P0EKknZ+boivklAcyHY0DvJ6lmOM8SMahtnfZHob4dH7Nkq5NqvEIdrXR1QetjXa7d3gCxpmzCkKEvC238VGMmGRkO/qJJgiunjXHkoSnqPchPnd+YUMdGXUkqZ7hUWORdMTSIftt3aZnEJmnR+jLg/NVStX1LW3GMe7CxGd6ptQQDzNEXulT6bEapbXMKhJabLse/RZZJ+yDBkanjPmqK8HkA2x7kdNBkJv7kP1f7gpmL7SIl1AsxZryEgNDPGE24FeuJmary5ON80+hfkpvhKBwa3oEpB/SqqrQkw7mbvU+Wrj8nYQGBI6eqvGrOBDW4QkeOuW+CG3onFCiqHkIfPuGK91iubnODnTdlDLrxfeaUnroAHpZcN/TIrW9oqShZbuwWcFuOJ4w4xem9u+ggRhRxhflzP40tbu1mb8Yo0nGN12TYWt2zXy8fBgbOmCYADv6BUllEM6F+rwFBgPDCEf79liVr8bHBkIp1Yw//Mz6sJSVI+JuixzcQdLe3I6pExG4hU1cTweF7R2p1d7LIoJe+xY9Izcv",
                "5g39GU48QRop5eg1"));

    }
}
