package ra.model;

import java.util.Scanner;
public class Singer {
    private int singerId;
    private  String singerName;
    private  int age;
    private  String nationality;
    private Boolean gender;
    private  String genre;

    // ____________CONSTRUCTOR___________//

    public Singer() {
    }
    public Singer(int singerId, String singerName, int age, String nationality, Boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    //_______CÁC PHUONG THUC GETTER/ SETTER__________//

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //__________INPUT DATA___________//
    public void inputData(Scanner scanner, Singer[] arrSingers, int currentIndexSinger){
        this.singerId= inputSingerId( arrSingers,currentIndexSinger) ;
        this.singerName = inputSingerName(scanner);
        this.age=inputAge(scanner);
        this.nationality=inputNationality(scanner);
        this.gender= inputGender(scanner);
        this.genre = inputGenre(scanner);

    }

    public String inputGenre(Scanner scanner) {
        System.out.println("Nhập Genre");
        genre = scanner.nextLine();
        while (true) {
            if (genre.trim().isEmpty()) {
                System.err.println("Genre không được để trống, vui lòng nhập lại");

            } else {
                return genre;
            }
        }
    }

    public Boolean inputGender(Scanner scanner) {
        System.out.println("Bạn hãy nhập vào giới tính: ");
        do{
            try{
                String gender = scanner.nextLine();
                if(!(gender.equalsIgnoreCase("true")||gender.equalsIgnoreCase("false"))){
                    System.err.println("Phải nhập giới tính là true hoac false");
                }else
                    return Boolean.parseBoolean(gender);
            }catch (Exception e){
                System.err.println("Giới tính nhập phải đúng kiểu định dạng true hoac false");
            }
        }while (true);
    }


    public int inputAge(Scanner scanner) {
        System.out.println("Mời bạn nhập vào tuổi");
        do {
            try{
                int age= Integer.parseInt(scanner.nextLine());
                if (age<=0){
                    System.err.println("Tuổi nhập vào phải lớn hơn 0");
                }else {
                    return age;
                }

            }catch (Exception e){
                System.err.println("Tuổi nhập vào phải đúng định dạng là số nguyên");
            }

        }while (true);

    }

    public String inputNationality(Scanner sc) {
        System.out.println("Nhập tên quốc tịch của ca sỹ");

        while (true) {
            String nationality = sc.nextLine();
            if (nationality.trim().isEmpty()) {
                System.err.println("Tên quốc tịch không được để trống");

            } else {
                return nationality;
            }
        }
    }


    public   int inputSingerId(Singer[] arrSingers, int currentIndexSinger) {
        if (currentIndexSinger == 0) {
            return 1;
        } else {
            int maxId = arrSingers[0].getSingerId();
            for (int i = 0; i < currentIndexSinger; i++) {
                if (arrSingers[i].getSingerId() > maxId) {
                    maxId = arrSingers[i].getSingerId();
                }
            }

            return maxId + 1;
        }
    }
    public  String inputSingerName(Scanner scanner) {
        System.out.println("Nhập tên ca sỹ");;
        while (true){
            String singerName = scanner.nextLine();
            if (singerName.trim().isEmpty()) {
                System.out.println("Tên không được để trống, vui lòng nhập vào");

            } else {
                return singerName;
            }
        }
    }

    //______________UPDATE DATA___________________//
    public void updateData(Scanner scanner){

        this.singerName = inputSingerName(scanner);
        this.age = inputAge(scanner);
        this.nationality = inputNationality(scanner);
        this.gender =inputGender(scanner);
        this.genre =inputGenre(scanner);
    }

    //_______________DISPLAY DATA______________//
    public void displayData(){
        System.out.printf("ID : %3s | Name: %15s | Age: %5s | Genre %15s | Gender: %8s | Nationality: %15s \n",
                this.singerId,this.singerName,this.age,this.genre,this.gender?"Male":"Female",this.nationality);
        System.out.println("______________________________________________________________________________________________________________________________________________");
    }

}



