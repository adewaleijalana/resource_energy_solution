package com.resource.energy.domain.xtras;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author: Adewale Ijalana
 * @Email: adewaleijalana@gmail.com
 */

public enum AppUtil {


    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppUtil.class);

    AppUtil() {

    }

    static byte[] concatenateByteArrays(List<byte[]> blocks) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        for (byte[] b : blocks) {
            os.write(b, 0, b.length);
        }
        return os.toByteArray();
    }

    public <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    //    public final String capitalize(String input) {
//        String output;// = Character.toUpperCase(input.charAt(0)) + input.substring(1);
//        output = StringUtils.capitalize(input);
//        return output;
//    }
    public final boolean stringIsNullOrEmpty(String arg) {
        if ((arg == null)) return true;
        else
            return ("".equals(arg)) || (arg.trim().length() == 0);
    }



    //Wed Jan 20 09:11:12 AM WAT 2016
    public String humanReadableDate(Date date) {
        DateFormat formatter = new SimpleDateFormat
                ("EEE MMM dd hh:mm:ss a zzz yyyy");
        String formattedDate = formatter.format(date);
        return formattedDate;
    }





    /*public final String generateUUIDString() {
//        UUID uuid = UUID.randomUUID();
        UUID uuid = getTimeUUID();
        String randomUUIDString = uuid.toString().replaceAll("-", "").toUpperCase();
        return randomUUIDString;

    }*/



    /*public final String generateUUIDTransactionNumber() {
        //generate random UUIDs
        return getTimeUUID().toString();
    }*/


//    public static void main(String[] args) {
//        for (int i = 0; i < 50; i++) {
//            System.out.println(AppUtils.INSTANCE.generateUUIDString());
//        }
//    }

    /*public static void mainx(String args[]) {

        System.out.println("a- " + INSTANCE.generateRandomCharactersForPasswd(40));
        System.out.println(INSTANCE.generateRandomCharactersForPasswd(40));

        String datafile = "27";

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(datafile.getBytes(), 0, datafile.length());


        byte[] mdbytes = md.digest();

        //convert the byte to hex format
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < mdbytes.length; i++) {
            sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Digest(in hex format):: " + sb.toString());

        String signature = new BigInteger(1, md.digest()).toString(16);
        System.out.println("Signature: " + signature);

        System.out.println("Signature: " + INSTANCE.generateCheckSum(datafile));

    }*/









    /*static void mainx1(String[] args) {
        System.out.println("in -- ");

        byte[] myvar3 = new byte[]{};

        byte[] myvar0 = "The".getBytes();
        byte[] myvar1 = " Quick".getBytes();
        byte[] myvar2 = " Brown".getBytes();
        myvar3 = " fox".getBytes();

        List byteArrayList = new ArrayList<>();
        byteArrayList.add(myvar0);
        byteArrayList.add(myvar1);
        byteArrayList.add(myvar2);
        byteArrayList.add(myvar3);


        byte[] bytes = concatenateByteArrays(byteArrayList);
        System.out.println(new String(bytes));

    }*/


}
