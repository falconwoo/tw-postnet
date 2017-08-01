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
            barcodeBuffer.append(BarcodeEnum.getBarcodeByZipcode(zipCodeItem)).append(" ");
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
        String[] barCodeItemsWithoutFrame = new String[barcodeItems.length - 3];
        System.arraycopy(barcodeItems, 1, barCodeItemsWithoutFrame, 0, barcodeItems.length - 3);

        List<String> zipcodeItemList = new ArrayList<String>();

        for(String barCodeItem : barCodeItemsWithoutFrame){
            zipcodeItemList.add(String.valueOf(BarcodeEnum.getZipcodeByBarcode(barCodeItem)));
        }

        if(zipcodeItemList.size()>5){
            zipcodeItemList.add(5,"-");
        }

        StringBuffer zipcodeBuffer = new StringBuffer();
        for(String zipcodeItem : zipcodeItemList){
            zipcodeBuffer.append(zipcodeItem);
        }

        return zipcodeBuffer.toString();
    }

    private static String[] splitBarcode(String barcode) {
        return barcode.split(" ");
    }
}
