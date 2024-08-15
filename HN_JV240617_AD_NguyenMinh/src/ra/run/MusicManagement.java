package ra.run;

import ra.model.Singer;
import ra.model.Song;
import ra.controller.SingerController;
import ra.controller.SongController;
import ra.controller.SearchController;

import java.util.Scanner;

public class MusicManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("***************************** MUSIC-MANAGEMENT ***********************************");
            System.out.println("*                        1.Quản lý ca sỹ                                         *");
            System.out.println("*                        2.Quản lý bài hát                                       *");
            System.out.println("*                        3.Tìm kiếm bài hát                                      *");
            System.out.println("*                        4.Thoát                                                 *");
            System.out.println("*                       Select your collection                                   *");
            System.out.println("**********************************************************************************");
            choice = inputChoice(scanner);

            switch (choice){
                case 1:
                    SingerController.singerManagement(scanner);
                    break;
                case 2:
                    SongController.songManagement(scanner);
                    break;
                case 3:
                    SearchController.searchManagement(scanner);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Bạn hãy nhập lại các số từ 1 đến 4, vui lòng nhập lại");

            }
        }while (true);


    }

    public static int inputChoice(Scanner scanner) {
        System.out.println("Nhập vào lựa chọn của bạn: ");
        do {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                return choice;
            }catch (Exception e){
                System.err.println("Choice phải nhập là số");
            }
        }while (true);
    }
}
