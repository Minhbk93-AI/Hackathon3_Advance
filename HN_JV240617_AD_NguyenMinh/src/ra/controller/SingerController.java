package ra.controller;
import ra.service.SingerService;
import java.util.Scanner;
import ra.run.MusicManagement;


public class SingerController {
    public static void singerManagement(Scanner scanner){
        boolean flag=true;
        int choice;

        while (flag) {
            System.out.println("************************************SINGER-MANAGEMENT********************************");
            System.out.println("*            1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới      *");
            System.out.println("*            2.Hiển thị danh sách tất cả ca sỹ đã lưu trữ                           *");
            System.out.println("*            3.Thay đổi thông tin ca sỹ theo mã Id                                  *");
            System.out.println("*            4.Xóa ca sỹ theo mã Id                                                 *");
            System.out.println("*            5.Thoát                                                                *");
            System.out.println("*************************************************************************************");
            choice = MusicManagement.inputChoice(scanner);
            switch (choice) {
                case 1:
                    SingerService.addSinger(scanner);
                    break;
                case 2:
                    SingerService.showListSinger();
                    break;
                case 3:
                    SingerService.updateSinger(scanner);
                    break;
                case 4:
                    SingerService.deleteSinger(scanner);
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    System.out.println("Bạn hãy lựa chọn các case từ 1-5, vui lòng nhập lại");
            }
        }
    }
}
