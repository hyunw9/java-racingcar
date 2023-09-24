import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(String nameLine) {
        this.names = new ArrayList<>(Arrays.stream(nameLine.split(","))
                .map(String::trim)
                .map(Name::createName)
                .collect(Collectors.toList()));
        validateNameDuplication(names);
    }

    public static Names createNames(String nameLine){
        return new Names(nameLine);
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
