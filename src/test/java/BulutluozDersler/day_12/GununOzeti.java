package BulutluozDersler.day_12;

public class GununOzeti {
    /*
        Senkronize etmekten kasıt bilgisayar, internet sayfasinın hızını kodlarimizda eş zamanli çalışmasini sağlamaktir.
    Bunun için 3 tane bekletme yolu vardir.

    1-- Thread.sleep ---> Java tabanli wait. seleniumda yoktur. javadan kullaniriz.

    2-- implicitly wait ---> Selenium tabanli. site içerisinde elementlerin yüklenmesini beklemek için kullanilir.
    Bu kod sayfa acilmadiysa verilen sure kadar bekler ve sayfa içerisinde çalışırken karşılaştığı yüklenmemis elementleri de
    yüklenene kadar verilen süre kadar bekler.
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    3-- Explicitly wait --> Özellikle bekletmek istediğimiz elementlerin öncesinde ayarladığımız suredir.
    amaç bu element oncesi yüklenene kadar şu kadar süre vey şu şart gerçekleşene kadar bekledir.
    örneğin; dosya indirilene kdar bekle, veya dosyanin inmesini 15 sn bekle gibi...
       --> her element yada işlem için oncesinde yapilir.
       oluşturmak için wait objesi yapariz. --> WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
       --> wait.until() yazarak parantez içine ExpectedConditions + nokta basarak uygun şartı belirtmemiz gerekir.
       --> koşulların parantez içine --wait.until(ExpectedConditions.elementToBeClickable(enableKutusu);--
       webelement gibi şeyler yazmak gerekebilir.
        wait.until(ExpectedConditions.alertIsPresent());
        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("locate adresi"));
        wait.until(ExpectedConditions.refreshed();

                Cookies
                2 çeşittir.
                1) oturum çerezi -  bizim ip gibi bilgilerimizi serverda tutup bir daha bize soru sormuyor.
                Oturum çerezleri yalnızca bir web sitesinde gezinirken kullanılır.
                Bunlar rastgele erişimli bellekte saklanır ve hiçbir zaman sabit sürücüye yazılmaz.
                Oturum sona erdiğinde oturum çerezleri otomatik olarak silinir.

                2) kalıcı çerezler - Kalıcı çerezler bir bilgisayarda sonsuza kadar kalır
                ancak birçoğunun bir son kullanma tarihi olup bu tarihe gelindiğinde otomatik olarak kaldırılırlar.

                *** Üçüncü taraf çerezler daha sıkıntılıdır. Bunlar, genellikle kullanıcıların halihazırda
                gezindiği web sayfalarındaki reklamlarla bağlantılı olduklarından bu sayfalardan farklı
                web siteleri tarafındanoluşturulur.
     */
}
