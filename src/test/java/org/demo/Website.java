package org.demo;

import java.math.BigInteger;
import java.util.Base64;
public class Website {
    // Only using private key (decrypting)
    private BigInteger N;
    private BigInteger d;
    public Website(String d, String N) {
        this.d = new BigInteger(d);
        this.N = new BigInteger(N);
    }
    private byte[] decrypt( byte[] encoded){
        RSA rsa = new RSA( BigInteger.ZERO, d, N);
        byte[] decrypted = rsa.decrypt(encoded);
        return decrypted;
    }
    public static void main(String[] args) {
        // Only using private key (decrypting)
        Website website = new Website(
                "84796609706227995577975272354527312555767838351561459730043144108857990669114967101899503169933122002605896020376160087830104208631066754648124649924261004132263870569424001632916516641707959002537185682720821724317842486872670778601828161064292551177778803122282138404656678905408387768638347157930850458917",
                "140784270116893248065425766082990775526425661024991057414009523205847864720756458579194977677975268109437940543755570381624387101436028329259796870845934119982864563351302604191432109540025391495532443603263316765781891659719569779017603177460388583023810447338257851340753946100707337787102698052885141531747"
        );

//        PZl0LEAtdMS7aXOPhEOn7W/55rkobCeorHoz4a81jzDAkjfnh2VpYoDSpBXtbogErlxc6stialK8YPukxCNb8yuWJq0HPYNdeZ1u6PC2HY88KdcNJRb5ss7b8wb/QMXPPjf26Ea6NVU/S6r4b3LgWVffyggSiz/DddonEfnZTWc=
        String base64Encoded =
                "PZl0LEAtdMS7aXOPhEOn7W/55rkobCeorHoz4a81jzDAkjfnh2VpYoDSpBXtbogErlxc6stialK8YPukxCNb8yuWJq0HPYNdeZ1u6PC2HY88KdcNJRb5ss7b8wb/QMXPPjf26Ea6NVU/S6r4b3LgWVffyggSiz/DddonEfnZTWc="
                ;
        // Add code to base64decrypt base64Encoded
        // Add code to decrypt encrypted message

        byte[] encrypted = Base64.getDecoder().decode(base64Encoded);
        byte[] decrypted = website.decrypt(encrypted);
        System.out.println(new String(decrypted));
    }



}

