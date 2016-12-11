package ipaddress;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ramil on 10.12.2016.
 */

public class IpTest {

    @Test
    public void ipaddres() {
        List<String> actual0 = Main.insideIpAddresses("192.168.0.1", "192.168.0.5");
        List<String> expected0 = Arrays.asList("192.168.0.1", "192.168.0.2", "192.168.0.3", "192.168.0.4");
        assertEquals(expected0, actual0);

        List<String> actual1 = Main.insideIpAddresses("192.168.254.253", "192.168.255.2");
        List<String> expected1 = Arrays.asList("192.168.254.253", "192.168.254.254", "192.168.254.255", "192.168.255.0", "192.168.255.1");
        assertEquals(expected1, actual1);

        List<String> actual2 = Main.insideIpAddresses("192.168.0.1", "192.168.0.1");
        List<String> expected2 = Collections.EMPTY_LIST;
        assertEquals(expected2, actual2);

        List<String> actual3 = Main.insideIpAddresses("192.168.0.1", "192.168.0.0");
        assertEquals(null,actual3);
    }
}
