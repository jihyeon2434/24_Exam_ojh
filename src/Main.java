import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static List<WiseSaying> wiseSayings = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lastId = 0;
		System.out.println("== 명언 앱 실행 ==");

		while (true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine();

			if (cmd.equals("등록")) {
				int id = lastId + 1;
				System.out.print("명언: ");
				String content = sc.nextLine();
				System.out.print("작가: ");
				String author = sc.nextLine();
				System.out.printf("%d번 명언이 등록되었습니다.\n",id);
				lastId++;
				
				WiseSaying wiseSaying = new WiseSaying(id,author,content);
				
				wiseSayings.add(wiseSaying);
				
			}else if(cmd.equals("목록")) {
				System.out.println("번호  / 작가  /  명언");
				System.out.println("=".repeat(25));
				
				for(int i = wiseSayings.size()-1;i>=0;i--) {
					WiseSaying ws = wiseSayings.get(i);
					System.out.printf("%d  /  %s  /  %s \n",ws.getId(),ws.getAuthor(),ws.getContent());
					
				}
				
				
				
			}else if(cmd.startsWith("삭제")) {
				String[] cmdBits = cmd.split("\\?", 2);
				
				Map<String, String> params = new HashMap<>();
				String[] paramBits = cmdBits[1].split("&");
				
				for(String paramStr:paramBits) {
					String[]paramStrBits = paramStr.split("=");
					String key = paramStrBits[0];
					String value = paramStrBits[1];
					params.put(key, value);
					
				}
				
				
				
				
			}
				

		}

	}
} class WiseSaying{
	private int id;
	private String content;
	private String author;
	// private String regDate;
	
	public WiseSaying(int id, String author, String content){
		this.setId(id);
		this.setAuthor(author);
		this.setContent(content);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
