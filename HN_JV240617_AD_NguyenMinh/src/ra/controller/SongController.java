package ra.controller;

import java.util.Scanner;
import ra.service.SongService;
import ra.run.MusicManagement;

public class SongController {
    public static void songManagement(Scanner scanner) {
        boolean flag= true;
        int choice;
        while (flag) {
            System.out.println("********************************** SONG-MANAGEMENT ***********************************");
            System.out.println("*              1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới   *");
            System.out.println("*              2.Hiển thị danh sách tất cả bài hát đã lưu trữ                        *");
            System.out.println("*              3.Thay đổi thông tin bài hát theo mã Id                               *");
            System.out.println("*              4.Xoá bài hát theo mã Id                                              *");
            System.out.println("*              5.Thoát                                                               *");
            System.out.println("**************************************************************************************");
            choice= MusicManagement.inputChoice(scanner);
            switch (choice) {
                case 1:
                    SongService.addSong(scanner);
                    break;
                case 2:
                    SongService.showListSong();
                    break;
                case 3:
                    SongService.updateSong(scanner);
                    break;
                case 4:
                    SongService.deleteSong(scanner);
                    break;
                case 5:
                     flag=false;
                     break;
                default:
                    System.out.println("Bạn hãy lựa chọn từ 1-5, vui lòng nhập lại");
            }
        }
    }
}
