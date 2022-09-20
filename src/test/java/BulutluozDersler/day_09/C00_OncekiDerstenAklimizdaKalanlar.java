package BulutluozDersler.day_09;

public class C00_OncekiDerstenAklimizdaKalanlar {


    /*      Mehmet hoca -- onceki dersten aklimizda kalanlar

1) Js: Allets: Web sitelerinde 2 tur allert wardir.
    1. HTML alerts : sağ click yapip incelenebilir. dolayısıyla diger web elementler gibidir
    2. JS Alerts : bunlar sag click yapilip incelenemez, dolayisyla da diger webElementlerden farklidir.
    Bunlarla calisabilmek icin driver.switchTo().alert() methodu ile alerte gecip, ondan sonra accept,
    dismis, sendKeys veya getText methodlarindan uygun olani kullanilir.

    Art arda bile olsa alert ile islem yapmak istedigimiz her seferde switchTo() kullanmaliyiz.

2) BasicAuthentication : Normal olarak web sitelerinde login fonksiyonu için kullanici adi ve sifre webelementlerine
bilgileri girip, login butonuna basariz.

Ancak bazı websitelerinde ve özellikle API haberleşmesinde kullanıcı adi ve sifreyi manuel olarak tek tek girmek yerine,
sevis sağlayıcının bize vereceği bilgiler doğrultusunda, kullanici adi ve sifreyi URL'e ekleyebiliriz.

Böylece sayfaya gitme ve login fonksiyonu tek adımda halledilmiş olur.

3) Bir web sayfasinin içinde ,kaynak olarak baska web sayfasinin calistigi bolum olusturmak icin HTML'DE iframe olusturulur.

Her bir iframe kendi içinde bir web sayfasi gibi HTML kodlarindan oluşur. (html,head ve body taglari gibi)

Eğer bir web Elementi dogru olarak locate etmemize ragmen, driver o web elementi bulamiyorsa,
webElement iframe içerisinde olabilir.Bu durumda HTML kodlarini incelememiz gerekir.
Eger bir wbelement iframe icerisindeyse once o iframe'e driver.switchTo().Frame(switchYöntemi) ile geçmeliyiz.

3 sekilde iframe'e yapabliriz. 1-index  2-name/id  3- webElement olarak tanımlayarak iframe alertten farklidir. switchTO() ile
iframe geçince oradan çıkıncaya kadar driver o iframe'de kalir ve bu surede asil sayfadaki webElementleri goremez.

iframe'den çıkmak icin 2 yöntem vardir.
1_ defaultContent(9 --> anasayfaya cikar.
2- parentFrame() --> bir ust frame'e cikar.(iç içe iframe olan sayfalarda kullanilabilir.)

    */



}
