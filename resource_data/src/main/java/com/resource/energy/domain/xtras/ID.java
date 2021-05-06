package com.resource.energy.domain.xtras;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/**
 * @Author: Adewale Ijalana
 * @Email: adewaleijalana@gmail.com, adewale.ijalana@xpresspayments.com
 * @Created: Jun 9, 2019 1:21:32 PM
 */
public enum ID {

    INSTANCE;

    private static final Random RANDOM1;
    private static final Random RANDOM2;
    private static final Random RANDOM3;
    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final long globalProcessID;
    static Logger LOGGER = LoggerFactory.getLogger(ID.class);

    static {
        long time = System.currentTimeMillis();
        long nanoTime = System.nanoTime();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long addressHashCode;
        try {
            InetAddress inetAddress;
            inetAddress = InetAddress.getLocalHost();
            addressHashCode = inetAddress.getHostName().hashCode()
                    ^ inetAddress.getHostAddress().hashCode();
        } catch (Exception err) {
            LOGGER.warn("Unable to get local host information.", err);
            addressHashCode = ID.class.hashCode();
        }
        globalProcessID = time ^ nanoTime ^ freeMemory ^ addressHashCode;
        RANDOM1 = new Random(time);
        RANDOM2 = new Random(nanoTime);
        RANDOM3 = new Random(addressHashCode ^ freeMemory);
    }

    private ID() {
    }

    public static void main(String[] arg) {
//		System.out.println(ID.generateInt());
//		System.out.println(ID.generateInt());
//		System.out.println(ID.generateLong());
//		System.out.println(ID.generateLong());
        for (int i = 0; i < 20; i++) {
            System.out.println(ID.generateUUIDString());

        }
        System.out.println(ID.generateUUIDString());
        System.out.println(ID.generateBigInteger());
        System.out.println(ID.generateBigInteger());
        System.out.println(random(1, 9));
        System.out.println(random(1, 9));
        System.out.println(random(1, 9));
        System.out.println(random(1, 9));
        System.out.println(getGlobalProcessID());

        for (int i = 0; i < 20; i++) {
            generateRandomCharacters(5);

        }

    }

    public static long generateLong() {
        return Math.abs(RANDOM1.nextLong() ^ RANDOM2.nextLong() ^ RANDOM3.nextLong());
    }

    public static int generateInt() {
        return (int) generateLong();
    }

    public static String generateUUIDString() {
        UUID uuid = UUID.randomUUID();
//		UUID uuid = getTimeUUID();
        String randomUUIDString = uuid.toString().replaceAll("-", "").toUpperCase();

        return randomUUIDString;

    }

    public static BigInteger generateBigInteger() {
        return BigInteger.valueOf(generateLong());
    }

    public static byte[] getMD5Bytes(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            return digest.digest(content.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        } catch (java.io.UnsupportedEncodingException uee) {
            throw new IllegalStateException(uee);
        }
    }

    public static String getHexString(byte[] bytes) {
        // This method cannot change even if it's wrong.
        BigInteger bigInteger = BigInteger.ZERO;
        int shift = 0;
        for (int i = bytes.length; --i >= 0; ) {
            BigInteger contrib = BigInteger.valueOf(bytes[i] & 0xFF);
            contrib = contrib.shiftLeft(shift);
            bigInteger = bigInteger.add(contrib);
            shift += 8;
        }
        return bigInteger.toString(16).toUpperCase();
    }

    /**
     * Gets a process ID that is nearly guaranteed to be globally unique.
     */
    public static long getGlobalProcessID() {
        return globalProcessID;
    }

    public static int random(int min, int max) {
        if (max <= min) {
            return min;
        }
        return Math.abs(RANDOM1.nextInt()) % (max - min) + min;
    }

    static void generateUserUniqueCode() {

        String ss = String.valueOf(random(1, 9));
    }

    //http://dev-blog.xoom.com/2013/09/15/a-fast-time-based-uuid-generator/
    private static UUID getTimeUUID() {
        return UUID.fromString(new com.eaio.uuid.UUID().toString());
    }

    public static final String generateRandomCode(int length){

        final String abc = "123456789";
        return generateRandomCharacters(length, abc);
    }


    public static final String generateRandomCharacters(int num, String characterSpace){

        Random r = new Random();
        String generatedString = "";
        for (int i = 0; i < num; i++) {
//			char letter = (abc).charAt(r.nextInt(62));
//			char letter = (abc).charAt(r.nextInt(34));
            char letter = (characterSpace).charAt(RANDOM2.nextInt(characterSpace.length()));
            generatedString += letter;
//            System.out.print("Random Letter " + letter);
        }
        LOGGER.debug("Random generatedString:- {}", generatedString);
        return generatedString;
    }

    public static final String generateRandomCharacters(int num) {

        final String abc = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";

        return generateRandomCharacters(num, abc);
    }

    public int generateRandomNumber(int upperLimit, int lowerLimit) {

        Random rn = new Random();
        return generateRandomInteger(lowerLimit, upperLimit, rn);

    }


    /**
     * generates a random integer within a specified range
     *
     * @param aStart
     * @param aEnd
     * @param aRandom
     * @return
     */

    public int generateRandomInteger(int aStart, int aEnd, Random aRandom) {
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        //get the range, casting to long to avoid overflow problems
        long range = (long) aEnd - (long) aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long) (range * aRandom.nextDouble());
        int randomNumber = (int) (fraction + aStart);
        return randomNumber;
    }


    public final String generateRandomCharactersForPasswd(int num) {

        final String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789" +
                "!@#$%^&*()[]-+}{:?<>~";

        Random r = new Random();
        String generatedString = "";
        for (int i = 0; i < num; i++) {
            char letter = (abc).charAt(r.nextInt(83));
            generatedString += letter;
        }
        LOGGER.debug("generateRandomCharactersForPasswd:- {}", generatedString);
        return generatedString;
    }

    public String generateCheckSumWithSha1(String toHash) throws RuntimeException {
        try {
            return String.format("%032x", // produces lower case 32 char wide hexa left-padded with 0
                    new BigInteger(1, // handles large POSITIVE numbers
                            MessageDigest.getInstance("SHA1").digest(toHash.getBytes())));
        } catch (NoSuchAlgorithmException e) {
            // do whatever seems relevant
        }
        return null;
    }

    public String generateCheckSumWithMD5(String toHash) throws RuntimeException {
        try {
            return String.format("%032x", // produces lower case 32 char wide hexa left-padded with 0
                    new BigInteger(1, // handles large POSITIVE numbers
                            MessageDigest.getInstance("MD5").digest(toHash.getBytes())));
        } catch (NoSuchAlgorithmException e) {
            // do whatever seems relevant
        }
        return null;
    }

}

