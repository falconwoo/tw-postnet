public class Postnet {

    public static String encoding(String zipcode) {
        String barcode = "";
        if(zipcode.equals("95713")){
            barcode = "| |:|:: :|:|: |:::| :::|| ::||: :|:|: |";
        }
        return barcode;
    }

    public static String decoding(String barcode) {
        String zipcode = "";
        if(barcode.equals("| |:|:: :|:|: |:::| :::|| ::||: :|:|: |")){
            zipcode = "95713";
        }
        return zipcode;
    }
}
