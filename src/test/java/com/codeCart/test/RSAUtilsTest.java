package com.codeCart.test;
import com.codeCart.RSAUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
public class RSAUtilsTest {
    private static  String PUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbi0Q/v+I19Ia2h9RWxyS1yZWYRuVTmeYdEJ9Nj71LPKQGnprlUQr5sNvItcwQsxJef3aTD6tZ3PmmZJyCFyOkYFRMOfur+au1x/XI/DlUaSADT4MeZGqfXWoHSbIo4PvQuQY0AKiUWgMps/2N/xmyvMk61WxHYmyIUpY7CQlx+QIDAQAB" ;
    private static  String PRIVATEKEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJuLRD+/4jX0hraH1FbHJLXJlZhG5VOZ5h0Qn02PvUs8pAaemuVRCvmw28i1zBCzEl5/dpMPq1nc+aZknIIXI6RgVEw5+6v5q7XH9cj8OVRpIANPgx5kap9dagdJsijg+9C5BjQAqJRaAymz/Y3/GbK8yTrVbEdibIhSljsJCXH5AgMBAAECgYAMPcyndVmMER+QOmZqu43wqwz77z0/9B4l7j34I7Z5HZLaXOpbeKJaSyH9zNj8Y3hJoAYPLHq6Cs5KQYoG7v1EZGyIu+7Jx5p/UkpOWZWlIL5WFfDAmuE7Y5WyzmN8OSNKi4emdtGPB0vCeu7MfaR/3unjXAUf6kW1YUMGlZG21QJBANfLrSotGAe4nRdXbFyrHpzC0P5KZuxvGLg75xTK5hiElOM0Wr6FsSasiRKP3vlU7SbJJZliiwC+VLQDggclrucCQQC4hedLjL0Fsy6b1Kiv6jwxET7uKTa/VXp5aLGg8PBXL7Uokaw6NCXQ5VCyM1981w0bdQQYfH3sPwy1S4u96BwfAkAaXkDijnAJQX2whHYxPJeZABUZfW3mJg0XNfqeh8xl4o1u1c7gyOVEnICDTCEqxj3UJ2/4thnWFWu0M1mIFgqxAkBKFqm58fZrdXh/ZTGeAITOhsgnxDCRPncAjILVxigaObOZaHQooouUhp6SDoKGk6pVnfRZCJNe6inmGUEwrSOtAkB4ohM8Up7VTJEh9MJfZQjzw3VnAliVHvUVR/sk5LNvVDwYgVNdykLcCse8JicR1tdLOgJY0SKpfJ+kLC1uxrH7" ;
    @Test
    public void confirm() throws Exception {
        System.out.println("PUBLICKEY:"+PUBLICKEY+'\n'+"PRIVATEKEY:"+PRIVATEKEY);
        String data = "zhangsan";
        String en = RSAUtils.encryptedDataOnJava(data, PUBLICKEY);
        System.out.println(en);
        String de = RSAUtils.decryptDataOnJava(en, PRIVATEKEY);
        System.out.println(de);

    }
}
