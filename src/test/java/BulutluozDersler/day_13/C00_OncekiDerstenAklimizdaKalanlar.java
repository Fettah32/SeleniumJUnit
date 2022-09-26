package BulutluozDersler.day_13;

public class C00_OncekiDerstenAklimizdaKalanlar {
    /*
    1-  Selenium waits,(senkronizasyon) : KOdlarimizla, internet ve bilgisayarin calismasini uyuml hale
    getirmek icin bazen kodlarimizi bekletmemiz gerekir.

    2- Selenium'da 3 cesit wait vardir:
        1. Thread.sleep(): Java'dan gelir ve kodlari durdurur. Kendisine verilen surenin tamamini bekler.
        Dinamik degil statiktir.
        2. implicitlyWait(): Selenium'dan gelir. Sayfanin yuklenmesini ve her bir webelement'in locate
        edilmesi icin beklenecek max sureyi belirler. Esnektir. Esas olan beklemek degil, kodun calismasini
        saglamaktir. Kod calisirsa beklemeden devam, kod calismazsa max.sure doluncaya kadar bekler ve
        sonra hata mesaji verir(Exception).
    3- ExplicitlyWait : Selenium'dan gelir, sepesifik bir islem icin beklenecek max. sureyi belirler.
        ExplicitlyWait kullanabilmek icin wait objesi olusturmamiz gerekir.
        wait.until(ExpectedConditions...Istedigimiz fonk.) seklinde kullanilir.
           Genellikle wait.until() metodu locate ile birlikte kullanılır.

         FluentWait()-- belirli araliklarla geldi mi diye kontrol eder.
     */
}
