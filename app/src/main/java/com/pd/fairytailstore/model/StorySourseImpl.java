package com.pd.fairytailstore.model;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class StorySourseImpl implements StorySourse {
    private List<FaireTail> dataSourse;


    @Override
    public int size() {
        return dataSourse.size();
    }

    @Override
    public FaireTail getFairyTail(int position) {
        return dataSourse.get(position);
    }


    @Override
    public void clearAll() {
        dataSourse.clear();
    }

    public StorySourseImpl() {
        dataSourse = new ArrayList<FaireTail>();
    }

    public StorySourseImpl init() {
        dataSourse.add(new FaireTail("Цветик-семицветик", "Валентин Катаев", "11:00", "cvetik-semicvetik.txt"));
        dataSourse.add(new FaireTail("Рапунцель", "Братья Гримм", "6:35", "rapuncel.txt"));
        dataSourse.add(new FaireTail("12 Месяцев", "Самуил Маршак", "11:10", "12-mesjacev.txt"));
        dataSourse.add(new FaireTail("Огниво", "Ганс Христиан Андерсен", "11:10", "ognivo.txt"));
        dataSourse.add(new FaireTail("Свинопас", "Ганс Христиан Андерсен", "12:35", "svinopas.txt"));
        dataSourse.add(new FaireTail("Стойкий оловянный солдатик", "Ганс Христиан Андерсен", "7:35", "stoikii-olovjannyi-soldatik.txt"));
        dataSourse.add(new FaireTail("Госпожа Метелица", "Братья Гримм", "5:40", "gospozha-metelica.txt"));
        dataSourse.add(new FaireTail("Рике с хохолком", "Шарль Перо", "12:35", "rike-s-hoholkom.txt"));
        dataSourse.add(new FaireTail("Сивка Бурка", "Русская народная", "6:55", "sivka_burka.txt"));
        dataSourse.add(new FaireTail("Новое платье короля", "Ганс Христиан Андерсен", "7:30", "novoe-plate-korolja.txt"));
        dataSourse.add(new FaireTail("Бременские музыканты", "Братья Гримм", "5:20", "bremenskie_muzikanti.txt"));
        dataSourse.add(new FaireTail("Финист-Ясный Сокол", "Братья Гримм", "11:10", "finist-jasnyi-sokol.txt"));
        dataSourse.add(new FaireTail("Кот в сапогах", "Шарль Перо", "6:30", "kot_v_sapogah.txt"));
        dataSourse.add(new FaireTail("Синяя борода", "Шарль Перо", "7:00", "sinjaja-boroda.txt"));
        dataSourse.add(new FaireTail("Спящая красавица", "Шарль Перо", "6:25", "spashaya_krasavitsa.txt"));
        dataSourse.add(new FaireTail("Стоптанные туфельки", "Братья Гримм", "7:50", "stoptanie_tufelki.txt"));
        dataSourse.add(new FaireTail("Золушка", "Шарль Перо", "8:35", "zolushka.txt"));
        dataSourse.add(new FaireTail("Василиса Прекрасная", "Русская народная", "13:40", "vasilisa_prekrasnya.txt"));
        dataSourse.add(new FaireTail("Летучий корабль", "Русская народная", "14:25", "letuchii-korabl.txt"));
        dataSourse.add(new FaireTail("Белоснежка и 7 гномов", "Братья Гримм", "14:50", "belosnezka_i_7_gnomov.txt"));
        dataSourse.add(new FaireTail("Гадкий Утенок", "Ганс Христиан Андерсен", "16:55", "gadkiy_utenok.txt"));
        dataSourse.add(new FaireTail("По щучьему велению", "Русская народная", "9:05", "po-shuchemu-velenyu.txt"));
        dataSourse.add(new FaireTail("Серая шейка", "Дмитрий Мамин-Сибиряк", "16:40", "seraja-sheika.txt"));
        dataSourse.add(new FaireTail("Хозяйка медной горы", "Павел Бажов", "17:15", "hozyayka-mednoy-gory.txt"));
        dataSourse.add(new FaireTail("Храбрый портняжка", "Братья Гримм", "9:55", "hrabryi-portnjazhka.txt"));
        dataSourse.add(new FaireTail("Иван крестьянский сын и чудо-юдо", "Русская народная", "15:20", "ivan_krestiaskiy_sin_i_chudo_udo.txt"));
        dataSourse.add(new FaireTail("Ослиная шкура", "Шарль Перо", "15:40", "oslinaja-shkura.txt"));
        dataSourse.add(new FaireTail("Царевна лягушка", "Русская народная", "10:35", "tsarevna_liagushka.txt"));
        dataSourse.add(new FaireTail("Мальчик с пальчик", "Шарль Перо", "7:30", "malchik_s_palchik.txt"));
        dataSourse.add(new FaireTail("Морской царь и Василиса Премудрая", "Русская народная", "13:25", "morskoy-car-i-vasilisa-premudraya.txt"));
        dataSourse.add(new FaireTail("Серебрянное копытце", "Павел Бажов", "12:45", "serebryanoe-kopytce.txt"));
        dataSourse.add(new FaireTail("Сундук-Самолет", "Ганс Христиан Андерсен", "10:30", "sunduk-samolet.txt"));
        dataSourse.add(new FaireTail("Волшебное яблочко", "Русская народная", "14:10", "volshebnoe-jablochko.txt"));
        dataSourse.add(new FaireTail("Живая вода", "Братья Гримм", "12:30", "zhivaya-voda.txt"));
        dataSourse.add(new FaireTail("Золотой гусь", "Братья Гримм", "8:35", "zolotoy-gus.txt"));
        dataSourse.add(new FaireTail("Лягушка-путешественница", "Русская народная", "8:20", "lyagushka-puteshestvennica.txt"));
        return this;
    }


}
