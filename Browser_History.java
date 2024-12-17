import java.util.Scanner;
import java.util.Stack;

public class Browser_History {
    // Tulis kode disini
    private Stack<String> history;
    private Stack<String> forward;

    public Browser_History() {
        this.history = new Stack<>();
        this.forward = new Stack<>();
    }

    public void view() {
        System.out.println("History Browser:");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println((history.size() - i) + ". " + history.get(i));
        }
    }

    public void browse(String website) {
        history.push(website);
        forward.clear();
        System.out.println("Website " + website + " telah ditambahkan ke history.");
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk kembali.");
        } else {
            String website = history.pop();
            forward.push(website);
            System.out.println("Kembali ke website sebelumnya.");
        }
    }

    public void forward() {
        if (forward.isEmpty()) {
            System.out.println("Tidak ada history untuk maju.");
        } else {
            String website = forward.pop();
            history.push(website);
            System.out.println("Maju ke website berikutnya.");
        }
    }

    public static void main(String[] args) {
        Browser_History browser = new Browser_History();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pilih opsi:");
            System.out.println("1. View History");
            System.out.println("2. Browse Website");
            System.out.println("3. Back");
            System.out.println("4. Forward");
            System.out.println("5. Keluar");

            int opsi = scanner.nextInt();
            scanner.nextLine(); // untuk menghapus newline

            switch (opsi) {
                case 1:
                    browser.view();
                    break;
                case 2:
                    System.out.print("Masukkan website: ");
                    String website = scanner.nextLine();
                    browser.browse(website);
                    break;
                case 3:
                    browser.back();
                    break;
                case 4:
                    browser.forward();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    scanner.close(); // Menutup scanner
                    return;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}