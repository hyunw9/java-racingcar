import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    private Names(List<Name> nameList) {
        this.names = nameList;
    }

    public static Names createNames(String nameInput){
        ArrayList<Name> nameList = new ArrayList<>(Arrays
                .stream(nameInput.split(","))
                .map(String::trim)
                .map(Name::createName)
                .collect(Collectors.toList()));
        validateNameDuplication(nameList);
        return new Names(nameList);
    }

    public void validateNameDuplication(List<Name> names) {
        Set<Name> nameSet = new HashSet<>(names);
        if (nameSet.size() > names.size()) {
            throw new IllegalArgumentException("이름이 중복됩니다.");
        }
    }

    public List<Name> getNames() {
        return names;
    }
}
