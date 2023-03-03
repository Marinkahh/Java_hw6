package Seminar6.hw;


import java.util.*;

public class Main {
    public static List<PC> filteredNoteBooks;
    public static void main(String[] args) {
        filteredNoteBooks = GetNotebooks();
        System.out.println("Привет! я помогу выбрать тебе ноутбук!");
        System.out.println("Выбери критерий для фильтра");
        Menu();
    }

    public static List<PC> GetNotebooks() {
        List<PC> itemList = new ArrayList<>();
        itemList.add(new PC("PC 01", 16, 256, 10, "gray"));
        itemList.add(new PC("PC 02", 16, 256, 10, "black"));
        itemList.add(new PC("PC 03", 16, 256, 11, "black"));
        itemList.add(new PC("PC 04", 16, 256, 11, "gray"));
        itemList.add(new PC("PC 05", 32, 256, 10, "black"));
        itemList.add(new PC("PC 06", 32, 256, 10, "gray"));
        itemList.add(new PC("PC 07", 32, 256, 11, "black"));
        itemList.add(new PC("PC 08", 32, 256, 11, "gray"));
        itemList.add(new PC("PC 09", 32, 512, 10, "black"));
        itemList.add(new PC("PC 10", 32, 512, 10, "gray"));
        itemList.add(new PC("PC 11", 32, 512, 11, "black"));
        itemList.add(new PC("PC 12", 32, 512, 11, "gray"));
        itemList.add(new PC("PC 13", 16, 512, 10, "black"));
        itemList.add(new PC("PC 14", 16, 512, 10, "gray"));
        itemList.add(new PC("PC 15", 16, 512, 11, "black"));
        itemList.add(new PC("PC 16", 16, 512, 11, "gray"));
        return itemList;
    }

    public static void Menu() {
        Map<Integer, String> filters = new HashMap<>();
        filters.put(1, "RAM");
        filters.put(2, "HDD");
        filters.put(3, "OS");
        filters.put(4, "Показать результат");
        filters.put(5, "Сбросить фильтр");
        for(var filter : filters.entrySet())
            System.out.println(filter.getKey() + " - " + filter.getValue());

        Do();
    }

    public static void Do() {
        Scanner scanner = new Scanner(System.in);
        var k = scanner.nextInt();

        switch (k)
        {
            case 1: {
                System.out.println("Выбери минимальное значение ОЗУ");
                var x = scanner.nextInt();
                filteredNoteBooks = filteredNoteBooks.stream().filter(f -> f.ram >= x).toList();
            } break;
            case 2: {
                System.out.println("Выбери минимальное значение HDD");
                var x = scanner.nextInt();
                filteredNoteBooks = filteredNoteBooks.stream().filter(f -> f.hdd >= x).toList();
            } break;
            case 3: {
                System.out.println("Выбери минимальную версию Windows");
                var x = scanner.nextInt();
                filteredNoteBooks = filteredNoteBooks.stream().filter(f -> f.os >= x).toList();
            } break;
            case 4: {
                System.out.println("Отфильтрованный список ноутбуков:");
                if (filteredNoteBooks.size() == 0) {
                    System.out.println("Список пуст!");
                } else {
                    for (var notebook : filteredNoteBooks)
                        System.out.println(notebook.name + ", " + notebook.ram + ", " + notebook.hdd
                                + ", Windows " + notebook.os + ", " + notebook.color);
                }
            } break;
            case 5: {
                filteredNoteBooks = GetNotebooks();
                System.out.println("Фильтр сброшен");
            } break;
            default: {
                System.out.println("Выбран некоректный пункт меню");
            }
        }

        Menu();
    }
}
