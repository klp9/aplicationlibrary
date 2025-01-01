public class Soal {
    private String soal;
    private String[] pilihanJawaban;
    private String jawabanBenar;

    // Constructor
    public Soal(String soal, String[] pilihanJawaban, String jawabanBenar) {
        this.soal = soal;
        this.pilihanJawaban = pilihanJawaban;
        this.jawabanBenar = jawabanBenar;
    }

    // Getter methods
    public String getSoal() {
        return soal;
    }

    public String[] getPilihanJawaban() {
        return pilihanJawaban;
    }

    public String getJawabanBenar() {
        return jawabanBenar;
    }
}
