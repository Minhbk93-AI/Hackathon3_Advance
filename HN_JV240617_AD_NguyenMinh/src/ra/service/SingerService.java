package ra.service;

import ra.model.Singer;
import ra.model.Song;
import ra.service.SongService;
import java.util.Scanner;

public class SingerService {
    public static Singer[] arrSingers = new Singer[100];
    public static int currentIndexSinger = 0;

    public static Singer findSingerById(int id) {
        for (int i = 0; i < currentIndexSinger; i++) {
            if (arrSingers[i].getSingerId() == id) {
                return arrSingers[i];
            }
        }
        return null;
    }


    public static void addSinger(Scanner scanner) {
        System.out.println("Hãy nhập số Singer muốn thêm ");
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number<=0){
                System.out.println("Số Singer nhập vào phải lơn hơn 0");
            }else {
                for (int i = 0; i < number; i++) {
                    System.out.println("Nhập singer thứ " + (i + 1));
                    Singer singer = new Singer();
                    singer.inputData(scanner, arrSingers, currentIndexSinger);
                    arrSingers[currentIndexSinger] = singer;
                    currentIndexSinger++;
                }
                System.out.println("Thêm " + number + " Singer đã hoàn thành");
            }
        }catch (Exception e){
            System.err.println("Số nhập phải là số nguyên");
        }



    }

    public static void showListSinger() {
        if (currentIndexSinger == 0) {
            System.err.println("List singer đang trống");
            return;
        }
        System.out.println("----------------------------------------------------------------Singer Information-------------------------------------------------------------");
        for (int i = 0; i < currentIndexSinger; i++) {
           arrSingers[i].displayData();
        }

    }

    public static void updateSinger(Scanner scanner) {
        if (currentIndexSinger == 0) {
            System.err.println("List singer đang trống");
            return;
        }else {
        System.out.println("Nhập vào Id bạn muốn update ");
        try {
            int singerId = Integer.parseInt(scanner.nextLine());
            if (findSingerById(singerId) == null) {
                System.err.println("Tên ca sỹ không tồn tại");
            } else {
                findSingerById(singerId).updateData(scanner);
            }
        }catch (Exception e){
            System.err.println("Singer Id nhập vào phải là số");
        }
    }
    }

    public static void deleteSinger(Scanner sc) {
        if (currentIndexSinger == 0) {
            System.err.println("List singer đang trống");
            return;
        }
        System.out.println("Nhập vào Id bạn muốn xóa ");
        int singerId = Integer.parseInt(sc.nextLine());
        if (findSingerById(singerId) != null) {
            for (int i = 0; i < SongService.currentIndexSong; i++) {
                if (singerId == SongService.arrSongs[i].getSinger().getSingerId()) {
                    System.err.println("Không thể xóa Singer có Song ");
                    return;
                }
            }
            int indexDelete = -1;
            for (int i = 0; i < currentIndexSinger; i++) {
                if (arrSingers[i].getSingerId() == singerId) {
                    indexDelete = i;
                    break;
                }
            }
            for(int i = indexDelete; i < currentIndexSinger; i++) {
                arrSingers[i] = arrSingers[i+1];
            }
            System.out.println("Xóa singer hoàn thành");
            currentIndexSinger--;

        } else {
            System.err.println("Singer not found");
        }

    }
}
