package BulutluozDersler.day_15;

public class C00_Notlar {
     /*
           WRITE EXCEL---

        //1) Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //4) 5.hucreye yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        (EXcel'de degisiklik yapmak icin oncesinde readExcel'de yaptigimiz gibi
        fis objesi ve workbook objesi olustururuz, bunlarla degisiklik yapacagimiz sayfaya ve satira ulasiriz.
        .createCell(4) .setCellValue("Nufus"); ile desiklik yapariz.
        sonrasinda dosyayi kaydetmek icin "fos" objeisini kullaniriz workbook.write(fos) parametre olarak fos'u gireriz
        ardindan fis ve fos objesini kapatiriz)

         Ornek:        FileOutputStream fos = new FileOutputStream(dosyaYolu);
                        workbook.write(fos);

                       workbook.close();
                        fis.close();
                        fos.close();
   ---------------------------------------------------------------------------------------
   ---------------------------------------------------------------------------------------

       Ornek: workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .createCell(4)
                .setCellValue("Nufus");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
      Ornek:  workbook
                .getSheet("Sayfa1")
                .getRow(1)
                .createCell(4)
                .setCellValue("1.500.000");


        //8) 15.satir nufus kolonuna 54000 yazdiralim
     Ornek:   workbook
                .getSheet("Sayfa1")
                .getRow(14)
                .createCell(4)
                .setCellValue(54000); -- tirnaklar olmadan da kullanabiliriz boyle olur int olarak gitmis olur.


        //9) Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //10)Dosyayi kapatalim
     Ornek:   workbook.close();
        fis.close();
        fos.close();


           READ EXCEL---

      String dosyaYolu="src/resources/ulkeler.xlsx";
      FileInputStream fis=new FileInputStream(dosyaYolu);
       Workbook workbook= WorkbookFactory.create(fis);
       ardindan workbook.getSheet(__"Sayfa1__)
                workbook.getRow(__satirIndex__)
                workbook.get(__sutun/hucreIndex__).toString()



         TAM EKRAN SCREENSHOT---
        1-Takcescreenshot objesi olustruruz.


        2-File objesi olusturarak ekran goruntusunun kaydedilecegi yeri belirtiriz.

        3-Seleniu screeshot yapitiginda gecici bir yere kaydeder,
         bunun icin gecici bir File temp olustururuz ve ts.getScreenshotAs(OutputType.FILE); kodunu assign ederiz.

        4-Temp'e kaydettigimiz ekran goruntusunu su kodla:FileUtils.copyFile(geciciDosya,tumSayfaResim); istedigimiz yere almis oluruz.




            Ornek:
                         1.Madde   TakesScreenshot ts = (TakesScreenshot) driver;

                         (Selenium her screenshot'i aldiginda ayni yere kaydededer.
                           Bu sebeple bir onceki screenshot silinmis olur.
                           Bunu engellemek icin screenshot ismi asagidaki gibi olusturulabilir.)

                            LocalDateTime date=LocalDateTime.now();
                            DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyMMddHHmmss");
                            String tarih = date.format(dtf);


                          2.Madde ---  File tumSayfaResim= new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");

                          3.Madde --- File geciciDosya= ts.getScreenshotAs(OutputType.FILE);

                          4.Madde ---  FileUtils.copyFile(geciciDosya,tumSayfaResim);



         WEBELEMENT SCREENSHOT---
         Selenium 4 ile gelen guzel ozelliklerden bir tanesi de
        istedigimiz WebElement’in fotografini almamiza imkan tanimasidir.

           Screenshot almak istedigimiz webEElement'i locate edip, bu WE uzerinden:
       -->  sonucYaziElementi.getScreenshotAs(OutputType.FILE); bu sekilde alip temp'e assign ederiz.

         Sonrasinda kopyalamayi unutmamak lazim -->FileUtils.copyFile(temp,sonucYaziElementSS);


         JavaSCript EXECUTER----

         JavaSCript executer objesi ile JavaSCript methodlarini kullanabiliriz.
         JavascriptExecutor jse= (JavascriptExecutor) driver;

            Iki kodu bilmeliyiz.
              jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu); Ekrani kayirma yapar.
              jse.executeScript("arguments[0].click();",signInButonu);  Buldugu butona tiklama yapar.

     */
}
