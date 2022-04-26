import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Notes {
    private List<String> notesList = new ArrayList<>();
    public Notes (List<String> notesList) {
        this.notesList = notesList;
    }

    public List<String> getNotesList() {
        return notesList;
    }

    public boolean isEmptyList() {
        if (getNotesList().isEmpty()) {
            System.out.println("Список пуст\n");
            return true;
        } else return false;
    }

    public void printList(String destination) {
        try (FileWriter fileWriter = new FileWriter(destination, false)) {
            int counts = 1;
            fileWriter.write(String.valueOf(LocalDate.now()));
            fileWriter.append('\n');
            for (String note : getNotesList()) {
                fileWriter.write(counts + ". ");
                fileWriter.write(note);
                fileWriter.append('\n');
                counts++;
            }
            System.out.println("Сохранено в файл " + "\"" + destination + "\"");
        } catch (IOException e) {
            System.out.println("Запись по указанному пути невозможна");
        }


    }
}
