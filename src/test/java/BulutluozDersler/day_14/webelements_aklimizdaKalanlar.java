package BulutluozDersler.day_14;

public class webelements_aklimizdaKalanlar {

    /*
    1.Web tables: HTML'de bazı elementleri organize bir sekilde,tablo biciminde kullanmak tercih edilebilir.

    2. Genel HTML kodlari acisindan tablo elementleri taglerle belirlenmiştir.
    - <table>
    - <header>
    - <tr>  - <th> satirlari
    -<td> satirdaki cell numarasini veriri. (bunu stutun diye adlandirabilirz ama kodlarda sutun yoktur.)
    -<tbody> tablo body'si
    - <tr>  satirlari
    -<td>satirdaki cell numarasini veriri. (bunu stutun diye adlandirabilirz ama kodlarda sutun yoktur.)

    3- WebElementleri absolute xpathe benzer sekilde locate edebiliriz. ancak yaptigimiz tam olarak xpath degildir.
    Biz tablodaki webElementlerin tag'larına odaklanırız.

    4- mesela tablo body'sinde 3 satırın 5. cell'ine ulaşmak istersek.
    //tbody//tr[3]//td[5]

            baslıktaki ilk satirdaki tum satırlar. //thead//tr[1]
            tablo body'sinde 4. sutundaki tum datalar. //tbody//td[4]
    5- eger verilen satır ve sutun numarasina gore dinamik bir locate yapmak istersek
            "//tbody//tr["+satır + "]//td["sutun + "]"

     */
}
