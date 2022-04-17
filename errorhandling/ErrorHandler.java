package ledgerbanking.errorhandling;

public class ErrorHandler {
    public static void throwError(String errorMsg) throws Exception {
        throw new Exception(errorMsg);
    }
}
