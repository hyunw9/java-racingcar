public class Name{

    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    private Name(String name){
        this.name = name;
    }

    public static Name createName(String name){
        validateNameLength(name);
        return new Name(name);
    }

    public static void validateNameLength(String name){
        if(name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("이름 길이가 5를 초과합니다.");
        }
    }
    @Override
    public String toString(){
        return this.name;
    }

}