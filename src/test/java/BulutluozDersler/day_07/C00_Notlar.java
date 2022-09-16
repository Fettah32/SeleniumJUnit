package BulutluozDersler.day_07;

public class C00_Notlar {

    /*
    ASSERT-->
        1-If-Else yerine Assert methodlarini kullaniriz.Bu bir nevi ileri seviye if else
         statement'dır.
        2-Assert'in kullanim amaci beklentimizin onaylanmasidir.Ne bekledigimiz onemlidir.
        3-Assert Method'lari sunlardir:
                Assert.assertTrue();--->Beklentimiz dogru sonuc ise
                    -Assert.assertTrue(logoElementi.isDisplayed());

                Assert.assertFalse()--->Beklentimiz yanlis sonuc ise
                   - Assert.assertFalse(actualTitle.contains(expectedTitle));
                   - Assert.assertFalse(logoElementi.isDisplayed());

                Assert.assertEquals(expectedResult, actualResult)--->Beklentimiz birebir esitse
                Assert.assertNotEquals(expectedResult, actualResult)--->Beklentimiz birbirine esit degilse

                , testi calistirdiktan sonra aldigimiz sonuc beklenen sonuctan farkliysa exeption firlatir.
                Assert.assertTrue("hata aldigimizda konsolda yazacak uyari metni", expectedResult, actualResult);

                 Assertion fail olursa kendi icinde bulundugu testin kalan kismini calistirmaz.




    Dropdown
    Tiklayinca asagi dogru acilan menuler dropdown'dur.
    Her menu dropdwon degildir.
    Dropdwon menulerin html tag'i her zaman select'dir.
    Dropdown menude islem yapabilmek icin adimlar sunlardir.
      dropdown'dan books secenegini secip
      dropdown'dan bir option secmek icin 3 adim vardir
        1-dropdown'i locate edelim
        WebElement dropdownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        2-bir select objesi olusturup
        parametre olarak bir onceki adimda locate ettigimiz ddm'yu girelim
        Select select=new Select(dropdownMenu);

        3- Dropdown'da var olan option'lardan istedigimiz bir taneyi secelim
                bu da 3 tanedir
               1- select.selectByVisibleText();  gorunur isimle seciyor
               2- select.selectByIndex(5); indexle seciyor
               3- select.selectByValue("search-alias=stripbooks-intl-ship"); value ile seciyor

       Dropdown'i tiklayip actigimiz yer index olarak 0 kabul edilir.

        istenirse getOptions(); methodu kullanilarak
        DropDown'daki tum elementler webelementlerden olusan
        bir listeye konabilir. List<WebElement>

        Dropdown'dan ilk option'u secmek ve yazdirmak icin asagidaki kodu kullaniriz.
        System.out.println(select.getFirstSelectedOption().getText());


 */


}
