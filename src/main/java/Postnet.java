public class Postnet {

    public static String encoding(String zipcode) {
        String barcode = "";
        if(zipcode.equals("95713")){
            barcode = "| |:|:: :|:|: |:::| :::|| ::||: :|:|: |";
        }
        return barcode;
    }
}
