package BulutluozDersler.day_08;

public class C05_NeOgrendik {
    /*

    ALERTS:
    * Web sitesine girdigimizde karsimiza cikan uyari pencereleri ALERT'dir.(Pop-Up)
    * Iki cesit alert vardir
        -HTML Alerts: Bir alert ciktiginda sag click ile inspect yapabiliyorsak html alert’dir ve extra bir isleme gerek yoktur.
        switchTo() method'unu kullanmaya gerek yoktur.

        -JsAlerts:
        Js alerts inspect yapilamaz, ekstra isleme ihtiyac vardir.switchTo() method'u ile islem yapilir.
        3 cesit Jaca Script Alert vardir:
            1.Simple Alert : Bu basit alert ekranda bazı bilgiler veyauyarılar
            görüntüler. Ok denilerekkapatilir
            2.Confirmation Alert : Bu onay uyarısı bir tür işlem yapma izni ister. Alert onaylaniyorsa OK,
            onaylanmiyorsa Cancel butonunabasilir.
            3.Prompt Alert : Bu Prompt Uyarısı kullanıcıdan bazı girdileringirilmesini
            ister ve selenium webdriver metni sendkeys ("input….") kullanarakgirebilir.

            driver.switchTo( ).alert( ).accept();
            driver.switchTo( ).alert( ).dismiss();
            driver.switchTo( ).alert( ).getText();
            driver.switchTo( ).alert( ).sendKeys("Text");




    Basic Authentication:
    * Kullanici adi ve sifre girip kendi  verilerimize erisilebilirlige denir.
    * Ya da bir sitenin baska bir sitenin data base'inden veriye erismesine denir.(Hava durumu,doviz)
    * End user’lar icin tasarlanmayan uygulamalarda (Ornegin API sorgularinda) bu authentication HTML komutlari ile de yapilabilir.
    * Bu authentication’i yapabilmek icin uygulamanin kullanicilara authentication’i nasil yapacaginadair
bilgilendirme yapmis olmasigerekir.
    * Ornek olarak : https://username:password@URL




    IFrame:
    * Ic ice web sayfalari ya da ic ice HTML kodlari diyebiliriz kisaca.Incele dedigimizde sayfada
    HTML kodlari icinde IFrame varsa IFrame oldugunu anlariz.

    ●Bir sayfada iframe varsa, Selenium bir iframe içindeki elementleri doğrudan göremez

    ●switchTo( ) method’u ile iframe’e gecmenin 3 yoluvardir;
        1) index ile:
        driver.switchTo( ).frame(index oftheiframe);//index 0’danbaslar
        2) id veya name value ile
        driver.switchTo( ).frame("id of the iframe");
        3 ) WebElementile
        driver.switchTo( ).frame(WebElement of the iframe);


         *Iframe’den cikmak icin 2 komut vardir
     --> driver.switchTo().parentFrame(); --> bir üst parent sayfaya cikar
     --> driver.switchTo().defaultContent(); --> en ustteki frame cikmis olursunuz.


        * Eger text box'da onceden yazilmis bir metin varsa temizlemek icin:
        WebElement textKutusu = driver.findElement(By.xpath("//*[@id = 'tinymce']"));
        textKutusu.clear();

     */
}
