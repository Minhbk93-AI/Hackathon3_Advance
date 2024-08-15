package ra.service;

import ra.model.Singer;
import ra.model.Song;
import ra.service.SingerService;
import ra.service.SongService;

import java.util.Scanner;

import static ra.service.SingerService.arrSingers;
import static ra.service.SingerService.currentIndexSinger;


public class SongService {
    public static Song[] arrSongs = new Song[100];
    public static int currentIndexSong = 0;

    public static Song findSongById(String id){
        for (int i = 0; i < currentIndexSong; i++) {
            if (arrSongs[i].getSongId().equals(id)) {
                return arrSongs[i];
            }
        }
        return null;
    }


    public static void addSong(Scanner scanner){
        System.out.println("Nhập số bài hát bạn cần thêm: ");
        try {
            int number = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < number; i++) {
                System.out.println("Nhập vào Songs: " + (i + 1));
                Song song = new Song();
                song.inputData(scanner, arrSingers, arrSongs, currentIndexSong, currentIndexSinger);
                arrSongs[currentIndexSong] = song;
                currentIndexSong++;
            }
            System.out.println("Thêm " + number + " Songs đã hoàn thành");
        }catch (Exception e){
            System.err.println("Số bài hát thêm vào phải là số");
        }
    }
    public static void showListSong(){
        if(currentIndexSong == 0){
            System.err.println("List Song đang trống");
            return;
        }
        System.out.println("**************************************************************** List Songs **************************************************************");
        for(int i =0; i<currentIndexSong;i++){
            arrSongs[i].displayData();
        }

    }
    public static void updateSong(Scanner scanner){
        System.out.println("Nhập vào ID Song bạn muốn Update");
        String id = scanner.nextLine();
        if(findSongById(id) == null){
            System.err.println("Song not found");
            return;
        }
        System.out.println("*************************************************************** Song Information *********************************************************");
        findSongById(id).displayData();
        System.out.println("Nhập vào thông tin Update");
        findSongById(id).updateData(scanner);
        System.out.println("Update song successfull");

    }
    public static void deleteSong(Scanner scanner){
        while (true){
            System.out.println("Nhập vào ID Song bạn muốn xóa");
            String id = scanner.nextLine();
            int indexDelete = -1;
            for(int i = 0 ; i < currentIndexSong ; i++){
                if(arrSongs[i].getSongId().equals(id)){
                    indexDelete = i;
                    break;
                }
            }
            if(indexDelete == -1){
                System.err.println("Song not found");
            }else{
                for(int i = indexDelete ; i < currentIndexSong ; i++){
                    arrSongs[i] = arrSongs[i+1];
                }
                System.out.println("Delete song successfully");
                currentIndexSong--;
                break;
            }
        }

    }



}
