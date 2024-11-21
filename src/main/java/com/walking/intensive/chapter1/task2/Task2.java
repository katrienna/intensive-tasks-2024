package com.walking.intensive.chapter1.task2;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {
        System.out.println(getFlatLocation(4, 3, 28));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        if ((floorAmount <= 0 || floorAmount > 163) || (entranceAmount <= 0 || entranceAmount > 156) || flatNumber <= 0)
            return "Некорректные входные данные";

        int totalQuantityOfFlats = floorAmount * entranceAmount * 4;
        if (flatNumber > totalQuantityOfFlats)
            return "Такой квартиры не существует";

        int flatsInEntrance = floorAmount * 4; // кол-во квартир в 1 подъезде
        int entranceNumber = ((flatNumber - 1) / flatsInEntrance) + 1; // номер подъезда
        int floor = 1 + (flatNumber - 1) % flatsInEntrance / 4; // этаж
        int flatNumberOnFloor = (flatNumber - (flatsInEntrance * (entranceNumber - 1))) % 4; // расположение квартиры

        return switch (flatNumberOnFloor) {
            case 1 ->
                    String.format("%d кв - %d подъезд, %d этаж, слева от лифта, влево", flatNumber, entranceNumber, floor);
            case 2 ->
                    String.format("%d кв - %d подъезд, %d этаж, слева от лифта, вправо", flatNumber, entranceNumber, floor);
            case 3 ->
                    String.format("%d кв - %d подъезд, %d этаж, справа от лифта, влево", flatNumber, entranceNumber, floor);
            case 0 ->
                    String.format("%d кв - %d подъезд, %d этаж, справа от лифта, вправо", flatNumber, entranceNumber, floor);
            default -> null;
        };
    }
}

