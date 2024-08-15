package ra.controller;

import java.util.Scanner;

import ra.run.MusicManagement;
import ra.service.SearchService;

public class SearchController {
    public static void searchManagement(Scanner scanner){

        boolean flag=true;
        int choice;
        while (flag) {

            System.out.println("******************************** SEARCH-MANAGEMENT ****************************");
            System.out.println("*                   1.Tìm kiêm bài hát theo tên ca sỹ hoặc thể loại           *");
            System.out.println("*                   2.Tìm kiêm ca sỹ theo tên hoặc thể loại                   *");
            System.out.println("*                   3.Hiển thị danh sách bài hát theo thứ tự tăng dần         *");
            System.out.println("*                   4.Hiển thị 10 bài hát được đăng mới nhất                  *");
            System.out.println("*                   5.Thoát                                                   *");
            System.out.println("*******************************************************************************");
            choice= MusicManagement.inputChoice(scanner);
            switch (choice) {
                case 1:
                    SearchService.searchSong(scanner);
                    break;
                case 2:
                    SearchService.searchSinger(scanner);
                    break;
                case 3:
                    SearchService.sortSingerByName(scanner);
                    break;
                case 4:
                    SearchService.displaySongsLatest();
                    break;
                case 5:
                    flag=false;
                    break;

                default:
                    System.out.println("Lựa chọn của bạn không đúng, hãy lựa chọn từ 1-5");
            }
        }
    }
}
