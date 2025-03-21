import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Manusia firstManusia = new Manusia("Full Name", true, "3570123456", true);
        System.out.println(firstManusia);
        firstManusia.separator();

        Manusia secondManusia = new Manusia("Full Name", false, "3570123456", true);
        System.out.println(secondManusia);
        secondManusia.separator();

        Manusia thirdManusia = new Manusia("Full Name", true, "3570123456", false);
        System.out.println(thirdManusia);
        thirdManusia.separator();

        MahasiswaFILKOM firstMahasiswaFILKOM = new MahasiswaFILKOM("2215792934", 2.9, "Full Student Name", true,
                "35892379823", false);
        System.out.println(firstMahasiswaFILKOM);
        firstMahasiswaFILKOM.separator();

        MahasiswaFILKOM secondMahasiswaFILKOM = new MahasiswaFILKOM("2315793934", 3.2, "Full Student Name", true,
                "35892379823", false);
        System.out.println(secondMahasiswaFILKOM);
        secondMahasiswaFILKOM.separator();

        MahasiswaFILKOM thirdMahasiswaFILKOM = new MahasiswaFILKOM("2415794934", 3.9, "Full Student Name", true,
                "35892379823", false);
        System.out.println(thirdMahasiswaFILKOM);
        thirdMahasiswaFILKOM.separator();

        Pekerja firstPekerja = new Pekerja(3000d, LocalDate.of(2023, 01, 01), 2,
                "Full Name", true, "3571234567",
                true);
        System.out.println(firstPekerja);
        firstPekerja.separator();

        Pekerja secondPekerja = new Pekerja(1000d, LocalDate.of(2023, 01, 01), 4,
                "Full Name", true, "3571234567",
                true);
        System.out.println(secondPekerja);
        secondPekerja.separator();

        Pekerja thirdPekerja = new Pekerja(5000d, LocalDate.of(2005, 01, 01), 10, "Full Name", true, "3571234567",
                true);
        System.out.println(thirdPekerja);
        thirdPekerja.separator();

        Manager firstManager = new Manager("Backend", 1000d, LocalDate.of(2023, 01, 01), 3, "Full Name ", true,
                "357123456", true);
        System.out.println(firstManager);
    }
}
