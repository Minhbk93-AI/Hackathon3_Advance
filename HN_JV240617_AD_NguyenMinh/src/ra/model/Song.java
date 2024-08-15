package ra.model;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import ra.controller.SongController;
import ra.controller.SingerController;
import ra.service.SingerService;
import ra.service.SongService;
import java.util.regex.Pattern;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    //____________CONSTRUCTOR__________//

    public Song() {
    }

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    //________________Các phương thức GETTER và SETTER__________________//

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    //_______________inputData_____________//
    public void inputData(Scanner scanner, Singer[] arrSingers, Song[] arrSongs, int currentIndexSinger, int currentIndexSong) {
        if (SingerService.currentIndexSinger == 0) {
            System.err.println("List Singer đang trống, bạn nên thêm singer");
            return;
        }
        this.songId = inputSongId(scanner);
        this.songName = inputSongName(scanner);
        System.out.println("Nhập vào mô tả bài hát");
        this.descriptions = scanner.nextLine();
        this.singer = inputSinger(scanner);
        this.songWriter = inputSongWriter(scanner);
        this.createdDate = new Date();

        this.songStatus = inputSongStatus(scanner);
    }

    private boolean inputSongStatus(Scanner scanner){
        System.out.println("Nhập trạng thái bài hát: ");
        do{
            try{
                String songStatus = scanner.nextLine();
                if(!(songStatus.equalsIgnoreCase("true")||songStatus.equalsIgnoreCase("false"))){
                    System.err.println("Phải nhập trạng thái bài hát là true hoac false");
                }else
                    return Boolean.parseBoolean(songStatus);
            }catch (Exception e){
                System.err.println("Trang thái bài hát phải là true hoac false");
            }
        }while (true);
    }

    private String inputSongWriter(Scanner scanner){
        System.out.println("Nhập vào Song Writer ");
        while (true){
            String songWriter = scanner.nextLine();
            if(songWriter.trim().isEmpty()){
                System.err.println("Song Writer đang trống, vui lòng nhâp lại");

            }else{
                return songWriter;
            }
        }
    }

    private Singer inputSinger(Scanner scanner) {
        System.out.println("Nhập vào Singer, List singer bạn có thể chọn");
        for (int i = 0; i < SingerService.currentIndexSinger; i++) {
            SingerService.arrSingers[i].displayData();
        }
        System.out.println("Nhập singer ID: ");
            int singerId = Integer.parseInt(scanner.nextLine());
            while (true) {
                if (SingerService.findSingerById(singerId) == null) {
                    System.err.println("Không thể tìm Singer với Id " + singerId);
                    System.out.println("Nhập Singer Id ");
                    singerId = Integer.parseInt(scanner.nextLine());
                } else {
                    return SingerService.findSingerById(singerId);
                }
            }

    }


   private String inputSongName(Scanner scanner) {
       System.out.println("Nhập vào tên bài hát: ");

       while (true) {
           String songName = scanner.nextLine();
           if (songName.trim().isEmpty()) {
               System.err.println("Tên bài hát không được để trống, vui lòng nhập lại");

           } else {
               return songName;
           }
       }
   }

    private String inputSongId(Scanner scanner) {
        System.out.println("Nhập Id bài hát: ");
        String songId = scanner.nextLine();
        String songIdRegex = "^S\\w{3}$";
        while (true){
            if(songId.matches(songIdRegex)){
                if(SongService.findSongById(songId) == null){
                    return songId;
                }
                else {
                    System.err.println("Id đã tồn tại, Vui lòng nhập lai");
                }
            }else{
                System.err.println("Phải có 4 ký tự và bắt đầu bằng kí tự S, không trùng lặp, vui lòng nhập lại");
            }
            System.out.println("Nhập lại ID bài hát: ");
            songId = scanner.nextLine();
        }
    }


    //________________DISPLAY DATA_____________//
    public void displayData() {
        System.out.printf("ID : %3s | Name: %15s | Descriptons: %15s | SongWriter %10s | Singer: %15s | Created: %15s | Status %6s\n",
                this.songId, this.songName, this.descriptions, this.songWriter, this.singer.getSingerName(), this.createdDate, this.songStatus ? "Active" : "inActive");
        System.out.println("____________________________________________________________________________________________________________________________________________________________________________________________________________");
    }


//________________UPDATE DATA__________________//
    public void updateData(Scanner scanner){
        this.songName = inputSongName(scanner);
        System.out.println("Nhập vào mô tả");
        this.descriptions = scanner.nextLine();
        this.singer = inputSinger(scanner);
        this.songWriter = inputSongWriter(scanner);
        this.songStatus = inputSongStatus(scanner);
    }
}

