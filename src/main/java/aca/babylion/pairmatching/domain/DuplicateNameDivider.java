package aca.babylion.pairmatching.domain;

import aca.babylion.pairmatching.domain.dto.ExtractDuplicateNameResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateNameDivider {

    private static final List<String> signatures = List.of(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"
    );
    public static final String NAME_SIGNATURE_DELIMITER = "_";

    public List<String> addSignatureIfDuplicateName(final List<String> names) {
        final ExtractDuplicateNameResult result = extractDuplicateName(names);
        final List<String> duplicateNames = result.getDuplicateNames();
        final Set<String> distinctNames = result.getDistinctNames();

        // 김멋사 3개, 이테킷 2개, 최백엔 1개
        final Map<String, List<String>> newNamesByPureName = distinctNames.stream()
                .collect(Collectors.toMap(Function.identity(), name -> filterNameEquals(names, name)));

        return newNamesByPureName.values().stream()
                .flatMap(it -> addSignatureForDuplicateNames(it).stream())
                .collect(Collectors.toList());
    }

    private List<String> addSignatureForDuplicateNames(final List<String> names) {
        if (names.size() == 1) {
            return names;
        }

        final List<String> newNames = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            final String name = names.get(i);
            newNames.add(name + NAME_SIGNATURE_DELIMITER + signatures.get(i));
        }
        return newNames;
    }

    private List<String> filterNameEquals(final List<String> duplicateNames, final String name) {
        return duplicateNames.stream()
                .filter(it -> it.equals(name))
                .collect(Collectors.toList());
    }

    private ExtractDuplicateNameResult extractDuplicateName(final List<String> names) {
        final Set<String> duplicateNames = new HashSet<>();
        final Set<String> distinctNames = new HashSet<>();

        for (String name : names) {
            divideDuplicateAndDistinct(duplicateNames, distinctNames, name);
        }

        return new ExtractDuplicateNameResult(
                names.stream()
                        .filter(duplicateNames::contains)
                        .collect(Collectors.toList()),
                distinctNames
        );
    }

    private void divideDuplicateAndDistinct(
            final Set<String> duplicateNames,
            final Set<String> distinctNames,
            final String name
    ) {
        if (distinctNames.contains(name)) {
            duplicateNames.add(name);
            return;
        }
        distinctNames.add(name);
    }
}
