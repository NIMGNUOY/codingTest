package codingTest.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final Service service;
	
	@RequestMapping("/")
	public String mainPage() {
		
		return "index";
	}
	
	@GetMapping("test1")
	public String test1() {
		
		return "test1";
	}
	
	@GetMapping("test2")
	public String test2() {
		
		return "test2";
	}
	
	@GetMapping("test3")
	public String test3() {
		
		return "test3";
	}
	
	@GetMapping("test4")
	public String test4(Model model) {
		
		List<Organization> orgList = service.selectOrgList();
		
		model.addAttribute("orgList", orgList);
		
		return "test4";
	}
	
	@GetMapping("test5")
	public String test5() {
		
		return "test5";
	}
	
	@GetMapping("test6")
	public String test6() {
		
		return "test6";
	}
	
	@GetMapping("test66")
	@ResponseBody
	public int[][] test66() {
		
		int size = 5;
		int[][] square = new int[size][size];
		Random random = new Random();
		
		int row = random.nextInt(size);
		int col = random.nextInt(size);
		
		System.out.println("row : " + row);
		System.out.println("col : " + col);
		
		for(int num = 1; num <= size * size; num ++) {
			square[row][col] = num;
			
			int nextRow = (row - 1 + size) % size;
			int nextCol = (col - 1 + size) % size;
			
			if(square[nextRow][nextCol] != 0) {
				row = (row + 1) % size; 
			} else {
				row = nextRow;
				col = nextCol;
			}
			
		}
		
		System.out.println(size * size);
		System.out.println("생성된 마방진:");
		for (int i = 0; i < square.length; i++) {
		    for (int j = 0; j < square[i].length; j++) {
		        System.out.print(square[i][j] + " ");
		    }
		    System.out.println();
		}
		
		return square;
	}
	
	@GetMapping("test7")
	public String test7() {
		
		return "test7";
	}
	
	@PostMapping("/rpsGame")
	@ResponseBody
	public Map<String, Object> rpsGame(Model model,
										@RequestParam("playerChoice") String playerChoice) {
		
		Map<String, Object> map = new HashMap<>();
		
		int score = 0;
		int attempts = 0;
		int draws = 0;
		int strikes = 0;
		int outs = 0;
		final int maxOuts = 3;
		
		String[] rpsOptions = {"scissors", "rock", "paper"};
		Random random = new Random();
		
		String computerChoice = rpsOptions[random.nextInt(3)];
		
		System.out.println("player choice : " + playerChoice);
		System.out.println("computer choice : " + computerChoice);
		
		int result = getResult(playerChoice, computerChoice);
		
		if(result == 0) {
			draws++;
			map.put("message", "무승부! 다시 선택해주세요.");
		} else if (result == 1) {
			score++;
			attempts++;
			strikes = 0;
			map.put("message", "승리! 1루 출루");
		} else {
			strikes++;
			attempts++;
			if(strikes == 2) {
				outs++;
				strikes = 0;
				if(outs >= maxOuts) {
					map.put("message", "3아웃! 게임 종료");
				} else {
					map.put("message", "아웃! 현재 아웃 : " + outs);
				}
			} else {
				map.put("message", "스트라이크! 다음 게임");
			}
		}
		
		System.out.println(map.get("message"));
		
		map.put("playerChoice", playerChoice);
		map.put("computerChoice", computerChoice);
		map.put("score", score);
		map.put("attempts", attempts);
		map.put("draws", draws);
		map.put("strikes", strikes);
		map.put("outs", outs);
		
		System.out.println(map);
		
		return map;
	}

	private int getResult(String player, String computer) {
		
		if(player.equals(computer)) {
			return 0;
		} else if ((player.equals("scissors") && computer.equals("paper")) ||
					player.equals("rock") && computer.equals("scissors") ||
					player.equals("paper") && computer.equals("rock")) {
			return 1;
		} else {
			return -1;
		}
	}
}
