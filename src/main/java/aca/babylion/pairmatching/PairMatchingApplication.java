package aca.babylion.pairmatching;

import java.util.*;

public class PairMatchingApplication {


    // 중복검사하고 동명이인 처리할 맵

    public static void main(String[] args) {
        // 1) 어플리케이션이 시작하면 콘솔창에서 다음 메시지와 함께 참가할 훈련생의 수를 입력받는다.**
        Scanner scanner = new Scanner(System.in);
        List<String> studentlist = new ArrayList<>(); //훈련생 이름을 저장할 리스트
        Map<String, Integer> nameMap = new HashMap<>(); // key값인 Integer는 중복 불가

        //  (1) 어플리케이션이 시작하면 콘솔창에서 다음 메시지와 함께 참가할 훈련생의 수를 입력받는다.
        System.out.println("참가할 훈련생은 몇 명인가요?");
        int memberCount = scanner.nextInt(); // 참가할 훈련생의 수를 입력 받음
        scanner.nextLine(); // 빈줄을 skip

        //  (2) 다음 메시지와 함께 한 라인에 한명씩 훈련생의 이름을 입력받는다
        System.out.println("참가할 훈련생의 이름을 입력하세요.");
        for (int i = 0; i < memberCount; i++) {
            String name = scanner.nextLine().trim();//공백제거 trim()사용
            if(name.length() < 1 || name.length() > 20){
                System.out.println("이름은 공백을 제외하고 1~20자 이내여야 합니다. 다시 입력해주세요.");
                i--;
                continue;
            }else {
                studentlist.add(name);
            }
            if(nameMap.containsKey(name)){//특정 키값이 Map에 존재하는지 확인
                int count = nameMap.get(name); //name에 해당하는 값을 가져와 count에 저장
                nameMap.put(name,count+1);// name에 해당하는 값을 1증가시키고 저장 (map은 key 값 중복 x)
                studentlist.add(name+"_"+(char)('A'+count)); // 아스키코드를 이용해 name 뒤에 A+count에 해당하는 알파벳을 붙여 출력함
            }else {
                nameMap.put(name,1);
                studentlist.add(name);
            }
        }


        System.out.println("짝궁 매칭 결과입니다.");
        Collections.shuffle(studentlist);  //모든 짝꿍은 랜덤으로 매치한다.

        // 기본으로 짝꿍은 2명으로 구성되나,
        // 전체 인원이 홀수일 경우 한 팀은 3명으로 구성된다.
        int teamNumber =1;
        for (int i = 0; i < studentlist.size(); i++) {

        }

    }
}