package com.ssafit.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import io.swagger.annotations.Api;

// @Controller		: return 값이 뷰 페이지 이름
// @RestController 	: return 값이 데이터

@RestController
@RequestMapping("/api-chat") // 공통으로 적용되는 상위 주소를 세팅
@Api(tags = "채팅 컨트롤러") // API의 이름 설정
// @CrossOrigin("*") -> WebConfig에서 설정
// application.properties : API-key 설정 필요
public class ChatRestController {

	@Autowired
	private ChatgptService chatgptService;

	// 채팅
	@PostMapping("sendMessage")
	public String Chat(@RequestBody String message) {
		String setting = "당신은 운동 전문가로서 유저에게 운동과 추천해주는 인공지능입니다. "
				+ "유저가 특정 운동 부위를 말하면 해당 부위에 해당하는 운동을 추천해주는 메세지를 출력하면 됩니다. "
				+ "운동 부위는  가슴, 등, 어깨, 팔, 하체 등이 있으며 각 부위에 따른 대표적인 운동은 다음과 같습니다. "
				+ "가슴 운동은 벤치프레스, 인클라인 벤치프레스, 머신 벤치프레스, 푸시업, 딥스 등이 있습니다. "
				+ "등 운동은 시티드 로우, 바벨로우, 백 익스텐션, 랫 풀 다운, 풀업, 데드리프트, 로우 덤벨 등이 있습니다. "
				+ "어깨 운동은 밀리터리 프레스, 사이드 레터럴 레이즈, 밴딩 숄더 스트레칭, 프론트 레이즈, 숄더 프레스 등이 있습니다. "
				+ "하체 운동은 스쿼트, 브이스쿼트, 와이드스쿼트, 사이드 킥백, 레그프레스 등이 있습니다. " + "전신 운동은 줄넘기, 달리기, 수영, 농구, 축구, 테니스 등이 있습니다. "
				+ "추천하는 메뉴로는 닭가슴살 샐러드, 연어 포케, 치킨 샌드위치, 계란 토마토볶음, 치킨 월남쌈, 소고기 스테이크 등이 있습니다. " + "이제 다음 문장에서 원하는 부위를 말할 테니 운동을 추천해주시면 됩니다. ";
		String input = message;

		// 입력받은 문자열
		int idx1 = -1;
		int idx2 = -1;
		int cnt = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '"') {
				cnt++;

				if (cnt == 3) {
					idx1 = i;
				} else if (cnt == 4) {
					idx2 = i;
					break; // 두 번째 큰따옴표를 찾으면 반복문 종료
				}
			}
		}

		// 추출된 문자열 출력
		String extractedMessage = "";
		if (idx1 != -1 && idx2 != -1) {
			extractedMessage = input.substring(idx1 + 1, idx2);
			System.out.println(extractedMessage);
		} else {
			extractedMessage = "잘못된 입력입니다";
		}

		String responseMessage = chatgptService.sendMessage(setting + extractedMessage);
		System.out.println(responseMessage);
		return "안녕하세요! " + responseMessage + " 말씀드린 운동을 검색해 보세요!";
	}

}
