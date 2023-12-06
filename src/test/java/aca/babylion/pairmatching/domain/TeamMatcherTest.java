package aca.babylion.pairmatching.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TeamMatcherTest {

    @Test
    void 짝수_인원일_시_모든_팀은_2명으로_구성된다() {
        final List<Member> members = List.of(
                new Member("김테킷_A"),
                new Member("이멋사"),
                new Member("최백엔"),
                new Member("김테킷_B")
        );
        final TeamMatcher teamMatcher = new TeamMatcher(members);

        List<Team> teams = teamMatcher.match();

        assertThat(teams).hasSize(2);
        assertThat(teams.get(0).getMemberCount()).isEqualTo(2);
        assertThat(teams.get(1).getMemberCount()).isEqualTo(2);
    }



    @Test
    void 홀수_인원일_시_한_팀은_3명으로_구성된다() {
        final List<Member> members = List.of(
                new Member("김테킷_A"),
                new Member("이멋사"),
                new Member("최백엔"),
                new Member("김테킷_B"),
                new Member("김테킷_C")
        );
        final TeamMatcher teamMatcher = new TeamMatcher(members);

        List<Team> teams = teamMatcher.match();

        assertThat(teams).hasSize(2);
    }
}
