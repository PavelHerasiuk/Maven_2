public class Main{
    public static void main(String [] args){
        java.io.File file = new java.io.File("D:\\test.txt"); // создаем объект на файл test.txt
        if(file.exists()){ // если файл существует, то переименовываем его
            file.renameTo(new java.io.File("D:\\main.java"));
        }
        else{
            System.out.println("File not found!");
        }
    }
}
