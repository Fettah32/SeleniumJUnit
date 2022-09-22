package day_11;

public class FileExistNot {
    /*
    
            FILE EXISTS
        indirilen dosyanin,inip inmedigini test etmek için dosyanin yoluna ihtiyacimiz vardir.
        --> Dosyanin bilgisayarda olmasi gereken konum/yer- bunu manuel test yaparken indirdigimiz dosyanin yoluna(path)bakarak bulabilirz.
        Basit cümlelerle burdan aldigimiz yoluda(path)kullanarak dosya ___konumda__ varmi diye sorariz bilgisayara.
        --> Ama bu sefer herkesin bilgisayirinin ismi farkli oldugundan dosyanin inmesi gereken yol(path)
        değişkenlik gösterir.
            --> Ornegin benim bilgisayarimda dosyanin inmesi gereken konum --->> "C:\Users\asd\Desktop\text.txt"
        --> C:\Users\asd\ --> kisminda -asd- benim bilgisayarimin ismi. o halde bu kısım her bilgisayarda değişecektir.
        Eğer değişecekse bizde bunu dinamik yapmamiz lazim. Bunun için (System.getProperty("user.home") koduyla her bilgisayarin bu
         ilk kısma ulasabiliriz. bunu bir stringe atariz. string ismi olarak farkliBolum diyebilirz.
         String farkliBolum = System.getProperty("user.home");
        -->>  yine (\Desktop\text.txt) bu kismin son kısmi herkesde ayni oldugu icin burayi normal bir string variablea atariz.
        String ortakBolum = "\Desktop\text.txt"
        --Z en son bu String yapiyi birleştirirsek her bilgisayar icin dinamik bir path elde etmis oluruz ve bunu bir stringe atariz.
            String masaUstuDosyaYolu = farkliBolum + ortakBolum;

        -------> Ardından dosyanin inip inmediğini test etmek icin;
        System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu))); --> bu kod blogunu kullaniriz. Bu kod blogu true / false doner.
       true ise inmiştir.

        */

}
