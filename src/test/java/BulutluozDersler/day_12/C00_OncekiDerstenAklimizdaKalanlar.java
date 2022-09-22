package BulutluozDersler.day_12;

public class C00_OncekiDerstenAklimizdaKalanlar {
    /*
    1-) File : Selenium Webdriver uzerinden calistigi icin bizim bilgisayarimizdaki dosyalar ile ilgili test
    yapamaz. Ancak bazi testlerimizi calistirirken bilgisayarimizda bir dosyanun var olup olmadigini kontrol
    etmemiz, bir dosyayi okumamiz veya indirdigimiz bir dosyanin indirilip indirilmedigini kontrol etmemiz
    gerekir.
            - Bu durumda Java imdadimiza yetisir.
            - Ancak Java'nin bilgisayarimizdaki osyalara erismek icin dosya yoluna (path) ihtiyaci vardir.
            - Her bilgisayarin ismi ve user ismi birbirinden farkli olacagindan, eger sabit bir dosya yolu
    yazarsak, bir bilgisayarda calisan test otekinde calismaz. Bunun icin dosya yolunun dinamik olmasi tercih edilir.
            -Dosya yolunu dinamik yapmak icin, herkesin bilgisayarinda farkli olan kisim ve herkesin
    bilgisayarinda ayni olan kisimlari concate etmemiz gerekir.
            - herkeste farkli olan = System.getProperty("user.home")    C:\\Users\\90545
            - herkeste ayni olan = \\Dekstop\\dosyaAdi.dosyaUzantisi
    2-) dosyanin bilgisayarimizda oldugunu test etmek icin
            Files.exist(Paths.get(dosyaYolu))
    3-) dosya upload : bilgisayarimizdaki klasorleri mouse ile acamayacagimiz icin, dosya sec butonunu locate edip
    button.sendKeys(dosyaYolu) diyerek dosyayi secip, sonra file upload butonuna basiyoruz.
     */
}
