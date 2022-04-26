import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //В качетстве инструмента для хранения заметок будем использовать ArrayList
        Notes notes = new Notes(new ArrayList<>());
        notes.getNotesList().add("Тестовая заметка"); //Данная заметка будет добавлена сразу после запуска программы
        Scanner scanner = new Scanner(System.in);
        int count = 1; //Количество добавленных заметок
        String input = null;
        while (true) {
            try {
                System.out.println("\nВыберите действие: \n" + "1. Добавить заметку\n" + "2. Вывести список заметок\n" +
                        "3. " + "Удалить заметку из списка\n" + "4. Изменить заметку\n" + "5. Сохранить заметки в файл\n"
                        + "0. Выход\n");
                input = scanner.nextLine();
                int choose = Integer.parseInt(input);
                if (choose < 0 || choose > 5) {
                    System.out.println("Необходимо ввести действие (число от 0 до 5), повторите попытку");
                    continue;
                }
                if (choose == 0) {
                    System.out.println("Завершение программы");
                    scanner.close();
                    break;
                }
                switch (choose) {
                    case 1: //Добавление заметки
                        System.out.println("Введите порядковый номер будущей заметки: ");
                        input = scanner.nextLine();
                        choose = Integer.parseInt(input);
                        if (choose <= 0 || (notes.getNotesList().size() + 1) < choose) {
                            System.out.println("Порядковый номер заметки не может быть меньше 1, либо больше "
                                    + (count + 1));
                            break;
                        }
                        System.out.println("Введите текст заметки: ");
                        String task = scanner.nextLine();
                        notes.getNotesList().add((choose - 1), task);
                        count++;
                        break;
                    case 2: //Вывод на экран списка заметок
                        if (notes.isEmptyList()) {
                            break;
                        }
                        System.out.println("Список заметок: ");
                        for (int i = 0; i < notes.getNotesList().size(); i++) {
                            System.out.println((i + 1) + ". " + notes.getNotesList().get(i));
                        }
                        break;
                    case 3: //Удаление заметки
                        if (notes.isEmptyList()) {
                            break;
                        }
                        System.out.println("Введите номер заметки из списка для её удаления:");
                        input = scanner.nextLine();
                        choose = Integer.parseInt(input);
                        if (choose > notes.getNotesList().size() || choose <= 0) {
                            System.out.println("Неверный ввод, количество заметок в вашем списке " + count);
                            break;
                        }
                        System.out.println("Заметка № " + choose + " \"" + notes.getNotesList().get(choose - 1)
                                + "\" удалена из " + "списка");
                        notes.getNotesList().remove(choose - 1);
                        count--;
                        break;
                    case 4: //Изменение заметки
                        if (notes.isEmptyList()) {
                            break;
                        }
                        System.out.println("Введите порядковый номер заметки, которую хотите изменить: ");
                        input = scanner.nextLine();
                        choose = Integer.parseInt(input);
                        if (choose <= 0 || notes.getNotesList().size() < choose) {
                            System.out.println("Порядковый номер изменяемой заметки не может быть меньше 1, либо " +
                                    "больше " + count);
                            break;
                        }
                        System.out.println("Введите новую заметку: ");
                        task = scanner.nextLine();
                        notes.getNotesList().set((choose - 1), task);
                        break;
                    case 5: //Сохранение добавленных заметок в файл
                        if (notes.isEmptyList()) {
                            break;
                        }
                        System.out.print("Укажите путь, куда хотите сохранить ваши заметки, " +
                                "напимер: С:\\ProgramFiles\\Notes.txt: ");
                        String destination = scanner.nextLine();
                        notes.printList(destination);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка!!! Необходимо ввести ЦЕЛОЕ ПОЛОЖИТЕЛЬНОЕ ЧИСЛО, а вы ввели \"" + input +
                        "\"");
            }
        }
    }
}
