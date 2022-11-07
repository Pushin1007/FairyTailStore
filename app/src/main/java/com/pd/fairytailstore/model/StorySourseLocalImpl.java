package com.pd.fairytailstore.model;

import java.util.ArrayList;
import java.util.List;

public class StorySourseLocalImpl implements StorySourse {
    private List<FairyTail> dataSourse;


    //   @Override
//    public StorySourse init(StorySourselResponce storySourselResponce) {
//        return null;
//    }

    @Override
    public int size() {
        return dataSourse.size();
    }

    @Override
    public FairyTail getFairyTail(int position) {
        return dataSourse.get(position);
    }


    @Override
    public void clearAll() {
        dataSourse.clear();
    }

    public StorySourseLocalImpl() {
        dataSourse = new ArrayList<FairyTail>();
    }

    // public StorySourse init() {
    public StorySourse init(StorySourselResponce storySourselResponce) {
        dataSourse.add(new FairyTail("Цветик-семицветик", "Валентин Катаев", "11:00", "cvetik-semicvetik.txt"));
        dataSourse.add(new FairyTail("Рапунцель", "Братья Гримм", "6:35", "rapuncel.txt"));
        dataSourse.add(new FairyTail("12 Месяцев", "Самуил Маршак", "11:10", "12-mesjacev.txt"));
        dataSourse.add(new FairyTail("Огниво", "Ганс Христиан Андерсен", "11:10", "ognivo.txt"));
        dataSourse.add(new FairyTail("Свинопас", "Ганс Христиан Андерсен", "12:35", "svinopas.txt"));
        dataSourse.add(new FairyTail("Стойкий оловянный солдатик", "Ганс Христиан Андерсен", "7:35", "stoikii-olovjannyi-soldatik.txt"));
        dataSourse.add(new FairyTail("Госпожа Метелица", "Братья Гримм", "5:40", "gospozha-metelica.txt"));
        dataSourse.add(new FairyTail("Рике с хохолком", "Шарль Перо", "12:35", "rike-s-hoholkom.txt"));
        dataSourse.add(new FairyTail("Сивка Бурка", "Русская народная", "6:55", "sivka_burka.txt"));
        dataSourse.add(new FairyTail("Новое платье короля", "Ганс Христиан Андерсен", "7:30", "novoe-plate-korolja.txt"));
        dataSourse.add(new FairyTail("Бременские музыканты", "Братья Гримм", "5:20", "bremenskie_muzikanti.txt"));
        dataSourse.add(new FairyTail("Финист-Ясный Сокол", "Братья Гримм", "11:10", "finist-jasnyi-sokol.txt"));
        dataSourse.add(new FairyTail("Кот в сапогах", "Шарль Перо", "6:30", "kot_v_sapogah.txt"));
        dataSourse.add(new FairyTail("Синяя борода", "Шарль Перо", "7:00", "sinjaja-boroda.txt"));
        dataSourse.add(new FairyTail("Спящая красавица", "Шарль Перо", "6:25", "spashaya_krasavitsa.txt"));
        dataSourse.add(new FairyTail("Стоптанные туфельки", "Братья Гримм", "7:50", "stoptanie_tufelki.txt"));
        dataSourse.add(new FairyTail("Золушка", "Шарль Перо", "8:35", "zolushka.txt"));
        dataSourse.add(new FairyTail("Василиса Прекрасная", "Русская народная", "13:40", "vasilisa_prekrasnya.txt"));
        dataSourse.add(new FairyTail("Летучий корабль", "Русская народная", "14:25", "letuchii-korabl.txt"));
        dataSourse.add(new FairyTail("Белоснежка и 7 гномов", "Братья Гримм", "14:50", "belosnezka_i_7_gnomov.txt"));
        dataSourse.add(new FairyTail("Гадкий Утенок", "Ганс Христиан Андерсен", "16:55", "gadkiy_utenok.txt"));
        dataSourse.add(new FairyTail("По щучьему велению", "Русская народная", "9:05", "po-shuchemu-velenyu.txt"));
        dataSourse.add(new FairyTail("Серая шейка", "Дмитрий Мамин-Сибиряк", "16:40", "seraja-sheika.txt"));
        dataSourse.add(new FairyTail("Хозяйка медной горы", "Павел Бажов", "17:15", "hozyayka-mednoy-gory.txt"));
        dataSourse.add(new FairyTail("Храбрый портняжка", "Братья Гримм", "9:55", "hrabryi-portnjazhka.txt"));
        dataSourse.add(new FairyTail("Иван крестьянский сын и чудо-юдо", "Русская народная", "15:20", "ivan_krestiaskiy_sin_i_chudo_udo.txt"));
        dataSourse.add(new FairyTail("Ослиная шкура", "Шарль Перо", "15:40", "oslinaja-shkura.txt"));
        dataSourse.add(new FairyTail("Царевна лягушка", "Русская народная", "10:35", "tsarevna_liagushka.txt"));
        dataSourse.add(new FairyTail("Мальчик с пальчик", "Шарль Перо", "7:30", "malchik_s_palchik.txt"));
        dataSourse.add(new FairyTail("Морской царь и Василиса Премудрая", "Русская народная", "13:25", "morskoy-car-i-vasilisa-premudraya.txt"));
        dataSourse.add(new FairyTail("Серебрянное копытце", "Павел Бажов", "12:45", "serebryanoe-kopytce.txt"));
        dataSourse.add(new FairyTail("Сундук-Самолет", "Ганс Христиан Андерсен", "10:30", "sunduk-samolet.txt"));
        dataSourse.add(new FairyTail("Волшебное яблочко", "Русская народная", "14:10", "volshebnoe-jablochko.txt"));
        dataSourse.add(new FairyTail("Живая вода", "Братья Гримм", "12:30", "zhivaya-voda.txt"));
        dataSourse.add(new FairyTail("Золотой гусь", "Братья Гримм", "8:35", "zolotoy-gus.txt"));
        dataSourse.add(new FairyTail("Лягушка-путешественница", "Русская народная", "8:20", "lyagushka-puteshestvennica.txt"));
        if (storySourselResponce != null) {
            storySourselResponce.initialized(this);
        }
        return this;
    }


}
