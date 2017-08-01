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

    @Test
    public void check_decoding_to_95713(){
        // given
        String barcode = "| |:|:: :|:|: |:::| :::|| ::||: :|:|: |";
        // when
        String zipcode = Postnet.decoding(barcode);
        // then
        assertTrue(zipcode.equals("95713"));
    }

    @Test
    public void check_encoding_with_55555_1237(){
        // given
        String zipcode = "55555-1237";
        // when
        String barcode = Postnet.encoding(zipcode);
        // then
        assertTrue(barcode.equals("| :|:|: :|:|: :|:|: :|:|: :|:|: :::|| ::|:| ::||: |:::| ::|:| |"));
    }

    @Test
    public void check_decoding_to_55555_1237(){
        // given
        String barcode = "| :|:|: :|:|: :|:|: :|:|: :|:|: :::|| ::|:| ::||: |:::| ::|:| |";
        // when
        String zipcode = Postnet.decoding(barcode);
        // then
        assertTrue(zipcode.equals("55555-1237"));
    }
}
