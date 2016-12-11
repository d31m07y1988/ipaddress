package ipaddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

/*        List<String> inputIP = new ArrayList<>();
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (inputIP.size() != 2) {
                String ip = consoleReader.readLine();
                if (validate(ip)) {
                    inputIP.add(ip);
                }
            }
        }
        List<String> ipAddresses = insideIpAddresses(inputIP.get(0), inputIP.get(1));*/

        if(args.length==2 && validate(args[0]) && validate(args[1])) {
            List<String> ipAddresses = insideIpAddresses(args[0], args[1]);
            ipAddresses.forEach(System.out::println);
        }
    }

    public static List<String> insideIpAddresses(String startIp, String endIp) {
        List<String> insideIpAddresses = new ArrayList<>();
        long start = ipToLong(startIp);
        long stop = ipToLong(endIp);
        if (stop < start) return null;
        for (long i = start; i < stop; i++) {
            insideIpAddresses.add(longToIp(i));
        }
        return insideIpAddresses;
    }

    public static long ipToLong(String ipAddress) {

        String[] ipAddressInArray = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);
        }
        return result;
    }

    public static String longToIp(long ip) {
        return ((ip >> 24) & 0xFF) + "."
                + ((ip >> 16) & 0xFF) + "."
                + ((ip >> 8) & 0xFF) + "."
                + (ip & 0xFF);
    }

    public static boolean validate(String ip) {
        Pattern pattern = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
