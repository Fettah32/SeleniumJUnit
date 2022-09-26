package BulutluozDersler.day_14;

public class ReadExcel_Notlar {
     /*
         1) Seleniumda excel kullanımı
            Seleniumda exce kullanmak için Java'nın input output ozelliğini kullanmalıyız. Yani
           --  FileInputStream kullanırız. FileInputStream objesi oluşturmak için bize excelin pathi gerek.
          FileInputStream fis= new FileInputStream(dosyaYolu);

           -- dosya yoluna erişmek için kullanmak istedigimiz excel dosyasini src'nin içinde bir resource
           klasoru oluşturarak içine excelimizi atariz ve ordan sağ click (Path from Content Root)
            ile pathi aliriz. Aldigimiz excelinYolunu String bir değişkene atariz.
            String dosyaYolu="src/resources/ulkeler.xlsx";

            -- excel üzerinde işlem yapabilmek için bize, selenium excelin bir kopyası üzerinde çalışma imkanı tanır.
            Bu sanal kopyayi kullanmak için bir obje oluşturmalıyız. Oluşturduğumuz bu obje üzerinden excel içindeki
            sayfa, satir ve hucre yapisina ulşabiliriz.
                Workbook workbook= WorkbookFactory.create(fis);

             -- Excelde Sayfaya ulaşmak içinde ayri bir obje oluşturabiliriz. Kısayol olarak bunlari cağrmak için workbook uzerinden
              .getSheet("Sayfa1").getRow(satirIndex).getCell(sutunIndex).toString(); kodlariyla yapabiliriz.

                Sheet sheet= workbook.getSheet("Sayfa1"); --  sayfa objesi olusturma

            -- Excelde satıra ulaşmak için ayri bir obje olusturabilirz. ve bu obje uzerinden istedigimiz satırı cağırabilirz.
               Row row= sheet.getRow(3);

            -- Excelde hucreye ulaşmak için ayri bir obje olusturabilirz. ve bu obje uzerinden istedigimiz hucreyi cağırabilirz.
                        Cell cell=row.getCell(3);





         2) .getPhysicalNumberOfRows();  /   .getLastRowNum(); farkı

            .getPhysicalNumberOfRows(); --> bize exceldeki tabloda  içinde veri olan satırları döndürür.
            aralardaki boş satırlari ve hucreleri değerlendirmeye almaz.

             .getLastRowNum(); --> bize exceldeki tabloda var olan en son satır sayisini döndürür.
             ama excel index kullandıgı için gözle gördügümüz satır sayisindan 1 eksik döner.
             aralardaki boş satırlari ve hucreleri değerlendirmeye alır.

         3) ------ excel verilerini saklamak için kullandığımız yapi Map'e atamak-----
            excel verilerini islemek için en iyi konteynır Maptir
            cunku key, value ozelliginden dolayı bulmasi ve islemesi kolaydır.

             Excel sayfasindaki tablodan ilk satırı key olarak değerlendirmeye alabiliriz.
             bu ilk satıra ulasmak icin -->
             String key= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

             Excel sayfasindaki tablodan ilk satır haricindeki verileri / sutunlari value olarak değerlendirmeye alabiliriz.
            String value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();


            Oluşturdugumuz bu key ve value değerlerini bir for loop içinde kullanarak map'e atariz. for-loop yapmak
            için exceldeki sayfada tablonun son satirina da ihtiyac duyariz. Örnegin;


            Workbook workbook= WorkbookFactory.create(fis);
        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatirIndex ; i++) {
            // key i. satirdaki 0 indexindeki data olacak
            String key= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            // value ise i. satirdaki 1,2 ve 3. indexdeki datalarin birlesimi olacak
            String value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
            System.out.println(key+ " , " + value);
        }

        System.out.println(ulkelerMap);


     */
}
