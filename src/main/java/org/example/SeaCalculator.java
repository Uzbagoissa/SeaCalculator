package org.example;

import java.awt.event.*;

public class SeaCalculator implements ActionListener {
    private final MainFrame mainFrame;
    double shipspeed;                                                                   //скорость судна в узлах
    double shipcourse;                                                                  //курс судна в градусах
    double windspeed;                                                                   //скорость ветра с альтиметра в м/с
    double winddirection;                                                               //направление ветра с альтиметра в градусах
    double windspeedtrue;                                                               //истинная скорость ветра в м/с
    double winddirectiontrue;                                                           //истинное направление ветра в градусах
    int balls;                                                                          //сила ветра в баллах, шкала Бофорта

    public SeaCalculator(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("Расчитать")) {
            try {
                calculation();
            } catch (NumberFormatException ex) {
                clearAllFields();
            }
        }
        if (command.equals("Reset")) {
            clearAllFields();
        }
    }

    private void calculation() throws NumberFormatException {
        if (Double.parseDouble(mainFrame.numbers1.getText()) > 100){
            mainFrame.numbers1.setText("Число должно быть меньше 100");
            return;
        } else {
            shipspeed = Double.parseDouble(mainFrame.numbers1.getText());
        }

        if (Double.parseDouble(mainFrame.numbers2.getText()) > 359){
            mainFrame.numbers2.setText("Число должно быть меньше 359");
            return;
        } else {
            shipcourse = Double.parseDouble(mainFrame.numbers2.getText());
        }

        if (Double.parseDouble(mainFrame.numbers3.getText()) > 150){
            mainFrame.numbers3.setText("Число должно быть меньше 150");
            return;
        } else {
            windspeed = Double.parseDouble(mainFrame.numbers3.getText());
        }

        if (Double.parseDouble(mainFrame.numbers4.getText()) > 359){
            mainFrame.numbers4.setText("Число должно быть меньше 359");
            return;
        } else {
            winddirection = Double.parseDouble(mainFrame.numbers4.getText());
        }

        windspeedtrue = (Math.sqrt(shipspeed * shipspeed + windspeed * windspeed //расчет истинной скорости ветра в м/с
                - 2 * shipspeed * windspeed * Math.cos(Math.toRadians(winddirection)))) * 0.514;
        mainFrame.got3.setText(" " + (int) windspeedtrue + " м/с");

        winddirectiontrue = Math.toDegrees(Math.asin((shipspeed         //расчет истинного направления ветра в градусах
                * Math.sin(Math.toRadians(winddirection))) / windspeedtrue)) + shipcourse + winddirection;

        if (winddirectiontrue > 360) {
            winddirectiontrue = winddirectiontrue - 360;
        }
        if (winddirectiontrue < 0) {
            winddirectiontrue = 360 + winddirectiontrue;
        }

        if (winddirectiontrue >= 348.75 & winddirectiontrue < 11.25) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " N");
        }
        if (winddirectiontrue >= 11.25 & winddirectiontrue < 33.75) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " NNE");
        }
        if (winddirectiontrue >= 33.75 & winddirectiontrue < 56.25) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " NE");
        }
        if (winddirectiontrue >= 56.25 & winddirectiontrue < 78.75) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " ENE");
        }
        if (winddirectiontrue >= 78.75 & winddirectiontrue < 101.25) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " E");
        }
        if (winddirectiontrue >= 101.25 & winddirectiontrue < 123.75) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " ESE");
        }
        if (winddirectiontrue >= 123.75 & winddirectiontrue < 146.25) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " SE");
        }
        if (winddirectiontrue >= 146.25 & winddirectiontrue < 168.75) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " SSE");
        }
        if (winddirectiontrue >= 168.75 & winddirectiontrue < 191.25) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " S");
        }
        if (winddirectiontrue >= 191.25 & winddirectiontrue < 213.75) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " SSW");
        }
        if (winddirectiontrue >= 213.75 & winddirectiontrue < 236.25) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " SW");
        }
        if (winddirectiontrue >= 236.25 & winddirectiontrue < 258.75) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " WSW");
        }
        if (winddirectiontrue >= 258.75 & winddirectiontrue < 281.25) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " W");
        }
        if (winddirectiontrue >= 281.25 & winddirectiontrue < 303.75) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " WNW");
        }
        if (winddirectiontrue >= 303.75 & winddirectiontrue < 326.25) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " NW");
        }
        if (winddirectiontrue >= 326.25 & winddirectiontrue < 348.75) {
            mainFrame.got3_1.setText((int) winddirectiontrue + " NNW");
        }

        if (windspeedtrue < 0.3) {
            balls = 0;
            mainFrame.got4.setText(balls + " баллов" + " По Шкале Бофорта" + "\n" +
                    "Штиль" + "\n" + "Волна 0м" + "\n" + "Море - Зеркальная гладь");
        }
        if (windspeedtrue >= 0.3 & windspeedtrue < 1.5) {
            balls = 1;
            mainFrame.got4.setText(balls + " балл" + " По Шкале Бофорта" + "\n" + "Тихий ветерок" + "\n" + "Волна <0.1м" +
                    "\n" + "Море - Рябь, пены на гребнях нет");
        }
        if (windspeedtrue >= 1.5 & windspeedtrue < 3.3) {
            balls = 2;
            mainFrame.got4.setText(balls + " баллa" + " По Шкале Бофорта" + "\n" + "Легкий бриз" + "\n" + "Волна <0.3м" +
                    "\n" + "Море - Короткие волны. Гребни не опрокидываются" + " и кажутся стекловидными");
        }
        if (windspeedtrue >= 3.3 & windspeedtrue < 5.4) {
            balls = 3;
            mainFrame.got4.setText(balls + " баллa" + " По Шкале Бофорта" + "\n" + "Слабый бриз" + "\n" + "Волна <0.6м" +
                    "\n" + "Море - Короткие, хорошо выраженные волны. Гребни, "
                    + "опрокидываясь, образуют стекловидную пену. " + "Редкие маленькие барашки");
        }
        if (windspeedtrue >= 5.4 & windspeedtrue < 7.9) {
            balls = 4;
            mainFrame.got4.setText(balls + " балла" + " По Шкале Бофорта" + "\n" + "Умеренный бриз" + "\n" + "Волна <1.5м" +
                    "\n" + "Море - Волны удлиненные, барашки во многих местах");
        }
        if (windspeedtrue >= 7.9 & windspeedtrue < 10.7) {
            balls = 5;
            mainFrame.got4.setText(balls + " баллов" + " По Шкале Бофорта" + "\n" + "Свежий бриз" + "\n" + "Волна <2м" +
                    "\n" + "Море - Хорошо развитые в длину, но не крупные волны. "
                    + "Везде барашки. В отдельных случаях образуются брызги");
        }
        if (windspeedtrue >= 10.7 & windspeedtrue < 13.8) {
            balls = 6;
            mainFrame.got4.setText(balls + " баллов" + " По Шкале Бофорта" + "\n" + "Сильный ветер" + "\n" + "Волна <3м" +
                    "\n" + "Море - Появляются крупные волны. " + "Белые пенистые гребни занимают значительные площади. "
                    + "Вероятны брызги");
        }
        if (windspeedtrue >= 13.8 & windspeedtrue < 17.1) {
            balls = 7;
            mainFrame.got4.setText(balls + " баллов" + " По Шкале Бофорта" + "\n" + "Крепкий ветер" + "\n" +
                    "Волна <5.5м, ср.4.7м" + "\n" + "Море - Волны громоздятся, гребни волн срываются. "
                    + "Пена ложится полосами по ветру");
        }
        if (windspeedtrue >= 17.1 & windspeedtrue < 20.7) {
            balls = 8;
            mainFrame.got4.setText(balls + " баллов" + " По Шкале Бофорта" + "\n" + "Очень крепкий ветер (Буря)" + "\n" +
                    "Волна <7.5м, ср.5.5м" + "\n" + "Море - Умеренно высокие длинные волны. "
                    + "По краям гребней начинают взлетать брызги. " + "Полосы пены - рядами по направлению ветра");
        }
        if (windspeedtrue >= 20.7 & windspeedtrue < 24.4) {
            balls = 9;
            mainFrame.got4.setText(balls + " баллов" + " По Шкале Бофорта" + "\n" + "Шторм (Сильная буря)" + "\n" +
                    "Волна <10м, ср.7.7м" + "\n" + "Море - Высокие волны. "
                    + "Пена широкими плотными полосами ложится по ветру. "
                    + "Гребни волн начинают опрокидываться, рассыпаясь в брызги " + "и ухудшая видимость");
        }
        if (windspeedtrue >= 24.4 & windspeedtrue < 28.4) {
            balls = 10;
            mainFrame.got4.setText(balls + " баллов" + " По Шкале Бофорта" + "\n" + "Сильный шторм (Полная буря)" +
                    "\n" + "Волна <12м, ср.9м" + "\n" + "Море - Очень высокие волны с длинными загибающимися "
                    + "вниз гребнями. Пена выдувается большими хлопьями в виде "
                    + "густых белых полос. Поверхность моря бела от пены. "
                    + "Сильный грохот волн сродни ударам молота Тора!");
        }
        if (windspeedtrue >= 28.4 & windspeedtrue < 32.6) {
            balls = 11;
            mainFrame.got4.setText(balls + " баллов" + " По Шкале Бофорта" + "\n" +
                    "Жестокий шторм (Жестокая - Кровавая б..ть! буря)" + "\n" +
                    "Волна <16м, ср.11.5м" + "\n" + "Море - Видимость плохая. "
                    + "Исключительно высокие волны. Небольшие и средние суда тонут "
                    + "нахер (шутка) временами скрываются из вида. Все море покрыто "
                    + "длинными белыми хлопьями пены, располагающимися по ветру. " + "Края волн всюду сдуваются в пену");
        }
        if (windspeedtrue >= 32.6) {
            balls = 12;
            mainFrame.got4.setText(balls + " баллов" + " По Шкале Бофорта" + "\n" + "Ураган (Тайфун) Жопа короч" + "\n" +
                    "Волна >16м" + "\n" + "Море - Исключительно плохая видимость. "
                    + "Воздух наполнен пеной и брызгами. Все море покрыто полосами " + "пены. Всех сдувает в ад...");
        }
    }

    private void clearAllFields() {
        mainFrame.numbers1.setText(" ");
        mainFrame.numbers2.setText(" ");
        mainFrame.numbers3.setText(" ");
        mainFrame.numbers4.setText(" ");
        mainFrame.got3.setText(" ");
        mainFrame.got3_1.setText(" ");
        mainFrame.got4.setText(" ");
    }
}
