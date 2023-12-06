package aca.babylion.pairmatching.domain.dto;

import java.util.List;
import java.util.Set;

public class ExtractDuplicateNameResult {

    private final List<String> duplicateNames;
    private final Set<String> distinctNames;

    public ExtractDuplicateNameResult(final List<String> duplicateNames, final Set<String> distinctNames) {
        this.duplicateNames = duplicateNames;
        this.distinctNames = distinctNames;
    }

    public List<String> getDuplicateNames() {
        return duplicateNames;
    }

    public Set<String> getDistinctNames() {
        return distinctNames;
    }
}
