import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PostnetTest {

    @Test
    public void check_encoding_given_95713(){
        // given
        String zipcode = "95713";
        // when
        String barcode = Postnet.encoding(zipcode);
        // then
        assertTrue(barcode.equals("| |:|:: :|:|: |:::| :::|| ::||: :|:|: |"));
    }
}
