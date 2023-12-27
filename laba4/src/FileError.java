import java.io.*;

public class FileError {
    public static void main(String[] args) {
        //String fromFileName = "D:/JavaPr/laba4/src/noFile.txt";
        String fromFileName = "D:/JavaPr/laba4/src/from.txt";
        String toFileName = "D:/JavaPr/laba4/src/to.txt";
        FileInputStream fromFile = null;
        FileOutputStream toFile = null;

        try {
            fromFile = new FileInputStream(fromFileName);
            toFile = new FileOutputStream(toFileName);
            //открытие исходного и целевого файла

            byte[] buffer = new byte[1024];//буфер для чтения из исходного и записи в целевой
            int bytesRead;//кол-во байт прочитанных из исходного

            while ((bytesRead = fromFile.read(buffer)) != -1) {//когда файл прочитан,read возвращает -1
                toFile.write(buffer, 0, bytesRead);//0 - начало записи из начала буфера
            }
            System.out.println("Файл успешно скопирован.");
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден.");//ошибка открытия
        } catch (IOException e) {
            System.err.println("Ошибка при копировании файла.");
        } finally {
            try{
                if (toFile != null){
                    toFile.close();
                }
            } catch (IOException e){
                System.err.println("Ошибка при закрытии файла");
            }
        }
    }
}