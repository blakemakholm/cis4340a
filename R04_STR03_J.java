// Note that this code does not run, it is simply to document the SEI Java Rule with the non-compliant
// and compliant code as shown below

// Non-compliant solution
BigInteger x = new BigInteger("530500452766");
    byte[] byteArray = x.toByteArray();
    String s = new String(byteArray);
    byteArray = s.getBytes();
    x = new BigInteger(byteArray);

// Compliant Solution
BigInteger x = new BigInteger("530500452766");
String s = x.toString();  // Valid character data
byte[] byteArray = s.getBytes();
String ns = new String(byteArray);
x = new BigInteger(ns);