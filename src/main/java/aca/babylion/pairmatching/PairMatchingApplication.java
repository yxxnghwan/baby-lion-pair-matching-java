package aca.babylion.pairmatching;

import aca.babylion.pairmatching.domain.DuplicateNameDivider;
import aca.babylion.pairmatching.domain.Member;
import aca.babylion.pairmatching.domain.Team;
import aca.babylion.pairmatching.domain.TeamMatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PairMatchingApplication {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("참가할 훈련생은 몇 명인가요?");
        final int memberCount = Integer.parseInt(scanner.nextLine());
        System.out.println("");

        System.out.println("참가할 훈련생의 이름을 입력하세요.");
        final List<String> memberNames = new ArrayList<>();
        for (int i = 0; i < memberCount; i++) {
            final String name = scanner.nextLine().trim();
            memberNames.add(name);
        }
        final DuplicateNameDivider duplicateNameDivider = new DuplicateNameDivider();
        final List<String> newNames = duplicateNameDivider.addSignatureIfDuplicateName(memberNames);
        final List<Member> members = newNames.stream()
                .map(Member::new)
                .toList();
        final TeamMatcher teamMatcher = new TeamMatcher(members);
        final List<Team> teams = teamMatcher.match();

        System.out.println("짝꿍 매칭 결과입니다.");
        for (int i = 0; i < teams.size(); i++) {
            final Team team = teams.get(i);
            final String memberNameString = team.getMembers().stream()
                    .map(Member::getName)
                    .collect(Collectors.joining(","));
            System.out.println((i + 1) + "팀 - " + memberNameString);
        }
    }
}
