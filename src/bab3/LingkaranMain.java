public class LingkaranMain {
    public static void main(String[] args) {
        Lingkaran firstCircle = new Lingkaran();
        firstCircle.setAlas(3);
        firstCircle.setTinggi(10);
        firstCircle.displayMessage();

        Lingkaran secondCircle = new Lingkaran(4, 10);
        secondCircle.displayMessage();

        Lingkaran thirdCircle = new Lingkaran("2", "5");
        thirdCircle.displayMessage();
    }
}
