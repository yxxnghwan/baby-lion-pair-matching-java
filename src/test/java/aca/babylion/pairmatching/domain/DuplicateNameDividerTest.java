package aca.babylion.pairmatching.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class DuplicateNameDividerTest {

    @Test
    void 중복_이름이_들어왔을_때_이름_뒤에_알파벳을_붙여_반환한다() {
        // given
        final DuplicateNameDivider duplicateNameDivider = new DuplicateNameDivider();
        final List<String> names = List.of("김멋사", "김멋사", "김멋사", "이테킷");

        // when
        final List<String> divideNames = duplicateNameDivider.addSignatureIfDuplicateName(names);

        // then
        assertThat(divideNames).contains("김멋사_A", "김멋사_B", "김멋사_C", "이테킷");
    }
}
