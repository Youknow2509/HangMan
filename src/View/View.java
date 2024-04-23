package View;

public class View {
    // Hien thi tu dang an
    public static void showWord(String word, int max_Error) {
        System.out.println(word);
        System.out.println("So lan sai con lai: " + max_Error);
    }
    // Hien thi yeu nhap
    public static void nhap() {
        System.out.println("Nhap: ");
    }
    // Thong bao nhap sai
    public  static void thongbaonnhapsai() {
        System.out.println("Ki tu ban nhap khong co");
    }
    // Thong bao thua
    public  static void win() {
        System.out.println("ban da chien thang");
    }
    // THong bao thang
    public  static void lose() {
        System.out.println("Ban da thua cuoc");
    }
    // In ket qua
    public static void result(String word) {
        System.out.println("Tu can tim la: " + word);
    }
}

