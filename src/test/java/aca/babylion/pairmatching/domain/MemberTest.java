package aca.babylion.pairmatching.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    void 훈련생_생성() {
        // given
        final String memberName = "테스트";

        // when
        final Member member = new Member(memberName);

        // then
        assertThat(member.getName()).isEqualTo("테스트");
    }

    @Test
    void 훈련생의_이름은_1글자이상_20자_이내여야_한다() {
        // given
        final String memberName1 = "테";
        final String memberName2 = "테스트테스트테스트테스트테스트테스트테스";

        // when & then
        assertDoesNotThrow(() -> new Member(memberName1));
        assertDoesNotThrow(() -> new Member(memberName2));
    }

    @Test
    void 훈련생의_이름은_1글자보다_적으면_예외가_발생한다() {
        // given
        final String memberName = "";

        // when & then
        assertThatThrownBy(() -> new Member(memberName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 훈련생의_이름은_20자가_넘으면_예외가_발생한다() {
        // given
        final String memberName = "테스트테스트테스트테스트테스트테스트테스트";

        // when & then
        assertThatThrownBy(() -> new Member(memberName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
