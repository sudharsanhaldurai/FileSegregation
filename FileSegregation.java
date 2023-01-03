import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {
    public static void main(String args[]) throws IOException {
        
        Scanner sc=new Scanner(System.in);
        String folderName="";
        String path="";
        String fullPath="";
        File directoryPath = new File("C:\\Users\\sudharsan\\Documents\\Files");
        FilenameFilter textFilefilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".pdf") || lowercaseName.endsWith(".txt")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        FilenameFilter audioFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".mp3")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        FilenameFilter videoFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".mp4")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        String textFilesList[] = directoryPath.list(textFilefilter);
        if(textFilesList.length>=1){
              path="C:\\Users\\sudharsan\\Documents\\Files\\";
              folderName="document";
              path = path+folderName;
            File file = new File(path);

            boolean bool = file.mkdir();

        }
        System.out.println("Documents");
        for (String fileName : textFilesList) {
            
            Path temp = Files.move
                    (Paths.get("C:\\Users\\sudharsan\\Documents\\Files\\"+fileName),
                            Paths.get(path+"\\"+fileName));


        }

        String audioFilesList[] = directoryPath.list(audioFilter);
        if(audioFilesList.length>=1){
            path="C:\\Users\\sudharsan\\Documents\\Files\\";
            folderName="audio";
            path = path+folderName;
            File file = new File(path);
            boolean bool = file.mkdir();
        }
        System.out.println("Audio:");
        for (String fileName : audioFilesList) {
            System.out.println(fileName);
        }

        String videoFilesList[] = directoryPath.list(videoFilter);
        if(videoFilesList.length>=1){
            path="C:\\Users\\sudharsan\\Documents\\Files\\";
            folderName="video";
            path = path+folderName;
            File file = new File(path);

            boolean bool = file.mkdir();

        }
        System.out.println("Video:");
        for (String fileName :videoFilesList) {
            System.out.println(fileName);
        }
    }
}
