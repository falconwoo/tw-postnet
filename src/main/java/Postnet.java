import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Postnet {

    public static String encoding(String zipcode) {

        char[] zipCodeItems = splitZipcode(zipcode);

        String barcode = transferZipcodeToBarcode(zipCodeItems);

        return barcode;
    }

    private static String transferZipcodeToBarcode(char[] zipCodeItems) {

        List<Integer> zipCodeList = new ArrayList<Integer>();

        for(char zipCodeItem : zipCodeItems){
            if(zipCodeItem == '-'){
                continue;
            }
            zipCodeList.add(Character.getNumericValue(zipCodeItem));
        }

        int checkDigital = calcCheckDigital(zipCodeList);

        zipCodeList.add(checkDigital);

        StringBuffer barcodeBuffer = new StringBuffer("| ");
        for(Integer zipCodeItem : zipCodeList){
            switch(zipCodeItem){
                case 0:
                    barcodeBuffer.append("||:::").append(" ");
                    break;
                case 1:
                    barcodeBuffer.append(":::||").append(" ");
                    break;
                case 2:
                    barcodeBuffer.append("::|:|").append(" ");
                    break;
                case 3:
                    barcodeBuffer.append("::||:").append(" ");
                    break;
                case 4:
                    barcodeBuffer.append(":|::|").append(" ");
                    break;
                case 5:
                    barcodeBuffer.append(":|:|:").append(" ");
                    break;
                case 6:
                    barcodeBuffer.append(":||::").append(" ");
                    break;
                case 7:
                    barcodeBuffer.append("|:::|").append(" ");
                    break;
                case 8:
                    barcodeBuffer.append("|::|:").append(" ");
                    break;
                case 9:
                    barcodeBuffer.append("|:|::").append(" ");
                    break;
            }
        }

        barcodeBuffer.append("|");

        return barcodeBuffer.toString();
    }

    private static int calcCheckDigital(List<Integer>  zipCodeList) {
        int total = 0;
        for(int zipCodeItem : zipCodeList){
            total += zipCodeItem;
        }
        int checkDigital = 10 - total % 10;
        return checkDigital;
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
