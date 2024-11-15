package r5a08.findmyword;

public interface WordRepository {
    String fetchWordByNumber(int number);
    int highestWordNumber() ;
}
