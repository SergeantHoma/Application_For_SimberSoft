package GetName;

public class GetNameFile {
    public static String GetNameFileMethod(String name) {
        return name.substring(name.lastIndexOf("/") + 1);
    }
}
