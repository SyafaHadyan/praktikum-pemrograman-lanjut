public class Rational {
    private int pembilang, penyebut;

    public Rational() {
        pembilang = 0;
        penyebut = 0;
    }

    public Rational(int pbl, int pyb) {
        pembilang = pbl;
        penyebut = pyb;
    }

    // mengecek suatu bilangan adalah rasional atau bukan
    public boolean isRational() {
        return (penyebut != 0);
    }

    // menyederhanakan bilangan rasional
    public void Sederhana() {
        int temp, A, B;
        if (penyebut == 0) {
            return;
        }
        A = (pembilang < penyebut) ? penyebut : pembilang;
        B = (pembilang < penyebut) ? pembilang : penyebut;

        for (; B != 0;) {
            temp = A % B;
            A = B;
            B = temp;
        }

        pembilang /= A;
        penyebut /= A;
    }

    public double Cast() {
        return (penyebut == 0.0) ? 0.0 : (double) pembilang / (double) penyebut;
    }

    // oprator >
    public boolean moreThan(Rational A) {
        return (pembilang * A.penyebut > penyebut * A.pembilang);
    }

    // operator <
    public boolean lessThan(Rational A) {
        return (pembilang * A.penyebut < penyebut * A.pembilang);
    }

    // operator Unary- ---> A = -A
    public void negasi() {
        pembilang = -pembilang;
    }

    // operator unary += \
    public void unaryPlus(Rational A) {
        pembilang = pembilang * A.penyebut + penyebut *
                A.pembilang;
        penyebut *= A.penyebut;
    }

    // operator <=
    public boolean leq(Rational A) {
        return (pembilang * A.penyebut <= penyebut * A.pembilang);
    }

    // operator >=
    public boolean geq(Rational A) {
        return (pembilang * A.penyebut >= penyebut * A.pembilang);
    }

    // operator -
    public void minus(Rational A) {
        pembilang *= A.penyebut;
        A.pembilang *= penyebut;
        penyebut *= A.penyebut;

        pembilang -= A.pembilang;
    }

    // operator *
    public void multiply(Rational A) {
        pembilang *= A.pembilang;
        penyebut *= A.penyebut;
    }

    // operator /
    public void divide(Rational A) {
        pembilang *= A.penyebut;
        penyebut *= A.pembilang;
    }

    public void cetak() {
        System.out.println(pembilang + "/" + penyebut);
    }
}
