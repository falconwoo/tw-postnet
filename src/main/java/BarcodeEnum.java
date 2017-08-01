public enum BarcodeEnum {
    B1(":::||",1),B2("::|:|",2),B3("::||:",3),B4(":|::|",4),B5(":|:|:",5),
    B6(":||::",6),B7("|:::|",7),B8("|::|:",8),B9("|:|::",9),B0("||:::",0);

    String barcode;
    Integer zipCode;
    BarcodeEnum(String barcode, Integer zipcode){
        this.barcode = barcode;
        this.zipCode = zipcode;
    }

    public static String getBarcodeByZipcode(Integer zipcode){
        switch(zipcode){
            case 1:
                return B1.barcode;
            case 2:
                return B2.barcode;
            case 3:
                return B3.barcode;
            case 4:
                return B4.barcode;
            case 5:
                return B5.barcode;
            case 6:
                return B6.barcode;
            case 7:
                return B7.barcode;
            case 8:
                return B8.barcode;
            case 9:
                return B9.barcode;
            case 0:
                return B0.barcode;
            default:
                return null;
        }
    }

    public static Integer getZipcodeByBarcode(String barcode){
        BarcodeEnum[] barcodeEnums = BarcodeEnum.values();
        for(BarcodeEnum barcodeEnumItem : barcodeEnums){
            if(barcode.equals(barcodeEnumItem.barcode)){
                return barcodeEnumItem.zipCode;
            }
        }
        return null;
    }

}
