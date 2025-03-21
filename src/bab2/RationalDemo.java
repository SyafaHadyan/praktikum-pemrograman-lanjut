public class RationalDemo {
    public static void main(String[] args) {
        Rational R1 = new Rational(1, 2);
        Rational R2 = new Rational(1, 3);

        System.out.println("R1.isRational: " + R1.isRational());
        System.out.println("R2.isRational: " + R1.isRational());
        System.out.println();

        System.out.println("R1 > R2 : " + R1.moreThan(R2));
        System.out.println("R1 < R2 : " + R1.lessThan(R2));
        System.out.println();

        System.out.println("R1 >= R2 : " + R1.geq(R2));
        System.out.println("R1 <= R2 : " + R1.leq(R2));
        System.out.println();

        System.out.print("R1 : ");
        R1.cetak();
        System.out.print("R2 : ");
        R2.cetak();
        System.out.println();

        R1.Sederhana();
        R2.Sederhana();

        System.out.print("R1 : ");
        R1.cetak();
        System.out.print("R2 : ");
        R2.cetak();
        System.out.println();

        System.out.println("Setelah dilakukan Cast ke double menjadi : ");
        System.out.println("R1 : " + R1.Cast());

        System.out.println("R2 : " + R2.Cast());
        System.out.println();

        R1.negasi();
        System.out.print("Unary- dari R1 : ");
        R1.cetak();
        System.out.println();

        R1.unaryPlus(R2);
        System.out.print("Nilai dari 'R1 += R2' : ");
        R1.cetak();
        System.out.println();

        R1.minus(R2);
        System.out.print("Nilai dari R1 - R2 = ");
        R1.cetak();
        System.out.println();

        R1.multiply(R2);
        System.out.print("Nilai dari R1 * R2 = ");
        R1.cetak();
        System.out.println();

        R1.divide(R2);
        System.out.print("Nilai dari R1 / R2 = ");
        R1.cetak();
        System.out.println();
    }
}
