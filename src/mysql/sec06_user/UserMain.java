//package mysql.sec06_user;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class UserMain {
//	private static UserService userService = new UserServiceMySQLImpl();
//	// ==> @Autowired private static MessageService messageService;
//	private static Scanner scan = new Scanner(System.in);
//
//	public static void main(String[] args) {
//		List<User> list = null;
//		String writer = null, content = null;
//		User user = null;
//		int mid = 0;
//		boolean run = true;
//		
//		while (run) {
//			System.out.println("+================+===============+===============+===============+=========+========+");
//			System.out.println("| 1. 페이지 목록 | 2.사용자 등록 | 3.사용자 수정 | 4.사용자 삭제 | 5.로그인| 6.종료 |");
//			System.out.println("+================+===============+===============+===============+=========+========+");
//			System.out.print("선택> ");
//			
//			int selectNo = Integer.parseInt(scan.nextLine());
//			switch(selectNo) {
//			case 1:
//				list = messageService.getMessageListAll();
//				list.forEach(x -> System.out.println(x));
//				System.out.println();
//				break;
//			case 2:
//				System.out.println("---------------");
//				System.out.println(" Writer별 목록");
//				System.out.println("---------------");
//				System.out.print("Writer 이름> ");
//				writer = scan.nextLine();
//				list = messageService.getMessageListByWriter(writer);
//				list.forEach(x -> System.out.println(x));
//				System.out.println();
//				break;
//			case 3:
//				System.out.println("---------------");
//				System.out.println("  메세지 쓰기");
//				System.out.println("---------------");
//				System.out.print("Writer 이름> ");
//				writer = scan.nextLine();
//				System.out.print("메세지 내용> ");
//				content = scan.nextLine();
//				message = new Message(content, writer);
//				messageService.insertMessage(message);
//				break;
//			case 4:
//				System.out.println("---------------");
//				System.out.println("  메세지 수정");
//				System.out.println("---------------");
//				System.out.print("메세지 ID> ");
//				mid = Integer.parseInt(scan.nextLine());
//				message = messageService.findByMid(mid);
//				System.out.print("Writer 이름(" + message.getWriter() + ")> ");
//				writer = scan.nextLine();
//				System.out.print("메세지 내용(" + message.getContent() + ")> ");
//				content = scan.nextLine();
//				message.setWriter(writer);
//				message.setContent(content);
//				messageService.updateMessage(message);
//				break;
//			case 5:
//				System.out.println("---------------");
//				System.out.println("  메세지 삭제");
//				System.out.println("---------------");
//				System.out.print("메세지 ID> ");
//				mid = Integer.parseInt(scan.nextLine());
//				messageService.deleteMessage(mid);
//				break;
//			case 6:
//				run = false; 
//				break;
//			default:
//				System.out.println("Warning: 1 ~ 6 사이의 숫자만 입력하세요.");
//			}
//		}
//		System.out.println("프로그램 종료");
//		messageService.close();
//		scan.close();
//	}
//}