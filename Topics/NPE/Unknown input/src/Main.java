class Util {
    // correct this method to avoid NPE
    public static void printLength(String name) {
        if(name == null){
            System.out.println(0);
        }
        System.out.println(name.length());
    }
}