package ra.service;

import java.util.Date;
import ra.model.Singer;
import ra.model.Song;
import java.util.Scanner;

public class SearchService {
    public static void searchSong(Scanner scanner) {
        if (SongService.currentIndexSong == 0) {
            System.err.println("Danh sách bài hát đang trống, hãy thêm bài hát");
            return;
        }
        if (SingerService.currentIndexSinger == 0) {
            System.err.println("Danh sách ca sỹ đang trống, hãy thêm ca sỹ");
            return;
        }
        System.out.println("Nhập vào tên ca sỹ hoặc thể loại nhạc");
        String search = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < SongService.currentIndexSong; i++) {
            if (SongService.arrSongs[i].getSinger().getSingerName().contains(search) || SongService.arrSongs[i].getSinger().getGenre().contains(search)) {
                SongService.arrSongs[i].displayData();
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Không tìm kiếm được bài hát nao theo tên ca sỹ hoặc thể loại nhạc");
        } else {
            System.out.println("Có " + count + " bài hát tìm kiếm được");
        }

    }

    public static void searchSinger(Scanner scanner) {
        if (SingerService.currentIndexSinger == 0) {
            System.err.println("Danh sách ca sỹ đang trống, vui lòng thêm ca sỹ");
            return;
        }
        System.out.println("Nhập vào tên ca sỹ hoặc thể loại nhạc");
        String search = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < SingerService.currentIndexSinger; i++) {
            if (SingerService.arrSingers[i].getSingerName().contains(search) || SingerService.arrSingers[i].getGenre().contains(search)) {
                SingerService.arrSingers[i].displayData();
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Không tìm kiếm được tên ca sỹ nào");
        } else {
            System.out.println("Có " + count + " ca sỹ tìm kiếm được");
        }

    }

    public static void sortSingerByName(Scanner scanner) {
        for (int i = 0; i < SongService.currentIndexSong - 1; i++) {
            for (int j = 0; j < SongService.currentIndexSong - i - 1; j++) {
                if (SongService.arrSongs[j].getSongName() != null && SongService.arrSongs[j+1].getSongName() != null) {
                    if (SongService.arrSongs[j].getSongName().compareTo(SongService.arrSongs[j + 1].getSongName()) > 0) {
                        Song temp = SongService.arrSongs[j];
                        SongService.arrSongs[j] = SongService.arrSongs[j + 1];
                        SongService.arrSongs[j + 1] = temp;
                    }
                }
            }
        }
        System.out.println("Sắp xếp hoàn thành");
        for (int i = 0; i < SongService.currentIndexSong; i++) {
            SongService.arrSongs[i].displayData();
        }

    }

    public static void displaySongsLatest() {
        if (SongService.currentIndexSong < 10) {
            System.err.println("Danh sách bài hát phải lớn hơn hoặc bằng 10");
            return;
        }
        int count = 0;
        while (count <= 10) {
            for (int i = SongService.currentIndexSong - 1; i >= 0; i--) {
                System.out.println("Song: " + (count + 1));
                SongService.arrSongs[i].displayData();
                count++;
            }
        }
        System.out.println("___________________________________");
        System.out.println("Hiển thị 10 bài hát gần nhất");
        for (int i = 0; i < SongService.currentIndexSong; i++) {
            SongService.arrSongs[i].displayData();
        }
    }
}




