package Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Repository<T> {

    private String filePath;

    public Repository(String filePath) {
        this.filePath = filePath;
    }

    public void add(T item) {
        List<T> itemList = readFile();
        itemList.add(item);
        writeFile(itemList);
    }

    public void remove(int id) {
        List<T> itemList = readFile();
        itemList.remove(id);
        writeFile(itemList);
    }

    public void edit(int id, T newItem) {
        List<T> itemList = readFile();
        itemList.set(id, newItem);
        writeFile(itemList);
    }

    public List<T> getAll() {
        return readFile();
    }

    public T get(int id) {
        return readFile().get(id);
    }

    public int size() {
        List<T> itemList = readFile();
        if (itemList == null)
            return 0;
        else
            return itemList.size();
    }

    public boolean isEmpty() {
        List<T> itemList = readFile();
        if (itemList == null)
            return true;
        else
            return false;
    }

    private void writeFile(List<T> itemList) {
        File temp = new File(filePath);
        if (temp.exists()) 
            temp.delete();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(itemList);
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<T> readFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));   
            List<T> itemList = (ArrayList<T>) ois.readObject();
            ois.close();
            return itemList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        } 
    }
    
}
