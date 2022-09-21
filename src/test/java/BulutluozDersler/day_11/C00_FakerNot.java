package BulutluozDersler.day_11;

public class C00_FakerNot {
    /*

                FAKER
    Faker sahte kullanici adi, sifre email vb.. olusturmak için kullanilan bir kutuphanedir.
    Nasil JUnit kutuphanesini yuklediysek bunu da pom.xml'deki dependencies arasina yuklemek gerek.
    www.mvnrepository--> faker arat --> kod satirinmi kopyala ---> pom.xml dependencies arasina yapiştir.

    Kullanmak için obje oluşturmamız gerek.
    Faker faker=new Faker();

    faker.__kullanmakİstegimizBaslik__ ama email ve password icin --> faker.internet().emailAddress();
                                                                 ---> faker.internet().password();
               ACTIONS KULLANARAK SAYFAYI ASAGI KAYDIRMA
     2 yontem var. 1.--> sayfanın gitmek isteginmiz yerinde bir webElelemti locate ederiz.
               actions.moveToElement(webElement).perform() ve locate ettigimiz yere bu kodlarla gideriz.

                2. yontem
                --> sayfada gitmek istegimiz yere actions.sendKeys(Keys.PAGE_DOWN).perform() kodlari ile gideriz.
                PAGE_DOWN tusuna 1 defa basmak yeterli gelmiyorsa kodlari tekrar yazip istedigimiz kadar
                tusa bastırabiliriz.

        FILE EXIST
       System.out.println(System.getProperty("user.home"));
        // C:\Users\Lenovo  yani benim bilgisayarimin bana ozel kismini verdi

        System.out.println(System.getProperty("user.dir"));
        // bana icinde oldugum projenin dosy yoliunu(path) verir

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));

       -- Files.exists()---> dosyanin bilgisayarda varligini test etmek için kullanılır. içine parametre olarak
        Paths classından get() metodunu alir.
      --  Paths.get(masaustuDosyaYolu)) ---> Paths.get()'de dosyanın bulundugu yolu/konumu almak(okumak) için
        kullanılır. Paths.get() methodu içine onceden ayarladiğimiz yolu/konumu parametre olarak alir.

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));


        FILE DOWNLOAD
        - bizden dosyanin indigini Assert etmemizi isterse, Assert içerisinde
        Files.exists(Paths.get(masaustuDosyaYolu))  kodunu kullanırız.

        FILE UPLOAD
        - dosyayı upload etmek için ;
        1) Upload butonu locate edilir.
        2) Upload butonuna send.KEys() metodu ile dosya path(yolu) gonderilir.
        3) Upload butonuna tıklanır.





     */

}
