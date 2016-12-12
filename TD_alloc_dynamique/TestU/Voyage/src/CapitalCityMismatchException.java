
public class CapitalCityMismatchException extends Exception {

    CapitalCityMismatchException() {
        super("Cette ville n'est pas une capitale européenne");
    }

    CapitalCityMismatchException(String s) {
        super(s);
    }
}
