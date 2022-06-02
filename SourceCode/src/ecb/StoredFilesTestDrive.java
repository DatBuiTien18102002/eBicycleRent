/*
*  created date: May 17, 2022
*  author: cgm
*/
package ecb;
public class StoredFilesTestDrive {
    public static void main(String[] args) {
        StoredFiles storedFiles = new StoredFiles("person2.json");
        System.out.println(storedFiles.search("name", "Teo",storedFiles.getAll()));
    }
    
}
