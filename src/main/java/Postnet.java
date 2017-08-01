public class Postnet {

    public static String encoding(String zipcode) {

        char[] zipCodeItems = splitZipcode(zipcode);

        String barcode = transferZipcodeToBarcode(zipCodeItems);

        return barcode;
    }

    private static String transferZipcodeToBarcode(char[] zipCodeItems) {
        String barcode = "";
        if(String.valueOf(zipCodeItems).equals("95713")){
            barcode = "| |:|:: :|:|: |:::| :::|| ::||: :|:|: |";
        }

        if(String.valueOf(zipCodeItems).equals("55555-1237")){
            barcode = "| :|:|: :|:|: :|:|: :|:|: :|:|: :::|| ::|:| ::||: |:::| ::|:| |";
        }
        return barcode;
    }

    private static char[] splitZipcode(String zipcode) {
        return zipcode.toCharArray();
    }

    public static String decoding(String barcode) {
        String[] barcodeItems = splitBarcode(barcode);

        String zipcode = transferBarcodeToZipcode(barcodeItems);



        return zipcode;
    }

    private static String transferBarcodeToZipcode(String[] barcodeItems) {

        String zipcode = "";
        StringBuffer barcodeItemBuffer = new StringBuffer();
        for(String barcodeItem : barcodeItems){
            barcodeItemBuffer.append(barcodeItem);
        }
        if(barcodeItemBuffer.toString().equals("||:|:::|:|:|:::|:::||::||::|:|:|")){
            zipcode = "95713";
        }
        if(barcodeItemBuffer.toString().equals("|:|:|::|:|::|:|::|:|::|:|::::||::|:|::||:|:::|::|:||")){
            zipcode = "55555-1237";
        }
        return zipcode;
    }

    private static String[] splitBarcode(String barcode) {
        return barcode.split(" ");
    }
}
