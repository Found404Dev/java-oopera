package ru.yandex.practicum.theatre;

public class Theatre {
    public static void main(String[] args) {
        System.out.println("=== ТЕАТР НАЧИНАЕТ РАБОТУ ===\n");

        // 1. Создаём актёров
        Actor actor1 = new Actor("Иван", "Петров", Gender.MALE, 1.85);
        Actor actor2 = new Actor("Мария", "Сидорова", Gender.FEMALE, 1.68);
        Actor actor3 = new Actor("Алексей", "Иванов", Gender.MALE, 1.78);

        System.out.println("Созданы актёры:");
        System.out.println("1. " + actor1);
        System.out.println("2. " + actor2);
        System.out.println("3. " + actor3);
        System.out.println();

        // 2. Создаём режиссёров
        Director director1 = new Director("Сергей", "Смирнов", Gender.MALE, 15);
        Director director2 = new Director("Ольга", "Кузнецова", Gender.FEMALE, 8);

        System.out.println("Созданы режиссёры:");
        System.out.println("1. " + director1);
        System.out.println("2. " + director2);
        System.out.println();

        // 3. Создаём автора музыки и хореографа
        String musicAuthor = "Пётр Чайковский";
        String choreographer = "Мариус Петипа";

        System.out.println("Автор музыки: " + musicAuthor);
        System.out.println("Хореограф: " + choreographer);
        System.out.println();

        // 4. Создаём спектакли
        Show regularShow = new Show("Ревизор", 150, director1);

        Opera operaShow = new Opera(
                "Евгений Онегин",
                180,
                director1,
                musicAuthor,
                "Действие I\n" +
                        "Сад в имении Лариных. Сестры Татьяна и Ольга поют дуэт...\n" +
                        "Действие II\n" +
                        "Бал в доме Лариных. Онегин танцует с Ольгой...",
                40
        );

        Ballet balletShow = new Ballet(
                "Лебединое озеро",
                140,
                director2,
                musicAuthor,
                "Акт I\n" +
                        "Праздник в замке принца Зигфрида по случаю его совершеннолетия...\n" +
                        "Акт II\n" +
                        "Озеро в лесу. Принц встречает Одетту, королеву лебедей...",
                choreographer
        );

        System.out.println("Созданы спектакли:");
        System.out.println("1. " + regularShow.getTitle() + " (обычный)");
        System.out.println("2. " + operaShow.getTitle() + " (опера)");
        System.out.println("3. " + balletShow.getTitle() + " (балет)");
        System.out.println();

        System.out.println("=== РАСПРЕДЕЛЕНИЕ АКТЁРОВ ===");

        regularShow.addActor(actor1);
        regularShow.addActor(actor2);

        operaShow.addActor(actor2);
        operaShow.addActor(actor3);

        balletShow.addActor(actor1);
        balletShow.addActor(actor2);
        balletShow.addActor(actor3);

        System.out.println("\nПопытка добавить уже существующего актёра:");
        balletShow.addActor(actor2);
        System.out.println();

        System.out.println("=== СПИСКИ АКТЁРОВ ===");
        regularShow.printActors();
        System.out.println();
        operaShow.printActors();
        System.out.println();
        balletShow.printActors();
        System.out.println();

        System.out.println("=== ЗАМЕНА АКТЁРА ===");

        Actor actor4 = new Actor("Дмитрий", "Васильев", Gender.MALE, 1.82);
        System.out.println("Создан новый актёр: " + actor4);

        balletShow.replaceActor(actor4, "Петров"); // Заменяем Ивана Петрова

        System.out.println("\nОбновлённый список актёров в балете:");
        balletShow.printActors();
        System.out.println();

        System.out.println("=== ПОПЫТКА ЗАМЕНЫ НЕСУЩЕСТВУЮЩЕГО АКТЁРА ===");
        balletShow.replaceActor(actor4, "Несуществующий");
        System.out.println();

        System.out.println("=== ЛИБРЕТТО ===");
        System.out.println("Опера:");
        operaShow.printLibretto();

        System.out.println("Балет:");
        balletShow.printLibretto();

        System.out.println("=== ИНФОРМАЦИЯ О РЕЖИССЁРАХ ===");
        regularShow.printDirectorInfo();
        System.out.println();
        operaShow.printDirectorInfo();
        System.out.println();
        balletShow.printDirectorInfo();

        System.out.println("\n=== РАБОТА ТЕАТРА ЗАВЕРШЕНА ===");
    }
}
