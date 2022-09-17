package BulutluozDersler.day_08;

public class C00_DunNeGorduk {
    /*
    1- Assertion : Selenium'da test edin denilen durumlari Selenium Assert Class'indan hazir method'larla yapariz.
            * Java'dan kalan if-else ile de test yapilabilir ama JUnit ve sinra kullanacagimiz TstNG framework'leri
            Assert'e gore dizayn edilmistir.
            * Assertion'da oncelikle testimizde bizden istenenin ne oldugunu incelemeliyiz;
                - eger bizden istenen iki degerin esitliginin test edilmesi ise assert.Equals
                - eger sonucun olumlu olmasi (true) bekleniyorsa assertTrue
                - eger sonucun olumsuz olmasi (false) bekleniyorsa assertFalse
            * Assertion'da test FAILED olunca Selenium kodun kalan satirlarini calistirmaz.
            * If-else kullandigimizda test istenen sonucu yazdirir,
            testin calismasi durmaz ve testin sonunda kodlar normal calisp bittigi icin test PASSED der.



      2- DropDown Menu: acilir menu;
            * Dropdown bir webelement'den birden fazla option kullanabilmemizi saglar.
            * Dropdown ile Select tag'i birbirinin ayrilmaz parcasidir.
            * Bir HTML tag'i select tag'i kullaniyorsa cok buyuk bir ihtimal ile dropdown'dir.
            * Dropdown'da asil amac, webelement'i locate etmek degil, dropdown'dan istedigimiz
            option'i secebilmektir.
            * Secme islemi 3 adimda yapilir:
                1- Dropdown webelement'ini locate ederiz,
                2- Select class'indan bir obje olusturup, parametre olarak dropdown webElement'ini yazariz
                3- Dropdown'dan option secmek icin 3 secenekten birini kullaniriz:
                    - selectByIndex
                    - selectByVisibleText
                    - selectByValue
     */
}
