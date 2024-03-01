// Note that this code does not run, it is simply to document the SEI Java Rule with the non-compliant
// and compliant code as shown below

// Non-compliant solution
public static int getInteger(DataInputStream is) throws IOException {
    return is.readInt();
}


// Compliant Solution
public static long getInteger(DataInputStream is) throws IOException {
    return is.readInt() & 0xFFFFFFFFL; // Mask with 32 one-bits
}