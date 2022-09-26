package day_13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookies extends TestBaseBeforeAfter {

    /*

    1-Amazon anasayfaya gidin
    2-tum cookie'leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie'nin sayfaya eklendigini test edin
    7-ismi skin olan cookie'yi silin ve silindigini test edin
    8-tum cookie'leri silin ve silindigini test edin

 */

    @Test
    public void test01() {

        // 1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //    2-tum cookie'leri listeleyin
        Set<Cookie> tumCookieList = driver.manage().getCookies();
        System.out.println(tumCookieList);

        int sayac = 0;
        for (Cookie w:tumCookieList
             ) {
            System.out.println(sayac + ".ci cookie : " + w );
            System.out.println(sayac + ".ci cookie : " + w.getName());
            System.out.println(sayac + ".ci cookie : " + w.getValue());
            sayac++;
        }

        //    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookiesSayisi = tumCookieList.size();
        Assert.assertTrue(cookiesSayisi > 5);

        //    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:tumCookieList
             ) {
            if (w.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", w.getValue());
            }
        }


        //    5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);
        tumCookieList = driver.manage().getCookies();
        sayac = 1;
        for (Cookie w:tumCookieList
             ) {
            System.out.println(sayac + ".ci cookie : " + w );
            System.out.println(sayac + ".ci cookie : " + w.getName());
            System.out.println(sayac + ".ci cookie : " + w.getValue());
            sayac++;
        }


        //    6-eklediginiz cookie'nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookieList.contains(yeniCookie));

        //    7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(tumCookieList.contains("skin"));



        //    8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookieList = driver.manage().getCookies();
        Assert.assertTrue(tumCookieList.isEmpty());

    }

}
